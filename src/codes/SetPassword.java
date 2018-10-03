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

public class SetPassword implements ActionListener{
	
	private Bill b;
	
	JFrame window= new JFrame();
	JPasswordField pass= new JPasswordField();
	JButton enter= new JButton("Enter");
	
	
	public Bill showWindow(Bill b) {
		
		this.b=b;
		
		initWindow();
		
		window.setSize(445, 150);
		window.setTitle("Set Password");
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		return b;
	}
	
	
	private void initWindow() {
		
		enter.addActionListener(this);
		
		JLabel passLabel= new JLabel("Set new password");
		
		window.setLayout(null);
		
		window.add(passLabel);
		passLabel.setBounds(10,10,250,20);
		passLabel.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(pass);
		pass.setBounds(200,10,200,30);
		pass.setFont(new Font(null, Font.BOLD, 20));
		
		window.add(enter);
		enter.setBounds(165,50,90,40);
		enter.setFont(new Font(null, Font.BOLD, 20));
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==enter){
			b.setPassword(pass.getText());
			JOptionPane.showMessageDialog(null, "Your password has been changed");
			window.dispose();
		}
		
	}

}
