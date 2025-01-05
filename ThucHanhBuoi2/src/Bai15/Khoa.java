package Bai15;

import java.io.Serializable;
import java.util.ArrayList;

public class Khoa implements Serializable {
    private String maKhoa;                  // Mã khoa
    private String tenKhoa;                 // Tên khoa
    private ArrayList<Lop> listLop = new ArrayList<>();  // Danh sách các lớp trong khoa

    // Constructor có tham số
    public Khoa(String maKhoa, String tenKhoa) {
        super();
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
    }

    // Constructor mặc định
    public Khoa() {
        super();
    }

    // Getter và Setter cho các trường
    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public ArrayList<Lop> getListLop() {
        return listLop;
    }

    public void setListLop(ArrayList<Lop> listLop) {
        this.listLop = listLop;
    }

    // Phương thức thêm lớp vào khoa
    public void themLop(Lop lop) {
        this.listLop.add(lop);  // Thêm lớp vào danh sách lớp
        lop.setKhoa(this);      // Liên kết lớp với khoa hiện tại
    }

    // Phương thức toString() để hiển thị tên khoa
    @Override
    public String toString() {
        return this.tenKhoa;  // Trả về tên khoa khi gọi toString()
    }
}
