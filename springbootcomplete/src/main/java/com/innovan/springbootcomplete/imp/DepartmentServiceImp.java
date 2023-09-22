package com.innovan.springbootcomplete.imp;

import com.innovan.springbootcomplete.entitiy.Department;
import com.innovan.springbootcomplete.error.DepartmentNotFoundException;
import com.innovan.springbootcomplete.repository.DepartmentRepository;
import com.innovan.springbootcomplete.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService {
    @Autowired
    private DepartmentRepository repository;
    @Override
    public void saveDepartment(Department department){

        repository.save(department);
    }
    @Override
    public List<Department>fetchdepartmentList(){
        return repository.findAll();
    }
    @Override
    public Department fetchDepartmentById(Long department_Id) throws DepartmentNotFoundException {
        Optional<Department>department=
                repository.findById(department_Id);
        if(!department.isPresent()){
            throw  new DepartmentNotFoundException("department no found");
        }
        return department.get();
    }
    @Override
    public void deleteDepartmentById(Long department_Id ){
        repository.deleteById(department_Id);
    }
    @Override
    public void deleteAll(List<Department> departments) {
        repository.deleteAll(departments);
    }
    @Override
    public Optional<Department> updateDepartment(Long departmentId, Department department) {
        Department dpDB = repository.findById(departmentId).get();
        if (Objects.nonNull(department.getDepartment_Name()) && !"".equalsIgnoreCase(department.getDepartment_Name())) {
            dpDB.setDepartment_Name(department.getDepartment_Name());
        }
        if (Objects.nonNull(department.getDepartment_Address()) && !"".equalsIgnoreCase(department.getDepartment_Address())) {
            dpDB.setDepartment_Address(department.getDepartment_Address());
        }
        if (Objects.nonNull(department.getDepartment_Code()) && !"".equalsIgnoreCase(department.getDepartment_Code())) {
            dpDB.setDepartment_Code(department.getDepartment_Code());
        }
        return Optional.of(repository.save(dpDB));
    }

//    @Override
//    public Department findByName(String department_Name) {
//
//        return repository.findByName(department_Name);
//    }
    @Override
    public void deleteDepartments(List<Department> departments) {
        repository.deleteAll(departments);
    }

}
