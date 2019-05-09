
/**
 * View - Add Department Class 
 */

package views.hrStaff;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddDepartmentView {

	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldWebAddress;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JButton btnCreateDepartment;
	private JComboBox comboBoxDepartmentType;

	public AddDepartmentView() {
		
		frame = new JFrame("Add Department");
		frame.setBounds(100, 100, 500, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnCreateDepartment = new JButton("Create Department");
		btnCreateDepartment.setBounds(176, 212, 147, 23);
		frame.getContentPane().add(btnCreateDepartment);
		
		JLabel lblNewLabel = new JLabel("Name*");
		lblNewLabel.setBounds(41, 43, 48, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Web Address");
		lblNewLabel_1.setBounds(41, 100, 85, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Type of Department*");
		lblNewLabel_2.setBounds(111, 158, 127, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Username*");
		lblNewLabel_3.setBounds(255, 43, 68, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password*");
		lblNewLabel_4.setBounds(255, 100, 68, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(125, 40, 96, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldWebAddress = new JTextField();
		textFieldWebAddress.setBounds(125, 97, 96, 20);
		frame.getContentPane().add(textFieldWebAddress);
		textFieldWebAddress.setColumns(10);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(332, 40, 96, 20);
		frame.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(332, 97, 96, 20);
		frame.getContentPane().add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		comboBoxDepartmentType = new JComboBox();
		comboBoxDepartmentType.setModel(new DefaultComboBoxModel(new String[] {"-Please Select-", "Engineering", "Arts", "Science"}));
		comboBoxDepartmentType.setBounds(243, 154, 127, 22);
		frame.getContentPane().add(comboBoxDepartmentType);
	}


	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	public String getTextFieldName() {
		return textFieldName.getText();
	}


	public void setTextFieldName(JTextField textFieldName) {
		this.textFieldName = textFieldName;
	}


	public String getTextFieldWebAddress() {
		return textFieldWebAddress.getText();
	}


	public void setTextFieldWebAddress(JTextField textFieldWebAddress) {
		this.textFieldWebAddress = textFieldWebAddress;
	}


	public String getTextFieldUsername() {
		return textFieldUsername.getText();
	}


	public void setTextFieldUsername(JTextField textFieldUsername) {
		this.textFieldUsername = textFieldUsername;
	}


	public String getTextFieldPassword() {
		return textFieldPassword.getText();
	}


	public void setTextFieldPassword(JTextField textFieldPassword) {
		this.textFieldPassword = textFieldPassword;
	}
	
	
	public void createDepartmentListener(ActionListener createListener) {
		
		btnCreateDepartment.addActionListener(createListener);
	}
	
	public String getComboBoxDepartmentType() {
		return (String)comboBoxDepartmentType.getSelectedItem();
	}

	public void setComboBoxDepartmentType(JComboBox comboBoxDepartmentType) {
		this.comboBoxDepartmentType = comboBoxDepartmentType;
	}
	
	public void displayError(String errorMessage) {
		JOptionPane.showMessageDialog(null, errorMessage);
	}
}
