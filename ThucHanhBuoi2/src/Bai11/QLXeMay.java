package Bai11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;

public class QLXeMay extends JFrame {
    private JPanel contentPane;
    private JTextField txtMaXe;
    private JTextField txtHangSanXuat;
    private JTextField txtTenXe;
    private JTextField txtNamSanXuat;
    private JTextField txtGiaThanh;
    private JLabel lblGiThnh;
    private JTable tblXe;
    private JTextField txtSoLuong;
    DefaultTableModel modelXe;
    int tongSL = 0;
    double tongGiaThanh = 0.0;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QLXeMay frame = new QLXeMay("Quản lý xe máy");
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public QLXeMay(String name) {
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 572, 365);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Mã xe");
        lblNewLabel.setBounds(57, 17, 68, 14);
        contentPane.add(lblNewLabel);

        txtMaXe = new JTextField();
        txtMaXe.setBounds(161, 11, 86, 20);
        contentPane.add(txtMaXe);
        txtMaXe.setColumns(10);

        txtHangSanXuat = new JTextField();
        txtHangSanXuat.setColumns(10);
        txtHangSanXuat.setBounds(161, 50, 86, 20);
        contentPane.add(txtHangSanXuat);

        JLabel lblHngSnXut = new JLabel("Hãng sản xuất");
        lblHngSnXut.setBounds(57, 56, 94, 14);
        contentPane.add(lblHngSnXut);

        txtTenXe = new JTextField();
        txtTenXe.setColumns(10);
        txtTenXe.setBounds(375, 11, 86, 20);
        contentPane.add(txtTenXe);

        JLabel lblTnXe = new JLabel("Tên xe");
        lblTnXe.setBounds(286, 11, 65, 14);
        contentPane.add(lblTnXe);

        txtNamSanXuat = new JTextField();
        txtNamSanXuat.setColumns(10);
        txtNamSanXuat.setBounds(375, 47, 86, 20);
        contentPane.add(txtNamSanXuat);

        JLabel lblNmSnXut = new JLabel("Năm sản xuất");
        lblNmSnXut.setBounds(286, 47, 79, 14);
        contentPane.add(lblNmSnXut);

        txtGiaThanh = new JTextField();
        txtGiaThanh.setColumns(10);
        txtGiaThanh.setBounds(161, 89, 86, 20);
        contentPane.add(txtGiaThanh);

        lblGiThnh = new JLabel("Giá thành");
        lblGiThnh.setBounds(57, 95, 68, 14);
        contentPane.add(lblGiThnh);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 159, 536, 114);
        contentPane.add(scrollPane);

        tblXe = new JTable();
        tblXe.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Mã Xe", "Tên xe", "Hãng sản xuất", "Năm sản xuất", "Giá thành", "Số lượng"
                }
        ));
        scrollPane.setViewportView(tblXe);
        modelXe = (DefaultTableModel) tblXe.getModel();

        JLabel lblNewLabel_1 = new JLabel("Tổng số lượng");
        lblNewLabel_1.setBounds(84, 283, 86, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblTngGiThnh = new JLabel("Tổng giá thành");
        lblTngGiThnh.setBounds(289, 283, 86, 14);
        contentPane.add(lblTngGiThnh);

        txtSoLuong = new JTextField();
        txtSoLuong.setColumns(10);
        txtSoLuong.setBounds(376, 89, 86, 20);
        contentPane.add(txtSoLuong);

        JLabel lblSLng = new JLabel("Số lượng");
        lblSLng.setBounds(286, 89, 68, 14);
        contentPane.add(lblSLng);

        JButton btnThem = new JButton("Thêm");
        btnThem.setBounds(169, 120, 89, 23);
        contentPane.add(btnThem);

        JButton btnTiepTuc = new JButton("Tiếp tục");
        btnTiepTuc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtMaXe.setText("");
                txtTenXe.setText("");
                txtHangSanXuat.setText("");
                txtNamSanXuat.setText("");
                txtGiaThanh.setText("");
                txtSoLuong.setText("");
            }
        });
        btnTiepTuc.setBounds(268, 120, 89, 23);
        contentPane.add(btnTiepTuc);

        JLabel lblTongGiaThanh = new JLabel("0");
        lblTongGiaThanh.setForeground(Color.RED);
        lblTongGiaThanh.setBounds(383, 283, 46, 14);
        contentPane.add(lblTongGiaThanh);

        JLabel lblTongSoLuong = new JLabel("0");
        lblTongSoLuong.setForeground(Color.RED);
        lblTongSoLuong.setBounds(175, 283, 46, 14);
        contentPane.add(lblTongSoLuong);

        btnThem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String maXe = txtMaXe.getText();
                String tenXe = txtTenXe.getText();
                String hangSX = txtHangSanXuat.getText();
                try {
                    int namSX = Integer.parseInt(txtNamSanXuat.getText());
                    double giaThanh = Double.parseDouble(txtGiaThanh.getText());
                    int soLuong = Integer.parseInt(txtSoLuong.getText());
                    if (maXe.isEmpty() || tenXe.isEmpty() || hangSX.isEmpty() || 
                        String.valueOf(namSX).isEmpty() || String.valueOf(giaThanh).isEmpty() || 
                        String.valueOf(soLuong).isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Vui lòng không bỏ trống trường nào!", "Cảnh báo", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    modelXe.addRow(new Object[]{maXe, tenXe, hangSX, namSX, giaThanh, soLuong});
                    XeMay xe = new XeMay(maXe, tenXe, hangSX, namSX, giaThanh, soLuong);

                    tongSL += xe.getSoLuong();
                    lblTongSoLuong.setText(tongSL + "");
                    tongGiaThanh += xe.tinhGia();
                    lblTongGiaThanh.setText(tongGiaThanh + "");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Xin nhập đúng dạng hoặc không bỏ trống", "Cảnh báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}

