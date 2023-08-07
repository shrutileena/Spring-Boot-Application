package com.example.employeeManagement.Repository;

import com.example.employeeManagement.Model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    @Query(value = "select emp_id, first_name, last_name, email, dept_id, manager_id, " +
            "project_id, location from employee_tbl where location=\"Pune\"", nativeQuery = true)
    public List<Employee> getPuneEmployees();

}
