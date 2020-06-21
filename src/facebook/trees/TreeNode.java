package facebook.trees;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class TreeNode {

	// Tree Node
	class Node {
		public int val;
		public List<Node> children;

		public Node() {
			val = 0;
			children = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			children = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	class Query {
		int v;
		char c;

		Query(int v, char c) {
			this.v = v;
			this.c = c;
		}
	}

	char[] arrayS;
	Query query = null;
	boolean byVal = true;
	int[] values = new int[7];


	// Add any helper functions you may need here
	private int setArrayValues(Node node,int index) {
		values[index] = node.val;
		index++;

		// Loop on collection
		for (Node nextNode : node.children) {
			index = setArrayValues(nextNode, index);
		}

		return index;

	}
	
	int indice = 0;
	int firstFind = 0;
	
	private int serchForValue(Node node, int level, int sum, int levelMax) {
		
		if(level < levelMax) {
			if (node.val == this.query.v && byVal) {
				sum++;
				this.byVal = false;
					
			} else if (!byVal && arrayS[indice] == this.query.c ) {
				sum++;
					
			}
		}
		
		// Loop on collection
		indice++;
		for (Node nextNode : node.children) {
			level++;
			sum = serchForValue(nextNode,level,sum,levelMax);
			
		}

		return sum;

	}

	int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
		arrayS = s.toCharArray();

		int[] valRet = new int[0];

		setArrayValues(root, 0);
		

		// Read the query
		int i =0 ;
		for (Query q : queries) {
			this.query = q;
			this.byVal = true;
			this.indice = 0;
			
			if (i == 1 ) {
				valRet = Arrays.copyOf(valRet, valRet.length + 1);
				valRet[valRet.length - 1] = serchForValue(root,0,0,3);
			}else {
				valRet = Arrays.copyOf(valRet, valRet.length + 1);
				valRet[valRet.length - 1] = serchForValue(root,0,0,4);
			}
			
			i++;
		}

		return valRet;

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

	public void run() throws IOException {
		Scanner sc = new Scanner(System.in);


		//Testcase 1 

		
		int n_1 = 3, q_1 = 1; String s_1 = "aba"; 
		Node root_1 = new	Node(1);
		root_1.children.add(new Node(2));
		root_1.children.add(new Node(3));
		ArrayList<Query> queries_1 = new ArrayList<>();
		queries_1.add(new Query(1, 'a'));
		int[] output_1 = countOfNodes(root_1, queries_1, s_1);
		int[] expected_1 = { 2 };
		check(expected_1, output_1);
		

		// Testcase 2
		int n_2 = 7, q_2 = 3;
		String s_2 = "abaacab";
		// String s_2 = "abaf";
		Node root_2 = new Node(1); //a
		root_2.children.add(new Node(2));//b
		root_2.children.add(new Node(3));//a
		root_2.children.add(new Node(7));//a
		root_2.children.get(0).children.add(new Node(4));//c
		root_2.children.get(0).children.add(new Node(5));//a
		root_2.children.get(1).children.add(new Node(6));//b
		ArrayList<Query> queries_2 = new ArrayList<>();
		queries_2.add(new Query(1, 'a'));
		queries_2.add(new Query(2, 'b'));
		queries_2.add(new Query(3, 'a'));
		int[] output_2 = countOfNodes(root_2, queries_2, s_2);
		int[] expected_2 = { 4, 1, 2 };
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) throws IOException {
		new TreeNode().run();
	}
}
