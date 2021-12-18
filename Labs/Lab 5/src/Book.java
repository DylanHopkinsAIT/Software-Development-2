import java.util.Scanner;

public class Book {
    public String title;
    private String publisher;
    private String author;
    private int price;
    public static int sortingMethod = 1;

    /**
     * Override toString method to print out book details.
     *
     * @return Title, Author, Publisher, Price
     */
    @Override
    public String toString() {
        return
                "Title: " + this.title + "\n" +
                        "Publisher: " + this.publisher + "\n" +
                        "Author: " + this.author + "\n" +
                        "Price: " + this.price;
    }

    /**
     * Sets sorting method based off integer input.
     *
     * @param i integer input from user
     */
    public void setSortingMethod(int i) {
        sortingMethod = i;
    }

    /**
     * Book constructor
     *
     * @param title     Title of book.
     * @param publisher Publisher of book.
     * @param author    Author of book.
     * @param price     Price of book.
     */
    public Book(String title, String publisher, String author, int price) {
        this.title = (String) validate(title);
        this.publisher = (String) validate(publisher);
        this.author = (String) validate(author);
        this.price = (Integer) validate(price);
    }

    /**
     * This method validates arguments to be non-null or less than zero.
     *
     * @param obj the argument to be validated
     * @return Valid argument || Error if null
     */
    public Object validate(Object obj) {
        if (obj.getClass() == Integer.class) {
            if ((int) obj < 0) {
                throw new IllegalArgumentException("Cannot Be Less than 0");
            }
        }
        if (obj.getClass() == String.class) {
            String s = (String) obj;
            if (s.length() == 0)
                throw new IllegalArgumentException("String Cannot be Null");
        }
        return obj;
    }

    /**
     * This method compares one book to another book
     *
     * @param o book to be compared to
     * @return bigger/smaller (1/0)
     */
    public int compareTo(Book o) {

        switch (sortingMethod) {
            case 1: //If Sorting method is title.
                if (this.title.compareTo(o.title) < 0) {
                    return 1;
                }
                break;
            case 2: //If Sorting method is publisher.
                if (this.publisher.compareTo(o.publisher) < 0) {
                    return 1;
                }
                break;
            default: //If Sorting method is author.
                if (this.price < o.price) {
                    return 1;
                }
                break;
        }

        return 0;
    }

    /**
     * This method swaps the position of 2 books in a book array.
     *
     * @param a book array containing books.
     * @param i position of first book.
     * @param j position of second book.
     */
    public static void swap(Book[] a, int i, int j) {
        Book temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * This method sorts books from lowest value to highest value, lexicographically.
     *
     * @param input the book Array to be sorted.
     */
    public static void sortBooks(Book[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            int leastIndex = i;

            for (int j = i + 1; j < input.length; j++) {
                if (input[j].compareTo(input[leastIndex]) == 1) {
                    leastIndex = j;
                }

            }
            if (leastIndex != i) {
                swap(input, i, leastIndex);
            }
        }

        for (Book i : input) {
            System.out.println(i);
            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {
        //Lab 5.2 Create Book class.
        Book a = new Book("Copying and Pasting from StackOverflow", "Reef Tang Books", "Harlan Huber", 6);
        Book b = new Book("Googling the Error Message", "Mikaeel Martinez Literature", "Anne Barnes", 9);
        Book c = new Book("Blame the User", "Antony Miles Inc.", "Yvette Simons", 4);
        Book d = new Book("Trying Stuff Until it Works", "Giuseppe Mays Publishing", "Fabian Wiley", 2);
        Book e = new Book("How to Write Spaghetti Code", "Amber-Rose Bass & Co.", "Simra Velasquez", 0);
        Book f = new Book("What Are Comments and How Do They Work?", "Kiaan Macfarlane Books", "Samina Martinez", 15);
        Book g = new Book("Changing Stuff to See What Happens", "Haley Thomas Ltd.", "Remi Mcclure", 8);

        //Store books in array
        Book[] bookArr = new Book[]{a, b, c, d, e, f, g};

        //Lab 5.3 Sort books using comparable interface.
        Scanner sc = new Scanner(System.in);
        System.out.println("How would you like to sort \n Enter: 1 for Title | 2 for Publisher | 3 for Price");
        a.setSortingMethod(sc.nextInt());
        sortBooks(bookArr);
    }


}