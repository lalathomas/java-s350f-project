<%@ page import="your.package.Student" %>
<%@ page import="your.package.StudentManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Student Information Update</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="Css.css" rel="stylesheet">
</head>

<body>
    <div class="wrapper">
        <!--Navigation Bar-->
        <div class="sidebar">
            <header>
                Student
            </header>
            <ul>
                <li><a href="./studentOverview.jsp">Overview</a></li>
                <li><a href="./studentCourse.jsp">Course</a></li>
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
                <h4>Student Information Update</h4>
                <form action="UpdateStudentServlet" method="post">
                    <% 
                        Student loggedInStudent = StudentManager.getLoggedInStudent(); // Replace with your logic
                    %>
                    <div class="updateInput">
                        Student ID:
                        <input type="text" name="studentID" id="studentID" value="<%= loggedInStudent.getStudentID() %>">
                    </div>
                    <div class="updateInput">
                        First Name:
                        <input type="text" name="firstName" id="firstName" value="<%= loggedInStudent.getFirstName() %>">
                    </div>
                    <div class="updateInput">
                        Last Name:
                        <input type="text" name="lastName" id="lastName" value="<%= loggedInStudent.getLastName() %>">
                    </div>
                    <div class="updateInput">
                        Email:
                        <input type="email" name="email" id="email" value="<%= loggedInStudent.getEmail() %>">
                    </div>
                    <!-- Add other fields as needed -->
                    <div class="updateButton1">
                        <input type="submit" value="Update">
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>

</html>
