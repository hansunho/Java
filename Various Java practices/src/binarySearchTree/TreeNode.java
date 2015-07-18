package binarySearchTree;



//Declarations for a typical tree-node class
//For a binary search tree, data in nodes must have a comesBefore method
//as well as an equal method.  This node therefore uses the Entry class 
//for data storage.

import java.lang.Comparable;

public class TreeNode <E extends Comparable> {

protected E data;      // the information to be stored in the node
protected TreeNode left;   // the pointer to the node's left subtree
protected TreeNode right;  // the pointer to the node's right subtree
protected int treeHeight; //the height of the subtree based at each node
// Constructors
public TreeNode (E startingData) {
   data = startingData;
   left = null;
   right = null;
   treeHeight=-1;
}

public TreeNode (E initData, TreeNode leftNode, TreeNode rightNode) {
   data = initData;
   left = leftNode;
   right = rightNode;
   treeHeight= -1;
}

// extractors
public E getData () {
   return data;
}

public int getTreeHeight() {
	return treeHeight;
}

public void setTreeHeight(int treeHeight) {
	this.treeHeight = treeHeight;
}

public TreeNode getLeft () {
   return left;
}

public TreeNode getRight () {
   return right;
}

// modifiers
public void setData (E newData) {
   data = newData;
}

public void setLeft (TreeNode newLeft) {
   left = newLeft;
}
public void setRight (TreeNode newRight) {
   right = newRight;
}
} // TreeNode
