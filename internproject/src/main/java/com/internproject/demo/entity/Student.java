package com.internproject.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "STUDENT")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)

public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	long id;
	
	@Column (name = "STUDENT_NAME")
	String name;
	
	@Column (name = "STUDENT_PHONE")
	String phone;
	
	@Column 
	String rollNo;
	
	@Column 
	String address;
	
	@Column
	String dob;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRollNo() {
		return rollNo;
	}


	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	
}
