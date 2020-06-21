package facebook.stacks;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;




public class BalanceBrackets {

	final Map<String,String> dicitonary = new Hashtable<String,String>();

	
	public BalanceBrackets() {
		dicitonary.put("(", ")");
		dicitonary.put("{", "}");
		dicitonary.put("[", "]");
	}
	
	boolean isBalanced(String s) {
		// Write your code here
		char[] allStrings = s.toCharArray();
		int allSize = allStrings.length;
		int midle = allStrings.length /2 ; 
		boolean balanced = true;
		
		char[] allLeft = Arrays.copyOfRange(allStrings,0, midle);
		char[] allRight = Arrays.copyOfRange(allStrings,midle,allSize );
		
	
		
	for (int i = 0 ; i < allLeft.length; i++) {
		char left = allLeft[midle - (i+1)];
		char right = allRight[i];
		char compRight = this.dicitonary.get(String.valueOf(left)).charAt(0);
		//char compRight = ' ';

		if(compRight !=  right) {
			balanced = false;
			break;
		}
		
	}
		
		return balanced;

	}

	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;

	void check(boolean expected, boolean output) {
		boolean result = (expected == output);
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			System.out.print(expected);
			System.out.print(" Your output: ");
			System.out.print(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printString(String str) {
		System.out.print("[" + str + "]");
	}

	public void run() {
		String s_1 = "{[(])}";
		boolean expected_1 = false;
		boolean output_1 = isBalanced(s_1);
		check(expected_1, output_1);

		String s_2 = "{{[[(())]]}}";
		boolean expected_2 = true;
		boolean output_2 = isBalanced(s_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new BalanceBrackets().run();
	}

}
