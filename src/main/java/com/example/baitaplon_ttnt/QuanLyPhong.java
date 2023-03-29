package com.example.baitaplon_ttnt;


import java.io.*;
import java.util.*;

public class QuanLyPhong {
    public Set<Phong> listphong;
    public LinkedList<Phong> list;

    public QuanLyPhong() {
        this.listphong = new LinkedHashSet<Phong>();
    }

    public QuanLyPhong(Set<Phong> listphong) {
        this.listphong = listphong;
    }

    public LinkedList<Phong> getList() {
        return new LinkedList<>(listphong);
    }

    public void addPhong(Phong phong) {
        if (!listphong.contains(phong)) {
            listphong.add(phong);
        }
    }

    public void removePhong(Phong phong) {
        list = new LinkedList<Phong>(listphong);
        int i = list.indexOf(phong);
        removePhong(i);
    }

    public void removePhong(int vt) {

        list.remove(list.get(vt));
        listphong.clear();
        listphong.addAll(list);
    }

    public void suaThongtinPhong(Phong phong) {
        list = new LinkedList<Phong>(listphong);
        int i = list.indexOf(phong);
        suaThongtinPhong(i);
    }

    public void suaThongtinPhong(int vt) {
        Scanner input = new Scanner(System.in);
        list = new LinkedList<>(listphong);
        Phong phong = list.get(vt);
        System.out.println("\tBạn muốn sửa thông tin gì\n1 1. Mã phòng\n2 2. Loại phòng\n3 3. Giá phòng\n4 4.Cả 4\n Chọn: ");
        int chon = input.nextInt();
        while (chon < 1 || chon > 4) {
            System.out.print("Chọn sai mời nhập lại ");
            System.out.print("Chọn: ");
            chon = input.nextInt();


        }
        switch (chon) {
            case 1:
                System.out.print("Nhập Mã phòng: ");
                input.nextLine();
                String mphong = input.nextLine();
                phong.setMaphong(mphong);
                break;
            case 2:
                System.out.print("Nhập Loại phòng: ");
                input.nextLine();
                String lphong = input.nextLine();
                phong.setLoaiphong(lphong);
                break;
            case 3:
                System.out.print("Giá phòng: ");
                int giaphong = input.nextInt();
                phong.setGiaphong(giaphong);
                break;
            case 4:
                System.out.print("Nhập Mã phòng: ");
                input.nextLine();
                String mp = input.nextLine();
                phong.setMaphong(mp);
                System.out.print("Nhập Loại phòng: ");
                String lp = input.nextLine();
                phong.setLoaiphong(lp);
                System.out.print("Giá phòng: ");
                int gp = input.nextInt();
                phong.setGiaphong(gp);
                break;
        }
        list.set(vt, phong);
        listphong.clear();
        listphong.addAll(list);
    }

    public void HienThi() {
        for (Phong key : listphong) {
            System.out.println(key.toString());
        }
    }

    public String locPhong() {
        list = new LinkedList<Phong>(listphong);
        int Trong = 0;
        int khongTrong = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).CheckPhong() == true)
                khongTrong++;
            else
                Trong++;
        }
        String s1 = "Không trống: " + khongTrong + "\n";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).CheckPhong())
                s1 += "\t " + list.get(i).toString() +"\t  Cmt: "+list.get(i).getKhachHang().getCmt()+"\t Thuê: "+list.get(i).getSoNgayTro() + "Ngày\n";
        }
        s1 += "Trống: " + Trong + "\n";
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).CheckPhong())
                s1 += "\t " + list.get(i).toString() + "\n";
        }
        return s1;
    }





    public static void main(String[] args) throws IOException {
        QuanLyPhong qlp= new QuanLyPhong();
        Phong p1 = new Phong("A","Vip",500,"available",0,"");
        Phong p2 = new Phong("A1","BinhThuong",300,"available",0,"");
        Phong p3 = new Phong("A2","BinhThuong",300,"available",0,"");
        qlp.addPhong(p1);
        qlp.addPhong(p2);
        qlp.addPhong(p3);
        qlp.HienThi();
        KhachHang kh1 = new KhachHang("T","01","Nam",18);
        KhachHang kh2 = new KhachHang("T1","02","Nu",19);
        KhachHang kh3 = new KhachHang("T2","03","Nu",17);
        KhachHang kh4 = new KhachHang("T3","04","Nu",15);
        KhachHang kh5 = new KhachHang("T4","05","Nam",18);
        DTPhong dt = new DTPhong();
        dt.DatPhong(p1,kh1,3);
        dt.TraPhong(p1,kh1,3);
        dt.DatPhong(p2,kh3,5);
        dt.DatPhong(p1,kh1,7);
        dt.TraPhong(p1,kh5,3);
        System.out.println(qlp.locPhong());
        qlp.HienThi();

        File file = new File(qlp);
        file.GhiFile();
        file.DocFile();

//        System.out.println(qlp.locPhong());
//        qlp.HienThi();
//        qlp.HienThi();
//        System.out.println("5"+kh1.getPhong());

//        System.out.println("--------------------------------------");
//        qlp.removePhong(new Phong("A5","Vip",500));
//        qlp.HienThi();
//        System.out.println("--------------------------------------");
//        qlp.suaThongtinPhong(new Phong("A4","BinhThuong",300), new Phong("A6","Vip",500));
//        qlp.HienThi();
//        System.out.println("--------------------------------------");*/
    }


}
