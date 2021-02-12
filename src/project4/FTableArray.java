//Project 4
//Description: Array based implementation
//Got this example from the book and modified to my own
//Author: Peter Schurhammer

package project4;

import java.util.*;

public class FTableArray <T extends KeyedItem<KT>, KT extends Comparable<? super KT>> implements Interface<T, KT>{
    final int MAX_TABLE = 10000;
    protected ArrayList<Comparable> items;
    private int numOfComps;

    public FTableArray() {
        items = new ArrayList<>(MAX_TABLE);
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    //insert for the KeyedItem
    public void insert(KeyedItem newItem) throws FTableException {
        if(size() < MAX_TABLE){
            numOfComps++;
            items.add(newItem.getKey());
            Collections.sort(items);
        } //end if
    } //end insert

    //grab searchKey
    public int retrieve(Comparable searchKey) {
        //retrieve method
        numOfComps++; //iterate numOfComps
        int i = items.indexOf(searchKey);
        int count = 0;
        if(i>= 0){
            count++;
        } //end if
        i++;
        while(i < items.size()  && items.get(i).compareTo(searchKey) == 0){
            count++;
            i++;
        } //end while
        return count;
    } //end retrieve

    public void saveFTable(String filename) {
        //way to find duplicates but I couldn't get this working like the BSTree class
        for(int i=0;i< items.size();i++){
            for(int j=i+1;j<items.size();j++) {
                if (items.get(i).equals(items.get(j))) {
                    items.remove(j);
                    j--;
                } //end if
            } //end for
        } //end for
        for (Comparable key:items) {
            System.out.print(key.toString() + " ");
            System.out.println(retrieve(key));
        } //end foreach
    } //end saveFTable
    //number of comparisons
    public int getNumOfComps() {
        return numOfComps;
    }
} //end FTableArray
