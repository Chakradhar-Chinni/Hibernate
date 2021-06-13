package com.telusko.DemoHib;

import javax.persistence.Embeddable;

@Embeddable
public class Address 
{
	private String home;
	private String office; 
	private String residential;
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getResidential() {
		return residential;
	}
	public void setResidential(String residential) {
		this.residential = residential;
	}
	@Override
	public String toString() {
		return "Address [home=" + home + ", office=" + office + ", residential=" + residential + "]";
	} 
	 
	 
}
