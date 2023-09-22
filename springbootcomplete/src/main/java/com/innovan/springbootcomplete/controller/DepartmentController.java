package com.innovan.springbootcomplete.controller;

import com.innovan.springbootcomplete.entitiy.Department;
import com.innovan.springbootcomplete.error.DepartmentNotFoundException;
import com.innovan.springbootcomplete.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    private DepartmentService service;
    private  final  Logger logger=Logger.getLogger(String.valueOf(DepartmentController.class));
    @PostMapping("/departmentSave")
    public void saveDepartment( @Validated @RequestBody Department department){
        logger.info("Inside the Department Controller");

        service.saveDepartment(department);
    }
    @GetMapping("/department")
    public List<Department> fetchdepartmentList(){
        return service.fetchdepartmentList();
    }
    @GetMapping("/department/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long department_Id) throws DepartmentNotFoundException {
        logger.info("Inside the Department Controller");
        return service.fetchDepartmentById(department_Id);
    }
//    @GetMapping("/department/name/{name}")
//    public Department findByName(@PathVariable("department_Name") String department_Name){
//        return service.findByName(department_Name);
//    }
    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long department_Id){
        logger.info("Inside the Department Controller");
        service.deleteDepartmentById(department_Id);
        return "data deleted Successfully";
    }
    @PutMapping("/department/{id}")
    public Optional<Optional<Department>> updateDepartment(@PathVariable("id") Long department_Id, @RequestBody Department department){
        logger.info("Inside the Department Controller");
        return Optional.ofNullable(service.updateDepartment(department_Id, department));
    }
    @DeleteMapping("/departmentAll")
    public void listOfDeletes(@RequestBody List<Department> departments){
        service.deleteAll(departments);
    }



}
