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

public class NewAcnt implements ActionListener{
	private int i;
	Bill[] b= new Bill[i];
	
	JFrame window = new JFrame();
	JTextField flat= new JTextField();
	JPasswordField pass= new JPasswordField();
	JButton creat= new JButton("Creat");
	JButton back= new JButton("Back");
	
	
	public Bill[] showWindow(Bill[] b,int i){
		this.i=i;
		this.b= b;
		
		window.setContentPane(new JLabel(new ImageIcon("Images\\user.jpg")));
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
		
		JLabel newAcnt= new JLabel("Create new account");
		JLabel flatLabel= new JLabel("Enter your flat number");
		JLabel passLabel= new JLabel("Enter your password");
		
		window.setLayout(null);
		
		window.add(newAcnt);
		newAcnt.setBounds(110,50,600,50);
		newAcnt.setFont(new Font(null, Font.BOLD, 60));
		newAcnt.setForeground(Color.blue);
		
		window.add(flatLabel);
		flatLabel.setBounds(140,150,300,50);
		flatLabel.setFont(new Font(null, Font.BOLD, 25));
		
		window.add(flat);
		flat.setBounds(420,150,200,50);
		flat.setFont(new Font(null, Font.BOLD, 25));
		
		passLabel.setBounds(140,200,300,50);
		passLabel.setFont(new Font(null, Font.BOLD, 25));
		
		
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
		if(e.getSource()==creat ){
			
			boolean flatCheck= false;
			for (int i = 0; i < b.length; i++) {
				if(b[i].getFlatNo().equals(flat.getText())){
										
					if(b[i].getName().equals("Admin")){
						AcntSetUp asup= new AcntSetUp();
						b[i]=asup.showWindow(b[i]);
						window.dispose();
					}
					
					else {
						JOptionPane.showMessageDialog(null, "A person already signed on this flat");
						flat.setText("");
					}
					flatCheck= true;
					
					break;
				}
			}
			
			if(flatCheck==false){
				JOptionPane.showMessageDialog(null, "Flat No not found");
				flat.setText("");
				pass.setText("");
			}
			
		}
		
		else if(e.getSource()==back){
			window.dispose();
		}
		
	}
}
