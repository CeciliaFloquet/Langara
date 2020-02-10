/**
 * Students have unique id, login that is create by their name.
 *they have gpa that is calculate used the  credits and gradePoint
 */
public class Student{
	
    /**
	 * Constructs a student  with student number 
	 * and credits zero, gpa zero and gradePoint zero
	 * @param is not used 
	 */
	public Student(){
		studNumber = studentNumber;
	    studentNumber++;
		credits=0;
		gpa=0;
		gradePoint=0;	
	}
	/**
      * Constructs a Student with
      * @param adr the address of student and
	  *	@param n the name of student
      */
	public Student(String adr, String n){
		address = adr;
		studNumber = studentNumber;
	    studentNumber++;
		credits=0;
		gpa=0;
		gradePoint=0;	
		setName(n);
		setLoginId();
	}
	/**
	 * Method to check if name is correct.
	 * @return true or false
	*/
	public void setName( String n){
		n=n.trim();
		String[] words= n.split(" "); 
		name = words[0] + " " + words[words.length-1];
	} 
	
	/**
	 * Gets name of students.
	 * @return name
	 */
	public String getName(){
		
		return name;
	}
	/**
	 * Gets address of students.
	 * @return address
	 */
	public String getAddress(){
		
		return  address;
	}
	/**
	 * addCouse with
	 * @param c the credit of the course and 
	 * @param sco the score of course of each student
	 */
	public void addCourse(int c, String sco){
		int credit= c;
		credits +=c;
		String score= sco;
		score= score.toLowerCase();
		switch(score){
			case "a+":
				gradePoint += (credit * 4.00);
				break;
			case "a":
				gradePoint += (credit * 4.00);
				break;
			case "a-":
				gradePoint += (credit * 3.70);
				break;
			case "b+":
				gradePoint += (credit * 3.33);
				break;
			case "b":
				gradePoint += (credit * 3.00);
				break;
			case "b-":
				gradePoint += (credit * 2.70);
				break;
			case "c+":
				gradePoint += (credit * 2.30);
				break;
			case "c":
				gradePoint += (credit * 2.00);
				break;
			case "c-":
				gradePoint += (credit * 1.70);
				break;
			case "d+":
				gradePoint += (credit * 1.30);
				break;
			case "d":
				gradePoint += (credit * 1.0);
				break;
			case "d-":
				gradePoint += (credit * 0.70);
				break;
			default:
				gradePoint +=0;
				break;
		}
	}
	/**
	 * Calculate of students' gpa.
	 * @return gpa
	 */
	public double calculateGPA(){
		gpa = gradePoint / credits;
		return gpa;
	}
	/**
	 * Gets students' number.
	 * @return studentNumber
	 */
	public int getStudentNum(){
		 
	     return studNumber;
	}
	/**
	 * set students'login 
	 * 
	 */
	private void setLoginId(){
		String studentName=name;
		String takePartNumber="";
		takePartNumber += studNumber;
	
		String temp="", firstLetter= studentName.substring(0,1);
		
		int index=studentName.indexOf(" ");
		studentName=studentName.substring(index);
		studentName= studentName.trim();
		String test2= studentName.substring(studentName.indexOf(" ") +1);
		if(studentName.length() >= 4){
			temp = studentName.substring(0,3);
		}
		else{
			temp =  studentName.substring(0);
		}
				
		id =  firstLetter + temp + takePartNumber.substring(takePartNumber.length()-2);
		
	}
	
	/**
	 * Gets students' login.
	 * @return login id
	 */
	public String getLoginId(){		
		return id;
	}
	
   
	
	
	private String name;
	private String address;
	private double averageGPA;
	private double gpa;
	private int credits;
	private double gradePoint;
	private int studNumber;
	private String id;
	private static int studentNumber = 10001;
}