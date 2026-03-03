public class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookID, String title, String author, boolean isAvailable){
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public boolean borrowBook(){
        if(!isAvailable()){
            return false;
        }
        isAvailable = false;
        return true;

    }

    public boolean returnBook(){
        if(isAvailable){
            return false;
        }

        isAvailable = true;
        return true;
    }

    public String toString(){
       return "Book Title: " + title +
        "\nBookID: " + bookID +
        "\nAuthor: " + author +
        "\nBook Availability: " + isAvailable;
    }

}
