/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ProductIO;

import Connection.DBConnection;
import java.sql.Connection;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author david
 */
public class StaffIOTest {

    private Connection conn;

    @Before
    public void setUp() throws Exception {
        conn = DBConnection.getConnection();
        conn.commit();
    }

    @After
    public void tearDown() throws Exception {
        conn.rollback();
        conn.close();
    }

    public StaffIOTest() {
    }

    @Test
    public void testCheckWithAvailable() {
        assertEquals(true, StaffIO.check("admin", "admin"));
    }

    @Test
    public void testCheckWithWrongPassword() {
        assertEquals(false, StaffIO.check("admin", "gfds"));
    }

    @Test
    public void testCheckWithWrongUsername() {
        assertEquals(false, StaffIO.check("fd", "admin"));
    }

}
