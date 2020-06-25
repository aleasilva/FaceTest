package facebook.list;

import java.io.*;
import java.util.*;

public class QueueRemovals {

	// Add any helper functions you may need here
	private int[] popElements(int[] arr, int x) {
		
		int[] arrRemoved = new int[x];
		
		//New size of the array
		for(int i = 0; i < x ;i++) {
			arrRemoved[i] = arr[i];
		}
		
		//Mark item for removal
		int largest = - 1;
		for(int val : arrRemoved) {
			if(val > largest) {
				largest = val;
			}			
		}
		
		//Remove the largest item
		int[] newArray;
		if(largest != -1) {
			newArray = new int[x-1];
			for (int i = 0; i < arrRemoved.length ; i++) {
				if(arrRemoved[i] != largest) {
					newArray[i] = arrRemoved[i];
				}
			}
			
		}else {
			newArray = arrRemoved;
		}
		
		//Update the remains values subtract one
		for(int i = 0; i < newArray.length;i++) {
			if(newArray[i]-1 > 0 ) {
				newArray[i] = newArray[i]-1;
			}
		}
		
		int index = 0;
		for(int i = arr.length; i > x ; i --) {
			arrRemoved[index] = arr[i-1];
			index++;
		}
		//Puting back the values of the array
		
		
		return arrRemoved;
	}

	
	int[] fisrtInteration(int[] arr, int x) {
		int[] tempArr = new int[x];
		
		//New size of the array
		
		int largest = - 1;
		
		for(int i = 0; i < x ;i++) {
			if(arr[i] > arr[i] - 1) {
				tempArr[i] = arr[i] - 1;			
			}else {
				tempArr[i] = arr[i];
			}
			
			if (tempArr[i] > largest ) {
				largest = tempArr[i];
			}
			
			arr[i] = -1;
		}
		
		//Recreating the array
		int[] newArray = new int[arr.length-1];
		
		for(int i = 0; i < arr.length; i++ ) {
			int posBack = (arr.length - i)-1; 
			
			//Put the values not changed first
			if(arr[posBack] != -1) {
				newArray[i] = arr[posBack]; 
			
			//See if is possible to add the value
		    //Remove the largest
			}else if(tempArr[i-1] != largest ) {
				newArray[i] = tempArr[i-1];
			}
		}
		
		return newArray;
		
	}
	
	int[] findPositions(int[] arr, int x) {
		// Write your code here

		// First a I ll loop throw the interation
		//for (int i = 0; i < x; i++) {
		return	fisrtInteration(arr, x);
		//}

		//return new int[1];
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
