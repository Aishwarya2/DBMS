import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Manager extends JFrame {
	private Statement smt = null;
	private ResultSet result = null;
	
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	private JTextArea reportOccupancyTA;
	private JTextArea staffTA;
	private JTextArea revenueTA;
	
	private JButton btnOccupancyByHotel;
	private JButton btnOccupancyByDate;
	private JButton btnOccupancyByRoom;
	private JButton btnTotalOccupancy;
	private JButton btnOccupancyByCity;
	private JButton btnTotalPercentageOccupancy;
	private JButton btnAssignStaffs;
	private JButton btnGroupStaffsBy;
	private JButton btnStaffInfoFor;
	private JButton btnGenerateRevenue;
	
	private JTabbedPane tabbedPane ;
	private JLabel lblHotelid;
	private JLabel lblRoomNumber;
	private JLabel lblCheckinId;
	private JLabel lblServiceName;
	private JTextField textField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager frame = new Manager();
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
	public Manager (){
		initComponents();
		initEvents();
	}
	
	public Manager(Statement smt) {
		this.smt = smt;
		initComponents();
		initEvents();
	}
	
	private void initComponents(){
		setTitle("Manager ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 481);
		getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 669, 412);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("Report Occupancy");
		tabbedPane.addTab("Report Occupancy", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		btnOccupancyByHotel = new JButton("Occupancy by Hotel");
		
		GridBagConstraints gbc_btnOccupancyByHotel = new GridBagConstraints();
		gbc_btnOccupancyByHotel.insets = new Insets(0, 0, 5, 5);
		gbc_btnOccupancyByHotel.gridx = 1;
		gbc_btnOccupancyByHotel.gridy = 1;
		panel.add(btnOccupancyByHotel, gbc_btnOccupancyByHotel);
		
		btnOccupancyByDate = new JButton("Occupancy by Date Range");
		
		GridBagConstraints gbc_btnOccupancyByDate = new GridBagConstraints();
		gbc_btnOccupancyByDate.insets = new Insets(0, 0, 5, 5);
		gbc_btnOccupancyByDate.gridx = 3;
		gbc_btnOccupancyByDate.gridy = 1;
		panel.add(btnOccupancyByDate, gbc_btnOccupancyByDate);
		
		btnOccupancyByRoom = new JButton("Occupancy by Room type");
		GridBagConstraints gbc_btnOccupancyByRoom = new GridBagConstraints();
		gbc_btnOccupancyByRoom.insets = new Insets(0, 0, 5, 5);
		gbc_btnOccupancyByRoom.gridx = 4;
		gbc_btnOccupancyByRoom.gridy = 1;
		panel.add(btnOccupancyByRoom, gbc_btnOccupancyByRoom);
		
		btnTotalOccupancy = new JButton("Total Occupancy");
		
		GridBagConstraints gbc_btnTotalOccupancy = new GridBagConstraints();
		gbc_btnTotalOccupancy.insets = new Insets(0, 0, 5, 5);
		gbc_btnTotalOccupancy.gridx = 1;
		gbc_btnTotalOccupancy.gridy = 3;
		panel.add(btnTotalOccupancy, gbc_btnTotalOccupancy);
		
		btnOccupancyByCity = new JButton("Occupancy by City");
		
		GridBagConstraints gbc_btnOccupancyByCity = new GridBagConstraints();
		gbc_btnOccupancyByCity.insets = new Insets(0, 0, 5, 5);
		gbc_btnOccupancyByCity.gridx = 3;
		gbc_btnOccupancyByCity.gridy = 3;
		panel.add(btnOccupancyByCity, gbc_btnOccupancyByCity);
		
		btnTotalPercentageOccupancy = new JButton("Total Percentage Occupancy");
		GridBagConstraints gbc_btnTotalPercentageOccupancy = new GridBagConstraints();
		gbc_btnTotalPercentageOccupancy.insets = new Insets(0, 0, 5, 5);
		gbc_btnTotalPercentageOccupancy.gridx = 4;
		gbc_btnTotalPercentageOccupancy.gridy = 3;
		panel.add(btnTotalPercentageOccupancy, gbc_btnTotalPercentageOccupancy);
		
		reportOccupancyTA = new JTextArea();
		GridBagConstraints gbc_textArea_2 = new GridBagConstraints();
		gbc_textArea_2.gridwidth = 4;
		gbc_textArea_2.insets = new Insets(0, 0, 0, 5);
		gbc_textArea_2.fill = GridBagConstraints.BOTH;
		gbc_textArea_2.gridx = 1;
		gbc_textArea_2.gridy = 6;
		panel.add(reportOccupancyTA, gbc_textArea_2);
		reportOccupancyTA.setVisible(false);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Operation on Staffs", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnAssignStaffs = new JButton("Assign Staffs");
		
		GridBagConstraints gbc_btnAssignStaffs = new GridBagConstraints();
		gbc_btnAssignStaffs.insets = new Insets(0, 0, 5, 5);
		gbc_btnAssignStaffs.gridx = 1;
		gbc_btnAssignStaffs.gridy = 1;
		panel_1.add(btnAssignStaffs, gbc_btnAssignStaffs);
		
		btnGroupStaffsBy = new JButton("Group Staffs by Role");
		GridBagConstraints gbc_btnGroupStaffsBy = new GridBagConstraints();
		gbc_btnGroupStaffsBy.insets = new Insets(0, 0, 5, 5);
		gbc_btnGroupStaffsBy.gridx = 2;
		gbc_btnGroupStaffsBy.gridy = 1;
		panel_1.add(btnGroupStaffsBy, gbc_btnGroupStaffsBy);
		
		btnStaffInfoFor = new JButton("Staff info for every Customer stay");
		GridBagConstraints gbc_btnStaffInfoFor = new GridBagConstraints();
		gbc_btnStaffInfoFor.insets = new Insets(0, 0, 5, 5);
		gbc_btnStaffInfoFor.gridx = 3;
		gbc_btnStaffInfoFor.gridy = 1;
		panel_1.add(btnStaffInfoFor, gbc_btnStaffInfoFor);
		
		lblHotelid = new JLabel("HotelID:");
		GridBagConstraints gbc_lblHotelid = new GridBagConstraints();
		gbc_lblHotelid.anchor = GridBagConstraints.EAST;
		gbc_lblHotelid.insets = new Insets(0, 0, 5, 5);
		gbc_lblHotelid.gridx = 1;
		gbc_lblHotelid.gridy = 2;
		panel_1.add(lblHotelid, gbc_lblHotelid);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblRoomNumber = new JLabel("Room number");
		GridBagConstraints gbc_lblRoomNumber = new GridBagConstraints();
		gbc_lblRoomNumber.anchor = GridBagConstraints.EAST;
		gbc_lblRoomNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomNumber.gridx = 1;
		gbc_lblRoomNumber.gridy = 3;
		panel_1.add(lblRoomNumber, gbc_lblRoomNumber);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 3;
		panel_1.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		lblCheckinId = new JLabel("Checkin ID");
		GridBagConstraints gbc_lblCheckinId = new GridBagConstraints();
		gbc_lblCheckinId.anchor = GridBagConstraints.EAST;
		gbc_lblCheckinId.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckinId.gridx = 1;
		gbc_lblCheckinId.gridy = 4;
		panel_1.add(lblCheckinId, gbc_lblCheckinId);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 4;
		panel_1.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		lblServiceName = new JLabel("Service name");
		GridBagConstraints gbc_lblServiceName = new GridBagConstraints();
		gbc_lblServiceName.anchor = GridBagConstraints.EAST;
		gbc_lblServiceName.insets = new Insets(0, 0, 5, 5);
		gbc_lblServiceName.gridx = 1;
		gbc_lblServiceName.gridy = 5;
		panel_1.add(lblServiceName, gbc_lblServiceName);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 2;
		gbc_textField_6.gridy = 5;
		panel_1.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		staffTA = new JTextArea();
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		gbc_textArea_1.gridwidth = 5;
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.gridx = 1;
		gbc_textArea_1.gridy = 6;
		panel_1.add(staffTA, gbc_textArea_1);
		staffTA.setVisible(false);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Generate Revenue", null, panel_2, null);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblGenerateRevenueEarned = new JLabel("Generate Revenue Earned by Hotel in Date range");
		GridBagConstraints gbc_lblGenerateRevenueEarned = new GridBagConstraints();
		gbc_lblGenerateRevenueEarned.anchor = GridBagConstraints.WEST;
		gbc_lblGenerateRevenueEarned.insets = new Insets(0, 0, 5, 0);
		gbc_lblGenerateRevenueEarned.gridx = 1;
		gbc_lblGenerateRevenueEarned.gridy = 1;
		panel_2.add(lblGenerateRevenueEarned, gbc_lblGenerateRevenueEarned);
		
		JLabel lblHotelId = new JLabel("Hotel ID");
		GridBagConstraints gbc_lblHotelId = new GridBagConstraints();
		gbc_lblHotelId.anchor = GridBagConstraints.EAST;
		gbc_lblHotelId.insets = new Insets(0, 0, 5, 5);
		gbc_lblHotelId.gridx = 0;
		gbc_lblHotelId.gridy = 4;
		panel_2.add(lblHotelId, gbc_lblHotelId);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		panel_2.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblStartDate_1 = new JLabel("Start Date");
		GridBagConstraints gbc_lblStartDate_1 = new GridBagConstraints();
		gbc_lblStartDate_1.anchor = GridBagConstraints.EAST;
		gbc_lblStartDate_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartDate_1.gridx = 0;
		gbc_lblStartDate_1.gridy = 5;
		panel_2.add(lblStartDate_1, gbc_lblStartDate_1);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 5;
		panel_2.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblStartDate = new JLabel("End Date");
		GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
		gbc_lblStartDate.anchor = GridBagConstraints.EAST;
		gbc_lblStartDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartDate.gridx = 0;
		gbc_lblStartDate.gridy = 6;
		panel_2.add(lblStartDate, gbc_lblStartDate);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 6;
		panel_2.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		btnGenerateRevenue = new JButton("Generate revenue ");
		
		GridBagConstraints gbc_btnGenerateRevenue = new GridBagConstraints();
		gbc_btnGenerateRevenue.insets = new Insets(0, 0, 5, 0);
		gbc_btnGenerateRevenue.gridx = 1;
		gbc_btnGenerateRevenue.gridy = 7;
		panel_2.add(btnGenerateRevenue, gbc_btnGenerateRevenue);
		
		revenueTA = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 9;
		panel_2.add(revenueTA, gbc_textArea);
		revenueTA.setVisible(false);
		
	}

	private void initEvents(){
		btnOccupancyByHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					result=smt.executeQuery("SELECT count(*) as count,hotel_id from Reservations  group by hotel_id");
					String resultStr="";
					while(result.next()){	
						resultStr += "\n"+result.getInt("count")+"occupied in"+result.getInt("hotel_id");
						System.out.println(result.getInt("count")+"occupied in"+result.getInt("hotel_id"));
					}
					reportOccupancyTA.setText(resultStr);
					reportOccupancyTA.setVisible(true);
				} catch (SQLException e) {
						e.printStackTrace();
				}
			}
		});
		
		btnOccupancyByDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					result=smt.executeQuery("Select count(*) as count,start_date,end_date from Reservations group by start_date, end_date");
				    String resultStr = "";
					while(result.next()){
						resultStr+="\n"+result.getInt("count")+" occupied in date range "+result.getString("start_date")+","+result.getString("end_date");
						System.out.println(result.getInt("count")+" occupied in date range "+result.getString("start_date")+","+result.getString("end_date"));
				    }
					
					reportOccupancyTA.setText(resultStr);
					reportOccupancyTA.setVisible(true);
			    	
				} catch (SQLException ex) {
						ex.printStackTrace();
				}
			}
		});
		

		btnOccupancyByRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					result=smt.executeQuery("SELECT count(*) as count,c.category_name from Reservations r, Rooms R, Category c where r.room_number=R.room_number"
												 +" and R.category_name = c.category_name group by c.category_name");
				    String resultStr = "";
					while(result.next()){
						resultStr+= "\n"+result.getInt("count")+"occupied of type"+result.getString("c.category_name");
				    	System.out.println(result.getInt("count")+"occupied of type"+result.getString("c.category_name"));
				    }
				    
				    reportOccupancyTA.setText(resultStr);
				    reportOccupancyTA.setVisible(true);
			    	
				} catch (SQLException ex) {
						ex.printStackTrace();
				}
			}
		});
		
		btnTotalOccupancy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					result=smt.executeQuery("SELECT count(*) as count from Reservations");
					String resultStr = "";
					while(result.next()){
						resultStr+="\n"+result.getInt("count")+"occupied in the entire hotel chain ";
				    	System.out.println(result.getInt("count")+"occupied in the entire hotel chain ");
					}
				    reportOccupancyTA.setText(resultStr);
					reportOccupancyTA.setVisible(true);
				} catch (SQLException ex) {
						ex.printStackTrace();
				}
			}
		});
		
		btnOccupancyByCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					result=smt.executeQuery("SELECT count(*) as count,l.city from Reservations r, Hotels h, Locations l where r.hotel_id=h.id"
												 +" and h.zip_code=l.zip_code group by l.city");
					String resultStr = "";
					while(result.next()){
						resultStr+="\n"+result.getInt("count")+"occupied in city"+result.getString("l.city");	    	
				    	System.out.println(result.getInt("count")+"occupied in city"+result.getString("l.city"));
				    }
					reportOccupancyTA.setText(resultStr);
					reportOccupancyTA.setVisible(true);
				} catch (SQLException ex) {
						ex.printStackTrace();
				}
			}
		});
		
		btnTotalPercentageOccupancy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					result=smt.executeQuery("SELECT (count(*)/a.total)*100 as percentage_occupancy from (select count(*) as"
												 +" total from Reservations) a, Rooms group by hotel_id");
					String resultStr = "";
					while(result.next()){
						resultStr+="\n"+result.getInt("percentage_occupancy")+" percentage occupied in the entire hotel chain.";
				    	System.out.println(result.getInt("percentage_occupancy")+" percentage occupied in the entire hotel chain.");

					}
				    reportOccupancyTA.setText(resultStr);
					reportOccupancyTA.setVisible(true);
				} catch (SQLException ex) {
						ex.printStackTrace();
				}
			}
		});
		
		btnGroupStaffsBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					result=smt.executeQuery("SELECT job_title,count(*) as count from Staffs group by job_title");
					String resultStr = "";
					while(result.next()){
						resultStr+="\n"+"Number of staffs in"+result.getString("job_title")+"is"+result.getInt("count");
				    	System.out.println("Number of staffs in"+result.getString("job_title")+"is"+result.getInt("count"));
				    }
					staffTA.setText(resultStr);
					staffTA.setVisible(true);
				} catch (SQLException ex) {
						ex.printStackTrace();
				}	

			}
		});
		
		btnStaffInfoFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					result=smt.executeQuery("SELECT * from Staffs where id in (select Serves.staff_id from Serves where (Serves.service_name,Serves.hotel_id) in (select service_name,hotel_id from Pricings group by checkin_id))");
					String resultStr = "";
					while(result.next()){
					resultStr+="\n"+"The staff id is "+result.getInt("id")+" from hotel "+result.getInt("hotel_id")+"job_title is"+result.getString("job_title");
					System.out.println("The staff id is "+result.getInt("id")+" from hotel "+result.getInt("hotel_id")+"job_title is"+result.getString("job_title"));
				}
				staffTA.setText(resultStr);
				staffTA.setVisible(true);
				}
				catch(SQLException ex){
					ex.printStackTrace();
				}
			}
		});
		
		btnGenerateRevenue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hotel_id = textField_1.getText();
				String start_date = textField_3.getText();
				String end_date = textField_2.getText();
				try{
					result=smt.executeQuery("SELECT sum(Checkins.amount) as revenue,hotel_id from Checkins, Pricings where Pricings.checkin_id=Checkins.id and Pricings.hotel_id="+hotel_id+" and Checkins.id in (select id from Checkins where start_date>='"+start_date+"' and end_date<='"+end_date+"')");
					String resultStr = "";
					while(result.next()){
					resultStr+="\n"+result.getInt("revenue")+" is the revenue earned by "+result.getInt("hotel_id")+" in the given date range";
					System.out.println(result.getInt("revenue")+" is the revenue earned by "+result.getInt("hotel_id")+" in the given date range");
				}
				revenueTA.setText(resultStr);
				revenueTA.setVisible(true);
				}
				catch(SQLException ex){
					ex.printStackTrace();
				}
			}
		});
		
		btnAssignStaffs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hotel_id = Integer.parseInt(textField.getText());
				int room_number = Integer.parseInt(textField_4.getText());
				int checkinid = Integer.parseInt(textField_5.getText());
				String service_name = textField_6.getText();
				assignstaff(hotel_id, room_number, checkinid, service_name);
				System.out.println(hotel_id);
				System.out.println(room_number);
				System.out.println(checkinid);
				System.out.println(service_name);
			}
		});
	}
	
	private void assignstaff(int hotel_id,int room_number,int checkinid,String service_name)
	{
		 try{
			//check if the service has already been availed by the room
			result = smt.executeQuery(String.format("select service_name from Pricings where checkin_id='%d' and room_number='%d' and hotel_id='%d' and service_name='%s'",checkinid,room_number,hotel_id, service_name));
			//If not
			if(!result.next()) {
				// find available staff and insert into serves and Pricings table
				result = smt.executeQuery("Select id from Staffs where availability='Yes' limit 1");
				int staff_id=0;
				System.out.println("Available Staff id: "+ staff_id);
				if (result.next()){
					staff_id = result.getInt("id");
					System.out.println("Available Staff id: "+ staff_id);
					smt.executeUpdate(String.format("Insert into Serves values('%d','%d','%s','%d')",  staff_id, hotel_id, service_name, checkinid));
					smt.executeUpdate(String.format("Insert into Pricings values('%d','%d','%d','%d','%s')",  1,checkinid,room_number,hotel_id,service_name));
				}
			} else {
				//Update count in pricings
				smt.executeUpdate(String.format("Update Pricings set count=count+1 where checkin_id='%d' and room_number='%d' and service_name='%s'",checkinid,room_number,service_name));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
