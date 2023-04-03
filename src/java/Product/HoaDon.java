/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Product;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 *
 * @author tranh
 */
public class HoaDon implements Serializable {
    private String ma;
    private String ten;
    private String ngay;
    private String gianhap;
    private String soluong;
    private String loai;

    public HoaDon() {
    }

    public HoaDon(String ma, String ten, String ngay, String gianhap, String soluong, String loai) {
        this.ma = ma;
        this.ten = ten;
        this.ngay = ngay;
        this.gianhap = gianhap;
        this.soluong = soluong;
        this.loai = loai;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getNgay() {
        return ngay;
    }

    public String getGianhap() {
        return gianhap;
    }

    public String getSoluong() {
        return soluong;
    }

    public String getLoai() {
        return loai;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public void setGianhap(String gianhap) {
        this.gianhap = gianhap;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
 
    
}
