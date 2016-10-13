/**
 * Created by lrterry on 10/13/16.
 */
import java.util.Scanner;

public class InputHandler {
    Scanner input = new Scanner(System.in);
    Library myLibrary = new Library();

    private int validateIdInput(String userInput) {
        Boolean validId = false;
        int id = 0;
        while(!validId) {
            System.out.println("Enter Book ID: ");
            try {
                id = Integer.parseInt(userInput);
                validId = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid ID input. Please enter a number.");
            }
        }
        return id;
    }

    public void startProgram() {
        Boolean quitCondition = false;

        while(!quitCondition) {
            System.out.println("Welcome to the interactive library. Enter a command! (h for help)");
            switch(input.nextLine().toUpperCase().trim()) {
                case "H":
                    System.out.println("* a: add book");
                    System.out.println("* l: list books");
                    System.out.println("* la: list info on all books");
                    System.out.println("* co: check out a book");
                    System.out.println("* ci: check in a book");
                    System.out.println("* q: quit the program");
                    break;
                case "A":
                    String title;
                    String author;
                    int id = 0;

                    System.out.println("Enter Book Title: ");
                    title = input.nextLine();
                    System.out.println("Enter Book Author: ");
                    author = input.nextLine();
                    id = validateIdInput(input.nextLine().trim());

                    if(myLibrary.addBook(id, title, author)) {
                        System.out.println("Book successfully added!");
                    } else {
                        System.out.println("Error, this Book is already in the Library");
                    }
                    break;
                case "L":
                    myLibrary.listBooks();
                    break;
                case "LA":
                    myLibrary.listAllBookInfo();
                    break;
                case "CO":
                    int coId = 0;
                    coId = validateIdInput(input.nextLine().trim());
                    myLibrary.checkOutBook(coId);
                    break;
                case "CI":
                    int ciId = 0;
                    ciId = validateIdInput(input.nextLine().trim());
                    myLibrary.checkInBook(ciId);
                    break;
                case "Q":
                    System.out.println("Quitting....");
                    quitCondition = true;
                    break;
                default:
                    System.out.println("Error, invalid input!");
            }
        }
    }
}