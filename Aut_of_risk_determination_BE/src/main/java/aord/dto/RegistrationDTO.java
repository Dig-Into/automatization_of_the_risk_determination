package aord.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import aord.api.annotations.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationDTO {
	@Email
	@NotBlank(message = "Please provide e-mail address")
	private String email;

	@NotBlank(message = "Please provide password")
	@Size(min = 8, message = "Password must be at least 8 characters long.")
	private String password;
}
