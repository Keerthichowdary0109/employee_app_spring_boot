package org.jsp.employee.exceptionclasses;

import lombok.Builder;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor
public class InvalidEmployeeIdException extends RuntimeException 
{
	private String msge;
	   
	   public InvalidEmployeeIdException(String msge)
	   {
		   this.msge=msge;
	   }
	   @Override
		public String getMessage() {
			
			return this.msge;
		}
}
