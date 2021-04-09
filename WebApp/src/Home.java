import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Home implements ActionListener{
	
	
	
	JFrame jf = new JFrame();
    JTextField text = new JTextField();
    JTextArea area = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();

	@Override
	public void actionPerformed(ActionEvent e) {
		 	// TODO Auto-generated method stub
		if(e.getSource()==buttonA) {
	          Quiz quiz = new Quiz("Easy");
	}
		if(e.getSource()==buttonB) {
	          Quiz quiz = new Quiz("Middle");
	}
		if(e.getSource()==buttonC) {
	          Quiz quiz = new Quiz("Hard");
	}
		}
	public Home() {
		    	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.setSize(650,650);
				jf.getContentPane().setBackground(new Color(50,50,50));
				jf.setLayout(null);
				jf.setResizable(false);
				
				text.setBounds(0,0,650,50);
				text.setBackground(new Color(25,25,25));
				text.setForeground(new Color(25,255,0));
				text.setFont(new Font("Ink Free", Font.BOLD,30));
				text.setBorder(BorderFactory.createBevelBorder(1));
				text.setHorizontalAlignment(JTextField.CENTER);
				text.setEditable(false);
				
				area.setBounds(0,50,650,50);
				area.setLineWrap(true);
				area.setWrapStyleWord(true);
				area.setBackground(new Color(25,25,25));
				area.setForeground(new Color(25,255,0));
				area.setFont(new Font("MV Boli", Font.BOLD,25));
				area.setBorder(BorderFactory.createBevelBorder(1));
				area.setEditable(false);
				area.setText("Select Level");
				
				buttonA.setBounds(300,100,150,100);
				buttonA.setFont(new Font("MV Boli", Font.BOLD,20));
				buttonA.setFocusable(false);
				buttonA.addActionListener(this);
				buttonA.setText("Easy");
				
				buttonB.setBounds(300,200,150,100);
				buttonB.setFont(new Font("MV Boli", Font.BOLD,20));
				buttonB.setFocusable(false);
				buttonB.addActionListener(this);
				buttonB.setText("Middle");

				
				buttonC.setBounds(300,300,150,100);
				buttonC.setFont(new Font("MV Boli", Font.BOLD,20));
				buttonC.setFocusable(false);
				buttonC.addActionListener(this);
				buttonC.setText("Hard");
				
		
				jf.add(buttonA);
				jf.add(buttonB);
				jf.add(buttonC);
				jf.add(area);
				jf.add(text);
				jf.setVisible(true);
			
	}

}
