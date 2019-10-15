package com.vastika.userinfosystem.basic;

import java.awt.EventQueue;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.vastika.userinfosystem.dao.UserDao;
import com.vastika.userinfosystem.dao.UserDaoImpl;
import com.vastika.userinfosystem.model.User;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class UserTable extends JFrame 
{
    public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTable table;
	UserDao userDao = new UserDaoImpl();

	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				try{
					UserTable frame = new UserTable();
					frame.setVisible(true);
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		});	
	}
	public UserTable() {
		setTitle("User Information Table");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setLocationRelativeTo(null);							// to open in the center of the page.
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(35, 20, 750, 450);
		String [] columns = {"Id", "Username", "Password", "Email", "Gender", "Hobbies", "Dob", "Nationality"};
		DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
		table.setModel(tableModel);
		
		loadDataInTable();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 11, 774, 390);
		contentPane.add(scrollPane);
		
		JButton newBtn = new JButton("New ");
		newBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserForm userForm = new UserForm();
				userForm.setVisible(true);
				dispose();		
			}
		});
		newBtn.setBounds(399, 413, 117, 29);
		contentPane.add(newBtn);
		
		
		JButton editBtn = new JButton("Edit");
		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				int selectedRow = table.getSelectedRow();
				
				if(selectedRow != -1) {
				
						Object id = tableModel.getValueAt(selectedRow, 0);
						Object user_name = tableModel.getValueAt(selectedRow, 1);
						Object password = tableModel.getValueAt(selectedRow, 2);
						Object email = tableModel.getValueAt(selectedRow, 3);
						Object gender = tableModel.getValueAt(selectedRow, 4);
						Object hobbies = tableModel.getValueAt(selectedRow, 5);
						Object dob = tableModel.getValueAt(selectedRow, 6);
						Object nationality = tableModel.getValueAt(selectedRow, 7);
				
						
						// create object of the class UserForm to access all the field from the UserForm..
						
						UserForm userForm = new UserForm();					 
						userForm.id.setText(id.toString());
						userForm.user_name.setText(user_name.toString());
						userForm.password.setText(password.toString());
						userForm.email.setText(email.toString());
						userForm.nationality.setSelectedItem(nationality);
						
						if(gender.equals("Male")){
						userForm.gender_male.setSelected(true);
						} else {
							userForm.gender_female.setSelected(true);
						}
						
						String [] hobby = hobbies.toString().split(",");
						for(String h : hobby) {
							if(h.contentEquals("Reading")) {
								userForm.reading_box.setSelected(true);
							}
							if(h.contentEquals("Playing")) {
								userForm.playing_box.setSelected(true);
							}
						
						try {
							SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
							Date date = sdf.parse(dob.toString());
							userForm.dob.setDate(date);
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
							
						userForm.setVisible(true);
						dispose();
					
						}													
				}
			}
		});
		editBtn.setBounds(528, 413, 117, 29);
		contentPane.add(editBtn);		
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				int selectedRow = table.getSelectedRow();
				
				if(selectedRow != -1) {
					int deleteConfirm = JOptionPane.showConfirmDialog(new UserTable(), "Are you sure you want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
					
					if (deleteConfirm == 0){
					Object id = tableModel.getValueAt(selectedRow, 0);
					userDao.deleteUserInfo(Integer.parseInt(id.toString()));
					loadDataInTable();
				}
				}else {
					JOptionPane.showMessageDialog(new UserTable(), "Please select any row to delete");
				}
			}
		});
		deleteBtn.setBounds(657, 413, 117, 29);
		contentPane.add(deleteBtn);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Directing to User Form...");
				UserForm userForm = new UserForm();				
				userForm.setVisible(true);			
				dispose();
				
			}
		});
		cancelBtn.setBounds(270, 413, 117, 29);
		contentPane.add(cancelBtn);
	}
	
	public void loadDataInTable() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		List<User> userList = userDao.getAllUserInfo();
		for(User u : userList) {
			tableModel.addRow(new Object[] { u.getId(), u.getUser_name(), u.getPassword(), u.getEmail(), u.getGender(), u.getHobbies(), u.getDob(), u.getNationality()});
		}	
	}
}