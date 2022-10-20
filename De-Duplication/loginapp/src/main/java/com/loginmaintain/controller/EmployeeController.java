package com.loginmaintain.controller;




import com.loginmaintain.exception.ResourceNotFoundException1;
import com.loginmaintain.repository.EmployeeRepository;
import com.loginmaintain.storagemodels.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin
@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employee")
    public Employee createEmployee(@Valid @RequestBody Employee note) {
        return employeeRepository.save(note);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") Long empId) {
        return employeeRepository.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException1("Employee", "id", empId));
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable(value = "id") Long empId,
                                           @Valid @RequestBody Employee empDetails) {

    	Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException1("Employee", "id", empId));
    	employee.setFirstName(empDetails.getFirstName());
    	employee.setLastName(empDetails.getLastName());
    	employee.setDesignation(empDetails.getDesignation());
    	employee.setExperience(empDetails.getExperience());
    	employee.setPhoneNumber(empDetails.getPhoneNumber());
    	employee.setAge(empDetails.getAge());
    	employee.setCurrentLocation(empDetails.getCurrentLocation());
    	employee.setTeleCommuterTemp(empDetails.isTeleCommuter()?1:0);
    	
        Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long empId) {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException1("Employee", "id", empId));

        employeeRepository.delete(employee);

        return ResponseEntity.ok().build();
    }
}
