package library.management.system;

import java.time.LocalDate;

/**
 * created by ticoh dallo
 */

 public class Book {

    private String title;
    private String author;
    private String ISBN;
    private Boolean available;
    private LocalDate duedate; // New field for due dates
    private Member reservedBy;

    /**
     * 
     * @param title title of books in library
     * @param author author of books in library
     * @param ISBN number of the book
     */

    public Book(String title, String author, String ISBN){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.available = true;
    }
    /**
     * 
     * @return the list of book titles in the library.
     */

    public String getTitle(){
        return title;

    }

    public String getAuthor(){
        return author;
    }

    public String getISBN(){
        return ISBN;
    }

    public boolean isAvailable(){
        return available;
    }

    public void setAvailable(boolean available){
        this.available = available;

    }
    public void setDueDate(LocalDate dueDate) {
    }

    public LocalDate getDueDate(){
        return duedate;
    }

    public void setReserved(boolean reserved){
    }

    public void setReservedBy(Member reservedBy){
        this.reservedBy = reservedBy;
    }
    public boolean isReserved() {
        return isReserved();
    }

    public Member getReservedBy(){
        return reservedBy;

    }

    @Override
    public String toString(){
        return "Book{" + "title ='" + '\'' + ", author ='" + author + '\'' + ", ISBN ='" + ISBN + '\'' + '}';
    }

}

