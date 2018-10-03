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

public class AcntSetUp implements ActionListener{
	private Bill b;
	
	JFrame window = new JFrame();
	JButton back= new JButton("Back");
	JTextField name= new JTextField();
	JPasswordField pass= new JPasswordField();
	JButton creat= new JButton("Submit");
	
	public Bill showWindow(Bill b){
		
		this.b= b;
		
		window.setContentPane(new JLabel(new ImageIcon("Images\\key.jpg")));
		initWindow();
		
		window.setSize(800, 500);		
		window.setTitle("Billing Management");
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		return b;		
	}

	private void initWindow() {
		
		creat.addActionListener(this);
		back.addActionListener(this);
		
		JLabel newAcnt= new JLabel("Enter your data");
		JLabel nameLabel= new JLabel("Enter your name");
		JLabel passLabel= new JLabel("Enter your password");
		
		window.setLayout(null);
		
		window.add(newAcnt);
		newAcnt.setBounds(150,50,600,80);
		newAcnt.setFont(new Font(null, Font.BOLD, 60));
		newAcnt.setForeground(Color.blue);
		
		window.add(nameLabel);
		nameLabel.setBounds(140,150,300,50);
		nameLabel.setFont(new Font(null, Font.BOLD, 25));
		
		window.add(name);
		name.setBounds(420,150,200,50);
		name.setFont(new Font(null, Font.BOLD, 25));
		
		window.add(passLabel);
		passLabel.setBounds(140,200,300,50);
		passLabel.setFont(new Font(null, Font.BOLD, 25));
		
		
		window.add(pass);
		pass.setBounds(420,205,200,50);
		pass.setFont(new Font(null, Font.BOLD, 25));
		
		window.add(creat);
		creat.setBounds(350,270,150,50);
		creat.setFont(new Font(null, Font.BOLD, 25));
		
		window.add(back);
		back.setBounds(10,400,80,20);
		back.setFont(new Font(null, Font.BOLD, 12));
		
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==creat){
			String n= name.getText();
			b.setName(n);
			String p= pass.getText();
			b.setPassword(p);
			JOptionPane.showMessageDialog(null, "Your account has been creaed");
			window.dispose();
		}
		else if(e.getSource()==back){
			window.dispose();
		}
		
	}
}
