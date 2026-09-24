import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class bookDBA {

    public void addBook(Book book){
        String sql = "INSERT INTO books (book_id, title, author, is_available) VALUES (?, ?, ?, ?)";

        try (Connection connection = DataBaseConnection.getConnection();

             PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, book.getBookID());

                statement.setString(2, book.getTitle());

                statement.setString(3, book.getAuthor());

                statement.setBoolean(4, book.isAvailable());

                statement.executeUpdate();

                System.out.println("Book added to database!");

            } catch (SQLException e) {

            e.printStackTrace();

        }
    }

}
