/**
 * Created by lrterry on 10/13/16.
 */
import java.util.ArrayList;

public class Library {
    ArrayList<Book> bookList = new ArrayList();

    public void listBooks() {
        for(Book i: bookList) {
            System.out.println(i.title);
        }
    }

    public void listAllBookInfo() {
        for(Book i: bookList) {
            i.listInfo();
        }
    }

    private ArrayList<Book> sortBookArrayById(ArrayList<Book> bookArray) {
        Book placeholder;
        for(int i = 0; i < bookArray.size(); i++) {
            for(int j = i + 1; j < bookArray.size(); j++) {
                if(bookArray.get(i).id > bookArray.get(j).id) {
                    placeholder = bookArray.get(i);
                    bookArray.set(i, bookArray.get(j));
                    bookArray.set(j, placeholder);
                }
            }
        }
        return bookArray;
    }

    private Boolean checkIfBookExists(int id) {
        Boolean exists = false;
        for(Book i: bookList) {
            if(i.id == id) {
                exists = true;
            }
        }
        return exists;
    }

    public Boolean addBook(int id, String title, String author) {
        Boolean added = false;
        if(!checkIfBookExists(id)) {
            Book newBook = new Book(id, title, author);
            bookList.add(newBook);
            added = true;
        }
        return added;
    }

    public void checkOutBook(int id) {
        ArrayList<Book> bookArray = sortBookArrayById(bookList);
        for(Book i: bookArray) {
            if(i.id == id && !i.isCheckedOut) {
                i.isCheckedOut = true;
                System.out.println(i.title + " has been checked out");
            } else {
                System.out.println("Sorry, this book must already by checked out");
            }
        }
    }

    public void checkInBook(int id) {
        ArrayList<Book> bookArray = sortBookArrayById(bookList);
        for(Book i: bookArray) {
            if(i.id == id && i.isCheckedOut) {
                System.out.println(i.title + " has been returned");
            } else {
                System.out.println("Sorry, this book must have already been returned");
            }
        }
    }
}