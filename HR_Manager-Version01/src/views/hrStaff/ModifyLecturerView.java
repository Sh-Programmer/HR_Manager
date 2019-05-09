
/**
 * View - Modify Lecturer View Class 
 */
package views.hrStaff;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ModifyLecturerView {
	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldAddress;
	private JTextField textFieldPhoneNumber;
	private JTextField textFieldEmailAddress;
	private JTextField textFieldSalary;
	private JTextField textFieldHourlyRate;
	private JTextField textFieldContractFinishDate;
	private JTextField textFieldStartedDate;
	private JLabel lblStartedDate;
	private JLabel lblStaffID;
	private JButton btnUpdateLecturer;
	private JLabel lblLectureType;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;

	
	public ModifyLecturerView() {
		
		frame = new JFrame("Change Details of the Lecturer");
		frame.setBounds(100, 100, 600, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Staff ID");
		lblNewLabel.setBounds(69, 76, 48, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(69, 134, 48, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setBounds(69, 205, 48, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		lblNewLabel_3.setBounds(69, 274, 79, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Lecturer Type");
		lblNewLabel_4.setBounds(317, 76, 84, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email Address");
		lblNewLabel_5.setBounds(317, 134, 84, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Salary");
		lblNewLabel_6.setBounds(317, 205, 48, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Hourly Rate");
		lblNewLabel_7.setBounds(317, 274, 84, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Contract Finish Date");
		lblNewLabel_8.setBounds(297, 333, 109, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(159, 131, 96, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(159, 202, 96, 20);
		frame.getContentPane().add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setBounds(158, 270, 96, 20);
		frame.getContentPane().add(textFieldPhoneNumber);
		textFieldPhoneNumber.setColumns(10);
		
		textFieldEmailAddress = new JTextField();
		textFieldEmailAddress.setBounds(411, 131, 96, 20);
		frame.getContentPane().add(textFieldEmailAddress);
		textFieldEmailAddress.setColumns(10);
		
		textFieldSalary = new JTextField();
		textFieldSalary.setBounds(411, 202, 96, 20);
		frame.getContentPane().add(textFieldSalary);
		textFieldSalary.setColumns(10);
		
		textFieldHourlyRate = new JTextField();
		textFieldHourlyRate.setBounds(411, 270, 96, 20);
		frame.getContentPane().add(textFieldHourlyRate);
		textFieldHourlyRate.setColumns(10);
		
		textFieldContractFinishDate = new JTextField();
		textFieldContractFinishDate.setBounds(411, 329, 96, 20);
		frame.getContentPane().add(textFieldContractFinishDate);
		textFieldContractFinishDate.setColumns(10);
		
		btnUpdateLecturer = new JButton("Update Lecturer");
		btnUpdateLecturer.setBounds(222, 394, 154, 23);
		frame.getContentPane().add(btnUpdateLecturer);
		
		lblStaffID = new JLabel("");
		lblStaffID.setBounds(159, 76, 96, 14);
		frame.getContentPane().add(lblStaffID);
		
		textFieldStartedDate = new JTextField();
		textFieldStartedDate.setBounds(159, 329, 96, 20);
		frame.getContentPane().add(textFieldStartedDate);
		textFieldStartedDate.setColumns(10);
		
		lblStartedDate = new JLabel("Started Date");
		lblStartedDate.setBounds(69, 332, 79, 14);
		frame.getContentPane().add(lblStartedDate);
		
		lblLectureType = new JLabel("");
		lblLectureType.setBounds(411, 77, 96, 14);
		frame.getContentPane().add(lblLectureType);
		
		label = new JLabel("For Full Time & Contract Lectures Only");
		label.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label.setBounds(347, 224, 164, 14);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("For Part Time Lectures Only");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_1.setBounds(390, 290, 124, 14);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("For Contract Lectures Only");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_2.setBounds(395, 347, 124, 14);
		frame.getContentPane().add(label_2);
		
		label_3 = new JLabel("(dd/mm/yy)");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_3.setBounds(69, 347, 72, 14);
		frame.getContentPane().add(label_3);
		
		label_4 = new JLabel("(dd/mm/yy)");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_4.setBounds(317, 347, 72, 14);
		frame.getContentPane().add(label_4);
	}


	public String getTextFieldStartedDate() {
		return textFieldStartedDate.getText();
	}


	public JFrame getFrame() {
		return frame;
	}


	public String getLabellStaffID() {
		return lblStaffID.getText();
	}


	public String getTextFieldName() {
		return textFieldName.getText();
	}


	public String getTextFieldAddress() {
		return textFieldAddress.getText();
	}


	public String getTextFieldPhoneNumber() {
		return textFieldPhoneNumber.getText();
	}


	public String getTextFieldEmailAddress() {
		return textFieldEmailAddress.getText();
	}


	public String getTextFieldSalary() {
		return textFieldSalary.getText();
	}


	public String getTextFieldHourlyRate() {
		return textFieldHourlyRate.getText();
	}


	public String getTextFieldContractFinishDate() {
		return textFieldContractFinishDate.toString();
	}
	
	public String getLabellLectureType() {
		return lblLectureType.getText();
	}
	
	public void displayError(String errorMessage) {
		JOptionPane.showMessageDialog(null, errorMessage);
	}

	public void setTextFieldName(String textFieldName) {
		this.textFieldName.setText(textFieldName);;
	}


	public void setTextFieldAddress(String textFieldAddress) {
		this.textFieldAddress.setText(textFieldAddress);;
	}


	public void setTextFieldPhoneNumber(String textFieldPhoneNumber) {
		this.textFieldPhoneNumber.setText(textFieldPhoneNumber);;
	}


	public void setTextFieldEmailAddress(String textFieldEmailAddress) {
		this.textFieldEmailAddress.setText(textFieldEmailAddress);;
	}


	public void setTextFieldSalary(String textFieldSalary) {
		this.textFieldSalary.setText(textFieldSalary);;
	}


	public void setTextFieldHourlyRate(String textFieldHourlyRate) {
		this.textFieldHourlyRate.setText(textFieldHourlyRate);;
	}


	public void setTextFieldContractFinishDate(String textFieldContractFinishDate) {
		this.textFieldContractFinishDate.setText(textFieldContractFinishDate);;
	}


	public void setTextFieldStartedDate(String textFieldStartedDate) {
		this.textFieldStartedDate.setText(textFieldStartedDate);;
	}


	public void setLblStaffID(String lblStaffID) {
		this.lblStaffID.setText(lblStaffID);;
	}


	public void setLblLectureType(String lblLectureType) {
		this.lblLectureType.setText(lblLectureType);
	}
	
	public void updateLecturerListener(ActionListener updateListener) {
		btnUpdateLecturer.addActionListener(updateListener);
	}
}
