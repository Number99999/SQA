/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Product;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Tan Dat
 */
public class HoaDonTest {
    
    private HoaDon hoaDon;

    @Before
    public void setUp() {
        hoaDon = new HoaDon("001", "Hoa don 1", "2023-04-05", "100000", "10", "Loai 1");
    }

    @Test
    public void testGetMa() {
        assertEquals("001", hoaDon.getMa());
    }

    @Test
    public void testGetTen() {
        assertEquals("Hoa don 1", hoaDon.getTen());
    }

    @Test
    public void testGetNgay() {
        assertEquals("2023-04-05", hoaDon.getNgay());
    }

    @Test
    public void testGetGianhap() {
        assertEquals("100000", hoaDon.getGianhap());
    }

    @Test
    public void testGetSoluong() {
        assertEquals("10", hoaDon.getSoluong());
    }

    @Test
    public void testGetLoai() {
        assertEquals("Loai 1", hoaDon.getLoai());
    }

    @Test
    public void testSetMa() {
        hoaDon.setMa("002");
        assertEquals("002", hoaDon.getMa());
    }

    @Test
    public void testSetTen() {
        hoaDon.setTen("Hoa don 2");
        assertEquals("Hoa don 2", hoaDon.getTen());
    }

    @Test
    public void testSetNgay() {
        hoaDon.setNgay("2023-04-06");
        assertEquals("2023-04-06", hoaDon.getNgay());
    }

    @Test
    public void testSetGianhap() {
        hoaDon.setGianhap("200000");
        assertEquals("200000", hoaDon.getGianhap());
    }

    @Test
    public void testSetSoluong() {
        hoaDon.setSoluong("20");
        assertEquals("20", hoaDon.getSoluong());
    }

    @Test
    public void testSetLoai() {
        hoaDon.setLoai("Loai 2");
        assertEquals("Loai 2", hoaDon.getLoai());
    }
}
