package com.jwt.dao;

import com.jwt.model.Department;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO{
    @Autowired
    private SessionFactory sessionFactory;

    public void addDepartment(Department department) {
        sessionFactory.getCurrentSession().saveOrUpdate(department);
    }

    public List<Department> getAllDepartments() {
        return sessionFactory.getCurrentSession().createQuery("from Department").list();
    }

    public void deleteDepartment(Integer departmentId) {
        Department department = (Department) sessionFactory.getCurrentSession().load(Department.class, departmentId);
        if(null != department){
            this.sessionFactory.getCurrentSession().delete(department);
        }
    }

    public Department updateDepartment(Department department) {
        sessionFactory.getCurrentSession().update(department);
        return department;
    }

    public Department getDepartment(int departmentId) {
        return (Department) sessionFactory.getCurrentSession().get(Department.class, departmentId);
    }
}
