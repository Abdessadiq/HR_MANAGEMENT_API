package com.hrmanagement.api.services;

import com.hrmanagement.api.Model.Employee;
import com.hrmanagement.api.repositories.EmployeeRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public Optional<Employee> getEmployee(final Long id){
        return employeeRepository.findById(id);
    }
    public  Iterable<Employee> getAllEmployee(){
        return  employeeRepository.findAll();
    }
    public  void deleteEmployee(final Long id){
        employeeRepository.deleteById(id);
    }
    public Employee saveEmployee(Employee employee){
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee;
    }

}
