package com.example.employeeManagement.Repository;

import com.example.employeeManagement.Model.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {
    @Query(value = "select dept_id, dept_name from department_tbl", nativeQuery = true)
    List<Department> getAllDepartments();
}
