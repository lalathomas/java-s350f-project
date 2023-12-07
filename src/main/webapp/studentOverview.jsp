<%@ page import="java.sql.Connection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ict.bean.WebUser" %>
<%@ page import="ict.bean.Student" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <%
                    Student loggedInStudent = null;
                    WebUser loggedInUser = (WebUser) session.getAttribute("loggedInUser");
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
                        } catch (Exception e) {
                            e.printStackTrace();
                            // Handle the exception as needed
                        }
                    }
                %>
                <%
                    if (loggedInStudent != null) {
                %>
                <li><a href="./studentCourse.jsp?studentID=<%= loggedInStudent.getStudentID() %>">Course</a></li>
                <li><a href="./studentExam.jsp?studentID=<%= loggedInStudent.getStudentID() %>">Exam result</a></li>
                <li><a href="./studentInformation.jsp?studentID=<%= loggedInStudent.getStudentID() %>">Information</a></li>
                <%
                    }
                %>
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
                    <%-- Retrieve the WebUser object from the session --%>
                    <%
                        if (loggedInUser != null) {
                    %>
                    <p>Student ID: <%= loggedInStudent.getStudentID()%></p>
                    <p>First Name: <%= loggedInUser.getFirstName()%></p>
                    <p>Last Name: <%= loggedInUser.getLastName()%></p>
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
