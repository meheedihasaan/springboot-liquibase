package com.mehedi.springbootliquibase.controllers;

import com.mehedi.springbootliquibase.entities.Department;
import com.mehedi.springbootliquibase.models.requests.CreateDepartmentRequest;
import com.mehedi.springbootliquibase.services.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<Page<Department>> getAll(Pageable pageable) {
        return ResponseEntity.ok(departmentService.getAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Department> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(departmentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody CreateDepartmentRequest request) {
        UUID id = departmentService.create(request);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri()).build();
    }

    @GetMapping(value = "/perform")
    public ResponseEntity<Void> perform() {
        departmentService.perform();
        return ResponseEntity.ok().build();
    }
}
