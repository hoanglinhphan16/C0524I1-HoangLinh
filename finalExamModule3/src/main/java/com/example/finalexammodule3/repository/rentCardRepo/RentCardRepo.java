package com.example.finalexammodule3.repository.rentCardRepo;

import com.example.finalexammodule3.model.RentCard;
import com.example.finalexammodule3.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RentCardRepo implements IRentCardRepo {
    private static final String INSERT_RENTCARD = "INSERT INTO rentcards (bookId, studentId, status, rentDate, returnDate) VALUES (?, ?, ?, ?, ?)";

    @Override
    public void rentCard(RentCard rentCard) {
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RENTCARD)) {
            preparedStatement.setString(1, rentCard.getBookId());
            preparedStatement.setInt(2, rentCard.getStudentId());
            preparedStatement.setString(3, rentCard.getStatus());
            preparedStatement.setDate(4, rentCard.getRentDate());
            preparedStatement.setDate(5, rentCard.getReturnDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
