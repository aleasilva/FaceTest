package facebook.strings;

import java.nio.charset.StandardCharsets;

public class RotationalCipher {

	  // Add any helper functions you may need here
	  private byte rotateString(byte[] limit, byte ascCode, int rotate){    
	    
	    if (ascCode >= limit[0] && ascCode <= limit[1]){
	                
	        for (int r=0; r < rotate; r++){

	          ascCode += (byte)1;
	          
	          if (ascCode > limit[1]){
	            ascCode = (byte) limit[0];  
	          }          
	        }
	              
	    }
	    
	    return ascCode;
	  }
	  
	  byte[] numLimit = {48,57};
	  byte[] capLimit = {65,90};
	  byte[] nCapLimit = {97,122};

	  String rotationalCipher(String input, int rotationFactor) {
	    byte[] ascii = input.getBytes(StandardCharsets.US_ASCII); 
	    byte[] limits = null;
	    
	    for (int i = 0; i < ascii.length ; i++){
	      
	      if(ascii[i] >= numLimit[0] && ascii[i] <= numLimit[1] ){
	        limits = numLimit;        
	      } else if (ascii[i] >= capLimit[0] && ascii[i] <= capLimit[1]){
	        limits = capLimit;
	      } else if (ascii[i] >= nCapLimit[0] && ascii[i] <= nCapLimit[1]){
	        limits = nCapLimit; 
	      }
	            
	       ascii[i] = this.rotateString(limits , ascii[i], rotationFactor);
	      
	    }
	    
	    String s = new String(ascii, StandardCharsets.US_ASCII);
	    
	    return s;
	  }



	  // These are the tests we use to determine if the solution is correct.
	  // You can add your own at the bottom, but they are otherwise not editable!
	  int test_case_number = 1;
	  void check(String expected, String output) {
	    boolean result = (expected.equals(output));
	    char rightTick = '\u2713';
	    char wrongTick = '\u2717';
	    if (result) {
	      System.out.println(rightTick + " Test #" + test_case_number);
	    }
	    else {
	      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
	      printString(expected); 
	      System.out.print(" Your output: ");
	      printString(output);
	      System.out.println();
	    }
	    test_case_number++;
	  }
	  void printString(String str) {
	    System.out.print("[\"" + str + "\"]");
	  }
	  
	  public void run() {
	    String input_1 = "All-convoYs-9-be:Alert1.";
	    int rotationFactor_1 = 4;
	    String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
	    String output_1 = rotationalCipher(input_1, rotationFactor_1);
	    check(expected_1, output_1);

	    String input_2 = "abcdZXYzxy-999.@";
	    int rotationFactor_2 = 200;
	    String expected_2 = "stuvRPQrpq-999.@";
	    String output_2 = rotationalCipher(input_2, rotationFactor_2);
	    check(expected_2, output_2);

	    // Add your own test cases here
	    
	  }
	  
	  public static void main(String[] args) {
	    new RotationalCipher().run();
	  }
	
}
