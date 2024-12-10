package com.mehedi.springbootliquibase.services;

import com.mehedi.springbootliquibase.entities.Department;
import com.mehedi.springbootliquibase.entities.Student;
import com.mehedi.springbootliquibase.exceptions.NotFoundException;
import com.mehedi.springbootliquibase.models.requests.CreateStudentRequest;
import com.mehedi.springbootliquibase.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private final DepartmentService departmentService;

    public Page<Student> getAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public Student findById(UUID id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found"));
    }

    public UUID create(CreateStudentRequest request) {
        Department department = departmentService.findById(request.getDepartmentId());

        Student student = Student.builder()
                .name(request.getName())
                .email(request.getEmail())
                .studentId(request.getStudentId())
                .gender(request.getGender())
                .department(department)
                .build();

        return studentRepository.save(student).getId();
    }
}
