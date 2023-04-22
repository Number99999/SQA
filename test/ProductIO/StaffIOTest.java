/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ProductIO;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author david
 */
public class StaffIOTest {
    
    public StaffIOTest() {
    }

    
    @Test
    public void testCheckWithAvailable() {
        assertEquals(true,StaffIO.check("admin", "admin"));
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
