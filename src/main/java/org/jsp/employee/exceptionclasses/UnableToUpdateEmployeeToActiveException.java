package org.jsp.employee.exceptionclasses;

import lombok.Builder;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor
public class UnableToUpdateEmployeeToActiveException extends RuntimeException 
{
private String msge;
	
	public UnableToUpdateEmployeeToActiveException(String msge)
	   {
		   this.msge=msge;
	   }
	   @Override
		public String getMessage() 
	   {	
			return this.msge;
		}
}
