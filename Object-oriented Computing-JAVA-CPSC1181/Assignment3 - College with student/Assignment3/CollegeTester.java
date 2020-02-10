import java.util.*;
/**
  * This class tests the College class 
*/
public class CollegeTester
{
   /**
   * Creates a few College and test the various methods of the class.
   */
   public static void main(String[] args)
   {	
		//declaring variable and create college langara
		College langara = new College(); 
		int number, number1, number2, number3, credit, answer;
		String name, address, grade;
		Student student;
		do{
			Scanner input = new Scanner(System.in);
			System.out.println(" press: "+
							 " \n1)add new student in the college " +
							 "\n2)find student by id" +
							 "\n3)delete student" +
							 "\n4)add grade for specific student" +
							 "\n5)Retrieving Login used id number" +
							 "\n6)find Highest GPA  of students" +
							 "\n7) show all student in the college" +
							 "\n8) stop the program");
			answer= input.nextInt();
			
			switch(answer){
				//add new student in the college
				case 1:
					Scanner input1 = new Scanner(System.in);
					System.out.println("Please enter the name of student");
					name= input1.nextLine();
					Scanner input2 = new Scanner(System.in);
					System.out.println("Please enter the address of student");
					address = input2.nextLine();
					langara.add(new Student(address, name));
					System.out.println("Student added with success");
				break;
				//find student by id
				case 2:
					Scanner input3 = new Scanner(System.in);
					System.out.println("Please enter the student number that you need finding:");
					number= input3.nextInt();
					student=langara.findByStudentNum(number);
				if(student != null){
					System.out.println(student);
				}
				else{
					System.out.println("This student not find");
				}
				break;
				//delete student
				case 3:
					Scanner input4 = new Scanner(System.in);
					System.out.println("Please enter the student number that you need deleting:");
					number1= input4.nextInt();
					student = langara.findByStudentNum(number1);
					if( student == null){
						System.out.println("This student not find");
					}
					else{
						langara.delete(number1);
						System.out.println("Student deleted with success");
					}
					break;
				//add grade for specific student
				case 4:
					Scanner input5 = new Scanner(System.in);
					System.out.println("Please enter the student number that you need add credit and grade point");
					number2= input5.nextInt();
					student = langara.findByStudentNum(number2);
					if( student == null){
						System.out.println("This student not find");
						
					}
					else{
						Scanner input6 = new Scanner(System.in);
						System.out.println("Please enter the student grade like a+,a a-...: ");
						grade= input6.nextLine();
						Scanner input7 = new Scanner(System.in);
						System.out.println("Please enter the student credit:");
						credit= input7.nextInt();
						
						langara.addGrade(number2,credit,grade);
							
						
						System.out.println("credit and grade add with success");
					
					}			
					break;
				//Retrieving Login used id number
				case 5:
					Scanner input8 = new Scanner(System.in);
					System.out.println("Please enter the student number");
					number3= input8.nextInt();
					student = langara.findByStudentNum(number3);
					if( student == null){
						System.out.println("This student not find");
					}
					else{
						System.out.println("tTe login is:  " + langara.retrievingLogin(number3));
					}
					break;
				//find Highest GPA  of students
				case 6:
					System.out.println("The highest GPA is: " + langara.findHighestGPA());
					break;
				//show all student in the college
				case 7:
					System.out.println(langara);
					break;
				
			}
		
		}while(answer != 8);
   }
}