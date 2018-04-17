import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;

//Main Menu for navigating between Manager and FrontDesk representative
public class WindowTrial {

	private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/";
	private static final String username = "vsreeni";
	private static final String password = "200205504";
	private static final String dbName="vsreeni";
	
	
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet result = null;	

	
	public Statement smt=null;
	private JFrame frame;
	private JButton btnFrontDeskRep;
	private JButton btnManager;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			try{
				//Establishing connection to DB 
				connection=DriverManager.getConnection(jdbcURL+dbName,username,password);
	 			//Create statment from Connection object
	 			statement = connection.createStatement();
			} catch(SQLException e){
				e.printStackTrace();
			}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Display Window containing the Main Menu
					WindowTrial window = new WindowTrial(statement, connection);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowTrial(Statement smt, Connection connection) {
		this.smt = smt;
		this.connection = connection;
		initialize();
	}

	private void initialize() {
		initComponents();
		initEvent();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponents(){
		frame = new JFrame();
		frame.setBounds(100, 100, 714, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		//Front Desk rep button
		btnFrontDeskRep = new JButton("Front Desk Rep");
		GridBagConstraints gbc_btnFrontDeskRep = new GridBagConstraints();
		gbc_btnFrontDeskRep.insets = new Insets(0, 0, 5, 5);
		gbc_btnFrontDeskRep.gridx = 3;
		gbc_btnFrontDeskRep.gridy = 1;
		frame.getContentPane().add(btnFrontDeskRep, gbc_btnFrontDeskRep);
		
		//Manager Button
		btnManager = new JButton("Manager");
		GridBagConstraints gbc_btnManager = new GridBagConstraints();
		gbc_btnManager.insets = new Insets(0, 0, 5, 5);
		gbc_btnManager.gridx = 5;
		gbc_btnManager.gridy = 1;
		frame.getContentPane().add(btnManager, gbc_btnManager);
	}
	

	//Handle events 
	private void initEvent(){
				//Front Desk Representative view 
				btnFrontDeskRep.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FrontDeskRep f = new FrontDeskRep(smt, connection);
						f.setVisible(true);
					}
				});
				
				//Manager View
				btnManager.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Manager m = new Manager(smt);
						m.setVisible(true);
					}
				});
			}
	}