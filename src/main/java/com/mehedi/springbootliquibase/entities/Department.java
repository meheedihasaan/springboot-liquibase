package com.mehedi.springbootliquibase.entities;

import com.mehedi.springbootliquibase.audits.Audit;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "departments")
public class Department extends Audit {

    private String name;

    private String description;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();
}
