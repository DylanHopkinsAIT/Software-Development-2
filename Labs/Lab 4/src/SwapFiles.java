import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class SwapFiles {

    /**
     * This method takes a string array and prints out every 5th element in the array.
     *
     * @param everyFifth String to be converted.
     */
    public static void printFifth(String [] everyFifth) {

        //Loop through array, if array index is divisible by 5 evenly, print it.
        for (int wordCount = 1; wordCount < everyFifth.length; wordCount++) {

            if (wordCount % 5 == 0) {
                System.out.println(everyFifth[wordCount]);
            }
        }
    }

    /**
     * Method to remove punctuation chars from a String and converts to all lowercase for processing.
     *
     * @param s String to be 'cleaned'
     * @return 'cleaned' String
     */
    public static String cleanString(String s) {

        return s.replace(",", "").replace("'", "").toLowerCase()
                .replace(".", "").replace("!", "").replace(": ", "");

    }

    /**
     * Method to create a file array of arbitrary size, containing empty text files in each array index.
     *
     * @return File array of desired size
     */
        File[] fileArr = new File[a];                   //File array to be returned

        for (int i = 0; i < a; i++) {
            try {
                File createFile = new File("C:\\Users\\A00284332\\OneDrive - Athlone Institute Of Technology\\Modules\\Year 2\\Software Development 2\\Labs\\Lab 4\\src\\file" + i + ".txt");
                if (createFile.createNewFile()) {
                    System.out.println("File created: " + createFile.getName());
                    fileArr[i] = createFile;
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error has occurred.");
                e.printStackTrace();
            }
        }
        return fileArr;
    }

    public static void oneFifth(File[] f, String [] s){
        for (int i = 0; i < s.length; i++){


        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File textFile = new File("\\file.txt");
        Scanner readFile = new Scanner(textFile);
        String [] inputString = cleanString(readFile.nextLine()).split(" ");

        //Lab 4.1 - Read in text file and print out every 5th word.
        //printFifth(inputString);

        //Lab 4.2 - Create an array of 5 files, put one fifth of the words from the text file in each file.
        File [] fileArray = createFileArr(5);
        oneFifth(fileArray,inputString);







    }
}
