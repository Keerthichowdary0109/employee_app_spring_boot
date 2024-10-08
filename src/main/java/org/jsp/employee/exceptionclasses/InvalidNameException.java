package org.jsp.employee.exceptionclasses;

import lombok.Builder;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor
public class InvalidNameException extends RuntimeException
{
private String msge;
	
	public InvalidNameException(String msge)
	   {
		   this.msge=msge;
	   }
	   @Override
		public String getMessage() 
	   {	
			return this.msge;
		}
}
