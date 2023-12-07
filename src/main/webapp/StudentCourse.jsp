<%-- 
    Document   : StudentCourse
    Created on : 2023年12月5日, 上午5:16:47
    Author     : lala
--%>

<%@ page import="java.sql.Connection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ict.bean.WebUser" %>
<%@ page import="ict.bean.Student" %>
<%@ page import="ict.bean.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Student Courses</title>
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
                <h4>Student Courses</h4>
                <div class="informationBox">
                    <%-- Retrieve the WebUser and Student objects from the session --%>
                    <%
                        DatabaseConnector databaseConnector = new DatabaseConnector();
                        //WebUser loggedInUser = (WebUser) session.getAttribute("loggedInUser");
                        Student loggedInStudent = (Student) session.getAttribute("loggedInStudent");

                        if ( loggedInStudent != null) {
                            try {
                                Connection yourConnectionObject = databaseConnector.getConnection();

                                // Create an instance of CourseDAO
                                CourseDAO courseDAO = new CourseDAO(yourConnectionObject);

                                // Retrieve the courses that the student is taking
                                List<Course> studentCourses = courseDAO.getCoursesByStudentID(loggedInStudent.getStudentID());

                                // Now you can use studentCourses as needed
                    %>
                    <table>
                        <thead>
                            <tr>
                                <th>Course ID</th>
                                <th>Course Name</th>
                                <th>Course Description</th>
                                <!-- Add other course attributes here -->
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Course course : studentCourses) { %>
                                <tr>
                                    <td><%= course.getCourseID() %></td>
                                    <td><%= course.getCourseName() %></td>
                                    <td><%= course.getCourseDescription() %></td>
                                    <!-- Add other course attributes here -->
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
