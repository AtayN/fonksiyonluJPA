package folder;

import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class guiiLogin1 {
	static EntityManagerFactory factory;
	static EntityManager manager;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiiLogin1 window = new guiiLogin1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con = null;
	private JTextField userTextField;
	private JPasswordField passwordField_1;

	/**
	 * Create the application.
	 */
	public guiiLogin1() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 637, 321);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		userTextField = new JTextField();
		userTextField.setBounds(325, 71, 86, 20);
		frame.getContentPane().add(userTextField);
		userTextField.setColumns(10);

		JLabel userLabel = new JLabel("user name :");
		userLabel.setBounds(189, 74, 101, 14);
		frame.getContentPane().add(userLabel);

		JLabel passswordLabel = new JLabel("password  :");
		passswordLabel.setBounds(189, 105, 101, 14);
		frame.getContentPane().add(passswordLabel);

		JButton btnNewButton = new JButton("login!");
		// Image img = new
		// ImageIcon(this.getClass().getResource("/tick.png")).getImage();
		// btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					factory = Persistence.createEntityManagerFactory("fonksiyonluJPA");
					manager = factory.createEntityManager();

					manager.getTransaction().begin();

					Query query = manager.createQuery("SELECT e FROM satici e where e.isim='" + userTextField.getText()
							+ "' and e.sifre='" + passwordField_1.getText() + "'");

					List<satici> list = (List<satici>) query.getResultList();
					siparisGui.tut = list.get(0);

					// satici list = (satici) query.getSingleResult();
					//
					if (list.size() == 1) {

						JOptionPane.showMessageDialog(null, "user name or password is correct.");
						frame.dispose();
						siparisGui secondf = new siparisGui();
						secondf.setVisible(true);

					} else
						JOptionPane.showMessageDialog(null, "user name or password is incorrect.");

				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, e1);

				}
			}
		});
		btnNewButton.setBounds(220, 148, 222, 58);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("");
		// Image img1 = new
		// ImageIcon(this.getClass().getResource("/laptop.png")).getImage();
		// lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(21, 37, 158, 171);
		frame.getContentPane().add(lblNewLabel);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(325, 102, 86, 20);
		frame.getContentPane().add(passwordField_1);
	}
}
