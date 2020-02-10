public class GraduateStudent extends Student{
  
   private String topic;
   private String studentSupervisor;
   
   public GraduateStudent(String name, String address, String topic, String supervisor){
      super(name, address);
      topic= topic;
      studentSupervisor= supervisor;
   }
   public  String researchTopic(){
      return topic;
   }
   public String nameOfStudentSupervisor(){
     return studentSupervisor;
      
   }
   public String toString() {
      return super.toString() + "(topic:" + topic + ")" + "(studentSupervisor:" + studentSupervisor + ")";
   } 
   

}