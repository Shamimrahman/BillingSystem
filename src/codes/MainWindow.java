package codes;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainWindow implements ActionListener{
	
	private int i;
	
	Bill[] b= new Bill[i];
	
	JFrame window= new JFrame();
	JButton login = new JButton("Log In");
	JButton admin = new JButton("Admin Panel");
	JButton newAcnt= new JButton("Creat Accout");
	
	public void showWindow(Bill[] b, int i){
		
		this.i=i;
		this.b= b;
		
		window.setContentPane(new JLabel(new ImageIcon("Images\\handshake.jpg")));
		initWindow();		
		window.setSize(800, 500);		
		window.setTitle("Billing Management");
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	private void initWindow() {
		
		login.addActionListener(this);
		admin.addActionListener(this);
		newAcnt.addActionListener(this);
		
		JLabel wlcm= new JLabel("Welcome");
		
		JLabel quds= new JLabel("Pay your bills by this app");
		
		window.setLayout(null);
		
		
		window.add(wlcm);
		wlcm.setBounds(270,10,300,60);
		wlcm.setFont(new Font(null, Font.BOLD, 60));
		wlcm.setForeground(Color.DARK_GRAY);
		
		window.add(quds);
		quds.setBounds(300,0,800,200);
		quds.setFont(new Font(null, Font.BOLD, 17));
		
		window.add(login);
		login.setFont(new Font(null, Font.BOLD, 50));
		login.setForeground(Color.DARK_GRAY);
		
		login.setText("Login");
		login.setBounds(305,180,185,70);		
		
		window.add(admin);
		admin.setBounds(10,400,150,30);
		admin.setFont(new Font(null, Font.BOLD, 12));
		
		window.add(newAcnt);
		newAcnt.setBounds(620,400,150,30);
		newAcnt.setFont(new Font(null, Font.BOLD, 12));		
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login){						
			LoginWindow lgWindow = new LoginWindow();
			b=lgWindow.showWindow(b,i);
		}
		
		else if(e.getSource()==admin){
			AdminPanel ap= new AdminPanel();
			ap.showWindow(b,i);
		}
		
		else if(e.getSource()==newAcnt){
			NewAcnt na= new NewAcnt();
			na.showWindow(b,i);
		}
		
	}
	
	
	
	
}
