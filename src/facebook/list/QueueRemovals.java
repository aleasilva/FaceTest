package facebook.list;

import java.io.*;
import java.util.*;

public class QueueRemovals {
	
	List<Integer> savedList = new ArrayList<Integer>();
	int[] newRet ;
 	int[][] arraySaved;
 	int VAL_ORI = 0;
 	int VAL_ATU = 1;
 	
 	
 	private int findBigValue(int[] arr, int intR) {
 		int[] aOrder; 
 		
 		if (intR < arr.length) {
 			 aOrder = Arrays.copyOfRange(arr,intR,arr.length );
 		 }else {
 			 aOrder = arr;
 		 }
 		
 		Arrays.sort(aOrder);
 		
 		return aOrder[aOrder.length-1];
 		
 	}
 		
 	private int[] removeItemFromArray(int[] arr, int val) {
 		int[] tmpArray = new int[arr.length - 1];
 		
 		int offSet = 0;
 		for(int i = 0; i < arr.length; i++) {
 			
 			if(arr[i] != val ) {
 				tmpArray[offSet] = arr[i];
 				offSet++;
 			}
 			
 		}
 		
 		return tmpArray;
 		
 	}
 	
 	private int[] putItemOnArray(int[] arr, int val, int pos) {
 		int[] tmpArray = new int[arr.length+1];
 		
 		int offSet = 0;
	 	for(int i = 0; i < arr.length; i++) {
	 		
	 		if(i == pos ) {
	 			tmpArray[offSet] = val;
	 			offSet++;
	 			tmpArray[offSet] = arr[i];
	 		}else {
	 			tmpArray[offSet] = arr[i];
	 		}
	 		
	 		offSet++;
	 	}
	 	
	 	return tmpArray;
 		
 	}
 	
 	private void computeArray(int[] arr, int intR) {
 		
 		for(int i = 0; i < arr.length; i++) {
 			
 			if(i > intR && arr[i] > 0) {
 				arr[i] = arr[i] - 1;
 			}
 			
 		}
 		
 		
 	}
	
 	int[] getResizedList(int[] arr, int size, int intR) {	
 		int[] workArr;
 		int newValue;
 		
 		//For the first and second interation when the array is bigger
 		if(arr.length > size && intR == 0 ) {
 			
 			workArr = Arrays.copyOfRange(arr, 0, size);
 			int valRemove = findBigValue(workArr, intR);
 			newValue = savedList.indexOf(valRemove)+1;
 			
 			workArr = removeItemFromArray(workArr, valRemove);
 			workArr = putItemOnArray(workArr, newValue, intR);

 			//System.out.println("Input ->" + Arrays.toString(workArr));
 			computeArray(workArr, intR);
 			//System.out.println("Output ->" + Arrays.toString(workArr));
 			
 		}else  {
 			workArr = arr;
 			int valRemove = findBigValue(workArr, intR -1);
 			newValue = savedList.indexOf(valRemove)+1;
 			
 			workArr = removeItemFromArray(workArr, valRemove);
 			computeArray(workArr, -1);
 			
 		}
 		
 		this.newRet[intR] = newValue; 
 				
 		return workArr;
 		
 	}
	
 	
	int[] findPositions(int[] arr, int x) {
		this.arraySaved = new int[arr.length][2];
		
		
		//Save this array into list, just for fun
		for(int i = 0; i < arr.length;i++) {
			this.savedList.add(arr[i]);
			this.arraySaved[i][VAL_ORI] = arr[i];
			this.arraySaved[i][VAL_ATU] = arr[i];
			
		}
		
		
		// Write your code here
		int[] tempArray = arr;
		this.newRet = new int[x];
		
		for(int i=0; i < x; i++) {
			tempArray = getResizedList(tempArray,x,i);
			System.out.println(i+1+ "-> " + Arrays.toString(tempArray));
		}
		
		return this.newRet;

	}

	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;

	void check(int[] expected, int[] output) {
		int expected_size = expected.length;
		int output_size = output.length;
		boolean result = true;
		if (expected_size != output_size) {
			result = false;
		}
		for (int i = 0; i < Math.min(expected_size, output_size); i++) {
			result &= (output[i] == expected[i]);
		}
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printIntegerArray(expected);
			System.out.print(" Your output: ");
			printIntegerArray(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printIntegerArray(int[] arr) {
		int len = arr.length;
		System.out.print("[");
		for (int i = 0; i < len; i++) {
			if (i != 0) {
				System.out.print(", ");
			}
			System.out.print(arr[i]);
		}
		System.out.print("]");
	}

	public void run() {
		int n_1 = 6;
		int x_1 = 5;
		int[] arr_1 = { 1, 2, 2, 3, 4, 5 };
		int[] expected_1 = { 5, 6, 4, 1, 2 };
		int[] output_1 = findPositions(arr_1, x_1);
		check(expected_1, output_1);

		int n_2 = 13;
		int x_2 = 4;
		int[] arr_2 = { 2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4 };
		int[] expected_2 = { 2, 5, 10, 13 };
		int[] output_2 = findPositions(arr_2, x_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new QueueRemovals().run();
	}

}
