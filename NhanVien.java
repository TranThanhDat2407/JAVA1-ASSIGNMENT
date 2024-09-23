/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MOB1023_ASM;

import java.io.Serializable;

/**
 *
 * @author THANHDAT
 */
public class NhanVien implements Serializable{
    private String MaNV;
    private String TenNV;
    private int tuoi;
    private String email;
    private double luong;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String TenNV, int tuoi, String email, double luong) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.tuoi = tuoi;
        this.email = email;
        this.luong = luong;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }
    
    
}
