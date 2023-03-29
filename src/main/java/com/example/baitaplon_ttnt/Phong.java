package com.example.baitaplon_ttnt;

import java.util.Objects;

import java.util.Objects;

public class Phong
{
    public String maphong,loaiphong;
    public int giaphong;

    public String trangthai;
    private int SoNgayTro;
    private String SoCmtKhach;

    private KhachHang khachHang=null;

    public Phong()
    {
        this.maphong="";
        this.trangthai="available" ;
        this.giaphong=0;
        this.loaiphong="";
        this.SoNgayTro=0;
        this.SoCmtKhach="";
    }
    public Phong(String maphong, String loaiphong, int giaphong,String TrangThai,int SoNgayTro,String SoCmtKhach)
    {
        this.maphong=maphong;
        this.loaiphong=loaiphong;
        this.giaphong=giaphong;
        this.trangthai=TrangThai;
        this.SoNgayTro=SoNgayTro;
        this.SoCmtKhach=SoCmtKhach;

    }

    public void setSoCmtKhach(String soCmtKhach) {
        SoCmtKhach = soCmtKhach;
    }

    public String getSoCmtKhach() {
        return SoCmtKhach;
    }

    public void setSoNgayTro(int soNgayTro) {
        SoNgayTro = soNgayTro;
    }

    public int getSoNgayTro() {
        return SoNgayTro;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public boolean CheckPhong(){
        if(getKhachHang()!=null)
            return true;
        else
            return false;
    }

    public void setLoaiphong(String loaiphong) {
        this.loaiphong = loaiphong;
    }

    public String getLoaiphong() {
        return loaiphong;
    }

    public String getMaphong() {
        return maphong;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }

    public void setGiaphong(int giaphong) {
        this.giaphong = giaphong;
    }

    public int getGiaphong() {
        return giaphong;
    }

    public void setTrangthai(String Trangthai)
    {
        this.trangthai = Trangthai;
    }

    public String getTrangthai()
    {
        return trangthai;
    }

    public String toString(){
        return "Mã phòng: "+maphong+"- Loại phòng: "+loaiphong+"- Giá phòng: "+giaphong+"/Ngày "+"- Trạng thái: "+trangthai ;
    }
    public boolean equals(Object o) {
        if(this==o) return true;
        if(o==null|| getClass()!=o.getClass()) return false;
        Phong phong = (Phong) o;
        return maphong.equals(phong.maphong);
    }
    public int hashCode() {
        return Objects.hash(maphong);
    }



}
