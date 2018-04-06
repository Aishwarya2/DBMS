import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Frontend extends JPanel {

  public Frontend() {

    JButton btn1 = new JButton("Frontdesk-representative");
    btn1.addActionListener(new ButtonListener());
    add(btn1);
    JButton btn2 = new JButton("Manager");
    btn2.addActionListener(new ButtonListener());
    add(btn2);
    

  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.getContentPane().add(new Frontend());

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
    if (e.getActionCommand().equals("Login")) {
        //System.out.println("Frontdesk representative has been clicked");
      	this.setVisible(false);
      	new Frontdesk().setVisible(true);
      	//new Frontdesk().setVisible(true);
      	
      }
    else if(e.getActionCommand().equals("Manager")){
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
		    JButton btn2 = new JButton("Generate Revenue");
		    btn2.addActionListener(new ButtonListener());
		    add(btn2);
		    JFrame frame = new JFrame();
		    frame.getContentPane().add(this);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(1000, 1000);
		    frame.setVisible(true);

		  }
}