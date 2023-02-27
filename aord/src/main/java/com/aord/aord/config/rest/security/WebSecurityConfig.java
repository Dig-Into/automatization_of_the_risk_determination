package com.aord.aord.config.rest.security;

import java.util.List;

import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.aord.aord.security.AuthorizationFilter;
import com.aord.aord.service.JWTService;
import com.aord.aord.service.UserService;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final int STRENGTH = 10;

    private final JWTService jwtService;
    private final UserService userService;

    @Autowired
    WebSecurityConfig(JWTService jwtService, @Lazy UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(STRENGTH);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        Filter filter = new AuthorizationFilter(jwtService, userService)
        http.cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .addFilterAt(
                        new AuthorizationFilter(jwtService, userService), BasicAuthenticationFilter.class)
                .addFilter()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/swagger**", "/webjars/**", "/swagger-resources/**", "/v2/api-docs")
                .antMatchers("/csrf")
                .antMatchers("/")
                .antMatchers("/ws/**")
                .antMatchers("/error")
                .antMatchers(
                        HttpMethod.POST,
                        "/user/login");

    }

    @Bean
    CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addExposedHeader("Authorization");
        config.addExposedHeader("Set-Cookie");
        config.setAllowCredentials(true);
        config.setAllowedOrigins(List.of("http://localhost:4200", "http://localhost:8080"));
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");


        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Bean
    HttpFirewall httpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedDoubleSlash(true);
        return firewall;
    }
}