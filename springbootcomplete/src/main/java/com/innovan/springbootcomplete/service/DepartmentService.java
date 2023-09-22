package com.innovan.springbootcomplete.service;

import com.innovan.springbootcomplete.entitiy.Department;
import com.innovan.springbootcomplete.error.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DepartmentService {
   public void saveDepartment(Department department);

  public List<Department>fetchdepartmentList();

  public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

  public void deleteDepartmentById(Long departmentId);

  public void deleteAll(List<Department> departments);

  public Optional<Department> updateDepartment(Long departmentId, Department department);

    void deleteDepartments(List<Department> departments);

//   public Department findByName(String departmentName);
}
