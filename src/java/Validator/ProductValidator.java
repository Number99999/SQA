package Validator;

import ProductIO.ProductIO;

import java.math.BigDecimal;

public class ProductValidator {

    private String ma;
    private String ten;
    private String gianhap;
    private String giaban;
    private String loai;
    private String error;

    public ProductValidator() {
        this.error = "";
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

    public boolean isValid() {
        if (ma == null || ma.trim().isEmpty()) {
            error = "Ma mat hang khong duoc de trong";
            return false;
        }

        if (ten == null || ten.trim().isEmpty()) {
            error = "Ten mat hang khong duoc de trong";
            return false;
        }
        if (gianhap == null || gianhap.trim().isEmpty()) {
            error = "Gia nhap khong duoc de trong";
            return false;
        }
        else {
            try {
                BigDecimal priceConverted = BigDecimal.valueOf(Double.parseDouble(gianhap));
            } catch (NumberFormatException e) {
                error = "Gia nhap khong hop le";
                return false;
            }
        }
        if (giaban == null || giaban.trim().isEmpty()) {
            error = "Gia ban khong duoc de trong";
            return false;
        } 
        else {
            try {
                BigDecimal priceConverted = BigDecimal.valueOf(Double.parseDouble(giaban));
            } catch (NumberFormatException e) {
                error = "Gia ban khong hop le";
                return false;
            }
        }
        if(loai == null || loai.trim().isEmpty()){
            error = "Loai mat hang khong duoc de trong";
            return false;
        }
        
        return true;
    }

    public String getError() {
        return error;
    }
}
