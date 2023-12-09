package ict.servlet;

import ict.bean.Student;
import ict.bean.WebUser;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ict.dao.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userID = request.getParameter("userid");
        String password = request.getParameter("password");

        System.out.println("UserID: " + userID); // Debug message
        System.out.println("Password: " + password); // Debug message

        // Validate the user
        WebUserDAO webUserDAO = null;
        try {
            System.out.println(DatabaseConnector.class.getClassLoader());
            System.out.println(System.getProperty("java.class.path"));
            Class.forName("com.mysql.cj.jdbc.Driver");
            webUserDAO = new WebUserDAO(DatabaseConnector.getConnection());
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            // Handle database connection error
            request.setAttribute("errorMessage", "Database connection error");
            request.getRequestDispatcher("loginPage.jsp").forward(request, response);
            return;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        WebUser loggedInUser = null;
        if (webUserDAO != null) {
            loggedInUser = webUserDAO.validateUser(userID, password);
            System.out.println("LoggedInUser: " + loggedInUser); // Debug message
        } else {
            System.out.println("No WebUserDAO read");
            // Handle WebUserDAO not initialized
            request.setAttribute("errorMessage", "WebUserDAO not initialized");
            request.getRequestDispatcher("loginPage.jsp").forward(request, response);
            return;
        }

        HttpSession session = request.getSession();

        if (loggedInUser != null) {
            String role = loggedInUser.getRole();

            switch (role) {
                case "Admin":
                    // Set admin in session and redirect to admin page
                    session.setAttribute("loggedInUser", loggedInUser);
                    response.sendRedirect("adminOverview.jsp");
                    break;
                case "Teacher":
                    // Set teacher in session and redirect to teacher page
                    session.setAttribute("loggedInUser", loggedInUser);
                    response.sendRedirect("teacherOverview.jsp");
                    break;
                case "Student":
                    // Set student in session and redirect to student page
                    StudentDAO studentDAO=null;
                try {
                    studentDAO = new StudentDAO(DatabaseConnector.getConnection());
                } catch (SQLException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(studentDAO==null){
                    System.out.println("null studentDAO");
                }
                    Student loggedInStudent = studentDAO.getStudentByUserID(loggedInUser.getUserID());
                    session.setAttribute("loggedInUser", loggedInUser);
                    session.setAttribute("loggedInStudent", loggedInStudent);
                    response.sendRedirect("studentOverview.jsp");
                    break;
                default:
                    // Handle unknown role
                    request.setAttribute("errorMessage", "Unknown role");
                    request.getRequestDispatcher("loginPage.jsp").forward(request, response);
                    break;
            }
        } else {
            // Invalid user, show error message on login page
            System.out.println("Incorrect User ID or Password"); // Debug message
            request.setAttribute("errorMessage", "Incorrect User ID or Password");
            request.getRequestDispatcher("loginPage.jsp").forward(request, response);
        }
    }
}
