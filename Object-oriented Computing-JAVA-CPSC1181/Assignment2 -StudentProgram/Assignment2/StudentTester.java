/**
**Program name: Student
**Author:   Cecilia Floquet
**Date:  Jan 14, 2019
**Course:  CPSC 1181
**Compiler:  JDK 1.9
*/

import java.util.*;
/**
 * Tests the methods of Student class
 * @param args not used
 */
public class StudentTester{
	public static void main(String[] args){
			
		//CREATE THE OBJECT STUDENT default
		Student st= new Student();	
		
		//CREATE THE OBJECT STUDENT1
		Student st1= new Student("Vancouver", "    George         Felix   Barbosa");
		//call method of object student1
		st1.addCourse(3, "a");
		st1.addCourse(1, "b");
		st1.addCourse(3, "c");
		st1.addCourse(3, "f");
			
		//DISPLAY THE INFORMATION ABOUT STUDENT1
		System.out.println( "studentNameOne: " + st1.getName() + "\nAddressOne: " + st1.getAddress() + "\nLoginOne: " + st1.getLoginId() + "\nStudentNumberOne" + st1.getStudentNum() +
							"\nGPAOne: " + st1.calculateGPA());
		System.out.println( "Expected studentNameOne:    George         Felix   Barbosa"  + "\nExpected AddressOne: Vancouver"  + "\nExpected LoginOne: Gbar02" +   "\n Expected StudentNumberOne:10002" + 
							"\nExpected GPAOne:2.1 ");
		
		//CREATE THE OBJECT STUDENT2
		Student st2= new Student(" ", "   Cecilia    ");
		//call method of object student2
		st2.addCourse(3, "c");
		st2.addCourse(3, "a+");
		st2.addCourse(4, "ff");
		//DISPLAY THE INFORMATION ABOUT STUDENT2
		System.out.println( "studentNameTwo: " + st2.getName() + "\nAddressTwo: " + st2.getAddress() + "\nLoginTwo: " + st2.getLoginId() + "\nStudentNumberTwo" + st2.getStudentNum() +
							"\nGPATwo: " + st2.calculateGPA());
		System.out.println( "Expected studentNameTwo:    Cecilia    cecilia"  + "\nExpected AddressTwo:  " + "\nExpected LoginTwo: ccec03" + "\nExpected StudentNumberTwo:10003" +
							"\nExpected GPATwo: 1.8");								

		//CREATE THE OBJECT STUDENT4
		Student st3= new Student(" Vancouver ", "  Cecilia Lo   ");
		//call method of object student2
		st3.addCourse(4, "c+");
		st3.addCourse(5, "d-");
		
		//DISPLAY THE INFORMATION ABOUT STUDENT3
		System.out.println( "studentNameThree: " + st3.getName() + "\nAddressThree: " + st3.getAddress() + "\nLoginThree: " + st3.getLoginId() + "\nStudentNumberThree" + st3.getStudentNum() +
							"\nGPAThree: " + st3.calculateGPA());
		System.out.println( "Expected studentNameThree:  Cecilia Lo   " + "\nExpected AddressThree:  Vancouver " + "\nExpected LoginThree: clo04"  + "\nExpected StudentNumberThree: 10004"  +
							"\nExpected GPAThree: 1.41");

									
	}
	
}

