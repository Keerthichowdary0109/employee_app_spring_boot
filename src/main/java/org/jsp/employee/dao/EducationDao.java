package org.jsp.employee.dao;

import java.util.Optional;

import org.jsp.employee.entity.Education;
import org.jsp.employee.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component

public class EducationDao 
{
  @Autowired
  private EducationRepository repository;

	public Education saveEducation(Education education) 
	{
		return repository.save(education);
	}

	public Education updateEducation(Education education) 
	{
	  return repository.save(education);
	}

	public Optional<Education> findEducationByEid(int eid) 
	{
	  return repository.findEducationByEid(eid);	
	}

 
}
