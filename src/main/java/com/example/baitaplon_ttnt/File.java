package com.example.baitaplon_ttnt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class File {
    private QuanLyPhong qlp;
    public File(QuanLyPhong qlp){
        this.qlp=qlp;
    }
    void GhiFile() throws IOException {
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("/Users/nguyentienthuan/Downloads/BaiTapLon_TTNT/src/main/java/com/example/baitaplon_ttnt/QuanLyPhong.dat");
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            for (int i = 0; i < qlp.getList().size(); i++) {
                bufferedOutputStream.write((qlp.getList().get(i).getMaphong() + "-" + qlp.getList().get(i).getLoaiphong() + "-" + qlp.getList().get(i).getGiaphong() + "\n").getBytes(StandardCharsets.UTF_8));
            }
            System.out.println("Lưu phải thành công");
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi");
        } finally {
            bufferedOutputStream.close();
            fileOutputStream.close();
        }
    }
    void DocFile() throws IOException {

        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            fileInputStream = new FileInputStream("/Users/nguyentienthuan/Downloads/BaiTapLon_TTNT/src/main/java/com/example/baitaplon_ttnt/QuanLyPhong.dat");
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println("Đã đọc xong");
        } catch (FileNotFoundException e) {
            System.out.println("Gặp lỗi");
        } finally {
            fileInputStream.close();
            bufferedInputStream.close();
        }

    }
}
