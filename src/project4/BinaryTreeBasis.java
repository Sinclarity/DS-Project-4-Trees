//Project 4
//Description: Binary Search Tree Basis, helps with BST
//Used this from the previous project
//Author: Peter Schurhammer

package project4;

public abstract class BinaryTreeBasis<T> {

    protected TreeNode<T> root;

    public BinaryTreeBasis() {
        root = null;
    }  // end default constructor

    public BinaryTreeBasis(KeyedItem rootItem) {
        root = new TreeNode<T>(rootItem, null, null);
    }  // end constructor

    public boolean isEmpty() {
        // Returns true if the tree is empty, else returns false.
        return root == null;
    }  // end isEmpty

    public void makeEmpty() {
        // Removes all nodes from the tree.
        root = null;
    }  // end makeEmpty

    public KeyedItem getRootItem() throws FTableException {
        // Returns the item in the tree's root.
        if (root == null) {
            throw new FTableException("TreeException: Empty tree");
        }
        else {
            return root.item;
        }  // end if
    }  // end getRootItem

    public abstract void setRootItem(KeyedItem newItem);
    // Throws UnsupportedOperationException if operation
    // is not supported.

}  // end BinaryTreeBasis