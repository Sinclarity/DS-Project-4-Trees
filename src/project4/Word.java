//Project 4
//Description: Word, finds word and count
//Author: Peter Schurhammer

package project4;

public class Word extends KeyedItem<String> {

    // declare variables
    private String word; // Word is a sequence of alphabetic
    // characters converted to uppercase
    // the word is the searchKey
    private int count = 1; // the number of occurences of a particular
    // word in an input text file

    public Word(String searchWord, int newCount) {
        super(searchWord); // makes the word the searchKey
        count = newCount;
    } //end constructor

    // getters and setters
    public String getWord() {
        return word;
    } //end getWord

    public void setWord(String word) {
        this.word = word;
    } //end setWord

    public int getCount() {
        return count;
    } //end getCount

    public void setCount(int count) {
        this.count = count;
    } //end setCount

    @Override
    public String toString() {
        return String.format(" ",getKey(), count);
    }
} //end Word

