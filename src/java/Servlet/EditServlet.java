package Servlet;

import Validator.ProductValidator;
import ProductIO.ProductIO;
import Product.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "EditServlet", value = "/edit")
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        String url = "/products.jsp";
        if (Objects.equals(action, "create")) {
            url = "/edit.jsp";
        } else if (Objects.equals(action, "update")) {
            url = "/edit.jsp";
            request.setAttribute("isUpdate", true);
            String productCode = request.getParameter("productCode");
            Product product = ProductIO.getProduct(productCode);
            request.setAttribute("ma", product.getMa());
            request.setAttribute("ten", product.getTen());
            request.setAttribute("gianhap", product.getGianhap());
            request.setAttribute("giaban", product.getGiaban());
            request.setAttribute("loai", product.getLoai());

        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            response.sendRedirect(getServletContext().getContextPath() + "/products.jsp");
        }
        if (Objects.equals(action, "create")) {
            doPost_Create(request, response);
        } else if (Objects.equals(action, "update")) {
            doPost_Update(request, response);
        }

    }

    protected void doPost_Create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/edit.jsp";
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String gianhap = request.getParameter("gianhap");
        String giaban = request.getParameter("giaban");
        String loai = request.getParameter("loai");
        ProductValidator validator = new ProductValidator();
        validator.setMa(ma);
        validator.setTen(ten);
        validator.setGianhap(gianhap);
        validator.setGiaban(giaban);
        validator.setLoai(loai);

        if (ProductIO.exists(ma)) {
            request.setAttribute("error", "Ma mat hang da ton tai");
        } else if (validator.isValid()) {
            Product product = new Product();
            product.setMa(ma);
            product.setTen(ten);
            product.setGianhap(gianhap);
            product.setGiaban(giaban);
            product.setLoai(loai);
            ProductIO.insert(product);
            url = "/products";
            response.sendRedirect(getServletContext().getContextPath() + url);
            return;
        } else {
            request.setAttribute("error", validator.getError());
            request.setAttribute("ma", ma);
            request.setAttribute("ten", ten);
            request.setAttribute("gianhap", gianhap);
            request.setAttribute("giaban", giaban);
            request.setAttribute("loai", loai);

        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void doPost_Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/edit.jsp";
        request.setAttribute("isUpdate", true);
        String productCode = request.getParameter("productCode");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String gianhap = request.getParameter("gianhap");
        String giaban = request.getParameter("giaban");
        String loai = request.getParameter("loai");
        ProductValidator validator = new ProductValidator();
        validator.setMa(ma);
        validator.setTen(ten);
        validator.setGianhap(gianhap);
        validator.setGiaban(giaban);
        validator.setLoai(loai);
        
        if (validator.isValid()) {
            Product product = new Product();
            product.setMa(ma);
            product.setTen(ten);
            product.setGianhap(gianhap);
            product.setGiaban(giaban);
            product.setLoai(loai);
            ProductIO.update(product, productCode);
            url = "/products";
            response.sendRedirect(getServletContext().getContextPath() + url);
            return;
        } else {
            request.setAttribute("error", validator.getError());
            request.setAttribute("ma", ma);
            request.setAttribute("ten", ten);
            request.setAttribute("gianhap", gianhap);
            request.setAttribute("giaban", giaban);
            request.setAttribute("loai", loai);
            
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
