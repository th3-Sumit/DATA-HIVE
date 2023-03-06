package com.datahive.app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	
//defining globally to access in other methods
	JButton probtn,exit,delbtn,upbtn;
	JTextField uname;
	String username;
	
	
	Login(){
		
		
//code for adding image before Welcome heading
		ImageIcon common = new ImageIcon(ClassLoader.getSystemResource("icons/common.jpg"));
        Image i1 = common.getImage().getScaledInstance(650, 500, Image.SCALE_DEFAULT);
    	ImageIcon i3 = new ImageIcon(i1);
        JLabel img =  new JLabel(i3);
    	img.setBounds(0,0,650,500);
        add(img);
		
		
//creating Jlabel
		JLabel welcome = new JLabel("Data-Hive A Quick Survey App");
		welcome.setBounds(100,130,400,50);
		welcome.setFont(new Font("Comic Sans Ms",Font.BOLD,25));
		welcome.setForeground(Color.blue);
		img.add(welcome);
		
//creating Label user for username	
		JLabel user = new JLabel("Enter Username");
		user.setBounds(200,200,300,20);
		user.setFont(new Font("Comic Sans Ms",Font.BOLD,20));
		user.setForeground(Color.BLACK);
		img.add(user);	
		
//creating text-field for user name
		uname = new JTextField();
		uname.setBounds(140, 230, 280, 30);
		uname.setFont(new Font("Comic Sans Ms",Font.BOLD,15));;
		img.add(uname);
		
//adding Fill Survey  or proceed button
		probtn = new JButton("Fill Survey");
		probtn.setBounds(200, 270, 150, 25);
		probtn.setFont(new Font("Comic Sans Ms",Font.BOLD,15));
		probtn.setForeground(Color.white);
		probtn.setBackground(Color.blue);
		probtn.addActionListener(this);
		img.add(probtn);
		
//adding update  or proceed button
		upbtn = new JButton("Update Survey");
		upbtn.setBounds(200, 310, 150, 25);
		upbtn.setFont(new Font("Comic Sans Ms",Font.BOLD,15));
		upbtn.setForeground(Color.white);
		upbtn.setBackground(Color.blue);
		upbtn.addActionListener(this);
		img.add(upbtn);

//adding Delete Survey button
		delbtn = new JButton("Delete Survey");
		delbtn.setBounds(200, 360, 150, 25);
		delbtn.setFont(new Font("Comic Sans Ms",Font.BOLD,15));
		delbtn.setForeground(Color.white);
		delbtn.setBackground(Color.red);
		delbtn.addActionListener(this);
		img.add(delbtn);
		
		
//adding exit button		
		exit = new JButton("Exit");
		exit.setBounds(240, 400, 60, 25);
		exit.setFont(new Font("Comic Sans Ms",Font.BOLD,10));
		exit.setForeground(Color.white);
		exit.setBackground(Color.RED);
		exit.addActionListener(this);
		img.add(exit);
		
		
//creating frame
		setLocation(450,100);
		setSize(600,500);
		setTitle("DATA-HIVE");
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setVisible(true);
		
	}
	
	
	public static void main(String args[]) {
		new Login();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == probtn) {
			username = uname.getText();
			setVisible(false);
			new Details(username);
		}else if(e.getSource()==upbtn) {
			username = uname.getText();
			setVisible(false);
			new upDetails(username);
		}
		else if(e.getSource() == delbtn) {
		   username  = uname.getText();
			new DelSurvey(username);
			setVisible(false);
		}
		else if(e.getSource()== exit){
			setVisible(false);
			System.exit(ABORT);
		}
	}

}
