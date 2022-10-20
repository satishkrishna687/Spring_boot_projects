package xyz.satish.springbootrws.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.satish.springbootrws.model.Employee;
import xyz.satish.springbootrws.service.EmployeeService;

@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {
 
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//build to create employee rest api
	//ResponesEntity because we can provide complete response details in this class
	@PostMapping
	//RequestBody allows us to retrieve request's body and convert it to java object
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	//build to get all employees
	@GetMapping("/info")
	public List<Employee> getAllEmployee()
	{
		return employeeService.getAllEmployees();
	}
	
	
	//build to find by id
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmoplyeeById(@PathVariable("id")int id)
	{
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
	}
	
	//to update employee by ID
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateById(@PathVariable("id") int id,@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.updateEmpoyeeById(employee, id),HttpStatus.OK);
	}
	
	//to delete employee by ID
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int id)
	{
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<String>("Deleted sucessfullly",HttpStatus.OK);
	}
}
