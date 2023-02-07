package com.example.shop_app.model;

public class SanPham {
    private int anh;
    private String name;
    private String gia;
    private String number;

    public SanPham(int anh, String name, String gia, String number) {
        this.anh = anh;
        this.name = name;
        this.gia = gia;
        this.number = number;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "anh=" + anh +
                ", name='" + name + '\'' +
                ", gia='" + gia + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
