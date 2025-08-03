package com.utpal.employeemanager.service;

import com.utpal.employeemanager.exception.UserNotFoundException;
import com.utpal.employeemanager.model.Employee;
import com.utpal.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        // Assign a UUID if employeeCode is null or empty
        if (employee.getEmployeeCode() == null || employee.getEmployeeCode().isEmpty()) {
            employee.setEmployeeCode(UUID.randomUUID().toString());
        }
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("Employee with id " + id + " not found"));
    }

    public void deleteEmployee(Long id) {
        if (!employeeRepo.existsById(id)) {
            throw new RuntimeException("Employee with id " + id + " not found.");
        }
        employeeRepo.deleteById(id);
    }
}
