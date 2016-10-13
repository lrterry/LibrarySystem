/**
 * Created by lrterry on 10/13/16.
 */
import java.util.Date;

public class Book{
    public String title;
    public int id;
    private String author;
    public Boolean isCheckedOut;
    private int checkTime;

    public Book(int id, String title, String author) {
        this.title = title;
        this.id = id;
        this.author = author;
        this.isCheckedOut = false;
    }

    public void listInfo() {
        System.out.println("* Book ID: " + id);
        System.out.println("* Book Title: " + title);
        System.out.println("* Book Author: " + author);
        if(isCheckedOut) {
            System.out.println("This Book is checked out");
        }
    }
}