import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;



public class Manager extends JFrame {

	private JPanel contentPane;
	private Statement smt = null;
	private ResultSet result = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager frame = new Manager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Manager (){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("184px"),
				ColumnSpec.decode("60px"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblManager = new JLabel("Manager");
		contentPane.add(lblManager, "1, 2, left, top");
		
		JButton btnAssignStaff = new JButton("Assign staff");
		contentPane.add(btnAssignStaff, "1, 4");
		
		JButton btnReportTotalOccupany = new JButton("Report total occupany ");
		contentPane.add(btnReportTotalOccupany, "1, 6");
	}
	
	public Manager(Statement smt) {
		this.smt = smt;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblManager = new JLabel("Manager");
		contentPane.add(lblManager, BorderLayout.NORTH);
		try {
			result=smt.executeQuery("SELECT job_title,count(*) as count from Staffs group by job_title");
		    while(result.next()){
		    	System.out.println("Number of staffs in"+result.getString("job_title")+"is"+result.getInt("count"));
		    }
		} catch (SQLException ex) {
				ex.printStackTrace();
		}
	}

}
