<%-- 
    Document   : teacherOverview.jsp
    Created on : 2023年12月7日, 下午9:24:53
    Author     : lala
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="ict.bean.Course" %>
<%@ page import="ict.bean.Teacher" %>

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
                <li><a href="#">Settings</a></li>
                <li><a href="./loginPage.jsp">Logout</a></li>
            </ul>
        </div>

        <div class="main-content">
            <div class="Welcome">
                <h2>Welcome Back! Teacher</h2>
            </div>
            <div class="content">
                <h4>Teaching Courses</h4>
                <div class="informationBox">
                    <%-- Retrieve the Teacher object from the session --%>
                    <%
                        Teacher loggedInTeacher = (Teacher) session.getAttribute("loggedInTeacher");
                        if (loggedInTeacher != null) {
                            try {
                                // Create an instance of CourseDAO
                                CourseDAO courseDAO = new CourseDAO(DatabaseConnector.getConnection());

                                // Get the teacher's courses using the CourseDAO instance
                                List<Course> teachingCourses = courseDAO.getCoursesByInstructorID(loggedInTeacher.getTeacherID());

                                if (!teachingCourses.isEmpty()) {
                                    for (Course course : teachingCourses) {
                    %>
                    <p><a href="./teacherCourseStudents.jsp?courseID=<%= course.getCourseID() %>"><%= course.getCourseName() %></a></p>
                    <%-- Add other course information fields here --%>
                    <%
                                    }
                                } else {
                    %>
                    <p>No courses found.</p>
                    <%
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                // Handle the exception as needed
                            }
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
