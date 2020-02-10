public class StudentTest
{
     public static void main(String[] args)
     {
           Student s1 = new Student("Jo Mah", "100 West 49");
           Student s2 = new GraduateStudent("John Smith", "100 West 49", "DataMining", "Smith");
           Student s3 = new InternationalStudent("Mary McNight", "94 Noel St.", "Holland");
       
           s1.addCourse(3.4, 3);
	   s1.addCourse(4.0, 3);
           System.out.println("The tuition fee for the regular student is: " + s1.getTuitionFee());
           System.out.println("The GPA of the regular student is: " + s1.getGPA());
           System.out.println("Expected output: \n"
                        + "\tThe tuition fee for the regular student is: 562.14" 
                        + "\n\tThe GPA of the regular student is: 3.6999999999999997");
      
           s2.addCourse(3.4, 3);
           s2.addCourse(4.0, 3);
           System.out.println("\nThe tuition fee for this graduate student is: " + s1.getTuitionFee());
           System.out.println("The GPA of this graduate student is: " + s2.getGPA());
           System.out.println("Expected output: \n"
                        + "\tThe tuition fee for this graduate student is: 562.14" 
                        + "\n\tThe GPA of this graduate student is: 3.6999999999999997");
      
           s3.addCourse(3.4, 3);
           s3.addCourse(4.0, 3);
           System.out.println("\nThe tuition fee for this InternationalStudent is: " + s3.getTuitionFee());
           System.out.println("The GPA of this International student is: " + s2.getGPA());
           System.out.println("Expected output: \n"
                        + "\tThe tuition fee for this InternationalStudent is: 2075.7" 
                        + "\n\tThe GPA of this International student is: 3.6999999999999997");
                        
          System.out.println("\n" + s1 + "\n" + s2 + "\n" + s3);
          System.out.println("Expected output: \n"
            + "\tClass Name: Student Name: Jo Mah Address: 100 West 49 Student Number: 10001 Login ID: jmah01 GPA: 3.70" +
               "\n\tClass Name: GraduateStudent Name: John Smith Address: 100 West 49 Student Number: 10002 Login ID: jsmi02 GPA: 3.70 Topic: DataMining Supervisor: Smith" +
               "\n\tClass Name: InternationalStudent Name: Mary McNight Address: 94 Noel St. Student Number: 10003 Login ID: mmcn03 GPA: 3.70 Countr: Holland");
     }
}