package org.jsp.employee.exceptionclasses;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class NoEmployeeFoundException extends RuntimeException 
{
 private String msge;
 public NoEmployeeFoundException(String msge)
 {
	 this.msge=msge;
 }
 
 public String getMsge() 
 {
	return msge;
}
}
