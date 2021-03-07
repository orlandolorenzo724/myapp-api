package com.app.api.request;

import org.springframework.stereotype.Component;

import com.app.api.entity.enumeration.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {
	private String firstName;
	private String lastName;
	 @JsonFormat(pattern = "yyyy/MM/dd")
	private String dateOfBirth;
	private String email;
	private String password;
	private UserRole userRole;
}
