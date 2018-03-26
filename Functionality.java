import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Functionality {
	static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/asundar2";
	// Put your oracle ID and password here

	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet result = null;

	public static void main(String[] args) {

		connectToDatabase();
		//Enter into table operation hotel,rooms,staffs,customers
		// insertIntoHotels(name, phone_number, address, rate, zipcode,city);
		insertIntoHotels("New Marriot", "9198331120","500 Fayetteville St, Raleigh, NC", 47.5,"27666","Raleigh");
		// insertIntoRooms(hotelID,room_number, category_name, max_occupancy);
		insertIntoRooms(1,200, "Deluxe", 4);
		// insertIntoStaffs(hotelID,availability, name, address, age, job_title, phone_number);
		insertIntoStaffs(1,"Yes", "New Robin Sam", "25 Brigadoon, Raleigh, NC", 29, "Catering","9451204444");
		// insertIntoCustomers(name, phone_number, dob, emailID);
		insertIntoCustomers("Tony Stark", "750123456","1975-02-21", "stark@gmail.com");

		//Update tables operation hotel,rooms,staffs,customers
		// updateHotels(name, address, phone_number, HotelID,zipcode);
		updateHotels("New Updated Marriot", "501 Fayetteville St, Raleigh, NC", "9198331122", 1,'27601');
		// updateRooms(hotelID, room_number, category_name, max_occupancy);
		updateRooms(1, 200, "Executive Suite", 3);
		// updateStaffs(availability,name, address, age, job_title, phone_number, StaffID);
		updateStaffs("No","New Updated Robin Sam", "25 Brigadoon, Raleigh, NC", 39, "Laundry",1);
		// updateCustomers(name, phone_number, dob, emailID, customer_id);
		updateCustomers("Updated Tony Stark", "750123456","1975-02-21", "stark@gmail.com", 1);

		//Delete tables operation hotel,rooms,staffs,customers
		// deleteFromHotels(HotelID);
		deleteFromHotels(2);
		// deleteFromRooms(hotelID, room_number);
		deleteFromRooms(2, 201);
		// deleteFromStaffs(staffID);
		deleteFromStaffs(2);
		// deleteFromCustomers(customerID);
		deleteFromCustomers(2);

		//Check if room and room type requested are available
		

		//Assign rooms to customers by request

        //Release rooms
		
		//Maintain billing account
		
		//Itemized receipt
		
		//Report occupancy by hotel , room_type, date range and city
		
		//Details about Occupancy
		
		//Report Total Occupancy
		
		//Report percentage of rooms occupied
		
		//Information on number of Staffs grouped by their role
		
		//Display Staff  details for every customer stay
		
		//Generate revenue earned by a given hotel during a given date range
		
		
		close();
	}
	
	private static void insertIntoHotels(String name, String phone_number, String address, float rate, String zipcode) {
		statement.executeUpdate("INSERT INTO Locations VALUES ('"+zipcode+"', '"+address+"', "+rate+",'"+city+"')");
		statement.executeUpdate("INSERT INTO Hotels(name, phone_number, zip_code) VALUES ('"+name+"', '"+phone_number+"', '"+zipcode+"')");
	}

	private static void insertIntoRooms(int hotelID, int room_number, String category_name,int max_occupancy) {
		statement.executeUpdate("INSERT INTO Rooms VALUES("+room_number+", "+hotelID+" ,"+max_occupancy+", '"+category_name+"' )"); 
	}

	private static void insertIntoStaffs(int hotelID, String availability, String name, String  address, int age, String  job_title, String phone_number) {
		statement.executeUpdate("INSERT INTO Staffs(hotel_id, name, address, age, phone_number, job_title, availability) values("+hotelID+", '"+name"'+,'"+ address+"',"+age+", '"+phone_number+"', '"+job_title+"', '"+availability+"')");
	}


	private static void insertIntoCustomers(String name, String phone_number,String dob,String emailID) {
		statement.executeUpdate("INSERT INTO Customers(name, DOB, email, phone_number) VALUES ('"+name+"','"+dob+"','"+emailID+"', '"+phone_number+"')");	
	}

	//Update tables operation hotel,rooms,staffs,customers
	private static void updateHotels(String name,String address,String phone_number,int hotelID,String zipcode) {
		try{
			statement.executeUpdate("UPDATE Hotels SET name='"+name+"'phone_number='"+phone_number+"' WHERE id ="+hotelID );
			statement.executeUpdate("UPDATE Locations SET address='"+address+"' WHERE zipcode ='"+zipcode+"'" );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void updateRooms(int hotelID, int room_number, String category_name, int max_occupancy) {
		try{
			statement.executeUpdate("UPDATE Rooms SET category_name='"+category_name+"', max_occupancy="+max_occupancy+" WHERE hotel_id ="+hotelID+" and room_number="+room_number );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void updateStaffs(String availability, String name,String address,int age,String job_title,String phone_number, int staffID){
		try{
			statement.executeUpdate("UPDATE Staffs SET availability='"+availability+"', name='"+name+"', address='"+address+"', age="+age+", job_title='"+job_title+"', phone_number='"+phone_number+"' WHERE id ="+staffID );
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	private static void updateCustomers(String name,String phone_number,String dob,String emailID,int customer_id){
		try{
			statement.executeUpdate("UPDATE Customers SET name='"+name+"', phone_number='"+phone_number+"', dob='"+dob+"', email='"+emailID+"' WHERE id ="+customer_id);	
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//Delete tables operation hotel,rooms,staffs,customers
	private static void deleteFromHotels(int hotelID) {
		try{
			statement.executeUpdate("DELETE from Hotels where id="+hotelID);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	private static void deleteFromRooms(int hotelID,int room_number){
		try{
			statement.executeUpdate("DELETE from Rooms where hotel_id="+hotelID+" and room_number="+room_number);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	private static void deleteFromStaffs(int staffID) {
		try{
			statement.executeUpdate("DELETE from Staffs where id="+staffID);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	private static void deleteFromCustomers(int customerID) {
		try{
			statement.executeUpdate("DELETE from Customers where id="+customerID);	
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	private static void connectToDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");

		String user = "asundar2";
		String password = "200203826";

		connection = DriverManager.getConnection(jdbcURL, user, password);
		statement = connection.createStatement();

	}

	private static void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (result != null) {
			try {
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
