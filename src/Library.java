import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    ArrayList<Book> books = new ArrayList<>();

    public Book addBook(Book book){
        books.add(book);

        return book;
    }

    public String removeBook(String title){
        if(books.isEmpty()){
            return "There are no books.";
        }else{
            for(int i = 0; i < books.size(); i++){
                if (books.get(i).getTitle().equals(title)){
                        books.remove(i);
                        return "Book removed.";
                }
            }
        }

        return "Book not found.";
    }

    public Book searchBook(String title){
            for(Book book: books){
                if(book.getTitle().equals(title)){
                    return book;
                }
            }

        return null;
    }

    public void displayBooks(){
        for(Book book: books){
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("BookID: " + book.getBookID());
            System.out.println("Book availability: " + book.isAvailable());
        }
    }

}
