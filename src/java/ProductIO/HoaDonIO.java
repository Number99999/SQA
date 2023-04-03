/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductIO;

import Connection.DBConnection;
import Product.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author tranh
 */
public class HoaDonIO {
    public static void saveBill(HoaDon hd){
        try{
            Connection conn = DBConnection.getConnection();
            String INSERT_BILL = "INSERT INTO hoadon (ma, ten, gianhap, loai, ngay, soluong) VALUE (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(INSERT_BILL);
            pstmt.setString(1, hd.getMa());
            pstmt.setString(2, hd.getTen());
            pstmt.setString(3, hd.getGianhap());
            pstmt.setString(4, hd.getLoai());
            pstmt.setString(5, hd.getNgay());
            pstmt.setString(6, hd.getSoluong());
            pstmt.executeUpdate();
            
            conn.close();
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
