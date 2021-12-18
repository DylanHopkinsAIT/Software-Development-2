import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class jumbleLetters {

    /**
     * Method to take in a String array and jumble it, leaving the first and last characters untouched.
     *
     * @param textFile String[] to be jumbled
     * @return jumbled String.
     */
    public static String jumble(String[] textFile) {
        StringBuilder returnString = new StringBuilder();

        for (String s : textFile) {
            int wordLength = s.length();

            if (wordLength > 3) {

                //Convert the current index of textFile array to string
                String innerLetters = s;

                //Pull the first and last letters from string
                char firstLetter = innerLetters.charAt(0);
                char lastLetter = innerLetters.charAt(innerLetters.length() - 1);

                //Remove first and last letters from innerLetters string
                innerLetters = innerLetters.substring(1, innerLetters.length() - 1);
                int innerLetterIndex = innerLetters.length() - 1;

                //Create a random number to pass to 'swap method' (int) is casting double as int. (2.5 = 2)etc.
                int randomNumber = (int) (Math.random() * innerLetterIndex);

                //Character array of the inner letters only
                char[] letterArray = innerLetters.toCharArray();

                //Swap around the inner letters
                String temp = swap(letterArray, innerLetterIndex, randomNumber);

                //Remove any unnecessary characters from temp
                String finalInner = temp.replaceAll("(^A-Za-z0-9)", "")
                        .replace(",", "")
                        .replace("[", "")
                        .replace("]", "")
                        .replace(" ", "");

                //Put rebuild jumbled string, replace first and last letter
                String rebuildString = firstLetter + finalInner + lastLetter + " ";

                //Add word onto final string
                returnString.append(rebuildString);

            } else {
                //Add word onto final string
                returnString.append(s).append(" ");
            }

        }
        return returnString.toString();
    }

    /**
     * Method to swap around the center characters in a char array
     *
     * @param s char array to be 'swapped'
     * @param i index number of char array to be swapped with. (use either a Math.random() number or for loop index)
     * @param j second index number of char array to be swapped with. (use either a Math.random() number or for loop index)
     * @return character array with letters swapped
     */
    public static String swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;

        return Arrays.toString(s);
    }

    /**
     * Method to count number of vowels in string.
     *
     * @param s string with vowels to be counted.
     * @return number of vowels in string.
     */
    public static double getVowels(String s) {
        int numVowels = 0;                          //Counter for vowels
        s = s.toLowerCase();                        //Make string lowercase because I'm lazy

        for (char c : s.toCharArray()) {
            //If letter is vowel, increment counter...
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                numVowels++;
            }
        }
        return numVowels;
    }

    /**
     * Method to count the number of words in a given string.
     *
     * @param s String of words to be counted
     * @return Number of words in string.
     */
    public static double countWords(String s) {
        int wordCount = 0;

        boolean word = false;
        int end = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {

            //If char is a letter - true
            if (Character.isLetter(s.charAt(i)) && i != end) {
                word = true;

                //If char not letter & has letters before - increment
            } else if (!Character.isLetter(s.charAt(i)) && word) {
                wordCount++;
                word = false;

                //If is last word of string
            } else if (Character.isLetter(s.charAt(i)) && i == end) {
                wordCount++;
            }
        }
        return wordCount;
    }

    /**
     * This method takes a String, removes any punctuation characters, breaks it down in to individual words and
     * packages it into a String[] containing each individual cleaned word
     *
     * @param s String to be cleaned
     * @return String[] containing words
     */
    public static String[] cleanString(String s) {

        return s.replace(",", "").replace("'", "").toLowerCase()
                .replace(".", "").replace("!", "").split(" ");

    }

    public static void main(String[] args) throws FileNotFoundException {
        //Create instance of file and scanner to read file.
        File f = new File("file.txt");
        Scanner sc = new Scanner(f);
        String textFile = sc.nextLine();

        //Lab 3.1 - Count number of words in text file
        System.out.println("Number of words in this file: " + countWords(textFile));

        //Lab 3.2 - Count number of vowels & avg number vowels per word
        System.out.println("Number of vowels in this file:" + getVowels(textFile));
        System.out.println("Average number of vowels per word: " + getVowels(textFile) / countWords(textFile));

        //Lab 3.3 - we do some Jumbling 😎
        String[] toBeJumbled = cleanString(textFile);
        String hasBeenJumbled = jumble(toBeJumbled);
        System.out.println(hasBeenJumbled);

    }
}

