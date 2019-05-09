
/**
 * View - Lecturer Details View Class
 */

package views.department;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LecturerDetailsView {

	private JFrame frame;
	private JTable table;


	public LecturerDetailsView() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLectuererDetails = new JLabel("Lectuerer Details");
		lblLectuererDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblLectuererDetails.setBounds(134, 11, 151, 14);
		frame.getContentPane().add(lblLectuererDetails);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(178, 266, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
	}

	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public void setTable(Object[][] obj) {
		String[] columnNames = {"Parameters","Details"};
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(110, 40, 245, 150);
		table = new JTable(obj,columnNames);
		//table.setBounds(116, 42, 245, 187);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		System.out.println("Set Table");
	}
}
