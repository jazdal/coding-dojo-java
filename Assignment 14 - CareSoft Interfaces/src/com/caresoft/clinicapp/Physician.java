package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;

	public Physician(Integer id) {
		super(id);
		// TODO Auto-generated constructor stub
		this.patientNotes = new ArrayList<String>();
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
		if (this.id == confirmedAuthID) {
			return true;
		} else {
			return false;
		}
	}
	
	public void newPatientNotes(String notes, String patientName, Date date) {
		String report = String.format("Datetime submitted: %s \n", date);
		report += String.format("Reported by ID: %s \n", this.id);
		report += String.format("Patient Name: %s \n", patientName);
		report += String.format("Notes: %s \n", notes);
		this.patientNotes.add(report);
	}

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
}
