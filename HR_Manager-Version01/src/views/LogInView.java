
/**
 * View - Login View
 */

package views;

import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

public class LogInView {

	private JFrame frame;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JButton btnLogIn;
	private JPanel panel;

	public LogInView() {
		
		frame = new JFrame("Log In");
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(40, 40, 350, 135);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel.setBounds(91, 43, 64, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_1.setBounds(91, 87, 64, 14);
		panel.add(lblNewLabel_1);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Calibri", Font.BOLD, 12));
		textFieldUsername.setBounds(175, 38, 88, 20);
		panel.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		textFieldPassword = new JPasswordField(10);
		textFieldPassword.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPassword.setFont(new Font("Calibri", Font.BOLD, 11));
		textFieldPassword.setBounds(175, 82, 88, 20);
		panel.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(172, 202, 89, 23);
		frame.getContentPane().add(btnLogIn);
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public String getUsername() {
		return textFieldUsername.getText();
	}
	
	public String getPassword() {
		return textFieldPassword.getText();
	}
	
	public void setUsername(String u) {
		textFieldUsername.setText(u);
	}
	
	public void setPassword(String p) {
		textFieldPassword.setText(p);
	}

	public void logInListener(ActionListener loginListener) {
		btnLogIn.addActionListener(loginListener);
	}
	
	public void displayError(String errorMessage) {
		JOptionPane.showMessageDialog(null, errorMessage);
	}
	
}
