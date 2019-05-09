
/**
 * Model - Lecturer Class 
 */

package models;

import java.io.Serializable;

import models.lecturer.LecturerType;

public abstract class Lecturer implements Serializable {
	
	private String name;
	private String address;
	private String phoneNumber;
	private String emailAddress;
	private String startedDate;
	private LecturerType lecturerType;
	private String staffID;
	
	public String getStaffID() {
		return staffID;
	} 
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber2) {
		this.phoneNumber = phoneNumber2;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getStartedDate() {
		return startedDate;
	}
	public void setStartedDate(String startedDate2) {
		this.startedDate = startedDate2;
	}
	public LecturerType getLecturerType() {
		return lecturerType;
	}
	public void setLecturerType(LecturerType lecturerType) {
		this.lecturerType = lecturerType;
	}
	
	@Override
	public String toString(){
		return staffID;
		
	}
	
}
