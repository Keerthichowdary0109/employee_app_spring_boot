package org.jsp.employee.dao;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.jsp.employee.entity.Employee;
import org.jsp.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao 
{
	@Autowired
  private EmployeeRepository repository;
	
   public Employee saveEmployee(Employee employee)
   {
	   return repository.save(employee);
   }
   
   public Employee updateEmployee(Employee employee)
   {
	   return repository.save(employee);
   }  
   
   public Optional<Employee> findEmployeeById(int eid)
   {
	   return repository.findById(eid);
   }
   
   public List<Employee> findAllEmployees()
   {
	   return repository.findAll();
   }
   
   public List<Employee> findAllActiveEmployees()
   {
	   return repository.findAllActiveEmployees();
   }
   
   public void deleteEmployeeById(int eid)
   {
	    repository.deleteById(eid);
   }
   
   public Optional<Employee> findEmployeeByEmailAndPassword(String email, String password)
   {
	   return repository.findByEmailAndPassword(email, password);
   }
   
   public List<Employee> findEmployeeByName(String name)
   {
	   return repository.findByName(name);
   }
}
