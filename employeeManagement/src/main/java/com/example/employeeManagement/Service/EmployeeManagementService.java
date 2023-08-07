package com.example.employeeManagement.Service;

import com.example.employeeManagement.Model.Department;
import com.example.employeeManagement.Model.Employee;
import com.example.employeeManagement.Repository.DepartmentRepository;
import com.example.employeeManagement.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManagementService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Employee> getPuneEmployees(){
        List<Employee> puneEmployees = employeeRepository.getPuneEmployees();
        return puneEmployees;
    }

    public List<Department> getAllDepartments() {
        List<Department> allDepartments = departmentRepository.getAllDepartments();
        return allDepartments;
    }
}
