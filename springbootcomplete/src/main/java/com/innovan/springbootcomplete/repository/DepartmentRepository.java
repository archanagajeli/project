package com.innovan.springbootcomplete.repository;

import com.innovan.springbootcomplete.entitiy.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
// public Department findByName(String name);
    public void deleteDepartments(List<Long> department_Id);


}
