public class InternationalStudent extends Student{
  
   private String country;   
   
   public InternationalStudent(String name, String address, String country){
      super(name, address);
      country= country;
        
   
   }
   public String countryName(){
      return country;
   }
   
   public double getTuitionFee(){
      return getTotalCredits() * 345.95;
      
   }
   
   public String toString() {
      return super.toString() + "(country:" + country + ")";
   } 
}

