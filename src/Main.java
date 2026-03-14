import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Library library = new Library();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = scan.nextInt();
                    scan.nextLine(); // consume newline
                    System.out.print("Enter Title: ");
                    String title = scan.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scan.nextLine();
                    Book newBook = new Book(id, title, author, true);
                    library.addBook(newBook);
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    // Remove a book
                    System.out.print("Enter Title to remove: ");
                    String removeTitle = scan.nextLine();
                    System.out.println(library.removeBook(removeTitle));
                    break;

                case 3:
                    // Search for a book
                    System.out.print("Enter Title to search: ");
                    String searchTitle = scan.nextLine();
                    String result = library.searchBook(searchTitle);
                    if (result.equals("Book not found") || result.equals("There are no books.")) {
                        System.out.println(result);
                    } else {
                        System.out.println("Book found: " + result);
                    }
                    break;

                case 4:
                    library.displayBooks();
                    break;

                case 5:
                    System.out.print("Enter Title to borrow: ");
                    String borrowTitle = scan.nextLine();
                    for (Book book : library.books) {
                        if (book.getTitle().equals(borrowTitle)) {
                            if (book.borrowBook()) {
                                System.out.println("You borrowed: " + book.getTitle());
                            } else {
                                System.out.println("Book is already borrowed.");
                            }
                        }
                    }
                    break;

                case 6:
                    System.out.print("Enter Title to return: ");
                    String returnTitle = scan.nextLine();
                    for (Book book : library.books) {
                        if (book.getTitle().equals(returnTitle)) {
                            if (book.returnBook()) {
                                System.out.println("You returned: " + book.getTitle());
                            } else {
                                System.out.println("Book was not borrowed.");
                            }
                        }
                    }
                    break;

                case 7:
                    running = false;
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scan.close();

    }
}
