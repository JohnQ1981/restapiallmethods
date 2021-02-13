package com.example1.example1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="Johny")
public class VBean01 {
	@Id
	private int j_id;
	private String name;
	private String lastName;
	private double salary;
	public VBean01(int j_id, String name, String lastName, double salary) {
		
		this.j_id = j_id;
		this.name = name;
		this.lastName = lastName;
		this.salary = salary;
	}
	public VBean01() {


	}
	public int getJ_id() {
		return j_id;
	}
	public void setJ_id(int j_id) {
		this.j_id = j_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "VBean01 [j_id=" + j_id + ", name=" + name + ", lastName=" + lastName + ", salary=" + salary + "]";
	}
	
	
	
	

}
