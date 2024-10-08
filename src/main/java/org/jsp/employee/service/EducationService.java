package org.jsp.employee.service;

import java.util.Optional;

import org.jsp.employee.dao.EducationDao;
import org.jsp.employee.entity.Education;
import org.jsp.employee.exceptionclasses.InvalidEmployeeIdException;
import org.jsp.employee.responsestructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EducationService 
{
    @Autowired
    private EducationDao dao;
    
	public ResponseEntity<?> saveEduaction(Education education) 
	{
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.builder().status(HttpStatus.CREATED.value()).msge("Education Saved Succssfullyy.").body(dao.saveEducation(education)).build());

	}

	public ResponseEntity<?> updateEducation(Education education) 
	{
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).msge("Education updated Succssfullyy.").body(dao.updateEducation(education)).build());	
	}

	public ResponseEntity<?> findEducationByEid(int eid) 
	{
		Optional<Education> optional=dao.findEducationByEid(eid);
		if(optional.isEmpty())
		{
			throw InvalidEmployeeIdException.builder().msge("Invalid id.Unable to find education.").build();
		}
	    return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).msge("Education Details found Succesfullyy..").body(optional.get()).build());

	}

}
