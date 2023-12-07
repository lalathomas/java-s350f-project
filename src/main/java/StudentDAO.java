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

public class StudentDAO {

    private Connection connection;

    public StudentDAO(Connection connection) {
        this.connection = connection;
    }

    // Implement code to retrieve Student by ID from the database.
    public Student getStudentByID(int studentID) {
        Student student = null;
        String query = "SELECT * FROM Student WHERE StudentID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, studentID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    student = new Student();
                    student.setStudentID(resultSet.getInt("StudentID"));
                    student.setUserID(resultSet.getInt("UserID"));
                    student.setDateOfBirth(resultSet.getDate("DateOfBirth"));
                    student.setGender(resultSet.getString("Gender"));
                    student.setContactNumber(resultSet.getString("ContactNumber"));
                    student.setAddress(resultSet.getString("Address"));
                    student.setEmergencyContact(resultSet.getString("EmergencyContact"));
                    student.setProgramID(resultSet.getInt("ProgramID"));
                    // Set other attributes here
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    // Implement code to retrieve all students from the database.
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM Student";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentID(resultSet.getInt("StudentID"));
                student.setUserID(resultSet.getInt("UserID"));
                student.setDateOfBirth(resultSet.getDate("DateOfBirth"));
                student.setGender(resultSet.getString("Gender"));
                student.setContactNumber(resultSet.getString("ContactNumber"));
                student.setAddress(resultSet.getString("Address"));
                student.setEmergencyContact(resultSet.getString("EmergencyContact"));
                student.setProgramID(resultSet.getInt("ProgramID"));
                // Set other attributes here
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // Implement code to add a new student to the database.
    public void addStudent(Student student) {
        String query = "INSERT INTO Student (StudentID, UserID, DateOfBirth, Gender, ContactNumber, Address, EmergencyContact, ProgramID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, student.getStudentID());
            preparedStatement.setInt(2, student.getUserID());
            preparedStatement.setDate(3, new java.sql.Date(student.getDateOfBirth().getTime()));
            preparedStatement.setString(4, student.getGender());
            preparedStatement.setString(5, student.getContactNumber());
            preparedStatement.setString(6, student.getAddress());
            preparedStatement.setString(7, student.getEmergencyContact());
            preparedStatement.setInt(8, student.getProgramID());
            // Set other attributes here
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Implement code to update an existing student in the database.
    public void updateStudent(Student student) {
        String query = "UPDATE Student SET UserID = ?, DateOfBirth = ?, Gender = ?, ContactNumber = ?, Address = ?, EmergencyContact = ?, ProgramID = ? WHERE StudentID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, student.getUserID());
            preparedStatement.setDate(2, new java.sql.Date(student.getDateOfBirth().getTime()));
            preparedStatement.setString(3, student.getGender());
            preparedStatement.setString(4, student.getContactNumber());
            preparedStatement.setString(5, student.getAddress());
            preparedStatement.setString(6, student.getEmergencyContact());
            preparedStatement.setInt(7, student.getProgramID());
            // Set other attributes here
            preparedStatement.setInt(8, student.getStudentID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Implement code to delete a student from the database.
    public void deleteStudent(int studentID) {
        String query = "DELETE FROM Student WHERE StudentID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, studentID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student getStudentByUserID(int userID) {
        Student student = null;
        String query = "SELECT * FROM Student WHERE UserID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    student = new Student();
                    student.setStudentID(resultSet.getInt("StudentID"));
                    student.setUserID(resultSet.getInt("UserID"));
                    student.setDateOfBirth(resultSet.getDate("DateOfBirth"));
                    student.setGender(resultSet.getString("Gender"));
                    student.setContactNumber(resultSet.getString("ContactNumber"));
                    student.setAddress(resultSet.getString("Address"));
                    student.setEmergencyContact(resultSet.getString("EmergencyContact"));
                    student.setProgramID(resultSet.getInt("ProgramID"));
                    // Set other attributes here
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
