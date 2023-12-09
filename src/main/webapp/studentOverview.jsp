
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ict.bean.WebUser" %>
<%@ page import="ict.bean.Student" %>
<%@ page import="ict.bean.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="ict.dao.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Student Overview</title>
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
                    <!-- Add these lines in the appropriate place in your HTML -->
                    <li><a href="./studentExam.jsp">View Course Result</a> </li>
                    <li><a href="./studentInformation.jsp">View Student Information</a> </li>
                        <%  
    WebUser loggedInUser = (WebUser) session.getAttribute("loggedInUser");
    System.out.println("Logged in user ID: " + loggedInUser.getUserID());
    System.out.println("Logged in user role: " + loggedInUser.getRole());
    Student loggedInStudent = null;
    if (loggedInUser != null) {
        try {
            Connection yourConnectionObject = DatabaseConnector.getConnection();

            // Create an instance of StudentDAO
            StudentDAO studentDAO = new StudentDAO(yourConnectionObject);

            // Get the userID of the logged-in user (replace this with your actual code to get the userID)
            int userID = loggedInUser.getUserID();

            // Retrieve the logged-in student using the StudentDAO instance
            loggedInStudent = studentDAO.getStudentByUserID(userID);

            // Now you can use loggedInStudent as needed
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }
                        %>
                    
                    <li><a href="./loginPage.jsp">Logout</a></li>
                </ul>
            </div>
        </div>
        <div class="content">
            <h4>Student Overview</h4>
            <div class="informationBox">
                <%-- Retrieve the WebUser object from the session --%>
                <%
                    if (loggedInUser != null) {
                %>
                <p>Student ID: <%= loggedInStudent.getStudentID() %></p>
                <p>First Name: <%= loggedInUser.getFirstName() %></p>
                <p>Last Name: <%= loggedInUser.getLastName() %></p>
                <!-- Add other student information fields here -->
                <%
                    } else {
                %>
                <p>Student information not found.</p>
                <%
                    }
                %>
            </div>
        </div>
    </div>
    <!-- Footer -->
    <div class="footer">
        <p>© 2022 Your School. All rights reserved.</p>
    </div>
</body>
</html> 