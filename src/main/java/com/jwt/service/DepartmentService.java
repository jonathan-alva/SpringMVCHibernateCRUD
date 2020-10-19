package com.jwt.service;

import com.jwt.model.Department;

import java.util.List;

public interface DepartmentService {
    void addDepartment(Department department);

    List<Department> getAllDepartments();

    void deleteDepartment(Integer departmentId);

    Department getDepartment(int departmentId);

    Department updateDepartment(Department department);
}
