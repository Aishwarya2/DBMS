import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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


public class FrontDeskRep extends JFrame {

	private Statement smt=null;
	private ResultSet result = null;
	private Connection connection = null;
	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField txtEnterTableName;
	private JTextField textField_14;
	private JTextField textField_13;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	
	
	private JButton btnCheckin;
	private JButton btnGenerateBill;
	private JButton btnCheckAvailability;
	private JButton btnCheckout_1; 
	private JButton btnInsert_1;
	
	private JTextArea checkinTA;
	private JTextArea textArea_1;
	private JTextArea textArea;
	private JTextArea textArea_2; 
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_21;
	private JTextField textField_22;
	
	
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
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 3;
		panel.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JLabel lblStartDate_1 = new JLabel("Start Date");
		GridBagConstraints gbc_lblStartDate_1 = new GridBagConstraints();
		gbc_lblStartDate_1.anchor = GridBagConstraints.EAST;
		gbc_lblStartDate_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartDate_1.gridx = 1;
		gbc_lblStartDate_1.gridy = 4;
		panel.add(lblStartDate_1, gbc_lblStartDate_1);
		
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
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
		
		btnCheckout_1 = new JButton("Checkout");
		
		GridBagConstraints gbc_btnCheckout_1 = new GridBagConstraints();
		gbc_btnCheckout_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnCheckout_1.gridx = 4;
		gbc_btnCheckout_1.gridy = 8;
		panel_1.add(btnCheckout_1, gbc_btnCheckout_1);
		
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
		
		textArea_2 = new JTextArea();
		GridBagConstraints gbc_textArea_2 = new GridBagConstraints();
		gbc_textArea_2.gridwidth = 3;
		gbc_textArea_2.insets = new Insets(0, 0, 0, 5);
		gbc_textArea_2.fill = GridBagConstraints.BOTH;
		gbc_textArea_2.gridx = 1;
		gbc_textArea_2.gridy = 12;
		panel_1.add(textArea_2, gbc_textArea_2);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Add Customer", null, panel_5, null);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 2;
		gbc_lblName.gridy = 1;
		panel_5.add(lblName, gbc_lblName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		panel_5.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblDob = new JLabel("DOB:");
		GridBagConstraints gbc_lblDob = new GridBagConstraints();
		gbc_lblDob.anchor = GridBagConstraints.EAST;
		gbc_lblDob.insets = new Insets(0, 0, 5, 5);
		gbc_lblDob.gridx = 2;
		gbc_lblDob.gridy = 2;
		panel_5.add(lblDob, gbc_lblDob);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 2;
		panel_5.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 3;
		panel_5.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_21 = new JTextField();
		GridBagConstraints gbc_textField_21 = new GridBagConstraints();
		gbc_textField_21.insets = new Insets(0, 0, 5, 5);
		gbc_textField_21.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_21.gridx = 3;
		gbc_textField_21.gridy = 3;
		panel_5.add(textField_21, gbc_textField_21);
		textField_21.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
		gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNumber.gridx = 2;
		gbc_lblPhoneNumber.gridy = 4;
		panel_5.add(lblPhoneNumber, gbc_lblPhoneNumber);
		
		textField_22 = new JTextField();
		GridBagConstraints gbc_textField_22 = new GridBagConstraints();
		gbc_textField_22.insets = new Insets(0, 0, 5, 5);
		gbc_textField_22.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_22.gridx = 3;
		gbc_textField_22.gridy = 4;
		panel_5.add(textField_22, gbc_textField_22);
		textField_22.setColumns(10);
		
		btnInsert_1 = new JButton("Insert");
	
		GridBagConstraints gbc_btnInsert_1 = new GridBagConstraints();
		gbc_btnInsert_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsert_1.gridx = 3;
		gbc_btnInsert_1.gridy = 5;
		panel_5.add(btnInsert_1, gbc_btnInsert_1);
		
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
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblCheckRoomAvailability = new JLabel("Check room availability");
		GridBagConstraints gbc_lblCheckRoomAvailability = new GridBagConstraints();
		gbc_lblCheckRoomAvailability.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckRoomAvailability.gridx = 1;
		gbc_lblCheckRoomAvailability.gridy = 1;
		panel_3.add(lblCheckRoomAvailability, gbc_lblCheckRoomAvailability);
		
		JLabel lblStartDate = new JLabel("Start Date:");
		GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
		gbc_lblStartDate.anchor = GridBagConstraints.EAST;
		gbc_lblStartDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartDate.gridx = 1;
		gbc_lblStartDate.gridy = 5;
		panel_3.add(lblStartDate, gbc_lblStartDate);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 5;
		panel_3.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		btnCheckAvailability = new JButton("Check Availability");
		
		GridBagConstraints gbc_btnCheckAvailability = new GridBagConstraints();
		gbc_btnCheckAvailability.insets = new Insets(0, 0, 5, 5);
		gbc_btnCheckAvailability.gridx = 5;
		gbc_btnCheckAvailability.gridy = 5;
		panel_3.add(btnCheckAvailability, gbc_btnCheckAvailability);
		
		JLabel lblEndDate = new JLabel("End Date:");
		GridBagConstraints gbc_lblEndDate = new GridBagConstraints();
		gbc_lblEndDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndDate.anchor = GridBagConstraints.EAST;
		gbc_lblEndDate.gridx = 1;
		gbc_lblEndDate.gridy = 6;
		panel_3.add(lblEndDate, gbc_lblEndDate);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 6;
		panel_3.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 2;
		gbc_textArea.gridwidth = 5;
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 8;
		panel_3.add(textArea, gbc_textArea);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Enter/Update/Delete", null, panel_4, null);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblInsertIntoTable = new JLabel("Modify table:");
		GridBagConstraints gbc_lblInsertIntoTable = new GridBagConstraints();
		gbc_lblInsertIntoTable.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsertIntoTable.gridx = 1;
		gbc_lblInsertIntoTable.gridy = 1;
		panel_4.add(lblInsertIntoTable, gbc_lblInsertIntoTable);
		
		txtEnterTableName = new JTextField();
		txtEnterTableName.setText("Enter table name");
		txtEnterTableName.setToolTipText("Enter Table name");
		GridBagConstraints gbc_txtEnterTableName = new GridBagConstraints();
		gbc_txtEnterTableName.insets = new Insets(0, 0, 5, 0);
		gbc_txtEnterTableName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterTableName.gridx = 3;
		gbc_txtEnterTableName.gridy = 1;
		panel_4.add(txtEnterTableName, gbc_txtEnterTableName);
		txtEnterTableName.setColumns(10);
		
		JLabel lblValues = new JLabel("Insert Values");
		GridBagConstraints gbc_lblValues = new GridBagConstraints();
		gbc_lblValues.insets = new Insets(0, 0, 5, 5);
		gbc_lblValues.gridx = 1;
		gbc_lblValues.gridy = 2;
		panel_4.add(lblValues, gbc_lblValues);
		
		textField_14 = new JTextField();
		GridBagConstraints gbc_textField_14 = new GridBagConstraints();
		gbc_textField_14.insets = new Insets(0, 0, 5, 0);
		gbc_textField_14.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_14.gridx = 3;
		gbc_textField_14.gridy = 2;
		panel_4.add(textField_14, gbc_textField_14);
		textField_14.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		GridBagConstraints gbc_btnInsert = new GridBagConstraints();
		gbc_btnInsert.insets = new Insets(0, 0, 5, 0);
		gbc_btnInsert.gridx = 3;
		gbc_btnInsert.gridy = 3;
		panel_4.add(btnInsert, gbc_btnInsert);
		
		JLabel lblUpdateValues = new JLabel("Update Values");
		GridBagConstraints gbc_lblUpdateValues = new GridBagConstraints();
		gbc_lblUpdateValues.insets = new Insets(0, 0, 5, 5);
		gbc_lblUpdateValues.gridx = 1;
		gbc_lblUpdateValues.gridy = 5;
		panel_4.add(lblUpdateValues, gbc_lblUpdateValues);
		
		textField_13 = new JTextField();
		GridBagConstraints gbc_textField_13 = new GridBagConstraints();
		gbc_textField_13.insets = new Insets(0, 0, 5, 0);
		gbc_textField_13.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_13.gridx = 3;
		gbc_textField_13.gridy = 5;
		panel_4.add(textField_13, gbc_textField_13);
		textField_13.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 0);
		gbc_btnUpdate.gridx = 3;
		gbc_btnUpdate.gridy = 6;
		panel_4.add(btnUpdate, gbc_btnUpdate);
		
		JLabel lblDeleteRecord = new JLabel("Delete record");
		GridBagConstraints gbc_lblDeleteRecord = new GridBagConstraints();
		gbc_lblDeleteRecord.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeleteRecord.gridx = 1;
		gbc_lblDeleteRecord.gridy = 8;
		panel_4.add(lblDeleteRecord, gbc_lblDeleteRecord);
		
		textField_15 = new JTextField();
		GridBagConstraints gbc_textField_15 = new GridBagConstraints();
		gbc_textField_15.insets = new Insets(0, 0, 5, 0);
		gbc_textField_15.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_15.gridx = 3;
		gbc_textField_15.gridy = 8;
		panel_4.add(textField_15, gbc_textField_15);
		textField_15.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridx = 3;
		gbc_btnDelete.gridy = 9;
		panel_4.add(btnDelete, gbc_btnDelete);
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
					result=smt.executeQuery("SELECT SUM(rates) as Total from(select sum(se.rate*pr.count) as rates from Services se,Pricings pr where se.service_name=pr.service_name and pr.service_name in(select p.service_name from Pricings p where p.checkin_id in(select checkin_id from Done_by where customer_id="+customerID+" group by checkin_id)group by p.service_name) UNION ALL select sum(c.nightly_rate) from Category c,Rooms r where r.category_name=c.category_name and r.room_number in(select p.room_number from Pricings p where p.hotel_id =(select hotel_id from Pricings where checkin_id in(select checkin_id from Done_by where customer_id="+customerID+")group by checkin_id))UNION ALL SELECT l.rate as rates from Locations l,Hotels h where l.zip_code=h.zip_code and h.id =(select hotel_id from Pricings where checkin_id in(select checkin_id from Done_by where customer_id="+customerID+")group by checkin_id))Item");
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

		btnCheckout_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hotelID = Integer.parseInt(textField_16.getText()) ;
				int checkinid = Integer.parseInt(textField_9.getText()) ;
				String payment_method = textField_10.getText();
				String card_number = textField_11.getText();
				String SSN = textField_12.getText();
				String billing_address = textField_17.getText();
				releaserooms(hotelID, checkinid,payment_method,card_number,SSN,billing_address);
			}
		});
		
		btnCheckAvailability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
//				int hotelID = Integer.parseInt(textField.getText());
//				int room_number = Integer.parseInt(textField_1.getText());
				String start_date= textField_2.getText();
				String end_date = textField_3.getText();
				String resultStr="";
				try {
					result=smt.executeQuery(String.format("SELECT * FROM Rooms WHERE (room_number, hotel_id) NOT IN (SELECT room_number, hotel_id from Reservations WHERE '%s' <= CURDATE() or '%s' >= CURDATE() )",start_date,end_date));
			        while(result.next()){
			  
			        	int rno=result.getInt("room_number");
			        	int hotelid=result.getInt("hotel_id");
						resultStr+="\n"+"Room number "+rno+" is available in hotel "+hotelid;
			        	System.out.println("Room number "+rno+" is available in hotel "+hotelid);
			        }
			        textArea.setText(resultStr);
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		btnInsert_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String name = textField.getText();
			String dob = textField_1.getText();
			String emailID = textField_21.getText();
			String phone_number = textField_22.getText();
			int cid=0;
			try{
			smt.executeUpdate("INSERT INTO Customers(name, DOB, email, phone_number) VALUES ('"+name+"','"+dob+"','"+emailID+"', '"+phone_number+"')");
			
			result = smt.executeQuery("SELECT LAST_INSERT_ID()");
			 while(result.next()){
				 cid=result.getInt(1);
			 }
			 System.out.println("Customer Id: "+cid);
			}
			catch(SQLException ed){
				ed.printStackTrace();
			}
			}
		});
	}
	
	private void assignRoomsByRequest(int hotelID,int customerID, String categoryName,String startDate,String endDate,String city, int number_of_guests) throws SQLException {
		int[] roomhotel = reportOccupancyBasedOnRequest(hotelID, categoryName, startDate, endDate,city);
		if(roomhotel[0]==-1){
			System.out.println("Room not available while checkin");
			return;
		}
		//If needed
		// insertIntoCustomers("Tony Stark", "750123456","1975-02-21", "stark@gmail.com");	
		try{
		result=smt.executeQuery("select id from Customers where id="+customerID+"");
		
		if(!result.next()){ 
			System.out.println("Customer Not found.");
		 } else {
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
		result=smt.executeQuery("SELECT * from Rooms where room_number="+room_number+" and hotel_id="+hotelID+"");
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

	private void releaserooms(int hotelID, int checkinid,String payment_method,String card_number,String SSN,String billing_address){
		int tid=0;
		int customerID=1;
		//retrieve customer id
		try{
		result=smt.executeQuery(String.format("select customer_id from Done_by where checkin_id='%s'",checkinid));
		if(result.next())
			customerID=result.getInt("customer_id");
		//get the final amount
		int bill= generateBill(customerID);
		//update this amount in checkins
		smt.executeUpdate(String.format("update Checkins set amount='%d' where id='%d'",bill,checkinid)); 
	    //Delete from reservations
		smt.executeUpdate(String.format("Delete from Reservations where hotel_id,room_number in (select hotel_id,room_number from Pricings where checkin_id='%d')",checkinid));
		//check if card_number already exists in card table
//		result=smt.executeQuery(String.format("select card_number from Cards where card_number='%d'",card_number));
//		if(!result.next())
//		smt.executeUpdate(String.format("Insert into Cards values('%s','%s','%f')",card_number,payment_method,0.05));
//		//Assume that he/she has made the payment 
//		//insert into billings and get transaction id
//		smt.executeUpdate(String.format("Insert into Billings('billing_address','SSN') values('%s','%s')",billing_address,SSN));
//	    result = smt.executeQuery("SELECT LAST_INSERT_ID()");
//		 while(result.next()){
//			 tid=result.getInt(1);
//		 }
//		 //insert cardnumber,tid in paid through
//		 smt.executeUpdate(String.format("Insert into Paid_through('transaction_id','card_number')values('%d','%s')",tid,card_number)); 
//		//Update tid in Done_by
//		smt.executeUpdate(String.format("Update Done_by set transaction_id='%d' where checkin_id='%d'",tid,checkinid)); 
//	    //Set availability of staffs to Yes in staffs table
//		smt.executeUpdate(String.format("Update Staffs set availability='Yes' where id in (select id from Serves where checkin_id='%d')",checkinid));
//		textArea_2.setText("Successfully checkedout!");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	private int generateBill(int customer_id){
		int amount=0;
		try{
			result=smt.executeQuery("SELECT SUM(rates) as Total from(select sum(se.rate*pr.count) as rates from Services se,Pricings pr where se.service_name=pr.service_name and pr.service_name in(select p.service_name from Pricings p where p.checkin_id in(select checkin_id from Done_by where customer_id="+customer_id+" group by checkin_id)group by p.service_name) UNION ALL select sum(ps.nightly_rate) as rates from Pricings ps where ps.checkin_id in(select d.checkin_id from Done_by d where customer_id="+customer_id+")group by ps.checkin_id UNION ALL select sum(c.rate) from Category c,Rooms r where r.category_name=c.category_name and r.room_number in(select p.room_number from Pricings p where p.hotel_id =(select hotel_id from Pricings where checkin_id in(select checkin_id from Done_by where customer_id="+customer_id+")group by checkin_id))UNION ALL SELECT l.rate as rates from Locations l,Hotels h where l.zip_code=h.zip_code and h.id =(select hotel_id from Pricings where checkin_id in(select checkin_id from Done_by where customer_id="+customer_id+")group by checkin_id))Item");
		while(result.next()){
			System.out.println("The total bill is "+result.getInt("Total"));
			amount=result.getInt("Total");
		}
		
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return amount;
	}
}
