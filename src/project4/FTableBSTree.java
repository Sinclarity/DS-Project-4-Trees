//Project 4
//Description: BST part of the program
//Just like FTableArray, got this from the book and modified it to my own
//Author: Peter Schurhammer

package project4;


import java.util.ArrayList;
import java.util.List;

public class FTableBSTree<T extends KeyedItem<KT>,
        KT extends Comparable<? super KT>>
        extends BinaryTreeBasis<T> implements Interface<T, KT> {

    //variables
    private int size;
    private int numOfComps;
    public FTableBSTree() {
    } // end default constructor

    public FTableBSTree(KeyedItem rootItem) {
        super(rootItem);
    } // end constructor

    public void setRootItem(KeyedItem newItem) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    } // end setRootItem

    @Override
    public int size() {
        return size;
    }

    public void insert(KeyedItem newItem) {
        numOfComps = 0;
        root = insertItem(root, newItem);
        size++;
    } // end insertItem

    public int retrieve(Comparable searchKey) {
        numOfComps = 0;
        return retrieveItem(root, searchKey);
    } //end retrieve

    @Override
    public int getNumOfComps() {
        return numOfComps;
    }

    @Override
    public void saveFTable(String filename) {
        List<String> temp = new ArrayList<String>();
        List<String> temp2 = inorderRec(root,temp);

        //finds and deletes duplicate words in the temp list
        for(int i=0;i<temp.size();i++){
            for(int j=i+1;j<temp.size();j++) {
                if (temp.get(i).equals(temp.get(j))) {
                    temp.remove(j);
                    j--;
                } //end if
            } //end for
        } //end for

        for (String key: temp2) {
            System.out.print(key + " ");
            System.out.println(this.retrieve(key));
        } //end foreach
    } //end saveFTable

    //insertItem method to push into file
    protected TreeNode<T> insertItem(TreeNode<T> tNode, KeyedItem newItem) {
        numOfComps++;
        TreeNode<T> newSubtree;
        Comparable searchKey = newItem.getKey();
        if(tNode == null) {
            // position of insertion found; insert after leaf
            // create a new node
            tNode = new TreeNode<T>(newItem, null, null);
            return tNode;
        } // end if

        KeyedItem nodeItem = tNode.item;
        // search for the insertion position
        if (newItem.getKey().compareTo(nodeItem.getKey()) < 0){
            //search the left subtree
            newSubtree = insertItem(tNode.leftChild, newItem);
            tNode.leftChild = newSubtree;
            return tNode;
        } //end if
        else {
            // search the right subtree
            newSubtree = insertItem(tNode.rightChild, newItem);
            tNode.rightChild = newSubtree;
            return tNode;
        } // end else
    } // end insertItem

    //grabbing specific searchKey
    protected int retrieveItem(TreeNode<T> tNode, Comparable searchKey) {
        numOfComps++;
        KeyedItem treeItem;
        int count = 0;
        if(tNode == null) {
            return 0;
        } //end if
        else {
            KeyedItem nodeItem = tNode.item;
           if(searchKey.compareTo(nodeItem.getKey()) == 0) {
                // item is in the root of some subtree
                count += 1;
                count += retrieveItem(tNode.rightChild, searchKey);
            } //end if
            else if (searchKey.compareTo(nodeItem.getKey()) < 0) {
                // add the number of nodes in the left subtree
                count += retrieveItem(tNode.leftChild, searchKey);
            } //end else if
            else {
                // add the number of nodes in the right subtree
                count += retrieveItem(tNode.rightChild, searchKey);
            } // end else
        } //end if
        return count;
    }// end retrieveItem

    // A utility function to
    // do inorder traversal of BST
     List<String> inorderRec(TreeNode root, List<String> temp) {
        if (root != null) {
            inorderRec(root.leftChild, temp);
            temp.add(root.item.getKey().toString());
            inorderRec(root.rightChild, temp);
        } //end if
        return temp;
    } //end inorderRec
} // end BinarySearchTree