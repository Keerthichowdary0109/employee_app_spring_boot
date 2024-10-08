package org.jsp.employee.repository;

import java.util.Optional;

import org.jsp.employee.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EducationRepository extends JpaRepository<Education, Integer>
{

	@Query("select edu from Education edu where edu.eid=:eid")
	Optional<Education> findEducationByEid(int eid);

}
