package com.jwt.service;

import com.jwt.dao.DepartmentDAO;
import com.jwt.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentDAO departmentDAO;

    @Transactional
    public void addDepartment(Department department) {
        departmentDAO.addDepartment(department);
    }

    public List<Department> getAllDepartments() {
        return departmentDAO.getAllDepartments();
    }

    public void deleteDepartment(Integer departmentId) {
        departmentDAO.deleteDepartment((departmentId));
    }

    public Department getDepartment(int departmentId) {
        return departmentDAO.getDepartment(departmentId);
    }

    public Department updateDepartment(Department department) {
        return departmentDAO.updateDepartment(department);
    }

    public void setDepartmentDAO(DepartmentDAO departmentDAO){
        this.departmentDAO = departmentDAO;
    }
}
