package org.jsp.employee.exceptionclasses;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class NoEmployeeFoundToDeleteException extends RuntimeException 
{
private String msge;

public NoEmployeeFoundToDeleteException(String msge)
{
	this.msge=msge;
}

public String getMsge()
{
	return msge;
}
}
