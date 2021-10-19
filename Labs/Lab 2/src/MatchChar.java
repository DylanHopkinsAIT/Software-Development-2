public class MatchChar {

    /**
     * This method takes in a charArray from main and determines the index of a chosen char.
     *
     * @param ca the charArray from main
     * @param c  the char to be indexed
     * @return index of chosen char
     */
    public static int findIndex(char[] ca, char c) {
        //Loop through the char array until a match is found, then let 'a' equal the position of the match.
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] == c) {
                return i;
            }
        }
        return -1;
    }

    /**
     * This method takes a 2D array from main, and indexes it at a given location.
     *
     * @param ca the 2D array from main
     * @param c  the char to be indexed
     * @return the int array for index
     */
    public static int[] findIndex(char[][] ca, char c) {
        int[] returnInt = {-1, -1};

        for (int i = 0; i < ca.length; i++) {
            int rT = findIndex(ca[i], c);

            if (rT != -1) {
                returnInt[0] = i;
                returnInt[1] = rT;
                return returnInt;
            }
        }
        return returnInt;
    }

    /**
     * Takes two character arrays from main, and returns an int array containing the
     * index of the first matching character in each array.
     *
     * @param a First character array.
     * @param b Second character array.
     * @return Matching character.
     */
    public static int[] matchChar(char[] a, char[] b) {
        int[] match = {-1, -1};

        //Nested for loop, Compares first char in 'a' to every char in 'b', then second char in 'a' to all in b... etc.
        for (char firstChar : a) {
            for (char secondChar : b) {
                //If a match is found return the location of the match in each array.
                if (firstChar == secondChar) {
                    match[0] = findIndex(a, firstChar);
                    match[1] = findIndex(b, secondChar);
                    return match;
                }
            }
        }
        return match;
    }

    /**
     * Void method that takes the original char arrays and the int array containing the index of the matching chars
     * and arranges them in their corresponding place on a 2D array and prints out that array.
     *
     * @param a 'first' character array created in main
     * @param b 'second' character array created in main
     * @param c int array of matching chars
     */
    public static void printMatchChar(char[] a, char[] b, int[] c) {
        char[][] table = new char[b.length][a.length];                //2D array to print vertical and horizontal axis'

        //For loop to loop through each array and print them in their corresponding axis, matching on first common char
        for (int i = 0; i < a.length; i++) {

            //Horizontal row on table
            System.arraycopy(a, 0, table[c[1]], 0, a.length);

            //Vertical Column on table
            for (int k = 0; k < b.length; k++) {
                for (int l = 0; l < a.length; l++) {
                    table[k][c[0]] = b[k];
                }
            }
        }

        // Loop to print out the 2D array in a grid format.
        for (char[] chars : table) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int charPos;
        char[] index = "Hello World".toCharArray();                // 1D array to search
        char[][] arr2D = new char[5][5];                           //2D array to search
        arr2D[3][3] = 'h';                                         //Set 3,3 of arr2D to contain char 'h'

        // Lab 2.1 - Search the 1D array for the char 'o'
        charPos = findIndex(index, 'o');
        System.out.println("The character is located at position: " + charPos);

        // Lab 2.2 - Search the 2D array for the char 'h'
        int[] rT = findIndex(arr2D, 'h');
        System.out.println("The character is located at position: " + rT[0] + "," + rT[1]);

        // Lab 2.3 - Create two strings and find the common letter, then join on that common letter
        String first = "Emancipation".toLowerCase();
        String second = "Memoirs".toLowerCase();
        int[] offset = matchChar(first.toCharArray(), second.toCharArray());
        printMatchChar(first.toCharArray(), second.toCharArray(), offset);

    }

}
