package com.hrmanagement.api.Controllers;

import com.hrmanagement.api.Model.Employee;
import com.hrmanagement.api.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
//@CrossOrigin("*")
@RestController

public class EmployeeController {

    @Autowired
    EmployeeService service;
    /**
     * Create - Add a new employee
     * @param employee An object employee
     * @return The employee object saved
     */


    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){
    return service.saveEmployee(employee);
    }
    /**
     * Read - Get one employee
     * @param id The id of the employee
     * @return An Employee object full filled
     */
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Long id){
        Optional<Employee> employee = service.getEmployee(id);
        if (employee.isPresent()){
            return employee.get();
        }else {
            return null;
        }
    }
    /**
     * Read - Get all employees
     * @return - An Iterable object of Employee full filled
     */
    @GetMapping("/employees")
    public Iterable<Employee> getEmployees(){
        return service.getAllEmployee();
    }
    /**
     * Update - Update an existing employee
     * @param id - The id of the employee to update
     * @param employee - The employee object updated
     * @return
     */
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") final  Long id ,@RequestBody Employee employee){
    Optional<Employee> e = service.getEmployee(id);
    if (e.isPresent()){
        Employee currentEmployee = e.get();
        String firstName= employee.getFirstName();
        if (firstName !=null){
            currentEmployee.setFirstName(firstName);
        }
        String lastName = employee.getLastName();
        if (lastName !=null){
            currentEmployee.setLastName(lastName);
        }
        String mail = employee.getMail();
        if (mail != null){
            currentEmployee.setMail(lastName);
        }
        String password = employee.getPassword();
        if (password !=null){
            currentEmployee.setPassword(password);
        }
        service.saveEmployee(currentEmployee);
        return  currentEmployee;
    }
    return null;
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") final Long id){
    service.deleteEmployee(id);

    }


}
