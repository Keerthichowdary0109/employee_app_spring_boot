package org.jsp.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.employee.dao.EmployeeDao;
import org.jsp.employee.entity.Employee;
import org.jsp.employee.exceptionclasses.InvalidCredentialsException;
import org.jsp.employee.exceptionclasses.InvalidNameException;
import org.jsp.employee.exceptionclasses.InvalidEmployeeIdException;
import org.jsp.employee.exceptionclasses.NoActiveEmployeeFoundException;
import org.jsp.employee.exceptionclasses.NoEmployeeFoundException;
import org.jsp.employee.exceptionclasses.NoEmployeeFoundToDeleteException;
import org.jsp.employee.exceptionclasses.UnableToUpdateEmployeeToActiveException;
import org.jsp.employee.exceptionclasses.UnableToUpdateEmployeeToInActiveException;
import org.jsp.employee.responsestructure.ResponseStructure;
import org.jsp.employee.util.EmployeeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService
{
 @Autowired
 private EmployeeDao dao;
 
public ResponseEntity<?> saveEmployee(Employee employee)
{

	employee.setStatus(EmployeeStatus.IN_ACTIVE);
   
//   ResponseStructure<Employee> structure =new ResponseStructure<>();
//	structure.setStatus(HttpStatus.CREATED.value());
//	structure.setMsge("Employee saved successfullyy");
//	structure.setBody(emp);
// bulider is a method used to bulid an object.
   // return statement contains response structure creation and network status code..
  
	return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.builder().status(HttpStatus.CREATED.value()).msge("Employee Saved Succssfullyy.").body(dao.saveEmployee(employee)).build());
}

public ResponseEntity<?> updateEmployee(Employee employee)
{
//	ResponseStructure<Employee> structure =new ResponseStructure<>();
//	structure.setStatus(HttpStatus.OK.value());
//	structure.setMsge("Employee updated successfullyy");
//	structure.setBody(emp);
	
	return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).msge("Employee Upadetd successfullyy.").body(dao.updateEmployee(employee)).build());
}

public ResponseEntity<?> findAllActiveEmployees()
{
	List<Employee> el=dao.findAllActiveEmployees();
	if(el.isEmpty())
	{
//		ResponseStructure<List<Employee>> structure =new ResponseStructure<>();
//		structure.setStatus(HttpStatus.NOT_FOUND.value());
//		structure.setMsge("No Employee Found In DB");
//		structure.setBody(el);
//		return structure;
		
		throw NoActiveEmployeeFoundException.builder().msge("No Active Employee Found In the Data Base").build();
	}
	
//	ArrayList<Employee> activeEmployees=new ArrayList<>();
//	for(Employee e:el)
//		if(e.getStatus()==EmployeeStatus.ACTIVE)
//			activeEmployees.add(e);
//	
//	ResponseStructure<List<Employee>> structure =new ResponseStructure<>();
//	structure.setStatus(HttpStatus.OK.value());
//	structure.setMsge("All Employee Found Succesfullyy..");
//	structure.setBody(el);
	
	return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).msge("All Active Employee Found Succesfullyy..").body(el).build());
}

public ResponseEntity<?> findEmployeeById(int id)
{
	Optional<Employee> optional=dao.findEmployeeById(id);
	ResponseStructure<Employee> structure =new ResponseStructure<>();
	if(optional.isEmpty())
	{
//		structure.setStatus(HttpStatus.NOT_FOUND.value());
//		structure.setMsge("No Employee Found In DB..Invalid id: "+id);
//		structure.setBody(null);
//		return structure;
		
		throw InvalidEmployeeIdException.builder().msge("Invalid id.Unable to find Employee.").build();
	}
//	    Employee emp=optional.get();
//	    structure.setStatus(HttpStatus.OK.value());
//	    structure.setMsge("All Employee Found Succesfullyy..");
//	    structure.setBody(emp);
	
	    return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).msge("All Active Employee Found Succesfullyy..").body(optional.get()).build());
}

public ResponseEntity<?> deleteEmployeeById(int id)
{
	Optional<Employee> optional=dao.findEmployeeById(id);
	if(optional.isEmpty())
	{
//		structure.setStatus(HttpStatus.BAD_REQUEST.value());
//		structure.setMsge("No Employee Found In DB..Invalid id: "+id);
//		structure.setBody("Delete Unsuccessfull");
//		return structure;
		
		throw NoEmployeeFoundToDeleteException.builder().msge("Invalid id..Unable to delete.").build();
	}
         dao.deleteEmployeeById(id);
//	    structure.setStatus(HttpStatus.OK.value());
//	    structure.setMsge("Employee deleted Succesfullyy..");
//	    structure.setBody("Delete Successfull..");

	return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).msge("Employee deleted Succesfullyy..").body("Delete Successfull..").build());
}

public ResponseEntity<?> findEmployeeByEmailAndPassword(String email, String password)
{
	Optional<Employee> optional=dao.findEmployeeByEmailAndPassword(email, password);
	if(optional.isEmpty())
	{
//		structure.setStatus(HttpStatus.NOT_FOUND.value());
//		structure.setMsge("Invalid credentials.."+email+" "+password);
//		structure.setBody(null);
//		return structure;
		
		throw InvalidCredentialsException.builder().msge("Invalid Email and Password.").build();
	}
//	Employee emp=optional.get();
//    structure.setStatus(HttpStatus.OK.value());
//    structure.setMsge("Employee verified Successfully..");
//    structure.setBody(emp);
	
    return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).msge("Employee verified Succesfullyy..").body(optional.get()).build());	  
}

public ResponseEntity<?> findEmployeeByName(String name)
{
	List<Employee> el=dao.findEmployeeByName(name);
	if(el.isEmpty())
	{
//		ResponseStructure<List<Employee>> structure =new ResponseStructure<>();
//		structure.setStatus(HttpStatus.NOT_FOUND.value());
//		structure.setMsge("No Employee Found In DB with that name..");
//		structure.setBody(el);
//		return structure;
		
		throw InvalidNameException.builder().msge("Invalid Name").build();
	}
//	ResponseStructure<List<Employee>> structure =new ResponseStructure<>();
//	structure.setStatus(HttpStatus.OK.value());
//	structure.setMsge("Employee Found By Name Succesfullyy..");
//	structure.setBody(el);
	
	return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).msge("Employee Found By Name Succesfullyy..").body(el).build());
}

public ResponseEntity<?> updateEmployeeStatusToActive(int eid) 
{
	Optional<Employee> optional=dao.findEmployeeById(eid);
	if(optional.isEmpty())
	{
//		structure.setStatus(HttpStatus.BAD_REQUEST.value());
//		structure.setMsge("No Employee Found In DB..");
//		structure.setBody(null);
//		return structure;
		
		throw UnableToUpdateEmployeeToActiveException.builder().msge("Unable to update employee to active").build();
	}
	
	Employee emp=optional.get();
	emp.setStatus(EmployeeStatus.ACTIVE);
	
//	structure.setStatus(HttpStatus.OK.value());
//	structure.setMsge("Employee Status updated to Active..");
//	structure.setBody(emp);
	
	return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).msge("Employee Status updated to Active..").body(dao.updateEmployee(emp)).build());
}

public ResponseEntity<?> updateEmployeeStatusToInActive(int eid) 
{
	Optional<Employee> optional=dao.findEmployeeById(eid);
	if(optional.isEmpty())
	{
//		structure.setStatus(HttpStatus.BAD_REQUEST.value());
//		structure.setMsge("No Employee Found In DB..");
//		structure.setBody(null);
//		return structure;
		
		throw UnableToUpdateEmployeeToInActiveException.builder().msge("Unable to update employee to in active").build();
	}
	Employee emp=optional.get();
	emp.setStatus(EmployeeStatus.IN_ACTIVE);
	
//	structure.setStatus(HttpStatus.OK.value());
//	structure.setMsge("Employee Status updated to In Active..");
//	structure.setBody(emp);
	
	return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).msge("Employee Status updated to In Active..").body(dao.updateEmployee(emp)).build());
}

public ResponseEntity<?> findAllEmployees()
{
   List<Employee> el=dao.findAllEmployees();
   if(el.isEmpty())
   {
	   throw NoEmployeeFoundException.builder().msge("No employees are found").build();
   }
   
   return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).msge("All Employees Found Successfullyy..").body(el).build());
}
}

