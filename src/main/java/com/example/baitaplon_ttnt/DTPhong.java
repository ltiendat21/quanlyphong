package com.example.baitaplon_ttnt;

import java.util.Objects;

public class DTPhong
{

    public void DatPhong(Phong phong, KhachHang khachHang, int songaytro){
        if(!phong.CheckPhong()){
            khachHang.setPhong(phong);
            phong.setKhachHang(khachHang);
            phong.setSoNgayTro(songaytro);
            phong.setTrangthai("unavailable");
            System.out.println("Mã phòng "+phong.getMaphong()+"----- Cmt: " +khachHang.getCmt());
            System.out.println("Đặt phòng thành công");
        }
        else
            System.out.println("Phòng này đã được đặt");
    }
    public void TraPhong (Phong phong,KhachHang khachHang,int songaytro){
        if(khachHang.getPhong()==null)
            System.out.println("Khách hàng này chưa đặt phòng ");
        else if( phong.CheckPhong() && (khachHang.getPhong().getMaphong().equals(phong.getMaphong())) && songaytro==(phong.getSoNgayTro())){
            khachHang.setPhong(null);
            phong.setKhachHang(null);
            phong.setSoNgayTro(0);
            phong.setTrangthai("available");
            System.out.println("Mã phòng "+phong.getMaphong()+"----- Cmt: " +khachHang.getCmt()+" số tiền phải trả: "+songaytro* phong.getGiaphong());
            System.out.println("Trả phòng thành công");
        }
        else
            System.out.println("Phòng chưa được thuê hoặc Sai khách trả hoặc sai ngày trọ");
    }
}
