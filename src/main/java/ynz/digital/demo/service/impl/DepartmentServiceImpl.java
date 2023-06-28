package ynz.digital.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ynz.digital.demo.entity.Department;
import ynz.digital.demo.exception.DepartmentException;
import ynz.digital.demo.repository.DepartmentRepository;
import ynz.digital.demo.service.DepartmentService;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department save(Department department) throws DepartmentException {
        if (null != department.getDepartmentId()) {
            validateDuplicateId(department.getDepartmentId());
        }
        if(null != department.getDepartmentCode()) {
            validateDuplicateDeptCode(department.getDepartmentCode());
        }
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartment(Long id) throws DepartmentException {
        validateId(id);
        return departmentRepository.findById(id).get();
    }

    @Override
    public List<Department> listDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void deleteDepartment(Long id) throws DepartmentException {
        validateId(id);
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Department department) throws DepartmentException {
        validateId(department.getDepartmentId());
        return departmentRepository.save(department);
    }

    public void validateId(Long id) throws DepartmentException {
        if(!departmentRepository.existsById(id))
        {
            throw new DepartmentException("Department ID " + id + " does not exist");
        }
    }

    public void validateDuplicateId(Long id) throws DepartmentException {
        if (departmentRepository.existsById(id)) {
            throw new DepartmentException("Department ID " + id + " already exist");
        }
    }

    public void validateDuplicateDeptCode(String deptCode) throws DepartmentException {
        if (null != departmentRepository.findByDepartmentCode(deptCode)) {
            throw new DepartmentException("Department Code " + deptCode + " already exist");
        }
    }
}
