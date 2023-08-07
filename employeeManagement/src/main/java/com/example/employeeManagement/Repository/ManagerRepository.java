package com.example.employeeManagement.Repository;

import com.example.employeeManagement.Model.Manager;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepository extends CrudRepository<Manager, Integer> {
}
