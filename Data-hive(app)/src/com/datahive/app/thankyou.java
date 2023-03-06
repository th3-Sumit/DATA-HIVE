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

public class thankyou extends JFrame implements ActionListener{
	       JButton exit;
	
          String username;
          
          
	      thankyou(String username){
	      this.username = username;
	      
//adding image
	      ImageIcon thanks = new ImageIcon(ClassLoader.getSystemResource("icons/thankyou.jpg"));
          Image i1 = thanks.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
          ImageIcon i3 = new ImageIcon(i1);
	      JLabel img =  new JLabel(i3);
	      img.setBounds(0,0,600,500);
	      add(img);
	      
	      exit = new JButton("Exit");
	      exit.setBounds(220, 350, 100, 50);
	      exit.setFont(new Font("Comic Sans Ms", Font.BOLD, 20));
	      exit.setForeground(Color.white);
	      exit.setBackground(Color.red);
	      exit.addActionListener(this);
	      img.add(exit);

	    	  
	    	  
//creating frame
	    	  setSize(600,500);
	    	  setLocation(450, 100);
	    	  setLayout(null);
	    	  getContentPane().setForeground(Color.white);
              setVisible(true);	    	     
	    	  
	      }
	
	public static void main(String[] args) {
		new thankyou("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit) {
			setVisible(false);
			System.exit(ABORT);
		}
		
	}

}
