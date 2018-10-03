package codes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowStateListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow implements ActionListener{
	private int i;
	Bill[] b= new Bill[i];
	
	JFrame window= new JFrame();
	JButton submit= new JButton("Submit");
	JButton back= new JButton("Back");
	JTextField flat= new JTextField();
	JPasswordField pas= new JPasswordField();
	
	
	public Bill[]  showWindow(Bill[] b,int i){
		this.i=i;
		this.b=b;
		
		window.setContentPane(new JLabel(new ImageIcon("Images\\lock2.jpg")));
		initWindow();		
		window.setTitle("Billing Management");
		window.setSize(800, 500);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);		
		return b;		
	}
	
	public void initWindow(){
		
		back.addActionListener(this);
		submit.addActionListener(this);
		
		JLabel quds= new JLabel("Enter Your Requirment Data");
		JLabel flatLabel= new JLabel("Flat Number");
		JLabel pasLabel= new JLabel("Password");
		
		window.setLayout(null);
		
		window.add(quds);
		quds.setBounds(130,50,600,50);
		quds.setFont(new Font(null, Font.BOLD, 40));
		quds.setForeground(Color.DARK_GRAY);
		
		window.add(flatLabel);
		flatLabel.setBounds(160,120,150,50);
		flatLabel.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(flat);
		flat.setBounds(300,125,300,40);
		flat.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(pasLabel);
		pasLabel.setBounds(160,190,300,50);
		pasLabel.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(pas);
		pas.setBounds(300,195,300,40);
		pas.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(submit);
		submit.setBounds(300,280,200,50);
		submit.setFont(new Font(null, Font.BOLD, 30));
		
		window.add(back);
		back.setBounds(10,400,80,20);
		back.setFont(new Font(null, Font.BOLD, 12));
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==back){
			window.dispose();
		}
		
		else if(e.getSource()==submit){
			String flatCheck= flat.getText();
			String pasCheck= pas.getText();
			
			boolean check= true;
			for (int i = 0; i < b.length; i++) {
				if(b[i].getFlatNo().equals(flatCheck) && b[i].getPassword().equals(pasCheck)){
					UserPanel up= new UserPanel();
					b[i]=up.showWindow(b[i]);
					window.dispose();
					check=false;
					break;
				}
				
			}
			
			if(check==true){				
				flat.setText("");
				pas.setText("");
				JOptionPane.showMessageDialog(null, "You have enterd wrong password or Flat no");
									
			}
			
			
			
		}
	}
	
	public void setBillarray(Bill b1){
		for (int i = 0; i < this.b.length; i++) {
			if(b[i].getName().equals(b1.getName())){
				b[i]=b1;
				break;
			}
		}
		MainWindow mw= new MainWindow();
		mw.showWindow(b,i);
	}
}
