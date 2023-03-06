package com.datahive.app;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class upDetails extends JFrame implements ActionListener{

    //declaring Globally
    JButton update,exit ;
    JTextField fn,ln,a,c,st;
    JRadioButton m,f;
    ButtonGroup option;
    String username,firstname,lastname,city,state;
    String gender ="";
    int age;

 public upDetails(String username) {
     this.username = username;
   
    	 JLabel welcome = new JLabel("  WELCOME  "+ username);
    	 welcome.setBounds(150,10,600,50);
    	 welcome.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
    	 welcome.setForeground(Color.RED);
         add(welcome);  	
    	
    	
//creating Jlabel heading
        JLabel heading = new JLabel("***Update Details To Proceed***");
        heading.setBounds(40,50,600,50);
        heading.setFont(new Font("Comic Sans Ms",Font.BOLD,15));
        heading.setForeground(Color.black);
        add(heading);

//creating JLabels and JTextFields

//first name		
        JLabel fname = new JLabel("First Name");
        fname.setBounds(40,100,300,30);
        fname.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        fname.setForeground(Color.darkGray);
        add(fname);

        fn = new JTextField();
        fn.setBounds(40,130,200,30);
        fn.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        add(fn);
//last name		
        JLabel lname = new JLabel("Last Name");
        lname.setBounds(340,100,300,30);
        lname.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        fname.setForeground(Color.darkGray);
        add(lname);

        ln = new JTextField();
        ln.setBounds(340,130,200,30);
        ln.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        add(ln);
//age		
        JLabel age = new JLabel("Age");
        age.setBounds(40,180,100,30);
        age.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        age.setForeground(Color.darkGray);
        add(age);

        a = new JTextField();
        a.setBounds(40,210,100,30);
        a.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        add(a);
//Gender	with radio button	
        JLabel gender = new JLabel("Gender");
        gender.setBounds(340,180,100,30);
        gender.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        gender.setForeground(Color.darkGray);
        add(gender);

        m = new JRadioButton("Male");
        m.setBounds(340,210,70,30);
        m.setFont(new Font("Comic Sans Ms",Font.BOLD,15));
        m.setForeground(Color.black);
        add(m);

        f = new JRadioButton("Female");
        f.setBounds(420,210,100,30);
        f.setFont(new Font("Comic Sans Ms",Font.BOLD,15));
        f.setForeground(Color.black);
        add(f);
//button group to select only one button
        option = new ButtonGroup();
        option.add(m);
        option.add(f);


//City	
        JLabel city = new JLabel("City");
        city.setBounds(40,260,200,30);
        city.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        city.setForeground(Color.darkGray);
        add(city);

        c = new JTextField();
        c.setBounds(40,290,200,30);
        c.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        add(c);

//state		
        JLabel state = new JLabel("State");
        state.setBounds(340,260,100,30);
        state.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        state.setForeground(Color.darkGray);
        add(state);

        st = new JTextField();
        st.setBounds(340,290,200,30);
        st.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        add(st);

//submit Button
        update = new JButton("Update");
        update.setBounds(220,350,150,30);
        update.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        update.setForeground(Color.white);
        update.setBackground(Color.blue);
        update.addActionListener(this);
        add(update);
//exit Button
        exit = new JButton("Exit");
        exit.setBounds(240,390,100,25);
        exit.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        exit.setForeground(Color.white);
        exit.setBackground(Color.RED);
        exit.addActionListener(this);
        add(exit);





//creating frame
        setSize(650,500);
        setLocation(400, 100);
        getContentPane().setForeground(Color.white);
        setLayout(null);
        setVisible(true);


    }


	@Override
	public void actionPerformed(ActionEvent e) {
	        if(e.getSource()== update) {
	            //function to call next class
	            firstname = fn.getText();
	            lastname = ln.getText();
	            age = Integer.parseInt(a.getText());
	            if(m.isSelected()) {
	                gender += "Male";
	            }else if(f.isSelected()) {
	                gender += "Female";
	            }
	            city = c.getText();
	            state = st.getText();

	            
	            setVisible(false);
//calling database class   
	            new updateSurvey(username, firstname, lastname, age, gender, city, state);
	            
//	            System.out.println("Details: "+ " "+firstname+ " "+lastname+ " "+age+ " "+gender+ " "+city+ " "+state);

	            

	        }else if(e.getSource()==exit) {
	            System.exit(ABORT);
	            setVisible(false);
		
	}
}

	public static void main(String[] args) {
		new upDetails("");

	}

}
