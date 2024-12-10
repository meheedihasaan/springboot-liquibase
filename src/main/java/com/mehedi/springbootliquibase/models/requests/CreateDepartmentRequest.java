package com.mehedi.springbootliquibase.models.requests;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateDepartmentRequest {
    private String name;
    private String description;
}
