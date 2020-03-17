package com.capgemini.empwebapp2.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="employee1")
public class EmployeeBean {
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String name;
	@Column(unique = true)
	private String email;
	@Column
	private String password;
}
