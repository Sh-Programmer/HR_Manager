
/**
 * Model - Part Time Lecturer Class 
 */

package models.lecturer;

import java.text.ParseException;

import models.Lecturer;

public class PartTimeLecturer extends Lecturer {
	
	private String hourlyRate;
	
	public PartTimeLecturer(String staffID, String name, String address, String phoneNumber, 
			String emailAddress, String startedDate, String hourlyRate) throws ParseException {

		this.setStaffID(staffID);
		this.setName(name);
		this.setAddress(address);
		this.setPhoneNumber(phoneNumber);
		this.setEmailAddress(emailAddress);
		this.setStartedDate(startedDate);
		setLecturerType(LecturerType.PART_TIME);
		this.hourlyRate = hourlyRate;
	}  

	public String getHourlyRate() {
		
		return hourlyRate;
	}

	public void setHourlyRate(String hourlyRate) {
		
		this.hourlyRate = hourlyRate;
	}
	
}
