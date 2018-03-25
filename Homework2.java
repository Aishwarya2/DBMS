import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Homework2 {
static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/asundar2";
private static Connection connection = null;
private static Statement statement = null;
private static ResultSet result = null;

public static void main(String[] args) {

	initialize();
/*
  

*/
	try {
		
		

	} catch (SQLException e) {
		e.printStackTrace();
		
	if (connection != null) {
		try {
			System.err.print("Transaction is being rolled back");
			connection.rollback();
		} catch(SQLException excep) {
		  
			excep.printStackTrace();
		}
	}
	}
	try{
	connection.setAutoCommit(true);
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	// ***********************************************************************
	close();
}

private static void initialize() {
	try {
		connectToDatabase();

		statement.executeUpdate("CREATE TABLE Students (Name VARCHAR(20), "
				+ "School VARCHAR(10), Age INTEGER, FundingReceived INTEGER, Income INTEGER, Sex CHAR(1))");

		statement.executeUpdate("INSERT INTO Students VALUES ('Todd', 'NC State'," + " 18, 16000, 30000, 'M')");
		statement.executeUpdate("INSERT INTO Students VALUES ('Max', 'Stanford'," + " 21, 20000, 70000, 'M')");
		statement.executeUpdate("INSERT INTO Students VALUES ('Alex', 'UNC'," + " 19, 8000, 40000, 'M')");
		statement.executeUpdate("INSERT INTO Students VALUES ('Natasha', 'Harvard'," + " 22, 15000, 75000, 'F')");
		statement.executeUpdate("INSERT INTO Students VALUES ('Kelly', 'UCLA'," + " 23, 2000, 50000, 'F')");
		statement.executeUpdate("INSERT INTO Students VALUES ('Angela', 'NYU'," + "18, 8000, 45000, 'F')"); //63000

		statement.executeUpdate("CREATE TABLE Schools (Name VARCHAR(10), Location VARCHAR(30), "
				+ "TuitonFees INTEGER, LivingExpenses INTEGER)");
		statement.executeUpdate("INSERT INTO Schools VALUES ('NC State', 'North Carolina', 24000, 20000)");
		statement.executeUpdate("INSERT INTO Schools VALUES ('Stanford', 'California', 44000, 35000)");
		statement.executeUpdate("INSERT INTO Schools VALUES ('UNC', 'North Carolina', 34000, 20000)");
		statement.executeUpdate("INSERT INTO Schools VALUES ('Harvard', 'Massachusetts', 50000, 38000)");
		statement.executeUpdate("INSERT INTO Schools VALUES ('UCLA', 'California', 36000, 30000)");
		statement.executeUpdate("INSERT INTO Schools VALUES ('NYU', 'New York', 22000, 41000)"); // 56000
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
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