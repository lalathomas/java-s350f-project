<%@ page import="java.sql.Connection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ict.bean.WebUser" %>
<%@ page import="ict.bean.Teacher" %>
<%@ page import="ict.bean.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="ict.dao.TeacherDAO" %>
<%@ page import="ict.dao.CourseDAO" %>
<%@ page import="java.sql.SQLException" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Teacher Overview</title>
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
                    WebUser loggedInUser = (WebUser) session.getAttribute("loggedInUser");
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
                        } catch (SQLException e) {
                            e.printStackTrace();
                            // Handle the exception as needed
                        }
                    }
                %>
                <%
                    if (loggedInTeacher != null) {
                        try {
                            // Create an instance of CourseDAO
                            CourseDAO courseDAO = new CourseDAO(DatabaseConnector.getConnection());

                            // Get the courses taught by the logged-in teacher
                            List<Course> coursesTaught = courseDAO.getCoursesByInstructorID(loggedInTeacher.getTeacherID());
                %>
                <%
                    for (Course course : coursesTaught) {
                %>
                <li><a href="./teacherCourseStudents.jsp?courseID=<%= course.getCourseID() %>"><%= course.getCourseName() %></a></li>
                <%
                    }
                %>
                <%
                        } catch (SQLException e) {
                            e.printStackTrace();
                            // Handle the exception as needed
                        }
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
                <h4>Teacher Overview</h4>
                <div class="informationBox">
                    <%-- Retrieve the WebUser object from the session --%>
                    <%
                        if (loggedInUser != null) {
                    %>
                    <p>Teacher ID: <%= loggedInTeacher.getTeacherID() %></p>
                    <p>First Name: <%= loggedInUser.getFirstName() %></p>
                    <p>Last Name: <%= loggedInUser.getLastName() %></p>
                    <!-- Add other teacher information fields here -->
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
