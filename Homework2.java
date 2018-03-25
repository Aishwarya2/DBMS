import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Homework2 {
	static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/vsreeni";
	// Put your oracle ID and password here

	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet result = null;

	public static void main(String[] args) {

		initialize();
	}
	
	private static void initialize() {
		try {
			connectToDatabase();
			statement.executeUpdate("create table Locations(zip_code char(5) PRIMARY KEY,"
								   +"address varchar(50) NOT NULL, rate float NOT NULL,"
								   +"city varchar(20) NOT NULL, CONSTRAINT chk_zipcode CHECK(zip_code not like '%[^0-9]%')");
			
			statement.executeUpdate("create table Hotels(id int PRIMARY KEY AUTO_INCREMENT,"
								   +"name varchar(30) NOT NULL,phone_number char(10) NOT NULL,"
								   +"zip_code char(5) NOT NULL,FOREIGN KEY (zip_code) REFERENCES Locations(zip_code) ON DELETE CASCADE)");
			
			statement.executeUpdate("create table Staffs(id int NOT NULL AUTO_INCREMENT,hotel_id int NOT NULL,"
								   +"name varchar(30) NOT NULL,address varchar(50) NOT NULL,age int NOT NULL,"
								   +"phone_number char(10) NOT NULL,job_title varchar(30) NOT NULL,availability varchar(5) NOT NULL,"
								   +"PRIMARY KEY (id, hotel_id),FOREIGN KEY (hotel_id) REFERENCES Hotels(id) ON DELETE CASCADE,"
								   +"CONSTRAINT chk_phone_no CHECK(phone_number not like '%[^0-9]%'),CONSTRAINT chk_avail CHECK(availability='Yes' OR availability='No'),"
								   +"CONSTRAINT chk_avail CHECK(age>18 AND age<=60)");

			statement.executeUpdate("create table Managers(id int NOT NULL,hotel_id int NOT NULL, password varchar(32) NOT NULL,"
								   +"PRIMARY KEY(id, hotel_id),FOREIGN KEY (id, hotel_id) REFERENCES Staffs(id,hotel_id) ON DELETE CASCADE,"
								   +"CONSTRAINT chk_pwd CHECK(lengthb(password)>6)");
			
			statement.executeUpdate("create table Frontdesk_rep(id int NOT NULL,hotel_id int NOT NULL, "
								   +"password varchar(32) NOT NULL,PRIMARY KEY(id, hotel_id),"
								   +"FOREIGN KEY (id, hotel_id) REFERENCES Staffs(id,hotel_id) ON DELETE CASCADE,CONSTRAINT chk_pwd CHECK(lengthb(password)>6))");
			
			statement.executeUpdate("create table Customers(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30) NOT NULL,"
								   +"DOB date,email varchar(50) NOT NULL,phone_number char(10),"
								   +"CONSTRAINT chk_phone_no CHECK(phone_number not like '%[^0-9]%'),CONSTRAINT chk_email CHECK(email like '%@%.%')");
			
			statement.executeUpdate("create table Billings (transaction_id int PRIMARY KEY AUTO_INCREMENT,"
								   +"billing_address varchar(100) NOT NULL)");

			statement.executeUpdate("create table Cards(card_number char(16) PRIMARY KEY,payment_method varchar(20) NOT NULL,"
								   +"discount float NOT NULL,SSN char(10) NOT NULL,CONSTRAINT chk_card_no CHECK(card_number not like '%[^0-9]%'),"
								   +"CONSTRAINT chk_discount CHECK(discount in (0.05,1)))");
			
			statement.executeUpdate("create table Paid_through (transaction_id int NOT NULL,card_number char(16) NOT NULL,"
								   +"PRIMARY KEY(transaction_id, card_number),FOREIGN KEY (transaction_id) REFERENCES Billings(transaction_id) ON DELETE CASCADE,"
								   +"FOREIGN KEY (card_number) REFERENCES Cards(card_number) ON DELETE CASCADE)");
			
			statement.executeUpdate("create table Category(category_name varchar(30) PRIMARY KEY,rate float NOT NULL)");
			
			statement.executeUpdate("create table Rooms(room_number int NOT NULL,hotel_id int NOT NULL, max_occupancy int NOT NULL,"
								   +"category_name varchar(30),PRIMARY KEY (hotel_id,room_number),FOREIGN KEY (hotel_id) REFERENCES Hotels(id) ON DELETE CASCADE,"
								   +"FOREIGN KEY (category_name) REFERENCES Category(category_name) ON DELETE CASCADE)");

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
			
			statement.executeUpdate("INSERT INTO Students VALUES ('Todd', 'NC State'," + " 18, 16000, 30000, 'M')");
			statement.executeUpdate("INSERT INTO Students VALUES ('Max', 'Stanford'," + " 21, 20000, 70000, 'M')");
			statement.executeUpdate("INSERT INTO Students VALUES ('Alex', 'UNC'," + " 19, 8000, 40000, 'M')");
			statement.executeUpdate("INSERT INTO Students VALUES ('Natasha', 'Harvard'," + " 22, 15000, 75000, 'F')");
			statement.executeUpdate("INSERT INTO Students VALUES ('Kelly', 'UCLA'," + " 23, 2000, 50000, 'F')");
			statement.executeUpdate("INSERT INTO Students VALUES ('Angela', 'NYU'," + "18, 8000, 45000, 'F')");

			statement.executeUpdate("CREATE TABLE Schools (Name VARCHAR(10), Location VARCHAR(30), "
					+ "TuitonFees INTEGER, LivingExpenses INTEGER)");
			statement.executeUpdate("INSERT INTO Schools VALUES ('NC State', 'North Carolina', 24000, 20000)");
			statement.executeUpdate("INSERT INTO Schools VALUES ('Stanford', 'California', 44000, 35000)");
			statement.executeUpdate("INSERT INTO Schools VALUES ('UNC', 'North Carolina', 34000, 20000)");
			statement.executeUpdate("INSERT INTO Schools VALUES ('Harvard', 'Massachusetts', 50000, 38000)");
			statement.executeUpdate("INSERT INTO Schools VALUES ('UCLA', 'California', 36000, 30000)");
			statement.executeUpdate("INSERT INTO Schools VALUES ('NYU', 'New York', 22000, 41000)");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void connectToDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");

		String user = "vsreeni";
		String password = "200205504";

		connection = DriverManager.getConnection(jdbcURL, user, password);
		statement = connection.createStatement();

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
