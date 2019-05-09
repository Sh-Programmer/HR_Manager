/**
 * Main Class Project
 */

import views.*;
import views.hrStaff.AddDepartmentView;
import views.hrStaff.AddLecturerView;
import views.hrStaff.ModifyDepartmentView;
import views.hrStaff.ModifyLecturerView;


public class Main {
	public static void main(String[] args) {

		StartUpView startUpView = new StartUpView();										// All the views that will be needed to initialize for the program
		LogInView logInVIew = new LogInView();
		DepartmentView departmentView = new DepartmentView();
		HRStaffView hrStaffView = new HRStaffView();
		AddDepartmentView addDepartmentView = new AddDepartmentView();
		ModifyDepartmentView modifyDepartmentView = new ModifyDepartmentView();
		AddLecturerView addLecturerView = new AddLecturerView();
		ModifyLecturerView modifyLecturerView = new ModifyLecturerView();
		
		startUpView.getFrame().setVisible(true);											// For the Start Up View
		
		for(int i=1;i<=100;i++) {
			
			try{
				
				Thread.sleep(30);
				startUpView.getProgressBar().setValue(i);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		startUpView.getFrame().setVisible(false);											
		logInVIew.getFrame().setVisible(true);
		
		Controller controller = new Controller(logInVIew, departmentView, hrStaffView, 		// Giving the control to the Controller
				addDepartmentView, modifyDepartmentView, addLecturerView, modifyLecturerView);
		
	}
		
}
