package project;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProjectTry extends JFrame {
	private JTextField firstName = null;
	private JTextField lastName = null;
	Connection con=null;
    PreparedStatement st = null;
    JRadioButton rdbtSelected = null;
    
    byte rockBand = 0;
    byte classicalBand = 0;
    byte soloFlute = 0;
    byte sitarAndTabla = 0;
    byte fluteAndTabla = 0;
    private JTextField ageText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectTry frame = new ProjectTry();
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
	public ProjectTry() throws SQLException{
		
		final String url = "jdbc:mysql://localhost:3306/project";
		final String uname = "root";
		final String pass = "Omkar@1301";
		
		
		getContentPane().setBackground(new Color(255, 222, 173));
		setBackground(new Color(255, 239, 213));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().setForeground(new Color(0, 0, 139));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		getContentPane().setLayout(null);
		
		JLabel eventRegisteration = new JLabel("Event Registeration");
		eventRegisteration.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		eventRegisteration.setBounds(215, 11, 334, 49);
		getContentPane().add(eventRegisteration);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblFirstName.setBounds(23, 215, 178, 49);
		getContentPane().add(lblFirstName);
		
		firstName = new JTextField();
		firstName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		firstName.setBounds(251, 217, 498, 49);
		getContentPane().add(firstName);
		firstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblLastName.setBounds(23, 300, 178, 49);
		getContentPane().add(lblLastName);
		
		lastName = new JTextField();
		lastName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lastName.setColumns(10);
		lastName.setBounds(251, 302, 498, 49);
		getContentPane().add(lastName);
		
		
		
		JLabel lblAgeGroup = new JLabel("Age Group :");
		lblAgeGroup.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblAgeGroup.setBounds(23, 397, 160, 49);
		getContentPane().add(lblAgeGroup);
		
		JLabel likeToHear = new JLabel("Musical Instrument Performances You Would Like To Hear");
		likeToHear.setFont(new Font("Tahoma", Font.BOLD, 24));
		likeToHear.setBounds(23, 464, 726, 49);
		getContentPane().add(likeToHear);
		
		// option 1
		
		final JCheckBox opt1 = new JCheckBox("Flute and Tabla");
		opt1.setBackground(new Color(255, 222, 173));
		opt1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		opt1.setBounds(23, 562, 215, 23);
		getContentPane().add(opt1);
		
		opt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// flute and tabla
				if(opt1.isSelected()) {
					fluteAndTabla = 1;
				}
				else {
					fluteAndTabla = 0;
				}
			}
		});
		
		
		// option 2
		
		final JCheckBox opt2 = new JCheckBox("Solo Flute performance");
		opt2.setBackground(new Color(255, 222, 173));
		opt2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		opt2.setBounds(265, 562, 231, 23);
		getContentPane().add(opt2);
		
		opt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// solo flute
				if(opt2.isSelected()) {
					soloFlute = 1;
				}
				else {
					soloFlute = 0;
				}
			}
		});
		
		
		// option 3
		final JCheckBox opt3 = new JCheckBox(" Sitar And Tabla");
		opt3.setBackground(new Color(255, 222, 173));
		opt3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		opt3.setBounds(534, 562, 215, 23);
		getContentPane().add(opt3);
		
		
		opt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// sitar and tabla
				if(opt3.isSelected()) {
					sitarAndTabla = 1;
				}
				else {
					sitarAndTabla = 0;
				}
			}
		});
		
		//option 4
		
		final JCheckBox opt4 = new JCheckBox("Rock Band");
		opt4.setBackground(new Color(255, 222, 173));
		opt4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		opt4.setBounds(144, 603, 165, 23);
		getContentPane().add(opt4);
		
		
		opt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opt4.isSelected()) {
					rockBand = 1;
				}
				else {
					rockBand = 0;
				}
			}
		});
		
		
		//option 5
		
		final JCheckBox opt5 = new JCheckBox("Classical Band");
		opt5.setBackground(new Color(255, 222, 173));
		opt5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		opt5.setBounds(435, 603, 271, 23);
		getContentPane().add(opt5);
		
		opt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// classical band
				
				if(opt5.isSelected()) {
					classicalBand = 1;
				}
				else {
					classicalBand = 0;
				}
				
			}
		});
		
		JLabel eventDate = new JLabel("Event Date : 25 December 2020");
		eventDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eventDate.setBounds(23, 89, 317, 25);
		getContentPane().add(eventDate);
		
		JLabel website = new JLabel("For More Details Go To  www.enchantedmusic.com");
		website.setFont(new Font("Tahoma", Font.PLAIN, 20));
		website.setBounds(23, 148, 505, 25);
		getContentPane().add(website);
		
		JLabel lblQuote = new JLabel("\u201CMusic is the shorthand of emotion.\u201D \u2013 Leo Tolstoy");
		lblQuote.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblQuote.setBounds(68, 706, 662, 55);
		getContentPane().add(lblQuote);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.setBackground(new Color(64, 224, 208));
		submitBtn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		submitBtn.setBounds(286, 646, 171, 49);
		getContentPane().add(submitBtn);
		
		JLabel lblAbove = new JLabel("Below 18  /  18 - 50  / above 50   ");
		lblAbove.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAbove.setBounds(198, 412, 317, 25);
		getContentPane().add(lblAbove);
		
		ageText = new JTextField();
		ageText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				if(Character.isLetter(c))
					e.consume();
			}
		});
		ageText.setFont(new Font("Tahoma", Font.PLAIN, 22));
		ageText.setColumns(10);
		ageText.setBounds(534, 399, 172, 49);
		getContentPane().add(ageText);	
		
		JLabel lblNewLabel = new JLabel("(Please check  the boxes carefully)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(198, 509, 326, 31);
		getContentPane().add(lblNewLabel);
		
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            System.out.println("Driver Loaded");
		            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Omkar@1301");
		            System.out.println("Connection Established");
		            System.out.println("Inserting Value in Table");
		        
		            String first = firstName.getText();
		            String last = lastName.getText();
		            String age = ageText.getText() ;
		            int opt1 = fluteAndTabla;
		            int opt2 = soloFlute;
		            int opt3 = sitarAndTabla;
		            int opt4 = rockBand;
		            int opt5 = classicalBand;
		            
		            
		            
		            st = con.prepareStatement("insert into registeration(first,last,age,opt1,opt2,opt3,opt4,opt5) values(?,?,?,?,?,?,?,?)");
		            st.setString(1, first);
		            st.setString(2, last);
		            st.setString(3, age+"");
		            st.setString(4, opt1+"");
		            st.setString(5, opt2+"");
		            st.setString(6, opt3+"");
		            st.setString(7, opt4+"");
		            st.setString(8, opt5+"");
		            int i = st.executeUpdate();
		            
		            if(i != 0){
		                System.out.println("Value inserted");
		            }
		            else{
		                System.out.println("Value not inserted");
		        }
		            
		           JOptionPane.showMessageDialog(null, "You are registered successfully"); 
		        }
		        catch (ClassNotFoundException ex){
		            System.out.println(ex.getMessage());
		        } catch (SQLException e1) {
		
					e1.printStackTrace();
				}
				
			}
		});
		
		
	}
}
