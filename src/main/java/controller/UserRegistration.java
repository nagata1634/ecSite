package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.dao.UserDao;
import model.dao.UserDaoImpl;

/**
 * Servlet implementation class UserRegistration
 */

@WebServlet("/userregistration")
public class UserRegistration extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET");
        response.sendRedirect("view/userRegistrationForm.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("POST");
        String nameStr = request.getParameter("name");
        String passwordStr = request.getParameter("password");
        String isAdminStr = request.getParameter("isAdmin");

        boolean isAdmin = isAdminStr.equals("True") ? true: false;

        UserDao dao = new UserDaoImpl();

        boolean result = dao.registration(nameStr, passwordStr, isAdmin);

        if (!result) {
//        	登録が出来なかったら戻す
            System.out.println("registration errer");
            request.setAttribute("errer", "errer");
            response.sendRedirect("view/userRegistrationForm.jsp");
        } else {
//        	出来たらloginpageへ
            response.sendRedirect("login");
        }
    }

}
