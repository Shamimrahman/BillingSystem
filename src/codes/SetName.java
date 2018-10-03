package codes;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SetName implements ActionListener{
	
	private Bill b;
	
	JFrame window= new JFrame();
	JTextField name= new JTextField();
	JButton enter= new JButton("Enter");
	
	
	public Bill showWindow(Bill b) {
		
		this.b=b;
		
		initWindow();
		
		window.setSize(445, 150);
		window.setTitle("Set Name");
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		return b;
	}


	private void initWindow() {
		
		enter.addActionListener(this);
		
		JLabel nameLabel= new JLabel("Set new name");
		
		window.setLayout(null);
		
		window.add(nameLabel);
		nameLabel.setBounds(10,10,250,20);
		nameLabel.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(name);
		name.setBounds(200,10,200,30);
		name.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(enter);
		enter.setBounds(165,50,90,40);
		enter.setFont(new Font(null, Font.BOLD, 20));
		
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==enter){
			b.setName(name.getText());
			JOptionPane.showMessageDialog(null, "\t\tYour name has been changed \nPlease log out and log in to see the changed name");
			window.dispose();
		}
		
	}
}
