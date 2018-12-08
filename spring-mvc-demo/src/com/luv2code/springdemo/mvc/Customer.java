package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.springdemo.mvc.validation.CourseCode;

public class Customer {

	private String firstName;
	
	@NotNull(message="Valore non valido")
	@Size(min=1, message="Campo obbligatorio")
	private String lastName;
	
	@NotNull(message="Campo Obbligatorio")
	@Min(value=0, message="Non puoi richiedere un numero negativo di pass")
	@Max(value=10, message="Non puoi richiedere più di 10 pass")
	private Integer freePasses;

	//@NotNull
	@Pattern(regexp="^\\d{5}", message="CAP non valido")
	private String cap;

	@CourseCode(value="TOPS", message="Must start with TOPS")
	private String courseCode;
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}

