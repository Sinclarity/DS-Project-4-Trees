// Project 4
// Driver program
// By: Peter Schurhammer

package project4;

import java.io.*;
import java.util.*;

public class Driver {

    static FTableArray table = new FTableArray();
    static FTableBSTree bst = new FTableBSTree();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //user input for the file
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input filename with the format 'src\\project4\\yourfilename.txt': " );
        String filename = scanner.nextLine();
        File inputFile = new File(filename);
        Scanner reader = new Scanner(inputFile);

        String space = " ";       //formatting
        String temp = "[.,!]";    //cuts off unneeded punctuation
        Word word;

        //arraylist to trim the words
        ArrayList<String> wordList = new ArrayList<>();
        while(reader.hasNext()) {
            String stopWord = reader.next().trim();
            wordList.add(stopWord.toLowerCase().replaceAll(temp, space).trim());
        } //end while

        //pump into filename (insert)
        reader = new Scanner(new File(filename));
        while(reader.hasNext()) {
            int count = 1;
            String nextWord = reader.next().toLowerCase().replaceAll(temp, space).trim();
            word = new Word(nextWord, count);
            bst.insert(word);
            table.insert(word);
        } //end while

        //showing the outputs of both classes with the file name
        System.out.println("Format using FTableArray:");
        table.saveFTable(filename);
        System.out.println("\n");
        System.out.println("Format using FTableBSTree:");
        bst.saveFTable(filename);


        Scanner userInput = new Scanner(System.in);
        int choice;

        do { //do while for the switch
            System.out.println("\nChoose from the following options...");
            System.out.println("1) Display number of comparisons");;
            System.out.println("2) Find a word from Binary Search Tree");
            System.out.println("3) Find a word from Array Based");
            System.out.println("4) Enter a word to insert into the table");
            System.out.println("5) Exit the program.");
            choice = userInput.nextInt();

            //switch statement for the user
            switch(choice) {
                case 1:  //Number of comparisons for both of the classes
                    System.out.println("The number of comparisons in Binary Search Tree: " + bst.getNumOfComps());
                    System.out.println("The number of comparisons in Array Based: " + table.getNumOfComps());
                    break;

                case 2:  //search for a keyword from FTableBSTree
                    System.out.println("Please enter the word you are looking for: ");
                    String targetword = userInput.next();
                    System.out.println("Number of times " + targetword + " is found: " +
                            bst.retrieveItem(bst.root, targetword));
                    break;

                case 3:  //search for a keyword from FTableArray
                    System.out.println("Please enter the word you are looking for: ");
                    String targetword2 = userInput.next();
                    System.out.println("Number of times " + targetword2 + " is found: " +
                            table.retrieve(targetword2));
                    break;

                case 4: //insert for both of the tables based on the filename and word
                    System.out.println("Please enter a word to be inserted into the table: ");
                    String insertWord = scanner.next();
                    Word tempObj = new Word(insertWord, 1);
                    bst.insert(tempObj);
                    table.insert(tempObj);
                    break;

                case 5: //end program
                    System.out.println("Ending program.");
                    System.exit(0);
                    break;

                default: //error checking for switch
                    System.out.println("Please enter a valid choice.");
                    break;
            } //end switch
        } while(choice != 5); //number of choices for switch
    } //end main
} //end Driver
