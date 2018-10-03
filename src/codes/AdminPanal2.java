package codes;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AdminPanal2 implements ActionListener{
	
	private int i;
	Bill[] b= new Bill[i];
	
	JFrame window= new JFrame();
	JTextField flat= new JTextField();
	JButton enter= new JButton("Enter");
	JButton back= new JButton("Back");
	
	public Bill[] showWindow(Bill[] b, int i){
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
		
		JLabel nameLabel= new JLabel("Enter Flat No.");
		
		window.setLayout(null);
		
		window.add(nameLabel);
		nameLabel.setBounds(100,150,250,50);
		nameLabel.setFont(new Font(null, Font.BOLD, 30));
		
		window.add(flat);
		flat.setBounds(351,150,250,50);
		flat.setFont(new Font(null, Font.BOLD, 30));
		
		window.add(enter);
		enter.setBounds(310,250,150,60);
		enter.setFont(new Font(null, Font.BOLD, 40));
		
		window.add(back);
		back.setBounds(10,400,80,20);
		back.setFont(new Font(null, Font.BOLD, 12));
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==enter){			
			String flatVerify= flat.getText();
			boolean flatVerify2= true;
			
			for (int i = 0; i < b.length; i++) {
				if(b[i].getFlatNo().equals(flatVerify)){
					ImportBill ib= new ImportBill();
					b[i]=ib.showWindow(b[i]);
					flatVerify2= false;
					break;
				}
			}
			
			if(flatVerify2==true){
				JOptionPane.showMessageDialog(null,"You have enterd wrong flat No.");
			}
			flat.setText("");
		}
		
		else if(e.getSource()==back){
			window.dispose();
		}
	}
}
