import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Frontend
{
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
      	new DataEntry().setVisible(true);
      	//new Frontdesk().setVisible(true);
      	
      }
    
    if (e.getActionCommand().equals("Check room type available")) {
        //System.out.println("Frontdesk representative has been clicked");
      	this.setVisible(false);
      	//new Login("Frontdesk").setVisible(true);
      	new RoomAvailability().setVisible(true);
      	//new Frontdesk().setVisible(true);
      	
    }//Generate bills for customer stay
    if (e.getActionCommand().equals("Generate bills for customer stay")) {
        //System.out.println("Frontdesk representative has been clicked");
      	this.setVisible(false);
      	//new Login("Frontdesk").setVisible(true);
      	new GenerateBills().setVisible(true);
      	//new Frontdesk().setVisible(true);
      	
    }//Assign Staff
    if (e.getActionCommand().equals("Report total occupancy")) {
        //System.out.println("Frontdesk representative has been clicked");
      	this.setVisible(false);
      	//new Login("Frontdesk").setVisible(true);
      	new ReportTotalOccupancy().setVisible(true);
      	//new Frontdesk().setVisible(true);
      	
    }//Assign Staff
    if (e.getActionCommand().equals("Report percentage occupancy")) {
        //System.out.println("Frontdesk representative has been clicked");
      	this.setVisible(false);
      	//new Login("Frontdesk").setVisible(true);
      	new ReportPercOccupancy().setVisible(true);
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
      	new ReportOccupancy().setVisible(true);
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
      	new StaffforEveryStay().setVisible(true);
      	//new Frontdesk().setVisible(true);
      	
      }//Generate revenue earned by hotel in date range
    if (e.getActionCommand().equals("Generate revenue earned by hotel in date range")) {
        //System.out.println("Frontdesk representative has been clicked");
      	this.setVisible(false);
      	new GenerateHotelRevenue().setVisible(true);
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
	 public DataEntry(){
		 System.out.println("Enter/Update/Delete info");
	}

	}
class RoomAvailability extends JPanel{
	public RoomAvailability(){
		System.out.println("check if room and room type requested are available");
	}
}//GenerateBills
class GenerateBills extends JPanel{
	public GenerateBills(){
		System.out.println("Generate Bills and itemized receipt");
	}
}
class AssignStaff extends JPanel{
	public AssignStaff(){
		System.out.println("Assign staff by Manager");
	}
}//ReportOccupancy
class ReportOccupancy extends JPanel{
	public ReportOccupancy(){
		System.out.println("Report Occupancy");
	}
}
class ReportTotalOccupancy extends JPanel{
	public ReportTotalOccupancy(){
		System.out.println("Report Total Occupancy");
	}
}
class ReportPercOccupancy extends JPanel{
	public ReportPercOccupancy(){
		System.out.println("ReportPercOccupancy");
	}
}

//Groupedstaff
class Groupedstaff extends JPanel{

	public Groupedstaff(Frontend f){


	    JFrame frame = new JFrame();
	    frame.getContentPane().add(this);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1000, 1000);
	    frame.setVisible(true);
	    
	    f.getStaffGroupedByRoles();
	    
	}

}//StaffforEveryStay

class StaffforEveryStay extends JPanel{
	public StaffforEveryStay(){
		System.out.println("StaffforEveryStay");
	}
}//GenerateHotelRevenue

class GenerateHotelRevenue extends JPanel{
	public GenerateHotelRevenue(){
		System.out.println("Generate Hotel Revenue");
	}
}