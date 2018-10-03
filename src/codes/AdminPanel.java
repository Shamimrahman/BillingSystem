package codes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminPanel implements ActionListener{
	
	private int i;
	Bill[] b= new Bill[i];
	
	JFrame window= new JFrame();
	JTextField name= new JTextField();
	JPasswordField pass= new JPasswordField();
	JButton enter= new JButton("Enter");
	JButton back= new JButton("Back");
	
	public Bill[] showWindow(Bill[] b,int i){
		this.i=i;
		this.b= b;
		
		window.setContentPane(new JLabel(new ImageIcon("Images\\admin.png")));
		initWindow();		
		window.setSize(800, 500);		
		window.setTitle("Billing Management");
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		return b;
	}

	private void initWindow() {
		
		enter.addActionListener(this);
		back.addActionListener(this);
		
		JLabel admin= new JLabel("Admin");
		JLabel nameLabel= new JLabel("Admin Name");
		JLabel passLabel= new JLabel("Password");
		
		window.setLayout(null);
		
		window.add(admin);
		admin.setBounds(295,80,200,50);
		admin.setFont(new Font(null, Font.BOLD, 60));
		admin.setForeground(Color.RED);
		
		window.add(nameLabel);
		nameLabel.setBounds(200,180,150,30);
		nameLabel.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(name);
		name.setBounds(400,180,150,30);
		name.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(passLabel);
		passLabel.setBounds(200,230,150,30);
		passLabel.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(pass);
		pass.setBounds(400,230,150,30);
		pass.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(enter);
		enter.setBounds(310, 300, 150, 50);
		enter.setFont(new Font(null, Font.BOLD,35));
		
		window.add(back);
		back.setBounds(10,400,80,20);
		back.setFont(new Font(null, Font.BOLD, 12));
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==enter){
			String nameVerify= name.getText();
			String passVerify= pass.getText();
			
			if(b[1].getAdminName().equals(nameVerify) && b[1].getAdminPass().equals(passVerify)){
				AdminPanal2 ad2= new AdminPanal2();
				ad2.showWindow(b,i);
				window.dispose();				
			}
			
			else{				
				JOptionPane.showMessageDialog(null,"You have enterd wrong name or password");
				name.setText("");
				pass.setText("");
			}
		}
		
		else if(e.getSource()==back){
			window.dispose();
		}
		
	}
}
