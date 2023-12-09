<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="ict.bean.Student" %>
<%@ page import="ict.bean.WebUser" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Student Information</title>
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
                <h4>Student Information</h4>
                <div class="informationBox">
                    <%-- Retrieve the Student and WebUser objects from the session --%>
                    <%
                        Student loggedInStudent = (Student) session.getAttribute("loggedInStudent");
                        WebUser loggedInUser = (WebUser) session.getAttribute("loggedInUser");

                        if (loggedInStudent != null && loggedInUser != null) {
                    %>
                    <p>Student ID: <%= loggedInStudent.getStudentID() %></p>
                    <p>First Name: <%= loggedInUser.getFirstName() %></p>
                    <p>Last Name: <%= loggedInUser.getLastName() %></p>
                    <p>Date of Birth: <%= new SimpleDateFormat("yyyy-MM-dd").format(loggedInStudent.getDateOfBirth()) %></p>
                    <p>Gender: <%= loggedInStudent.getGender() %></p>
                    <p>Contact Number: <%= loggedInStudent.getContactNumber() %></p>
                    <p>Address: <%= loggedInStudent.getAddress() %></p>
                    <p>Emergency Contact: <%= loggedInStudent.getEmergencyContact() %></p>
                    <p>Program ID: <%= loggedInStudent.getProgramID() %></p>
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
    </div>
</body>

</html>
