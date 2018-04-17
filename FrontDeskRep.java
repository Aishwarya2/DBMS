import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JTable;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JList;


public class FrontDeskRep extends JFrame {

	private Statement smt=null;
	private ResultSet result = null;
	private Connection connection = null;
	private JPanel contentPane;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	
	
	private JButton btnCheckin;
	private JButton btnGenerateBill;
	private JButton btnCheckAvailability;
	
	private JTextArea checkinTA;
	private JTextArea textArea_1;
	private JTextArea textArea;
	private JTextField insert_h_id;
	private JTextField Insert_name;
	private JTextField insertAddress;
	private JTextField insertAge;
	private JTextField inserPhone;
	private JTextField inserTitle;
	private JTextField isnertAvailability;
	private JTextField insertDept;
	private JTextField update_H_Id;
	private JTextField update_S_Id;
	private JTextField updateName;
	private JTextField updateAddress;
	private JTextField updateAge;
	private JTextField updatePhoneNumber;
	private JTextField updateJobTitle;
	private JTextField updateAvailability;
	private JTextField updateDept;
	private JTextField delete_H_Id;
	private JTextField delete_S_Id;
	private JTextField insertName;
	private JTextField insertPhone;
	private JTextField updateHotelID;
	private JTextField update_H_Name;
	private JTextField update_H_Phone;
	private JTextField DeleteHotelID;
	private JTextField insertHZip;
	private JTextField insertHAddress;
	private JTextField insertHRate;
	private JTextField inserHCity;
	private JTextField updateHZipcode;
	private JTextField updateHAddress;
	private JTextField updateHRate;
	private JTextField updateHCity;
	private JTextField deleteZip;
	private JTextField insertZip;
	private JTextField updateZipCode;
	private JTextField insertCName;
	private JTextField insertCDOB;
	private JTextField insertCEmail;
	private JTextField insertCPhoneNumber;
	private JTextField updateCId;
	private JTextField updateCName;
	private JTextField updateCDOB;
	private JTextField updateCEmail;
	private JTextField updateCPhoneNumber;
	private JTextField deleteCId;
	private JTextField insertRoomNumber;
	private JTextField insertHotelId;
	private JTextField insertMaxOccupancy;
	private JTextField insertCategory;
	private JTextField updateRoomNumber;
	private JTextField updateHotelId;
	private JTextField updateMaxOccupancy;
	private JTextField updateCategory;
	private JTextField deleteRoomNumber;
	private JTextField deleteRoomHotelId;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_13;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontDeskRep frame = new FrontDeskRep();
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
	public FrontDeskRep() {
		setTitle("Front Desk Representative");
		initComponents();
		initEvents();
	}

	public FrontDeskRep(Statement smt, Connection connection) {
		this.smt = smt;
		this.connection = connection;
		initComponents();
		initEvents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(15, 0, 773, 442);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Check-in", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCheckinCustomerStay = new JLabel("Checkin Customer stay");
		GridBagConstraints gbc_lblCheckinCustomerStay = new GridBagConstraints();
		gbc_lblCheckinCustomerStay.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckinCustomerStay.gridx = 1;
		gbc_lblCheckinCustomerStay.gridy = 1;
		panel.add(lblCheckinCustomerStay, gbc_lblCheckinCustomerStay);
		
		JLabel lblCustomerId_1 = new JLabel("Customer ID");
		GridBagConstraints gbc_lblCustomerId_1 = new GridBagConstraints();
		gbc_lblCustomerId_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomerId_1.anchor = GridBagConstraints.EAST;
		gbc_lblCustomerId_1.gridx = 1;
		gbc_lblCustomerId_1.gridy = 3;
		panel.add(lblCustomerId_1, gbc_lblCustomerId_1);
		

		JLabel lblStartDate_1 = new JLabel("Start Date");
		GridBagConstraints gbc_lblStartDate_1 = new GridBagConstraints();
		gbc_lblStartDate_1.anchor = GridBagConstraints.EAST;
		gbc_lblStartDate_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartDate_1.gridx = 1;
		gbc_lblStartDate_1.gridy = 4;
		panel.add(lblStartDate_1, gbc_lblStartDate_1);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 3;
		panel.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 2;
		gbc_textField_6.gridy = 4;
		panel.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		JLabel lblEndDate_1 = new JLabel("End Date");
		GridBagConstraints gbc_lblEndDate_1 = new GridBagConstraints();
		gbc_lblEndDate_1.anchor = GridBagConstraints.EAST;
		gbc_lblEndDate_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndDate_1.gridx = 1;
		gbc_lblEndDate_1.gridy = 5;
		panel.add(lblEndDate_1, gbc_lblEndDate_1);
		
		textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 0);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 2;
		gbc_textField_7.gridy = 5;
		panel.add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		JLabel lblHotelId_1 = new JLabel("Hotel ID");
		GridBagConstraints gbc_lblHotelId_1 = new GridBagConstraints();
		gbc_lblHotelId_1.anchor = GridBagConstraints.EAST;
		gbc_lblHotelId_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblHotelId_1.gridx = 1;
		gbc_lblHotelId_1.gridy = 6;
		panel.add(lblHotelId_1, gbc_lblHotelId_1);
		checkinTA = new JTextArea();
		checkinTA.setVisible(false);
		
		textField_8 = new JTextField();
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(0, 0, 5, 0);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 2;
		gbc_textField_8.gridy = 6;
		panel.add(textField_8, gbc_textField_8);
		textField_8.setColumns(10);
		
		JLabel lblRoomType = new JLabel("Room Type");
		GridBagConstraints gbc_lblRoomType = new GridBagConstraints();
		gbc_lblRoomType.anchor = GridBagConstraints.EAST;
		gbc_lblRoomType.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomType.gridx = 1;
		gbc_lblRoomType.gridy = 7;
		panel.add(lblRoomType, gbc_lblRoomType);
		
		textField_18 = new JTextField();
		GridBagConstraints gbc_textField_18 = new GridBagConstraints();
		gbc_textField_18.insets = new Insets(0, 0, 5, 0);
		gbc_textField_18.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_18.gridx = 2;
		gbc_textField_18.gridy = 7;
		panel.add(textField_18, gbc_textField_18);
		textField_18.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.anchor = GridBagConstraints.EAST;
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.gridx = 1;
		gbc_lblCity.gridy = 8;
		panel.add(lblCity, gbc_lblCity);
		
		textField_19 = new JTextField();
		GridBagConstraints gbc_textField_19 = new GridBagConstraints();
		gbc_textField_19.insets = new Insets(0, 0, 5, 0);
		gbc_textField_19.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_19.gridx = 2;
		gbc_textField_19.gridy = 8;
		panel.add(textField_19, gbc_textField_19);
		textField_19.setColumns(10);
		
		JLabel lblCapacity = new JLabel("Capacity");
		GridBagConstraints gbc_lblCapacity = new GridBagConstraints();
		gbc_lblCapacity.anchor = GridBagConstraints.EAST;
		gbc_lblCapacity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCapacity.gridx = 1;
		gbc_lblCapacity.gridy = 9;
		panel.add(lblCapacity, gbc_lblCapacity);
		
		textField_20 = new JTextField();
		GridBagConstraints gbc_textField_20 = new GridBagConstraints();
		gbc_textField_20.insets = new Insets(0, 0, 5, 0);
		gbc_textField_20.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_20.gridx = 2;
		gbc_textField_20.gridy = 9;
		panel.add(textField_20, gbc_textField_20);
		textField_20.setColumns(10);
		
		
		btnCheckin = new JButton("Checkin");
		
		GridBagConstraints gbc_btnCheckin = new GridBagConstraints();
		gbc_btnCheckin.gridx = 2;
		gbc_btnCheckin.gridy = 10;
		panel.add(btnCheckin, gbc_btnCheckin);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Checkout", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblCheckoutCustomerStay = new JLabel("Checkout Customer stay");
		GridBagConstraints gbc_lblCheckoutCustomerStay = new GridBagConstraints();
		gbc_lblCheckoutCustomerStay.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckoutCustomerStay.gridx = 1;
		gbc_lblCheckoutCustomerStay.gridy = 1;
		panel_1.add(lblCheckoutCustomerStay, gbc_lblCheckoutCustomerStay);
		
		JLabel lblCheckinId = new JLabel("Checkin ID");
		GridBagConstraints gbc_lblCheckinId = new GridBagConstraints();
		gbc_lblCheckinId.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckinId.gridx = 1;
		gbc_lblCheckinId.gridy = 3;
		panel_1.add(lblCheckinId, gbc_lblCheckinId);
		
		textField_9 = new JTextField();
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 3;
		gbc_textField_9.gridy = 3;
		panel_1.add(textField_9, gbc_textField_9);
		textField_9.setColumns(10);
		
		JLabel lblHotelid = new JLabel("HotelID");
		GridBagConstraints gbc_lblHotelid = new GridBagConstraints();
		gbc_lblHotelid.insets = new Insets(0, 0, 5, 5);
		gbc_lblHotelid.gridx = 1;
		gbc_lblHotelid.gridy = 4;
		panel_1.add(lblHotelid, gbc_lblHotelid);
		
		textField_16 = new JTextField();
		GridBagConstraints gbc_textField_16 = new GridBagConstraints();
		gbc_textField_16.insets = new Insets(0, 0, 5, 5);
		gbc_textField_16.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_16.gridx = 3;
		gbc_textField_16.gridy = 4;
		panel_1.add(textField_16, gbc_textField_16);
		textField_16.setColumns(10);
		
		JLabel lblPayment = new JLabel("Payment:");
		GridBagConstraints gbc_lblPayment = new GridBagConstraints();
		gbc_lblPayment.insets = new Insets(0, 0, 5, 5);
		gbc_lblPayment.gridx = 1;
		gbc_lblPayment.gridy = 6;
		panel_1.add(lblPayment, gbc_lblPayment);
		
		JLabel lblPaymentMethod = new JLabel("Payment Method");
		GridBagConstraints gbc_lblPaymentMethod = new GridBagConstraints();
		gbc_lblPaymentMethod.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaymentMethod.gridx = 1;
		gbc_lblPaymentMethod.gridy = 7;
		panel_1.add(lblPaymentMethod, gbc_lblPaymentMethod);
		
		textField_10 = new JTextField();
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.insets = new Insets(0, 0, 5, 5);
		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_10.gridx = 3;
		gbc_textField_10.gridy = 7;
		panel_1.add(textField_10, gbc_textField_10);
		textField_10.setColumns(10);
		
		JLabel lblCardNoif = new JLabel("Card no (if Payment by credit)");
		GridBagConstraints gbc_lblCardNoif = new GridBagConstraints();
		gbc_lblCardNoif.insets = new Insets(0, 0, 5, 5);
		gbc_lblCardNoif.gridx = 1;
		gbc_lblCardNoif.gridy = 8;
		panel_1.add(lblCardNoif, gbc_lblCardNoif);
		
		textField_11 = new JTextField();
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.insets = new Insets(0, 0, 5, 5);
		gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_11.gridx = 3;
		gbc_textField_11.gridy = 8;
		panel_1.add(textField_11, gbc_textField_11);
		textField_11.setColumns(10);
		
		JLabel lblSsn = new JLabel("SSN");
		GridBagConstraints gbc_lblSsn = new GridBagConstraints();
		gbc_lblSsn.insets = new Insets(0, 0, 5, 5);
		gbc_lblSsn.gridx = 1;
		gbc_lblSsn.gridy = 9;
		panel_1.add(lblSsn, gbc_lblSsn);
		
		textField_12 = new JTextField();
		GridBagConstraints gbc_textField_12 = new GridBagConstraints();
		gbc_textField_12.insets = new Insets(0, 0, 5, 5);
		gbc_textField_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_12.gridx = 3;
		gbc_textField_12.gridy = 9;
		panel_1.add(textField_12, gbc_textField_12);
		textField_12.setColumns(10);
		
		JButton btnCheckout = new JButton("Pay & Checkout");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnCheckout = new GridBagConstraints();
		gbc_btnCheckout.insets = new Insets(0, 0, 5, 0);
		gbc_btnCheckout.gridx = 5;
		gbc_btnCheckout.gridy = 9;
		panel_1.add(btnCheckout, gbc_btnCheckout);
		
		JLabel lblBillingAddressif = new JLabel("Billing Address (if new card)");
		GridBagConstraints gbc_lblBillingAddressif = new GridBagConstraints();
		gbc_lblBillingAddressif.insets = new Insets(0, 0, 5, 5);
		gbc_lblBillingAddressif.gridx = 1;
		gbc_lblBillingAddressif.gridy = 10;
		panel_1.add(lblBillingAddressif, gbc_lblBillingAddressif);
		
		textField_17 = new JTextField();
		GridBagConstraints gbc_textField_17 = new GridBagConstraints();
		gbc_textField_17.insets = new Insets(0, 0, 5, 5);
		gbc_textField_17.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_17.gridx = 3;
		gbc_textField_17.gridy = 10;
		panel_1.add(textField_17, gbc_textField_17);
		textField_17.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Room", null, panel_4, null);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblInsert_4 = new JLabel("INSERT");
		GridBagConstraints gbc_lblInsert_4 = new GridBagConstraints();
		gbc_lblInsert_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsert_4.gridx = 1;
		gbc_lblInsert_4.gridy = 1;
		panel_4.add(lblInsert_4, gbc_lblInsert_4);
		
		JLabel lblUpdate_4 = new JLabel("UPDATE");
		GridBagConstraints gbc_lblUpdate_4 = new GridBagConstraints();
		gbc_lblUpdate_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblUpdate_4.gridx = 5;
		gbc_lblUpdate_4.gridy = 1;
		panel_4.add(lblUpdate_4, gbc_lblUpdate_4);
		
		JLabel lblDelete_4 = new JLabel("DELETE");
		GridBagConstraints gbc_lblDelete_4 = new GridBagConstraints();
		gbc_lblDelete_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblDelete_4.gridx = 11;
		gbc_lblDelete_4.gridy = 1;
		panel_4.add(lblDelete_4, gbc_lblDelete_4);
		
		JLabel lblRoomNumber_1 = new JLabel("Room Number");
		GridBagConstraints gbc_lblRoomNumber_1 = new GridBagConstraints();
		gbc_lblRoomNumber_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomNumber_1.gridx = 3;
		gbc_lblRoomNumber_1.gridy = 2;
		panel_4.add(lblRoomNumber_1, gbc_lblRoomNumber_1);
		
		updateRoomNumber = new JTextField();
		GridBagConstraints gbc_updateRoomNumber = new GridBagConstraints();
		gbc_updateRoomNumber.insets = new Insets(0, 0, 5, 5);
		gbc_updateRoomNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateRoomNumber.gridx = 5;
		gbc_updateRoomNumber.gridy = 2;
		panel_4.add(updateRoomNumber, gbc_updateRoomNumber);
		updateRoomNumber.setColumns(10);
		
		JLabel lblRoomNumber_2 = new JLabel("Room Number");
		GridBagConstraints gbc_lblRoomNumber_2 = new GridBagConstraints();
		gbc_lblRoomNumber_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomNumber_2.gridx = 9;
		gbc_lblRoomNumber_2.gridy = 2;
		panel_4.add(lblRoomNumber_2, gbc_lblRoomNumber_2);
		
		deleteRoomNumber = new JTextField();
		GridBagConstraints gbc_deleteRoomNumber = new GridBagConstraints();
		gbc_deleteRoomNumber.insets = new Insets(0, 0, 5, 0);
		gbc_deleteRoomNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_deleteRoomNumber.gridx = 11;
		gbc_deleteRoomNumber.gridy = 2;
		panel_4.add(deleteRoomNumber, gbc_deleteRoomNumber);
		deleteRoomNumber.setColumns(10);
		
		JLabel lblRoomNumber = new JLabel("Room number");
		GridBagConstraints gbc_lblRoomNumber = new GridBagConstraints();
		gbc_lblRoomNumber.anchor = GridBagConstraints.EAST;
		gbc_lblRoomNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomNumber.gridx = 0;
		gbc_lblRoomNumber.gridy = 3;
		panel_4.add(lblRoomNumber, gbc_lblRoomNumber);
		
		insertRoomNumber = new JTextField();
		GridBagConstraints gbc_insertRoomNumber = new GridBagConstraints();
		gbc_insertRoomNumber.insets = new Insets(0, 0, 5, 5);
		gbc_insertRoomNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_insertRoomNumber.gridx = 1;
		gbc_insertRoomNumber.gridy = 3;
		panel_4.add(insertRoomNumber, gbc_insertRoomNumber);
		insertRoomNumber.setColumns(10);
		
		JLabel lblHotel = new JLabel("Hotel");
		GridBagConstraints gbc_lblHotel = new GridBagConstraints();
		gbc_lblHotel.insets = new Insets(0, 0, 5, 5);
		gbc_lblHotel.gridx = 3;
		gbc_lblHotel.gridy = 3;
		panel_4.add(lblHotel, gbc_lblHotel);
		
		updateHotelId = new JTextField();
		GridBagConstraints gbc_updateHotelId = new GridBagConstraints();
		gbc_updateHotelId.insets = new Insets(0, 0, 5, 5);
		gbc_updateHotelId.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateHotelId.gridx = 5;
		gbc_updateHotelId.gridy = 3;
		panel_4.add(updateHotelId, gbc_updateHotelId);
		updateHotelId.setColumns(10);
		
		JLabel lblHotel_1 = new JLabel("Hotel");
		GridBagConstraints gbc_lblHotel_1 = new GridBagConstraints();
		gbc_lblHotel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblHotel_1.gridx = 9;
		gbc_lblHotel_1.gridy = 3;
		panel_4.add(lblHotel_1, gbc_lblHotel_1);
		
		deleteRoomHotelId = new JTextField();
		GridBagConstraints gbc_deleteRoomHotelId = new GridBagConstraints();
		gbc_deleteRoomHotelId.insets = new Insets(0, 0, 5, 0);
		gbc_deleteRoomHotelId.fill = GridBagConstraints.HORIZONTAL;
		gbc_deleteRoomHotelId.gridx = 11;
		gbc_deleteRoomHotelId.gridy = 3;
		panel_4.add(deleteRoomHotelId, gbc_deleteRoomHotelId);
		deleteRoomHotelId.setColumns(10);
		
		JLabel lblHotelId_5 = new JLabel("Hotel Id");
		GridBagConstraints gbc_lblHotelId_5 = new GridBagConstraints();
		gbc_lblHotelId_5.anchor = GridBagConstraints.EAST;
		gbc_lblHotelId_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblHotelId_5.gridx = 0;
		gbc_lblHotelId_5.gridy = 4;
		panel_4.add(lblHotelId_5, gbc_lblHotelId_5);
		
		insertHotelId = new JTextField();
		GridBagConstraints gbc_insertHotelId = new GridBagConstraints();
		gbc_insertHotelId.insets = new Insets(0, 0, 5, 5);
		gbc_insertHotelId.fill = GridBagConstraints.HORIZONTAL;
		gbc_insertHotelId.gridx = 1;
		gbc_insertHotelId.gridy = 4;
		panel_4.add(insertHotelId, gbc_insertHotelId);
		insertHotelId.setColumns(10);
		
		JLabel lblMaxOccupany = new JLabel("Max Occupancy");
		GridBagConstraints gbc_lblMaxOccupany = new GridBagConstraints();
		gbc_lblMaxOccupany.anchor = GridBagConstraints.EAST;
		gbc_lblMaxOccupany.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaxOccupany.gridx = 0;
		gbc_lblMaxOccupany.gridy = 5;
		panel_4.add(lblMaxOccupany, gbc_lblMaxOccupany);
		
		insertMaxOccupancy = new JTextField();
		GridBagConstraints gbc_insertMaxOccupancy = new GridBagConstraints();
		gbc_insertMaxOccupancy.insets = new Insets(0, 0, 5, 5);
		gbc_insertMaxOccupancy.fill = GridBagConstraints.HORIZONTAL;
		gbc_insertMaxOccupancy.gridx = 1;
		gbc_insertMaxOccupancy.gridy = 5;
		panel_4.add(insertMaxOccupancy, gbc_insertMaxOccupancy);
		insertMaxOccupancy.setColumns(10);
		
		JLabel lblInvalidArgs = new JLabel("Invalid args!!!");
		GridBagConstraints gbc_lblInvalidArgs = new GridBagConstraints();
		gbc_lblInvalidArgs.insets = new Insets(0, 0, 5, 5);
		gbc_lblInvalidArgs.gridx = 5;
		gbc_lblInvalidArgs.gridy = 5;
		panel_4.add(lblInvalidArgs, gbc_lblInvalidArgs);
		lblInvalidArgs.setVisible(false);
		
		JLabel lblCategory = new JLabel("Category");
		GridBagConstraints gbc_lblCategory = new GridBagConstraints();
		gbc_lblCategory.anchor = GridBagConstraints.EAST;
		gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategory.gridx = 0;
		gbc_lblCategory.gridy = 6;
		panel_4.add(lblCategory, gbc_lblCategory);
		
		insertCategory = new JTextField();
		GridBagConstraints gbc_insertCategory = new GridBagConstraints();
		gbc_insertCategory.insets = new Insets(0, 0, 5, 5);
		gbc_insertCategory.fill = GridBagConstraints.HORIZONTAL;
		gbc_insertCategory.gridx = 1;
		gbc_insertCategory.gridy = 6;
		panel_4.add(insertCategory, gbc_insertCategory);
		insertCategory.setColumns(10);
		
		//Populate field from the data in database for specific room
		JButton btnConfirm_3 = new JButton("Confirm");
		btnConfirm_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int hotelId=Integer.parseInt(updateHotelId.getText());
				int roomId=Integer.parseInt(updateRoomNumber.getText());
				boolean b =false;
				try {
					//get the tuple for the room in a hotel
					ResultSet res = smt.executeQuery("SELECT * from Rooms where room_number="+roomId+" AND hotel_id=000"+hotelId);
					while(res.next()){
						//if room exists then populate the elements in the form
						b= true;
						updateCategory.setText(res.getString("category_name"));
						updateMaxOccupancy.setText(Integer.toString(res.getInt("max_occupancy")));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					b= false;
					//if there's an error catch into exception
				}
				//if the arguments were invalid display error message
				lblInvalidArgs.setVisible(!b);
			}
		});
		GridBagConstraints gbc_btnConfirm_3 = new GridBagConstraints();
		gbc_btnConfirm_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirm_3.gridx = 5;
		gbc_btnConfirm_3.gridy = 6;
		panel_4.add(btnConfirm_3, gbc_btnConfirm_3);
		
		JLabel lblFailedToDelete = new JLabel("Failed to Delete");
		GridBagConstraints gbc_lblFailedToDelete = new GridBagConstraints();
		gbc_lblFailedToDelete.insets = new Insets(0, 0, 5, 0);
		gbc_lblFailedToDelete.gridx = 11;
		gbc_lblFailedToDelete.gridy = 6;
		panel_4.add(lblFailedToDelete, gbc_lblFailedToDelete);
		lblFailedToDelete.setVisible(false);
		
		JLabel lblCouldntInsert = new JLabel("Couldn't insert!!");
		GridBagConstraints gbc_lblCouldntInsert = new GridBagConstraints();
		gbc_lblCouldntInsert.insets = new Insets(0, 0, 5, 5);
		gbc_lblCouldntInsert.gridx = 1;
		gbc_lblCouldntInsert.gridy = 8;
		panel_4.add(lblCouldntInsert, gbc_lblCouldntInsert);
		lblCouldntInsert.setVisible(false);
		
		JButton insertRoom = new JButton("OK");
		insertRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int hotelId = Integer.parseInt(insertHotelId.getText());
				int roomNumber = Integer.parseInt(insertRoomNumber.getText());
				int maxOccupancy = Integer.parseInt(insertMaxOccupancy.getText());
				String category = insertCategory.getText();
				
				//insert room into the database
				boolean b = insertRoom(hotelId, roomNumber, maxOccupancy, category);
				//if insertion was not successfull display error to user
				lblCouldntInsert.setVisible(!b);
				
				
			}
		});
		
		JLabel lblMaxOccupancy = new JLabel("Max Occupancy");
		GridBagConstraints gbc_lblMaxOccupancy = new GridBagConstraints();
		gbc_lblMaxOccupancy.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaxOccupancy.gridx = 3;
		gbc_lblMaxOccupancy.gridy = 8;
		panel_4.add(lblMaxOccupancy, gbc_lblMaxOccupancy);
		
		updateMaxOccupancy = new JTextField();
		GridBagConstraints gbc_updateMaxOccupancy = new GridBagConstraints();
		gbc_updateMaxOccupancy.insets = new Insets(0, 0, 5, 5);
		gbc_updateMaxOccupancy.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateMaxOccupancy.gridx = 5;
		gbc_updateMaxOccupancy.gridy = 8;
		panel_4.add(updateMaxOccupancy, gbc_updateMaxOccupancy);
		updateMaxOccupancy.setColumns(10);
		
		JLabel lblCategory_1 = new JLabel("Category");
		GridBagConstraints gbc_lblCategory_1 = new GridBagConstraints();
		gbc_lblCategory_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategory_1.gridx = 3;
		gbc_lblCategory_1.gridy = 9;
		panel_4.add(lblCategory_1, gbc_lblCategory_1);
		
		updateCategory = new JTextField();
		GridBagConstraints gbc_updateCategory = new GridBagConstraints();
		gbc_updateCategory.insets = new Insets(0, 0, 5, 5);
		gbc_updateCategory.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateCategory.gridx = 5;
		gbc_updateCategory.gridy = 9;
		panel_4.add(updateCategory, gbc_updateCategory);
		updateCategory.setColumns(10);
		GridBagConstraints gbc_insertRoom = new GridBagConstraints();
		gbc_insertRoom.insets = new Insets(0, 0, 0, 5);
		gbc_insertRoom.gridx = 1;
		gbc_insertRoom.gridy = 10;
		panel_4.add(insertRoom, gbc_insertRoom);
		
		JLabel lblInvalidData_1 = new JLabel("Invalid Data");
		GridBagConstraints gbc_lblInvalidData_1 = new GridBagConstraints();
		gbc_lblInvalidData_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblInvalidData_1.gridx = 3;
		gbc_lblInvalidData_1.gridy = 10;
		panel_4.add(lblInvalidData_1, gbc_lblInvalidData_1);
		lblInvalidData_1.setVisible(false);
		
		JButton updateButton = new JButton("OK");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int hotelId = Integer.parseInt(updateHotelId.getText());
				int roomNumber = Integer.parseInt(updateRoomNumber.getText());
				int maxOccupancy = Integer.parseInt(updateMaxOccupancy.getText());
				String category = updateCategory.getText();
				//update Room data from hotel id and room number 
				boolean b = updateRoom(hotelId, roomNumber, maxOccupancy, category);
				//if updation was not successfull report to the user
				lblInvalidData_1.setVisible(!b);
				
			}
		});
		
		
		
		
		GridBagConstraints gbc_updateButton = new GridBagConstraints();
		gbc_updateButton.insets = new Insets(0, 0, 0, 5);
		gbc_updateButton.gridx = 5;
		gbc_updateButton.gridy = 10;
		panel_4.add(updateButton, gbc_updateButton);
		
		JButton btnOk_2 = new JButton("OK");
		btnOk_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int hotelId = Integer.parseInt(deleteRoomHotelId.getText());
				int roomNumber = Integer.parseInt(deleteRoomNumber.getText());
				//delete Room based on data provided by the user
				boolean b = deleteRoom(hotelId, roomNumber);
				//if delete failed report or room did not exist report
				lblFailedToDelete.setVisible(!b);
			}
		});
		GridBagConstraints gbc_btnOk_2 = new GridBagConstraints();
		gbc_btnOk_2.gridx = 11;
		gbc_btnOk_2.gridy = 10;
		panel_4.add(btnOk_2, gbc_btnOk_2);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Generate Bill", null, panel_2, null);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblGenerateBillFor = new JLabel("Generate bill for customer");
		GridBagConstraints gbc_lblGenerateBillFor = new GridBagConstraints();
		gbc_lblGenerateBillFor.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenerateBillFor.gridx = 1;
		gbc_lblGenerateBillFor.gridy = 1;
		panel_2.add(lblGenerateBillFor, gbc_lblGenerateBillFor);
		
		JLabel lblCustomerId = new JLabel("Customer ID:");
		GridBagConstraints gbc_lblCustomerId = new GridBagConstraints();
		gbc_lblCustomerId.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomerId.anchor = GridBagConstraints.EAST;
		gbc_lblCustomerId.gridx = 1;
		gbc_lblCustomerId.gridy = 3;
		panel_2.add(lblCustomerId, gbc_lblCustomerId);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 3;
		panel_2.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		btnGenerateBill = new JButton("Generate bill");
		
		GridBagConstraints gbc_btnGenerateBill = new GridBagConstraints();
		gbc_btnGenerateBill.insets = new Insets(0, 0, 5, 5);
		gbc_btnGenerateBill.gridx = 3;
		gbc_btnGenerateBill.gridy = 3;
		panel_2.add(btnGenerateBill, gbc_btnGenerateBill);
		
		textArea_1 = new JTextArea();
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		gbc_textArea_1.gridwidth = 2;
		gbc_textArea_1.insets = new Insets(0, 0, 0, 5);
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.gridx = 1;
		gbc_textArea_1.gridy = 7;
		panel_2.add(textArea_1, gbc_textArea_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Room Availability", null, panel_3, null);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblCheckRoomAvailability = new JLabel("Check room availability Today");
		GridBagConstraints gbc_lblCheckRoomAvailability = new GridBagConstraints();
		gbc_lblCheckRoomAvailability.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckRoomAvailability.gridx = 1;
		gbc_lblCheckRoomAvailability.gridy = 1;
		panel_3.add(lblCheckRoomAvailability, gbc_lblCheckRoomAvailability);
		
		
		
		JLabel lblRoomId = new JLabel("Room Number");
		GridBagConstraints gbc_lblRoomId = new GridBagConstraints();
		gbc_lblRoomId.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomId.gridx = 1;
		gbc_lblRoomId.gridy = 5;
		panel_3.add(lblRoomId, gbc_lblRoomId);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 5;
		panel_3.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblHotelId_6 = new JLabel("Hotel ID");
		GridBagConstraints gbc_lblHotelId_6 = new GridBagConstraints();
		gbc_lblHotelId_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblHotelId_6.gridx = 1;
		gbc_lblHotelId_6.gridy = 6;
		panel_3.add(lblHotelId_6, gbc_lblHotelId_6);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 6;
		panel_3.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblRoomType_1 = new JLabel("Room Type");
		GridBagConstraints gbc_lblRoomType_1 = new GridBagConstraints();
		gbc_lblRoomType_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomType_1.gridx = 1;
		gbc_lblRoomType_1.gridy = 7;
		panel_3.add(lblRoomType_1, gbc_lblRoomType_1);
		
		textField_13 = new JTextField();
		GridBagConstraints gbc_textField_13 = new GridBagConstraints();
		gbc_textField_13.insets = new Insets(0, 0, 5, 5);
		gbc_textField_13.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_13.gridx = 3;
		gbc_textField_13.gridy = 7;
		panel_3.add(textField_13, gbc_textField_13);
		textField_13.setColumns(10);
		
		btnCheckAvailability = new JButton("Check Availability");
		
		GridBagConstraints gbc_btnCheckAvailability = new GridBagConstraints();
		gbc_btnCheckAvailability.insets = new Insets(0, 0, 5, 5);
		gbc_btnCheckAvailability.gridx = 5;
		gbc_btnCheckAvailability.gridy = 9;
		panel_3.add(btnCheckAvailability, gbc_btnCheckAvailability);
		
		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 2;
		gbc_textArea.gridwidth = 5;
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 10;
		panel_3.add(textArea, gbc_textArea);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Staff", null, panel_5, null);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblInsert = new JLabel("INSERT");
		GridBagConstraints gbc_lblInsert = new GridBagConstraints();
		gbc_lblInsert.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsert.gridx = 2;
		gbc_lblInsert.gridy = 1;
		panel_5.add(lblInsert, gbc_lblInsert);
		
		JLabel lblUpdate = new JLabel("UPDATE");
		GridBagConstraints gbc_lblUpdate = new GridBagConstraints();
		gbc_lblUpdate.insets = new Insets(0, 0, 5, 5);
		gbc_lblUpdate.gridx = 7;
		gbc_lblUpdate.gridy = 1;
		panel_5.add(lblUpdate, gbc_lblUpdate);
		
		JLabel lblDelete = new JLabel("DELETE");
		GridBagConstraints gbc_lblDelete = new GridBagConstraints();
		gbc_lblDelete.insets = new Insets(0, 0, 5, 0);
		gbc_lblDelete.gridx = 13;
		gbc_lblDelete.gridy = 1;
		panel_5.add(lblDelete, gbc_lblDelete);
		
		JLabel lblHotelId_2 = new JLabel("Hotel Id");
		GridBagConstraints gbc_lblHotelId_2 = new GridBagConstraints();
		gbc_lblHotelId_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblHotelId_2.gridx = 5;
		gbc_lblHotelId_2.gridy = 3;
		panel_5.add(lblHotelId_2, gbc_lblHotelId_2);
		
		update_H_Id = new JTextField();
		GridBagConstraints gbc_update_H_Id = new GridBagConstraints();
		gbc_update_H_Id.insets = new Insets(0, 0, 5, 5);
		gbc_update_H_Id.fill = GridBagConstraints.HORIZONTAL;
		gbc_update_H_Id.gridx = 7;
		gbc_update_H_Id.gridy = 3;
		panel_5.add(update_H_Id, gbc_update_H_Id);
		update_H_Id.setColumns(10);
		
		JLabel lblHotelid_1 = new JLabel("HotelID");
		GridBagConstraints gbc_lblHotelid_1 = new GridBagConstraints();
		gbc_lblHotelid_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblHotelid_1.gridx = 11;
		gbc_lblHotelid_1.gridy = 3;
		panel_5.add(lblHotelid_1, gbc_lblHotelid_1);
		
		delete_H_Id = new JTextField();
		GridBagConstraints gbc_delete_H_Id = new GridBagConstraints();
		gbc_delete_H_Id.insets = new Insets(0, 0, 5, 0);
		gbc_delete_H_Id.fill = GridBagConstraints.HORIZONTAL;
		gbc_delete_H_Id.gridx = 13;
		gbc_delete_H_Id.gridy = 3;
		panel_5.add(delete_H_Id, gbc_delete_H_Id);
		delete_H_Id.setColumns(10);
		
		JLabel lblStaffId_1 = new JLabel("Staff Id");
		GridBagConstraints gbc_lblStaffId_1 = new GridBagConstraints();
		gbc_lblStaffId_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblStaffId_1.gridx = 5;
		gbc_lblStaffId_1.gridy = 4;
		panel_5.add(lblStaffId_1, gbc_lblStaffId_1);
		
		update_S_Id = new JTextField();
		GridBagConstraints gbc_update_S_Id = new GridBagConstraints();
		gbc_update_S_Id.insets = new Insets(0, 0, 5, 5);
		gbc_update_S_Id.fill = GridBagConstraints.HORIZONTAL;
		gbc_update_S_Id.gridx = 7;
		gbc_update_S_Id.gridy = 4;
		panel_5.add(update_S_Id, gbc_update_S_Id);
		update_S_Id.setColumns(10);
		
		JLabel lblInvalidArguments = new JLabel("Invalid arguments");
		lblInvalidArguments.setVisible(false);
		GridBagConstraints gbc_lblInvalidArguments = new GridBagConstraints();
		gbc_lblInvalidArguments.insets = new Insets(0, 0, 5, 5);
		gbc_lblInvalidArguments.gridx = 7;
		gbc_lblInvalidArguments.gridy = 5;
		panel_5.add(lblInvalidArguments, gbc_lblInvalidArguments);
		
		JLabel lblStaffid = new JLabel("Staff_ID");
		GridBagConstraints gbc_lblStaffid = new GridBagConstraints();
		gbc_lblStaffid.insets = new Insets(0, 0, 5, 5);
		gbc_lblStaffid.gridx = 11;
		gbc_lblStaffid.gridy = 5;
		panel_5.add(lblStaffid, gbc_lblStaffid);
		
		delete_S_Id = new JTextField();
		GridBagConstraints gbc_delete_S_Id = new GridBagConstraints();
		gbc_delete_S_Id.insets = new Insets(0, 0, 5, 0);
		gbc_delete_S_Id.fill = GridBagConstraints.HORIZONTAL;
		gbc_delete_S_Id.gridx = 13;
		gbc_delete_S_Id.gridy = 5;
		panel_5.add(delete_S_Id, gbc_delete_S_Id);
		delete_S_Id.setColumns(10);
		
		JLabel lblHotelId = new JLabel("Hotel Id");
		GridBagConstraints gbc_lblHotelId = new GridBagConstraints();
		gbc_lblHotelId.anchor = GridBagConstraints.EAST;
		gbc_lblHotelId.insets = new Insets(0, 0, 5, 5);
		gbc_lblHotelId.gridx = 1;
		gbc_lblHotelId.gridy = 6;
		panel_5.add(lblHotelId, gbc_lblHotelId);
//		lblHotelId.setVisible(false);
		
		insert_h_id = new JTextField();
		insert_h_id.addComponentListener(new ComponentAdapter() {
		
		});
		GridBagConstraints gbc_insert_h_id = new GridBagConstraints();
		gbc_insert_h_id.insets = new Insets(0, 0, 5, 5);
		gbc_insert_h_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_insert_h_id.gridx = 2;
		gbc_insert_h_id.gridy = 6;
		panel_5.add(insert_h_id, gbc_insert_h_id);
		insert_h_id.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get the parameters from the form
				Integer hotelId = Integer.parseInt(update_H_Id.getText());
				Integer staffId= Integer.parseInt(update_S_Id.getText());
				try {
					//populate the updatable fields from data exisiting in the database
					ResultSet result = smt.executeQuery("Select name, address, age, phone_number, job_title, availability, department FROM Staffs where hotel_id ="+hotelId+" AND id ="+staffId);
					
					while(result.next()){

					System.out.println(result.getString("name"));
					updateName.setText(result.getString("name"));
					
					updateAddress.setText(result.getString("address"));
					
					updateAge.setText(Integer.toString(result.getInt("age")));
					
					updatePhoneNumber.setText(result.getString("phone_number"));
					updateJobTitle.setText(result.getString("job_title"));
					updateAvailability.setText(result.getString("availability"));
					updateDept.setText(result.getString("department"));
					}
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					//if an error occurs notify user
					lblInvalidArguments.setVisible(true);
					ex.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnConfirm = new GridBagConstraints();
		gbc_btnConfirm.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirm.gridx = 7;
		gbc_btnConfirm.gridy = 6;
		panel_5.add(btnConfirm, gbc_btnConfirm);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 7;
		panel_5.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		Insert_name = new JTextField();
		GridBagConstraints gbc_Insert_name = new GridBagConstraints();
		gbc_Insert_name.insets = new Insets(0, 0, 5, 5);
		gbc_Insert_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_Insert_name.gridx = 2;
		gbc_Insert_name.gridy = 7;
		panel_5.add(Insert_name, gbc_Insert_name);
		Insert_name.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 5;
		gbc_lblName.gridy = 7;
		panel_5.add(lblName, gbc_lblName);
		
		updateName = new JTextField();
		GridBagConstraints gbc_updateName = new GridBagConstraints();
		gbc_updateName.insets = new Insets(0, 0, 5, 5);
		gbc_updateName.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateName.gridx = 7;
		gbc_updateName.gridy = 7;
		panel_5.add(updateName, gbc_updateName);
		updateName.setColumns(10);
		
		JLabel lblStaffDoesntExist = new JLabel("Staff doesn't exist");
		lblStaffDoesntExist.setVisible(false);
		GridBagConstraints gbc_lblStaffDoesntExist = new GridBagConstraints();
		gbc_lblStaffDoesntExist.insets = new Insets(0, 0, 5, 0);
		gbc_lblStaffDoesntExist.gridx = 13;
		gbc_lblStaffDoesntExist.gridy = 7;
		panel_5.add(lblStaffDoesntExist, gbc_lblStaffDoesntExist);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 8;
		panel_5.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		insertAddress = new JTextField();
		GridBagConstraints gbc_insertAddress = new GridBagConstraints();
		gbc_insertAddress.insets = new Insets(0, 0, 5, 5);
		gbc_insertAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_insertAddress.gridx = 2;
		gbc_insertAddress.gridy = 8;
		panel_5.add(insertAddress, gbc_insertAddress);
		insertAddress.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 5;
		gbc_lblAddress.gridy = 8;
		panel_5.add(lblAddress, gbc_lblAddress);
		
		updateAddress = new JTextField();
		GridBagConstraints gbc_updateAddress = new GridBagConstraints();
		gbc_updateAddress.insets = new Insets(0, 0, 5, 5);
		gbc_updateAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateAddress.gridx = 7;
		gbc_updateAddress.gridy = 8;
		panel_5.add(updateAddress, gbc_updateAddress);
		updateAddress.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 9;
		panel_5.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		insertAge = new JTextField();
		GridBagConstraints gbc_insertAge = new GridBagConstraints();
		gbc_insertAge.insets = new Insets(0, 0, 5, 5);
		gbc_insertAge.fill = GridBagConstraints.HORIZONTAL;
		gbc_insertAge.gridx = 2;
		gbc_insertAge.gridy = 9;
		panel_5.add(insertAge, gbc_insertAge);
		insertAge.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.insets = new Insets(0, 0, 5, 5);
		gbc_lblAge.gridx = 5;
		gbc_lblAge.gridy = 9;
		panel_5.add(lblAge, gbc_lblAge);
		
		updateAge = new JTextField();
		GridBagConstraints gbc_updateAge = new GridBagConstraints();
		gbc_updateAge.insets = new Insets(0, 0, 5, 5);
		gbc_updateAge.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateAge.gridx = 7;
		gbc_updateAge.gridy = 9;
		panel_5.add(updateAge, gbc_updateAge);
		updateAge.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Phone Number");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 10;
		panel_5.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		inserPhone = new JTextField();
		GridBagConstraints gbc_inserPhone = new GridBagConstraints();
		gbc_inserPhone.insets = new Insets(0, 0, 5, 5);
		gbc_inserPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_inserPhone.gridx = 2;
		gbc_inserPhone.gridy = 10;
		panel_5.add(inserPhone, gbc_inserPhone);
		inserPhone.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
		gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber.gridx = 5;
		gbc_lblPhoneNumber.gridy = 10;
		panel_5.add(lblPhoneNumber, gbc_lblPhoneNumber);
		
		updatePhoneNumber = new JTextField();
		GridBagConstraints gbc_updatePhoneNumber = new GridBagConstraints();
		gbc_updatePhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_updatePhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_updatePhoneNumber.gridx = 7;
		gbc_updatePhoneNumber.gridy = 10;
		panel_5.add(updatePhoneNumber, gbc_updatePhoneNumber);
		updatePhoneNumber.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Job Title");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 11;
		panel_5.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		inserTitle = new JTextField();
		GridBagConstraints gbc_inserTitle = new GridBagConstraints();
		gbc_inserTitle.insets = new Insets(0, 0, 5, 5);
		gbc_inserTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_inserTitle.gridx = 2;
		gbc_inserTitle.gridy = 11;
		panel_5.add(inserTitle, gbc_inserTitle);
		inserTitle.setColumns(10);
		
		JLabel lblJobTitle = new JLabel("Job Title");
		GridBagConstraints gbc_lblJobTitle = new GridBagConstraints();
		gbc_lblJobTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblJobTitle.gridx = 5;
		gbc_lblJobTitle.gridy = 11;
		panel_5.add(lblJobTitle, gbc_lblJobTitle);
		
		updateJobTitle = new JTextField();
		GridBagConstraints gbc_updateJobTitle = new GridBagConstraints();
		gbc_updateJobTitle.insets = new Insets(0, 0, 5, 5);
		gbc_updateJobTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateJobTitle.gridx = 7;
		gbc_updateJobTitle.gridy = 11;
		panel_5.add(updateJobTitle, gbc_updateJobTitle);
		updateJobTitle.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Availability");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 12;
		panel_5.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		isnertAvailability = new JTextField();
		GridBagConstraints gbc_isnertAvailability = new GridBagConstraints();
		gbc_isnertAvailability.insets = new Insets(0, 0, 5, 5);
		gbc_isnertAvailability.fill = GridBagConstraints.HORIZONTAL;
		gbc_isnertAvailability.gridx = 2;
		gbc_isnertAvailability.gridy = 12;
		panel_5.add(isnertAvailability, gbc_isnertAvailability);
		isnertAvailability.setColumns(10);
		
		JLabel lblAvailability = new JLabel("Availability");
		GridBagConstraints gbc_lblAvailability = new GridBagConstraints();
		gbc_lblAvailability.insets = new Insets(0, 0, 5, 5);
		gbc_lblAvailability.gridx = 5;
		gbc_lblAvailability.gridy = 12;
		panel_5.add(lblAvailability, gbc_lblAvailability);
		
		updateAvailability = new JTextField();
		GridBagConstraints gbc_updateAvailability = new GridBagConstraints();
		gbc_updateAvailability.insets = new Insets(0, 0, 5, 5);
		gbc_updateAvailability.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateAvailability.gridx = 7;
		gbc_updateAvailability.gridy = 12;
		panel_5.add(updateAvailability, gbc_updateAvailability);
		updateAvailability.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Department");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 13;
		panel_5.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		insertDept = new JTextField();
		GridBagConstraints gbc_insertDept = new GridBagConstraints();
		gbc_insertDept.insets = new Insets(0, 0, 5, 5);
		gbc_insertDept.fill = GridBagConstraints.HORIZONTAL;
		gbc_insertDept.gridx = 2;
		gbc_insertDept.gridy = 13;
		panel_5.add(insertDept, gbc_insertDept);
		insertDept.setColumns(10);
		
		JLabel Department = new JLabel("Department");
		GridBagConstraints gbc_Department = new GridBagConstraints();
		gbc_Department.insets = new Insets(0, 0, 5, 5);
		gbc_Department.gridx = 5;
		gbc_Department.gridy = 13;
		panel_5.add(Department, gbc_Department);
		
		updateDept = new JTextField();
		GridBagConstraints gbc_updateDept = new GridBagConstraints();
		gbc_updateDept.insets = new Insets(0, 0, 5, 5);
		gbc_updateDept.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateDept.gridx = 7;
		gbc_updateDept.gridy = 13;
		panel_5.add(updateDept, gbc_updateDept);
		updateDept.setColumns(10);
		
		JButton insertOK = new JButton("OK");
		insertOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//get the fields from the form
				int hotelId = Integer.parseInt(insert_h_id.getText());
				String availability = "Yes";
				String name = Insert_name.getText();
				String address = insertAddress.getText();
				int age = Integer.parseInt(insertAge.getText());
				String job_title = inserTitle.getText();
				String phone_number = inserPhone.getText();
				String department = insertDept.getText();
				//insert into staffs the fields obtained from the form
				insertIntoStaffs(hotelId, availability, name, address, age, job_title, phone_number, department);
			}
		});
		GridBagConstraints gbc_insertOK = new GridBagConstraints();
		gbc_insertOK.insets = new Insets(0, 0, 0, 5);
		gbc_insertOK.gridx = 2;
		gbc_insertOK.gridy = 14;
		panel_5.add(insertOK, gbc_insertOK);
		
		JButton UpdateOK = new JButton("OK");
		UpdateOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get values frim fields in the form
				int hotelID = Integer.parseInt(update_H_Id.getText());
				int staffId = Integer.parseInt(update_S_Id.getText());
				String name = updateName.getText();
				String address = updateAddress.getText();
				int age = Integer.parseInt(updateAge.getText());
				String job_title = updateJobTitle.getText();
				String phone_number = updatePhoneNumber.getText();
				String department = updateDept.getText();
				String availability = updateAvailability.getText();
				//update Staff table with new valuels	
				updateStaff(hotelID, staffId, availability, name, address, age, job_title, phone_number, department);
			}
			
			
		});
		GridBagConstraints gbc_UpdateOK = new GridBagConstraints();
		gbc_UpdateOK.insets = new Insets(0, 0, 0, 5);
		gbc_UpdateOK.gridx = 7;
		gbc_UpdateOK.gridy = 14;
		panel_5.add(UpdateOK, gbc_UpdateOK);
		
		JButton deleteOk = new JButton("OK");
		deleteOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hotelId = Integer.parseInt(delete_H_Id.getText());
				int staffId = Integer.parseInt(delete_S_Id.getText());
				boolean b = deleteStaff(hotelId, staffId);
				lblStaffDoesntExist.setVisible(!b);
			}
		});
		GridBagConstraints gbc_deleteOk = new GridBagConstraints();
		gbc_deleteOk.gridx = 13;
		gbc_deleteOk.gridy = 14;
		panel_5.add(deleteOk, gbc_deleteOk);
		
		JPanel Hotel = new JPanel();
		tabbedPane.addTab("Hotel", null, Hotel, null);
		GridBagLayout gbl_Hotel = new GridBagLayout();
		gbl_Hotel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Hotel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Hotel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_Hotel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		Hotel.setLayout(gbl_Hotel);
		
		JLabel lblInsert_1 = new JLabel("Insert");
		GridBagConstraints gbc_lblInsert_1 = new GridBagConstraints();
		gbc_lblInsert_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsert_1.gridx = 3;
		gbc_lblInsert_1.gridy = 0;
		Hotel.add(lblInsert_1, gbc_lblInsert_1);
		
		JLabel lblUpdate_1 = new JLabel("Update");
		GridBagConstraints gbc_lblUpdate_1 = new GridBagConstraints();
		gbc_lblUpdate_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblUpdate_1.gridx = 10;
		gbc_lblUpdate_1.gridy = 0;
		Hotel.add(lblUpdate_1, gbc_lblUpdate_1);
		
		JLabel lblDelete_1 = new JLabel("Delete");
		GridBagConstraints gbc_lblDelete_1 = new GridBagConstraints();
		gbc_lblDelete_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblDelete_1.gridx = 18;
		gbc_lblDelete_1.gridy = 0;
		Hotel.add(lblDelete_1, gbc_lblDelete_1);
		
		JLabel lblHotelId_3 = new JLabel("Hotel ID");
		GridBagConstraints gbc_lblHotelId_3 = new GridBagConstraints();
		gbc_lblHotelId_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblHotelId_3.gridx = 8;
		gbc_lblHotelId_3.gridy = 2;
		Hotel.add(lblHotelId_3, gbc_lblHotelId_3);
		
		updateHotelID = new JTextField();
		GridBagConstraints gbc_updateHotelID = new GridBagConstraints();
		gbc_updateHotelID.insets = new Insets(0, 0, 5, 5);
		gbc_updateHotelID.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateHotelID.gridx = 10;
		gbc_updateHotelID.gridy = 2;
		Hotel.add(updateHotelID, gbc_updateHotelID);
		updateHotelID.setColumns(10);
		
		JLabel lblHotelId_4 = new JLabel("Hotel ID");
		GridBagConstraints gbc_lblHotelId_4 = new GridBagConstraints();
		gbc_lblHotelId_4.anchor = GridBagConstraints.EAST;
		gbc_lblHotelId_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblHotelId_4.gridx = 17;
		gbc_lblHotelId_4.gridy = 2;
		Hotel.add(lblHotelId_4, gbc_lblHotelId_4);
		

		JLabel lblInvalidHotel = new JLabel("Invalid Hotel");
		GridBagConstraints gbc_lblInvalidHotel = new GridBagConstraints();
		gbc_lblInvalidHotel.insets = new Insets(0, 0, 5, 5);
		gbc_lblInvalidHotel.gridx = 10;
		gbc_lblInvalidHotel.gridy = 4;
		Hotel.add(lblInvalidHotel, gbc_lblInvalidHotel);
		lblInvalidHotel.setVisible(false);
		
		DeleteHotelID = new JTextField();
		GridBagConstraints gbc_DeleteHotelID = new GridBagConstraints();
		gbc_DeleteHotelID.insets = new Insets(0, 0, 5, 0);
		gbc_DeleteHotelID.fill = GridBagConstraints.HORIZONTAL;
		gbc_DeleteHotelID.gridx = 18;
		gbc_DeleteHotelID.gridy = 2;
		Hotel.add(DeleteHotelID, gbc_DeleteHotelID);
		DeleteHotelID.setColumns(10);
		
		JButton confirmHotel = new JButton("Confirm");
		confirmHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println(updateHot.getText());
				int hotelId = Integer.parseInt(updateHotelID.getText());
				boolean b = false;
				try {
					//Get data about the hotel with specific hotel id
					ResultSet rs = smt.executeQuery("SELECT * FROM Hotels where id ="+hotelId);
					
					while(rs.next()){
						b = true;
						//if hotel exists populate the other update fields
						update_H_Name.setText(rs.getString("name"));
						
						update_H_Phone.setText(rs.getString("phone_number"));
						
						updateZipCode.setText(rs.getString("zip_code"));
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//if there's an error update flag and print the exception
					b = false;
					e1.printStackTrace();
					
				}
				//Notify user if there's an error
				lblInvalidHotel.setVisible(!b);
				
			}
		});
		GridBagConstraints gbc_confirmHotel = new GridBagConstraints();
		gbc_confirmHotel.insets = new Insets(0, 0, 5, 5);
		gbc_confirmHotel.gridx = 10;
		gbc_confirmHotel.gridy = 3;
		Hotel.add(confirmHotel, gbc_confirmHotel);
		
		JLabel lb_Name = new JLabel("Name");
		GridBagConstraints gbc_lb_Name = new GridBagConstraints();
		gbc_lb_Name.insets = new Insets(0, 0, 5, 5);
		gbc_lb_Name.gridx = 1;
		gbc_lb_Name.gridy = 4;
		Hotel.add(lb_Name, gbc_lb_Name);
		
		insertName = new JTextField();
		GridBagConstraints gbc_insertName = new GridBagConstraints();
		gbc_insertName.insets = new Insets(0, 0, 5, 5);
		gbc_insertName.fill = GridBagConstraints.HORIZONTAL;
		gbc_insertName.gridx = 3;
		gbc_insertName.gridy = 4;
		Hotel.add(insertName, gbc_insertName);
		insertName.setColumns(10);
		
		JLabel lblInvalidHotelId = new JLabel("Invalid Hotel Id");
		GridBagConstraints gbc_lblInvalidHotelId = new GridBagConstraints();
		gbc_lblInvalidHotelId.insets = new Insets(0, 0, 5, 0);
		gbc_lblInvalidHotelId.gridx = 18;
		gbc_lblInvalidHotelId.gridy = 4;
		Hotel.add(lblInvalidHotelId, gbc_lblInvalidHotelId);
		lblInvalidHotelId.setVisible(false);
		
		
		JLabel lblName_1 = new JLabel("Name");
		GridBagConstraints gbc_lblName_1 = new GridBagConstraints();
		gbc_lblName_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblName_1.gridx = 8;
		gbc_lblName_1.gridy = 5;
		Hotel.add(lblName_1, gbc_lblName_1);
		
		update_H_Name = new JTextField();
		GridBagConstraints gbc_update_H_Name = new GridBagConstraints();
		gbc_update_H_Name.insets = new Insets(0, 0, 5, 5);
		gbc_update_H_Name.fill = GridBagConstraints.HORIZONTAL;
		gbc_update_H_Name.gridx = 10;
		gbc_update_H_Name.gridy = 5;
		Hotel.add(update_H_Name, gbc_update_H_Name);
		update_H_Name.setColumns(10);
		
		JLabel lblPhoneNumber_1 = new JLabel("Phone Number");
		GridBagConstraints gbc_lblPhoneNumber_1 = new GridBagConstraints();
		gbc_lblPhoneNumber_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber_1.gridx = 1;
		gbc_lblPhoneNumber_1.gridy = 6;
		Hotel.add(lblPhoneNumber_1, gbc_lblPhoneNumber_1);
		
		insertPhone = new JTextField();
		GridBagConstraints gbc_insertPhone = new GridBagConstraints();
		gbc_insertPhone.insets = new Insets(0, 0, 5, 5);
		gbc_insertPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_insertPhone.gridx = 3;
		gbc_insertPhone.gridy = 6;
		Hotel.add(insertPhone, gbc_insertPhone);
		insertPhone.setColumns(10);
		
		JLabel lblPhoneNumber_2 = new JLabel("Phone Number");
		GridBagConstraints gbc_lblPhoneNumber_2 = new GridBagConstraints();
		gbc_lblPhoneNumber_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber_2.gridx = 8;
		gbc_lblPhoneNumber_2.gridy = 6;
		Hotel.add(lblPhoneNumber_2, gbc_lblPhoneNumber_2);
		
		update_H_Phone = new JTextField();
		GridBagConstraints gbc_update_H_Phone = new GridBagConstraints();
		gbc_update_H_Phone.insets = new Insets(0, 0, 5, 5);
		gbc_update_H_Phone.fill = GridBagConstraints.HORIZONTAL;
		gbc_update_H_Phone.gridx = 10;
		gbc_update_H_Phone.gridy = 6;
		Hotel.add(update_H_Phone, gbc_update_H_Phone);
		update_H_Phone.setColumns(10);
		
		JLabel lblZipCode = new JLabel("Zip Code");
		GridBagConstraints gbc_lblZipCode = new GridBagConstraints();
		gbc_lblZipCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblZipCode.gridx = 1;
		gbc_lblZipCode.gridy = 7;
		Hotel.add(lblZipCode, gbc_lblZipCode);
		
		insertZip = new JTextField();
		GridBagConstraints gbc_insertZip = new GridBagConstraints();
		gbc_insertZip.insets = new Insets(0, 0, 5, 5);
		gbc_insertZip.fill = GridBagConstraints.HORIZONTAL;
		gbc_insertZip.gridx = 3;
		gbc_insertZip.gridy = 7;
		Hotel.add(insertZip, gbc_insertZip);
		insertZip.setColumns(10);

		
		JLabel lblZipCode_1 = new JLabel("Zip Code");
		GridBagConstraints gbc_lblZipCode_1 = new GridBagConstraints();
		gbc_lblZipCode_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblZipCode_1.gridx = 8;
		gbc_lblZipCode_1.gridy = 7;
		Hotel.add(lblZipCode_1, gbc_lblZipCode_1);
		
		JButton hInsertOk = new JButton("OK");
		hInsertOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get values from the form
				String name = insertName.getText();
				String phone = insertPhone.getText();
				String zip_code = insertZip.getText();
				//insert the data of the hotel into the database
				boolean b = insertHotel(name, phone, zip_code);
				//Notify user of error
				lblInvalidArguments.setVisible(!b);
			}
		});
		
		updateZipCode = new JTextField();
		GridBagConstraints gbc_updateZipCode = new GridBagConstraints();
		gbc_updateZipCode.insets = new Insets(0, 0, 5, 5);
		gbc_updateZipCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateZipCode.gridx = 10;
		gbc_updateZipCode.gridy = 7;
		Hotel.add(updateZipCode, gbc_updateZipCode);
		updateZipCode.setColumns(10);
		
		JLabel lblInvalidData = new JLabel("Invalid Data");
		GridBagConstraints gbc_lblInvalidData = new GridBagConstraints();
		gbc_lblInvalidData.insets = new Insets(0, 0, 0, 5);
		gbc_lblInvalidData.gridx = 1;
		gbc_lblInvalidData.gridy = 8;
		Hotel.add(lblInvalidData, gbc_lblInvalidData);
		lblInvalidData.setVisible(false);
		
		JLabel lblFailed = new JLabel("Failed!");
		GridBagConstraints gbc_lblFailed = new GridBagConstraints();
		gbc_lblFailed.insets = new Insets(0, 0, 0, 5);
		gbc_lblFailed.gridx = 8;
		gbc_lblFailed.gridy = 8;
		Hotel.add(lblFailed, gbc_lblFailed);
		lblFailed.setVisible(false);
		
		GridBagConstraints gbc_hInsertOk = new GridBagConstraints();
		gbc_hInsertOk.insets = new Insets(0, 0, 0, 5);
		gbc_hInsertOk.gridx = 3;
		gbc_hInsertOk.gridy = 8;
		Hotel.add(hInsertOk, gbc_hInsertOk);
		
		JButton hUpdateOk = new JButton("OK");
		hUpdateOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get values from form
				int hotelId = Integer.parseInt(updateHotelID.getText());
				String name = update_H_Name.getText();
				String phone_number = update_H_Phone.getText();
				String zip_code = updateZipCode.getText();
				// update values in the hotel ltable
				boolean b = updateHotel(hotelId, name, phone_number, zip_code);
				//notify user for the error
				lblFailed.setVisible(!b);
			}

			
		});
		
		
		
		
		GridBagConstraints gbc_hUpdateOk = new GridBagConstraints();
		gbc_hUpdateOk.insets = new Insets(0, 0, 0, 5);
		gbc_hUpdateOk.gridx = 10;
		gbc_hUpdateOk.gridy = 8;
		Hotel.add(hUpdateOk, gbc_hUpdateOk);
		lblFailed.setVisible(false);
		
		JButton HDeleteOK = new JButton("OK");
		HDeleteOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hotelId = Integer.parseInt(DeleteHotelID.getText());
				//delete hotel if hotel exists
				boolean b = deleteHotel(hotelId);
				//if failed give error
				lblInvalidHotelId.setVisible(!b);
			}
		});
		GridBagConstraints gbc_HDeleteOK = new GridBagConstraints();
		gbc_HDeleteOK.gridx = 18;
		gbc_HDeleteOK.gridy = 8;
		Hotel.add(HDeleteOK, gbc_HDeleteOK);
		
		JPanel Locations = new JPanel();
		tabbedPane.addTab("Locations", null, Locations, null);
		GridBagLayout gbl_Locations = new GridBagLayout();
		gbl_Locations.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Locations.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Locations.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_Locations.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Locations.setLayout(gbl_Locations);
		
		JLabel lblInvalidZip_1 = new JLabel("Invalid Zip");
		GridBagConstraints gbc_lblInvalidZip_1 = new GridBagConstraints();
		gbc_lblInvalidZip_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblInvalidZip_1.gridx = 19;
		gbc_lblInvalidZip_1.gridy = 3;
		Locations.add(lblInvalidZip_1, gbc_lblInvalidZip_1);
		lblInvalidZip_1.setVisible(false);
		
		
		JLabel lblInsert_2 = new JLabel("Insert");
		GridBagConstraints gbc_lblInsert_2 = new GridBagConstraints();
		gbc_lblInsert_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsert_2.gridx = 3;
		gbc_lblInsert_2.gridy = 0;
		Locations.add(lblInsert_2, gbc_lblInsert_2);
		
		JLabel lblUpdate_2 = new JLabel("Update");
		GridBagConstraints gbc_lblUpdate_2 = new GridBagConstraints();
		gbc_lblUpdate_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblUpdate_2.gridx = 10;
		gbc_lblUpdate_2.gridy = 0;
		Locations.add(lblUpdate_2, gbc_lblUpdate_2);
		
		JLabel lblDelete_2 = new JLabel("Delete");
		GridBagConstraints gbc_lblDelete_2 = new GridBagConstraints();
		gbc_lblDelete_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblDelete_2.gridx = 19;
		gbc_lblDelete_2.gridy = 0;
		Locations.add(lblDelete_2, gbc_lblDelete_2);
		
		JLabel lblIlegalArguments = new JLabel("Ilegal Arguments");
		GridBagConstraints gbc_lblIlegalArguments = new GridBagConstraints();
		gbc_lblIlegalArguments.insets = new Insets(0, 0, 0, 5);
		gbc_lblIlegalArguments.gridx = 10;
		gbc_lblIlegalArguments.gridy = 12;
		Locations.add(lblIlegalArguments, gbc_lblIlegalArguments);
		lblIlegalArguments.setVisible(false);
		
		
		JLabel lblZipcode_1 = new JLabel("ZipCode");
		GridBagConstraints gbc_lblZipcode_1 = new GridBagConstraints();
		gbc_lblZipcode_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblZipcode_1.gridx = 8;
		gbc_lblZipcode_1.gridy = 2;
		Locations.add(lblZipcode_1, gbc_lblZipcode_1);
		
		updateHZipcode = new JTextField();
		GridBagConstraints gbc_updateHZipcode = new GridBagConstraints();
		gbc_updateHZipcode.insets = new Insets(0, 0, 5, 5);
		gbc_updateHZipcode.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateHZipcode.gridx = 10;
		gbc_updateHZipcode.gridy = 2;
		Locations.add(updateHZipcode, gbc_updateHZipcode);
		updateHZipcode.setColumns(10);
		
		JLabel lblZipcode_2 = new JLabel("ZipCode");
		GridBagConstraints gbc_lblZipcode_2 = new GridBagConstraints();
		gbc_lblZipcode_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblZipcode_2.gridx = 17;
		gbc_lblZipcode_2.gridy = 2;
		Locations.add(lblZipcode_2, gbc_lblZipcode_2);
		
		deleteZip = new JTextField();
		GridBagConstraints gbc_deleteZip = new GridBagConstraints();
		gbc_deleteZip.insets = new Insets(0, 0, 5, 0);
		gbc_deleteZip.fill = GridBagConstraints.HORIZONTAL;
		gbc_deleteZip.gridx = 19;
		gbc_deleteZip.gridy = 2;
		Locations.add(deleteZip, gbc_deleteZip);
		deleteZip.setColumns(10);
		
		JLabel lblZipcode = new JLabel("ZipCode");
		GridBagConstraints gbc_lblZipcode = new GridBagConstraints();
		gbc_lblZipcode.insets = new Insets(0, 0, 5, 5);
		gbc_lblZipcode.gridx = 1;
		gbc_lblZipcode.gridy = 3;
		Locations.add(lblZipcode, gbc_lblZipcode);
		
		JLabel lblInvalidZip = new JLabel("Invalid Zip");
		GridBagConstraints gbc_lblInvalidZip = new GridBagConstraints();
		gbc_lblInvalidZip.insets = new Insets(0, 0, 5, 5);
		gbc_lblInvalidZip.gridx = 10;
		gbc_lblInvalidZip.gridy = 4;
		Locations.add(lblInvalidZip, gbc_lblInvalidZip);
		lblInvalidZip.setVisible(false);
		
		insertHZip = new JTextField();
		GridBagConstraints gbc_insertHZip = new GridBagConstraints();
		gbc_insertHZip.insets = new Insets(0, 0, 5, 5);
		gbc_insertHZip.fill = GridBagConstraints.HORIZONTAL;
		gbc_insertHZip.gridx = 3;
		gbc_insertHZip.gridy = 3;
		Locations.add(insertHZip, gbc_insertHZip);
		insertHZip.setColumns(10);
		
		JButton btnConfirm_1 = new JButton("Confirm");
		btnConfirm_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String zip = updateHZipcode.getText();
				ResultSet result;
				try {
					// populate the fields from the values in the database
					result = smt.executeQuery("Select * from Locations where zip_code="+zip);
					while(result.next()){
						updateHAddress.setText(result.getString("address"));
						updateHCity.setText(result.getString("city"));
						updateHRate.setText(Float.toString(result.getFloat("rate")));
					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblInvalidZip.setVisible(true);
					
				}
				
			}
		});
		GridBagConstraints gbc_btnConfirm_1 = new GridBagConstraints();
		gbc_btnConfirm_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirm_1.gridx = 10;
		gbc_btnConfirm_1.gridy = 3;
		Locations.add(btnConfirm_1, gbc_btnConfirm_1);
		
		
		
		
		JButton deleteLocation = new JButton("Delete");
		deleteLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String zipCode= deleteZip.getText();
				boolean b;
				b = deleteLocation(zipCode);
				lblInvalidZip_1.setVisible(!b);
			}

			
		});
		GridBagConstraints gbc_deleteLocation = new GridBagConstraints();
		gbc_deleteLocation.insets = new Insets(0, 0, 5, 0);
		gbc_deleteLocation.gridx = 19;
		gbc_deleteLocation.gridy = 4;
		Locations.add(deleteLocation, gbc_deleteLocation);
		
		JLabel lblAddress_1 = new JLabel("Address");
		GridBagConstraints gbc_lblAddress_1 = new GridBagConstraints();
		gbc_lblAddress_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress_1.gridx = 1;
		gbc_lblAddress_1.gridy = 5;
		Locations.add(lblAddress_1, gbc_lblAddress_1);
		
		insertHAddress = new JTextField();
		GridBagConstraints gbc_insertHAddress = new GridBagConstraints();
		gbc_insertHAddress.insets = new Insets(0, 0, 5, 5);
		gbc_insertHAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_insertHAddress.gridx = 3;
		gbc_insertHAddress.gridy = 5;
		Locations.add(insertHAddress, gbc_insertHAddress);
		insertHAddress.setColumns(10);
		
		JLabel lblAddress_2 = new JLabel("Address");
		GridBagConstraints gbc_lblAddress_2 = new GridBagConstraints();
		gbc_lblAddress_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress_2.gridx = 8;
		gbc_lblAddress_2.gridy = 5;
		Locations.add(lblAddress_2, gbc_lblAddress_2);
		
		updateHAddress = new JTextField();
		GridBagConstraints gbc_updateHAddress = new GridBagConstraints();
		gbc_updateHAddress.insets = new Insets(0, 0, 5, 5);
		gbc_updateHAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateHAddress.gridx = 10;
		gbc_updateHAddress.gridy = 5;
		Locations.add(updateHAddress, gbc_updateHAddress);
		updateHAddress.setColumns(10);
		
		JLabel lblRate = new JLabel("Rate");
		GridBagConstraints gbc_lblRate = new GridBagConstraints();
		gbc_lblRate.insets = new Insets(0, 0, 5, 5);
		gbc_lblRate.gridx = 1;
		gbc_lblRate.gridy = 7;
		Locations.add(lblRate, gbc_lblRate);
		
		insertHRate = new JTextField();
		GridBagConstraints gbc_insertHRate = new GridBagConstraints();
		gbc_insertHRate.insets = new Insets(0, 0, 5, 5);
		gbc_insertHRate.fill = GridBagConstraints.HORIZONTAL;
		gbc_insertHRate.gridx = 3;
		gbc_insertHRate.gridy = 7;
		Locations.add(insertHRate, gbc_insertHRate);
		insertHRate.setColumns(10);
		
		JLabel lblRate_1 = new JLabel("Rate");
		GridBagConstraints gbc_lblRate_1 = new GridBagConstraints();
		gbc_lblRate_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblRate_1.gridx = 8;
		gbc_lblRate_1.gridy = 7;
		Locations.add(lblRate_1, gbc_lblRate_1);
		
		updateHRate = new JTextField();
		GridBagConstraints gbc_updateHRate = new GridBagConstraints();
		gbc_updateHRate.insets = new Insets(0, 0, 5, 5);
		gbc_updateHRate.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateHRate.gridx = 10;
		gbc_updateHRate.gridy = 7;
		Locations.add(updateHRate, gbc_updateHRate);
		updateHRate.setColumns(10);
		
		JLabel lblCity_1 = new JLabel("City");
		GridBagConstraints gbc_lblCity_1 = new GridBagConstraints();
		gbc_lblCity_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity_1.gridx = 1;
		gbc_lblCity_1.gridy = 9;
		Locations.add(lblCity_1, gbc_lblCity_1);
		
		inserHCity = new JTextField();
		GridBagConstraints gbc_inserHCity = new GridBagConstraints();
		gbc_inserHCity.insets = new Insets(0, 0, 5, 5);
		gbc_inserHCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_inserHCity.gridx = 3;
		gbc_inserHCity.gridy = 9;
		Locations.add(inserHCity, gbc_inserHCity);
		inserHCity.setColumns(10);
		
		JLabel lblCity_2 = new JLabel("City");
		GridBagConstraints gbc_lblCity_2 = new GridBagConstraints();
		gbc_lblCity_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity_2.gridx = 8;
		gbc_lblCity_2.gridy = 9;
		Locations.add(lblCity_2, gbc_lblCity_2);
		
		JLabel lblInvalidAgrumenets = new JLabel("Invalid Agruments");
		GridBagConstraints gbc_lblInvalidAgrumenets = new GridBagConstraints();
		gbc_lblInvalidAgrumenets.insets = new Insets(0, 0, 0, 5);
		gbc_lblInvalidAgrumenets.gridx = 3;
		gbc_lblInvalidAgrumenets.gridy = 12;
		Locations.add(lblInvalidAgrumenets, gbc_lblInvalidAgrumenets);
		lblInvalidAgrumenets.setVisible(false);
		
		updateHCity = new JTextField();
		GridBagConstraints gbc_updateHCity = new GridBagConstraints();
		gbc_updateHCity.insets = new Insets(0, 0, 5, 5);
		gbc_updateHCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateHCity.gridx = 10;
		gbc_updateHCity.gridy = 9;
		Locations.add(updateHCity, gbc_updateHCity);
		updateHCity.setColumns(10);
		
		JButton insertLocation = new JButton("OK");
		insertLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String zip = insertHZip.getText();
				String address = insertHAddress.getText();
				float rate = Float.parseFloat(insertHRate.getText());
				String city = inserHCity.getText();
				
			 boolean b =insertLocation(zip, address, rate, city);
			 lblInvalidAgrumenets.setVisible(!b);
			}
		});
		GridBagConstraints gbc_insertLocation = new GridBagConstraints();
		gbc_insertLocation.insets = new Insets(0, 0, 5, 5);
		gbc_insertLocation.gridx = 3;
		gbc_insertLocation.gridy = 11;
		Locations.add(insertLocation, gbc_insertLocation);
		
		JButton updateLocation = new JButton("OK");
		updateLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				boolean b;
				//get values from the form
				String zip = updateHZipcode.getText();
				updateHZipcode.setEditable(false);
				String address = updateHAddress.getText();
				float rate = Float.parseFloat(updateHRate.getText());
				String city = updateHCity.getText();
				//update the locations
				b = updateLocations(zip, address, rate, city);
				//Display error message if any error
				lblIlegalArguments.setVisible(!b);
			}
		});
		GridBagConstraints gbc_updateLocation = new GridBagConstraints();
		gbc_updateLocation.insets = new Insets(0, 0, 5, 5);
		gbc_updateLocation.gridx = 10;
		gbc_updateLocation.gridy = 11;
		Locations.add(updateLocation, gbc_updateLocation);
		
		JPanel Customer = new JPanel();
		tabbedPane.addTab("Customer", null, Customer, null);
		GridBagLayout gbl_Customer = new GridBagLayout();
		gbl_Customer.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Customer.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_Customer.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_Customer.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		Customer.setLayout(gbl_Customer);
		
		JLabel lblInsert_3 = new JLabel("Insert");
		GridBagConstraints gbc_lblInsert_3 = new GridBagConstraints();
		gbc_lblInsert_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsert_3.gridx = 3;
		gbc_lblInsert_3.gridy = 0;
		Customer.add(lblInsert_3, gbc_lblInsert_3);
		
		JLabel lblUpdate_3 = new JLabel("Update");
		GridBagConstraints gbc_lblUpdate_3 = new GridBagConstraints();
		gbc_lblUpdate_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblUpdate_3.gridx = 10;
		gbc_lblUpdate_3.gridy = 0;
		Customer.add(lblUpdate_3, gbc_lblUpdate_3);
		
		JLabel lblDelete_3 = new JLabel("Delete");
		GridBagConstraints gbc_lblDelete_3 = new GridBagConstraints();
		gbc_lblDelete_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblDelete_3.gridx = 16;
		gbc_lblDelete_3.gridy = 0;
		Customer.add(lblDelete_3, gbc_lblDelete_3);
		
		JLabel lblCustomerId_2 = new JLabel("Customer ID");
		GridBagConstraints gbc_lblCustomerId_2 = new GridBagConstraints();
		gbc_lblCustomerId_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomerId_2.gridx = 6;
		gbc_lblCustomerId_2.gridy = 2;
		Customer.add(lblCustomerId_2, gbc_lblCustomerId_2);
		
		updateCId = new JTextField();
		GridBagConstraints gbc_updateCId = new GridBagConstraints();
		gbc_updateCId.insets = new Insets(0, 0, 5, 5);
		gbc_updateCId.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateCId.gridx = 8;
		gbc_updateCId.gridy = 2;
		Customer.add(updateCId, gbc_updateCId);
		updateCId.setColumns(10);
		
		JLabel lblCustomerId_3 = new JLabel("Customer ID");
		GridBagConstraints gbc_lblCustomerId_3 = new GridBagConstraints();
		gbc_lblCustomerId_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomerId_3.gridx = 13;
		gbc_lblCustomerId_3.gridy = 2;
		Customer.add(lblCustomerId_3, gbc_lblCustomerId_3);
		
		deleteCId = new JTextField();
		GridBagConstraints gbc_deleteCId = new GridBagConstraints();
		gbc_deleteCId.gridwidth = 2;
		gbc_deleteCId.insets = new Insets(0, 0, 5, 0);
		gbc_deleteCId.fill = GridBagConstraints.HORIZONTAL;
		gbc_deleteCId.gridx = 15;
		gbc_deleteCId.gridy = 2;
		Customer.add(deleteCId, gbc_deleteCId);
		deleteCId.setColumns(10);
		
		JLabel lblInvalidId = new JLabel("Invalid Id!");
		GridBagConstraints gbc_lblInvalidId = new GridBagConstraints();
		gbc_lblInvalidId.insets = new Insets(0, 0, 5, 5);
		gbc_lblInvalidId.gridx = 15;
		gbc_lblInvalidId.gridy = 3;
		Customer.add(lblInvalidId, gbc_lblInvalidId);
		lblInvalidId.setVisible(false);
		
		JLabel lblName_2 = new JLabel("Name");
		GridBagConstraints gbc_lblName_2 = new GridBagConstraints();
		gbc_lblName_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblName_2.gridx = 1;
		gbc_lblName_2.gridy = 4;
		Customer.add(lblName_2, gbc_lblName_2);
		
		insertCName = new JTextField();
		GridBagConstraints gbc_insertCName = new GridBagConstraints();
		gbc_insertCName.insets = new Insets(0, 0, 5, 5);
		gbc_insertCName.fill = GridBagConstraints.HORIZONTAL;
		gbc_insertCName.gridx = 3;
		gbc_insertCName.gridy = 4;
		Customer.add(insertCName, gbc_insertCName);
		insertCName.setColumns(10);
		
		JLabel lblInvalidCId = new JLabel("Invalid C ID!!!");
		GridBagConstraints gbc_lblInvalidCId = new GridBagConstraints();
		gbc_lblInvalidCId.insets = new Insets(0, 0, 5, 5);
		gbc_lblInvalidCId.gridx = 6;
		gbc_lblInvalidCId.gridy = 4;
		Customer.add(lblInvalidCId, gbc_lblInvalidCId);
		lblInvalidCId.setVisible(false);
		
		JButton btnConfirm_2 = new JButton("Confirm");
		btnConfirm_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int customerId = Integer.parseInt(updateCId.getText());
				boolean flag=false;
				try {
					//get data of the customer from database
					ResultSet rs = smt.executeQuery("SELECT * from Customers where id="+customerId);
					
					while(rs.next()){
						flag = true;
						updateCName.setText(rs.getString("name"));
						updateCDOB.setText(rs.getString("DOB"));
						updateCEmail.setText(rs.getString("email"));
						updateCPhoneNumber.setText(rs.getString("phone_number"));
						
						
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					flag = false;
					//update flag for exception
				}
				//if no data exists or if error display message
				lblInvalidCId.setVisible(!flag);
			}
		});
		GridBagConstraints gbc_btnConfirm_2 = new GridBagConstraints();
		gbc_btnConfirm_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirm_2.gridx = 8;
		gbc_btnConfirm_2.gridy = 4;
		Customer.add(btnConfirm_2, gbc_btnConfirm_2);
		
		JLabel lblDob = new JLabel("DOB");
		GridBagConstraints gbc_lblDob = new GridBagConstraints();
		gbc_lblDob.insets = new Insets(0, 0, 5, 5);
		gbc_lblDob.gridx = 1;
		gbc_lblDob.gridy = 5;
		Customer.add(lblDob, gbc_lblDob);
		
		insertCDOB = new JTextField();
		GridBagConstraints gbc_insertCDOB = new GridBagConstraints();
		gbc_insertCDOB.insets = new Insets(0, 0, 5, 5);
		gbc_insertCDOB.fill = GridBagConstraints.HORIZONTAL;
		gbc_insertCDOB.gridx = 3;
		gbc_insertCDOB.gridy = 5;
		Customer.add(insertCDOB, gbc_insertCDOB);
		insertCDOB.setColumns(10);
		
		JLabel lblName_3 = new JLabel("Name");
		GridBagConstraints gbc_lblName_3 = new GridBagConstraints();
		gbc_lblName_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblName_3.gridx = 6;
		gbc_lblName_3.gridy = 5;
		Customer.add(lblName_3, gbc_lblName_3);
		
		updateCName = new JTextField();
		GridBagConstraints gbc_updateCName = new GridBagConstraints();
		gbc_updateCName.insets = new Insets(0, 0, 5, 5);
		gbc_updateCName.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateCName.gridx = 8;
		gbc_updateCName.gridy = 5;
		Customer.add(updateCName, gbc_updateCName);
		updateCName.setColumns(10);
		
		JButton btnOk_1 = new JButton("OK");
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int id = Integer.parseInt(deleteCId.getText());
				boolean b = deleteCustomer(id);
				lblInvalidId.setVisible(!b);
			}
		});
		GridBagConstraints gbc_btnOk_1 = new GridBagConstraints();
		gbc_btnOk_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnOk_1.gridx = 16;
		gbc_btnOk_1.gridy = 5;
		Customer.add(btnOk_1, gbc_btnOk_1);
		
		JLabel lblEmail = new JLabel("email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 6;
		Customer.add(lblEmail, gbc_lblEmail);
		
		insertCEmail = new JTextField();
		GridBagConstraints gbc_insertCEmail = new GridBagConstraints();
		gbc_insertCEmail.insets = new Insets(0, 0, 5, 5);
		gbc_insertCEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_insertCEmail.gridx = 3;
		gbc_insertCEmail.gridy = 6;
		Customer.add(insertCEmail, gbc_insertCEmail);
		insertCEmail.setColumns(10);
		
		JLabel lblDob_1 = new JLabel("DOB");
		GridBagConstraints gbc_lblDob_1 = new GridBagConstraints();
		gbc_lblDob_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDob_1.gridx = 6;
		gbc_lblDob_1.gridy = 6;
		Customer.add(lblDob_1, gbc_lblDob_1);
		
		updateCDOB = new JTextField();
		GridBagConstraints gbc_updateCDOB = new GridBagConstraints();
		gbc_updateCDOB.insets = new Insets(0, 0, 5, 5);
		gbc_updateCDOB.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateCDOB.gridx = 8;
		gbc_updateCDOB.gridy = 6;
		Customer.add(updateCDOB, gbc_updateCDOB);
		updateCDOB.setColumns(10);
		
		JLabel lblPhoneNumber_3 = new JLabel("Phone number");
		GridBagConstraints gbc_lblPhoneNumber_3 = new GridBagConstraints();
		gbc_lblPhoneNumber_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber_3.gridx = 1;
		gbc_lblPhoneNumber_3.gridy = 7;
		Customer.add(lblPhoneNumber_3, gbc_lblPhoneNumber_3);
		
		insertCPhoneNumber = new JTextField();
		GridBagConstraints gbc_insertCPhoneNumber = new GridBagConstraints();
		gbc_insertCPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_insertCPhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_insertCPhoneNumber.gridx = 3;
		gbc_insertCPhoneNumber.gridy = 7;
		Customer.add(insertCPhoneNumber, gbc_insertCPhoneNumber);
		insertCPhoneNumber.setColumns(10);
		
		JLabel lblEmail_1 = new JLabel("Email");
		GridBagConstraints gbc_lblEmail_1 = new GridBagConstraints();
		gbc_lblEmail_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail_1.gridx = 6;
		gbc_lblEmail_1.gridy = 7;
		Customer.add(lblEmail_1, gbc_lblEmail_1);
		
		updateCEmail = new JTextField();
		GridBagConstraints gbc_updateCEmail = new GridBagConstraints();
		gbc_updateCEmail.insets = new Insets(0, 0, 5, 5);
		gbc_updateCEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateCEmail.gridx = 8;
		gbc_updateCEmail.gridy = 7;
		Customer.add(updateCEmail, gbc_updateCEmail);
		updateCEmail.setColumns(10);
		
		JLabel lblFailedToInsert = new JLabel("Failed to insert");
		GridBagConstraints gbc_lblFailedToInsert = new GridBagConstraints();
		gbc_lblFailedToInsert.insets = new Insets(0, 0, 5, 5);
		gbc_lblFailedToInsert.gridx = 3;
		gbc_lblFailedToInsert.gridy = 8;
		Customer.add(lblFailedToInsert, gbc_lblFailedToInsert);
		
		JButton insertCOK = new JButton("OK");
		insertCOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get values from the Form
				String name = insertCName.getText();
				String DOB= insertCDOB.getText();
				String email = insertCEmail.getText();
				String phone_number = insertCPhoneNumber.getText();
				//Insert the Customer data in database
				boolean b = insertCustomer(name, DOB, email, phone_number);
				//  Display if any error
				lblFailedToInsert.setVisible(!b);
			}
		});
		
		JLabel lblPhoneNumber_4 = new JLabel("Phone Number");
		GridBagConstraints gbc_lblPhoneNumber_4 = new GridBagConstraints();
		gbc_lblPhoneNumber_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber_4.gridx = 6;
		gbc_lblPhoneNumber_4.gridy = 8;
		Customer.add(lblPhoneNumber_4, gbc_lblPhoneNumber_4);
		
		updateCPhoneNumber = new JTextField();
		GridBagConstraints gbc_updateCPhoneNumber = new GridBagConstraints();
		gbc_updateCPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_updateCPhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_updateCPhoneNumber.gridx = 8;
		gbc_updateCPhoneNumber.gridy = 8;
		Customer.add(updateCPhoneNumber, gbc_updateCPhoneNumber);
		updateCPhoneNumber.setColumns(10);
		
		JLabel lblFailedToUpdate = new JLabel("Failed to update");
		GridBagConstraints gbc_lblFailedToUpdate = new GridBagConstraints();
		gbc_lblFailedToUpdate.insets = new Insets(0, 0, 5, 5);
		gbc_lblFailedToUpdate.gridx = 8;
		gbc_lblFailedToUpdate.gridy = 9;
		Customer.add(lblFailedToUpdate, gbc_lblFailedToUpdate);
		GridBagConstraints gbc_insertCOK = new GridBagConstraints();
		gbc_insertCOK.insets = new Insets(0, 0, 0, 5);
		gbc_insertCOK.gridx = 3;
		gbc_insertCOK.gridy = 10;
		Customer.add(insertCOK, gbc_insertCOK);
		lblFailedToUpdate.setVisible(false);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(updateCId.getText());
				String name = updateCName.getText();
				String DOB = updateCDOB.getText();
				String email = updateCEmail.getText();
				String phone_number = updateCPhoneNumber.getText();
				// Update Customer data in the database
				boolean b = updateCustomer(id, name, DOB, email, phone_number);
				// Notify of errors
				lblFailedToUpdate.setVisible(!b);
				
				
			}
		});
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 0, 5);
		gbc_btnOk.gridx = 8;
		gbc_btnOk.gridy = 10;
		Customer.add(btnOk, gbc_btnOk);
		lblFailedToInsert.setVisible(false);
		
	
		
//		JLabel lblInvalidAgrumenets = new JLabel("Invalid Agruments");
//		GridBagConstraints gbc_lblInvalidAgrumenets = new GridBagConstraints();
//		gbc_lblInvalidAgrumenets.insets = new Insets(0, 0, 0, 5);
//		gbc_lblInvalidAgrumenets.gridx = 3;
//		gbc_lblInvalidAgrumenets.gridy = 12;
//		panel_6.add(lblInvalidAgrumenets, gbc_lblInvalidAgrumenets);
//		lblInvalidAgrumenets.setVisible(false);
		
		
	}

	

	private void initEvents() {
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerID = textField_5.getText();
				String start_date = textField_6.getText();
				String end_date =textField_7.getText();
				String hotelID = textField_8.getText();
				String type = textField_18.getText();
				String city = textField_19.getText();
				String capacity= textField_20.getText();
				
				
				try{
			       	connection.setAutoCommit(false);
					assignRoomsByRequest(Integer.parseInt(hotelID), Integer.parseInt(customerID), type, start_date, end_date, city,Integer.parseInt(capacity));
			       	connection.commit();
			       	}
			       	catch(SQLException ex){
			       		ex.printStackTrace();
			       		try{
			       		if(connection!=null){
							   //Roll back transations if error occurs
			       			System.out.println("Transaction is being rolled back");
			       			connection.rollback();
			       		}
			       		}
			       		catch(SQLException excep){
			       			excep.printStackTrace();
			       		}
			       	}
			       	try{
			       		connection.setAutoCommit(true);
			       	}
			       	catch(SQLException exc){
			       		exc.printStackTrace();
			       	}
			       	
				checkinTA.setText("Successfully checked you in!");
				checkinTA.setVisible(true);
			}
		});
		
		btnGenerateBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customerID = textField_4.getText();
				String resultStr="";
				try{
					//  Get the cost of services
					result=smt.executeQuery("SELECT SUM(rates) as Total from(select sum(se.rate*pr.count) as rates from Services se,Pricings pr where se.service_name=pr.service_name and pr.service_name in(select p.service_name from Pricings p where p.checkin_id in(select checkin_id from Done_by where customer_id="+customerID+" group by checkin_id)group by p.service_name) UNION ALL select sum(ps.nightly_rate) as rates from Pricings ps where ps.checkin_id in(select d.checkin_id from Done_by d where customer_id="+customerID+")group by ps.checkin_id UNION ALL select sum(c.rate) from Category c,Rooms r where r.category_name=c.category_name and r.room_number in(select p.room_number from Pricings p where p.hotel_id =(select hotel_id from Pricings where checkin_id in(select checkin_id from Done_by where customer_id="+customerID+")group by checkin_id))UNION ALL SELECT l.rate as rates from Locations l,Hotels h where l.zip_code=h.zip_code and h.id =(select hotel_id from Pricings where checkin_id in(select checkin_id from Done_by where customer_id="+customerID+")group by checkin_id))Item");
				while(result.next()){
					resultStr+="\n"+"The total bill is "+result.getInt("Total");
					System.out.println("The total bill is "+result.getInt("Total"));
				}

				textArea_1.setText(resultStr);
				}
				catch(SQLException ex){
					ex.printStackTrace();
				}
			}
		});
		
		btnCheckAvailability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String room_number = textField.getText();
				String hotel_id = textField_1.getText();
				String room_type = textField_13.getText();
				
				boolean hId = !hotel_id.equals("");
				boolean roomNumber = !room_number.equals("");
				boolean roomType = !room_type.equals("");
				//Create where clause if hotel id and/or room number and/or category are provided
				String sub ="";
				if(hId){
					sub = sub + " AND hotel_id="+hotel_id;
					if(roomNumber)
						sub = sub + " AND room_number="+room_number;
					if(roomType)
						sub = sub + " AND category_name='"+room_type+"'";
				}

				//if only room category is given
				if(!hId && roomType){
					sub = " AND category_name='"+room_type+"'";
				}
				
				
				
				String resultStr="";
				
				
					
				try {
					
			        //Find rooms that are available today by eliminating hotel rooms that are not available today
					//Add additional "where" conditions for room number and hotel id OR category_name of the room 
					result = smt.executeQuery("SELECT * FROM Rooms WHERE (room_number, hotel_id) NOT IN (SELECT room_number, hotel_id from Reservations WHERE start_date <= CURDATE() AND end_date>=CURDATE()) "+sub);
					while(result.next()){
			  
			        	int rno=result.getInt("room_number");
			        	int hotelid=result.getInt("hotel_id");
						resultStr+="\n"+"Room number "+rno+" is available in hotel "+hotelid;
			        	System.out.println("Room number "+rno+" is available in hotel "+hotelid);
			        }
					//populate the text area with the results found
			        textArea.setText(resultStr);
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				
			}
		});
	}
	
	private void assignRoomsByRequest(int hotelID,int customerID, String categoryName,String startDate,String endDate,String city, int number_of_guests) throws SQLException {
		int[] roomhotel = reportOccupancyBasedOnRequest(hotelID, categoryName, startDate, endDate,city);
		if(roomhotel[0]==-1)
		{
			System.out.println("Room not available while checkin");
			return;
		}
		//If needed
		// insertIntoCustomers("Tony Stark", "750123456","1975-02-21", "stark@gmail.com");	
		try{
		result=smt.executeQuery("select id from Customers where id="+customerID+"");
		
		if(!result.next())
		{   Scanner s=new Scanner(System.in);
		    System.out.println("Enter the customer's name:");
			String name=s.next();
			System.out.println("Enter the customer's dob:");
			String dob=s.next();
			System.out.println("Enter the customer's email:");
			String emailID=s.next();
			System.out.println("Enter the customer's phone_number:");
			String phone_number=s.next();
			try{
			smt.executeUpdate("INSERT INTO Customers(name, DOB, email, phone_number) VALUES ('"+name+"','"+dob+"','"+emailID+"', '"+phone_number+"')");
			}
			catch(SQLException ed){
				ed.printStackTrace();
			}
		 }
		else {
			System.out.println("Customer already exists in the DB");
		}
		}
		catch(SQLException er){
			er.printStackTrace();
		}
			
		insertIntoReservations(roomhotel[0], roomhotel[1], startDate, endDate);
		int checkinID = insertIntoCheckins(number_of_guests,hotelID, startDate, endDate);
		insertIntoDoneBy(checkinID, customerID);
        
		if(categoryName == "Presidential Suite") {
			int[]staffs=findAvailableStaffs(hotelID);
			if(staffs[0]==-1)
			{
			  System.out.println("Staffs not available");
			  return;
			}
			
			insertIntoServes(staffs[0], hotelID, "HouseKeeping",checkinID);
			insertIntoServes(staffs[1], hotelID, "Catering",checkinID);
			smt.executeQuery("UPDATE Staffs SET availability='No' where id in ("+staffs[0]+","+staffs[1]+") and hotel_id="+hotelID+"");
		}
		
	}
	
	private int[] reportOccupancyBasedOnRequest(int hotelID, String category_name, String startDate,String endDate,String city) {
		int[]answer=new int[2];
		try {
				result=smt.executeQuery("SELECT * FROM Reservations r, Hotels h where r.hotel_id="+hotelID+" and r. room_number in"
											 +"(select room_number from Rooms where category_name='"+category_name+"' and hotel_id="+hotelID+" )"
											 +"and r.start_date>='"+startDate+"' and r.end_Date<='"+endDate+"' and h.zip_code in "
											 +"(select zip_code from Locations where city='"+city+"')");
				if(result.next()){
					int rno=result.getInt("room_number");
					int hotelid=result.getInt("hotel_id");
					answer[0]=rno;
					answer[1]=hotelid;
				}
				else
				{
					System.out.println("ROOMS not available");
					answer[0]=-1;
					answer[1]=-1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return answer;
	}

	private void insertIntoReservations(int room_number,int hotelID, String startDate,String endDate) {
		try{
			//insert values into Reservations table
			//get the Rooms where the specific room number and room id are hotel id
		result=smt.executeQuery("SELECT * from Rooms where room_number="+room_number+" and hotel_id="+hotelID+"");
		//insert into reservations for those rooms
		if(result.next())
			smt.executeUpdate("INSERT INTO Reservations VALUES ("+room_number+", "+hotelID+", '"+startDate+"','"+endDate+"')");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		}

	private int insertIntoCheckins(int number_of_guests,int hotel_id, String startDate,String endDate) throws SQLException {
		int cid=0;
//		statement.executeUpdate("INSERT INTO Checkins(number_of_guests,start_date,end_date,checkin_time) VALUES ('"+"233232332323232"+"', '"+startDate+"','"+endDate+"',TIME(NOW()))");
		smt.executeUpdate("INSERT INTO Checkins(number_of_guests,start_date,end_date,checkin_time) VALUES ("+number_of_guests+", '"+startDate+"','"+endDate+"',TIME(NOW()))");
		
		result = smt.executeQuery("SELECT LAST_INSERT_ID()");
		 while(result.next()){
			 cid=result.getInt(1);
		 }
		 System.out.println("Checkin: " + cid);
		return cid;
		}

	private void insertIntoServes(int staffid,int hotelid,String job_title,int checkinid) {
		try{
		smt.executeUpdate("INSERT INTO Serves VALUES ("+staffid+","+hotelid+",'"+job_title+"',"+checkinid+")");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		}
	private void insertIntoDoneBy(int checkinID, int customerID) {
		try{
		smt.executeUpdate("INSERT INTO Done_by VALUES ("+checkinID+",NULL, "+customerID+")");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		}
	private int[] findAvailableStaffs(int hotelID) {
		int count=0;
		int[]s=new int[2];
		try{
		result=smt.executeQuery("SELECT id from Staffs WHERE hotel_id="+hotelID+"");
		while(result.next()&&count<2){
             s[count]=result.getInt("id");
             count++;
		}
		if(count==0)
			{
			s[0]=-1;
			s[1]=-1;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return s;
		}
	private void insertIntoStaffs(int hotelID, String availability, String name, String  address, int age, String  job_title, String phone_number, String department) {
		try{
		smt.executeUpdate("INSERT INTO Staffs(hotel_id, name, address, age, phone_number, job_title, availability, department) values("+hotelID+", '"+name+"','"+ address+"',"+age+", '"+phone_number+"', '"+job_title+"', '"+availability+"', '"+department+"')");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void updateStaff(int hotelID, int staffId, String availability, String name, String  address, int age, String  job_title, String phone_number, String department)
	{
		try {
			smt.executeUpdate("UPDATE Staffs set availability='"+availability+"', name='"+name+"',address='"+address+"', age="+age+", job_title='"+job_title+"', phone_number='"+phone_number+"',department='"+department+"' WHERE hotel_id="+hotelID+" AND id="+staffId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean deleteStaff(int hotelID, int staffId){
	
		int t;
		try {
			t = smt.executeUpdate("DELETE FROM Staffs where hotel_id="+hotelID+" AND id="+ staffId);
			return true&&(t == 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean insertLocation(String zipcode, String address, float rate, String city){
		try {
			smt.execute("INSERT INTO Locations values('"+zipcode+"', '"+address+"', "+rate+", '"+city+"')");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean updateLocations(String zipcode, String address, float rate, String city){
		try {
			smt.executeUpdate("Update Locations set address='"+address+"', rate="+rate+",city='"+city+"' where zip_code='"+zipcode+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean deleteLocation(String zipCode) {
		// TODO Auto-generated method stub
		int t;
		try {
			t = smt.executeUpdate("Delete from Locations where zip_code='"+zipCode+"'");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true&&(t == 1);
	}
	
	protected boolean insertHotel(String name, String phone, String zip_code) {
		// TODO Auto-generated method stub
		try {
			smt.executeUpdate("INSERT INTO Hotels(name, phone_number, zip_code) VALUES ('"+name+"', '"+phone+"', '"+zip_code+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean updateHotel(int hotelId, String name,String phone_number, String zip_code) {
		// TODO Auto-generated method stub
		try {
			System.out.println("REACHED");
			smt.executeUpdate("UPDATE Hotels set name='"+name+"', phone_number='"+phone_number+"',zip_code='"+zip_code+"' where id="+hotelId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean deleteHotel(int hotelId){
		int t;
		try {
		t=	smt.executeUpdate("DELETE FROM Hotels where id="+hotelId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return false;
		}
		return true&&(t==1);
	}
	
	public boolean insertCustomer(String name, String DOB, String email, String phone_number){
		try {
			smt.executeUpdate("Insert into Customers(name, DOB, email, phone_number) values ('"+name+"','"+DOB+"', '"+email+"','"+phone_number+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean updateCustomer(int id, String name, String DOB, String email, String phone_number){
		try {
			smt.executeUpdate("UPDATE Customers set name='"+name+"', DOB='"+DOB+"', email='"+email+"', phone_number='"+phone_number+"' where id="+id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteCustomer(int id){
		int t;
		try {
			t = smt.executeUpdate("DELETE from Customers where id="+id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		return true&&(t==1);
	}
	
	public boolean insertRoom(int hotelId, int roomNumber, int maxOccupancy, String category){
		try {
			//Insert the data into Rooms table
			smt.executeUpdate("insert into Rooms values ("+roomNumber+", 000"+hotelId+", "+maxOccupancy+", '"+category+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean updateRoom(int hotelId, int roomNumber, int maxOccupancy, String category){
		
		try {
			//Delete Room from Database
			smt.executeUpdate("UPDATE Rooms set max_occupancy="+maxOccupancy+", category_name='"+category+"' where hotel_id=000"+hotelId+" AND room_number="+roomNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block3
			e.printStackTrace();
			//Return false if failed
			return false;
		}
		return true;
	}
	
	public boolean deleteRoom(int hotelId, int roomNumber){
		int t;
		try {
			t = smt.executeUpdate("DELETE FROM Rooms where hotel_id=000"+hotelId+" AND room_number="+roomNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true&&(t==1);
	}
}