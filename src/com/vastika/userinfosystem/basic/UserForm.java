package com.vastika.userinfosystem.basic;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import com.vastika.userinfosystem.dao.UserDao;
import com.vastika.userinfosystem.dao.UserDaoImpl;
import com.vastika.userinfosystem.model.User;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserForm extends JFrame 
{
	private static final long serialVersionUID = 1L;
	public JLabel id;
	public JPanel unamefield;
	public JTextField user_name;
	public JTextField password;
	public JTextField email;
	public JRadioButton gender_male;
	public JRadioButton gender_female;
	public JCheckBox reading_box;
	public JCheckBox playing_box;
	public JComboBox<String>nationality;				// generalize with String
	public JDateChooser dob;
	private JButton cancelBtn;

	/**
	 * Launch the application(main method form UserForm Class) moved to UserTable to open from there.
	 */
//	public static void main(String[] args) 
//	{
//		EventQueue.invokeLater(new Runnable() 
//		{
//			public void run() 
//			{
//				try 
//				{
//					UserForm frame = new UserForm();		// this main method is moved to UserTable to access and launch from there.
//					frame.setVisible(true);
//				} 
//				catch (Exception e) 
//				{
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/** Create the frame */
	
	public UserForm() 
	{
		setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		setResizable(false);
		setTitle("User Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
		setSize(470, 500);
		setLocationRelativeTo(null);
		
		unamefield = new JPanel();
		setContentPane(unamefield);
		unamefield.setLayout(null);
		
		JLabel usernameLbl = new JLabel("User Name");
		usernameLbl.setForeground(Color.BLUE);
		usernameLbl.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		usernameLbl.setBounds(52, 59, 148, 16);
		unamefield.add(usernameLbl);
		
		user_name = new JTextField();
		user_name.setBackground(Color.LIGHT_GRAY);
		user_name.setBounds(198, 54, 242, 26);
		unamefield.add(user_name);
		user_name.setColumns(10);
		
		JLabel passwordLbl = new JLabel("Password");
		passwordLbl.setForeground(Color.BLUE);
		passwordLbl.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		passwordLbl.setBounds(52, 87, 100, 26);
		unamefield.add(passwordLbl);
		
		password = new JTextField();
		password.setBackground(Color.LIGHT_GRAY);
		password.setBounds(198, 87, 242, 26);
		unamefield.add(password);
		password.setColumns(10);
		
		JLabel emailLbl = new JLabel("Email\n");
		emailLbl.setForeground(Color.BLUE);
		emailLbl.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		emailLbl.setBounds(52, 125, 148, 16);
		unamefield.add(emailLbl);
		
		email = new JTextField();
		email.setBackground(Color.LIGHT_GRAY);
		email.setColumns(10);
		email.setBounds(198, 120, 242, 26);
		unamefield.add(email);
		
		JLabel genderLbl = new JLabel("Gender");
		genderLbl.setForeground(Color.BLUE);
		genderLbl.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		genderLbl.setBounds(52, 169, 61, 16);
		unamefield.add(genderLbl);
		
		gender_male = new JRadioButton("Male");
		gender_male.setSelected(true);
		gender_male.setBounds(198, 165, 70, 23);
		unamefield.add(gender_male);
		
		gender_female = new JRadioButton("Female");
		gender_female.setBounds(290, 165, 83, 23);
		unamefield.add(gender_female);
			
		ButtonGroup genderGroup = new ButtonGroup();					// creating genderGroup method to select either or  button.
		genderGroup.add(gender_male);
		genderGroup.add(gender_female);
		
		JLabel hobbiesLbl = new JLabel("Hobbies");
		hobbiesLbl.setForeground(Color.BLUE);
		hobbiesLbl.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		hobbiesLbl.setBounds(52, 197, 61, 16);
		unamefield.add(hobbiesLbl);
		
		reading_box = new JCheckBox("Reading");
		reading_box.setBounds(198, 193, 83, 23);
		unamefield.add(reading_box);
		
		playing_box = new JCheckBox("Playing");
		playing_box.setBounds(290, 193, 83, 23);
		unamefield.add(playing_box);
		
		JLabel nationalityCombolbl = new JLabel("Nationality");
		nationalityCombolbl.setForeground(Color.BLUE);
		nationalityCombolbl.setFont(new Font("Times New Roman", Font.BOLD, 13));
		nationalityCombolbl.setBounds(52, 235, 100, 16);
		unamefield.add(nationalityCombolbl);
		
		nationality = new JComboBox<>();
		nationality.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		nationality.setModel(new DefaultComboBoxModel<>(new String[] {"USA", "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Central African Republic (CAR)", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo, Democratic Republic of the", "Congo, Republic of the", "Costa Rica", "Cote d'Ivoire", "Croatia", "Cuba", "Cyprus", "Czechia", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "tKazakhstan", "tKenya", "tKiribati", "tKosovo", "tKuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Korea", "North Macedonia", "Norway", "Oman", "Pakistan", "Palau", "Palestine", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Korea", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Timor-Leste", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates (UAE)", "United Kingdom (UK)", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City (Holy See)", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe", ""}));
		nationality.setBounds(198, 231, 181, 27);
		unamefield.add(nationality);
		
		JLabel dobLbl = new JLabel("DOB");
		dobLbl.setForeground(Color.BLUE);
		dobLbl.setFont(new Font("Times New Roman", Font.BOLD, 13));
		dobLbl.setBounds(52, 263, 100, 16);
		unamefield.add(dobLbl);
		
		dob = new JDateChooser();
		dob.setBorder(null);
		dob.setDateFormatString("MM/dd/YYYY");
		dob.setBounds(198, 263, 175, 26);
		unamefield.add(dob);
		
		id = new JLabel("");
		id.setBounds(16, 6, 61, 16);
		unamefield.add(id);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{			 
			 UserDao userDao = new UserDaoImpl();
			 User user = new User();
			 
			 user.setUser_name(user_name.getText());
			 user.setPassword(password.getText());			// or user.setPassword(new String(password.getPassword())); if you have user field as Password
			 user.setEmail(email.getText());
			 
			 if(gender_male.isSelected()) 
				{
					user.setGender(gender_male.getText());
				}
				else
				{
					user.setGender(gender_female.getText());
				}
			 
			 String hobbies = " ";
			 if (reading_box.isSelected()) 
			 {
				 hobbies = hobbies + reading_box.getText() + ", ";
			 }
			 
			 if (playing_box.isSelected()) 
			 {
				 hobbies = hobbies + playing_box.getText();
			 }
			 user.setHobbies(hobbies);
			 
			 user.setNationality((String)nationality.getSelectedItem());
			 user.setDob(dob.getDate());	
			 String userId = id.getText();
			
			
			if(userId == null || userId.isEmpty()) {
				 int saved = userDao.saveUser(user);
				 
				 if(saved >=1) {
					 JOptionPane.showMessageDialog(new UserForm(), "User Info saved Successfully", "saved", JOptionPane.PLAIN_MESSAGE);	
					 UserTable userTable = new UserTable();
					 userTable.setVisible(true);
					 dispose();
				 }
				 else {
					 JOptionPane.showMessageDialog(new UserForm(), "OOPS ! ERROR occured !", "ERROR", JOptionPane.PLAIN_MESSAGE);
				 }
			}else {
				user.setId(Integer.parseInt(userId));    					// adding Id and parsing the value as Integer.
				 int updated = userDao.updateUser(user);
				 
				 if(updated >=1) {
					 JOptionPane.showMessageDialog(new UserForm(), "User Info updated Successfully", "Updated", JOptionPane.PLAIN_MESSAGE);	
					 UserTable userTable = new UserTable();
					 userTable.setVisible(true);
					 dispose();
				 }else {
					 JOptionPane.showMessageDialog(new UserForm(), "OOPS ! ERROR occured !", "ERROR", JOptionPane.PLAIN_MESSAGE);
				 }
				 }
			}
		});
		
		submitBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		submitBtn.setBounds(323, 426, 117, 29);
		unamefield.add(submitBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thank you for using Anil's Form");
				dispose();
			}
		});
		cancelBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		cancelBtn.setBounds(194, 427, 117, 29);
		unamefield.add(cancelBtn);
	}
}
