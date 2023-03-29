package com.example.baitaplon_ttnt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController implements Initializable
{
    @FXML
    private TableView<Phong>TableDanhSachPhong;
    @FXML
    private TableColumn<Phong,String> cmd_MaPhong;
    @FXML
    private TableColumn<Phong,String> cmd_LoaiPhong;
    @FXML
    private TableColumn<Phong,Integer> cmd_GiaTien;
    @FXML
    private TableColumn<Phong,String> cmd_TrangThai;
    @FXML
    private TableColumn<Phong, Integer> cmd_SoNgaytro;


    @FXML
    private TextField Tf_MaPhong;

    @FXML
    private TextField Tf_LoaiPhong;

    @FXML
    private TextField Tf_GiaPhong;

    @FXML
    private TextField Tf_XoaPhongTheoMaPhong;

    @FXML
    TextField Tf_TenKhachDatPhong;
    @FXML
    TextField Tf_SoCmtKhachHang_DatPhong;
    @FXML
    TextField Tf_Maphong_DatPhong;
    @FXML
    TextField Tf_SoNgayTro;

    @FXML
    TextField Tf_Maphong_TraPhong1;
    @FXML
    TextField Tf_SoCMT_TraPhong;





    @FXML
    TextField Tf_LoaiPhong_FormThemPhong;
    @FXML
    TextField Tf_MaPhong_FormThemPhong;
    @FXML
    TextField Tf_GiaPhong_FormThemPhong;
    @FXML
    ImageView IM_Header;
    @FXML
    private TableColumn<Phong,String>cmd_SoCmtKhach;


    ObservableList<Phong> ListPhong = FXCollections.observableArrayList( //Khởi tạo list danh sách phòng mặc định
            new Phong("A1","Vip",500,"available",0,""),
            new Phong("A2","Thường",200,"available",0,""),
            new Phong("A3","Vip", 600,"available",0,"")
            );

    ArrayList<Phong> listphongcoppy= new ArrayList<Phong>(ListPhong);
    ObservableList<Phong> ListPhong1 = FXCollections.observableArrayList(ListPhong);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    @FXML
    void Btn_DanhSach (ActionEvent event) // Hàm hiển thị danh sách
    {
        cmd_LoaiPhong.setCellValueFactory(new PropertyValueFactory<Phong,String>("Loaiphong") );
        cmd_MaPhong.setCellValueFactory(new PropertyValueFactory<Phong,String>("maphong") );
        cmd_GiaTien.setCellValueFactory(new PropertyValueFactory<Phong,Integer>("giaphong"));
        cmd_TrangThai.setCellValueFactory(new PropertyValueFactory<Phong,String>("trangthai"));
        cmd_SoNgaytro.setCellValueFactory(new PropertyValueFactory<Phong,Integer>("SoNgayTro"));
        cmd_SoCmtKhach.setCellValueFactory(new PropertyValueFactory<Phong,String>("SoCmtKhach"));


        TableDanhSachPhong.setItems(ListPhong);

    }
    //Stage stage = new Stage();

    private void Load()
    {
        TableDanhSachPhong.refresh();
    }//Làm load lại dữ liệu

    Boolean CheckMaPhong(String MaPhong)// Hàm check xem mã phòng đã tồn tại hay chưa
    {
        int i=0;

        for(int j= 0 ; j <ListPhong.size();j++)
        {
            if (ListPhong.get(j).getMaphong().equals(MaPhong) == true)
            {
                i++;

            }
            else
            {}
        }
        if(i>0)
        {
            return true;
        }
        else {return false;}


    }


    @FXML
    void  Btn_ThemPhong(ActionEvent event) throws IOException // Hàm thêm phòng
    {
       /* Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("FormThemPhong.fxml"));
        stage.setTitle("Form Thêm phòng");
        stage.setScene(new Scene(root));
        stage.show();*/

        if(CheckMaPhong(Tf_MaPhong.getText())== true)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Thông báo");
            alert.setHeaderText("Mã phòng này đã tồn tại, không thể thêm");
            alert.show();
        }
        else
        {

                    Phong newphong= new Phong();
                    newphong.setMaphong(Tf_MaPhong.getText());
                    newphong.setLoaiphong(Tf_LoaiPhong.getText());
                    newphong.setGiaphong(Integer.parseInt(Tf_GiaPhong.getText()));
                    ListPhong.add(newphong);
                    listphongcoppy.add(newphong);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);

                    alert.setTitle("Thông báo");
                    alert.setHeaderText("Thêm phòng thành công");
                    alert.show();

        }


        Tf_LoaiPhong.setText("");
        Tf_GiaPhong.setText("");
        Tf_MaPhong.setText("");

    }

    private LinkedList<Phong> list; // Linked list để sao chép dữ liệu từ arraylist

    @FXML
    void Btn_XoaPhong(ActionEvent event)//Hàm xóa phòng
    {
        list= new LinkedList<Phong>(ListPhong);
        if(CheckMaPhong(Tf_XoaPhongTheoMaPhong.getText())==true)
        {
            for(int i= 0 ; i <list.size();i++)
            {
                if (list.get(i).getMaphong().equals(Tf_XoaPhongTheoMaPhong.getText()) == true)
                {
                    if(list.get(i).getTrangthai().equals("unavailable"))
                    {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Thông báo");
                        alert.setHeaderText("Phòng có  người, không thể xóa");
                        alert.show();
                        break;
                    }
                    else
                    {
                        list.remove(i);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);

                        alert.setTitle("Thông báo");
                        alert.setHeaderText("Xóa phòng thành công");
                        alert.show();
                        break;
                    }
                }
            }

        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Mã Phòng không phù hợp");
            alert.show();
        }
        ListPhong.clear();
        listphongcoppy.clear();
        ListPhong.addAll(list);
        listphongcoppy.addAll(list);
        Tf_XoaPhongTheoMaPhong.setText("");
        Load();

    }
    @FXML
    void Btn_SuaPhong() // Hàm sửa phòng
    {
        if(CheckMaPhong(Tf_XoaPhongTheoMaPhong.getText())==true)
        {
            for (int i =0 ; i <ListPhong.size();i++) {
                if (ListPhong.get(i).getMaphong().equals(Tf_XoaPhongTheoMaPhong.getText()) == true) {
                    ListPhong.get(i).setLoaiphong(Tf_LoaiPhong.getText());
                    ListPhong.get(i).setMaphong(Tf_MaPhong.getText());
                    ListPhong.get(i).setGiaphong(Integer.parseInt(Tf_GiaPhong.getText()));
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);

                    alert.setTitle("Thông báo");
                    alert.setHeaderText("Sửa phòng thành công");
                    alert.show();
                    Load();
                    Tf_XoaPhongTheoMaPhong.setText("");
                    Tf_LoaiPhong.setText("");
                    Tf_GiaPhong.setText("");
                    Tf_MaPhong.setText("");
                    break;
                }
            }

        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Thông báo");
            alert.setHeaderText("Mã Phòng không phù hợp");
            alert.show();
            Tf_XoaPhongTheoMaPhong.setText("");

        }

    }

    ObservableList<KhachHang> ListKhachHang = FXCollections.observableArrayList();// Khởi tạo list khách hàng

    @FXML
    private void Btn_DatPhong()
    {
        if(CheckMaPhong(Tf_Maphong_DatPhong.getText())==true)
        {
            for(int i =0; i < ListPhong.size();i++)
            {

                if (ListPhong.get(i).getMaphong().equals(Tf_Maphong_DatPhong.getText()) == true && ListPhong.get(i).CheckPhong() == false) {
                    KhachHang KhachHang = new KhachHang();//Tạo Khách hàng mới
                    KhachHang.setTenkh(Tf_TenKhachDatPhong.getText());//set Thuộc tính cho đối tượng khách hàng
                    KhachHang.setCmt(Tf_SoCmtKhachHang_DatPhong.getText());//set Thuộc tính cho đối tượng khách hàng
                    KhachHang.setPhong(ListPhong.get(i)); //set Thuộc tính cho đối tượng khách hàng
                    ListPhong.get(i).setKhachHang(KhachHang);// set thuộc tính cho đối thượng phòng
                    ListPhong.get(i).setSoNgayTro(Integer.parseInt(Tf_SoNgayTro.getText()));//set số ngày trọ theo đơn đặt phòng
                    ListPhong.get(i).setSoCmtKhach(Tf_SoCmtKhachHang_DatPhong.getText());
                    ListKhachHang.add(KhachHang);//Thêm khách hàng vào arraylist chứa danh sách khách hàng
                    ListPhong.get(i).setTrangthai("unavailable");// set lại trạng thái phòng

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Thông báo");
                    alert.setHeaderText("Đặt phòng thành công");
                    alert.show();

                    Load();// Refresh lại tableview

                    Tf_Maphong_DatPhong.setText("");// set lại các Tf về trống
                    Tf_TenKhachDatPhong.setText("");
                    Tf_SoNgayTro.setText("");
                    Tf_SoCmtKhachHang_DatPhong.setText("");
                    break;//Thoát vòng lặp
                }
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Phòng không tồn tại hoặc trạng thái không sẵn sàng");

            alert.show();
        }
    }
    boolean CheckCmt(String Cmt)
    {
        int j=0;
        for(int i =0 ; i <ListKhachHang.size();i++)
        {
            if(ListKhachHang.get(j).getCmt().equals(Cmt)==true)
            {
                j++;
            }
        }
        if(j>0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    @FXML
    private void Btn_TraPhong()
    {
        if(CheckMaPhong(Tf_Maphong_TraPhong1.getText())==true)//Kiểm tra mã phòng có tồn tại không
        {
            for(int i= 0 ; i <ListPhong.size();i++)
            {
                if ( ListPhong.get(i).CheckPhong() == true)// Kiểm tra trạng thái phòng
                {
                   for(int m=0; m <ListPhong.size();m++)
                   {
                       if(ListPhong.get(m).getMaphong().equals(Tf_Maphong_TraPhong1.getText())==true)//Xác định index theo mã phòng
                       {
                           if(CheckCmt(Tf_SoCMT_TraPhong.getText())==true)//Kiểm tra số cmt của khách có tồn tại không
                           {
                               for (int j = 0; j < ListKhachHang.size(); j++)
                               {
                                   if (ListKhachHang.get(j).getCmt().equals(Tf_SoCMT_TraPhong.getText())  )
                                   {
                                       for (int k=0; k<ListKhachHang.size();k++)//Kiểm tra số cmt có khớp với mã phòng đã đặt không
                                       {
                                           if (ListKhachHang.get(k).getPhong().getMaphong().equals(Tf_Maphong_TraPhong1.getText())==true)
                                           {
                                               Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                               alert.setTitle("Thông báo");
                                               alert.setHeaderText("Bạn cần thanh toán "+ ListPhong.get(m).getSoNgayTro()* ListPhong.get(m).getGiaphong() +" $ "+"\nTrả phòng thành công " );
                                               alert.show();

                                               ListPhong.get(m).setTrangthai("available");// set lại trạng thái phòng
                                               ListPhong.get(m).setSoNgayTro(0);
                                               ListPhong.get(m).setSoCmtKhach("");
                                               ListPhong.get(m).setKhachHang(null);
                                               ListKhachHang.get(k).setPhong(null);

                                               Tf_Maphong_TraPhong1.setText("");
                                               Tf_SoCMT_TraPhong.setText("");

                                               Load();
                                               break;
                                           }
                                           else
                                           {
                                               Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                               alert.setTitle("Thông báo");
                                               alert.setHeaderText("Cmt khách hàng không khớp với mã phòng");
                                               alert.show();
                                               Load();
                                           }
                                       }
                                   }
                               }
                           }
                           else
                           {
                               Alert alert = new Alert(Alert.AlertType.INFORMATION);
                               alert.setTitle("Thông báo");
                               alert.setHeaderText("Cmt khách hàng không tồn tại");
                               alert.show();
                           }
                       }
                   }
                }
                /*else
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Thông báo");
                    alert.setHeaderText("Phòng chưa được đặt, không thể trả phòng");
                    alert.show();
                }*/
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText("Phòng không tồn tại");
            alert.show();
        }
    }
    @FXML
    private void PhongTrong()
    {
        ListPhong1.clear();
        for(int i=0 ; i < listphongcoppy.size();i++)
        {
            if(listphongcoppy.get(i).getTrangthai().equals("available")==true)
            {
                ListPhong1.add(listphongcoppy.get(i));
                TableDanhSachPhong.setItems(ListPhong1);
            }
        }
    }
    @FXML
    private void PhongKhongTrong()
    {
        ListPhong1.clear();
        for(int i=0 ; i < listphongcoppy.size();i++)
        {
            if(listphongcoppy.get(i).getTrangthai().equals("unavailable")==true)
            {
                ListPhong1.add(listphongcoppy.get(i));
                TableDanhSachPhong.setItems(ListPhong1);
            }
        }
    }
    @FXML
    void GhiFile(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Lưu file");
        alert.setHeaderText("Đang tiến hành lưu 99% ...");
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("/Users/nguyentienthuan/Downloads/BaiTapLon_TTNT/src/main/java/com/example/baitaplon_ttnt/QuanLyPhong.dat");
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            for (int i = 0; i < ListPhong.size(); i++) {
                bufferedOutputStream.write((ListPhong.get(i).getMaphong() + "-" + ListPhong.get(i).getLoaiphong() + "-" + ListPhong.get(i).getGiaphong() + "\n").getBytes(StandardCharsets.UTF_8));
            }
            alert.setContentText("Lưu thành công");
        } catch (FileNotFoundException e) {
            alert.setContentText("Gặp lỗi");
        } finally {
            bufferedOutputStream.close();
            fileOutputStream.close();
            alert.show();
        }
    }
    @FXML
    void DocFile(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Đọc file");
        alert.setHeaderText("Đang tiến hành đọc 99% ...");
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            fileInputStream = new FileInputStream("/Users/nguyentienthuan/Downloads/BaiTapLon_TTNT/src/main/java/com/example/baitaplon_ttnt/QuanLyPhong.dat");
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                System.out.print((char) i);
            }
            alert.setContentText("Đã đọc xong");
        } catch (FileNotFoundException e) {
            alert.setContentText("Gặp lỗi");
        } finally {
            fileInputStream.close();
            bufferedInputStream.close();
            alert.show();
        }

    }
}