package Product;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.io.Serializable;
public class Product implements Serializable
{
    private String ma;
    private String ten;
    private String gianhap;
    private String giaban;
    private String loai;

    public Product() {
    }

    public Product(String ma, String ten, String gianhap, String giaban, String loai) {
        this.ma = ma;
        this.ten = ten;
        this.gianhap = gianhap;
        this.giaban = giaban;
        this.loai = loai;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getGianhap() {
        return gianhap;
    }

    public String getGiaban() {
        return giaban;
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

    public void setGianhap(String gianhap) {
        this.gianhap = gianhap;
    }

    public void setGiaban(String giaban) {
        this.giaban = giaban;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
    
}