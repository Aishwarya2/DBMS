import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Statement;

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


public class FrontDeskRep extends JFrame {

	private JPanel contentPane;
	private Statement smt=null;
	private JTextField textField;
	private JTextField textField_1;
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

	public FrontDeskRep(Statement smt) {
		this.smt = smt;
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
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		textField_8 = new JTextField();
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(0, 0, 5, 0);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 2;
		gbc_textField_8.gridy = 6;
		panel.add(textField_8, gbc_textField_8);
		textField_8.setColumns(10);
		
		JButton btnCheckin = new JButton("Checkin");
		GridBagConstraints gbc_btnCheckin = new GridBagConstraints();
		gbc_btnCheckin.gridx = 2;
		gbc_btnCheckin.gridy = 9;
		panel.add(btnCheckin, gbc_btnCheckin);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Checkout", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_textField_9.insets = new Insets(0, 0, 5, 0);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 3;
		gbc_textField_9.gridy = 3;
		panel_1.add(textField_9, gbc_textField_9);
		textField_9.setColumns(10);
		
		JLabel lblPayment = new JLabel("Payment");
		GridBagConstraints gbc_lblPayment = new GridBagConstraints();
		gbc_lblPayment.insets = new Insets(0, 0, 5, 5);
		gbc_lblPayment.gridx = 1;
		gbc_lblPayment.gridy = 5;
		panel_1.add(lblPayment, gbc_lblPayment);
		
		JLabel lblPaymentMethod = new JLabel("Payment Method");
		GridBagConstraints gbc_lblPaymentMethod = new GridBagConstraints();
		gbc_lblPaymentMethod.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaymentMethod.gridx = 1;
		gbc_lblPaymentMethod.gridy = 7;
		panel_1.add(lblPaymentMethod, gbc_lblPaymentMethod);
		
		textField_10 = new JTextField();
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.insets = new Insets(0, 0, 5, 0);
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
		gbc_textField_11.insets = new Insets(0, 0, 5, 0);
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
		gbc_textField_12.insets = new Insets(0, 0, 5, 0);
		gbc_textField_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_12.gridx = 3;
		gbc_textField_12.gridy = 9;
		panel_1.add(textField_12, gbc_textField_12);
		textField_12.setColumns(10);
		
		JButton btnCheckout = new JButton("Pay & Checkout");
		GridBagConstraints gbc_btnCheckout = new GridBagConstraints();
		gbc_btnCheckout.gridx = 3;
		gbc_btnCheckout.gridy = 11;
		panel_1.add(btnCheckout, gbc_btnCheckout);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Generate Bill", null, panel_2, null);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 3;
		panel_2.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JTextArea textArea_1 = new JTextArea();
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
		
		JLabel lblHotelId = new JLabel("Hotel ID:");
		GridBagConstraints gbc_lblHotelId = new GridBagConstraints();
		gbc_lblHotelId.anchor = GridBagConstraints.EAST;
		gbc_lblHotelId.insets = new Insets(0, 0, 5, 5);
		gbc_lblHotelId.gridx = 1;
		gbc_lblHotelId.gridy = 3;
		panel_3.add(lblHotelId, gbc_lblHotelId);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 3;
		panel_3.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblRoomNumberoption = new JLabel("Room number (option):");
		GridBagConstraints gbc_lblRoomNumberoption = new GridBagConstraints();
		gbc_lblRoomNumberoption.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomNumberoption.gridx = 1;
		gbc_lblRoomNumberoption.gridy = 4;
		panel_3.add(lblRoomNumberoption, gbc_lblRoomNumberoption);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 4;
		panel_3.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
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
		
		JButton btnCheckAvailability = new JButton("Check Availability");
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
		
		JTextArea textArea = new JTextArea();
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
		
	}
}
