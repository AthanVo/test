package Bai11;

public class XeMay {
    private String maXe;
    private String tenXe;
    private String hangSX;
    private int namSX;
    private double giaThanh;
    private int soLuong;

    public XeMay(String maXe, String tenXe, String hangSX, int namSX, double giaThanh, int soLuong) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.hangSX = hangSX;
        this.namSX = namSX;
        this.giaThanh = giaThanh;
        this.soLuong = soLuong;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getHangSX() {
        return hangSX;
    }

    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public double getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(double giaThanh) {
        this.giaThanh = giaThanh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double tinhGia() {
        return this.soLuong * this.giaThanh;
    }

    @Override
    public String toString() {
        return this.getMaXe() + "-" + this.getTenXe() + "-" + this.getHangSX() + "-" + this.getNamSX() + "-" + this.getGiaThanh() + "-" + this.getSoLuong();
    }
}

