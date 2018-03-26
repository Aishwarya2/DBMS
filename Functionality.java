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

		verifyUserPreference('1','200','2018-05-03');
		//Find available rooms of a particular category on a particular day
		findCategoryPreference('1','200','2018-05-03','Deluxe');
		//Find availability of rooms by using room number
		findRoomAvailable('200','1');	
		//Assign rooms to customers by request
       

        //Release rooms
		releaserooms(checkout_time,customer_id,checkin_id);
		
		//Maintain Service records
		updatePricings(1, 45.12, 3, 107,4,'Laundry');
        //UPDATE Pricings SET count = count+1 WHERE (service_name like 'Laundry' AND checkin_id = 3 AND hotel_id = 4 AND room_number = 107);
        		
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
	private static void verifyUserPreference(int hotel_id,int room_number,Date start_date)
	{
		try {
		result=statement.executeQuery("SELECT * FROM Rooms WHERE (room_number, hotel_id) NOT IN (SELECT ' "+room_number, hotel_id+"%' from Reservations WHERE '"+start_date+"%' <= CURDATE())");


		throw new RuntimeException("Parameters of this function cannot be found.");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
		private static void updatePricings(int count,int nightly_rate,int checkin_id,int room_number,int hotel_id,String service_name)
	{
		try {
		result=statement.executeQuery("INSERT INTO Pricings VALUES("+count+", "+nightly_rate+" ,"+checkin_id+", "+room_number+","+hotel_id+",'"+service_name+"' )");
		result1=statement.executeQuery("UPDATE Pricings SET count = count+1 WHERE (service_name like '"+service_name+"' AND checkin_id = "+checkin_id+" AND hotel_id = "+hotel_id+" AND room_number = "+room_number+")");
		
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
				private static void releaserooms(Time checkout_time,int customer_id,int checkin_id)
	{
		try {
			//Update checkout time in timeins
		result=statement.executeUpdate("UPDATE Checkins SET checkout_time=CURRENT_TIME() where id in(select d.checkin_id from Done_by d where d.customer_id='"+customer_id+"')");
		    //Update amount in checkins table
		result1=statement.executeUpdate("UPDATE Checkins SET amount=( select SUM(rates) as Total from(select sum(se.rate*pr.count) as rates from Services se,Pricings pr where se.service_name=pr.service_name and pr.service_name in(select p.service_name from Pricings p where p.checkin_id in(select checkin_id from Done_by where customer_id=3 group by checkin_id)group by p.service_name) UNION ALL select sum(ps.nightly_rate) as rates from Pricings ps where ps.checkin_id in(select d.checkin_id from Done_by d where customer_id=3)group by ps.checkin_id UNION ALL select sum(c.rate) from Category c,Rooms r where r.category_name=c.category_name and r.room_number in(select p.room_number from Pricings p where p.hotel_id =(select hotel_id from Pricings where checkin_id in(select checkin_id from Done_by where customer_id='"+customer_id+"')group by checkin_id))UNION ALL  select l.rate as rates from Locations l,Hotels h where l.zip_code=h.zip_code and h.id =(select hotel_id from Pricings where checkin_id in(select checkin_id from Done_by where customer_id=3)group by checkin_id))Item) where id in (select d.checkin_id from Done_by d where d.customer_id='"+customer_id+"')");
		throw new RuntimeException("Parameters of this function cannot be found.");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
}
