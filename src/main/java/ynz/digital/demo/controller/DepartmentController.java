package ynz.digital.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ynz.digital.demo.entity.Department;
import ynz.digital.demo.exception.DepartmentException;
import ynz.digital.demo.service.DepartmentService;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> createDepartment(@Valid @RequestBody Department department)
            throws DepartmentException {
        return new ResponseEntity<>(departmentService.save(department), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable("id") long id) throws DepartmentException {
        return new ResponseEntity<>(departmentService.getDepartment(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        return new ResponseEntity<>(departmentService.listDepartments(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable("id") long id) throws DepartmentException {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Department> updateDepartment(@Valid @RequestBody Department department)
            throws DepartmentException {
        return new ResponseEntity<>(departmentService.updateDepartment(department), HttpStatus.OK);
    }

}
