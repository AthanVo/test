package Bai15;

import java.io.Serializable;
import java.util.ArrayList;

public class Lop implements Serializable {
    private String maLop;                     // Mã lớp
    private String tenLop;                    // Tên lớp
    private ArrayList<SinhVien> listSinhVien = new ArrayList<>();  // Danh sách sinh viên trong lớp
    private Khoa khoa;                        // Khoa mà lớp thuộc về

    // Constructor
    public Lop(String maLop, String tenLop) {
        super();
        this.maLop = maLop;
        this.tenLop = tenLop;
    }

    // Default constructor
    public Lop() {
        super();
    }

    // Getter và setter cho các trường
    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public ArrayList<SinhVien> getListSinhVien() {
        return listSinhVien;
    }

    public void setListSinhVien(ArrayList<SinhVien> listSinhVien) {
        this.listSinhVien = listSinhVien;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }

    // Thêm sinh viên vào lớp
    public void themSinhVien(SinhVien sinhVien) {
        this.listSinhVien.add(sinhVien);  // Thêm sinh viên vào danh sách
        sinhVien.setLop(this);            // Liên kết sinh viên với lớp hiện tại
    }

    // Chuyển đổi đối tượng Lop thành tên lớp (cho Tree hoặc hiển thị)
    @Override
    public String toString() {
        return this.tenLop;  // Trả về tên lớp khi gọi toString()
    }
}
