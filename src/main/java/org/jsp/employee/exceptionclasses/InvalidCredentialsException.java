package org.jsp.employee.exceptionclasses;

import lombok.Builder;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor
public class InvalidCredentialsException extends RuntimeException
{
	private String msge;
	
	public InvalidCredentialsException(String msge)
	   {
		   this.msge=msge;
	   }
	   @Override
		public String getMessage() {
			
			return this.msge;
		}
}
