package paperProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;

public class SubmitPaper {

	public JFrame frame;
	private JTextField textField;
	private JButton btnUpload;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubmitPaper window = new SubmitPaper();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SubmitPaper() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnUpload = new JButton("Upload");
		btnUpload.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnUpload.setBounds(459, 64, 117, 29);
		frame.getContentPane().add(btnUpload);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(114, 64, 315, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnLogout.setBounds(577, 6, 117, 29);
		frame.getContentPane().add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        		frame.dispose();
	        		Login login = new Login();
	        		login.frame.setVisible(true);
	        }
	    });
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 118, 619, 210);
		frame.getContentPane().add(scrollPane);
		
		JList reviewerList = new JList();
		scrollPane.setViewportView(reviewerList);
		
		JButton btnSelectReviewers = new JButton("Submit Reviewers");
		btnSelectReviewers.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnSelectReviewers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int arr[]=reviewerList.getSelectedIndices();
				//USE THESE INDICES TO VIEW WHICH REVIEWERS WERE SELECTED
			}
		});
		btnSelectReviewers.setBounds(162, 358, 173, 29);
		frame.getContentPane().add(btnSelectReviewers);
		
		JButton btnSubmitConflict = new JButton("Submit Conflicts");
		btnSubmitConflict.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnSubmitConflict.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int arr[]=reviewerList.getSelectedIndices();
				//USE THESE INDICES TO VIEW WHICH REVIEWERS WERE SELECTED
			}
		});
		btnSubmitConflict.setBounds(364, 358, 173, 29);
		frame.getContentPane().add(btnSubmitConflict);
		
		JButton btnSubmitPaper = new JButton("Submit Paper");
		btnSubmitPaper.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnSubmitPaper.setBounds(287, 419, 117, 29);
		frame.getContentPane().add(btnSubmitPaper);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnBack.setBounds(6, 6, 117, 29);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        		frame.dispose();
	        		AuthorShell shell = new AuthorShell();
	        		shell.frame.setVisible(true);
	        }
	    });
		
		addButtonPurposes();
		
	}
	private void addButtonPurposes() {
		btnUpload.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	JFileChooser fc = new JFileChooser();
	            fc.setVisible(true);
	            int val = fc.showDialog(null,"Choose");
	            if(val == JFileChooser.APPROVE_OPTION) {
	            	File file = fc.getSelectedFile();
	            	textField.setText(file.getName());
	            }
	        }
	    });
	}
}
