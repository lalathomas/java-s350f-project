<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="loginPageCss.css" rel="stylesheet">
</head>

<body>
    <div class="wrapper">
        <h1>Login</h1>
        <form action="LoginServlet" method="post">
            <div class="inputBox">
                <input type="text" name="userid" id="userid" placeholder="User ID"><br><br>
            </div>
            <div class="inputBox">
                <input type="password" name="password" id="password" placeholder="Password"><br><br>
            </div>
            <div class="forgetPw">
                <a href="./forgetPassword.jsp">Forget Password?</a>
                <input type="submit" value="Login" class="btn">
            </div>
        </form>
        <% 
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
        %>
            <p><%= errorMessage %></p>
        <% 
            }
        %>
    </div>
</body>

</html>
