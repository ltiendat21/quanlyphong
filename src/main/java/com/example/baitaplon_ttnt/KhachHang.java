package com.example.baitaplon_ttnt;


import java.util.Objects;

public class KhachHang
{
    private String tenkh,cmt,gt;
    private Phong phong=null;
    private int tuoi;
    public KhachHang(){
        this("","","",0);
    }

    public KhachHang(String tenkh, String cmt, String gt, int tuoi) {
        this.tenkh=tenkh;
        this.cmt=cmt;
        this.gt=gt;
        this.tuoi=tuoi;
    }


    public String getTenkh() {
        return tenkh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }


    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getCmt() {
        return cmt;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }
    public String toString(){
        return "Tên: "+tenkh+"--- Cmt: "+cmt+"---Giới Tính: "+gt+"---Tuổi: "+tuoi;
    }
    public boolean equals(Object o) {
        if(this==o) return true;
        if(o==null|| getClass()!=o.getClass()) return false;
        KhachHang khachHang = (KhachHang) o;
        return khachHang.equals(khachHang.cmt);
    }
    public int hashCode() {
        return Objects.hash(cmt);
    }
}


