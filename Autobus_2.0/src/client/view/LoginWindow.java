package client.view;

import java.awt.Color;
import javax.swing.*;
import java.awt.Insets;
import java.rmi.RemoteException;

/**
 * Created by lenovo on 4/20/2017.
 */
public class LoginWindow  extends Window {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnLogIn;
	private JTextField textField;
	private JPasswordField passwordField;

	public void initComponents(){
		setBackground(new Color(95, 158, 160));
		setBounds(0, 0, 400, 250);
		setLayout(null);
		
		JButton btnTopImg = new JButton("");
		btnTopImg.setVerticalAlignment(SwingConstants.TOP);
		btnTopImg.setMargin(new Insets(0, 0, 0, 0));
		btnTopImg.setContentAreaFilled(false);
		btnTopImg.setIcon(new ImageIcon(LoginWindow.class.getResource("/ressources/autobus_login.png")));
		btnTopImg.setBounds(0, 0, 400, 73);
		add(btnTopImg);
		
		JLabel lblEmailAdd = new JLabel("Email Address:");
		lblEmailAdd.setForeground(Color.WHITE);
		lblEmailAdd.setBounds(63, 109, 80, 14);
		add(lblEmailAdd);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(63, 149, 80, 14);
		add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(153, 106, 164, 20);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(153, 146, 164, 20);
		add(passwordField);
		
		btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(153, 193, 89, 23);
		add(btnLogIn);
		
	}
	
	public void createEvents(){
		
		btnLogIn.addActionListener(e ->{
			String username = textField.getText();
			String password = passwordField.getText();
			try {
				controller.login(username,password);
			} catch (RemoteException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(LoginWindow.this,"Failed to log in. Could not contact the server.");
			}

		});
	}

	@Override
	public void showLogin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showMain() {
		// TODO Auto-generated method stub
		view.setCurrentWindow(MAIN);
	}


	@Override
	public void loadData() {
		// TODO Auto-generated method stub
		
	}
}
