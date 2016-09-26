package Laboratory5;
/*
 * 
 * Allyssa S. Albores 09/26/16
 * 
 */
public class TestDate {
	   public static void main(String[] args) {
	      // Test constructor and toString()
	      Date d1 = new Date(2016, 4, 6);
	      System.out.println(d1);  // toString()
	 
	      // Test Setters and Getters
	      d1.setYear(2012);
	      d1.setMonth(12);
	      d1.setDay(23);
	      System.out.println(d1);  // run toString() to inspect the modified instance
	      System.out.println("Year is: " + d1.getYear());
	      System.out.println("Month is: " + d1.getMonth());
	      System.out.println("Day is: " + d1.getDay());
	 
	      System.out.println(Date.isLeapYear(2016) ? "Leap Year" : "Not Leap Year");
	      
	      System.out.println(Date.isValid(2017, 2, 29) ? "VALID" : "NOT VALID");
	      
	      
	   }
}
