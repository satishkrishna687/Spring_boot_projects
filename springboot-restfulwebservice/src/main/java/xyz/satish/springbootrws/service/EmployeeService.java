package xyz.satish.springbootrws.service;

import java.util.List;

import xyz.satish.springbootrws.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id);
	Employee updateEmpoyeeById(Employee employee,int id);
	void deleteEmployeeById(int id);
}
