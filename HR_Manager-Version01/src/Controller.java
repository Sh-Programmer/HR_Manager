/**
 * Controller of the Project
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import models.*;
import models.lecturer.ContractLecturer;
import models.lecturer.FullTimeLecturer;
import models.lecturer.PartTimeLecturer;
import views.*;
import views.department.LecturerDetailsView;
import views.hrStaff.AddDepartmentView;
import views.hrStaff.AddLecturerView;
import views.hrStaff.ModifyDepartmentView;
import views.hrStaff.ModifyLecturerView;

public class Controller {
	
	private LogInView logInView;
	private DepartmentView departmentView;
	private HRStaffView hrStaffView;
	private AddDepartmentView addDepartmentView;
	private ModifyDepartmentView modifyDepartmentView;
	private AddLecturerView addLecturerView;
	private ModifyLecturerView modifyLecturerView;

	private User user;
	
	public Controller( LogInView logInVIew,DepartmentView departmentView, HRStaffView hrStaffView, 
			AddDepartmentView addDepartmentView,ModifyDepartmentView modifyDepartmentView, 
			AddLecturerView addLecturerView,ModifyLecturerView modifyLecturerView) 
	{
		
		this.logInView = logInVIew;
		this.departmentView = departmentView;
		this.hrStaffView = hrStaffView;
		this.addDepartmentView = addDepartmentView;
		this.modifyDepartmentView = modifyDepartmentView;
		this.addLecturerView = addLecturerView;
		this.modifyLecturerView = modifyLecturerView;
		
		this.logInView.logInListener(new LoginListener());
		
	}
	
	class CloseHRStaffViewListener extends WindowAdapter{														// Log out from HR Staff Account
		
			@Override
		    public void windowClosing(WindowEvent windowEvent) {
				
		        if (JOptionPane.showConfirmDialog(hrStaffView.getFrame(), 
		            "Are you sure you want to Log out?", "Close Window?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		        	
		            hrStaffView.getFrame().setVisible(false);
		            departmentView.getFrame().setVisible(false);
		            logInView.getFrame().setVisible(true);
		            
		        }
		    
			}
			
	}
	
	class CloseDepartmentViewListener extends WindowAdapter{													// Log out from Department Account
		
		@Override
	    public void windowClosing(WindowEvent windowEvent) {
			
	        if (JOptionPane.showConfirmDialog(departmentView.getFrame(), 
	            "Are you sure you want to Log out?", "Close Window?", 
	            JOptionPane.YES_NO_OPTION,
	            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
	        	
	            departmentView.getFrame().setVisible(false);
	            hrStaffView.getFrame().setVisible(false);
	            logInView.getFrame().setVisible(true);
	            
	        }
	        
	    }
		
	}
	

	class RemoveLecturerListener implements ActionListener{														// Removing the Lecturer
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (hrStaffView.getTableLecturer().getSelectedRow() == -1) {
				
				hrStaffView.displayError("Please select the Item to Change Details");
				
			} else {
				
				String removeStaffID = (String) hrStaffView.getTableLecturer()
						.getValueAt(hrStaffView.getTableLecturer().getSelectedRow(), 1);
				String department = hrStaffView.getComboBoxDepartment();
				Department.removeLecturer(department, removeStaffID);
				hrStaffView.displayError("Lecturer Removed");
				
			} 
			
		}
		
	}
	
	class UpdateLectureListener implements ActionListener{														// Updating the changed details
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (modifyLecturerView.getTextFieldName().equals("")) {
				
				modifyLecturerView.displayError("Please fill the Mandatory fields");
				
			} else {
				
				Department.changeLecturerDetails(hrStaffView.getComboBoxDepartment(),
						modifyLecturerView.getLabellStaffID(), modifyLecturerView.getTextFieldName(),
						modifyLecturerView.getTextFieldAddress(), modifyLecturerView.getTextFieldPhoneNumber(),
						modifyLecturerView.getTextFieldEmailAddress(), modifyLecturerView.getTextFieldStartedDate(),
						modifyLecturerView.getTextFieldSalary(), modifyLecturerView.getTextFieldHourlyRate(),
						modifyLecturerView.getTextFieldContractFinishDate());

				modifyDepartmentView.displayError("Lecturer Updated Succesfully");
			
			} 
			
		}
	}
	
	class ModifyLecturerViewListener implements ActionListener{													// Opening the view to change details of a lecturer
		
		int i = 1;
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (hrStaffView.getTableLecturer().getSelectedRow() == -1) {
				hrStaffView.displayError("Please select the Item to Change Details");
			} else if (hrStaffView.getComboBoxDepartment().equals("-Please Select-"))
				hrStaffView.displayError("Please select a department");
			else {
				
				if (i == 1) {

					modifyLecturerView.updateLecturerListener(new UpdateLectureListener());

				}
				
				modifyLecturerView.getFrame().setVisible(true);
				modifyLecturerView.setLblStaffID((String) hrStaffView.getTableLecturer()
						.getValueAt(hrStaffView.getTableLecturer().getSelectedRow(), 0));
				modifyLecturerView.setTextFieldName((String) hrStaffView.getTableLecturer()
						.getValueAt(hrStaffView.getTableLecturer().getSelectedRow(), 1));
				modifyLecturerView.setTextFieldAddress((String) hrStaffView.getTableLecturer()
						.getValueAt(hrStaffView.getTableLecturer().getSelectedRow(), 2));
				modifyLecturerView.setTextFieldPhoneNumber((String) hrStaffView.getTableLecturer()
						.getValueAt(hrStaffView.getTableLecturer().getSelectedRow(), 3));
				modifyLecturerView.setTextFieldEmailAddress((String) hrStaffView.getTableLecturer()
						.getValueAt(hrStaffView.getTableLecturer().getSelectedRow(), 4));
				modifyLecturerView.setLblLectureType((String) hrStaffView.getTableLecturer()
						.getValueAt(hrStaffView.getTableLecturer().getSelectedRow(), 5));
				modifyLecturerView.setTextFieldStartedDate((String) hrStaffView.getTableLecturer()
						.getValueAt(hrStaffView.getTableLecturer().getSelectedRow(), 6));
				modifyLecturerView.setTextFieldSalary((String) hrStaffView.getTableLecturer()
						.getValueAt(hrStaffView.getTableLecturer().getSelectedRow(), 7));
				modifyLecturerView.setTextFieldHourlyRate((String) hrStaffView.getTableLecturer()
						.getValueAt(hrStaffView.getTableLecturer().getSelectedRow(), 8));
				modifyLecturerView.setTextFieldContractFinishDate((String) hrStaffView.getTableLecturer()
						.getValueAt(hrStaffView.getTableLecturer().getSelectedRow(), 9));

				
			} 
				
			i++;
				
		}
			
	}
		
	
	class CreateLecturerListener implements ActionListener{														// Create Lecturers in a department

		@Override
		public void actionPerformed(ActionEvent e) {
				if (addLecturerView.getTextFieldStaffID().equals("") || addLecturerView.getTextFieldName().equals("")) {
					
					addLecturerView.displayError("Please fill the Mandatory fields");
					
				} else if (addLecturerView.getComboBoxLecturerType().equals("-Please Select-")) {
					
					addLecturerView.displayError("Please Select a Department");
					
				} else if (Department.LecturerAlreadyExists(hrStaffView.getComboBoxDepartment(),
						addLecturerView.getTextFieldStaffID(), addLecturerView.getTextFieldName())) {
					
					addLecturerView.displayError("Staff ID or Name already exist");
					
				} else {
					
					Lecturer l;

					try {
						if (addLecturerView.getComboBoxLecturerType().equals("Full Time")) {
							
							l = new FullTimeLecturer(addLecturerView.getTextFieldStaffID(),
									addLecturerView.getTextFieldName(), addLecturerView.getTextFieldAddress(),
									addLecturerView.getTextFieldPhoneNumber(),
									addLecturerView.getTextFieldEmailAddress(),
									addLecturerView.getTextFieldStartedDate(), addLecturerView.getTextFieldSalary());
							
						} else if (addLecturerView.getComboBoxLecturerType().equals("Part Time")) {
							
							l = new PartTimeLecturer(addLecturerView.getTextFieldStaffID(),
									addLecturerView.getTextFieldName(), addLecturerView.getTextFieldAddress(),
									addLecturerView.getTextFieldPhoneNumber(),
									addLecturerView.getTextFieldEmailAddress(),
									addLecturerView.getTextFieldStartedDate(),
									addLecturerView.getTextFieldHourlyRate());
							
						} else {
							
							l = new ContractLecturer(addLecturerView.getTextFieldStaffID(),
									addLecturerView.getTextFieldName(), addLecturerView.getTextFieldAddress(),
									addLecturerView.getTextFieldPhoneNumber(),
									addLecturerView.getTextFieldEmailAddress(),
									addLecturerView.getTextFieldStartedDate(), addLecturerView.getTextFieldSalary(),
									addLecturerView.getTextFieldContractFinishDate());
							
						}

						Department.addLecturer(hrStaffView.getComboBoxDepartment(), l);								// Creating a Lecturer
						addLecturerView.displayError("Lecturer Succesfully Created");

					} catch (NumberFormatException e1) {
						addLecturerView.displayError(e1.toString());
					} catch (ParseException e1) {
						addLecturerView.displayError(e1.toString());
					} catch (DateTimeParseException e1) {
						addLecturerView.displayError("Please check the format of the date");

					}
				} 
		}
		
	}
	
	class AddLecturerViewListener implements ActionListener{														// A view to add Lecturers for HR Staff
		
		int i = 1;
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(hrStaffView.getComboBoxDepartment().equals("-Please Select-")){
				
				hrStaffView.displayError("Please select a Department");
				
			}
			else {
				
				addLecturerView.getFrame().setVisible(true);
				
				if(i == 1) {
						
						addLecturerView.createLecturerListener(new CreateLecturerListener());
					
				}
				
				i++;
				
			}	
			
		}	
		
	}
	
	class QueryLecturerListener implements ActionListener{															// Query Lecturers to HR Staff View 

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				
				Object[][] obj = Department.getLecturersAsObejects(hrStaffView.getComboBoxDepartment());
				hrStaffView.setTableLecturer(obj);
				
			}catch(NullPointerException|NoSuchElementException ex) {
				
				hrStaffView.displayError("Please Select Department");
				
			}
			
		}
		
	}

	
	class RemoveDepartmentListener implements ActionListener{														// Listener to remove the department
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (hrStaffView.getTableDepartment().getSelectedRow() == -1) {
				
				hrStaffView.displayError("Please select the Department to Change Details");
				
			}
			else {
				
				String removeUsername = (String) hrStaffView.getTableDepartment()		
						.getValueAt(hrStaffView.getTableDepartment().getSelectedRow(), 1);
				Department.removeDepartment(removeUsername);														// Remove Department
				hrStaffView.displayError("Department Deleted Succesfully");
			}
		}
	}
	
	class UpdateDepartmentListener implements ActionListener{														// Listener to Update Department
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
				if ((modifyDepartmentView.getTextFieldName().equals("") || 											// Checking whether Name, username and password is filled 
						modifyDepartmentView.getTextFieldPassword().equals(""))) {
					
					addDepartmentView.displayError("Please Fill all Mandatory Fields");

				} 
				else if (modifyDepartmentView.getComboBoxDepartmentType().equals("-Please Select-")) {
					
					modifyDepartmentView.displayError("Please Select the Correct Department Type");

				} 
				 else {
					 
					Department.changeDepartmentDetails(modifyDepartmentView.getLblUsername(), 						// Change the Details of the Department
						modifyDepartmentView.getTextFieldName(), modifyDepartmentView.getTextFieldWebAddress(),
						modifyDepartmentView.getTextFieldPassword(),
						modifyDepartmentView.getComboBoxDepartmentType());
						modifyDepartmentView.displayError("Department Updated Succesfully");

				} 
			
			
		}
	}
	
	class ModifyDepartmentViewListener implements ActionListener{													// Listener to get the Modify Department View
		
		int i = 1;
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(i);
			
				if (i==1) {
					
					modifyDepartmentView.updateDepartmentListener(new UpdateDepartmentListener());
					
				}
				
				if (hrStaffView.getTableDepartment().getSelectedRow() == -1) {
					
					hrStaffView.displayError("Please select the Department to Change Details");
					
				} else {

					modifyDepartmentView.getFrame().setVisible(true);
					modifyDepartmentView.setTextFieldName((String) hrStaffView.getTableDepartment()
							.getValueAt(hrStaffView.getTableDepartment().getSelectedRow(), 0));
					modifyDepartmentView.setLblUsername((String) hrStaffView.getTableDepartment()
							.getValueAt(hrStaffView.getTableDepartment().getSelectedRow(), 1));
					modifyDepartmentView.setTextFieldWebAddress((String) hrStaffView.getTableDepartment()
							.getValueAt(hrStaffView.getTableDepartment().getSelectedRow(), 2));
					modifyDepartmentView.setComboBoxDepartmentType((String) hrStaffView.getTableDepartment()
							.getValueAt(hrStaffView.getTableDepartment().getSelectedRow(), 3));
					
					List departments = Department.getListOfNames();												// Setting the ComboxDepartment with correct department list
					hrStaffView.setComboBoxDepartment(departments);	
					
				} 
				
			i++;
		}

	}
	class CreateDepartmentListener implements ActionListener{													// Create a new Department in HR Staff View
		
		@Override
		public void actionPerformed(ActionEvent e) {
				
				if ((addDepartmentView.getTextFieldName().equals("")|| 											// Checking whether Name, Username and password is filled 
						addDepartmentView.getTextFieldUsername().equals("")	
						|| addDepartmentView.getTextFieldPassword().equals(""))) {
					
					addDepartmentView.displayError("Please Fill all Mandatory Fields");					
					
				} else if (addDepartmentView.getComboBoxDepartmentType().equals("-Please Select-")) {
					
					addDepartmentView.displayError("Please Select the Correct Department Type");
					
				} else if (Department.departmentAlreadyExists(addDepartmentView.getTextFieldUsername(), 		// Checking whether Name or Username already exists
						addDepartmentView.getTextFieldName())){
					
					addDepartmentView.displayError("Username or Name Already Exists");
					
				} else {
					
					User u = new Department(addDepartmentView.getTextFieldName(),
							addDepartmentView.getTextFieldUsername(), 
							addDepartmentView.getTextFieldPassword(),
							addDepartmentView.getTextFieldWebAddress(), 
							addDepartmentView.getComboBoxDepartmentType()); 
					Department.addDepartment(u);																// Create the department
					addDepartmentView.displayError("Department Created Succesfully");
					
					List departments = Department.getListOfNames();												// Setting the ComboxDepartment with correct department list
					hrStaffView.setComboBoxDepartment(departments);	
					
				} 
	
		}
		
	}
	
	
	class AddDepartmentViewListener implements ActionListener{													// Opening a new window to add a department in HR Staff View
		
		int i=1;
		@Override
		public void actionPerformed(ActionEvent e) {

			addDepartmentView.getFrame().setVisible(true);
			
			if (i == 1) {

				addDepartmentView.createDepartmentListener(new CreateDepartmentListener());
				
			}
			
			i++;
			
		}
		
	}
	
	class QueryDepartmentListner implements ActionListener{														// Query the list of Departments to HR Staff View
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Object[][] obj = Department.getDepartmentsAsObejects();
			hrStaffView.setTableDepartment(obj);
			
		}
		
	}

	class LecturerDetailsQueryListener implements ListSelectionListener{										// Showing Lecturer Details to the Department Secretary View
		
		int i = 1;
		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			if(i==1) {
				
				String selectedData = (String) departmentView.getTable().getValueAt(departmentView.getTable().getSelectedRow(), 0);
				Object[][] obj = ((Department)user).query(selectedData);
		        LecturerDetailsView lecDetailsView = new LecturerDetailsView();
		        lecDetailsView.getFrame().setVisible(true);
		        lecDetailsView.setTable(obj);
		        
			}
			
	        i++;
	        
		}
		
	}
	
	class QueryListener implements ActionListener{																// Query Button for View for Department Secretary 
			
		@Override 
		public void actionPerformed(ActionEvent e) { 
			
			try {
				
				if(departmentView.getComboBoxLectureType().equals("-Please Select-")) {
					
					departmentView.displayError("Please Select Lecturer Type");
					
				}
				else {
					
					departmentView.setTable(((Department)user).query(departmentView.getTextFieldStaffID(),departmentView.getComboBoxLectureType()));
					departmentView.lecturerDetailsQueryListener(new LecturerDetailsQueryListener());
					
				}
				
			} 
			catch (Exception e1) { 
				
				departmentView.displayError("Please Select Lecturer Type"); 
				
			}
			
		}
  
	}
	 

	class LoginListener implements ActionListener{																// Listener for Login Button
		
		public void actionPerformed(ActionEvent e) {
			
			try {
				
				String logInStatus = User.verifyLogin(logInView.getUsername(),logInView.getPassword());
				
				
				if(logInStatus.equals("logInPass")) {
					
					user = User.getUser(logInView.getUsername());
					
					if(user instanceof HRStaff) {
						
						logInView.getFrame().setVisible(false);
						hrStaffView.getFrame().setVisible(true);
						hrStaffView.queryDepartmentListener(new QueryDepartmentListner());
						hrStaffView.queryLecturerListener(new QueryLecturerListener());
						hrStaffView.addDepartmentViewListener(new AddDepartmentViewListener());
						hrStaffView.modifyDepartmentViewListener(new ModifyDepartmentViewListener());
						hrStaffView.removeDepartmentListener(new RemoveDepartmentListener());
//						hrStaffView.comboBoxMouseListener(new ComboBoxMouseDepartmentTypeListener());
						hrStaffView.addLecturerViewListener(new AddLecturerViewListener());
						hrStaffView.modifyLecturerViewListener(new ModifyLecturerViewListener());
						hrStaffView.removeLecturerListener(new RemoveLecturerListener());
						hrStaffView.closeHRStaffViewListener(new CloseDepartmentViewListener());
					
						List departments = Department.getListOfNames();												// Setting the ComboxDepartment with correct department list
						hrStaffView.setComboBoxDepartment(departments);	
						
					}
					else if(user instanceof Department) {
						
						logInView.getFrame().setVisible(false);
						departmentView.getFrame().setVisible(true);
						departmentView.queryListener(new QueryListener());
						departmentView.setLblDepartment("Department: "+((Department)user).getName()+"     "+"	Username: "+ user.getUserName());
						departmentView.closeDepartmentViewListener(new CloseDepartmentViewListener());
						
					}
					else {
						
						logInView.displayError("Login Error");
						
					}
					
					logInView.setUsername("");
					logInView.setPassword("");
					
				}
				else
					logInView.displayError(logInStatus);
			}
			catch(NumberFormatException ex) {
				
				System.out.println(ex);
				
			}
			
		}
		
	}

}

