// Interface.java
// Interface for the project
// By: Peter Schurhammer

package project4;

public interface Interface<T extends KeyedItem<KT>, KT extends Comparable <? super KT>> {

    public int size();
    // Determines the size of the table

    public boolean isEmpty();
    // Determine whether the table is emppty.

    public void insert(KeyedItem newItem) throws FTableException;
    // Inserts a newItem to the table.If newItem is already in the table, increment its count.Otherwise
    // newItem is inserted to the table with the count 1.Set the number of comparisons required for this task
    // accordingly.Throws FTableException if frequency tableisfull.

    public int retrieve(Comparable searchKey);
    // Retrieves the count of an item with a given serachKey.
    // Return 0 if not found.Set the number of comparisons required for this task accordingly.

    public void saveFTable(String filename);
    // Saves thewords and their frequencies in the table in theoutput
    // file filename in the ascendingorderbased on the searchKey

    public int getNumOfComps();
    // Returns the number of key comparisons required to perform a particular frequency table operation.(In realitythis
    // operation mightnot be anoperation of ADT frequency table.It is included to obtain the statistics of comparisons.)
}
