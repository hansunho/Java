package binarySearchTree;

public class BSTree<E extends Comparable> {

	private TreeNode root;

	BSTree() {
		root = null;
	}

	public void insert(E newEntry) {
		if (root == null)
			root = new TreeNode(newEntry);
		else {
			TreeNode ptr = root; // pointer to node in search for leaf
			while (ptr != null) {// search for leaf
				if (newEntry.compareTo(ptr.getData()) < 0) {
					// insert on left of given node
					if (ptr.getLeft() == null) {
						// when at end of tree, insert
						ptr.setLeft(new TreeNode(newEntry));
						return;
					} else
						// move left in tree and continue search
						ptr = ptr.getLeft();
				} else {
					// insert on right of given node
					if (ptr.getRight() == null) {
						// when at end of tree, insert
						ptr.setRight(new TreeNode(newEntry));
						return;
					} else
						// move right in tree and continue search
						ptr = ptr.getRight();
				}
			}

			// insertion should be done by now!!
			// exception could be thrown or error message printed here!!
		}
	}

	public void print() {
		System.out.println("Directory Listing");
		printKernel(root);
		System.out.println();
		System.out.println("End of Listing");
	}

	private void printKernel(TreeNode<E> base) {
		// to print elements in a tree (using an in-order traversal),
		// print the left subtree
		// print the elements in a node
		// print the right subtree
		if (base != null) {
			printKernel(base.getLeft());
			System.out.print(base.getData());
			printKernel(base.getRight());
		}
	}

	// http://stackoverflow.com/questions/4531449/height-of-a-binary-tree

	public int height(TreeNode item) {
		// Once the item is null return
		if (item == null) {

			return 0;
		}
		// Keep adding one as long as will still have further to go
		return 1 + Math.max(height(item.getRight()), height(item.getLeft()));
	}

	
	
	//counts how many times computeSubtreeHeightsHelper is processed
	static int testingIndex=0;
	
	public static void computeSubtreeHeights(TreeNode name) {
		computeSubtreeHeightsHelper(name);
	}

	public static int computeSubtreeHeightsHelper(TreeNode item) {

		if (item == null)
			return 0;
		
		else{
		
			int temp = (1 + Math.max(computeSubtreeHeightsHelper(item.getRight()),
					computeSubtreeHeightsHelper(item.getLeft())));
			item.setTreeHeight(temp-1);
			System.out.println("number of process: "+testingIndex++);
			return temp;
		}
	

	}

	//http://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
	public static void printBinaryTree(TreeNode root, int level){
	    if(root==null)
	         return;
	    printBinaryTree(root.right, level+1);
	    if(level!=0){
	        for(int i=0;i<level-1;i++)
	            System.out.print("|\t");
	            System.out.println("|-------"+root.getData() +"("+ root.treeHeight+")");
	    }
	    else
	        System.out.println(root.getData() +"("+ root.treeHeight+")");
	    printBinaryTree(root.left, level+1);
	}    
	
	public static void main(String[] args) {
		BSTree<Integer> myTree = new BSTree<Integer>();	
		myTree.insert(18);
		myTree.insert(10);
		myTree.insert(28);
		myTree.insert(4);
		myTree.insert(15);
		myTree.insert(20);
		myTree.insert(30);
		myTree.insert(19);
		myTree.insert(25);
		System.out.println("before computeSubtreeHeights");
		printBinaryTree(myTree.root,0);
		System.out.println();
		System.out.println();
		System.out.println();
		computeSubtreeHeights(myTree.root);			
		System.out.println("After computeSubtreeHeights");
		printBinaryTree(myTree.root,0);

	}

}
