/**
 * Program: Student
 * Description: Create a class called Student that stores student data. 
 * Course: CPSC 1181-004
 * Assignment: 2
 * Date: January 14, 2018
 * Compiler: JDK 1.8
 * @author Michael Ko, 100272738
 * @version 1.0
*/

/**
 * A program that stores student data.
 */
public class Student {
    // Instance variables
    private String name;        // Student's first and last name
    private String address;     // Sttudent's home address
    private String login;       // Stduent login, auto-generated
    private int number;         // Student number, auto-generated
    private static int lastNumber = 10001;  // Current student number counter
    
    private double totalGradePoints;    // Total calculated grade points for all courses
    private int totalCredits;           // Total credits for all courses
     public static final  double TUITIONFEES = 93.69;

    
   /**
         * Default constructor for Student object with no arguments.
         */
    public Student() {
        this.name = "Firstname Lastname";
        this.address = "123 Street Name";
        this.number = setStudentNum();
        this.login = setLoginId();
    }
    
   /**
         * Constructor for Student object with two arguments.
         * @param name the student's first and last name
         * @param address the student's home address
         */
    public Student(String name, String address) {
        this.name = name.trim();
        this.address = address.trim();
        this.number = setStudentNum();
        this.login = setLoginId();
    }
    
   /**
         * Gets the student's name.
         * @return the String student's name
         */
   public String getName() {
        return this.name;
   }
    
   /**
         * Gets the student's home address.
         * @return the String student's home address
         */
   public String getAddress() {
        return this.address;
   }
    
   /**
         * Gets the student number.
         * @return the integer student number
        */
   public int getStudentNum() {
        return this.number;
   }
    
   /**
         * Gets the student login id.
         * @return the String login id
         */
   public String getLoginId() {
        return this.login;
   }
    
   /**
         * Gets the student's calculated GPA.
         * @return the double GPA score
         */
   public double getGPA() {
        return this.totalGradePoints / this.totalCredits;
   }
    
    /**
     * Set a student number for a student. New students should be incremented by one (e.g. 10001).
     * @return the integer student number
     */
    public int setStudentNum() {
        // Get the current student number count and apply it to the student number
        this.number = lastNumber;
        lastNumber++;
        
        return this.number;
    }
    
    /**
     * Generate a login id for the student (e.g. Homer Simpson, 10001: hsim01):
     *  First letter of id is the first letter of the student's first name.
     *  Middle part of id is the first 3 letters of the student's last name.
     *  Last part of id is the last 2 digits of the student number.
     * @return the String student's login id
     */
    public String setLoginId() {
        char letter;        // Character to check if there is a space in the full name
        int foundSpace = 0; // The location of the space in the full name
        String firstPart,   // The parts of the login id
               secondPart,
               thirdPart;
        
        // Find the space in the student's name to separate the first and last names
        for (int i = 0; i < this.name.length(); i++) {
            letter = this.name.charAt(i);
            
            if (letter == ' ') {
                foundSpace = i;
            }
        }

        // Get the first letter of the first name
        firstPart = this.name.substring(0, 1).toLowerCase();
        
        // Get the last name
        secondPart = this.name.substring(foundSpace).trim().toLowerCase();
        
        // Check if the last name is at least 3 characters
        if (secondPart.length() >= 3) {
            secondPart = secondPart.substring(0, 3);
        }
        
        // Get the last 2 digits of the 5 digit student number
        thirdPart = Integer.toString(this.number).substring(3);
        
        return firstPart + secondPart + thirdPart;
    }
    
    /**
     * Add a course to the student's record, which is required to calculate the GPA.
     * @param gradePoint the grade the student received for the course
     * @param credit the credit the student received for the course
     */
    public void addCourse(double gradePoint, double credit) {
        this.totalGradePoints += gradePoint * credit;
        this.totalCredits += credit;
        
    }
    
    
    public int getTotalCredits()
    {
      return totalCredits;
    }
    
    
    /**
     * Returns a string representation of the student record.
     * @return the String of student record
     */
    public String toString() {
        String gpaFormatted = String.format("%.2f", getGPA());
        
        return "Class Name: " + getClass().getName() + " Name: " + this.name + " Address: " + this.address + 
                " Student Number: " + this.number + " Login ID: " + this.login + 
                " GPA: " + gpaFormatted;
    }
    
    
    /**
     * Calculation the tutionfees
     * 
     */ 
   public double getTuitionFee(){
      return TUITIONFEES * totalCredits;
   }
    
  
    public  double getTotalGradePoints(){
       return totalGradePoints;
   }
   
   
    
}
