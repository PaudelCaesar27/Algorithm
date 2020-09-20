package lesson9;


import java.util.LinkedList;
import java.util.List;

/**
 This implementation of a BST makes the following assumptions:
 1) Data stored in nodes are of type Integer
 2) No duplicate values are inserted. 
 */
public class MyBST {
	private Node root;
	

	//start with an empty tree
	public MyBST() {
		root = null;
	}
	
	//searching
	
	/** Recursive find */
	public boolean find(Integer x) {
		if(x==null) return false;
		return find(x,root);
	}	
	private boolean find(Integer x, Node n){
		if(n == null) return false;
		if(n != null && n.element.equals(x)) return true;
		return (x.compareTo(n.element) < 0) ?
				find(x,n.left) :
				find(x,n.right);
		
	}
	private Node findNode(Integer val) {
		return findNode(val,root);
	}
	private Node findNode(Integer val,Node n) {
		if(n == null) return null;
		if(n != null && n.element.equals(val)) return n;
		if(val.compareTo(n.element)<0) {
			return findNode(val,n.left);
		}
		else {
			return findNode(val,n.right);
		}
	}
	
	public Integer findMin() {
		return findMin(root);
	}
	
	private Integer findMin(Node t) {
		Node s = findMinNode(t);
		return s.element;
	}
	/** Iterative procedure for finding min node */
	private Node findMinNode(Node t) {
		if(t==null) return null;
		while(t.left != null) {
			t = t.left;
		}
		return t;
	}
	
	
	// Insertion
	
	/** Insertion done recursively. 
	 *  Creates new root with input value x if root is null
	 *  Otherwise, inserts recursively into left or right subtree of root
	 */
	public void recInsert(Integer x) {
		if(findNode(x) != null) {
			System.out.println("Value " + x + " is already present on the tree");
			return;
		}
		//now recursively insert x
		if(root == null) {
			root = new Node(x, null, null);
		} else {
			recInsert(x, root);
		}
	}
	/**
	 * Insertions into either left subtree or right subtree of n.
	 * Assumes n != null
	 */
	public void recInsert(Integer x, Node n) {
		if(n == null) {
			System.out.println("Input node in recInsert is null -- error!");
		}
		if(x.compareTo(n.element) < 0) {
			if(n.left == null) n.left = new Node(x, null, null);
			else recInsert(x, n.left);
		} else {  //x.compareTo(n.element) > 0
			if(n.right == null) n.right = new Node(x,null,null);
			else recInsert(x, n.right);
		}
	}
	/** Iterative insertion algorithm */
	public void insert(Integer x) {
		if (root == null) {
			root = new Node(x, null, null);
		}
		else {
			Node n = root;
			boolean inserted = false;
			while(!inserted){
				if(x.compareTo(n.element)<0) {
					//space found on the left
					if(n.left == null){
						n.left = new Node(x,null,null);
						inserted = true;
					}
					else {
						n = n.left;
					}
				}
				
				else if(x.compareTo(n.element)>0){ 
					//space found on the right					
					if(n.right==null){
						n.right = new Node(x,null,null);
						inserted = true;
					}
					else {
						n = n.right;
					}
				}
                else { //duplicate value
                    throw new IllegalArgumentException("Duplicate value passed in!");
                }				
			}
		}
	}	
	
	// Deletion
	
		/** Removes by first locating the node to be removed and then
		 *  performing one of the three removal procedures
		 */
		public boolean remove(Integer val) {
			
			Node node = findNode(val,root);
			return removeNode(node);
			
			
		}
		private boolean removeNode(Node node) {
			if(node == null) return false;
			//in this case, we can just break the link
			//from node to its parent
			if(node.left == null && node.right== null) {
				Node parent = parent(node);
				if(parent != null) {
					if(parent.left == node) parent.left = null;
					if(parent.right == node) parent.right = null;
				}
				node = null;
				return true;
			}
			//in these cases, add a link from parent to 
			//child of node
			if( node.left != null && node.right == null ){
				Node parent = parent(node);
				if(parent.left == node) parent.left = node.left;
				if(parent.right == node) parent.right = node.left;
				node = null;
				return true;
			}
			if( node.left == null && node.right != null ){
				Node parent = parent(node);
				if(parent.left == node) parent.left = node.right;
				if(parent.right == node) parent.right = node.right;
				node = null;
				return true;
			}	
			
			//in this case, find min to the right of node and
			//insert this value into the node; link up parent of this min with right child
			//of this min
			
			
			if(node.left != null && node.right != null) {
				Node min = findMinNode(node.right);
				Node parentOfMin = parent(min);
				node.element = min.element;			
				parentOfMin.right = min.right;
				return true;
			}
			return false;
		}
		
		/* Used by removeNode */
		private Node parent(Node t) {
			if(t==root || t == null) return null;
			return parent(t, root);
		}
		
		/* Seeking parent of t by starting from root. 
		 * The Node above is always between root and t so is never null.
		 * When t is found to be left or right child of above, the node above 
		 * is returned.
		 */
		private Node parent(Node t, Node above) {
			if(above.left == t || above.right == t) return above;
			if(t.element.compareTo(above.element) < 0) {
				return parent(t, above.left);
			} else { //t.element.compareTo(above.element) > 0
				return parent(t, above.right);
			}
		}
	
	
	// Printing or saving tree values in a list
	
	/**
	 * Recursively prints the values in the nodes of the tree in sorted order.
	 */
	public void printTree() {
		if (root == null)
			System.out.println("Empty tree");
		else
			printTree(root);
	}
	
	/** 
	 * Recursively outputs tree values into a list
	 */
	public List<Integer> asList() {	
		return asList(new LinkedList<Integer>(), root);		
	}

	private void printTree(Node t) {
		if (t != null) {
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}
	private List<Integer> asList(List<Integer> theList, Node t) {
		if(theList == null) return theList;
		if(t == null) return theList;
		if(t != null) {
			asList(theList, t.left);
			theList.add(t.element);
			asList(theList, t.right);
		}
		return theList;
	}
	
	
	// Main method
	public static void main(String[] args){
		MyBST bst = new MyBST();
		bst.insert(10);
		bst.insert(5);
		bst.insert(15);
		bst.insert(12);
		bst.insert(26);
		bst.insert(13);
		bst.printTree();
		System.out.println();
		
		MyBST bst2 = new MyBST();
		bst2.recInsert(10);
		bst2.recInsert(5);
		bst2.recInsert(15);
		bst2.recInsert(12);
		bst2.recInsert(26);
		bst2.recInsert(13);
		bst2.printTree();
		System.out.println();
		bst.remove(26);	
		bst.remove(12);
		bst.remove(15);
		bst.printTree();
		System.out.println();
//		
//		bst.insert(21);
//		bst.insert(24);
//		bst.insert(22);
//		System.out.println(bst.asList());
//		//bst.printTree();
//		System.out.println();
//		bst.remove(26);
//		
//		bst.printTree();
		/*
		MyBST bst = new MyBST();
		bst.insert(10);
		bst.insert(9);
		bst.insert(8);
		MyBST.Node nine = bst.findNode(8);
		MyBST.Node ten = bst.findNode(10);
		System.out.println(ten == bst.parent(nine));
		*/
		/*
		MyBST bst = new MyBST();
		for(int i = 15; i >= 0; --i){
			bst.insert(new Integer(2*i));
			bst.insert(new Integer(2*i - 5));
		}
		bst.printTree();
		System.out.println("Is 24 in the tree? "+bst.find(new Integer(24)));
		System.out.println("Is 27 in the tree? "+bst.find(new Integer(27)));
		//System.out.println("Next larger Node than -5 is "+bst.findNextLargerNode(-5));
		*/
	}

	class Node {

		// Constructors
		Node(Integer theElement) {
			this(theElement, null, null);
		}

		Node(Integer element, Node left, Node right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}
		public String toString() {
			return element.toString();
		}
		private Integer element; // The data in the node
		private Node left; // Left child
		private Node right; // Right child
	}
}