/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductIO;

import Connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tranh
 */
public class StaffIO {
    public static boolean check(String username, String password){
        String  pw = null;
        try{
            Connection conn = DBConnection.getConnection();
            String GET_USER = "SELECT password FROM staff WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(GET_USER);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                pw = rs.getString("password");
            }
            conn.close();
       
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return password == null ? pw == null : password.equals(pw);
    }
}
