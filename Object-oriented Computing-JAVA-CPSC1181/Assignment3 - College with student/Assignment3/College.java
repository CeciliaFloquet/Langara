import java.util.ArrayList;

/**
* A College holds a collection of students.
*/
public class College
{

    /**
    * Constructs an empty college.
    */
	public College(){
      
		listOfStudents= new ArrayList<Student>();
		
    }
	/**
	 * add new Student for the list of student
	 * @param Student student that you want to add to College
	 */
	public void add(Student student){
      
		listOfStudents.add(student);
		
    }
	/**
	 * find the student with the same and return the Student
	 * @param number is the student's id 
	 * @return the student object if is the sme number if not return null
	 */
	public Student findByStudentNum(int number){
		
		for(int i=0; i< listOfStudents.size();i++){
			if(listOfStudents.get(i).getStudentNum() == number){
				return listOfStudents.get(i);
			}
		}
		return null;
	}
	/**
	 * find the student with the same number that you recebe with parameter
	 * @param number that is the student id  you need to find. If you find remove
	 */
	public void delete(int number){
		Student student =findByStudentNum(number);
		if (student != null){
			listOfStudents.remove(student);
		}
		
	}
	/**
	 * find the student with the same  number if you find add credits and grade
	 * @param number that is the students` id
	 * @param credit that is the credit of course you want add
	 * @param grade that is the grade of student you want add
	 */
	public void addGrade(int number,int credit, String grade){
		
		Student student = findByStudentNum(number);
		if(student != null){
			student.addCourse(credit, grade);
		}
	}
	/**
	 * find the student with the same number and return login 
	 * @param number that is the student id. 
	 * @return login id of this student that the number match 
	 */
	public String  retrievingLogin(int number){
		Student student = findByStudentNum(number);
		if(student != null){
			return student.getLoginId();
		}
		return null;
	}
	/**
	 * find the higest gpa in the listOfStudents
	 * @return the number of students with highest GPA
	 */
	public Student findHighestGPA(){
		Student temp= null;
		double num=0;
		for(int i=0; i< listOfStudents.size();i++){
			if(listOfStudents.get(i).calculateGPA() > num){
				num = listOfStudents.get(i).calculateGPA(); 
				temp=listOfStudents.get(i);
			}
		}
		return temp;
	}
	/**
	* Gives a text representation of the college.
	* @return a string 
	*/
	public String toString(){
		
		return "College" + listOfStudents.toString();    
	}
	
	private ArrayList<Student>listOfStudents;
	
}