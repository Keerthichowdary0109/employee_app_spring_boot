package org.jsp.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int doreNo;
	private String streetAddress;
	private String addessLine2;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	private String addressType; //can an enum PERMNENT, PRESENT
	@ManyToOne
	private Employee employee;
}
