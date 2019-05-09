
/**
 * View - Modify Department Class 
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


public class ModifyDepartmentView {

	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldWebAddress;
	private JTextField textFieldPassword;
	private JButton btnUpdateDepartment;
	private JComboBox comboBoxDepartmentType;
	private JLabel lblUsername;

	public ModifyDepartmentView() {
		
		frame = new JFrame("Change details of the Department");
		frame.setBounds(100, 100, 500, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnUpdateDepartment = new JButton("Update Department");
		btnUpdateDepartment.setBounds(176, 212, 147, 23);
		frame.getContentPane().add(btnUpdateDepartment);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(41, 43, 48, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Web Address");
		lblNewLabel_1.setBounds(41, 100, 84, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Type of Department");
		lblNewLabel_2.setBounds(109, 158, 122, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setBounds(255, 43, 68, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(255, 100, 73, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(125, 40, 96, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldWebAddress = new JTextField();
		textFieldWebAddress.setBounds(125, 97, 96, 20);
		frame.getContentPane().add(textFieldWebAddress);
		textFieldWebAddress.setColumns(10);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(332, 97, 96, 20);
		frame.getContentPane().add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		comboBoxDepartmentType = new JComboBox();
		comboBoxDepartmentType.setModel(new DefaultComboBoxModel(new String[] {"-Please Select-", "Engineering", "Arts", "Science"}));
		comboBoxDepartmentType.setBounds(236, 154, 122, 22);
		frame.getContentPane().add(comboBoxDepartmentType);
		
		lblUsername = new JLabel("-");
		lblUsername.setBounds(333, 43, 74, 14);
		frame.getContentPane().add(lblUsername);
	}
	
	public String getTextFieldName() {
		return textFieldName.getText();
	}
	
	public String getTextFieldPassword() {
		return textFieldPassword.getText();
	}

	public void setTextFieldName(String name) {
		this.textFieldName.setText(name);
	}

	public String getTextFieldWebAddress() {
		return textFieldWebAddress.getText();
	}

	public void setTextFieldWebAddress(String webAddress) {
		textFieldWebAddress.setText(webAddress);
	}

	public String getLblUsername() {
		return lblUsername.getText();
	}

	public void setLblUsername(String username) {
		lblUsername.setText(username);
	}

	public void setLblUsername(JLabel lblUsername) {
		this.lblUsername = lblUsername;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getBtnUpdateDepartment() {
		return btnUpdateDepartment;
	}

	public void setBtnUpdateDepartment(JButton btnUpdateDepartment) {
		this.btnUpdateDepartment = btnUpdateDepartment;
	}

	public String getComboBoxDepartmentType() {
		return comboBoxDepartmentType.getSelectedItem().toString();
	}

	public void setComboBoxDepartmentType(String departmentType) {
		comboBoxDepartmentType.setToolTipText(departmentType);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void updateDepartmentListener(ActionListener updateListener) {
		
		btnUpdateDepartment.addActionListener(updateListener);
	}
	
	public void displayError(String errorMessage) {
		JOptionPane.showMessageDialog(null, errorMessage);
	}
	
}
