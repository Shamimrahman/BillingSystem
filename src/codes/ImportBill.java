package codes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.net.ssl.HostnameVerifier;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ImportBill implements ActionListener{
	
	private Bill b;
	
	JFrame window= new JFrame();
	JTextField newGasBill= new JTextField();
	JTextField newElctricityBill= new JTextField();
	JTextField newWaterBill= new JTextField();
	JTextField newServiceBill= new JTextField();
	JButton importNewBill= new JButton("Set Bill");
	JButton back= new JButton("Back");
	
	
	
	public Bill showWindow(Bill b) {
		
		this.b= b;
		
		window.setContentPane(new JLabel(new ImageIcon("Images\\file4.jpg")));
		initWindow();		
		window.setSize(800, 500);		
		window.setTitle("Billing Management");
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		return b;
	}



	private void initWindow() {
		
		importNewBill.addActionListener(this);
		back.addActionListener(this);
		
		
		String n= b.getName(); 
		JLabel name= new JLabel(n);
		
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
		
		JLabel due= new JLabel("Due");
		String d= b.getDue()+"";
		JLabel dueUnit= new JLabel(d+"tk");
		
		
		window.setLayout(null);
		
		window.add(name);
		name.setBounds(150,40,400,50);
		name.setFont(new Font(null, Font.BOLD, 40));
		name.setForeground(Color.BLUE);
		
		window.add(gasBill);
		gasBill.setBounds(150,100,200,30);
		gasBill.setFont(new Font(null, Font.BOLD , 20));
		
		window.add(gasBillUnit);
		gasBillUnit.setBounds(350,100,200,30);
		gasBillUnit.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(newGasBill);
		newGasBill.setBounds(500,100,200,30);
		newGasBill.setFont(new Font(null, Font.BOLD , 20));
		
		window.add(electricityBill);
		electricityBill.setBounds(150,140,200,30);
		electricityBill.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(electricityBillUnit);
		electricityBillUnit.setBounds(350,140,200,30);
		electricityBillUnit.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(newElctricityBill);
		newElctricityBill.setBounds(500,140,200,30);
		newElctricityBill.setFont(new Font(null, Font.BOLD , 20));
		
		window.add(service);
		service.setBounds(150,180,200,30);
		service.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(serviceUnit);
		serviceUnit.setBounds(350,180,200,30);
		serviceUnit.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(newServiceBill);
		newServiceBill.setBounds(500,180,200,30);
		newServiceBill.setFont(new Font(null, Font.BOLD , 20));
		
		window.add(waterBill);
		waterBill.setBounds(150,220,200,30);
		waterBill.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(waterBillUnit);
		waterBillUnit.setBounds(350,220,200,30);
		waterBillUnit.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(newWaterBill);
		newWaterBill.setBounds(500,220,200,30);
		newWaterBill.setFont(new Font(null, Font.BOLD , 20));
		
		window.add(due);
		due.setBounds(150,280,200,30);
		due.setFont(new Font(null, Font.BOLD, 30));
		due.setForeground(Color.RED);
		
		window.add(dueUnit);
		dueUnit.setBounds(350,280,200,30);
		dueUnit.setFont(new Font(null, Font.BOLD, 30));
		dueUnit.setForeground(Color.RED);
		
		window.add(importNewBill);
		importNewBill.setBounds(520,280,160,60);
		importNewBill.setFont(new Font(null, Font.BOLD , 25));
		
		window.add(back);
		back.setBounds(10,400,80,20);
		back.setFont(new Font(null, Font.BOLD, 12));
	
		
	}



	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==importNewBill){
			String gss= newGasBill.getText();			
			double gb= Double.parseDouble(gss);
			b.setGasBill(b.getGasBill()+gb);
			
			String ebs= newElctricityBill.getText();			
			double eb= Double.parseDouble(ebs);
			b.setElecticityBill(b.getElecticityBill()+eb);
			
			String wbs= newWaterBill.getText();			
			double wb= Double.parseDouble(wbs);
			b.setWaterBill(b.getGasBill()+wb);
			
			String sbs= newServiceBill.getText();			
			double sb= Double.parseDouble(sbs);
			b.setServiceCharge(b.getServiceCharge()+sb);
			
			JOptionPane.showMessageDialog(null, "New bill has been added");
			
			window.dispose();
		}
		else if(e.getSource()==back){
			window.dispose();
		}
		
	}
}
