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
		
		//Update tables operation hotel,rooms,staffs,customers
		
		//Delete tables operation hotel,rooms,staffs,customers
		
		//Check if room and room type requested are available
		verifyUserPreference('1','200','2018-05-03');
		//Find available rooms of a particular category on a particular day
		findCategoryPreference('1','200','2018-05-03','Deluxe');
		//Find availability of rooms by using room number
		findRoomAvailable('200','1');
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
	private static void verifyUserPreference(int hotel_id,int room_number,Date start_date)
	{
		try {
		result=statement.executeQuery("SELECT * FROM Rooms WHERE (room_number, hotel_id) NOT IN (SELECT ' "+room_number, hotel_id+"%' from Reservations WHERE '"+start_date+"%' <= CURDATE())");


		throw new RuntimeException("Parameters of this function cannot be found.");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
		private static void findCategoryPreference(int hotel_id,int room_number,Date start_date, String Category)
	{
		try {
		result=statement.executeQuery("SELECT * FROM Rooms WHERE (room_number, hotel_id) NOT IN (SELECT ' "+room_number, hotel_id+" 'from Reservations WHERE ' "+start_date+"' <= CURDATE()) AND category_name LIKE '"+Category+"");
		throw new RuntimeException("Parameters of this function cannot be found.");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
			private static void findRoomAvailable(int room_number,int hotel_id)
	{
		try {
		result=statement.executeQuery("SELECT * FROM Rooms WHERE (room_number, hotel_id) NOT IN (SELECT '"+room_number, hotel_id+"' from Reservations WHERE start_date <= CURDATE()) AND room_number = '"+room_number"' AND hotel_id = '"+hotel_id+"");
		throw new RuntimeException("Parameters of this function cannot be found.");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
}
