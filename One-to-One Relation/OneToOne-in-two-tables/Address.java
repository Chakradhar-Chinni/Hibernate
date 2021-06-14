package com.practice.DemoHib;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Address 
{
	@Id
	private int lane;
	private String Colony;
	private String Ward;
	private String landmark;
	@OneToOne
	private Employee employee;
	
	
	public Employee getEmployee() {
		return employee;    
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getLane() {
		return lane;
	}
	public void setLane(int lane) {
		this.lane = lane;
	}
	public String getColony() {
		return Colony;
	}
	public void setColony(String colony) {
		Colony = colony;
	}
	public String getWard() {
		return Ward;
	}
	public void setWard(String ward) {
		Ward = ward;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	 
	 
}
