package com.daniel.TodoList.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class SignUpRequest {
    @NotBlank(message = "Username cannot be blank")
    private String username;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Wrong email format")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6,message = "Password length must be greater than 5")
    private String password;

    private Set<String> roles = new HashSet<>();


}
