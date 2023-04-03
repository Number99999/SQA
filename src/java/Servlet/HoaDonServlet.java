/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Product.HoaDon;
import Product.Product;
import ProductIO.HoaDonIO;
import ProductIO.ProductIO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tranh
 */
@WebServlet(name = "HoaDonServlet", value = "/bills")
public class HoaDonServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Product> products = ProductIO.getProducts();
        request.setAttribute("products", products);
        LocalDate cDate = LocalDate.now();

        HttpSession session = request.getSession();
        ArrayList<HoaDon> list = new ArrayList<>();
        ArrayList<HoaDon> listOut = new ArrayList<>();
        session.setAttribute("list", listOut);
        String ma = request.getParameter("productCode");
        HoaDon hd = new HoaDon();
        Product p = ProductIO.getProduct(ma);
        hd.setMa(p.getMa());
        hd.setTen(p.getTen());
        hd.setGianhap(p.getGianhap());
        hd.setLoai(p.getLoai());
        hd.setNgay(cDate.toString());
        list.add(hd);
        listOut = (ArrayList<HoaDon>) session.getAttribute("list");
        listOut.add(hd);
        session.setAttribute("hoadon", hd);
        request.setAttribute("list", listOut);

        getServletContext().getRequestDispatcher("/hoaDon.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LocalDate cDate = LocalDate.now();
        String ma = request.getParameter("ma");
        String soluong = request.getParameter("soluong");
        Product product = ProductIO.getProduct(ma);
        HoaDon hoadon = new HoaDon();
        hoadon.setMa(product.getMa());
        hoadon.setTen(product.getTen());
        hoadon.setGianhap(product.getGianhap());
        hoadon.setLoai(product.getLoai());
        hoadon.setSoluong(soluong);
        hoadon.setNgay(cDate.toString());
        HoaDonIO.saveBill(hoadon);
        ArrayList<Product> products = ProductIO.getProducts();
        request.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/hoaDon.jsp").forward(request, response);
    }

}
