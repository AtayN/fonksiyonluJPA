package folder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.sun.tools.xjc.generator.bean.ImplStructureStrategy.Result;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;

public class siparisGui extends JFrame {
	static EntityManagerFactory factory;
	static EntityManager manager;
	private JPanel contentPane;
	private JTextField textFieldMusteriAdi;
	static satici tut;
	private JTextField textFieldKola;
	private JTextField textFieldSu;
	private JTextField textFieldAt;
	Connection con = null;

	private JTable table_1;

	public void refreshTable() {

		try {

			String sql = "select * from siparis  ";

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			table_1.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void sipEkle(siparis ee, urun a1, int adet)

	{
		a1.getSiparis().add(ee);
		manager.merge(a1);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					siparisGui frame = new siparisGui();
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
	public siparisGui() {
		con = connectionss.Jdbc();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldMusteriAdi = new JTextField();
		textFieldMusteriAdi.setBounds(104, 42, 97, 20);
		contentPane.add(textFieldMusteriAdi);
		textFieldMusteriAdi.setColumns(10);

		JLabel lblMsteriAd = new JLabel("M\u00FCsteri Ad\u0131: ");
		lblMsteriAd.setBounds(35, 45, 86, 14);
		contentPane.add(lblMsteriAd);

		JCheckBox urun1 = new JCheckBox("kola");
		urun1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldKola.enable();
				if (!urun1.isSelected()) {
					textFieldKola.disable();
					textFieldKola.setText(null);
				}
			}
		});
		urun1.setBounds(35, 106, 59, 23);
		contentPane.add(urun1);
		urun1.setName("kola");

		JCheckBox urun2 = new JCheckBox("su");
		urun2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				textFieldSu.enable();
				if (!urun2.isSelected()) {
					textFieldSu.disable();
					textFieldSu.setText(null);
				}
			}
		});
		urun2.setBounds(35, 132, 59, 23);
		contentPane.add(urun2);
		urun2.setName("su");

		JCheckBox urun3 = new JCheckBox("çay");
		urun3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldAt.enable();
				if (!urun3.isSelected()) {
					textFieldAt.disable();
					textFieldAt.setText(null);
				}

			}
		});
		urun3.setBounds(35, 163, 59, 23);
		contentPane.add(urun3);
		urun3.setName("çay");

		JButton btnNewButton = new JButton("Siparis Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshTable();

				try {
					factory = Persistence.createEntityManagerFactory("fonksiyonluJPA");
					manager = factory.createEntityManager();

					manager.getTransaction().begin();

					urun a1;

					Query query = manager.createQuery("SELECT u FROM urun u where u.ismi='" + urun1.getName() + "'");
					a1 = (urun) query.getSingleResult();

					urun a2;
					Query query1 = manager.createQuery("SELECT u FROM urun u where u.ismi='" + urun2.getName() + "'");
					a2 = (urun) query1.getSingleResult();

					urun a3;
					Query query2 = manager.createQuery("SELECT u FROM urun u where u.ismi='" + urun3.getName() + "'");
					a3 = (urun) query2.getSingleResult();

					siparis sip = new siparis();

					double toplam = 0;
					if (urun1.isSelected()) {
						sipEkle(sip, a1, Integer.valueOf(textFieldKola.getText()));
						toplam += Integer.valueOf(textFieldKola.getText()) * a1.getFiyati();
					}

					if (urun2.isSelected()) {
						sipEkle(sip, a2, Integer.valueOf(textFieldSu.getText()));
						toplam += Integer.valueOf(textFieldSu.getText()) * a2.getFiyati();
					}

					if (urun3.isSelected()) {
						sipEkle(sip, a3, Integer.valueOf(textFieldAt.getText()));
						toplam += Integer.valueOf(textFieldAt.getText()) * a3.getFiyati();
					}
					sip.getUrun().add(a1);
					sip.getUrun().add(a2);
					sip.getUrun().add(a3);

					sip.setMusAdi(textFieldMusteriAdi.getText());
					sip.setCustomer(tut);
					sip.setTutar(toplam);

					manager.merge(sip);
					manager.getTransaction().commit();
					JOptionPane.showMessageDialog(null, "Sipariþ Kaydedildi.");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				refreshTable();
			}

		});
		btnNewButton.setBounds(35, 213, 166, 23);
		contentPane.add(btnNewButton);

		textFieldKola = new JTextField();
		textFieldKola.setBounds(104, 107, 30, 20);
		contentPane.add(textFieldKola);
		textFieldKola.setColumns(10);
		textFieldKola.disable();

		textFieldSu = new JTextField();
		textFieldSu.setBounds(104, 133, 30, 20);
		contentPane.add(textFieldSu);
		textFieldSu.setColumns(10);
		textFieldSu.disable();

		textFieldAt = new JTextField();
		textFieldAt.setBounds(104, 164, 30, 20);
		contentPane.add(textFieldAt);
		textFieldAt.setColumns(10);
		textFieldAt.disable();
		JLabel lblrn = new JLabel("\u00DCr\u00FCn");
		lblrn.setBounds(35, 85, 46, 14);
		contentPane.add(lblrn);

		JLabel lblAdet = new JLabel("Adet");
		lblAdet.setBounds(104, 85, 46, 14);
		contentPane.add(lblAdet);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(268, 45, 280, 172);
		contentPane.add(scrollPane);

		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		refreshTable();

	}
}
