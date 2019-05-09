
/**
 * Model - Contract Lecturer Class 
 */

package models.lecturer;

import java.text.ParseException;

import models.Lecturer;

public class ContractLecturer extends Lecturer{

	private String salary;
	private String contractFinishDate;
	
	public ContractLecturer(String staffID, String name, String address, String phoneNumber, 
			String emailAddress, String startedDate, String Salary, String contractFinishDate) throws ParseException {
		
		this.setStaffID(staffID);
		this.setName(name);
		this.setAddress(address);
		this.setPhoneNumber(phoneNumber);
		this.setEmailAddress(emailAddress);
		this.setStartedDate(startedDate);
		setLecturerType(LecturerType.CONTRACT);
		this.salary = salary;
		this.contractFinishDate = contractFinishDate;
	} 
	

	public String getContractFinishDate() {
		
		return contractFinishDate;
	}

	public void setContractFinishDate(String contractFinishDate) {
		
		this.contractFinishDate = contractFinishDate;
	}

	public String getSalary() {
		
		return salary;
	}

	public void setSalary(String textFieldSalary) {
		
		this.salary = textFieldSalary;
	}

}
