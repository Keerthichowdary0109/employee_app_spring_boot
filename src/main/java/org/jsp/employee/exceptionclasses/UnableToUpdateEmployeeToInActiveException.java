package org.jsp.employee.exceptionclasses;

import lombok.Builder;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor
public class UnableToUpdateEmployeeToInActiveException extends RuntimeException 
{
private String msge;
	
	public UnableToUpdateEmployeeToInActiveException(String msge)
	   {
		   this.msge=msge;
	   }
	   @Override
		public String getMessage() 
	   {	
			return this.msge;
		}

}
