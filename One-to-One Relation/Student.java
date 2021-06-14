package com.telusko.DemoHib;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student 
{
	
	private String Name;
	@Id
	private int Rollno;
	private int marks;
	@OneToOne
	private laptop l;
	
	public laptop getL() {
		return l;
	}
	public void setL(laptop l) {
		this.l = l;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getRollno() {
		return Rollno;
	}
	public void setRollno(int rollno) {
		Rollno = rollno;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [Name=" + Name + ", Rollno=" + Rollno + ", marks=" + marks + "]";
	}
	
	 
}
