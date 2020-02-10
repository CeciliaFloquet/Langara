import java.awt.event.*;
import java.awt.*;  
import javax.swing.*;
import java.util.*;
import java.lang. *;
	/**
     * create CalculateFrame class that extends 
	 JFrame
     */
public class CalculateFrame extends JFrame{
	
	private TextField input; 
	private int result = 0;
	private int firstOperand;
	private int	secondOperand ;
	private String operator;  
	private JLabel questionLabel;
	private JLabel answer;
	private JButton button;
	private JPanel panel;
	private JPanel panel2;
	private String[] values;
	/**
	 * Constructs a CalculateFrame without parameter
	 */
	public CalculateFrame() {
		setLayout(new FlowLayout());
		createTextField();
		createButton();
		createPanel();
		setTitle("Calculator");  
		setSize(550, 350);  
		setVisible(true);  
	}
    /**
     * create textfield
     */
    private void createTextField(){
		questionLabel = new JLabel("Please enter arithmetic expression: ");
		answer = new JLabel();
		input = new TextField(20);	
    }
    /**
     * createPanel and add elements
     */
    private void createPanel(){
		panel = new JPanel();
		panel.add(questionLabel);//question label
		panel2= new JPanel();
		panel.add(input); //add text field 1
		panel.add(button);
		panel2.add(answer);//add text field answer
		add(panel);
		add(panel2);
    }
	/**
     * create button and add listener for text field and button
     */
	private void createButton() {
		button = new JButton("Calculate");
		class AddInterestListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent evt) {
				try{
					String temp=input.getText();
					values = temp.split(" "); 
					firstOperand= getFirstOperand();
					operator=getOperator();
					secondOperand=getSecondOperand();
					getThirdOperand();
					result=getCalculation();
					answer.setText("result " + result + "");
					panel2.setBackground(Color.WHITE);
				} catch(InvalidExpressionException e){
					answer.setText(e.getMessage());
					panel2.setBackground(Color.RED);
				}	
			}
		}
		ActionListener listener = new AddInterestListener();
		button.addActionListener(listener);
		input.addActionListener(listener);
	}
	/**
     * get the calculation of expression
     * @param operand1 that is the operand1 of the expression
	 * @param operator that is the operator of the expression
	 * @param operand2 that is the operand2 of the expression
	 * @throws InvalidExpressionException
     */
	public int getCalculation() throws InvalidExpressionException {
		try{
			switch(operator){
			    case "+":
					result= firstOperand + secondOperand;
					return result;
			    case "-":
					result= firstOperand - secondOperand;
					return result;
				case "*":
					result= firstOperand * secondOperand;
					return result;
				case "/":
					result= firstOperand / secondOperand;
					return result;
				case "%":
					result= firstOperand % secondOperand;
					return result;				
				default:
					throw new InvalidExpressionException("Illegal operator " + "\"" + operator + "\""); 
			}
		} catch(ArithmeticException e){
			throw new InvalidExpressionException(e.getMessage());
		}
	}  	
	/**
     * get operandFirst for calculation
	 * @throws InvalidExpressionException
     */
	public int getFirstOperand()throws InvalidExpressionException{
		try {
			return Integer.parseInt(values[0]);
		} catch(IllegalArgumentException e){
			throw new InvalidExpressionException("The first operand  is not integer");
		} catch(ArrayIndexOutOfBoundsException e){
			throw new InvalidExpressionException("The first operand is missing");
		}	
	}
	/**
     * get operandSecond for calculation
	 * @throws InvalidExpressionException
     */
	public int getSecondOperand() throws InvalidExpressionException{
		try {
			return Integer.parseInt(values[2]);
		} catch(IllegalArgumentException e){	
			throw new InvalidExpressionException("The second operand  is not integer");
		} catch(ArrayIndexOutOfBoundsException e){
			throw new InvalidExpressionException("The second operand is missing");
		}
	}
	/**
     * check if the expression has maor than one operation
	 * if it has just trown exception
	 * @throws InvalidExpressionException
     */
	public void getThirdOperand() throws InvalidExpressionException{
		try {
			String thirdOperand= values[3];
			//should not have the third position means that you can not make 2 operation or more in the expression
			throw new InvalidExpressionException("More than just 2 operands and an operator");
		} catch(ArrayIndexOutOfBoundsException e){
			//do nothing because there is no 3 position
		}
	}
	/**
     * get operandator for calculation
	 * @throws InvalidExpressionException
     */
	public String getOperator() throws InvalidExpressionException{
		try {
			return values[1];
		} catch(ArrayIndexOutOfBoundsException e){
			throw new InvalidExpressionException("The operator and second operand are missing");
		}
	}
	/**
     * My own custom exception that extends exception
     */
    public static class InvalidExpressionException extends Exception{
		public  InvalidExpressionException (){}
		public InvalidExpressionException(String message){
			super(message);
		}
	}
 }