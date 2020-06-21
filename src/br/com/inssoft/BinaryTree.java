package br.com.inssoft;

public class BinaryTree {

	private int value;
	private BinaryTree leftNode = null;
	private BinaryTree rightNode = null;
	
	private static String LEFT = "L";
	private static String RIGHT = "R";
	

		
	public static void main(String[] args) {
		
		BinaryTree root = new BinaryTree(10);
		
		BinaryTree node = root.inserNode(root, 20, LEFT);
		node.inserNode(root, 30, RIGHT);
		
		node.inserNode(node, 40, LEFT);
		node.inserNode(node, 50, RIGHT);
		
		
		root.loopThrowTree(root);

	}
	
	public BinaryTree(int value ) {
		this.value = value;
	}
	
	public BinaryTree inserNode(final BinaryTree parent, final int value, final String pos) {
		final BinaryTree treeNode = new BinaryTree(value) ;
		
		if (LEFT.equals(pos)) {
			parent.leftNode = treeNode;
		}
		
		if (RIGHT.equals(pos)) {
			parent.rightNode = treeNode;				
		}
		
		return treeNode;
	}
	
	
	public void loopThrowTree(BinaryTree node){

		if (node.leftNode != null && node.rightNode != null){
			System.out.println("parent : " + node.value);
			System.out.println("Value left: " + node.leftNode.value);
			System.out.println("Value right: " + node.rightNode.value);
			
		} else {
			
			if (node.leftNode != null) {
				System.out.println("Value: " + node.value);
			}
			
			if (node.rightNode != null) {
				System.out.println("Value: " + node.value);
			}
		}
		
		if (node.leftNode != null) {
			node.loopThrowTree(node.leftNode);
		}
		
		if (node.rightNode != null) {
			node.loopThrowTree(node.rightNode);			
		}
		
	
	}
	


}
