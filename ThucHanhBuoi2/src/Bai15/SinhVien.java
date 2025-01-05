package Bai15;

import java.io.Serializable;
import java.util.Date;

public class SinhVien implements Serializable {
    private String maSinhVien;   // Mã sinh viên
    private String tenSinhVien;  // Tên sinh viên
    private Date ngaySinh;       // Ngày sinh sinh viên
    private boolean gioiTinh;    // Giới tính (true: Nam, false: Nữ)
    private Lop lop;             // Lớp mà sinh viên thuộc về

    // Constructor
    public SinhVien(String maSinhVien, String tenSinhVien, Date ngaySinh, boolean gioiTinh) {
        super();
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
    }

    // Default constructor
    public SinhVien() {
        super();
    }

    // Getter và setter
    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    @Override
    public String toString() {
        return this.tenSinhVien; // Trả về tên sinh viên khi gọi toString()
    }
}
