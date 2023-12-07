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

public class GradeDAO {

    private Connection connection;

    public GradeDAO(Connection connection) {
        this.connection = connection;
    }

    // Implement code to retrieve Grade by ID from the database.
    public Grade getGradeByID(int gradeID) {
        Grade grade = null;
        String query = "SELECT * FROM Grade WHERE GradeID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, gradeID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    grade = new Grade();
                    grade.setGradeID(resultSet.getInt("GradeID"));
                    grade.setStudentID(resultSet.getInt("StudentID"));
                    grade.setCourseID(resultSet.getInt("CourseID"));
                    grade.setAssignmentName(resultSet.getString("AssignmentName"));
                    grade.setGrade(resultSet.getString("Grade"));
                    // Set other attributes here
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grade;
    }

    // Implement code to retrieve all grades from the database.
    public List<Grade> getAllGrades() {
        List<Grade> grades = new ArrayList<>();
        String query = "SELECT * FROM Grade";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Grade grade = new Grade();
                grade.setGradeID(resultSet.getInt("GradeID"));
                grade.setStudentID(resultSet.getInt("StudentID"));
                grade.setCourseID(resultSet.getInt("CourseID"));
                grade.setAssignmentName(resultSet.getString("AssignmentName"));
                grade.setGrade(resultSet.getString("Grade"));
                // Set other attributes here
                grades.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }

    // Implement code to add a new grade to the database.
    public void addGrade(Grade grade) {
        String query = "INSERT INTO Grade (GradeID, StudentID, CourseID, AssignmentName, Grade) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, grade.getGradeID());
            preparedStatement.setInt(2, grade.getStudentID());
            preparedStatement.setInt(3, grade.getCourseID());
            preparedStatement.setString(4, grade.getAssignmentName());
            preparedStatement.setString(5, grade.getGrade());
            // Set other attributes here
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Implement code to update an existing grade in the database.
    public void updateGrade(Grade grade) {
        String query = "UPDATE Grade SET StudentID = ?, CourseID = ?, AssignmentName = ?, Grade = ? WHERE GradeID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, grade.getStudentID());
            preparedStatement.setInt(2, grade.getCourseID());
            preparedStatement.setString(3, grade.getAssignmentName());
            preparedStatement.setString(4, grade.getGrade());
            // Set other attributes here
            preparedStatement.setInt(5, grade.getGradeID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Implement code to delete a grade from the database.
    public void deleteGrade(int gradeID) {
        String query = "DELETE FROM Grade WHERE GradeID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, gradeID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
