
/**
 * View - Add Department Class 
 */

package views.hrStaff;

import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class AddLecturerView {

	private JFrame frame;
	private JTextField textFieldStaffID;
	private JTextField textFieldName;
	private JTextField textFieldAddress;
	private JTextField textFieldPhoneNumber;
	private JTextField textFieldEmailAddress;
	private JTextField textFieldSalary;
	private JTextField textFieldHourlyRate;
	private JTextField textFieldContractFinishDate;
	private JComboBox comboBoxLecturerType;
	private JTextField textFieldStartedDate;
	private JLabel lblStartedDate;
	private JButton btnCreateLecturer;
	private JLabel lblddmmyy;
	private JLabel label;
	private JLabel lblContractLecturesOnly;
	private JLabel label_1;
	private JLabel label_2;

	public String getComboBoxLecturerType() {
		
		return comboBoxLecturerType.getSelectedItem().toString();
	}

	public AddLecturerView() {
		
		frame = new JFrame("Add Lecturer");
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
		lblNewLabel_3.setBounds(69, 277, 79, 14);
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
		lblNewLabel_7.setBounds(317, 277, 84, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Contract Finish Date");
		lblNewLabel_8.setToolTipText("(dd/mm/yy)");
		lblNewLabel_8.setBounds(289, 332, 124, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		textFieldStaffID = new JTextField();
		textFieldStaffID.setBounds(159, 73, 96, 20);
		frame.getContentPane().add(textFieldStaffID);
		textFieldStaffID.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(159, 131, 96, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(159, 202, 96, 20);
		frame.getContentPane().add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setBounds(159, 274, 96, 20);
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
		textFieldHourlyRate.setBounds(411, 274, 96, 20);
		frame.getContentPane().add(textFieldHourlyRate);
		textFieldHourlyRate.setColumns(10);
		
		textFieldContractFinishDate = new JTextField();
		textFieldContractFinishDate.setBounds(411, 329, 96, 20);
		frame.getContentPane().add(textFieldContractFinishDate);
		textFieldContractFinishDate.setColumns(10);
		
		btnCreateLecturer = new JButton("Create Lecturer");
		btnCreateLecturer.setBounds(222, 394, 179, 23);
		frame.getContentPane().add(btnCreateLecturer);
		
		comboBoxLecturerType = new JComboBox();
		comboBoxLecturerType.setModel(new DefaultComboBoxModel(new String[] {"-Please Select-", "Full Time", "Part Time", "Contract"}));
		comboBoxLecturerType.setBounds(411, 72, 96, 22);
		frame.getContentPane().add(comboBoxLecturerType);
		
		textFieldStartedDate = new JTextField();
		textFieldStartedDate.setBounds(159, 329, 96, 20);
		frame.getContentPane().add(textFieldStartedDate);
		textFieldStartedDate.setColumns(10);
		
		lblStartedDate = new JLabel("Started Date");
		lblStartedDate.setToolTipText("(dd/mm/yy)");
		lblStartedDate.setBounds(69, 332, 72, 14);
		frame.getContentPane().add(lblStartedDate);
		
		lblddmmyy = new JLabel("(dd/mm/yyyy)");
		lblddmmyy.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblddmmyy.setBounds(69, 344, 72, 14);
		frame.getContentPane().add(lblddmmyy);
		
		label = new JLabel("(dd/mm/yyyy)");
		label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label.setBounds(317, 344, 72, 14);
		frame.getContentPane().add(label);
		
		lblContractLecturesOnly = new JLabel("For Contract Lectures Only");
		lblContractLecturesOnly.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblContractLecturesOnly.setBounds(398, 346, 124, 14);
		frame.getContentPane().add(lblContractLecturesOnly);
		
		label_1 = new JLabel("For Part Time Lectures Only");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_1.setBounds(392, 291, 124, 14);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("For Full Time & Contract Lectures Only");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_2.setBounds(350, 208, 165, 42);
		frame.getContentPane().add(label_2);
	}

	public String getTextFieldStartedDate() {
		return textFieldStartedDate.getText();
	}


	public JFrame getFrame() {
		return frame;
	}


	public String getTextFieldStaffID() {
		return textFieldStaffID.getText();
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
	
	public void createLecturerListener(ActionListener createListener) {
		btnCreateLecturer.addActionListener(createListener);
	}
	
	public void displayError(String errorMessage) {
		JOptionPane.showMessageDialog(null, errorMessage);
	}
}

