package xyz.satish.springbootrws.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import xyz.satish.springbootrws.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer >{

}
