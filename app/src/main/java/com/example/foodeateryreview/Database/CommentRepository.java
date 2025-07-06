package com.example.foodeateryreview.Database;

import com.example.foodeateryreview.Models.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CommentRepository {

    private final DatabaseConnection databaseConnection;

    public CommentRepository() {
        this.databaseConnection = new DatabaseConnection();
    }

    public List<Comment> getCommentsByBlogId(int blogId) {
        List<Comment> comments = new ArrayList<>();
        String query = "SELECT * FROM Comments WHERE BlogId = ?";

        try (Connection connection = databaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, blogId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Comment comment = Comment.builder()
                        .CommentId(resultSet.getInt("CommentId"))
                        .Content(resultSet.getString("Content"))
                        .CommentStatus(resultSet.getInt("CommentStatus"))
                        .UserId(resultSet.getInt("UserId"))
                        .Username(resultSet.getString("Username"))
                        .BlogId(resultSet.getInt("BlogId"))
                        .CommentLike(resultSet.getInt("CommentLike"))
                        .CommentDate(resultSet.getDate("CommentDate"))
                        .build();
                comments.add(comment);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return comments;
    }
}
