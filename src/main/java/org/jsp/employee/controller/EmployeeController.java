package org.jsp.employee.controller;

import java.util.List;

import org.jsp.employee.entity.Employee;
import org.jsp.employee.responsestructure.ResponseStructure;
import org.jsp.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController 
{
 @Autowired
 private EmployeeService service;
 
 @PostMapping
 public  ResponseEntity<?> saveEmployee(@RequestBody Employee employee)
 {
	 return service.saveEmployee(employee);
 }
 
 @PutMapping
 public ResponseEntity<?> updateEmployee(@RequestBody Employee employee)
 {
	 return service.updateEmployee(employee);
 }
 
 @GetMapping
 public ResponseEntity<?> findAllActiveEmployees()
 {
	 return service.findAllActiveEmployees();
 }
 
 @GetMapping(value = "/all")
 public ResponseEntity<?> findAllEmployees()
 {
	 return service.findAllEmployees();
 }
 
 @GetMapping(value="/{eid}")
 public ResponseEntity<?> findEmployeeById(@PathVariable int eid)
 {
	 return service.findEmployeeById(eid);
 }
 
 @DeleteMapping(value="/{eid}")
 public void deleteEmployeeById(@PathVariable int eid)
 {
	 service.deleteEmployeeById(eid);
 }
 
 @GetMapping(value="/{email}/{password}")
 public ResponseEntity<?> findEmployeeByEmailAndPassword(@PathVariable String email, @PathVariable String password)
 {
	return service.findEmployeeByEmailAndPassword(email, password);
 }
 
 @GetMapping(value="/name/{name}")
 public ResponseEntity<?> findEmployeeByName(@PathVariable String name)
 {
	 return service.findEmployeeByName(name);
 }
 
 @PatchMapping("/active/{eid}")
 public ResponseEntity<?> updateEmployeeStatusToActive(@PathVariable int eid)
 {
	 return service.updateEmployeeStatusToActive(eid);
 }
 
 @PatchMapping("/inactive/{eid}")
 public ResponseEntity<?> updateEmployeeStatusToInActive(@PathVariable int eid)
 {
	 return service.updateEmployeeStatusToInActive(eid);
 }
}
