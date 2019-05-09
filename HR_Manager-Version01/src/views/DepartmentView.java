
/**
 * Department Secretary View
 */

package views;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.util.List;


import models.Lecturer;
import models.lecturer.LecturerType;

public class DepartmentView {

	private JFrame frame;
	private JTable table;
	private JTextField txtFieldStaffID;
	private JButton btnQuery;
	private JScrollPane scrollPane;
	private JComboBox comboBox;
	private ListSelectionModel rowSelectionModel;
	private JLabel lblDepartment;
	
	public DepartmentView() {
		frame = new JFrame("Department");
		frame.setBounds(100, 100, 650, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblDepartment = new JLabel("");
		lblDepartment.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepartment.setFont(new Font("Calibri", Font.BOLD, 15));
		lblDepartment.setBounds(56, 11, 521, 22);
		frame.getContentPane().add(lblDepartment);
		
		txtFieldStaffID = new JTextField();
		txtFieldStaffID.setColumns(10);
		txtFieldStaffID.setBounds(157, 71, 97, 22);
		frame.getContentPane().add(txtFieldStaffID);
		
		comboBox = new JComboBox();
		comboBox.addItem("-Please Select-");
		comboBox.addItem(LecturerType.FULL_TIME);
		comboBox.addItem(LecturerType.PART_TIME);
		comboBox.addItem(LecturerType.CONTRACT);
		comboBox.setBounds(408, 70, 115, 24);
		frame.getContentPane().add(comboBox);
		
		btnQuery = new JButton("Query");
		btnQuery.setBounds(261, 103, 90, 24);
		frame.getContentPane().add(btnQuery);
		
		
		scrollPane = new JScrollPane();
		table = new JTable();
		scrollPane.setBounds(56, 159, 523, 259);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Staff ID");
		lblNewLabel.setBounds(84, 75, 48, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Lecturer Type");
		lblNewLabel_2.setBounds(313, 75, 97, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(58, 135, 521, -2);
		frame.getContentPane().add(panel);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		horizontalBox.setBounds(56, 59, 523, 80);
		frame.getContentPane().add(horizontalBox);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		horizontalBox_1.setBounds(57, 159, 522, 259);
		frame.getContentPane().add(horizontalBox_1);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		horizontalBox_2.setBounds(0, 0, 634, 461);
		frame.getContentPane().add(horizontalBox_2);
	}
	
	public void displayError(String errorMessage) {
		JOptionPane.showMessageDialog(null, errorMessage);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public String getTextFieldStaffID() { 
		 return txtFieldStaffID.getText(); 
	}
	
	public ListSelectionModel getRowSelectionModel() {
		return rowSelectionModel;
	}
	  
	public LecturerType getComboBoxLectureType() { 
		if(comboBox.getSelectedItem().toString() == "FULL_TIME")
		return LecturerType.FULL_TIME;
		else if(comboBox.getSelectedItem().toString() == "PART_TIME")
			return LecturerType.PART_TIME;
		else if(comboBox.getSelectedItem().toString() == "CONTRACT")
			return LecturerType.CONTRACT;
		else
			return null;
	}
	 
	public void setTable(List<Lecturer> lecturers) {															
		if(lecturers == null) {System.out.println("Null!!!");}
		else {
			
			String[] columnNames = {"ID","name","Lecture Type","Phone Number","Email Address"};
			Object[][] data = new Object[lecturers.size()][];
			
			for( int i=0;i<lecturers.size();i++) {
				
				 Object[] d = {lecturers.get(i).getStaffID(), lecturers.get(i).getName(), 
						 lecturers.get(i).getLecturerType().toString(), lecturers.get(i).getPhoneNumber(),
						 lecturers.get(i).getEmailAddress()};
				 data[i] = d;
				
			}
		
			frame.remove(scrollPane);
			scrollPane = new JScrollPane();
			scrollPane.setBounds(56, 151, 523, 267);
			table = new JTable(data,columnNames);
			table.setRowSelectionAllowed(true);
			rowSelectionModel = table.getSelectionModel();
		    rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			frame.getContentPane().add(scrollPane);
			scrollPane.setViewportView(table);

			
		}
	}

	public JTable getTable() {
		return table;
	}

	public void setLblDepartment(String lblDepartment) {
		this.lblDepartment.setText(lblDepartment);
	}
	
	public void closeDepartmentViewListener(WindowAdapter wA) {
		frame.addWindowListener(wA);
	}
	
	public void queryListener(ActionListener queryListener) {
		 btnQuery.addActionListener(queryListener); 
	}
	
	public void lecturerDetailsQueryListener(ListSelectionListener listSectionListener) {
		
		rowSelectionModel.addListSelectionListener(listSectionListener);
	}
}
