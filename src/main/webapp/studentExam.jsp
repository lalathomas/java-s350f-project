<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="ict.bean.Grade" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ict.dao.DatabaseConnector" %>
<%@ page import="ict.dao.GradeDAO" %>
<%@ page import="ict.bean.Student" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Exam Results</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="Css.css" rel="stylesheet">
</head>

<body>
    <div class="wrapper">
        <!-- Navigation Bar -->
        <div class="sidebar">
            <header>
                Student
            </header>
            <ul>
                <li><a href="./studentOverview.jsp">Overview</a></li>
                <li><a href="./studentCourse.jsp">Course</a></li>
                <li><a href="./studentExam.jsp">Exam result</a></li>
                <li><a href="./studentInformation.jsp">Information</a></li>
                <li><a href="#">Settings</a></li>
                <li><a href="./loginPage.jsp">Logout</a></li>
            </ul>
        </div>

        <div class="main-content">
            <div class="Welcome">
                <h2>Welcome Back! Student</h2>
            </div>
            <div class="content">
                <h4>Exam Results</h4>
                <div class="informationBox">
                    <%-- Retrieve the Student object from the session --%>
                    <%
                        Student loggedInStudent = (Student) session.getAttribute("loggedInStudent");
                        if (loggedInStudent != null) {
                            try {
                                Connection yourConnectionObject = DatabaseConnector.getConnection();

                                // Create an instance of GradeDAO
                                GradeDAO gradeDAO = new GradeDAO(yourConnectionObject);

                                // Get the student's exam results using the GradeDAO instance
                                List<Grade> examResults = gradeDAO.getExamResultsByStudentID(loggedInStudent.getStudentID());

                                // Now you can use examResults as needed
                    %>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>Course</th>
                                <th>Grade</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Grade result : examResults) { %>
                            <tr>
                                <td><%= result.getCourseID()%></td>
                                <td><%= result.getGrade() %></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                    <%
                            } catch (Exception e) {
                                e.printStackTrace();
                                // Handle the exception as needed
                            }
                        } else {
                    %>
                    <p>Student information not found.</p>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
