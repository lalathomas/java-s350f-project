<%@ page import="java.sql.Connection" %>
<%@ page import="ict.bean.WebUser" %>
<%@ page import="ict.bean.Student" %>
<%@ page import="ict.bean.Course" %>
<%@ page import="ict.bean.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.SQLException" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Teacher Course Students</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="Css.css" rel="stylesheet">
</head>

<body>
    <div class="wrapper">
        <!-- Navigation Bar -->
        <div class="sidebar">
            <header>
                Teacher
            </header>
            <ul>
                <li><a href="./teacherOverview.jsp">Overview</a></li>
                <%
                    Teacher loggedInTeacher = null;
                    WebUser loggedInUser = (WebUser) session.getAttribute("loggedInTeacher");
                    if (loggedInUser != null) {
                        try {
                            Connection yourConnectionObject = DatabaseConnector.getConnection();

                            // Create an instance of TeacherDAO
                            TeacherDAO teacherDAO = new TeacherDAO(yourConnectionObject);

                            // Get the userID of the logged-in user (replace this with your actual code to get the userID)
                            int userID = loggedInUser.getUserID();

                            // Retrieve the logged-in teacher using the TeacherDAO instance
                            loggedInTeacher = teacherDAO.getTeacherByUserID(userID);

                            // Now you can use loggedInTeacher as needed
                        } catch (Exception e) {
                            e.printStackTrace();
                            // Handle the exception as needed
                        }
                    }
                %>
                <%
                    if (loggedInTeacher != null) {
                %>
                <li><a href="./teacherCourseStudents.jsp">Course Students</a></li>
                <%
                    }
                %>
                <li><a href="#">Settings</a></li>
                <li><a href="./loginPage.jsp">Logout</a></li>
            </ul>
        </div>

        <div class="main-content">
            <div class="Welcome">
                <h2>Welcome Back! Teacher</h2>
            </div>
            <div class="content">
                <h4>Teacher Course Students</h4>
                <div class="informationBox">
                    <%-- Retrieve the Teacher object from the session --%>
                    <%
                        if (loggedInTeacher != null) {
                            try {
                                Connection yourConnectionObject = DatabaseConnector.getConnection();

                                // Create an instance of CourseDAO
                                CourseDAO courseDAO = new CourseDAO(yourConnectionObject);

                                // Get the course ID from the request parameter (replace this with your actual code to get the courseID)
                                int courseID = Integer.parseInt(request.getParameter("courseID"));

                                // Retrieve the course information using the CourseDAO instance
                                Course selectedCourse = courseDAO.getCourseByID(courseID);

                                // Create an instance of GradeDAO
                                GradeDAO gradeDAO = new GradeDAO(yourConnectionObject);

                                // Retrieve the grades for the selected course
                                List<Grade> courseGrades = gradeDAO.getGradesByCourseID(courseID);
                            } catch (Exception e) {
                                e.printStackTrace();
                                // Handle the exception as needed
                            }
                    %>
                    <h5>Course: <%= selectedCourse.getCourseName() %></h5>
                    <table>
                        <tr>
                            <th>Student ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Grade</th>
                        </tr>
                        <%
                            for (Grade grade : courseGrades) {
                                try {
                                    // Create an instance of StudentDAO
                                    StudentDAO studentDAO = new StudentDAO(yourConnectionObject);

                                    // Retrieve the student information for each grade
                                    Student student = studentDAO.getStudentByID(grade.getStudentID());
                        %>
                        <tr>
                            <td><%= student.getStudentID() %></td>
                            
                            <td><%= grade.getGrade() %></td>
                        </tr>
                        <%
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    // Handle the exception as needed
                                }
                            }
                        %>
                    </table>
                    <%
                        } else {
                    %>
                    <p>Teacher information not found.</p>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
