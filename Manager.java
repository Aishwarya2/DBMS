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
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		staffTA = new JTextArea();
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		gbc_textArea_1.insets = new Insets(0, 0, 5, 0);
		gbc_textArea_1.gridheight = 3;
		gbc_textArea_1.gridwidth = 5;
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.gridx = 1;
		gbc_textArea_1.gridy = 4;
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
						resultStr+="\n"+result.getInt("count")+"occupied in date range"+result.getString("start_date")+","+result.getString("end_date");
						System.out.println(result.getInt("count")+"occupied in date range"+result.getString("start_date")+","+result.getString("end_date"));
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
		try {
			result=smt.executeQuery("SELECT job_title,count(*) as count from Staffs group by job_title");
		    while(result.next()){
		    	System.out.println("Number of staffs in"+result.getString("job_title")+"is"+result.getInt("count"));
		    }
		} catch (SQLException ex) {
				ex.printStackTrace();
		}
	}
}
