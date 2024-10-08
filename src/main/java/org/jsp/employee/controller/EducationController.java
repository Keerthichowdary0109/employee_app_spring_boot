package org.jsp.employee.controller;

import org.jsp.employee.entity.Education;
import org.jsp.employee.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/educations")
@RestController
public class EducationController 
{
	@Autowired
	private EducationService service;
	
	@PostMapping("/{eid}")
	public ResponseEntity<?> saveEducation(@RequestBody Education education, @PathVariable int eid)
	{
		return service.saveEduaction(education);
	}
	
	@PutMapping("/{eid}")
	public ResponseEntity<?> updateEducation(@RequestBody Education education, @PathVariable int eid)
	{
		return service.updateEducation(education);
	}
	
	@GetMapping("/{eid}")
    public ResponseEntity<?> findEduactionByEid(@PathVariable int eid)
    {
       return service.findEducationByEid(eid); 	
    }
   
}
