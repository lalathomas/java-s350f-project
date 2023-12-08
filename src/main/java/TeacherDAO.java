/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lala
 */
import ict.bean.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {

    private Connection connection;

    public TeacherDAO(Connection connection) {
        this.connection = connection;
    }

    // Implement code to retrieve Teacher by ID from the database.
    public Teacher getTeacherByID(int teacherID) {
        Teacher teacher = null;
        String query = "SELECT * FROM Teacher WHERE TeacherID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, teacherID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    teacher = new Teacher();
                    teacher.setTeacherID(resultSet.getInt("TeacherID"));
                    teacher.setUserID(resultSet.getInt("UserID"));
                    teacher.setContactNumber(resultSet.getString("ContactNumber"));
                    // Set other attributes here
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    // Implement code to retrieve all teachers from the database.
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        String query = "SELECT * FROM Teacher";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeacherID(resultSet.getInt("TeacherID"));
                teacher.setUserID(resultSet.getInt("UserID"));
                teacher.setContactNumber(resultSet.getString("ContactNumber"));
                // Set other attributes here
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    // Implement code to add a new teacher to the database.
    public void addTeacher(Teacher teacher) {
        String query = "INSERT INTO Teacher (TeacherID, UserID, ContactNumber) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, teacher.getTeacherID());
            preparedStatement.setInt(2, teacher.getUserID());
            preparedStatement.setString(3, teacher.getContactNumber());
            // Set other attributes here
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Implement code to update an existing teacher in the database.
    public void updateTeacher(Teacher teacher) {
        String query = "UPDATE Teacher SET UserID = ?, ContactNumber = ? WHERE TeacherID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, teacher.getUserID());
            preparedStatement.setString(2, teacher.getContactNumber());
            // Set other attributes here
            preparedStatement.setInt(3, teacher.getTeacherID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Implement code to delete a teacher from the database.
    public void deleteTeacher(int teacherID) {
        String query = "DELETE FROM Teacher WHERE TeacherID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, teacherID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Teacher getTeacherByUserID(int userID) {
        Teacher teacher = null;
        String query = "SELECT * FROM Teacher WHERE UserID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    teacher = new Teacher();
                    teacher.setTeacherID(resultSet.getInt("TeacherID"));
                    teacher.setUserID(resultSet.getInt("UserID"));
                    // Set other attributes here
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }

}
