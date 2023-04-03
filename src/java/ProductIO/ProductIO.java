package ProductIO;

import java.sql.*;
import java.util.*;

import Connection.DBConnection;
import Product.Product;

public class ProductIO {

    public static ArrayList<Product> getProducts() {
        ArrayList<Product> products = null;
        try {
            Connection conn = DBConnection.getConnection();
            String GET_ALL_PRODUCTS_QUERY = "SELECT ma, ten, gianhap, giaban, loai FROM product";
            PreparedStatement pstmt = conn.prepareStatement(GET_ALL_PRODUCTS_QUERY);
            ResultSet rs = pstmt.executeQuery();
            products = new ArrayList<Product>();
            while (rs.next()) {
                Product product = new Product();
                product.setMa(rs.getString("ma"));
                product.setTen(rs.getString("ten"));
                product.setGianhap(rs.getString("gianhap"));
                product.setGiaban(rs.getString("giaban"));
                product.setLoai(rs.getString("loai"));

                products.add(product);
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static Product getProduct(String productCode) {
        Product product = null;
        try {
            Connection conn = DBConnection.getConnection();
            String GET_PRODUCT_QUERY = "SELECT ma, ten, gianhap, giaban, loai FROM product WHERE ma = ?";
            PreparedStatement pstmt = conn.prepareStatement(GET_PRODUCT_QUERY);
            pstmt.setString(1, productCode);
            ResultSet rs = pstmt.executeQuery();
            product = new Product();
            while (rs.next()) {
                product.setMa(rs.getString("ma"));
                product.setTen(rs.getString("ten"));
                product.setGianhap(rs.getString("gianhap"));
                product.setGiaban(rs.getString("giaban"));
                product.setLoai(rs.getString("loai"));
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }

    public static boolean exists(String productCode) {
        try {
            Connection conn = DBConnection.getConnection();
            String GET_PRODUCT_QUERY = "SELECT ma FROM product WHERE ma = ?";
            PreparedStatement pstmt = conn.prepareStatement(GET_PRODUCT_QUERY);
            pstmt.setString(1, productCode);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void saveProducts(ArrayList<Product> products) {
        try {
            Connection conn = DBConnection.getConnection();
            String INSERT_PRODUCT_QUERY = "INSERT INTO product (ma, ten, gianhap, giaban, loai) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(INSERT_PRODUCT_QUERY);
            for (Product product : products) {
                pstmt.setString(1, product.getMa());
                pstmt.setString(2, product.getTen());
                pstmt.setString(3, product.getGianhap());
                pstmt.setString(4, product.getGiaban());
                pstmt.setString(5, product.getLoai());
                pstmt.executeUpdate();
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void insert(Product product) {
        try {
            Connection conn = DBConnection.getConnection();
            String INSERT_PRODUCT_QUERY = "INSERT INTO product (ma, ten, gianhap, giaban, loai) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(INSERT_PRODUCT_QUERY);
            pstmt.setString(1, product.getMa());
            pstmt.setString(2, product.getTen());
            pstmt.setString(3, product.getGianhap());
            pstmt.setString(4, product.getGiaban());
            pstmt.setString(5, product.getLoai());
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void update(Product product, String productCode) {
        try {
            Connection conn = DBConnection.getConnection();
            String UPDATE_PRODUCT_QUERY = "UPDATE product SET ma = ?, ten = ?, gianhap = ?, giaban = ?, loai = ? WHERE ma = ?";
            PreparedStatement pstmt = conn.prepareStatement(UPDATE_PRODUCT_QUERY);
            pstmt.setString(1, productCode);
            pstmt.setString(2, product.getTen());
            pstmt.setString(3, product.getGianhap());
            pstmt.setString(4, product.getGiaban());
            pstmt.setString(5, product.getLoai());
            pstmt.setString(6, product.getMa());

            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void delete(String productCode) {
        try {
            Connection conn = DBConnection.getConnection();
            String DELETE_PRODUCT_QUERY = "DELETE FROM product WHERE ma = ?";
            PreparedStatement pstmt = conn.prepareStatement(DELETE_PRODUCT_QUERY);
            pstmt.setString(1, productCode);
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkUser(String username, String password) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "Select * from user where username =? and password = ?";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, username);
            pre.setString(2, password);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Lỗi dòng 160 checkUser");
        }
        return false;
    }

    public static String getUser(String username, String password) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "Select * from user where username = ? and password = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                String s = result.getString("username");
                return s;

            }
        } catch (Exception e) {
            System.out.println("Lỗi dòng 173 getUser");
        }
        return "khong load duoc";

    }
}
