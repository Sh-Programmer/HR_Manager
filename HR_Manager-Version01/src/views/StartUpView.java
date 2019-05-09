
/**
 * Start Up Window Class
 */

package views;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JProgressBar;

public class StartUpView {

	private JWindow frame;
	private JProgressBar progressBar;
	

	public StartUpView() {
		frame = new JWindow();
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHrManager = new JLabel("HR Manager of Northampton Metropolitan University");
		lblHrManager.setFont(new Font("Calibri", Font.BOLD, 14));
		lblHrManager.setHorizontalAlignment(SwingConstants.CENTER);
		lblHrManager.setBounds(38, 44, 359, 41);
		frame.getContentPane().add(lblHrManager);
		
		JLabel lblStartingUp = new JLabel("Loading...");
		lblStartingUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartingUp.setBounds(163, 236, 102, 33);
		frame.getContentPane().add(lblStartingUp);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(141, 224, 146, 14);
		frame.getContentPane().add(progressBar);
		
		try {
			
			BufferedImage image = ImageIO.read(new File("data/Images/Logo.png"));
			JLabel panel = new JLabel();
			panel.setBounds(153, 85, 118, 115);
			Image scaledImage = image.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_SMOOTH);
			panel = new JLabel(new ImageIcon(scaledImage));
			panel.setBounds(153, 85, 118, 115);
			frame.getContentPane().add(panel);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public JWindow getFrame() {
		return frame;
	}

	public void setFrame(JWindow frame) {
		this.frame = frame;
	}
	
	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}
}
