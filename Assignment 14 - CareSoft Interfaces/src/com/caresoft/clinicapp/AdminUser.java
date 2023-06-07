package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {
	private String role;
	private ArrayList<String> securityIncidents;
	
	public AdminUser(Integer id, String role) {
		super(id);
		// TODO Auto-generated constructor stub
		this.role = role;
		this.securityIncidents = new ArrayList<String>();
	}

	@Override
	public boolean assignPin(int pin) {
		if (String.valueOf(pin).length() < 4) {
			return false;
		} else {
			setPin(pin);
			return true;
		}
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if (id == confirmedAuthID) {
			return true;
		} else {
			authIncident();
			return false;
		}
	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return this.securityIncidents;
	}
	
	public void newIncident(String notes) {
		String report = String.format(
				"Datetime submitted: %s \n, Reported by ID: %s\n Notes: %s \n", 
				new Date(), this.id, notes
		);
		securityIncidents.add(report);
	}
	
	public void authIncident() {
		String report = String.format(
				"Datetime submitted: %s \n, ID: %s\n Notes: %s \n", 
				new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
		);
		securityIncidents.add(report);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
}
