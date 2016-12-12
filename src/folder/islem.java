package folder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class islem extends JFrame {
	static satici tut;
	private JPanel contentPane;
	private JButton btnSatici;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					islem frame = new islem();
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
	public islem() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIlemler = new JLabel("\u0130\u015ELEMLER");
		lblIlemler.setBounds(184, 35, 107, 39);
		contentPane.add(lblIlemler);
		
		JButton btnSipari = new JButton("Sipari\u015F ");
		btnSipari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				siparisGui sg=new siparisGui();
				sg.setVisible(true);
				
			}
		});
		btnSipari.setBounds(161, 85, 89, 23);
		contentPane.add(btnSipari);
		
	btnSatici = new JButton("Satici");
		btnSatici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				saticiEkle se=new saticiEkle();
				se.setVisible(true);
				
				
			}
		});
		btnSatici.setBounds(161, 126, 89, 23);
		contentPane.add(btnSatici);
		if(!tut.get›sim().equals("admin")){
			btnSatici.setEnabled(false);
		}
	
	}
}
