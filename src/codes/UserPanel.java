package codes;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UserPanel implements ActionListener{
	
	private Bill b;
	
	JFrame window = new JFrame();
	JButton pay= new JButton("Pay");
	JButton back= new JButton("Back");
	JTextField payBox= new JTextField();
	JButton setPass= new JButton("Set new password");
	JButton setName= new JButton("Set new name");
	
	public Bill showWindow(Bill b){
		
		this.b=b;
		
		window.setContentPane(new JLabel(new ImageIcon("Images\\file3.jpg")));
		initWindow();		
		window.setTitle("Billing Management");
		window.setSize(800, 500);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		return b;
	}

	private void initWindow() {
		pay.addActionListener(this);
		back.addActionListener(this);
		setName.addActionListener(this);
		setPass.addActionListener(this);
		
		JLabel name= new JLabel(b.getName());
		
		JLabel gasBill= new JLabel("Gas Bill");
		String gb= b.getGasBill()+""; 
		JLabel gasBillUnit= new JLabel(gb+"tk");
		
		
		JLabel electricityBill= new JLabel("Electricity Bill");
		String eb= b.getElecticityBill()+"";
		JLabel electricityBillUnit= new JLabel(eb+"tk");
		
		
		JLabel service= new JLabel("Service Charge");
		String sc= b.getServiceCharge()+"";
		JLabel serviceUnit= new JLabel(sc+"tk");
		
		
		JLabel waterBill= new JLabel("Water Bill");
		String wb= b.getWaterBill()+"";
		JLabel waterBillUnit= new JLabel(wb+"tk");
		
		
		JLabel total= new JLabel("Total Bill");
		String t= b.getTotalBill()+"";
		JLabel totalUnit= new JLabel(t+"tk");
		
		
		JLabel due= new JLabel("Due bill");
		String d= b.getDue()+"";
		JLabel dueUnit= new JLabel(d+"tk");
		
		
		
		
		window.setLayout(null);
		
		window.add(name);
		name.setBounds(150,40,400,50);
		name.setFont(new Font(null, Font.BOLD, 40));
		name.setForeground(Color.BLUE);
		
		window.add(gasBill);
		gasBill.setBounds(150,100,200,20);
		gasBill.setFont(new Font(null, Font.BOLD , 20));
		
		window.add(gasBillUnit);
		gasBillUnit.setBounds(350,100,200,20);
		gasBillUnit.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(electricityBill);
		electricityBill.setBounds(150,130,200,20);
		electricityBill.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(electricityBillUnit);
		electricityBillUnit.setBounds(350,130,200,20);
		electricityBillUnit.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(service);
		service.setBounds(150,160,200,20);
		service.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(serviceUnit);
		serviceUnit.setBounds(350,160,200,20);
		serviceUnit.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(waterBill);
		waterBill.setBounds(150,190,200,20);
		waterBill.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(waterBillUnit);
		waterBillUnit.setBounds(350,190,200,20);
		waterBillUnit.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(due);
		due.setBounds(150,220,200,20);
		due.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(dueUnit);
		dueUnit.setBounds(350,220,200,20);
		dueUnit.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(total);
		total.setBounds(150,270,200,20);
		total.setFont(new Font(null, Font.BOLD, 25));
		total.setForeground(Color.RED);
		
		window.add(totalUnit);
		totalUnit.setBounds(350,270,200,20);
		totalUnit.setFont(new Font(null, Font.BOLD, 25));
		totalUnit.setForeground(Color.RED);
		
		window.add(payBox);
		payBox.setBounds(150,320,200,40);
		payBox.setFont(new Font(null, Font.BOLD, 30));
		
		window.add(pay);
		pay.setBounds(351,320,200,40);
		pay.setFont(new Font(null, Font.BOLD, 30));
		
		window.add(back);
		back.setBounds(10,400,80,20);
		back.setFont(new Font(null, Font.BOLD, 12));
		
		window.add(setName);
		setName.setBounds(590,20,170,30);
		setName.setFont(new Font(null, Font.BOLD, 15));
		
		window.add(setPass);
		setPass.setBounds(590,60,170,30);
		setPass.setFont(new Font(null, Font.BOLD, 15));
		
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==pay){
			
			String s= payBox.getText();
			
			double i= Double.parseDouble(s);
			
			if(i>b.getTotalBill() || i<0){
				JOptionPane.showMessageDialog(null, "Pleasae enter equal to your bill or less then that");
				payBox.setText("");
			}
			else{
				
				b.setDue(i);
				b.setGasBill(0);
				b.setElecticityBill(0);
				b.setWaterBill(0);
				b.setServiceCharge(0);
				JOptionPane.showMessageDialog(null,"You have remain due "+b.getDue());
				window.dispose();
			}
		}
		
		else if(e.getSource()==setName){
			SetName sn= new SetName();
			b= sn.showWindow(b);
		}
		
		else if(e.getSource()==setPass){
			SetPassword sp= new SetPassword();
			b= sp.showWindow(b);
		}
		
		else if(e.getSource()==back){
			window.dispose();
		}
		
		
	}
}
