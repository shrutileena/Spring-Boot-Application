package com.example.employeeManagement.Repository;

import com.example.employeeManagement.Model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
}
