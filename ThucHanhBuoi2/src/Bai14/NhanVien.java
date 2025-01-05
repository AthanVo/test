package Bai14;

import java.io.Serializable;  // Import Serializable để lớp có thể ghi vào file
import java.util.Date;  // Import Date từ thư viện java.util để xử lý ngày tháng

// Lớp NhanVien kế thừa Serializable để có thể ghi vào file
public class NhanVien implements Serializable {
    private String maNhanVien;  // Mã nhân viên
    private String tenNhanVien;  // Tên nhân viên
    private Date namSinh;  // Năm sinh của nhân viên
    private Date ngayVaoLamViec;  // Ngày vào làm việc của nhân viên
    private PhongBan phong;  // Phòng ban mà nhân viên thuộc về

    // Getter và Setter cho thuộc tính phong (phòng ban của nhân viên)
    public PhongBan getPhong() {
        return phong;
    }

    public void setPhong(PhongBan phong) {
        this.phong = phong;
    }

    // Getter và Setter cho mã nhân viên
    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    // Getter và Setter cho tên nhân viên
    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    // Getter và Setter cho năm sinh
    public Date getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    // Getter và Setter cho ngày vào làm việc
    public Date getNgayVaoLamViec() {
        return ngayVaoLamViec;
    }

    public void setNgayVaoLamViec(Date ngayVaoLamViec) {
        this.ngayVaoLamViec = ngayVaoLamViec;
    }

    // Constructor khởi tạo đối tượng nhân viên với các thông tin cần thiết
    public NhanVien(String maNhanVien, String tenNhanVien, Date namSinh, Date ngayVaoLamViec) {
        super();  // Gọi constructor của lớp cha (Object)
        this.maNhanVien = maNhanVien;  // Gán giá trị mã nhân viên
        this.tenNhanVien = tenNhanVien;  // Gán giá trị tên nhân viên
        this.namSinh = namSinh;  // Gán giá trị năm sinh
        this.ngayVaoLamViec = ngayVaoLamViec;  // Gán giá trị ngày vào làm việc
    }

    // Phương thức toString() để hiển thị thông tin nhân viên, ở đây trả về tên nhân viên
    @Override
    public String toString() {
        return this.getTenNhanVien();  // Trả về tên nhân viên
    }
}
