package Servlet;

import ProductIO.ProductIO;
import Product.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DeleteServlet", value = "/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String productCode = request.getParameter("productCode");
        Product product = ProductIO.getProduct(productCode);
        request.setAttribute("product", product);
        getServletContext().getRequestDispatcher("/delete.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action.equals("confirm")) {
            doPost_Confirm(request, response);
        } else if (action.equals("cancel")) {
            doPost_Cancel(request, response);
        }
    }

    protected void doPost_Confirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productCode = request.getParameter("productCode");
        ProductIO.delete(productCode);
        getServletContext().getRequestDispatcher("/products").forward(request, response);
    }

    protected void doPost_Cancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(getServletContext().getContextPath() + "/products");
    }
}
