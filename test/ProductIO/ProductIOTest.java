/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ProductIO;

import Product.Product;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tranh
 */
public class ProductIOTest {

    public ProductIOTest() {
    }

    @Test
    public void testGetProducts() {
        ArrayList<Product> products = ProductIO.getProducts();
        assertNotNull(products);
        assertFalse(products.isEmpty());
    }

    @Test
    public void testGetProduct() {
        String productCode = "ABC123";
        Product product = ProductIO.getProduct(productCode);
        assertNotNull(product);
        assertEquals(productCode, product.getMa());
    }

    @Test
    public void testExists() {
        String productCode = "ABC123";
        boolean exists = ProductIO.exists(productCode);
        assertTrue(exists);
    }

}
