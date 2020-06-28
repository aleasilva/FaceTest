package facebook.list;

import java.io.*;
import java.util.*;

public class QueueRemovals {
	
	List<Integer> savedList = new ArrayList<Integer>();
	
	
 	int[] getResizedList(int[] arr, int size, int intR) {
 		
 		//Reducing the list
 		int[] arrTemp; 
 		int[] arrayToAdd;
 		int[] newArray = new int[size];
 		
 		int bigValue;
 		int oriItem;
 		
 		if( savedList.size() >= size + intR) {
 			arrTemp = Arrays.copyOfRange(arr,0,size); 	
 			
 			//Find the biggest
 			Arrays.sort(arrTemp);
 			bigValue = arrTemp[arrTemp.length - 1] ;
 			oriItem = savedList.indexOf(bigValue)+1;
 			
 			arrayToAdd = new int[arrTemp.length - 1];
 			//Remove the biggest
 			int index = 0;
 			for(int val : arrTemp) {
 				if(val != bigValue) {
 					arrayToAdd[index] = val;
 					index++;
 				}
 				
 			}
 			
 			//arrayToAdd = Arrays.copyOfRange(arrTemp,0,size-1);
 				
 		}else {
 			arrTemp = Arrays.copyOfRange(arr,intR,size);
 			arrayToAdd = Arrays.copyOfRange(arr,0,size-1);
 			
 			Arrays.sort(arrTemp);
 			bigValue = arrTemp[arrTemp.length - 1] + intR;
 			oriItem = savedList.indexOf(bigValue)+1;
 		}
 		
 
 		
 		//Remount the values
 		int offSet = 0;
 		
 		for(int i = 0; i < arrayToAdd.length ; i++) {
 			
 			if(i < intR) {
 				newArray[i] = arr[i];
 			}else if (i == intR) {
 				newArray[intR] = oriItem;
 				offSet++;
 			} else {
 			
	 			if (arrayToAdd[i] > 0 ) {
					newArray[offSet] = arrayToAdd[i] -1;
				}else {
					newArray[offSet] = arrayToAdd[i];
				}
 			}
 			offSet++;
 			
 		}
 		
 		return newArray;
 		
 		
 	}
	
 	
	int[] findPositions(int[] arr, int x) {
		
		//Save this array into list, just for fun
		for(int val : arr) {
			this.savedList.add(val);
		}
		
		// Write your code here
		int[] tempArray = arr;
		
		for(int i=0; i < x; i++) {
			tempArray = getResizedList(tempArray,x,i);
			System.out.println(i+1+ "-> " + Arrays.toString(tempArray));
		}
		
		return tempArray;

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
