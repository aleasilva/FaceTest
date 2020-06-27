package facebook.recursion;

public class Currency2 {

	
	
	private int match(int value, int[] coins, int index) {
		if(value< 0) {
			return 0;
		}else if (value == 0) {
			return 1;
		}
		
		int count =0 ;
		int pos = index;
		
		while (pos < coins.length ) {
			count += match(value - coins[pos], coins, pos);
			pos++;
		}
		
		return count;
		
	}

	boolean canGetExactChange(int targetMoney, int[] denominations) {
		if (match(targetMoney, denominations, 0) == 0) {
			return false;
		}else {
			return true;
		}

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
		System.out.print("[\"" + str + "\"]");
	}

	public void run() {

		int target_0 = 95;
		int arr_0[] = { 5, 10, 25, 100, 200 };
		boolean expected_0 = true;
		boolean output_0 = canGetExactChange(target_0, arr_0);
		check(expected_0, output_0);

		int target_1 = 94;
		int arr_1[] = { 5, 10, 25, 100, 200 };
		boolean expected_1 = false;
		boolean output_1 = canGetExactChange(target_1, arr_1);
		check(expected_1, output_1);

		int target_2 = 75;
		int arr_2[] = { 4, 17, 29 };
		boolean expected_2 = true;
		boolean output_2 = canGetExactChange(target_2, arr_2);
		check(expected_2, output_2);

		int target_3 = 15;
		int arr_3[] = { 2, 3, 5, 10 };
		boolean expected_3 = true;
		boolean output_3 = canGetExactChange(target_3, arr_3);
		check(expected_3, output_3);
		
		int target_4 = 5;
		int arr_4[] = { 1,2, 3 };
		boolean expected_4 = true;
		boolean output_4 = canGetExactChange(target_4, arr_4);
		check(expected_4, output_4);
		
		

	}

	public static void main(String[] args) {
		new Currency2().run();
	}
}
