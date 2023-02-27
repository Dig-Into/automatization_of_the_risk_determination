package com.aord.aord.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.aord.aord.api.annotations.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class RegistrationDTO {
    @Email
    @NotBlank(message = "Please provide e-mail address")
    private String email;

    @NotBlank(message = "Please provide password")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    private String password;

}