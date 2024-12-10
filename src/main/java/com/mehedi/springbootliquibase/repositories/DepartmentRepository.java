package com.mehedi.springbootliquibase.repositories;

import com.mehedi.springbootliquibase.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {
}
