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

public class CourseDAO {

    private Connection connection;

    public CourseDAO(Connection connection) {
        this.connection = connection;
    }

    // Implement code to retrieve Course by ID from the database.
    public Course getCourseByID(int courseID) {
        Course course = null;
        String query = "SELECT * FROM Course WHERE CourseID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, courseID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    course = new Course();
                    course.setCourseID(resultSet.getInt("CourseID"));
                    course.setCourseName(resultSet.getString("CourseName"));
                    course.setCourseDescription(resultSet.getString("CourseDescription"));
                    course.setCredits(resultSet.getInt("Credits"));
                    course.setInstructorID(resultSet.getInt("InstructorID"));
                    // Set other attributes here
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    // Implement code to retrieve all courses from the database.
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM Course";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Course course = new Course();
                course.setCourseID(resultSet.getInt("CourseID"));
                course.setCourseName(resultSet.getString("CourseName"));
                course.setCourseDescription(resultSet.getString("CourseDescription"));
                course.setCredits(resultSet.getInt("Credits"));
                course.setInstructorID(resultSet.getInt("InstructorID"));
                // Set other attributes here
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    // Implement code to add a new course to the database.
    public void addCourse(Course course) {
        String query = "INSERT INTO Course (CourseID, CourseName, CourseDescription, Credits, InstructorID) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, course.getCourseID());
            preparedStatement.setString(2, course.getCourseName());
            preparedStatement.setString(3, course.getCourseDescription());
            preparedStatement.setInt(4, course.getCredits());
            preparedStatement.setInt(5, course.getInstructorID());
            // Set other attributes here
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Implement code to update an existing course in the database.
    public void updateCourse(Course course) {
        String query = "UPDATE Course SET CourseName = ?, CourseDescription = ?, Credits = ?, InstructorID = ? WHERE CourseID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setString(2, course.getCourseDescription());
            preparedStatement.setInt(3, course.getCredits());
            preparedStatement.setInt(4, course.getInstructorID());
            // Set other attributes here
            preparedStatement.setInt(5, course.getCourseID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Implement code to delete a course from the database.
    public void deleteCourse(int courseID) {
        String query = "DELETE FROM Course WHERE CourseID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, courseID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Implement code to retrieve courses for a specific student from the database.

    public List<Course> getCoursesByStudentID(int studentID) {
        List<Course> studentCourses = new ArrayList<>();
        String query = "SELECT c.* FROM Course c "
                + "JOIN Grade g ON c.CourseID = g.CourseID "
                + "WHERE g.StudentID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, studentID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Course course = new Course();
                    course.setCourseID(resultSet.getInt("CourseID"));
                    course.setCourseName(resultSet.getString("CourseName"));
                    course.setCourseDescription(resultSet.getString("CourseDescription"));
                    course.setCredits(resultSet.getInt("Credits"));
                    course.setInstructorID(resultSet.getInt("InstructorID"));
                    // Set other course attributes here
                    studentCourses.add(course);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentCourses;
    }

}
