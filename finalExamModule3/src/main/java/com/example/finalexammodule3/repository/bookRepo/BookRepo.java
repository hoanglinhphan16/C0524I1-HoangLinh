package com.example.finalexammodule3.repository.bookRepo;

import com.example.finalexammodule3.model.Book;
import com.example.finalexammodule3.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepo implements IBookRepo{
    private static final String SELECT_ALL_BOOKS = "select * from books";
    private static final String SELECT_BOOK_BY_ID = "select * from books where id=?";


    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_BOOKS);
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                String description = resultSet.getString("description");
                int quantity = resultSet.getInt("quantity");
                books.add(new Book(id, name, author, description, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    @Override
    public Book getBookById(String id) {
        Book book = null;
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID)) {
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                String description = resultSet.getString("description");
                int quantity = resultSet.getInt("quantity");
                book = new Book(id, name, author, description, quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
}
