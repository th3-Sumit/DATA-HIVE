package com.datahive.app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Details extends JFrame implements ActionListener{

    //declaring Globally
    JButton submit,exit ;
    JTextField fn,ln,a,c,st;
    JRadioButton m,f;
    ButtonGroup option;
    String username,firstname,lastname,city,state;
    String gender = "";
    int age;

    public Details(String username) {
    	this.username = username;
    	
    	ImageIcon common = new ImageIcon(ClassLoader.getSystemResource("icons/common.jpg"));
        Image i1 = common.getImage().getScaledInstance(650, 500, Image.SCALE_DEFAULT);
    	ImageIcon i3 = new ImageIcon(i1);
        JLabel img =  new JLabel(i3);
    	img.setBounds(0,0,650,500);
        add(img);
    	
    	 JLabel welcome = new JLabel("  WELCOME  "+ username);
    	 welcome.setBounds(150,10,600,50);
    	 welcome.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
    	 welcome.setForeground(Color.RED);
         img.add(welcome);  	
    	
    	
//creating Jlabel heading
        JLabel heading = new JLabel("***Please Fill Details To Proceed***");
        heading.setBounds(40,50,600,50);
        heading.setFont(new Font("Comic Sans Ms",Font.BOLD,15));
        heading.setForeground(Color.black);
        img.add(heading);

//creating JLabels and JTextFields

//first name		
        JLabel fname = new JLabel("First Name");
        fname.setBounds(40,100,300,30);
        fname.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        fname.setForeground(Color.darkGray);
        img.add(fname);

        fn = new JTextField();
        fn.setBounds(40,130,200,30);
        fn.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        img.add(fn);
//last name		
        JLabel lname = new JLabel("Last Name");
        lname.setBounds(340,100,300,30);
        lname.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        fname.setForeground(Color.darkGray);
        img.add(lname);

        ln = new JTextField();
        ln.setBounds(340,130,200,30);
        ln.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        img.add(ln);
//age		
        JLabel age = new JLabel("Age");
        age.setBounds(40,180,100,30);
        age.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        age.setForeground(Color.darkGray);
        img.add(age);

        a = new JTextField();
        a.setBounds(40,210,100,30);
        a.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        img.add(a);
//Gender	with radio button	
        JLabel gender = new JLabel("Gender");
        gender.setBounds(340,180,100,30);
        gender.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        gender.setForeground(Color.darkGray);
        img.add(gender);

        m = new JRadioButton("Male");
        m.setBounds(340,210,70,30);
        m.setFont(new Font("Comic Sans Ms",Font.BOLD,15));
        m.setForeground(Color.black);
        m.setFocusable(false);
        img.add(m);

        f = new JRadioButton("Female");
        f.setBounds(420,210,100,30);
        f.setFont(new Font("Comic Sans Ms",Font.BOLD,15));
        f.setForeground(Color.black);       
        f.setFocusable(false);
        img.add(f);
        
//button group to select only one button
        option = new ButtonGroup();
        option.add(m);
        option.add(f);


//City	
        JLabel city = new JLabel("City");
        city.setBounds(40,260,200,30);
        city.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        city.setForeground(Color.darkGray);
        img.add(city);

        c = new JTextField();
        c.setBounds(40,290,200,30);
        c.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        img.add(c);

//state		
        JLabel state = new JLabel("State");
        state.setBounds(340,260,100,30);
        state.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        state.setForeground(Color.darkGray);
        img.add(state);

        st = new JTextField();
        st.setBounds(340,290,200,30);
        st.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        img.add(st);

//submit Button
        submit = new JButton("Submit");
        submit.setBounds(220,350,150,30);
        submit.setFont(new Font("Comic Sans Ms",Font.BOLD,25));
        submit.setForeground(Color.white);
        submit.setBackground(Color.blue);
        submit.addActionListener(this);
        img.add(submit);
//exit Button
        exit = new JButton("Exit");
        exit.setBounds(240,390,100,25);
        exit.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
        exit.setForeground(Color.white);
        exit.setBackground(Color.RED);
        exit.addActionListener(this);
        img.add(exit);





//creating frame
        setSize(650,500);
        setLocation(400, 100);
        setTitle("DATA-HIVE-SERVEY");
        getContentPane().setForeground(Color.white);
        setLayout(null);
        setVisible(true);


    }



	@Override
	public void actionPerformed(ActionEvent e) {
	        if(e.getSource()== submit) {
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

//calling database class   
	            new Jdbc(username,firstname, lastname, age, gender, city, state); 
	            
//	            System.out.println("Details: "+ " "+firstname+ " "+lastname+ " "+age+ " "+gender+ " "+city+ " "+state);

	            setVisible(false);

	        }else if(e.getSource()==exit) {
	            System.exit(ABORT);
	            setVisible(false);
		
	}

}
	
    public static void main(String args[]) {
        new Details("");
    }
}