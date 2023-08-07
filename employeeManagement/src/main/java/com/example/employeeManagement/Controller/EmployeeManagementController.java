package com.example.employeeManagement.Controller;

import com.example.employeeManagement.Model.Department;
import com.example.employeeManagement.Model.Employee;
import com.example.employeeManagement.Model.Manager;
import com.example.employeeManagement.Model.Project;
import com.example.employeeManagement.Repository.DepartmentRepository;
import com.example.employeeManagement.Repository.EmployeeRepository;
import com.example.employeeManagement.Repository.ManagerRepository;
import com.example.employeeManagement.Repository.ProjectRepository;
import com.example.employeeManagement.Service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping(path = "/employeeManagement")
public class EmployeeManagementController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private EmployeeManagementService employeeManagementService;

    @PostMapping(path = "/addEmployee")
    public @ResponseBody String addEmployee(@RequestParam String firstName,
                                              @RequestParam String lastName,
                                              @RequestParam String email,
                                              @RequestParam String deptId,
                                              @RequestParam String location,
                                              @RequestParam String managerId,
                                            @RequestParam String projectId) {
        Employee emp = new Employee();
        emp.setFirstName(firstName);
        emp.setLastName(lastName);
        emp.setEmail(email);
        emp.setDeptId(deptId);
        emp.setLocation(location);
        emp.setManagerId(managerId);
        emp.setProjectId(projectId);
        employeeRepository.save(emp);
        return "New employee added";
    }

    @PostMapping(path = "/addDepartment")
    public @ResponseBody String addDepartment(@RequestParam String deptId,
                                              @RequestParam String deptName){
        Department dept = new Department();
        dept.setDeptId(deptId);
        dept.setDeptName(deptName);
        departmentRepository.save(dept);
        return "New department added";
    }

    @PostMapping(path = "/addManager")
    public @ResponseBody String addManager(@RequestParam String managerId,
                                           @RequestParam String managerName,
                                           @RequestParam String projectId){
        Manager manager = new Manager();
        manager.setManagerId(managerId);
        manager.setManagerName(managerName);
        manager.setProjectId(projectId);
        managerRepository.save(manager);
        return "New manager added";
    }

    @PostMapping(path = "/addProject")
    public @ResponseBody String addProject(@RequestParam String projectId,
                                           @RequestParam String projectName){
        Project project = new Project();
        project.setProjectId(projectId);
        project.setProjectName(projectName);
        projectRepository.save(project);
        return "New project added";
    }

    @GetMapping(path = "/puneEmployees")
    public @ResponseBody List<Employee> getPuneEmployees() {
        return employeeManagementService.getPuneEmployees();
    }

    @GetMapping(path = "/allDepartments")
    public @ResponseBody List<Department> getAllDepartments(){
        return employeeManagementService.getAllDepartments();
    }
}
