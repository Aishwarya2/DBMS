import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Homework2 {
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
		
			connection = DriverManager.getConnection(jdbcURL+dbName,username,password);
 			statement = connection.createStatement();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
			initialize();
		//Insert	
		insertIntoHotels("New Marriot1", "9198331120","500 Fayetteville St, Raleigh, NC", 47.5,"27666","Raleigh");
		insertIntoRooms(7,200, "Deluxe", 4);
		insertIntoStaffs(1,"Yes", "New Robin Sam", "25 Brigadoon, Raleigh, NC", 29, "Catering","9451204444");
		insertIntoCustomers("Tony Stark", "750123456","1975-02-21", "stark@gmail.com");
	
		//Updates
		try{
		connection.setAutoCommit(false);
		updateHotels("New Updated Marriot", "501 Fayetteville St, Raleigh, NC", "9198331122", 1,"27601");
		connection.commit();
		}
		catch(SQLException ex){
			ex.printStackTrace();
			if(connection!=null){
				try{
					System.out.println("Transaction is being rolled back");
					connection.rollback();
				}
				catch(SQLException excep){
					excep.printStackTrace();
				}
			}
		}
		try{
			connection.setAutoCommit(true);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		updateRooms(1, 200, "Executive Suite", 3);
		updateStaffs("No","New Updated Robin Sam", "25 Brigadoon, Raleigh, NC", 39, "Laundry","9191211111",1);
		updateCustomers("Updated Tony Stark", "750123456","1975-02-21", "stark@gmail.com", 1);
	
	    //Deletes
		deleteFromHotels(2);
		deleteFromRooms(1, 202);
		deleteFromStaffs(2);
		deleteFromCustomers(2);
		
		//verify user preferences
		verifyUserPreference(1,200,"2018-05-03");
		
		//Maintain service records
		try{
		connection.setAutoCommit(false);
		updatePricings(1, 45.12, 3, 107,4,"Laundry");
		connection.commit();
		}
		catch(SQLException e){
			e.printStackTrace();
			if(connection!=null){
				try{
					System.out.println("Transaction is being rolled back");
					connection.rollback();
				}
				catch(SQLException excep){
					e.printStackTrace();
				}
			}
		}
		try{
			connection.setAutoCommit(true);
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		
		//Find available rooms of a particular category on a particular day
		findCategoryPreference(1,200,"2018-05-03","Deluxe");
		
		//Find availability of rooms by using room number
		findRoomAvailable(200,1);
		
		//Report occupancy by hotel
		reportOccupancyByHotel(0);
		
		//Report occupancy by room_type
		reportOccupancyByRoomType();
		
		//Report occupancy by date range
		reportOccupancyByDateRange();
		
		//Report occupancy by city
		reportOccupancyByCity();
		
		//Report Total Occupancy
		reportTotalOccupancy();
		
		//Report percentage of rooms occupied
		reportPercentageOfRoomsOccupied();
		
		//Information on number of Staffs grouped by their role
		getStaffGroupedByRoles();
		
       	// assignRoomsByRequest(hotel_id, customer_id, category_name, start_date, end_date, city, number_of_guests);
       	assignRoomsByRequest(1, 1, "Deluxe", "2018-05-03", "2018-05-10", "Raleigh",4);
		
       	//generate bill
       	generatebill(1);
       	
       	//int[]result=reportOccupancyBasedOnRequest(1, "Deluxe", "2018-05-03", "2018-05-10", "Raleigh");
       	//System.out.println("room"+result[0]+"in hotel"+result[1]);
		//Display Staff  details for every customer stay
		
       	// assignRoomsByRequest(hotel_id, customer_id, category_name, start_date, end_date, city, number_of_guests);
       //	assignRoomsByRequest(1, 1, "Deluxe", "2018-05-03", "2018-05-10", "Raleigh",4);
	}
	
	private static void initialize() {
		try {
			//connectToDatabase();
					//Class.forName("org.mariadb.jdbc.Driver");
        
		//String user = "asundar2";
		//String password = "200203826";


		
		try {
			statement.executeUpdate("DROP TABLE Paid_through");
			statement.executeUpdate("DROP TABLE Pricings");
			statement.executeUpdate("DROP TABLE Done_by");
			statement.executeUpdate("DROP TABLE Customers");
			statement.executeUpdate("DROP TABLE Cards");
			statement.executeUpdate("DROP TABLE Billings");
			statement.executeUpdate("DROP TABLE Serves");
			statement.executeUpdate("DROP TABLE Reservations");
			statement.executeUpdate("DROP TABLE Rooms");
			statement.executeUpdate("DROP TABLE Category");
			statement.executeUpdate("DROP TABLE Frontdesk_rep");
			statement.executeUpdate("DROP TABLE Managers");
			statement.executeUpdate("DROP TABLE Staffs");
			statement.executeUpdate("DROP TABLE Hotels");
			statement.executeUpdate("DROP TABLE Locations");
			statement.executeUpdate("DROP TABLE Services");
			statement.executeUpdate("DROP TABLE Checkins");
	} catch (SQLException e) {
	}
			
			
			
			
			
	statement.executeUpdate("create table Locations(zip_code char(5) PRIMARY KEY,address varchar(50) NOT NULL, rate float NOT NULL,city varchar(20) NOT NULL)");

			statement.executeUpdate("create table Hotels(id int PRIMARY KEY AUTO_INCREMENT,name varchar(30) NOT NULL,phone_number char(10) NOT NULL,zip_code char(5) NOT NULL,FOREIGN KEY (zip_code) REFERENCES Locations(zip_code) ON DELETE CASCADE)");
			
			statement.executeUpdate("create table Staffs(id int NOT NULL AUTO_INCREMENT,hotel_id int NOT NULL,name varchar(30) NOT NULL,address varchar(50) NOT NULL,age int NOT NULL,phone_number char(10) NOT NULL,job_title varchar(30) NOT NULL,availability varchar(5) NOT NULL,PRIMARY KEY (id, hotel_id),FOREIGN KEY (hotel_id) REFERENCES Hotels(id) ON DELETE CASCADE)");

			statement.executeUpdate("create table Managers(id int NOT NULL,hotel_id int NOT NULL, password varchar(32) NOT NULL,PRIMARY KEY(id, hotel_id),FOREIGN KEY (id, hotel_id) REFERENCES Staffs(id,hotel_id) ON DELETE CASCADE)");
			
			statement.executeUpdate("create table Frontdesk_rep(id int NOT NULL,hotel_id int NOT NULL,password varchar(32) NOT NULL,PRIMARY KEY(id, hotel_id),FOREIGN KEY (id, hotel_id) REFERENCES Staffs(id,hotel_id) ON DELETE CASCADE)");
			
			statement.executeUpdate("create table Customers(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30) NOT NULL,DOB date,email varchar(50) NOT NULL,phone_number char(10))");
			
			statement.executeUpdate("create table Billings (transaction_id int PRIMARY KEY AUTO_INCREMENT,billing_address varchar(100) NOT NULL,SSN char(10) NOT NULL)");

			statement.executeUpdate("create table Cards(card_number char(16) PRIMARY KEY,payment_method varchar(20) NOT NULL,discount float NOT NULL,SSN char(10) NOT NULL)");
			
			statement.executeUpdate("create table Paid_through (transaction_id int NOT NULL,card_number char(16) NOT NULL,PRIMARY KEY(transaction_id, card_number),FOREIGN KEY (transaction_id) REFERENCES Billings(transaction_id) ON DELETE CASCADE,FOREIGN KEY (card_number) REFERENCES Cards(card_number) ON DELETE CASCADE)");
			
			statement.executeUpdate("create table Category(category_name varchar(30) PRIMARY KEY,rate float NOT NULL)");
			
			statement.executeUpdate("create table Rooms(room_number int NOT NULL,hotel_id int NOT NULL, max_occupancy int NOT NULL,category_name varchar(30),PRIMARY KEY (hotel_id,room_number),FOREIGN KEY (hotel_id) REFERENCES Hotels(id) ON DELETE CASCADE,FOREIGN KEY (category_name) REFERENCES Category(category_name) ON DELETE CASCADE)");

			statement.executeUpdate("create table Checkins(id int PRIMARY KEY AUTO_INCREMENT,number_of_guests int DEFAULT 0,"
								   +"start_date date NOT NULL,end_date date NOT NULL,amount float,checkin_time time(3) NOT NULL,"
								   +"checkout_time time(3),CONSTRAINT chk_date CHECK(start_date<end_date))");
			
			statement.executeUpdate("create table Reservations (room_number int NOT NULL,hotel_id int NOT NULL, "
								   +"start_date date NOT NULL,end_date date NOT NULL,PRIMARY KEY(room_number, hotel_id, start_date, end_date),"
								   +"FOREIGN KEY(hotel_id, room_number) REFERENCES Rooms(hotel_id,room_number) ON DELETE CASCADE)");
			

			statement.executeUpdate("create table Services (service_name varchar(20) PRIMARY KEY,rate float NOT NULL)");
			
			statement.executeUpdate("create table Pricings(count int,nightly_rate float NOT NULL,checkin_id int NOT NULL,"
								   +"room_number int NOT NULL,hotel_id int NOT NULL, service_name varchar(20) NOT NULL,"
								   +"PRIMARY KEY(checkin_id, room_number, hotel_id, service_name),FOREIGN KEY(hotel_id, room_number) REFERENCES Rooms(hotel_id, room_number) ON DELETE CASCADE,"
								   +"FOREIGN KEY(checkin_id) REFERENCES Checkins(id) ON DELETE CASCADE,FOREIGN KEY(service_name) REFERENCES Services(service_name) ON DELETE CASCADE)");
			
			statement.executeUpdate("create table Done_by(checkin_id int NOT NULL,transaction_id int UNIQUE,"
								   +"customer_id int NOT NULL, PRIMARY KEY(checkin_id, customer_id),FOREIGN KEY(transaction_id) REFERENCES Billings(transaction_id) ON DELETE CASCADE,"
								   +"FOREIGN KEY(checkin_id) REFERENCES Checkins(id) ON DELETE CASCADE,FOREIGN KEY(customer_id) REFERENCES Customers(id) ON DELETE CASCADE)");
			
			statement.executeUpdate("create table Serves(staff_id int NOT NULL,hotel_id int NOT NULL,service_name varchar(20) NOT NULL,"
								+"checkin_id int NOT NULL,PRIMARY KEY(staff_id, hotel_id, service_name, checkin_id),FOREIGN KEY (hotel_id, staff_id) REFERENCES Staffs(hotel_id, id) ON DELETE CASCADE,"
								+"FOREIGN KEY(checkin_id) REFERENCES Checkins(id) ON DELETE CASCADE,FOREIGN KEY(service_name) REFERENCES Services(service_name) ON DELETE CASCADE)");
			
statement.executeUpdate("INSERT INTO Locations VALUES ('27601', '500 Fayetteville St, Raleigh, NC', 47.5,'Raleigh')");
		statement.executeUpdate("INSERT INTO Locations VALUES ('28202', '230 College St, Charlotte, NC', 99,'Charlotte')");
		statement.executeUpdate("INSERT INTO Locations VALUES ('43017', '600 Metro Pl, Dublin, OH', 69,'Dublin')");
		statement.executeUpdate("INSERT INTO Locations VALUES ('94559', '800 California Blvd, Napa, CA', 103,'Napa')");
		statement.executeUpdate("INSERT INTO Locations VALUES ('27607', '2100 Hillsborough St, Raleigh, NC', 73,'Raleigh')");
		statement.executeUpdate("INSERT INTO Locations VALUES ('33132', '146 Biscayne Blvd, Miami, FL', 65,'Miami')"); //63000
        statement.executeUpdate("INSERT INTO Locations VALUES ('31419', '16 Gateway Blvd, Savannah, GA', 88,'Savannah')");
		
		statement.executeUpdate("INSERT INTO Hotels(name, phone_number, zip_code) VALUES ('Marriot', '9198331120', '27601')");
		statement.executeUpdate("INSERT INTO Hotels(name, phone_number, zip_code) VALUES ('Holiday Inn', '9192381206', '28202')");
		statement.executeUpdate("INSERT INTO Hotels(name, phone_number, zip_code) VALUES ('Crown Plaza', '6147641231', '43017')");
		statement.executeUpdate("INSERT INTO Hotels(name, phone_number, zip_code) VALUES ('Spring Hill Suites', '7071205482', '94559')");
		statement.executeUpdate("INSERT INTO Hotels(name, phone_number, zip_code) VALUES ('Red Roof', '9194712063', '27607')");
		statement.executeUpdate("INSERT INTO Hotels(name, phone_number, zip_code) VALUES ('Conrad', '3055036500', '33132')"); // 56000
		statement.executeUpdate("INSERT INTO Hotels(name, phone_number, zip_code) VALUES ('Hampton Inn', '912619734', '31419')");
		
		statement.executeUpdate("INSERT INTO Staffs(hotel_id, name, address, age, phone_number, job_title, availability) values(1, 'Robin Sam', '25 Brigadoon, Raleigh, NC', 29, '9451204444', 'Catering', 'Yes')");
		statement.executeUpdate("INSERT INTO Staffs(hotel_id, name, address, age, phone_number, job_title, availability) values(2, 'Kanya Took', ' 84, Oberlin Road, Raleigh, NC', 43, '4444444444', 'Catering', 'Yes')");

		statement.executeUpdate("INSERT INTO Staffs(hotel_id, name, address, age, phone_number, job_title, availability) values(3, 'Seemant Shawn', 'Apt 63, 450 Oberlin Road, Raleigh, NC', 37, '5555555555', 'Laundry', 'Yes')");

		statement.executeUpdate("INSERT INTO Staffs(hotel_id, name, address, age, phone_number, job_title, availability) values(4, 'Rick Gose',  'Apt 34, 103 Avent Ferry Road, Raleigh, NC', 42, '7266266267', 'Manager', 'No')");

		statement.executeUpdate("INSERT INTO Staffs(hotel_id, name, address, age, phone_number, job_title, availability) values(5 , 'Huimin Joe' , '245, Fayetteville Road, Charlotte, NC', 45 , '7414115167',  ' Catering', 'No' )");

		statement.executeUpdate("INSERT INTO Staffs(hotel_id, name, address, age, phone_number, job_title, availability) values(6 , 'Ross Packard' , '8974, Niton Road, Charlotte, NC', 45 , '7411115167',  'Room Service', 'Yes')");

		statement.executeUpdate("INSERT INTO Staffs(hotel_id, name, address, age, phone_number, job_title, availability) values(7, 'Bihit Hans',  '103 Avent Ferry Road, Charolotte, NC', 42, '7216266267', 'Manager', 'Yes' )");

		statement.executeUpdate("INSERT INTO Staffs(hotel_id, name, address, age, phone_number, job_title, availability) values(7, 'Hans Hubberman',  '64, 103 Avenue Road, Dublin, OH', 39, '2216266267', 'Manager', 'Yes' )");

		statement.executeUpdate("INSERT INTO Staffs(hotel_id, name, address, age, phone_number, job_title, availability) values(7 , 'Ninoh Tu' , '24, Gollen drive, Napa', 45 , '7414111167',  ' Catering', 'Yes' )");

		statement.executeUpdate("INSERT INTO Staffs(hotel_id, name, address, age, phone_number, job_title, availability) values(7, 'Naromi Nida',  '1790 Venue Drive, Miami, Florida', 25, '2216266267', 'Catering', 'Yes' )");
		
		statement.executeUpdate("INSERT INTO Managers VALUES (1, 1, MD5('qwerty') )");
		statement.executeUpdate("INSERT INTO Managers VALUES (2, 2, MD5('password') )");
		statement.executeUpdate("INSERT INTO Managers VALUES (3, 3, MD5('manager') )");
		statement.executeUpdate("INSERT INTO Managers VALUES (4, 4, MD5('iamstarlord') )");
		statement.executeUpdate("INSERT INTO Managers VALUES (5, 5, MD5('abc123') )");
		statement.executeUpdate("INSERT INTO Managers VALUES (6, 6, MD5('admin123') )"); //63000
        statement.executeUpdate("INSERT INTO Managers VALUES (7, 7, MD5('123456') )");
		
		statement.executeUpdate("INSERT INTO Frontdesk_rep VALUES (8, 7, MD5('iamstaff'))");
		statement.executeUpdate("INSERT INTO Frontdesk_rep VALUES (9, 7, MD5('helloworld'))");
		statement.executeUpdate("INSERT INTO Frontdesk_rep VALUES (10, 7, MD5('dummypswd'))");
		
		statement.executeUpdate("INSERT INTO Customers(name, DOB, email, phone_number) VALUES ('Tony Stark', '1975-02-21', 'stark@gmail.com', '750123456')");
		statement.executeUpdate("INSERT INTO Customers(name, DOB, email, phone_number) VALUES ('Smith Brown', '1995-12-05', 'brown12@gmail.com', '9195820512')");
		statement.executeUpdate("INSERT INTO Customers(name, DOB, email, phone_number) VALUES ('Matt Newman', '2000-07-13', 'matt@gmail.com', '6509271048')");
		statement.executeUpdate("INSERT INTO Customers(name, DOB, email, phone_number) VALUES ('Judy Davis', '1990-08-31', 'jdy318@gmail.com', '9198310278')");
		statement.executeUpdate("INSERT INTO Customers(name, DOB, email, phone_number) VALUES ('Richard Charles', '1980-03-17', 'richard@gmail.com', '75')");
		statement.executeUpdate("INSERT INTO Customers(name, DOB, email, phone_number) VALUES ('Michael Halpert', '1992-05-30', 'mchalpert@gmail.com', '3053287420')"); //63000
        statement.executeUpdate("INSERT INTO Customers(name, DOB, email, phone_number) VALUES ('Pam Howard', '1980-11-14', 'pamhoward@gmail.com', '9124738930')");

		statement.executeUpdate("INSERT INTO Billings(billing_address, SSN) VALUES ('2842 Avent Ferry Rd, Apt 402, Raleigh, NC, 27606', '5761936104')");
		statement.executeUpdate("INSERT INTO Billings(billing_address, SSN) VALUES ('4423 Miami Blvd, Apt 103, Miami, FL, 33132', '7483819362')");
		statement.executeUpdate("INSERT INTO Billings(billing_address, SSN) VALUES ('5454 Ontario Common, Fremont, CA, 94555', '5139231046')");
		statement.executeUpdate("INSERT INTO Billings(billing_address, SSN) VALUES ('2715 Folsom Street, Apt 514, Charlotte, NC, 28202','5769251047')");
		statement.executeUpdate("INSERT INTO Billings(billing_address, SSN) VALUES ('99 West Camino Drive, Apt 402, San Francisco, CA, 9436','5559361047')");
		statement.executeUpdate("INSERT INTO Billings(billing_address, SSN) VALUES ('3288 Ivey Wood Lane, New York, NY, 10457', '4927518579')"); 
        statement.executeUpdate("INSERT INTO Billings(billing_address, SSN) VALUES ('6349 Alderton St, Apt 203, Chicago, IL, 89271', '3938361047')");

		statement.executeUpdate("INSERT INTO Cards VALUES (1234567891233456, 'Debit',0, '5761936104' )");
statement.executeUpdate("INSERT INTO Cards VALUES  (8324567891233456, 'Credit',0,'7483819362' )");
statement.executeUpdate("INSERT INTO Cards VALUES (1234567991233456, 'Hotel_Credit',0.05,'5139231046' )");
statement.executeUpdate("INSERT INTO Cards VALUES (2234567891233456, 'Debit',0,'5769251047' )");
statement.executeUpdate("INSERT INTO Cards VALUES (3234567891233456, 'Hotel_Credit',0.05,'5559361047' )");
statement.executeUpdate("INSERT INTO Cards VALUES (4234567891233456, 'Credit',0,'4927518579' )");
statement.executeUpdate("INSERT INTO Cards VALUES (5234567891233456, 'Hotel_Credit',0.05,'3938361047')");

statement.executeUpdate("INSERT INTO Paid_through VALUES (6, 1234567991233456)");
statement.executeUpdate("INSERT INTO Paid_through VALUES (4, 1234567891233456)");
statement.executeUpdate("INSERT INTO Paid_through VALUES (7, 2234567891233456)");
statement.executeUpdate("INSERT INTO Paid_through VALUES (5, 8324567891233456)");
statement.executeUpdate("INSERT INTO Paid_through VALUES (2, 3234567891233456)");
statement.executeUpdate("INSERT INTO Paid_through VALUES (1, 4234567891233456)");
statement.executeUpdate("INSERT INTO Paid_through VALUES (3, 5234567891233456)");

statement.executeUpdate("INSERT INTO Category VALUES('Deluxe', 100)");
statement.executeUpdate("INSERT INTO Category VALUES('Presidential Suite', 220 )");
statement.executeUpdate("INSERT INTO Category VALUES( 'Executive Suite', 150)");
statement.executeUpdate("INSERT INTO Category VALUES( 'Economy', 75.55)");

statement.executeUpdate("INSERT INTO Rooms VALUES(200, 1 ,4, 'Deluxe' )"); 
statement.executeUpdate("INSERT INTO Rooms VALUES(201, 2, 2, 'Presidential Suite' )"); 
statement.executeUpdate("INSERT INTO Rooms VALUES(202, 1, 4, 'Executive Suite' )"); 
statement.executeUpdate("INSERT INTO Rooms VALUES(204, 2, 2, 'Deluxe' )"); 
statement.executeUpdate("INSERT INTO Rooms VALUES(207, 4, 4, 'Deluxe' )"); 
statement.executeUpdate("INSERT INTO Rooms VALUES(101, 4, 4, 'Presidential Suite' )"); 
statement.executeUpdate("INSERT INTO Rooms VALUES(107, 4, 4, 'Deluxe' )"); 
statement.executeUpdate("INSERT INTO Rooms VALUES(103, 3, 4, 'Economy' )");

statement.executeUpdate("INSERT INTO Checkins(number_of_guests, start_date, end_date, amount, checkin_time,checkout_time  ) VALUES (0, '2018-07-05', '2018-08-05', 100,'08:00:00', '10:00:00')");
statement.executeUpdate("INSERT INTO Checkins(number_of_guests, start_date, end_date, amount, checkin_time,checkout_time ) VALUES ( 4, '2018-07-08', '2018-07-10', 100, '11:30:45', '09:15:00')");
statement.executeUpdate("INSERT INTO Checkins(number_of_guests, start_date, end_date, amount, checkin_time,checkout_time ) VALUES ( 2, '2017-12-30', '2018-01-02', 320, '10:00:00', '15:45:00')");
statement.executeUpdate("INSERT INTO Checkins(number_of_guests, start_date, end_date, amount, checkin_time,checkout_time ) VALUES ( 1, '2018-08-31', '2018-09-02', 500, '12:20:00', '07:20:00')");
statement.executeUpdate("INSERT INTO Checkins(number_of_guests, start_date, end_date, amount, checkin_time,checkout_time ) VALUES ( 3, '2018-05-07', '2018-05-10', 437, '04:00:00', '07:00:00')");
statement.executeUpdate("INSERT INTO Checkins(number_of_guests, start_date, end_date, amount, checkin_time,checkout_time ) VALUES ( 2, '2018-10-02', '2018-10-06', 750, '10:25:00', '04:21:00')");
statement.executeUpdate("INSERT INTO Checkins(number_of_guests, start_date, end_date, amount, checkin_time,checkout_time ) VALUES ( 5, '2018-03-10', '2018-03-12', 275, '07:30:00', '10:19:00')");
statement.executeUpdate("INSERT INTO Checkins(number_of_guests, start_date, end_date, amount, checkin_time,checkout_time ) VALUES ( 5, '2018-03-10', '2018-03-12', 275, '07:30:00', NULL)");

statement.executeUpdate("INSERT INTO Reservations VALUES( 200, 1, '2018-05-07', '2018-05-08' )");
statement.executeUpdate("INSERT INTO Reservations VALUES( 201, 2, '2018-06-09', '2018-06-10' )");
statement.executeUpdate("INSERT INTO Reservations VALUES( 202, 1, '2018-05-24', '2018-05-25' )");
statement.executeUpdate("INSERT INTO Reservations VALUES( 103, 3, '2018-04-04', '2018-04-05' )");
statement.executeUpdate("INSERT INTO Reservations VALUES( 107, 4, '2018-06-24', '2018-06-29' )");

statement.executeUpdate("INSERT INTO Services VALUES('Laundry', 24.25 )");
statement.executeUpdate("INSERT INTO Services VALUES('Food-Service', 12.25 )");
statement.executeUpdate("INSERT INTO Services VALUES('Butler', 40 )");
statement.executeUpdate("INSERT INTO Services VALUES('Housekeeping', 8.25 )");

statement.executeUpdate("INSERT INTO Serves VALUES (2, 2, 'Laundry', 1)");
statement.executeUpdate("INSERT INTO Serves VALUES (2, 2, 'Food-Service', 1)");
statement.executeUpdate("INSERT INTO Serves VALUES (1, 1, 'Butler', 2)");
statement.executeUpdate("INSERT INTO Serves VALUES (1, 1, 'Housekeeping', 2)");
statement.executeUpdate("INSERT INTO Serves VALUES (3, 3, 'Laundry', 3)");
statement.executeUpdate("INSERT INTO Serves VALUES (3, 3, 'Food-Service', 3)");

statement.executeUpdate("INSERT INTO Pricings values(4, 45.12,1, 201, 2, 'Laundry' )");
statement.executeUpdate("INSERT INTO Pricings values(1, 55.12,2, 202, 1, 'Laundry')");
statement.executeUpdate("INSERT INTO Pricings values(2, 35.12,3, 107, 4, 'Food-Service')");
statement.executeUpdate("INSERT INTO Pricings values(1, 15.12,4, 200, 1, 'Housekeeping')");

statement.executeUpdate("INSERT INTO Done_by VALUES (1, 1, 1)");
statement.executeUpdate("INSERT INTO Done_by VALUES (2, 2, 2)");
statement.executeUpdate("INSERT INTO Done_by VALUES (3, 3, 3)");
statement.executeUpdate("INSERT INTO Done_by VALUES (4, 4, 4)");
statement.executeUpdate("INSERT INTO Done_by VALUES (5, 7, 5)");
statement.executeUpdate("INSERT INTO Done_by VALUES (6, 5, 6)");
statement.executeUpdate("INSERT INTO Done_by VALUES (7, 6, 7)");
		}  catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void insertIntoRooms(int hotelID, int room_number, String category_name,int max_occupancy) {
		try{
		statement.executeUpdate("INSERT INTO Rooms VALUES("+room_number+", "+hotelID+" ,"+max_occupancy+", '"+category_name+"' )"); 
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	private static void insertIntoHotels(String name, String phone_number, String address, double rate, String zipcode,String city) {
	try{
		statement.executeUpdate("INSERT INTO Locations VALUES ('"+zipcode+"', '"+address+"', "+rate+",'"+city+"')");
		statement.executeUpdate("INSERT INTO Hotels(name, phone_number, zip_code) VALUES ('"+name+"', '"+phone_number+"', '"+zipcode+"')");
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	}
	private static void insertIntoStaffs(int hotelID, String availability, String name, String  address, int age, String  job_title, String phone_number) {
		try{
		statement.executeUpdate("INSERT INTO Staffs(hotel_id, name, address, age, phone_number, job_title, availability) values("+hotelID+", '"+name+"','"+ address+"',"+age+", '"+phone_number+"', '"+job_title+"', '"+availability+"')");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		}
	private static void insertIntoCustomers(String name, String phone_number,String dob,String emailID) {
	try{
		statement.executeUpdate("INSERT INTO Customers(name, DOB, email, phone_number) VALUES ('"+name+"','"+dob+"','"+emailID+"', '"+phone_number+"')");	
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	}
	private static void updateHotels(String name,String address,String phone_number,int hotelID,String zipcode) {
		try{
			//statement.executeUpdate("UPDATE Hotels SET name='"+name+"',phone_number='"+phone_number+"' WHERE id ='"+hotelID+"')");
			statement.executeUpdate(String.format("UPDATE Hotels set name='%s',phone_number='%s' where id='%s'",name,phone_number,hotelID));
			statement.executeUpdate(String.format("UPDATE Locations set address='%s' where zip_code ='%s'",address,zipcode));
			//throw new RuntimeException("Parameters of this function cannot be found.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void updateRooms(int hotelID, int room_number, String category_name, int max_occupancy) {
		try{
			statement.executeUpdate(String.format("UPDATE Rooms SET category_name='%s', max_occupancy='%d' WHERE hotel_id ='%d' and room_number='%d'",category_name,max_occupancy,hotelID,room_number));
			//throw new RuntimeException("Parameters of this function cannot be found.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void updateStaffs(String availability, String name,String address,int age,String job_title,String phone_number, int staffID){
		try{
			statement.executeUpdate(String.format("UPDATE Staffs SET availability='%s', name='%s', address='%s', age='%d', job_title='%s', phone_number='%s' WHERE id ='%d'",availability,name,address,age,job_title,phone_number,staffID));
			//throw new RuntimeException("Parameters of this function cannot be found.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	private static void updateCustomers(String name,String phone_number,String dob,String emailID,int customer_id){
		try{
			statement.executeUpdate(String.format("UPDATE Customers SET name='%s', phone_number='%s', dob='%s', email='%s' WHERE id ='%d'",name,phone_number,dob,emailID,customer_id));	
			//throw new RuntimeException("Parameters of this function cannot be found.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	private static void deleteFromHotels(int hotelID) {
		try{
			statement.executeUpdate("DELETE from Hotels where id="+hotelID);
			//throw new RuntimeException("Parameters of this function cannot be found.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	private static void deleteFromRooms(int hotelID,int room_number){
		try{
			statement.executeUpdate("DELETE from Rooms where hotel_id="+hotelID+" and room_number="+room_number);
			//throw new RuntimeException("Parameters of this function cannot be found.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	private static void deleteFromStaffs(int staffID) {
		try{
			statement.executeUpdate("DELETE from Staffs where id="+staffID);
			//throw new RuntimeException("Parameters of this function cannot be found.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	private static void deleteFromCustomers(int customerID) {
		try{
			statement.executeUpdate("DELETE from Customers where id="+customerID);	
			//throw new RuntimeException("Parameters of this function cannot be found.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	private static void verifyUserPreference(int hotel_id,int room_number,String start_date)
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
	
	private static void updatePricings(int count,double nightly_rate,int checkin_id,int room_number,int hotel_id,String service_name)
{
	try {
	statement.executeUpdate("INSERT INTO Pricings VALUES("+count+", "+nightly_rate+" ,"+checkin_id+", "+room_number+","+hotel_id+",'"+service_name+"' )");
	statement.executeUpdate(String.format("UPDATE Pricings SET count = count+1 WHERE service_name like '%s' AND checkin_id ='%d' AND hotel_id = '%d' AND room_number = '%d'",service_name,checkin_id,hotel_id,room_number));
	
	//throw new RuntimeException("Parameters of this function cannot be found.");
} catch (SQLException e) {
	e.printStackTrace();
}
}
	private static void findCategoryPreference(int hotel_id,int room_number,String start_date, String Category)
{
	try {
	result=statement.executeQuery(String.format("SELECT * FROM Rooms WHERE (room_number, hotel_id) NOT IN (SELECT '%d','%d'from Reservations WHERE '%s' <= CURDATE()) AND category_name LIKE '%s'",room_number,hotel_id,start_date,Category));
	//throw new RuntimeException("Parameters of this function cannot be found.");
	while(result.next()){
		int rno=result.getInt("room_number");
		int hotelid=result.getInt("hotel_id");
		System.out.println("Catagory"+Category+"in room_number"+rno+"of hotel"+hotelid);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
}
	private static void findRoomAvailable(int room_number1,int hotel_id1)
{
try {
result=statement.executeQuery(String.format("SELECT * FROM Rooms WHERE (room_number, hotel_id) NOT IN (SELECT '%d','%d' from Reservations WHERE start_date <= CURDATE()) AND room_number = '%d' AND hotel_id = '%d'",room_number1,hotel_id1,room_number1,hotel_id1));
//throw new RuntimeException("Parameters of this function cannot be found.");
while(result.next())
{
	int rno=result.getInt("room_number");
	int hotelid=result.getInt("hotel_id");
	if(rno==room_number1 && hotelid==hotel_id1)
		System.out.println("The room is available");
	else
		System.out.println("The room is not available");
	
}
} catch (SQLException e) {
e.printStackTrace();
}
}
	//Report Occupancy
	private static void reportOccupancyByHotel(int count) {
		try {
			result=statement.executeQuery("SELECT count(*) as count,hotel_id from Reservations  group by hotel_id");
			while(result.next())
			{
				System.out.println(result.getInt("count")+"occupied in"+result.getInt("hotel_id"));
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	private static void reportOccupancyByRoomType() {
		try {
			result=statement.executeQuery("SELECT count(*) as count,c.category_name from Reservations r, Rooms R, Category c where r.room_number=R.room_number"
										 +" and R.category_name = c.category_name group by c.category_name");
		    while(result.next()){
		    	System.out.println(result.getInt("count")+"occupied of type"+result.getString("c.category_name"));
		    }
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	private static void reportOccupancyByDateRange() {
		try {
			result=statement.executeQuery("Select count(*) as count,start_date,end_date from Reservations group by start_date, end_date");
		    while(result.next()){
		    	System.out.println(result.getInt("count")+"occupied in date range"+result.getString("start_date")+","+result.getString("end_date"));
		    }
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	private static void reportOccupancyByCity() {
		try {
			result=statement.executeQuery("SELECT count(*) as count,l.city from Reservations r, Hotels h, Locations l where r.hotel_id=h.id"
										 +" and h.zip_code=l.zip_code group by l.city");
		    while(result.next()){
		    	System.out.println(result.getInt("count")+"occupied in city"+result.getString("l.city"));
		    }
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	//Report total occupancy
	private static void reportTotalOccupancy() {
		try {
			result=statement.executeQuery("SELECT count(*) as count from Reservations");
		    while(result.next()){
		    	System.out.println(result.getInt("count")+"occupied in the entire hotel chain ");
		    }
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	//Report percentage of rooms Occupied
	private static void reportPercentageOfRoomsOccupied() {
		try {
			result=statement.executeQuery("SELECT (a.total/count(*))*100 as percentage_occupancy from (select count(*) as"
										 +" total from Reservations) a, Rooms");
		    while(result.next()){
		    	System.out.println(result.getInt("percentage_occupancy")+"percentage occupied in the entire hotel chain ");
		    }
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	//Staff Grouped by their roles
	private static void getStaffGroupedByRoles() {
		try {
			result=statement.executeQuery("SELECT job_title,count(*) as count from Staffs group by job_title");
		    while(result.next()){
		    	System.out.println("Number of staffs in"+result.getString("job_title")+"is"+result.getInt("count"));
		    }
		} catch (SQLException e) {
				e.printStackTrace();
		}	
	}
	
	//assign rooms to customers as per request
	private static void assignRoomsByRequest(int hotelID,int customerID, String categoryName,String startDate,String endDate,String city, int number_of_guests) {
		int[] roomhotel=reportOccupancyBasedOnRequest(hotelID, categoryName, startDate, endDate,city);
		if(roomhotel[0]==-1)
		{
			System.out.println("room not available while checkin");
			return;
		}
		//If needed
		// insertIntoCustomers("Tony Stark", "750123456","1975-02-21", "stark@gmail.com");	
		
		try {
			
		insertIntoReservations(roomhotel[0], roomhotel[1], startDate, endDate);
		// insertIntoCheckins(number_of_guests,start_date, end_date, amount, checkin_time, checkout_time);

		int checkinID = insertIntoCheckins(number_of_guests,hotelID, startDate, endDate);
		
		insertIntoDoneBy(checkinID, customerID);
        
		int[]staffs=findavailablestaffs(hotelID);
		if(staffs[0]==-1)
		{
		  System.out.println("Staffs not available");
		  return;
		}
		//if category name = Presidential Suite
		if(categoryName == "Presidential Suite") {
			insertIntoServes(staffs[0], hotelID, "HouseKeeping",checkinID);
			insertIntoServes(staffs[1], hotelID, "Catering",checkinID);
			statement.executeQuery("UPDATE Staffs SET availability='No' where id in ("+staffs[0]+","+staffs[1]+") and hotel_id="+hotelID+"");
		}
		//throw new RuntimeException("Parameters of this function cannot be found.");
		} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	private static int[] reportOccupancyBasedOnRequest(int hotelID, String category_name, String startDate,String endDate,String city) {
		int[]answer=new int[2];
		try {
				result=statement.executeQuery("SELECT * FROM Reservations r, Hotels h where r.hotel_id="+hotelID+" and r. room_number in"
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
			
				//throw new RuntimeException("Parameters of this function cannot be found.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return answer;
	}
	private static void insertIntoReservations(int room_number,int hotelID, String startDate,String endDate) {
		try{
		result=statement.executeQuery("SELECT * from Rooms where room_number="+room_number+" and hotel_id="+hotelID+"");
		if(result.next())
		statement.executeUpdate("INSERT INTO Reservations VALUES ("+room_number+", "+hotelID+", '"+startDate+"','"+endDate+"')");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		}

	private static int insertIntoCheckins(int number_of_guests,int hotel_id, String startDate,String endDate) {
		int cid=0;
		try{
		statement.executeUpdate("INSERT INTO Checkins(number_of_guests,start_date,end_date,checkin_time) VALUES ("+number_of_guests+", '"+startDate+"','"+endDate+"',TIME(NOW()))");
		 result = statement.executeQuery("SELECT LAST_INSERT_ID()");
		 while(result.next()){
			 cid=result.getInt(1);
		 }
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cid;
		}

	private static void insertIntoServes(int staffid,int hotelid,String job_title,int checkinid) {
		try{
		statement.executeUpdate("INSERT INTO Serves VALUES ("+staffid+","+hotelid+",'"+job_title+"',"+checkinid+")");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		}
	private static void insertIntoDoneBy(int checkinID, int customerID) {
		try{
		statement.executeUpdate("INSERT INTO Done_by VALUES ("+checkinID+",NULL, "+customerID+")");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		}
	private static int[] findavailablestaffs(int hotelID) {
		int count=0;
		int[]s=new int[2];
		try{
		result=statement.executeQuery("SELECT id from Staffs WHERE hotel_id="+hotelID+"");
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
	private static void generatebill(int customer_id){
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
}
