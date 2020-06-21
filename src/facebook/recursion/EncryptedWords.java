package facebook.recursion;

public class EncryptedWords {

	
	char[] sEncpt ;
	int pos;

	String findEncryptedWord(String s) {
		char[] sInput = s.toCharArray();
		this.sEncpt = new char[sInput.length];
		this.pos = -1;
		
		encryptData(sInput, 0 ,sInput.length-1 );
			
		
		String sRet = new String(this.sEncpt);
		
		return sRet;
	}
	
	private void encryptData(char[] input, int posIni , int posEnd) {
		int mid;
		
		if(posIni <= posEnd) {
			mid = (posIni+posEnd)/2;
			
			//Saving the correct order.
			this.sEncpt[++pos] = input[mid];
			
			encryptData(input, posIni, mid-1);
			encryptData(input, mid+1, posEnd);
			
		}
		
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
		} else {
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
		String s_1 = "abc";
		String expected_1 = "bac";
		String output_1 = findEncryptedWord(s_1);
		check(expected_1, output_1);

		String s_2 = "abcd";
		String expected_2 = "bacd";
		String output_2 = findEncryptedWord(s_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new EncryptedWords().run();
	}

}
