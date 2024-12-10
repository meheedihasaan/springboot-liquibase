package com.mehedi.springbootliquibase.controllers;

import com.mehedi.springbootliquibase.entities.Student;
import com.mehedi.springbootliquibase.models.requests.CreateStudentRequest;
import com.mehedi.springbootliquibase.services.StudentService;
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
@RequestMapping(value = "/api/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<Page<Student>> getAll(Pageable pageable) {
        return ResponseEntity.ok(studentService.getAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody CreateStudentRequest request) {
        UUID id = studentService.create(request);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri()).build();
    }
}
