package folder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class saticiEkle extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSAdi;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldTekrar;
	static EntityManagerFactory factory;
	static EntityManager manager;
	Connection con = null;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	
	public void refreshTable() {

		try {

			String sql1 = "select sat.sat_id,sat.isim from saticilar sat";

			PreparedStatement ps = con.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					saticiEkle frame = new saticiEkle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public saticiEkle() {
		con = connectionss.Jdbc();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSatcAd = new JLabel("Sat\u0131c\u0131 Ad\u0131     :");
		lblSatcAd.setBounds(33, 55, 72, 14);
		contentPane.add(lblSatcAd);
		
		JLabel lblSifre = new JLabel("Sifre            : ");
		lblSifre.setBounds(33, 80, 72, 14);
		contentPane.add(lblSifre);
		
		JButton btnSaticiEkle = new JButton("Sat\u0131c\u0131 Ekle");
		btnSaticiEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				refreshTable();
				if (passwordField.getText().equals(passwordFieldTekrar.getText())){
				System.out.println("esit");
				
				try {
					factory = Persistence.createEntityManagerFactory("fonksiyonluJPA");
					manager = factory.createEntityManager();

					manager.getTransaction().begin();

					satici saticiEkle =new satici();	
					saticiEkle.setÝsim(textFieldSAdi.getText());
					saticiEkle.setSifre(passwordField.getText());

					manager.persist(saticiEkle);
					manager.getTransaction().commit();
					JOptionPane.showMessageDialog(null, "Satýcý kaydedildi.");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					
				}
			}
				else 
				{
					JOptionPane.showMessageDialog(null, "Tekrar Deneyiniz.");
				
					
					
				}
				refreshTable();
			}
		});
		btnSaticiEkle.setBounds(33, 147, 193, 23);
		contentPane.add(btnSaticiEkle);
		
		textFieldSAdi = new JTextField();
		textFieldSAdi.setBounds(140, 52, 86, 20);
		contentPane.add(textFieldSAdi);
		textFieldSAdi.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(140, 77, 86, 20);
		contentPane.add(passwordField);
		
		JLabel lblSifreTekrar = new JLabel("Sifre Tekrar :");
		lblSifreTekrar.setBounds(33, 105, 72, 14);
		contentPane.add(lblSifreTekrar);
		
		passwordFieldTekrar = new JPasswordField();
		passwordFieldTekrar.setBounds(140, 108, 86, 20);
		contentPane.add(passwordFieldTekrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(253, 55, 155, 116);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		refreshTable();
	}
}
