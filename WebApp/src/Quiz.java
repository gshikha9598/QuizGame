import java.awt.*;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Quiz implements ActionListener{
	
	SurveyModel surveymodel;
	//String s = surveymodel.getQuestion();
	
	
	String [] questions =  {
			
			                "Where is Taj Mahal?",
			                "who is Prime Minister of India?",
			                "What was Java originally called?",
			                "Which year was Java created?"
			
	                       };
	
	String [][] options = {
			                 {"Agra","Delhi","Lucknow","Hyderabad"},
			                 {"Rahul Gandhi","Narendra Modi","Rajnath Singh","Amit Shah"},
			                 {"Apple","Microsoft","Oak","Android"},
			                 {"1989","1956","1972","1996"}

			                 };
	
	char[] answers = {
			           'A',
			           'B',
			           'C',
			           'D'
	                 };
	
    char guess;
    char answer;
    int index;
    int correct_guess = 0;
    int total_question = questions.length;	
    int result;
    int seconds = 30;
    
    JFrame jf = new JFrame();
    JTextField text = new JTextField();
    JTextArea area = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();
    

	Timer timer = new Timer(1000,new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
			
			 }
		
	});


    public Quiz(String a) {
    	String type = a;
    	System.out.println(type);
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
		
		buttonA.setBounds(0,100,100,100);
		buttonA.setFont(new Font("MV Boli", Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		buttonB.setBounds(0,200,100,100);
		buttonB.setFont(new Font("MV Boli", Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");

		
		buttonC.setBounds(0,300,100,100);
		buttonC.setFont(new Font("MV Boli", Font.BOLD,35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");

		
		buttonD.setBounds(0,400,100,100);
		buttonD.setFont(new Font("MV Boli", Font.BOLD,35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		answer_labelA.setBounds(125,100,500,100);
		answer_labelA.setBackground(new Color(50,50,50));
		answer_labelA.setForeground(new Color(25,255,0));
		answer_labelA.setFont(new Font("MV Boli", Font.PLAIN,35));
		
		answer_labelB.setBounds(125,200,500,100);
		answer_labelB.setBackground(new Color(50,50,50));
		answer_labelB.setForeground(new Color(25,255,0));
		answer_labelB.setFont(new Font("MV Boli", Font.PLAIN,35));
		
		answer_labelC.setBounds(125,300,500,100);
		answer_labelC.setBackground(new Color(50,50,50));
		answer_labelC.setForeground(new Color(25,255,0));
		answer_labelC.setFont(new Font("MV Boli", Font.PLAIN,35));
		
		answer_labelD.setBounds(125,400,500,100);
		answer_labelD.setBackground(new Color(50,50,50));
		answer_labelD.setForeground(new Color(25,255,0));
		answer_labelD.setFont(new Font("MV Boli", Font.PLAIN,35));
		
		seconds_left.setBounds(535,510,100,100);
		seconds_left.setBackground(new Color(25,25,25));
		seconds_left.setForeground(new Color(255,0,0));
		seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		
		time_label.setBounds(535,475,100,25);
		time_label.setBackground(new Color(25,25,25));
		time_label.setForeground(new Color(255,0,0));
		time_label.setFont(new Font("MV Boli",Font.BOLD,16));
		time_label.setHorizontalAlignment(JTextField.CENTER);
		time_label.setText(String.valueOf("timer >:D"));
		
		number_right.setBounds(225,225,200,100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(255,0,0));
		number_right.setFont(new Font("MV Boli",Font.BOLD,50));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setEditable(false);
		
		percentage.setBounds(225,325,200,100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(255,0,0));
		percentage.setFont(new Font("MV Boli",Font.BOLD,50));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setEditable(false);
		
		/*
		 * jf.add(percentage); jf.add(number_right);
		 */
        jf.add(seconds_left);
        jf.add(time_label);
		jf.add(answer_labelA);
		jf.add(answer_labelB);
        jf.add(answer_labelC);
		jf.add(answer_labelD);
		jf.add(buttonA);
		jf.add(buttonB);
		jf.add(buttonC);
		jf.add(buttonD);
		jf.add(area);
		jf.add(text);
		jf.setVisible(true);
		
		nextQuestion();
	
	}
	
	public void nextQuestion() {
		
		if(index>=total_question) {
			results();
		}
		else {
			text.setText("Question "+(index+1));
			area.setText(questions[index]);
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
			timer.start();

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(e.getSource()==buttonA) {
			answer = 'A';
			if(answer == answers[index]) {
				correct_guess++; 
			}
		}
		if(e.getSource()==buttonB) {
			answer = 'B';
			if(answer == answers[index]) {
				correct_guess++; 
			}
		}
		if(e.getSource()==buttonC) {
			answer = 'C';
			if(answer == answers[index]) {
				correct_guess++; 
			}
		}
		if(e.getSource()==buttonD) {
			answer = 'D';
			if(answer == answers[index]) {
				correct_guess++; 
			}
		}
		
		displayAnswer();
	}
	
	public void displayAnswer() {
		
		timer.stop();
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(answers[index] !='A')
			answer_labelA.setForeground(new Color(255,0,0));
        if(answers[index] !='B')
			answer_labelB.setForeground(new Color(255,0,0));
		if(answers[index] !='C')
			answer_labelC.setForeground(new Color(255,0,0));
		if(answers[index] !='D')
			answer_labelD.setForeground(new Color(255,0,0));
		
		Timer pause = new Timer(2000,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				answer_labelA.setForeground(new Color(25,255,0));
				answer_labelB.setForeground(new Color(25,255,0));
				answer_labelC.setForeground(new Color(25,255,0));
				answer_labelD.setForeground(new Color(25,255,0));
				
				answer = ' ';
				seconds = 30;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				
				index++;
				nextQuestion();		
             }
			
		});
		pause.setRepeats(false);
		pause.start();
		
	}
	
	public void results() {
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		result = (int)((correct_guess/(double)total_question)*100); 
		
		text.setText("RESULTS!");
		area.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
		number_right.setText("("+correct_guess+"/"+total_question+")");
		percentage.setText(result+"%");
		
		jf.add(number_right);
		jf.add(percentage);
		
		
	}
	
}
