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

import javax.swing.JLayeredPane;
import javax.swing.JTextField;


public class WindowTrial {

	private static final String jdbcURL = "jdbc:mysql://mydbinstance.ca6owdm4itco.us-east-1.rds.amazonaws.com:3306/";
	// Put your oracle ID and password here
    private static final String username="aishwaryassr";
	private static final String password="Macrohard.123";
	private static final String dbName="dbname";	
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet result = null;
	
	public Statement smt=null;
	private JFrame frame;
	private JTextField tf_login_code;
	private JLabel lblUser;
	private JButton btnFrontDeskRep;
	private JButton btnManager;
	private JButton btnLogin;
	private JLabel lblEnterCode;
	private JButton btnLogout;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
			} catch(SQLException e){
				e.printStackTrace();
			}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowTrial window = new WindowTrial(statement);
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
	public WindowTrial(Statement smt) {
		this.smt = smt;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initComponents();
		initEvent();
	}
	
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
		
		lblUser = new JLabel("User");
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser.gridx = 2;
		gbc_lblUser.gridy = 1;
		frame.getContentPane().add(lblUser, gbc_lblUser);
		lblUser.setVisible(false);
		
		btnFrontDeskRep = new JButton("Front Desk Rep");
		
		GridBagConstraints gbc_btnFrontDeskRep = new GridBagConstraints();
		gbc_btnFrontDeskRep.insets = new Insets(0, 0, 5, 5);
		gbc_btnFrontDeskRep.gridx = 3;
		gbc_btnFrontDeskRep.gridy = 1;
		frame.getContentPane().add(btnFrontDeskRep, gbc_btnFrontDeskRep);
		
		btnManager = new JButton("Manager");
		
		GridBagConstraints gbc_btnManager = new GridBagConstraints();
		gbc_btnManager.insets = new Insets(0, 0, 5, 5);
		gbc_btnManager.gridx = 5;
		gbc_btnManager.gridy = 1;
		frame.getContentPane().add(btnManager, gbc_btnManager);
		
		lblEnterCode = new JLabel("Enter Code:");
		GridBagConstraints gbc_lblEnterCode = new GridBagConstraints();
		gbc_lblEnterCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterCode.gridx = 2;
		gbc_lblEnterCode.gridy = 4;
		frame.getContentPane().add(lblEnterCode, gbc_lblEnterCode);
		lblEnterCode.setVisible(false);
		
		tf_login_code = new JTextField();
		GridBagConstraints gbc_tf_login_code = new GridBagConstraints();
		gbc_tf_login_code.insets = new Insets(0, 0, 5, 5);
		gbc_tf_login_code.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_login_code.gridx = 4;
		gbc_tf_login_code.gridy = 4;
		frame.getContentPane().add(tf_login_code, gbc_tf_login_code);
		tf_login_code.setColumns(10);
		tf_login_code.setVisible(false);
		
		btnLogin = new JButton("Login");
		
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 5;
		gbc_btnLogin.gridy = 4;
		frame.getContentPane().add(btnLogin, gbc_btnLogin);
		btnLogin.setVisible(false);
		
		btnLogout = new JButton("Login Menu");
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogout.gridx = 4;
		gbc_btnLogout.gridy = 11;
		frame.getContentPane().add(btnLogout, gbc_btnLogout);
		btnLogout.setVisible(false);
	}
	
	private void initEvent(){
		//FrontEndRep Login
				btnFrontDeskRep.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						lblUser.setText("Front Desk Rep");
						btnFrontDeskRep.setVisible(false);
						lblUser.setVisible(true);
						btnManager.setVisible(false);
						lblEnterCode.setVisible(true);
						btnLogin.setVisible(true);
						tf_login_code.setVisible(true);
						btnLogout.setVisible(true);
						try {
							result=smt.executeQuery("SELECT job_title,count(*) as count from Staffs group by job_title");
						    while(result.next()){
						    	System.out.println("Number of staffs in"+result.getString("job_title")+"is"+result.getInt("count"));
						    }
						} catch (SQLException ex) {
								ex.printStackTrace();
						}
						
					}
				});
				
				//Manager Login
				btnManager.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						lblUser.setText("Manager");
						lblUser.setVisible(true);
						btnManager.setVisible(false);
						btnFrontDeskRep.setVisible(false);
						lblEnterCode.setVisible(true);
						btnLogin.setVisible(true);
						tf_login_code.setVisible(true);
						btnLogout.setVisible(true);
					}
				});
				
				//Login
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Manager m = new Manager();
						m.setVisible(true);
					}
				});
				
				//Logout
				btnLogout.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						hideAllOtherComponents();
						btnManager.setVisible(true);
						btnFrontDeskRep.setVisible(true);
					}
				});
			}
			
			private void hideAllOtherComponents() {
				lblUser.setVisible(false);
				btnManager.setVisible(false);
				btnFrontDeskRep.setVisible(false);
				lblEnterCode.setVisible(false);
				btnLogin.setVisible(false);
				tf_login_code.setVisible(false);
				btnLogout.setVisible(false);
			}
	}
