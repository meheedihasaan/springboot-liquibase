package com.mehedi.springbootliquibase.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mehedi.springbootliquibase.audits.Audit;
import com.mehedi.springbootliquibase.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "students")
public class Student extends Audit {

    private String name;

    private String email;

    private String studentId;

    private Gender gender;

    @JsonIgnore
    @ManyToOne
    private Department department;
}
