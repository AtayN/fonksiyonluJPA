package folder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
public class second extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					second frame = new second();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con1=null;
	Connection con2=null;
	private JTextField nameTextField;
	private JTextField idTextField;
	private JTextField passwordTextField;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JTextField textField;
	private JComboBox comboBox;
	private JMenuBar menuBar;
	public  void refreshTable(){
		
		try {
			
			String sql = "select * from users ";
			
			PreparedStatement ps = con1.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs) );
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	/**
	 * Create the frame.
	 */
	public second() {
		//con1=baglanti.converter();
		//con2=baglanti.converter();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 305);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("file");
		menuBar.add(mnFile);
		
		JCheckBoxMenuItem chckbxmnýtmExit = new JCheckBoxMenuItem("exit");
		chckbxmnýtmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnFile.add(chckbxmnýtmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nameTextField = new JTextField("name");
		nameTextField.setBounds(165, 55, 86, 20);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		idTextField = new JTextField("Id");
		idTextField.setBounds(165, 86, 86, 20);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		
		passwordTextField = new JTextField("pass");
		passwordTextField.setBounds(165, 117, 86, 20);
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JLabel lblUserName = new JLabel("user name :");
		lblUserName.setBounds(53, 56, 86, 14);
		contentPane.add(lblUserName);
		
		lblNewLabel = new JLabel("user Id       :");
		lblNewLabel.setBounds(53, 89, 86, 14);
		contentPane.add(lblNewLabel);
		
		lblPassword = new JLabel("password   :");
		lblPassword.setBounds(53, 120, 86, 14);
		contentPane.add(lblPassword);
		
		JButton btnAdd = new JButton("add");
		btnAdd.setBounds(50, 201, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.setBounds(162, 201, 89, 23);
		btnDelete.setEnabled(false);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.setBounds(278, 201, 89, 23);
		btnUpdate.setEnabled(false);
		contentPane.add(btnUpdate);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"userName", "userId"}));
		comboBox.setBounds(301, 24, 92, 20);
		contentPane.add(comboBox);
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
	try {
					
					String sql = "insert into users (userName,userId,userPassword) values (?,?,?)";
					
					PreparedStatement ps = con2.prepareStatement(sql);
					
					
					ps.setString(1, nameTextField.getText());
					ps.setInt(2,Integer.valueOf(idTextField.getText()) );	
					ps.setString(3, passwordTextField.getText());
								
					ps.execute();			
					ps.close();
					refreshTable();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql ="delete from users where userId=? ";
				int  action =JOptionPane.showConfirmDialog(null, "do you really want to delete ? ","delete",JOptionPane.YES_NO_OPTION);
				if (action==0){
				try {
					
					PreparedStatement ps= con2.prepareStatement(sql);
					
					ps.setInt(1,Integer.valueOf(idTextField.getText()));
					ps.execute();
					JOptionPane.showMessageDialog(null, "kayýt silindi.");
					ps.close();
					refreshTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}}
		});
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String sql = "update users set userName=? , userPassword=? where userId=? ";
				
				try {
					PreparedStatement ps = con2.prepareStatement(sql);
					ps.setString(1	,nameTextField.getText());
					ps.setString(2, passwordTextField.getText());
					ps.setInt(3, Integer.valueOf(idTextField.getText()));
					
			
					ps.execute();
					ps.close();
					refreshTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(301, 55, 248, 122);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 int selectedRowIndex = table.getSelectedRow(); 
				  int selectedColumnIndex = table.getSelectedColumn(); 
				    Object selectedObject = (Object) table.getModel().getValueAt(selectedRowIndex, 2);
				
				    try {
						PreparedStatement prs =con1.prepareStatement("select userName , userId from users where userId="+String.valueOf(selectedObject));
						ResultSet rs=   prs.executeQuery();
						while (rs.next())
						{
						
						nameTextField.setText(rs.getString("userName"));
						idTextField.setText(rs.getString("userId"));
						btnDelete.setEnabled(true);
						btnUpdate.setEnabled(true);
						}
						prs.close();
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    
				    
				    
			}
		});
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				
				  try {
					  String list = (String)comboBox.getSelectedItem();
					  	
					  
						PreparedStatement prs =con1.prepareStatement("select * from users where "+list+"="+"?");
						prs.setString(1,textField.getText() );
						ResultSet rs=prs.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs) );
								
								
						
						
					/*	while (rs.next())
						{
						
						
					
					
						}*/
						prs.close();
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    
				
				
				
			}
		});
		textField.setBounds(403, 24, 146, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		refreshTable();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
