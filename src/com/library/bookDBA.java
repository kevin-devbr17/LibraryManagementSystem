package com.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class bookDBA {

    public void addBook(Book book) {
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

    public List<Book> getAllBooks() {

        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM books";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                int bookID = resultSet.getInt("book_id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                boolean isAvailable = resultSet.getBoolean("is_available");

                Book book = new Book(
                        bookID,
                        title,
                        author,
                        isAvailable
                );

                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
}
