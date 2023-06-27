package com.example.validation.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @NotEmpty
    private Integer userId;
    @NotEmpty
    private String userName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private String dateOfBirth;

    @Email(regexp = "[A-Za-z]+[0-9]+@[a-z]+\\.com")
    private String email;

    @Length(max = 12,min = 10)
    private String phoneNumber;
    @NotNull
    private Date date;
    @NotNull
    private Time time;

}
