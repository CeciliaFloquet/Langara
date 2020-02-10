/**
**Program name: Mystery Numbers Game
**Author:   Cecilia Floquet
**Date:  Jan 7, 2019
**Course:  CPSC 1181
**Compiler:  JDK 1.9
*/
import javax.swing.JOptionPane;
public class Mystery{

	public static void main(String[] args){
		String level="";
				
		//loop repeat while answer is continue
		do{
			//ask about level
			String[] levels = {"Begin", "Intermediate", "Expert"};
		  
			int answer1 = JOptionPane.showOptionDialog(null, "Choose the level Would you like to play?",
				"Question?",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				levels, levels[2]); 
			
			if (answer1 == 0){
				level = "begin";
				begin(level);
			}
			else if(answer1 == 1){
				level = "intermediate";
				intermediate(level);
			}	
			else{
				level = "expert";
				expert(level);
			}

		}while(stop());

    }
	//method for do operations
	public static int operation(String level){
		int guess1;
		//think about the number
		JOptionPane.showMessageDialog(null, "Think of a number", "Message", JOptionPane.INFORMATION_MESSAGE);
		//first calculate
		String guess = JOptionPane.showInputDialog( null, "The number that you thought multiply 10 is?", " Question", JOptionPane.QUESTION_MESSAGE);
		while(!check(guess)){
			JOptionPane.showMessageDialog( null, "Invalid Input", " Error", JOptionPane.INFORMATION_MESSAGE);
			guess = JOptionPane.showInputDialog( null, "The number that you thought multiply 10 is?", " Question", JOptionPane.QUESTION_MESSAGE);
		}
		//LEVEL1
		if(level.equals("begin")){
			return Integer.parseInt(guess) / 10;
		}
		//LEVEL2
		else if(level.equals("intermediate")){
			String guess2 = JOptionPane.showInputDialog( null,  " The number that you thought divide 2 is?", " Question", JOptionPane.QUESTION_MESSAGE);	
			while(!check(guess2)){
				JOptionPane.showMessageDialog( null, "Invalid Input", " Error", JOptionPane.INFORMATION_MESSAGE);
				guess2 = JOptionPane.showInputDialog( null,  " The number that you thought divide 2 is?", " Question", JOptionPane.QUESTION_MESSAGE);	
			} 
				
			String guess3 = JOptionPane.showInputDialog( null, " The number that you thought multiply 4 is?", " Question", JOptionPane.QUESTION_MESSAGE);
			while(!check(guess3)){
				JOptionPane.showMessageDialog( null, "Invalid Input", " Error", JOptionPane.INFORMATION_MESSAGE);
				guess3 = JOptionPane.showInputDialog( null, " The number that you thought multiply 4 is?", " Question", JOptionPane.QUESTION_MESSAGE);
			}
			return Integer.parseInt(guess3) / 4;
		}
		//LEVEL3
		else{
			String guess2 = JOptionPane.showInputDialog( null, " The number that you thought divide 5 is?", " Question", JOptionPane.QUESTION_MESSAGE);
			while(!check(guess2)){
				JOptionPane.showMessageDialog( null, "Invalid Input", " Error", JOptionPane.INFORMATION_MESSAGE);
				guess2 = JOptionPane.showInputDialog( null, " The number that you thought divide 5 is?", " Question", JOptionPane.QUESTION_MESSAGE);
			}
			String guess3 = JOptionPane.showInputDialog( null, " The number that you thought multiply 25 +1 is?", " Question", JOptionPane.QUESTION_MESSAGE);
			while(!check(guess3)){
				JOptionPane.showMessageDialog( null, "Invalid Input", " Error", JOptionPane.INFORMATION_MESSAGE);
				guess3 = JOptionPane.showInputDialog( null, " The number that you thought multiply 25 +1 is?", " Question", JOptionPane.QUESTION_MESSAGE);
			}
			String guess4 = JOptionPane.showInputDialog( null, " The number that you thought divide 2 is?", " Question", JOptionPane.QUESTION_MESSAGE);			
			while(!check(guess4)){
				JOptionPane.showMessageDialog( null, "Invalid Input", " Error", JOptionPane.INFORMATION_MESSAGE);
				guess4 = JOptionPane.showInputDialog( null, " The number that you thought divide 2 is?", " Question", JOptionPane.QUESTION_MESSAGE);		
			}
			String guess5 = JOptionPane.showInputDialog( null, "The number that you thought multiply 9 is?", " Question", JOptionPane.QUESTION_MESSAGE);
			while(!check(guess5)){
				JOptionPane.showMessageDialog( null, "Invalid Input", " Error", JOptionPane.INFORMATION_MESSAGE);
				guess5 = JOptionPane.showInputDialog( null, "The number that you thought multiply 9 is?", " Question", JOptionPane.QUESTION_MESSAGE);
			
			}
			return Integer.parseInt(guess5) / 9;
		}
	
	
	}
	//method to check if the input id valid or not
	public static boolean check(String guess){
		if(guess == null || guess.length() == 0 || guess.indexOf(".")> -1 || guess.indexOf("-")> -1){
			
			return false;
		}
		else{
			return true;
		}
	}
	
	//method for choose begin
	public static void begin( String level){
		int guess1=operation(level);
		//show the guess 1
		JOptionPane.showMessageDialog(null, "The number that you thought is " + guess1, "Guess", JOptionPane.INFORMATION_MESSAGE);
	}
	//method for choose intermediate
	public static void intermediate(String level){
		int guess1=operation(level);
		//show the guess 1
		JOptionPane.showMessageDialog(null, "The number that you thought is " + guess1, "Guess", JOptionPane.INFORMATION_MESSAGE);
	}
	//method for choose expert
	public static void expert(String level){
		int guess1=operation(level);
		//show the guess 1
		JOptionPane.showMessageDialog(null, "The number that you thought is " + guess1, "Guess", JOptionPane.INFORMATION_MESSAGE);
	}
	//method to ask the users if continue the program
	public static boolean stop(){
		String[] options = {"Yes, please", "No, thanks"};
      
		int answer = JOptionPane.showOptionDialog(null, "Would you like to continue?",
			"Question?",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
			options, options[1]); 
      
		if (answer == 0)
			return true;
      
		else
			return false;
	}
}