import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(200, 107, 193, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 145, 193, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email Address:");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblNewLabel.setBounds(89, 112, 99, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblPassword.setBounds(89, 150, 77, 16);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnLogin.setBounds(183, 195, 130, 29);
		frame.getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        		frame.dispose();
	        		AuthorShell shell = new AuthorShell();
	        		shell.frame.setVisible(true);
	        }
	    });
		
		JLabel lblSystemLogin = new JLabel("SYSTEM LOGIN");
		lblSystemLogin.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblSystemLogin.setBounds(171, 26, 162, 42);
		frame.getContentPane().add(lblSystemLogin);

		
		JButton btnCreateAccount = new JButton("Create University Account");
		btnCreateAccount.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreateAccount.setBounds(40, 278, 193, 29);
		frame.getContentPane().add(btnCreateAccount);
		
		JButton btnCreateAuthorAccount = new JButton("Create Author Account");
		btnCreateAuthorAccount.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnCreateAuthorAccount.setBounds(277, 278, 187, 29);
		frame.getContentPane().add(btnCreateAuthorAccount);
	}
}
