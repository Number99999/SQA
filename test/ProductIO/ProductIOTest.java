/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ProductIO;

import Product.Product;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author david
 */
public class ProductIOTest {
    
    public ProductIOTest() {
    }

    @Before
    public void setUp() throws Exception {
        // Khởi tạo các đối tượng cần thiết cho việc test
        // Nếu có thể, kết nối đến cơ sở dữ liệu thực và tạo các bản ghi tạm thời để test
    }
    
    @After
    public void tearDown() throws Exception {
        // Giải phóng các tài nguyên được sử dụng trong quá trình test
        // Nếu có thể, xóa các bản ghi tạm thời được tạo ra trong quá trình test
    }

    @Test
    public void testGetProducts() {
        ArrayList<Product> products = ProductIO.getProducts();
        assertEquals(false, products.isEmpty());

    }
    
    @Test
    public void testGetProduct() {
        Product product = ProductIO.getProduct("P002");
        assertEquals(false, product.equals(null));
        assertEquals("P002", product.getMa());
    }
    
    @Test
    public void testExists() {
        boolean exists = ProductIO.exists("P001");
        assertEquals(true, exists);
    }
    
    @Test
    public void testInsert() {
        Product product = new Product();
        product.setMa("DEF456");
        product.setTen("Test Product");
        product.setGianhap("100000");
        product.setGiaban("150000");
        product.setLoai("Test");

        ProductIO.insert(product);
        boolean exists = ProductIO.exists("DEF456");
        assertEquals(true, exists);
    }
    
    @Test
    public void testUpdate() {
        Product product = new Product();
        product.setMa("P002");
        product.setTen("Updated Product");
        product.setGianhap("100000");
        product.setGiaban("150000");
        product.setLoai("Test");

        ProductIO.update(product, "P002");
        Product updatedProduct = ProductIO.getProduct("P002");
        assertEquals("Updated Product", updatedProduct.getTen());
    }
    
    @Test
    public void testDelete() {
        ProductIO.delete("P003");
        boolean exists = ProductIO.exists("P003");
        assertFalse(exists);
    }

    
}
