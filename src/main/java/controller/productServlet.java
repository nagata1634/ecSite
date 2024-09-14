package controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.beans.Page;
import model.beans.Product;
import model.dao.ProductDao;
import model.dao.ProductDaoImpl;

/**
 * Servlet implementation class productServlet
 */
@WebServlet("/product")
public class productServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public productServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        int PAGEITEM = 51;
        String strPage =request.getParameter("page");
        int page = (strPage == null) ? 0 : Integer.parseInt(strPage);
        ProductDao dao = new ProductDaoImpl();
        List<Product> products = dao.list(PAGEITEM, page * PAGEITEM);
        Optional<Integer> productPieices = dao.pieces();
        
        Page pageBeans = new Page(page, productPieices: );

        request.setAttribute("products", products);
        request.setAttribute("page", pageBeans);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/productList.jsp");

        dispatcher.forward(request, response);



    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
