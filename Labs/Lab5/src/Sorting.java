import java.io.File;
import java.util.Scanner;

public class Sorting {

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

    public static void sort(int [] input)
    {
        for(int i = 0; i < input.length - 1; i++)
        {
            int leastIndex = i;

            for(int j = i+1; j < input.length; j++)
            {
                if(input[j] < input[leastIndex])
                {
                    leastIndex = j;
                }

            }
            if (leastIndex != i) {
                swap(input, i, leastIndex);
            }
        }

        for(int i : input)
        {
            System.out.println(i);
        }
    }

    public static void sort(String [] inputArr)
    {
        for(int i = 0; i < inputArr.length - 1; i++)
        {
            int leastIndex = i;

            for(int j = i+1; j < inputArr.length; j++)
            {
                if(inputArr[j].compareTo(inputArr[leastIndex]) > 0)
                {
                    leastIndex = j;
                }

            }
            if (leastIndex != i) {
                swap(inputArr, i, leastIndex);
            }
        }

        for(String i : inputArr)
        {
            System.out.println(i);
        }
    }
    public static void swap(String [] a, int i, int j)
    {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void swap(int [] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {
        Scanner fileIn = new Scanner(System.in);
        System.out.println("Please enter file path and name, including file extension: (default is file.txt)");
        String textString = fileToString(fileIn.nextLine());

        //Lab 5.1 Sort words.
        String [] stringArr = textString.split(" ");
        sort(stringArr);




    }
}
