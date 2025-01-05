package Bai14;

import java.io.Serializable;  // Để lớp có thể lưu trữ và truyền tải qua mạng
import java.util.Vector;  // Import Vector để lưu trữ danh sách nhân viên trong phòng ban

// Lớp PhongBan đại diện cho thông tin một phòng ban trong công ty
public class PhongBan implements Serializable {
    private String maPhong;  // Mã phòng ban
    private String tenPhong;  // Tên phòng ban
    private Vector<NhanVien> listNhanVien;  // Danh sách nhân viên trong phòng ban, sử dụng Vector

    // Getter và Setter cho danh sách nhân viên của phòng ban
    public Vector<NhanVien> getListNhanVien() {
        return listNhanVien;
    }

    public void setListNhanVien(Vector<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }

    // Constructor mặc định (khởi tạo danh sách nhân viên rỗng)
    public PhongBan() {
        super();  // Gọi constructor của lớp cha (Object)
        this.listNhanVien = new Vector<>();  // Khởi tạo danh sách nhân viên trống
    }

    // Constructor với mã phòng ban và tên phòng ban
    public PhongBan(String maPhong, String tenPhong) {
        super();  // Gọi constructor của lớp cha (Object)
        this.maPhong = maPhong;  // Gán giá trị mã phòng ban
        this.tenPhong = tenPhong;  // Gán giá trị tên phòng ban
        this.listNhanVien = new Vector<>();  // Khởi tạo danh sách nhân viên trống
    }

    // Getter và Setter cho mã phòng ban
    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    // Getter và Setter cho tên phòng ban
    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    // Phương thức thêm nhân viên vào danh sách nhân viên của phòng ban
    public void themNhanVien(NhanVien nhanVien) {
        this.listNhanVien.add(nhanVien);  // Thêm nhân viên vào danh sách
    }

    // Phương thức trả về tên phòng ban khi gọi đối tượng này
    @Override
    public String toString() {
        return this.getTenPhong();  // Trả về tên phòng ban
    }
}
