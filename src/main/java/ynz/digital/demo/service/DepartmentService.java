package ynz.digital.demo.service;

import ynz.digital.demo.entity.Department;
import ynz.digital.demo.exception.DepartmentException;

import java.util.List;

public interface DepartmentService {
    Department save(Department department) throws DepartmentException;
    Department getDepartment(Long id) throws DepartmentException;
    List<Department> listDepartments();
    void deleteDepartment(Long id) throws DepartmentException;
    Department updateDepartment(Department department) throws DepartmentException;
}
