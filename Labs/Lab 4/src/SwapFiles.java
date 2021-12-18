import java.io.*;
import java.util.Scanner;

public class SwapFiles {

    /**
     * This method takes in a string and processes it, removing all punctuation and symbols.
     *
     * @param s string to be processed
     * @return plaintext string.
     */
    public static String cleanString(String s) {

        return s.replaceAll("(^A-Za-z0-9)", "")
                .replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .replace("]", "")
                .replace(".", "")
                .replace("'", "")
                .replace(";", "")
                .replace(":", "")
                .replace("!", "")
                .toLowerCase();
    }

    /**
     * This method reads in from text file and prints out every fifth word.
     */
    public static void printFifth() {
        try {
            Scanner input = new Scanner(new File("file.txt"));
            int count = 0;

            //while scanner has an input, increment counter. If counter == 5, print out word and reset counter
            while (input.hasNext()) {
                count++;
                String word = cleanString(input.next());

                if (count == 5) {
                    System.out.println(word);
                    count = 0;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }

    }

    /**
     * This method takes creates a user specified amount of text files, takes in a string and splits the string evenly
     * among every created text file.
     * @param input String to be split among files
     * @param numFiles number of files to be created
     * @throws IOException printwriter fails
     */
    @SuppressWarnings("MismatchedReadAndWriteOfArray")
    public static void wordsToFile(String input, int numFiles) throws IOException {
        String[] inputArr = input.split(" ");

        //Create file array, string array and print writer with size from user input
        File[] fileArr = new File[numFiles];
        String[] stringArr = new String[numFiles];
        PrintWriter[] pwArr = new PrintWriter[numFiles];

        //Populate the file arrays with desired number of elements.
        for (int i = 0; i < fileArr.length; i++) {
            fileArr[i] = new File("file" + i + ".txt");
            stringArr[i] = " ";
            pwArr[i] = new PrintWriter("file" + i + ".txt", "UTF-8");
        }

        //Populate each element of the string array with even proportion of words.
        for (int i = 0; i < inputArr.length; i++) {
            int mod = i % numFiles;

            stringArr[mod] = stringArr[mod] + " " + inputArr[i];
        }

        //Write the strings to files using printWriter array.
        for (int i = 0; i < stringArr.length; i++) {
            pwArr[i].println(stringArr[i]);
            pwArr[i].close();
        }

    }

    /**
     * This method reads a file and concatenates the words in said file into a string.
     * @param s path of file to be read
     * @return string of file contents
     */
    private static String fileToString(String s) {
        StringBuilder textString = new StringBuilder();

        //Take all words from file, process them and concatenate them into a string.
        try {
            Scanner sc = new Scanner(new File(s));
            while (sc.hasNext()) {
                textString.append(" ").append(sc.next());
            }
        } catch (Exception e) {
            System.out.println("Could not read file");
            e.printStackTrace();
        }
        textString = new StringBuilder(cleanString(textString.toString()));
        return String.valueOf(textString);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter file path and name, including file extension: (default is file.txt)");
        String textString = fileToString(sc.nextLine());

        //Lab 4.1 Print every fifth word of file into console
        printFifth();

        // Lab 4.2 create an array of 5 files and put 1/5th of the words in each file.
        System.out.println("How many files would you like to create :");
        wordsToFile(textString, sc.nextInt());

    }


}
