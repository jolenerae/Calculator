package calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

	JFrame jf;
	JTextField tf;
	JButton[] numbers = new JButton[10];
	JButton[] functions = new JButton[13];
	JButton addButton, subButton, multButton, divButton, sqrButton, expButton, sqrootButton;
	JButton decButton, eqlButton, clrButton, delButton, negButton, invButton;
	JPanel jp;
	
	Font myFont = new Font(Font.SANS_SERIF, Font.BOLD, 25);
	Font deleteFont = new Font(Font.SANS_SERIF, Font.BOLD, 20);
	Font expFont = new Font(Font.SANS_SERIF, Font.BOLD, 15);
	Font smallFont = new Font(Font.SANS_SERIF, Font.BOLD, 10);

	
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	Calculator() {
		
		jf = new JFrame("Calculator");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(420, 550);
		jf.setLayout(null);
		
		tf = new JTextField();
		tf.setBounds(50, 25, 300, 50);
		tf.setFont(myFont); 
		tf.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		multButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		eqlButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		negButton = new JButton("(-)");
		sqrButton = new JButton("x^2");
		invButton = new JButton("1/x");
		expButton = new JButton("x^y");
		sqrootButton = new JButton("sqrt(x)");
		
		functions[0] = addButton;
		functions[1] = subButton;
		functions[2] = multButton;
		functions[3] = divButton;
		functions[4] = decButton;
		functions[5] = eqlButton;
		functions[6] = delButton;
		functions[7] = clrButton;
		functions[8] = negButton;
		functions[9] = sqrButton;
		functions[10] = invButton;
		functions[11] = expButton;
		functions[12] = sqrootButton;
		
		for (int i = 0; i < 13; i++) {
			functions[i].addActionListener(this);
			functions[i].setFont(myFont);
			functions[i].setFocusable(false);
		}		

		for (int i = 0; i < 10; i++) {
			numbers[i] = new JButton(String.valueOf(i));
			numbers[i].addActionListener(this);
			numbers[i].setFont(myFont);
			numbers[i].setFocusable(false);
		}
		
		negButton.setBounds(50, 430, 100, 50);
		delButton.setBounds(150, 430, 100, 50);
		delButton.setFont(deleteFont);
		clrButton.setBounds(250, 430, 100, 50);
		sqrButton.setFont(expFont);
		invButton.setFont(expFont);
		expButton.setFont(expFont);
		sqrootButton.setFont(smallFont);

		jp = new JPanel();
		jp.setBounds(50, 100, 300, 300);
		jp.setLayout(new GridLayout(5, 4, 10, 10));
		jp.setBackground(Color.LIGHT_GRAY);
		
		jp.add(sqrButton);
		jp.add(sqrootButton);
		jp.add(expButton);
		jp.add(invButton);
		jp.add(numbers[1]);
		jp.add(numbers[2]);
		jp.add(numbers[3]);
		jp.add(addButton);
		jp.add(numbers[4]);
		jp.add(numbers[5]);
		jp.add(numbers[6]);
		jp.add(subButton);
		jp.add(numbers[7]);
		jp.add(numbers[8]);
		jp.add(numbers[9]);
		jp.add(multButton);
		jp.add(decButton);
		jp.add(numbers[0]);
		jp.add(eqlButton);
		jp.add(divButton);
		
		jf.add(jp);
		jf.add(delButton);
		jf.add(clrButton);
		jf.add(negButton);
		jf.add(tf);
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < 10; i++) {
			if(e.getSource() == numbers[i]) {
				tf.setText(tf.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == decButton) {
			tf.setText(tf.getText().concat(String.valueOf(".")));
		}
		if (e.getSource() == addButton) {
			num1 = Double.parseDouble(tf.getText());
			operator = '+';
			tf.setText(" ");
		}
		if (e.getSource() == subButton) {
			num1 = Double.parseDouble(tf.getText());
			operator = '-';
			tf.setText(" ");
		}
		if (e.getSource() == multButton) {
			num1 = Double.parseDouble(tf.getText());
			operator = '*';
			tf.setText(" ");
		}
		if (e.getSource() == divButton) {
			num1 = Double.parseDouble(tf.getText());
			operator = '/';
			tf.setText(" ");
		}
		if (e.getSource() == expButton) {
			num1 = Double.parseDouble(tf.getText());
			operator = '^';
			tf.setText(" ");
		}
		if (e.getSource() == eqlButton) {
			num2 = Double.parseDouble(tf.getText());
			switch(operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			case '^':
				result = num1;
				for (int i = 2; i <= num2; i++) {
					result *= num1;
				}
				break;
			default:
				break;
			}
			tf.setText(Double.toString(result));
			num1 = result;
		}
		if (e.getSource() == clrButton) {
			tf.setText("");
		}
		if (e.getSource() == delButton) {
			String string = tf.getText();
			tf.setText("");
			for (int i = 0; i < string.length() - 1; i++) {
				tf.setText(tf.getText() + string.charAt(i));
			}
		}
		if (e.getSource() == negButton) {
			double temp = Double.parseDouble(tf.getText());
			temp *= -1;
			tf.setText(String.valueOf(temp));
		}
		if (e.getSource() == sqrButton) {
			num1 = Double.parseDouble(tf.getText());
			result = num1 * num1;
			tf.setText(Double.toString(result));
		}
		if (e.getSource() == invButton) {
			num1 = Double.parseDouble(tf.getText());
			result = 1 / num1;
			tf.setText(Double.toString(result));
		}
		if (e.getSource() == sqrootButton) {
			num1 = Double.parseDouble(tf.getText());
			result = Math.sqrt(num1);
			tf.setText(Double.toString(result));
		}
	}

}
