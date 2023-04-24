/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ProductIO;

import Connection.DBConnection;
import Product.HoaDon;
import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HoaDonIOTest {
    private Connection conn;
    private HoaDon hd;

    @Before
    public void setUp() throws Exception {
        conn = DBConnection.getConnection();
        conn.setAutoCommit(false);
        hd = new HoaDon("HD001", "San pham 1", "2023-04-03", "1000", "10", "Looai 1");
        conn.commit();
    }

    @After
    public void tearDown() throws Exception {
        conn.rollback();
        conn.close();
    }

    @Test
    public void testSaveBill() {
        HoaDonIO.saveBill(hd);

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM hoadon WHERE ma = ?");
            pstmt.setString(1, hd.getMa());
            ResultSet rs = pstmt.executeQuery();
            assertEquals(true,rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Unexpected SQLException");
        }
    }
}
