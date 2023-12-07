
import ict.bean.Student;
import ict.bean.WebUser;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userID = request.getParameter("userid");
        String password = request.getParameter("password");

        // Validate the user
        WebUserDAO webUserDAO = null;
        try {
            webUserDAO = new WebUserDAO(DatabaseConnector.getConnection());
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            // Handle database connection error
            request.setAttribute("errorMessage", "Database connection error");
            request.getRequestDispatcher("loginPage.jsp").forward(request, response);
            return;
        }

        WebUser loggedInUser = null;
        if (webUserDAO != null) {
            loggedInUser = webUserDAO.validateUser(userID, password);
        } else {
            System.out.println("No WebUserDAO read");
            // Handle WebUserDAO not initialized
            request.setAttribute("errorMessage", "WebUserDAO not initialized");
            request.getRequestDispatcher("loginPage.jsp").forward(request, response);
            return;
        }

        if (loggedInUser != null) {
            String role = loggedInUser.getRole();
            HttpSession session = request.getSession();

            switch (role) {
                case "admin":
                    // Set admin in session and redirect to admin page
                    session.setAttribute("loggedInAdmin", loggedInUser);
                    response.sendRedirect("adminOverview.jsp");
                    break;
                case "teacher":
                    // Set teacher in session and redirect to teacher page
                    session.setAttribute("loggedInTeacher", loggedInUser);
                    response.sendRedirect("teacherOverview.jsp");
                    break;
                case "student":
                    // Set student in session and redirect to student page
                    try {
                    StudentDAO studentDAO = new StudentDAO(DatabaseConnector.getConnection());
                    Student loggedInStudent = studentDAO.getStudentByUserID(loggedInUser.getUserID());

                    if (loggedInStudent != null) {
                        session.setAttribute("loggedInStudent", loggedInStudent);
                        response.sendRedirect("studentOverview.jsp");
                    } else {
                        // Student information not found, handle accordingly
                        request.setAttribute("errorMessage", "Student information not found");
                        request.getRequestDispatcher("loginPage.jsp").forward(request, response);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                    // Handle database error for student
                    request.setAttribute("errorMessage", "Database error for student");
                    request.getRequestDispatcher("loginPage.jsp").forward(request, response);
                }
                break;
                default:
                    // Unknown role, handle accordingly
                    request.setAttribute("errorMessage", "Unknown role");
                    request.getRequestDispatcher("loginPage.jsp").forward(request, response);
            }
        } else {
            // Invalid user, show error message on login page
            request.setAttribute("errorMessage", "Incorrect User ID or Password");
            request.getRequestDispatcher("loginPage.jsp").forward(request, response);
        }
        HttpSession session = request.getSession();
        session.setAttribute("userId", userID);
    }
}
