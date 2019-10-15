package com.vastika.userinfosystem.basic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.vastika.userinfosystem.dao.LoginDao;
import com.vastika.userinfosystem.dao.LoginDaoImpl;
import com.vastika.userinfosystem.model.Login;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UserLogin frame = new UserLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UserLogin() {
		setResizable(false);
		setTitle("User Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 171);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usernameLbl = new JLabel("Username");
		usernameLbl.setBounds(26, 18, 107, 29);
		contentPane.add(usernameLbl);
		
		JLabel passwordLbl = new JLabel("Password");
		passwordLbl.setBounds(26, 54, 107, 29);
		contentPane.add(passwordLbl);
		
		textField = new JTextField();
		textField.setBounds(155, 19, 250, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(155, 55, 250, 28);
		contentPane.add(passwordField);
		
		JButton loginBtn = new JButton("Log In");
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginDao loginDao = new LoginDaoImpl();
				Login login = new Login();
			}
		});
		loginBtn.setBounds(197, 95, 130, 29);
		contentPane.add(loginBtn);
	}
}
