<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="Css.css" rel="stylesheet">
    <style>
        th {
            background: rgb(125, 125, 180);
            padding-left: 10px;
            height: 40px;
        }

        td {
            padding-top: 5px;
            height: 40px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            font-size: 20px;
            text-align: center;
            margin-top: 50px;
        }
    </style>
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
                <div class="backButton">
                    <a href="./studentCourse.jsp">
                        <
                    </a>
                </div>
                <div class="content-1">
                    <a href="./studentCourseAssignment.jsp">Assignment</a>
                    <a href="./studentCourseTest.jsp">Test</a>
                    <a href="./studentCourseExam.jsp">Exam</a>
                </div>
                <h2>COMP S350F SOFTWARE ENGINEERING</h2>
                <div class="content-2">
                    <table>
                        <tr>
                            <th>No.</th>
                            <th>Code</th>
                            <th>Item</th>
                            <th>Date/Time</th>
                            <th>Status</th>
                            <th>Grade</th>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>COMP S350F</td>
                            <td>Exam 1</td>
                            <td>03-03-2023 13:00</td>
                            <td>Submitted</td>
                            <td>A</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>COMP S350F</td>
                            <td>Exam 2</td>
                            <td>04-04-2023 15:00</td>
                            <td>Submitted</td>
                            <td>Marking</td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
