/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Product;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tan Dat
 */
public class ProductTest {
    
    @Test
    public void testConstructorAndGetters() {
        // create a new Product object
        Product p = new Product("P001", "Test Product", "10.00", "15.00", "Test Type");

        // check that the getters return the correct values
        assertEquals("P001", p.getMa());
        assertEquals("Test Product", p.getTen());
        assertEquals("10.00", p.getGianhap());
        assertEquals("15.00", p.getGiaban());
        assertEquals("Test Type", p.getLoai());
    }

    @Test
    public void testSetters() {
        // create a new Product object
        Product p = new Product("P001", "Test Product", "10.00", "15.00", "Test Type");

        // change some values using the setters
        p.setTen("New Product Name");
        p.setGianhap("20.00");

        // check that the getters return the updated values
        assertEquals("P001", p.getMa());
        assertEquals("New Product Name", p.getTen());
        assertEquals("20.00", p.getGianhap());
        assertEquals("15.00", p.getGiaban());
        assertEquals("Test Type", p.getLoai());
    }
    
}
