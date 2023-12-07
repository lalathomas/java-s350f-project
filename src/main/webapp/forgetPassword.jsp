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
        <h1>Forget Password</h1>
        <form action="#">
            <div class="inputBox">
                <input type="text" name="userid" id="userid" placeholder="User ID"><br><br>
            </div>
            <div class="inputBox">
                <input type="email" name="email" id="email" placeholder="Email"><br><br>
            </div>
            <div class="back">
                <a href="./loginPage.jsp">Back To Login</a>         
                <input type="submit" value="Send Verification Email" class="btn1">
            </div>    
        </form>
    </div>
</body>

</html>
