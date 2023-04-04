/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ProductIO;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tranh
 */
public class StaffIOTest {

    public StaffIOTest() {
    }

    @Test
    public void testCheck() {
        assertEquals(true, StaffIO.check("admin", "admin"));
    }

    @Test
    public void testCheck1() {
        assertEquals(false, StaffIO.check("admin", "gfds"));
    }

    @Test
    public void testCheck2() {
        assertEquals(false, StaffIO.check("fd", "admin"));
    }

}
