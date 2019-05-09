
/**
 * HR Staff View
 */

package views;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.List;
import java.awt.Font;

public class HRStaffView {

	private JFrame frame;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTable tableDepartment;
	private JTable tableLecturer;
	private JComboBox comboBoxDepartment;
	private JLabel lblSelectDepartment;
	private JButton btnAddLecturer;
	private JButton btnModifyLecturer;
	private JButton btnRemoveLecturer;
	private JButton btnQueryLecturer;
	private JButton btnQueryDepartment;
	private JButton btnAddDepartment;
	private JButton btnModifyDepartment;
	private JButton btnRemoveDepartment;
	private JScrollPane scrollPaneDepartment;
	private JScrollPane scrollPaneLecturer;
	private JLayeredPane Department;
	private JLayeredPane Lecturer;

	
	public HRStaffView() {
		frame = new JFrame("HR Staff");
		frame.setBounds(100, 100, 655, 532);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		tabbedPane.setBounds(0, 0, 650, 500);
		frame.getContentPane().add(tabbedPane);
		
		Department = new JLayeredPane();
		tabbedPane.addTab("Department", null, Department, null);
		scrollPaneDepartment = new JScrollPane();
		scrollPaneDepartment.setBounds(41, 149, 550, 276);
		Department.add(scrollPaneDepartment);
		
		tableDepartment = new JTable();
		scrollPaneDepartment.setViewportView(tableDepartment);
		
		btnQueryDepartment = new JButton("Query All Departments");
		btnQueryDepartment.setBounds(216, 25, 186, 23);
		Department.add(btnQueryDepartment);
		
		btnAddDepartment = new JButton("Add Department");
		btnAddDepartment.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAddDepartment.setBounds(69, 73, 137, 23);
		Department.add(btnAddDepartment);
		
		btnModifyDepartment = new JButton("Change Department Details");
		btnModifyDepartment.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnModifyDepartment.setBounds(216, 73, 186, 23);
		Department.add(btnModifyDepartment);
		
		btnRemoveDepartment = new JButton("Remove Department");
		btnRemoveDepartment.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemoveDepartment.setBounds(412, 73, 155, 23);
		Department.add(btnRemoveDepartment);
		
		Lecturer = new JLayeredPane();
		tabbedPane.addTab("Lecturer", null, Lecturer, null);
		scrollPaneLecturer = new JScrollPane();
		scrollPaneLecturer.setBounds(46, 126, 544, 303);
		Lecturer.add(scrollPaneLecturer);
		
		tableLecturer = new JTable();
		scrollPaneLecturer.setViewportView(tableLecturer);
		
		comboBoxDepartment = new JComboBox();
		comboBoxDepartment.setBounds(222, 23, 105, 22);
		Lecturer.add(comboBoxDepartment);
		
		lblSelectDepartment = new JLabel("Select Department");
		lblSelectDepartment.setBounds(94, 27, 128, 14);
		Lecturer.add(lblSelectDepartment);
		
		btnAddLecturer = new JButton("Add New Lecturer");
		btnAddLecturer.setBounds(63, 68, 146, 23);
		Lecturer.add(btnAddLecturer);
		
		btnModifyLecturer = new JButton("Change Lecturer Details");
		btnModifyLecturer.setBounds(230, 68, 173, 23);
		Lecturer.add(btnModifyLecturer);
		
		btnRemoveLecturer = new JButton("Remove Lecturer");
		btnRemoveLecturer.setBounds(422, 68, 146, 23);
		Lecturer.add(btnRemoveLecturer);
		
		btnQueryLecturer = new JButton("Query");
		btnQueryLecturer.setBounds(385, 23, 89, 23);
		Lecturer.add(btnQueryLecturer);
	}
	
	public void displayError(String errorMessage) {
		JOptionPane.showMessageDialog(null, errorMessage);
	}

	public JTable getTableDepartment() {
		return tableDepartment;
	}

	public void setTableDepartment(Object[][] tableData) {
		
		String[] columnNames = {"Name","Username","Web Address","Department Type"};		
		tableDepartment = new JTable(tableData,columnNames);
		tableDepartment.setRowSelectionAllowed(true);
		ListSelectionModel rowSelectionModel = tableDepartment.getSelectionModel();
	    rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		Department.remove(scrollPaneDepartment);
		scrollPaneDepartment = new JScrollPane();
		scrollPaneDepartment.setBounds(41, 149, 550, 276);
		Department.add(scrollPaneDepartment);
		scrollPaneDepartment.setViewportView(tableDepartment);
		
	}

	public JTable getTableLecturer(){
		return tableLecturer;
	}


	public String getComboBoxDepartment() {
		
		return comboBoxDepartment.getSelectedItem().toString();
	}

	public void setComboBoxDepartment(List<String> departments) {
		
		comboBoxDepartment.removeAllItems();
		comboBoxDepartment.addItem("-Please Select-");
		for(String s: departments) {
	
			comboBoxDepartment.addItem(s);
		}
		
	}

	public JLabel getLblSelectDepartment() {
		
		return lblSelectDepartment;
	}

	public void setLblSelectDepartment(JLabel lblSelectDepartment) {
		
		this.lblSelectDepartment = lblSelectDepartment;
	}

	public JTabbedPane getTabbedPane() {
		
		return tabbedPane;
	}

	public JFrame getFrame() {
		
		return frame;
	}

	public void setFrame(JFrame frame) {
		
		this.frame = frame;
	}
	
	public void setTableDepartment(JTable tableDepartment) {
		
		this.tableDepartment = tableDepartment;
	}

	public void queryDepartmentListener(ActionListener queryListener) {
		
		btnQueryDepartment.addActionListener(queryListener); 
	}
	
	public void addDepartmentViewListener(ActionListener addListener) {
		
		btnAddDepartment.addActionListener(addListener); 
	}
	
	public void modifyDepartmentViewListener(ActionListener addListener) {
		
		btnModifyDepartment.addActionListener(addListener); 
	}
	
	public void removeDepartmentListener(ActionListener addListener) {
		
		btnRemoveDepartment.addActionListener(addListener); 
	}
	
	public void setTableLecturer(Object[][] tableData) {

		String[] columnNames = {"Staff ID","Name","Address","Phone Number", "Email Address", "Lecturer Type","Started Date", "Salary","Hourly Rate","Contract Finish Date"};		//Object[] d = {departments.get(i).getName(), departments.get(i).getUserName(),departments.get(i).getWebAddress(),departments.get(i).getType()};
		tableLecturer = new JTable(tableData,columnNames);
		tableLecturer.setRowSelectionAllowed(true);
		ListSelectionModel rowSelectionModel = tableLecturer.getSelectionModel();
	    rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		Lecturer.remove(scrollPaneLecturer);
		scrollPaneLecturer = new JScrollPane();
		scrollPaneLecturer.setBounds(46, 126, 544, 303);
		Lecturer.add(scrollPaneLecturer);
		scrollPaneLecturer.setViewportView(tableLecturer);
		
	}
	
	public void addLecturerViewListener(ActionListener addListener) {
		
		btnAddLecturer.addActionListener(addListener); 
	}
	
	public void modifyLecturerViewListener(ActionListener addListener) {

		btnModifyLecturer.addActionListener(addListener); 
	}
	
	public void removeLecturerListener(ActionListener addListener) {

		btnRemoveLecturer.addActionListener(addListener); 
	}

	public void closeHRStaffViewListener(WindowAdapter wA) {
		
		frame.addWindowListener(wA);
	}
	
	public void queryLecturerListener(ActionListener queryListener) {
		
		btnQueryLecturer.addActionListener(queryListener); 
	}

}
