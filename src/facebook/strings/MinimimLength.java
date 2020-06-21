package facebook.strings;

import java.io.IOException;


class MinimimLength {

  // Add any helper functions you may need here
  int countItensOnArray(char[] array, char key) {
	  int count = 0;
	  
	  for(char item : array ) {
		  if (item == key) {
			  count++;
		  }
	  }
	  
	  return count;
  }

  int checkFarPosition(char[] array, char key) {
	  int pos = 0;

	  for (int i = 0; i < array.length; i++) {
		  char item = array[i];
		  
		  if (item == key && i >= pos) {
			  pos = ++i;
		  }
	  }
	  
	  return pos;  
  }
  
  int minLengthSubstring(String s, String t) {
    // Write your code here
	
	char[] tableS = s.toCharArray();
	char[] tableT = t.toCharArray();
	int farPos = 0;
    
    
	for(int i = 0; i < tableT.length; i++) {
		
		int qtOnTabT = countItensOnArray(tableT, tableT[i]);
		int qtOnTabS = countItensOnArray(tableS, tableT[i]);
		
		//If the quantity is less the match is not possible
		if (qtOnTabS < qtOnTabT) {
			return -1;
		}
		
		//The far position on array shows the maximun combination range, I hope.
		int pos = checkFarPosition(tableS, tableT[i]);
		
		if (pos > farPos ) {
			farPos = pos;
		}
		
	}
	  
	return farPos;
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
  public void run() throws IOException {
    String s_1 = "dcbefebce";
    String t_1 = "fd";
    int expected_1 = 5;
    int output_1 = minLengthSubstring(s_1, t_1);
    check(expected_1, output_1);

    String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
    String t_2 = "cbccfafebccdccebdd";
    int expected_2 = -1;
    int output_2 = minLengthSubstring(s_2, t_2);
    check(expected_2, output_2);

    // Add your own test cases here
    
  }
  public static void main(String[] args) throws IOException {
    new MinimimLength().run();
  }
}