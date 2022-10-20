package xyz.satish.springbootrws.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import xyz.satish.springbootrws.excpetion.ResourceNotFoundException;
import xyz.satish.springbootrws.model.Employee;
import xyz.satish.springbootrws.repository.EmployeeRepository;
import xyz.satish.springbootrws.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	
	//no need to add Autowire as there is only one constructor
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		//saves employee instance to the database
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> employee=employeeRepository.findById(id);
		if(employee.isPresent())
		{
			return employee.get();
		}
		else
		{
			throw new ResourceNotFoundException("Employee","Id",id);
		}
	}


	@Override
	public Employee updateEmpoyeeById(Employee employee, int id) {
		Employee existingEmployee=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Empoyee","Id",id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastname(employee.getLastname());
		existingEmployee.setEmail(employee.getEmail());
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}


	@Override
	public void deleteEmployeeById(int id) {
		employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
		employeeRepository.deleteById(id);
	}

}
