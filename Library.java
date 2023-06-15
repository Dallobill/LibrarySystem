package library.management.system;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private static final Object ISBN = null;
    private List<Book> books;
    private List<Member> members;

    public Library(){
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void addMember(Member member){
        members.add(member);
    }

    public Book findBookByISBN(){
        for(Book book: books){
            if(book.getISBN().equals(ISBN)){
                return book;
            }
        }
        return null;
    }
    //to diplay the availability status of book
    public boolean isBookAvailable(String ISBN){
        Book book = (Book) findBookByTitle(ISBN);
        if(book != null){
            return book.isAvailable();
        }
        return false;

    }

    //ability to find books by title 
    public List<Book> findBookByTitle(String title){
        List<Book> foundBooks = new ArrayList<>();
        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(title)){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }



    public boolean reserveBook(String ISBN, Member member){
        Book book = (Book) findBookByTitle(ISBN);
        if(book != null && book.isAvailable() && !book.isReserved()){
            book.setReserved(true);
            book.setReservedBy(member);
            return true;
        }
        return false;
    }

    public boolean isReserved(String ISBN){
        Book book = findBookByISBN();
        return book != null && book.isReserved();
    }

    public void notifyMemberForAvailableBook(Member member){
        for(Book book : books){
            if(book.isReserved() && book.isAvailable() && book.getReservedBy().equals(member)){
                sendNotificationToMember(member, book);
            }
        }
    }
 
    private void sendNotificationToMember(Member member, Book book) {
    }

    public boolean borrowBook(String ISBN, Member member){
        Book book = findBookByISBN();
        if(book!=null && book.isAvailable()){
            book.setAvailable(false);
            book.setDueDate(LocalDate.now().plusDays(14)); //set due date as 14 days from current date/
            return true;
        }
        return false;
    }

    public boolean returnBook(String ISBN){
        Book book = findBookByISBN();
        if(book != null && ! book.isAvailable()){
            book.setAvailable(true);
            return true;
        }
        return false;
    }

    //method to return the due date of the book

    public void sendRemindersForOverdueBooks(){
        LocalDate today = LocalDate.now();
        for(Book book : books){
            if(!book.isAvailable() && today.isAfter(book.getDueDate())){
                // Send a reminder to the member associated with the book
                Member member = findMemberByBook(book);
                sendReminderToMember(member, book);

            }
        }
    }
    private Member findMemberByBook(Book book) {
        return null;
    }

    /**
     * 
     * @param book calculate late fees
     * @return fines per day 
     */

    public double calculateFineForLateReturn(Book book){
        LocalDate today = LocalDate.now();
        if(!book.isAvailable() && today.isAfter(book.getDueDate())){
            long daysLate = ChronoUnit.DAYS.between(book.getDueDate(), today);
            double finePerDay = 0.50; // Adjust the fine amount per day as needed
            return finePerDay * daysLate;
        }
        return 0.0; //No fine if book is returned on time or already returned
    }

    private void sendReminderToMember(Member member, Book book) {
    }

    Member findMemberByBook(String borrowerId) {
        return null;
    }

    public boolean reserveBook(String iSBN, String string) {
        return false;
    }

    public boolean borrowBook(Book borrowBook, Member borrower) {
        return false;
    }


    
}
