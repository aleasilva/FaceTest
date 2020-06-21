
package facebook.strings;

class MatchingPairs {

  // Add any helper functions you may need here
  
  
  private void swapItens(char[] array, int pos1, int pos2) {
	  
	  char save = array[pos1] ;
	  
	  array[pos1] = array[pos2];
	  array[pos2] = save;
	  
  }

  int matchingPairs(String s, String t) {
    // Write your code here
    char[] arrayS = s.toCharArray(); 
    char[] arrayT = t.toCharArray();
    int fisrtPosSwap = -1;
    int count = 0;
    
    //Swap when there are dif in array
    for (int i = 0; i < arrayS.length; i++){
      
      if(arrayS[i] != arrayT[i]  ){
    	  
    	  //Save the first item
    	  if(fisrtPosSwap == -1) {
    		  fisrtPosSwap = i;
    	  }else {
    		  swapItens(arrayS,fisrtPosSwap,i);
    	  }
        
      }
      
    }
    
    //Swap where the are the same
    if(fisrtPosSwap == -1) {
    	swapItens(arrayS,0,1);
    	
    }
    
    //Count par
    for (int p = 0; p < arrayS.length; p++) {
    	if(arrayS[p] == arrayT[p]  ){
    		count++;
    		 
    	}	
    }

    
    return count;
    
  }




  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  void check(int expected, int output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected); 
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }
  public void run() {
    String s_1 = "abcde";
    String t_1 = "adcbe";
    int expected_1 = 5;
    int output_1 = matchingPairs(s_1, t_1);
    check(expected_1, output_1);

    String s_2 = "abcd";
    String t_2 = "abcd";
    int expected_2 = 2;
    int output_2 = matchingPairs(s_2, t_2);
    check(expected_2, output_2);
    
    String s_3 = "mno";
    String t_3 = "mno";
    int expected_3 = 1;
    int output_3 = matchingPairs(s_3, t_3);
    check(expected_3, output_3);

    // Add your own test cases here
    
  }
  public static void main(String[] args) {
    new MatchingPairs().run();
  }
}
