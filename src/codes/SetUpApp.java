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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SetUpApp implements ActionListener{
	JFrame window= new JFrame();
	JTextField flatCount= new JTextField();
	JButton enter= new JButton("Enter");
	
	
	public void showWindow(){
		
		
		
		window.setContentPane(new JLabel(new ImageIcon("Images\\handshake.jpg")));
		initWindow();		
		window.setSize(800, 500);		
		window.setTitle("Billing Management");
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}


	private void initWindow() {
		
		enter.addActionListener(this);
		
		
		JLabel setUp= new JLabel("Set up your app");
		
		JLabel flatCountLabel= new JLabel("Enter how many flat you have");
		
		window.setLayout(null);
		
		
		window.add(setUp);
		setUp.setBounds(180,20,500,80);
		setUp.setFont(new Font(null, Font.BOLD, 60));
		setUp.setForeground(Color.DARK_GRAY);
		
		
		
		window.add(flatCountLabel);
		flatCountLabel.setBounds(200,120,700,50);
		flatCountLabel.setFont(new Font(null, Font.BOLD, 30));
		flatCountLabel.setForeground(Color.DARK_GRAY);
		
		
		window.add(flatCount);
		flatCount.setBounds(350,200,100,50);
		flatCount.setFont(new Font(null, Font.BOLD, 50));
		flatCount.setForeground(Color.DARK_GRAY);
		
		window.add(enter);
		enter.setBounds(300,300,200,50);
		enter.setFont(new Font(null, Font.BOLD, 50));
		enter.setForeground(Color.DARK_GRAY);
		
		
	}


	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==enter){
			if(flatCount.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Please insert a number");
			}
			else{
				String no= flatCount.getText();
				int i= Integer.parseInt(no);
				if(i==0 || i<0){
					JOptionPane.showMessageDialog(null, "Flat number must be positive and greater then zero");
				}
				else{
					Bill[] b= new Bill[i];
					for (int j = 0; j < b.length; j++) {
						String p= "A"+(j+1)+"";
						b[j]= new Bill("Admin",p,"Admin",0,0,0,0);
					}
					
					MainWindow mw= new MainWindow();
					mw.showWindow(b, i);
					window.dispose();
				}
			}
		}
		
	}



}
