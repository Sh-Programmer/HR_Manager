
/**
 * Model - Department Class 
 */

package models;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import models.lecturer.ContractLecturer;
import models.lecturer.FullTimeLecturer;
import models.lecturer.LecturerType;
import models.lecturer.PartTimeLecturer;

public class Department implements User, Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String type;
	private String webAddress;
	private String userName;
	private String password;
	private List<Lecturer> lecturers = new ArrayList<>();
	
	public Department() {}
	
	public Department(String name, String userName, String password, String webAddress, String type) {
		this.name = name;
		this.type = type;
		this.webAddress = webAddress;
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getWebAddress() {
		return webAddress;
	}
	
	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void addLecturer(Lecturer lecturer) {
		lecturers.add(lecturer);
	}
	
	public List<Lecturer> getLecturers() {
		return lecturers;
	}
	
	public List<Lecturer> query(String staffID, LecturerType lecturerType) {										// Query by Lecturer Type and Staff ID
		
		if(staffID.equals("")){	
			
			return  lecturers.stream().filter(x -> x.getLecturerType().equals(lecturerType)).
				collect(Collectors.toList());
		}
		else {
			
			return  lecturers.stream().filter(x -> x.getStaffID().contains(staffID)).
					filter(x -> x.getLecturerType().equals(lecturerType)).collect(Collectors.toList());
			
		}
	}
	
	public Object[][] query(String staffID) {																		// Query by StaffID and returning a JTable object of a selected Lecturer 
		
		Lecturer lec = lecturers.stream().filter(x -> x.getStaffID().equals(staffID)).findFirst().get();
		
		if(lec instanceof FullTimeLecturer) {
			
			FullTimeLecturer fl = (FullTimeLecturer)lec;
			Object[][] obj = {	{"Staff ID",fl.getStaffID()},	
					{"Name",fl.getName()},	
					{"Lecturer Type", fl.getLecturerType().toString()},
					{"Address", fl.getAddress()},	
					{"Email-Address",fl.getEmailAddress()},	
					{"Phone Number",fl.getPhoneNumber()},
					{"Started Date",fl.getStartedDate()},
					{"Salary",fl.getSalary()}
				};
			
			return obj;
			
		}
		else if(lec instanceof PartTimeLecturer) {
			
			PartTimeLecturer fl = (PartTimeLecturer)lec;
			Object[][] obj = {	{"Staff ID",fl.getStaffID()},	
					{"Name",fl.getName()},	
					{"Lecturer Type", fl.getLecturerType().toString()},
					{"Address", fl.getAddress()},	
					{"Email-Address",fl.getEmailAddress()},	
					{"Phone Number",fl.getPhoneNumber()},
					{"Started Date",fl.getStartedDate()},
					{"Hourly Rate",fl.getHourlyRate()}
				};
			
			return obj;
			
		}
		else {
			
			ContractLecturer fl = (ContractLecturer)lec;
			Object[][] obj = {	{"Staff ID",fl.getStaffID()},	
					{"Name",fl.getName()},	
					{"Lecturer Type", fl.getLecturerType().toString()},
					{"Address", fl.getAddress()},	
					{"Email-Address",fl.getEmailAddress()},	
					{"Phone Number",fl.getPhoneNumber()},
					{"Started Date",fl.getStartedDate()},
					{"Salary",fl.getSalary()},
					{"Contract Finish Date",fl.getContractFinishDate()}
				};
			
			return obj;
			
		}
		
	}
	
	public static Object[][] getDepartmentsAsObejects() {															// Department Details are arranged in a way to lay in a JTable
		
		List<User> users = User.loadUsers();
		List<Department> departments = users.stream().filter(x -> x instanceof Department).
				map(x->(Department)x).collect(Collectors.toList());
		Object[][] data = new Object[departments.size()][];
		
		for( int i=0;i<departments.size();i++) {
			
			 Object[] d = {departments.get(i).getName(), departments.get(i).getUserName(),
					 departments.get(i).getWebAddress(),departments.get(i).getType()};
			 data[i] = d;
			 
		}
		
		return data;
		
	}
	

	public static void changeDepartmentDetails(String lblUsername, String textFieldName, 							// Change the details of a selected department
			String textFieldWebAddress, String textFieldPassword, String comboBoxDepartmentType) {
		
		List<User> users = User.loadUsers();
		String fileName = "data/user.ser";
		File file = new File(fileName); 
		
		for(User u: users) {
			
			if(lblUsername.equals(u.getUserName())) {
				
				((Department)u).setName(textFieldName);
				((Department)u).setPassword(textFieldPassword);
				((Department)u).setType(comboBoxDepartmentType);
				((Department)u).setWebAddress(textFieldWebAddress);
			}
			
		}
		
		User.saveUsers(users);
		
	}

	public static void removeDepartment(String removeUsername) {													// remove selected Department
		
		List<User> users = User.loadUsers();
		
		int removeIndex = 0, i = 0;
		for(User u: users) {
			
			if(removeUsername.equals(u.getUserName())) {
				
				removeIndex = i;
				
			}
			
			i++;
			
		}
		
		users.remove(removeIndex);
		User.saveUsers(users);
		
	}

	public static List getListOfNames() {																			// get List of all Department Names
	
		List<User> users = User.loadUsers();
		
		return users.stream().filter(x -> x instanceof Department).map(x->((Department)x).getName()).collect(Collectors.toList());
		
	}

	
	public static Object[][] getLecturersAsObejects(String depName) {												// Lecturer Details are arranged in a way to lay in a JTable
		
		List<User> users = User.loadUsers();
		Department dep = users.stream().filter(x -> x instanceof Department).map(x->(Department)x).
				filter(x->x.getName().equals(depName)).findFirst().get();
		List<Lecturer> lecturers = dep.lecturers.stream().collect(Collectors.toList());
		Object[][] data = new Object[lecturers.size()][];
		
		for( int i=0;i<lecturers.size();i++) {
			
			if(lecturers.get(i) instanceof FullTimeLecturer) {

				Object[] d = {lecturers.get(i).getStaffID(), lecturers.get(i).getName(),
						lecturers.get(i).getAddress(), lecturers.get(i).getPhoneNumber(),
						lecturers.get(i).getEmailAddress(),lecturers.get(i).getLecturerType().toString(),
						lecturers.get(i).getStartedDate(),((FullTimeLecturer)lecturers.get(i)).getSalary(),"-","-"};
				data[i] = d;
				
			}
			 else if(lecturers.get(i) instanceof PartTimeLecturer) {

				 Object[] d = {lecturers.get(i).getStaffID(), lecturers.get(i).getName(),
						 lecturers.get(i).getAddress(), lecturers.get(i).getPhoneNumber(),
						 lecturers.get(i).getEmailAddress(),lecturers.get(i).getLecturerType().toString(),lecturers.get(i).getStartedDate(),
						 "-",((PartTimeLecturer)lecturers.get(i)).getHourlyRate(),"-"};
				 data[i] = d;
				 
			 }
			 else {

				 Object[] d = {lecturers.get(i).getStaffID(), lecturers.get(i).getName(),
						 lecturers.get(i).getAddress(), lecturers.get(i).getPhoneNumber(),lecturers.get(i).getEmailAddress(),
						 lecturers.get(i).getLecturerType().toString(),lecturers.get(i).getStartedDate(),
						 ((ContractLecturer)lecturers.get(i)).getSalary(), "-",((ContractLecturer)lecturers.get(i)).getContractFinishDate().toString()};
				 data[i] = d;
				 
			 }
			
		}
		
		return data;
		
	}

	public static void addLecturer(String comboBoxDepartment, Lecturer l) {											// Add a lecturer to a Department
		
		List<User> users = User.loadUsers();
		
		for(User u: users) {
			
			if(u instanceof Department) 
			{
				
				if(comboBoxDepartment.equals(((Department)u).getName())) 
				{
					
					((Department)u).addLecturer(l);
					
				}
				
			}
			
		}
		
		User.saveUsers(users);
		
	}

	public static void changeLecturerDetails(String comboBoxDepartment, String labellStaffID, 						// Change Lecturer Details			
			String textFieldName,String textFieldAddress, String textFieldPhoneNumber, 
			String textFieldEmailAddress, String textFieldStartedDate, 
			String textFieldSalary, String textFieldHourlyRate,String textFieldContractFinishDate) {
		
		List<User> users = User.loadUsers();
		
		for(User u : users) {
			
			if(u instanceof Department) {
				
				if(((Department)u).getName().equals(comboBoxDepartment)) {
					
					for(Lecturer l: ((Department)u).getLecturers() ) {
						
						if(l.getStaffID().equals(labellStaffID)) {
							
							l.setName(textFieldName);
							l.setAddress(textFieldAddress);
							l.setPhoneNumber(textFieldPhoneNumber);
							l.setEmailAddress(textFieldEmailAddress);
							l.setStartedDate(textFieldStartedDate);
							
							if(l instanceof FullTimeLecturer)
								((FullTimeLecturer)l).setSalary(textFieldSalary);
							else if(l instanceof PartTimeLecturer)
								((PartTimeLecturer)l).setHourlyRate(textFieldHourlyRate);
							else
								{((ContractLecturer)l).setSalary(textFieldSalary);	((ContractLecturer)l).setContractFinishDate(textFieldContractFinishDate);}
						}
						
					}
					
				}
				
			}
			
		}
		
		User.saveUsers(users);
		
	}

	public static void removeLecturer(String departmentName, String removeStaffID) {								// Remove Selected Lecturer
		
		List<User> users = User.loadUsers();
		int removeIndexLec = 0, j = 0;
		
		for(User u: users) {
			
			if(  u instanceof Department   ) {
				
				if(  ((Department)u).getName().equals(departmentName)  ){

					for(Lecturer l: ((Department)u).getLecturers()  ) {
						
						if(l.getStaffID().equals(removeStaffID)) {
							
							removeIndexLec = j;
							
						}
						
						j++;
						
					}
					
					((Department)u).lecturers.remove(removeIndexLec);	
					
				}
				
			}
			
		}
		
		User.saveUsers(users);
		
	}

	public static boolean departmentAlreadyExists(String username, String name) {										// Check whether the department with same name and Username already exists
		
		List<User> users = User.loadUsers();
		
		return users.stream().filter(x-> x instanceof Department).map(x->(Department)x).
				anyMatch(x->x.getName().equals(name)||x.getUserName().equals(username));
	}

	public static boolean LecturerAlreadyExists(String department, String staffID,  String name) {						// Check whether the lecturer with same Staff ID or Name Already Exists
		
		List<User> users = User.loadUsers();
		Department dep = users.stream().filter(x-> x instanceof Department).
				map(x->(Department)x).filter(x->x.getName().equals(department)).findFirst().get();
		
		return dep.getLecturers().stream().anyMatch(x->x.getStaffID().equals(staffID)||x.getName().equals(name));
		
	}

	public static void addDepartment(User u) {																			// Add Lecturer to a Department				
		
		List<User> users = User.loadUsers();
		users.add(u);
		User.saveUsers(users);
		
	}
	
}