package org.jsp.employee.exceptionhandler;

import java.sql.SQLIntegrityConstraintViolationException;

import org.jsp.employee.exceptionclasses.InvalidCredentialsException;
import org.jsp.employee.exceptionclasses.InvalidEmployeeIdException;
import org.jsp.employee.exceptionclasses.InvalidNameException;
import org.jsp.employee.exceptionclasses.NoActiveEmployeeFoundException;
import org.jsp.employee.exceptionclasses.NoEmployeeFoundToDeleteException;
import org.jsp.employee.exceptionclasses.UnableToUpdateEmployeeToActiveException;
import org.jsp.employee.exceptionclasses.UnableToUpdateEmployeeToInActiveException;
import org.jsp.employee.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.Builder;
@Builder
@RestControllerAdvice
public class EmployeeExceptionHandler 
{
  @ExceptionHandler(NoActiveEmployeeFoundException.class)
  public ResponseEntity<?> noActiveEmployeeFoundExceptionHandler(NoActiveEmployeeFoundException e)
  {
//	  ResponseStructure<String> structure=new ResponseStructure<>();
//	  structure.setStatus(HttpStatus.NOT_FOUND.value());
//	  structure.setMsge("No active Employee Found");
//	  structure.setBody(e.getMessage());
	  
	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).msge("No active Employee Found").body(e.getMessage()).build());
  }
  
  @ExceptionHandler(InvalidEmployeeIdException.class)
  public ResponseEntity<?> invalidEmployeeIdExceptionHandler(InvalidEmployeeIdException e)
  {
//	  ResponseStructure<String> structure=new ResponseStructure<>();
//	  structure.setStatus(HttpStatus.NOT_FOUND.value());
//	  structure.setMsge("No employee found With that Id");
//	  structure.setBody(e.getMessage());
	  
	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).msge("No Employee Found With That Id: ").body(e.getMessage()).build());
  }
  
  @ExceptionHandler(InvalidCredentialsException.class)
  public ResponseEntity<?> invalidCredentialsExceptionHandler(InvalidCredentialsException e)
  {
//	  ResponseStructure<String> structure=new ResponseStructure<>();
//	  structure.setStatus(HttpStatus.NOT_FOUND.value());
//	  structure.setMsge("Invalid Email And Password");
//	  structure.setBody(e.getMessage());
	 
	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).msge("Invalid Email And password").body(e.getMessage()).build());

  }
  
  @ExceptionHandler(InvalidNameException.class)
  public ResponseEntity<?> invalidNameExceptionHandler(InvalidNameException e)
  {
//	  ResponseStructure<String> structure=new ResponseStructure<>();
//	  structure.setStatus(HttpStatus.NOT_FOUND.value());
//	  structure.setMsge("Invalid Name.. No employee matched with that name.");
//	  structure.setBody(e.getMessage());
	  
	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).msge("Invalid Name.. No employee matched with that name").body(e.getMessage()).build());

  }
  
  @ExceptionHandler(UnableToUpdateEmployeeToActiveException.class)
  public ResponseEntity<?> unableToUpdateEmployeeToActiveException(UnableToUpdateEmployeeToActiveException e)
  {
//	  ResponseStructure<String> structure=new ResponseStructure<>();
//	  structure.setStatus(HttpStatus.BAD_REQUEST.value());
//	  structure.setMsge("Unable to update employee to active..Invalid id..");
//	  structure.setBody(e.getMessage());
	  
	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).msge("Unable to update employee to active..Invalid id..").body(e.getMessage()).build());
  }
  
  @ExceptionHandler(UnableToUpdateEmployeeToInActiveException.class)
  public ResponseEntity<?> unableToUpdateEmployeeToInActiveException(UnableToUpdateEmployeeToInActiveException e)
  {
//	  ResponseStructure<String> structure=new ResponseStructure<>();
//	  structure.setStatus(HttpStatus.BAD_REQUEST.value());
//	  structure.setMsge("Unable to update employee to in active..Invalid id..");
//	  structure.setBody(e.getMessage());
	 
	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).msge("Unable to update employee to in active..Invalid id..").body(e.getMessage()).build());

  }
  
  @ExceptionHandler(NoEmployeeFoundToDeleteException.class)
  public ResponseEntity<?> noEmployeeFoundToDeleteExceptionHandler(NoEmployeeFoundToDeleteException e)
  {
//	  ResponseStructure<String> structure=new ResponseStructure<>();
//	  structure.setStatus(HttpStatus.NOT_FOUND.value());
//	  structure.setMsge("Invalid Name..Unable to delete..");
//	  structure.setBody(e.getMessage());
	 
	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).msge("Invalid id..unable to delete..").body(e.getMessage()).build());
  }
  
  @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
  public ResponseEntity<?> sQLIntegrityConstraintViolationExceptionHndler(SQLIntegrityConstraintViolationException e)
  {
	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value()).msge("Invalid email or phonenumber").body(e.getMessage()).build());
  }
  
}
