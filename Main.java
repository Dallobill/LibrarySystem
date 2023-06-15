package library.management.system;


import java.util.Scanner;

public class Main {
    private static boolean success;

    public static void main(String[] args){
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int option;
        
        //Add Books
        Book book1 = new Book("Stock Market", "Michele Cagan", "222222" );
        Book book2 = new Book("personal Finance", "Michele Cagan", "444444");
        Book book3 = new Book("Backstage Guide to Real Estate", "Matt Picheny", "333333");
        Book book4 = new Book("Passive Cashflow", "Lane Kawaoka", "123456");
        Book book5 = new Book("The Secret Wealth Advantage", "Akhil Patel", "789123");
        Book book6 = new Book("What the Hell is an Economy", "Eric Johnson", "234567");
        Book book7 = new Book("The Money Intelligence", "Mike Feng Zheng", "456789");
        Book book8 = new Book("Four Ways to Beat the Market", "Algy Hall", "987654");
        Book book9 = new Book("The Mental Game Of Trading", "Jared Tendler", "876543");
        Book book10 = new Book("Stop Checking The Price!", "J.F Dodaro", "654321");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);
        library.addBook(book8);
        library.addBook(book9);
        library.addBook(book10);

        //Add Members
        Member member1 = new Member("Corey Holcomb","5150");
        Member member2 = new Member("T.K Kirkland","2211");
        Member member3 = new Member("Micheal Blackson", "5467");
        library.addMember(member1);
        library.addMember(member2);
        library.addMember(member3);

        boolean reservationSuccess = library.reserveBook("222222", "Corey Holcomb");
        if(reservationSuccess){
            System.out.println("Book reserved successfully by member: " + member1.getName());
        }else {
            System.out.println("Book could not be reserved.");
        }
        
        do {
            System.out.println("Library Management System:");
            
            System.out.println("1.Add book");

            System.out.println("2. Add member");

            System.out.println("3. Borrow book");

            System.out.println("4. Return book");

            System.out.println("0. Exit");

            System.out.println("Enter your option:");

            option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 1:
                System.out.println("Enter book title:");
                String title = scanner.nextLine();
                System.out.println("Enter book author:");
                String author = scanner.nextLine();
                System.out.print("Enter book ISBN:");
                String ISBN = scanner.nextLine();
                library.addBook(new Book(title, author, ISBN));
                System.out.println("Book added successfully.");

                
                break;
                case 2:
                System.out.print("Enter Member name:");
                String name = scanner.nextLine();
                System.out.print("Enter Member ID:");
                String id = scanner.nextLine();
                library.addMember(new Member(name, id));
                System.out.println("Member added successfully");
                break;
                case 3:
                System.out.print("Enter Member ID:");
                String borrowerId =scanner.nextLine();
                System.out.print("Enter book ISBN:");
                    Book borrowBook = library.findBookByISBN();
                Member borrower = library.findMemberByBook(borrowerId);
                
                if(borrowBook == null){
                    System.out.println("Book not found. Unable to borrow");
                    break;
                }

                if(borrower == null) {
                    System.out.println("Member not found. Unable to borrow.");
                }
                    if(success){
                    System.out.println("Book borroed successfully by member: " + borrower.getName());
                }else{
                    System.out.println("Book is not available for borrowing.");
                }
                break;


                
                case 4:
                
                System.out.print("Enter book ISBN:");
                String returnIsbn = scanner.nextLine();
                if(library.returnBook(returnIsbn)){
                    System.out.println("Book return successfully.");
                } else {
                    System.out.println("Failed to return book");
                }
                break;
                case 5:

                System.out.println("Exiting...");
                break;
                default:
                System.out.println("Invalid option! try again.");
            }
            System.out.println();
        }while(option !=5);
        
        scanner.close();
    }
    
}
