package com.mehedi.springbootliquibase.models.requests;

import com.mehedi.springbootliquibase.enums.Gender;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class CreateStudentRequest {
    private String name;
    private String email;
    private String studentId;
    private Gender gender;
    private UUID departmentId;
}
