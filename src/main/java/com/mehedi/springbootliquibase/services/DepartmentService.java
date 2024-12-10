package com.mehedi.springbootliquibase.services;

import com.mehedi.springbootliquibase.entities.Department;
import com.mehedi.springbootliquibase.entities.Student;
import com.mehedi.springbootliquibase.exceptions.NotFoundException;
import com.mehedi.springbootliquibase.models.requests.CreateDepartmentRequest;
import com.mehedi.springbootliquibase.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Page<Department> getAll(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    public Department findById(UUID id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Department not found"));
    }

    public UUID create(CreateDepartmentRequest request) {
        Department department = Department.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();

        return departmentRepository.save(department).getId();
    }

    public void perform() {
        Department department = departmentRepository.findAll().getFirst();
        log.info("Department: {}", department);

        List<Student> students = department.getStudents();
        log.info("Students: {}", students);

        log.info("Department 2: {}", department);

        students = department.getStudents();
        log.info("Students 2: {}", students);
    }
}
