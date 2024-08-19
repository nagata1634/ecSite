package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.beans.Product;
import model.beans.User;
import model.dao.CartDao;
import model.dao.CartDaoImpl;

/**
 * Servlet implementation class CartServlet
 */

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String productIdStr = request.getParameter("productId");
        String userIdStr = request.getParameter("userId");
//        String userIdStr = "2";
        boolean result = false;
        try {
            int productId = Integer.parseInt(productIdStr);
            int userId = Integer.parseInt(userIdStr);

            CartDao dao = new CartDaoImpl();

            result = dao.addCart(userId, productId);
        } catch(NumberFormatException e) {
            e.printStackTrace();
        }

        if (result) {
            response.sendRedirect("product");
        } else {
            response.sendRedirect("view/errer.jsp");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("view/product");
        }

        CartDao dao = new CartDaoImpl();
        List<Product> productList = dao.getCartList(user.getId());

        request.setAttribute("products", productList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/Cart.jsp");
        dispatcher.forward(request, response);
    }

}
