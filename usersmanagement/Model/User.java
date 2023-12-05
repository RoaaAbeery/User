package com.example.usersmanagement.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should not be empty")
    @Size(min = 4,message = "name length must be more than 4")
    @Column(columnDefinition = "varchar(10) not null")
    private String name;
    @NotEmpty(message = "username should not be empty")
    @Size(min = 4,message = "username length must be more than 4")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String username;
    @NotEmpty(message = "password should not be empty")
    @Column(columnDefinition = "varchar(9) not null")
    private String password;
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Enter valid Email")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;
    @NotEmpty(message = "role should not be empty")
    @Pattern(regexp = "^(user|admin)$",message = "role must be user or admin")
    @Column(columnDefinition = "varchar(6) not null Check (role='user' or role='admin') ")
    private String role;
    @NotNull(message = "age should not be empty")
    @Positive(message = "age must be positive number")
    @Column(columnDefinition = "int not null")
    private Integer age;
}
