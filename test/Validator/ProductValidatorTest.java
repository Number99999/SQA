/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Validator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tranh
 */
public class ProductValidatorTest {
    
    public ProductValidatorTest() {
    }

@Test
    public void testIsValidWithValidProduct() {
        ProductValidator validator = new ProductValidator();
        validator.setMa("MH01");
        validator.setTen("Product 1");
        validator.setGianhap("1000");
        validator.setGiaban("1500");
        validator.setLoai("Loai 1");
        boolean result = validator.isValid();
        assertTrue(result);
        assertEquals("", validator.getError());
    }

    @Test
    public void testIsValidWithInvalidMa() {
        ProductValidator validator = new ProductValidator();
        validator.setMa("");
        validator.setTen("Product 1");
        validator.setGianhap("1000");
        validator.setGiaban("1500");
        validator.setLoai("Loai 1");
        boolean result = validator.isValid();
        assertFalse(result);
        assertEquals("Ma mat hang khong duoc de trong", validator.getError());
    }

    @Test
    public void testIsValidWithInvalidTen() {
        ProductValidator validator = new ProductValidator();
        validator.setMa("MH01");
        validator.setTen("");
        validator.setGianhap("1000");
        validator.setGiaban("1500");
        validator.setLoai("Loai 1");
        boolean result = validator.isValid();
        assertFalse(result);
        assertEquals("Ten mat hang khong duoc de trong", validator.getError());
    }

    @Test
    public void testIsValidWithInvalidGianhap() {
        ProductValidator validator = new ProductValidator();
        validator.setMa("MH01");
        validator.setTen("Product 1");
        validator.setGianhap("");
        validator.setGiaban("1500");
        validator.setLoai("Loai 1");
        boolean result = validator.isValid();
        assertFalse(result);
        assertEquals("Gia nhap khong duoc de trong", validator.getError());
    }

    @Test
    public void testIsValidWithInvalidGiaban() {
        ProductValidator validator = new ProductValidator();
        validator.setMa("MH01");
        validator.setTen("Product 1");
        validator.setGianhap("1000");
        validator.setGiaban("");
        validator.setLoai("Loai 1");
        boolean result = validator.isValid();
        assertFalse(result);
        assertEquals("Gia ban khong duoc de trong", validator.getError());
    }

    @Test
    public void testIsValidWithInvalidLoai() {
        ProductValidator validator = new ProductValidator();
        validator.setMa("MH01");
        validator.setTen("Product 1");
        validator.setGianhap("1000");
        validator.setGiaban("1500");
        validator.setLoai("");
        boolean result = validator.isValid();
        assertFalse(result);
        assertEquals("Loai mat hang khong duoc de trong", validator.getError());
    }
    
}
