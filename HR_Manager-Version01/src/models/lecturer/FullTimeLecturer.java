
/**
 * Model - Full Time Lecturer Class 
 */

package models.lecturer;

import java.text.ParseException;

import models.Lecturer;

public class FullTimeLecturer extends Lecturer {
	
	private String salary;
	
	public FullTimeLecturer(String staffID, String name, String address, String phoneNumber, 
			String emailAddress, String startedDate, String Salary) throws ParseException {
		
		this.setStaffID(staffID);
		this.setName(name);
		this.setAddress(address);
		this.setPhoneNumber(phoneNumber);
		this.setEmailAddress(emailAddress);
		this.setStartedDate(startedDate);
		this.setLecturerType(LecturerType.FULL_TIME);
		this.salary = salary;
		
	} 
	
	public String getSalary() {
		
		return salary;
	}

	public void setSalary(String salary) {
		
		this.salary = salary;
	}
	
}

