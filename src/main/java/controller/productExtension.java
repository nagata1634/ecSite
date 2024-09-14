package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.beans.Product;
import model.dao.ProductDaoImpl;

/**
 * Servlet implementation class productExtension
 */

@WebServlet("/productextension")
public class productExtension extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public productExtension() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

        String idStr = request.getParameter("productId");
        int productId = 0;
        try {
            productId = Integer.parseInt(idStr);
        } catch(NumberFormatException e) {
            e.printStackTrace();
        }


        ProductDaoImpl dao = new ProductDaoImpl();

        Product product = dao.search(productId);

        request.setAttribute("product", product);


        RequestDispatcher dispather = request.getRequestDispatcher("WEB-INF/productExtension.jsp");
        dispather.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
