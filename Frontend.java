import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Frontend{
	private static final String jdbcURL = "jdbc:mysql://mydbinstance.ca6owdm4itco.us-east-1.rds.amazonaws.com:3306/";
	// Put your oracle ID and password here
    private static final String username="aishwaryassr";
	private static final String password="Macrohard.123";
	private static final String dbName="dbname";	
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet result = null;
	
public static void main(String[] args) {

		
		//String driver="com.mysql.jdbc.Driver";
		try{
		Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
		connection=DriverManager.getConnection(jdbcURL+dbName,username,password);
		
			//connection = DriverManager.getConnection(jdbcURL+dbName,username,password);
 			statement = connection.createStatement();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		Frontend1 f=new Frontend1();
		f.display();
}
//Staff info grouped by their role
public static void getStaffGroupedByRoles() {

		try {
			result=statement.executeQuery("SELECT job_title,count(*) as count from Staffs group by job_title");
		    while(result.next()){
		    	System.out.println("Number of staffs in"+result.getString("job_title")+"is"+result.getInt("count"));
		    }
		} catch (SQLException e) {
				e.printStackTrace();
		}	
	}

//check if room and room type requested are available
//Query to be changed (end date to be taken into consideration)
public static void verifyUserPreference(int hotel_id,int room_number,String start_date)
{
	try {
	result=statement.executeQuery(String.format("SELECT * FROM Rooms WHERE (room_number, hotel_id) NOT IN (SELECT '%d','%d' from Reservations WHERE '%s' <= CURDATE())",room_number,hotel_id,start_date));
    //throw new RuntimeException("Parameters of this function cannot be found.");
    while(result.next()){
    	int rno=result.getInt("room_number");
    	int hotelid=result.getInt("hotel_id");
    	System.out.println("room number"+rno+"is available in hotel"+hotelid);
    }
    
} catch (SQLException e) {
	e.printStackTrace();
}
}
//REPORT OCCUPANCY
public static void reportOccupancyByHotel(JTextArea output) {
	try {
		result=statement.executeQuery("SELECT count(*) as count,hotel_id from Reservations  group by hotel_id");
		String resultStr="";
		while(result.next()){	
			resultStr += "\n"+result.getInt("count")+"occupied in"+result.getInt("hotel_id");
			System.out.println(result.getInt("count")+"occupied in"+result.getInt("hotel_id"));
		}
		output.setText(resultStr);
    	output.setVisible(true);
	} catch (SQLException e) {
			e.printStackTrace();
	}
}

public static void reportOccupancyByCity(JTextArea output) {
	try {
		result=statement.executeQuery("SELECT count(*) as count,l.city from Reservations r, Hotels h, Locations l where r.hotel_id=h.id"
									 +" and h.zip_code=l.zip_code group by l.city");
		String resultStr = "";
		while(result.next()){
			resultStr="\n"+result.getInt("count")+"occupied in city"+result.getString("l.city");	    	
	    	System.out.println(result.getInt("count")+"occupied in city"+result.getString("l.city"));
	    }
		output.setText(resultStr);
    	output.setVisible(true);
	} catch (SQLException e) {
			e.printStackTrace();
	}
}
//GENERATE BILL
public static void generatebill(int customer_id){
	try{
		result=statement.executeQuery("SELECT SUM(rates) as Total from(select sum(se.rate*pr.count) as rates from Services se,Pricings pr where se.service_name=pr.service_name and pr.service_name in(select p.service_name from Pricings p where p.checkin_id in(select checkin_id from Done_by where customer_id="+customer_id+" group by checkin_id)group by p.service_name) UNION ALL select sum(ps.nightly_rate) as rates from Pricings ps where ps.checkin_id in(select d.checkin_id from Done_by d where customer_id="+customer_id+")group by ps.checkin_id UNION ALL select sum(c.rate) from Category c,Rooms r where r.category_name=c.category_name and r.room_number in(select p.room_number from Pricings p where p.hotel_id =(select hotel_id from Pricings where checkin_id in(select checkin_id from Done_by where customer_id="+customer_id+")group by checkin_id))UNION ALL SELECT l.rate as rates from Locations l,Hotels h where l.zip_code=h.zip_code and h.id =(select hotel_id from Pricings where checkin_id in(select checkin_id from Done_by where customer_id="+customer_id+")group by checkin_id))Item");
	while(result.next()){
		System.out.println("The total bill is"+result.getInt("Total"));
	}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
}
//ITEMIZED RECEIPT
public static void generateitemizedreceipt(int customer_id){
	try{
		result=statement.executeQuery("select sum(se.rate*pr.count) as rates from Services se,Pricings pr where se.service_name=pr.service_name and pr.service_name in(select p.service_name from Pricings p where p.checkin_id in(select checkin_id from Done_by where customer_id="+customer_id+" group by checkin_id)group by p.service_name) UNION ALL select sum(ps.nightly_rate) as rates from Pricings ps where ps.checkin_id in(select d.checkin_id from Done_by d where customer_id="+customer_id+")group by ps.checkin_id UNION ALL select sum(c.rate) from Category c,Rooms r where r.category_name=c.category_name and r.room_number in(select p.room_number from Pricings p where p.hotel_id =(select hotel_id from Pricings where checkin_id in(select checkin_id from Done_by where customer_id="+customer_id+")group by checkin_id))UNION ALL SELECT l.rate as rates from Locations l,Hotels h where l.zip_code=h.zip_code and h.id =(select hotel_id from Pricings where checkin_id in(select checkin_id from Done_by where customer_id="+customer_id+")group by checkin_id)");

		while(result.next()){
		System.out.println("The bill split is"+result.getInt("rates"));
	}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
}

public static void reportOccupancyByDateRange(JTextArea output) {
	try {
		result=statement.executeQuery("Select count(*) as count,start_date,end_date from Reservations group by start_date, end_date");
	    String resultStr = "";
		while(result.next()){
			resultStr+="\n"+result.getInt("count")+"occupied in date range"+result.getString("start_date")+","+result.getString("end_date");
			System.out.println(result.getInt("count")+"occupied in date range"+result.getString("start_date")+","+result.getString("end_date"));
	    }
		
		output.setText(resultStr);
    	output.setVisible(true);
    	
	} catch (SQLException e) {
			e.printStackTrace();
	}
}

public static void reportOccupancyByRoomType(JTextArea output) {
	try {
		
		result=statement.executeQuery("SELECT count(*) as count,c.category_name from Reservations r, Rooms R, Category c where r.room_number=R.room_number"
									 +" and R.category_name = c.category_name group by c.category_name");
	    String resultStr = "";
		while(result.next()){
			resultStr+= "\n"+result.getInt("count")+"occupied of type"+result.getString("c.category_name");
	    	System.out.println(result.getInt("count")+"occupied of type"+result.getString("c.category_name"));
	    }
	    
	    output.setText("Roomtype");
    	output.setVisible(true);
    	
	} catch (SQLException e) {
			e.printStackTrace();
	}
}
//REPORT TOTAL OCCUPANCY
public static void reportTotalOccupancy() {
	try {
		result=statement.executeQuery("SELECT count(*) as count from Reservations");
	    while(result.next()){
	    	System.out.println(result.getInt("count")+"occupied in the entire hotel chain ");
	    }
	} catch (SQLException e) {
			e.printStackTrace();
	}
}

//REPORT PERCENTAGE ROOM OCCUPANCY
public static void reportPercentageOfRoomsOccupied() {
	try {
		result=statement.executeQuery("SELECT (a.total/count(*))*100 as percentage_occupancy from (select count(*) as"
									 +" total from Reservations) a, Rooms group by hotel_id");
	    while(result.next()){
	    	System.out.println(result.getInt("percentage_occupancy")+" percentage occupied in the entire hotel chain.");
	    }
	} catch (SQLException e) {
			e.printStackTrace();
	}
}
//GENERATE REVENUE BY GIVEN HOTEL AND DATE RANGE
public static void generaterevenuebyhoteldate(int hotel_id,String start_date,String end_date){
	try{
		result=statement.executeQuery("SELECT sum(Checkins.amount) as revenue,hotel_id from Checkins, Pricings where Pricings.checkin_id=Checkins.id and Pricings.hotel_id="+hotel_id+" and Checkins.id in (select id from Checkins where start_date>='"+start_date+"' and end_date<='"+end_date+"')");
	while(result.next()){
		System.out.println(result.getInt("revenue")+"is the revenue earned by"+result.getInt("hotel_id")+"in the given date range");
	}
	}
	catch(SQLException e){
		e.printStackTrace();
	}


}
//display staff details for every customer stay
public static void displaystaffforeverycustomerstay(){
	try{
		result=statement.executeQuery("SELECT * from Staffs where id in (select Serves.staff_id from Serves where (Serves.service_name,Serves.hotel_id) in (select service_name,hotel_id from Pricings group by checkin_id))");
	while(result.next()){
		System.out.println("The staff id is"+result.getInt("id")+"from hotel"+result.getInt("hotel_id")+"job_title is"+result.getString("job_title"));
	}
	}
	catch(SQLException e){
		e.printStackTrace();
	}
}

public static void insertIntoStaffs(int hotelID, String availability, String name, String  address, int age, String  job_title, String phone_number) {
	try{
	statement.executeUpdate("INSERT INTO Staffs(hotel_id, name, address, age, phone_number, job_title, availability) values("+hotelID+", '"+name+"','"+ address+"',"+age+", '"+phone_number+"', '"+job_title+"', '"+availability+"')");
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	
	}

}


class Frontend1 extends JPanel {

  public Frontend1() {

    JButton btn1 = new JButton("Frontdesk-representative");
    btn1.addActionListener(new ButtonListener());
    add(btn1);
    JButton btn2 = new JButton("Manager");
    btn2.addActionListener(new ButtonListener());
    add(btn2);
    

  }

  public void display() {
    JFrame frame = new JFrame();
    frame.getContentPane().add(new Frontend1());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1000, 1000);
    frame.setVisible(true);
  }
}

class ButtonListener extends JPanel implements ActionListener {
  
	ButtonListener() {	  
  }

  
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Frontdesk-representative")) {
      //System.out.println("Frontdesk representative has been clicked");
    	this.setVisible(false);
    	
    	new Login("Frontdesk").setVisible(true);
    	//new Frontdesk().setVisible(true);
    	
    }
    if (e.getActionCommand().equals("Checkin")) {
        //System.out.println("Frontdesk representative has been clicked");
      	this.setVisible(false);
      	//new Login("Frontdesk").setVisible(true);
      	new Checkin().setVisible(true);
      	//new Frontdesk().setVisible(true);
      	
      }
    if (e.getActionCommand().equals("Checkout")) {
        //System.out.println("Frontdesk representative has been clicked");
      	this.setVisible(false);
      	//new Login("Frontdesk").setVisible(true);
      	new Checkout().setVisible(true);
      	//new Frontdesk().setVisible(true);
      	
      }
    if (e.getActionCommand().equals("Enter/update/delete info")) {
        //System.out.println("Frontdesk representative has been clicked");
      	this.setVisible(false);
      	//new Login("Frontdesk").setVisible(true);
      	new DataEntry(new Frontend()).setVisible(true);
      	//new Frontdesk().setVisible(true);
      	
      }
    
    if (e.getActionCommand().equals("Check room type available")) {
        //System.out.println("Frontdesk representative has been clicked");
      	this.setVisible(false);
      	//new Login("Frontdesk").setVisible(true);
      	new RoomAvailability(new Frontend()).setVisible(true);
      	//new Frontdesk().setVisible(true);
      	
    }//
    

    if (e.getActionCommand().equals("Generate bills for customer stay")) {
        //System.out.println("Frontdesk representative has been clicked");
      	this.setVisible(false);
      	//new Login("Frontdesk").setVisible(true);
      	new GenerateBills(new Frontend()).setVisible(true);
      	//new Frontdesk().setVisible(true);
      	
    }//Assign Staff
    if (e.getActionCommand().equals("Report total occupancy")) {
        //System.out.println("Frontdesk representative has been clicked");
      	this.setVisible(false);
      	//new Login("Frontdesk").setVisible(true);
      	new ReportTotalOccupancy(new Frontend()).setVisible(true);
      	//new Frontdesk().setVisible(true);
      	
    }//Assign Staff
    if (e.getActionCommand().equals("Report percentage occupancy")) {
        //System.out.println("Frontdesk representative has been clicked");
      	this.setVisible(false);
      	//new Login("Frontdesk").setVisible(true);
      	new ReportPercOccupancy(new Frontend()).setVisible(true);
      	//new Frontdesk().setVisible(true);
      	
    }
    if (e.getActionCommand().equals("Assign Staff")) {
        //System.out.println("Frontdesk representative has been clicked");
      	this.setVisible(false);
      	//new Login("Frontdesk").setVisible(true);
      	new AssignStaff().setVisible(true);
      	//new Frontdesk().setVisible(true);
      	
    }//Report occupancy by hotel,room type,date range, city
    if (e.getActionCommand().equals("Report occupancy by hotel,room type,date range, city")) {
        //System.out.println("Frontdesk representative has been clicked");
      	this.setVisible(false);
      	//new Login("Frontdesk").setVisible(true);
      	new ReportOccupancy(new Frontend()).setVisible(true);
      	//new Frontdesk().setVisible(true);
      	
    }
    if (e.getActionCommand().equals("Login")) {
        //System.out.println("Frontdesk representative has been clicked");
      	this.setVisible(false);
      	new Frontdesk().setVisible(true);
      	//new Frontdesk().setVisible(true);
      	
      }//Return staff info grouped by role
    if (e.getActionCommand().equals("Return staff info grouped by role")) {
        //System.out.println("Frontdesk representative has been clicked");
      	this.setVisible(false);
      	//new Groupedstaff().setVisible(true);
      	//new Groupedstaff(new Frontend()).getStaffGroupedByRoles();
      	//new Frontdesk().setVisible(true);
      	new Groupedstaff(new Frontend());
      }//Staff info for every stay
    if (e.getActionCommand().equals("Staff info for every stay")) {
        //System.out.println("Frontdesk representative has been clicked");
      	this.setVisible(false);
      	new StaffforEveryStay(new Frontend()).setVisible(true);
      	//new Frontdesk().setVisible(true);
      	
      }//Generate revenue earned by hotel in date range
    if (e.getActionCommand().equals("Generate revenue earned by hotel in date range")) {
        //System.out.println("Frontdesk representative has been clicked");
      	this.setVisible(false);
      	new GenerateHotelRevenue(new Frontend()).setVisible(true);
      	//new Frontdesk().setVisible(true);
      	
      }
    if(e.getActionCommand().equals("Manager")){
    	//System.out.println("Manager is clicked");
    	this.setVisible(false);
    	new Login("Manager").setVisible(true);
    }
  
}
}
class Login extends JPanel{
	public Login(String text){
	    JTextField t1;  
	    t1=new JTextField("Enter code");  
	    t1.setBounds(50,100, 200,30);  
	    add(t1);
	    JButton login=new JButton("Login");
	    login.addActionListener(new ActionListener( ) {
	        public void actionPerformed( ActionEvent e )
	        {
	          //System.out.println( t1.getText() );
	        	if(t1.getText().equals("hello") && text.equals("Frontdesk"))
	        	{
	        		//this.setVisible(false);
	        		new Frontdesk().setVisible(true);
	        	}
	        	else if(t1.getText().equals("bye") && text.equals("Manager"))
	        	{
	        		//this.setVisible(false);
	        		new Manager().setVisible(true);
	        	} 
	        	else {
	        		//new Manager().setVisible(true);
	        		//new Error().set
	        		JOptionPane.showMessageDialog(null, "Enter valid access code");
	        	}
	        }
	      });
	    login.addActionListener(new ButtonListener());
	    add(login);
	    JFrame frame = new JFrame();
	    frame.getContentPane().add(this);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1000, 1000);
	    frame.setVisible(true);
	}
}
class Frontdesk extends JPanel{
	  public Frontdesk() {

		    JButton btn1 = new JButton("Checkin");
		    btn1.addActionListener(new ButtonListener());
		    add(btn1);
		    JButton btn2 = new JButton("Checkout");
		    btn2.addActionListener(new ButtonListener());
		    add(btn2);
		    JButton btn3 = new JButton("Enter/update/delete info");
		    btn3.addActionListener(new ButtonListener());
		    add(btn3);
		    JButton btn4 = new JButton("Check room type available");
		    btn4.addActionListener(new ButtonListener());
		    add(btn4);
		    JButton btn5 = new JButton("Generate bills for customer stay");
		    btn5.addActionListener(new ButtonListener());
		    add(btn5);
		    JFrame frame = new JFrame();
		    frame.getContentPane().add(this);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(1000, 1000);
		    frame.setVisible(true);

		  }
}
class Manager extends JPanel{
	  public Manager() {

		    JButton btn1 = new JButton("Assign Staff");
		    btn1.addActionListener(new ButtonListener());
		    add(btn1);
		    JButton btn2 = new JButton("Report occupancy by hotel,room type,date range, city");
		    btn2.addActionListener(new ButtonListener());
		    add(btn2);
		    JButton btn3 = new JButton("Report total occupancy");
		    btn3.addActionListener(new ButtonListener());
		    add(btn3);
		    JButton btn4 = new JButton("Report percentage occupancy");
		    btn4.addActionListener(new ButtonListener());
		    add(btn4);
		    JButton btn5 = new JButton("Return staff info grouped by role");
		    btn5.addActionListener(new ButtonListener());
		    add(btn5);
		    JButton btn6 = new JButton("Staff info for every stay");
		    btn6.addActionListener(new ButtonListener());
		    add(btn6);
		    JButton btn7 = new JButton("Generate revenue earned by hotel in date range");
		    btn7.addActionListener(new ButtonListener());
		    add(btn7);
		    JFrame frame = new JFrame();
		    frame.getContentPane().add(this);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(1000, 1000);
		    frame.setVisible(true);

		  }
}
class Checkin extends JPanel{
 public Checkin(){
	 System.out.println("Checkin");
}

}
class Checkout extends JPanel{
	 public Checkout(){
		 System.out.println("Checkout");
	}

	}

	

class DataEntry extends JPanel{
	 public DataEntry(Frontend f){
		 System.out.println("Enter/Update/Delete info");

	 }
}
class RoomAvailability extends JPanel{
	public RoomAvailability(Frontend f){
		JTextField id=new JTextField("hotel_id:");
		add(id);
		JTextField rno =new JTextField("room_no:");
		add(rno);
		JTextField date=new JTextField("start_date");
		add(date);
		JButton verifyuserPreference=new JButton("verify user preference");
		add(verifyuserPreference);
	    JFrame frame = new JFrame();
	    frame.getContentPane().add(this);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1000, 1000);
	    frame.setVisible(true);
	    verifyuserPreference.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		f.verifyUserPreference(Integer.parseInt(id.getText()),Integer.parseInt(rno.getText()),date.getText());	
	    	}
	    });
	    
		System.out.println("check if room and room type requested are available");
	}
}//GenerateBills
class GenerateBills extends JPanel{
	public GenerateBills(Frontend f){
		System.out.println("Generate Bills and itemized receipt");
		JTextField cusid=new JTextField("customer-id");
		add(cusid);
		JButton retrievebill=new JButton("Retrieve Bill");
		add(retrievebill);
		JButton itemizedreceipt=new JButton("Generate itemized receipt");
		add(itemizedreceipt);
	    JFrame frame = new JFrame();
	    frame.getContentPane().add(this);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1000, 1000);
	    frame.setVisible(true);
	    retrievebill.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		f.generatebill(Integer.parseInt(cusid.getText()));		
	    	}
	    });
	    itemizedreceipt.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		f.generateitemizedreceipt(Integer.parseInt(cusid.getText()));		
	    	}
	    });
		
	}
}
class AssignStaff extends JPanel{
	public AssignStaff(Frontend f){
		System.out.println("Assign Staff");
	    JFrame frame = new JFrame();
	    frame.getContentPane().add(this);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1000, 1000);
	    frame.setVisible(true);
//	    f.assignStaff();
	}
}//ReportOccupancy
class ReportOccupancy extends JPanel{
	public ReportOccupancy(Frontend f){
		System.out.println("Report Occupancy");
		JButton byhotel=new JButton("Report Occupancy By Hotel");
		add(byhotel);
		JButton bycity=new JButton("Report Occupancy By city");
		add(bycity);
		JButton bydaterange=new JButton("Report Occupancy By Daterange");
		add(bydaterange);
		JButton byroomtype=new JButton("Report Occupancy By RoomType");
		add(byroomtype);
		JTextArea tfOutput=new JTextArea(10,10);  
	    tfOutput.setBounds(200,200, 100,50);  
	    tfOutput.setLineWrap(true);
	    tfOutput.setVisible(false);
	    add(tfOutput);
	   
		
		byhotel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				f.reportOccupancyByHotel(tfOutput);
			}
		});
		bycity.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				f.reportOccupancyByCity(tfOutput);
			}
		});
		bydaterange.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				f.reportOccupancyByDateRange(tfOutput);
			}
		});
		bydaterange.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				f.reportOccupancyByRoomType(tfOutput);
			}
		});
		
	    JFrame frame = new JFrame();
	    frame.getContentPane().add(this);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1000, 1000);
	    frame.setVisible(true);
		
	}
}
class ReportTotalOccupancy extends JPanel{
	public ReportTotalOccupancy(Frontend f){
		System.out.println("Report Total Occupancy");
	    JFrame frame = new JFrame();
	    frame.getContentPane().add(this);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1000, 1000);
	    frame.setVisible(true);
	    f.reportTotalOccupancy();
	    
	}
}
class ReportPercOccupancy extends JPanel{
	public ReportPercOccupancy(Frontend f){
		System.out.println("Report Total precentage Occupancy");
	    JFrame frame = new JFrame();
	    frame.getContentPane().add(this);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1000, 1000);
	    frame.setVisible(true);
	    f.reportPercentageOfRoomsOccupied();
	    
	}
}

//Groupedstaff
class Groupedstaff extends JPanel{

	public Groupedstaff(Frontend f){
		JTextArea tfOutput=new JTextArea(10,10);  
	    tfOutput.setBounds(200,200, 100,50);  
	    tfOutput.setLineWrap(true);
	    tfOutput.setVisible(false);
	    add(tfOutput);
	   

	    JFrame frame = new JFrame();
	    frame.getContentPane().add(this);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1000, 1000);
	    frame.setVisible(true);
	    
	    f.getStaffGroupedByRoles();
	    
	}

}//StaffforEveryStay

class StaffforEveryStay extends JPanel{
	public StaffforEveryStay(Frontend f){
		System.out.println("StaffforEveryStay");
	    JFrame frame = new JFrame();
	    frame.getContentPane().add(this);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1000, 1000);
	    frame.setVisible(true);
	    f.displaystaffforeverycustomerstay();
		
	}
}//GenerateHotelRevenue

class GenerateHotelRevenue extends JPanel{
	public GenerateHotelRevenue(Frontend f)
	{
		System.out.println("Generate Hotel Revenue");
		JTextField id=new JTextField("hotel_id:");
		add(id);
		JTextField startdate =new JTextField("start_date:");
		add(startdate);
		JTextField enddate=new JTextField("end_date:");
		add(enddate);
		JButton revenueearned=new JButton("Earned Revenue");
		add(revenueearned);
		revenueearned.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				f.generaterevenuebyhoteldate(Integer.parseInt(id.getText()),startdate.getText(),enddate.getText());
			}
		});
	    JFrame frame = new JFrame();
	    frame.getContentPane().add(this);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1000, 1000);
	    frame.setVisible(true);
		
	}
}