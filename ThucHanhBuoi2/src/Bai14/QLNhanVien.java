package Bai14;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class QLNhanVien extends JFrame {
    private JPanel contentPane;
    private JTextField txtMaNV;
    private JTextField txtTenNV;
    private JTextField txtNamSinh;
    private JTextField txtNgayVaoLam;
    
    PhongBan phongBanselected;
    NhanVien nhanVienselected;
    ArrayList<PhongBan> dsPB = new ArrayList<PhongBan>();
    private ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QLNhanVien frame = new QLNhanVien("Quản lý nhân viên");
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public QLNhanVien(String name) {
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 408);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Chọn phòng ban:");
        lblNewLabel.setBounds(74, 11, 110, 14);
        contentPane.add(lblNewLabel);
        
        JComboBox<PhongBan> cboPhongBan = new JComboBox<PhongBan>();
        cboPhongBan.setBounds(194, 8, 128, 20);
        contentPane.add(cboPhongBan);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 46, 182, 244);
        contentPane.add(panel);
        panel.setForeground(Color.BLACK);
        panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh sách", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
        panel.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 24, 162, 209);
        panel.add(scrollPane);
        
        JList<NhanVien> listNV = new JList<>();
        listNV.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {
                if (listNV.getSelectedIndex() == -1) return;
                nhanVienselected = listNV.getSelectedValue();
                txtMaNV.setText(nhanVienselected.getMaNhanVien());
                txtTenNV.setText(nhanVienselected.getTenNhanVien());
                txtNamSinh.setText(sdf.format(nhanVienselected.getNamSinh()));
                txtNgayVaoLam.setText(sdf.format(nhanVienselected.getNgayVaoLamViec()));
            }
        });
        scrollPane.setViewportView(listNV);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(204, 46, 220, 244);
        contentPane.add(scrollPane_1);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin chi tiết", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
        scrollPane_1.setViewportView(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Mã nhân viên");
        lblNewLabel_1.setBounds(67, 23, 86, 14);
        panel_1.add(lblNewLabel_1);
        
        txtMaNV = new JTextField();
        txtMaNV.setBounds(32, 48, 148, 20);
        panel_1.add(txtMaNV);
        txtMaNV.setColumns(10);
        
        JLabel lblTen = new JLabel("Tên nhân viên");
        lblTen.setBounds(67, 79, 86, 14);
        panel_1.add(lblTen);
        
        txtTenNV = new JTextField();
        txtTenNV.setColumns(10);
        txtTenNV.setBounds(32, 101, 148, 20);
        panel_1.add(txtTenNV);
        
        JLabel lblNmSinh = new JLabel("Năm sinh");
        lblNmSinh.setBounds(67, 132, 86, 14);
        panel_1.add(lblNmSinh);
        
        txtNamSinh = new JTextField();
        txtNamSinh.setColumns(10);
        txtNamSinh.setBounds(32, 157, 148, 20);
        panel_1.add(txtNamSinh);
        
        txtNgayVaoLam = new JTextField();
        txtNgayVaoLam.setColumns(10);
        txtNgayVaoLam.setBounds(32, 211, 148, 20);
        panel_1.add(txtNgayVaoLam);
        
        JLabel lblNgyVoLm = new JLabel("Ngày vào làm");
        lblNgyVoLm.setBounds(67, 186, 86, 14);
        panel_1.add(lblNgyVoLm);
        
        JButton btnThem = new JButton("Thêm");
        btnThem.setBounds(214, 301, 89, 23);
        contentPane.add(btnThem);
        
        JButton btnLuu = new JButton("Lưu");
        btnLuu.setBounds(325, 301, 89, 23);
        contentPane.add(btnLuu);
        
        JButton btnXoa = new JButton("Xoá");
        btnXoa.setBounds(215, 334, 89, 23);
        contentPane.add(btnXoa);
        
        JButton btnThoat = new JButton("Thoát");
        btnThoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (a == JOptionPane.YES_OPTION) dispose();
                else setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        btnThoat.setBounds(326, 334, 89, 23);
        contentPane.add(btnThoat);
        
        JButton btnGhiFile = new JButton("Ghi file");
        btnGhiFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (phongBanselected == null) {
                        JOptionPane.showMessageDialog(null, "Chọn phòng ban cần ghi file");
                        return;
                    }
                    FileOutputStream fos = new FileOutputStream("dsnv" + phongBanselected.getMaPhong() + ".dat");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(phongBanselected.getListNhanVien());
                    oos.close();
                    fos.close();
                    JOptionPane.showMessageDialog(null, "Ghi thành công");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Lỗi ghi file");
                }
            }
        });
        btnGhiFile.setBounds(42, 318, 89, 23);
        contentPane.add(btnGhiFile);
        
        PhongBan ptc = new PhongBan("ptc", "Phòng tổ chức");
        PhongBan pkt = new PhongBan("pkt", "Phòng kĩ thuật");
        PhongBan phc = new PhongBan("phc", "Phòng hành chính");
        dsPB.add(ptc);
        dsPB.add(pkt);
        dsPB.add(phc);
        
        ptc.themNhanVien(new NhanVien("NV01", "Nguyễn Văn A", new Date(98, 0, 1), new Date(118, 0, 1))); // Fixed deprecated Date constructor
        ptc.themNhanVien(new NhanVien("NV02", "Nguyễn Văn B", new Date(97, 0, 1), new Date(118, 1, 14)));
        ptc.themNhanVien(new NhanVien("NV03", "Nguyễn Thị B", new Date(97, 0, 5), new Date(118, 1, 5)));
        
        pkt.themNhanVien(new NhanVien("NV04", "Nguyễn Văn C", new Date(95, 9, 10), new Date(118, 1, 1)));
        pkt.themNhanVien(new NhanVien("NV05", "Nguyễn Văn D", new Date(95, 10, 10), new Date(119, 1, 6)));
        
        phc.themNhanVien(new NhanVien("NV06", "Nguyễn Thị C", new Date(96, 2, 10), new Date(118, 1, 21)));
        
        for (PhongBan phong : dsPB) {
            cboPhongBan.addItem(phong);
        }
        
        cboPhongBan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (cboPhongBan.getSelectedIndex() == -1) return;
                phongBanselected = (PhongBan) cboPhongBan.getSelectedItem();
                listNV.setListData(phongBanselected.getListNhanVien().toArray(new NhanVien[0]));
            }
        });
        
        btnThem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    NhanVien nhanVien = new NhanVien(
                        txtMaNV.getText(),
                        txtTenNV.getText(),
                        sdf.parse(txtNamSinh.getText()),
                        sdf.parse(txtNgayVaoLam.getText())
                    );
                    if (phongBanselected == null) {
                        JOptionPane.showMessageDialog(null, "Phải chọn phòng ban");
                        return;
                    }
                    for (NhanVien nv : phongBanselected.getListNhanVien()) {
                        if (nhanVien.getMaNhanVien().equalsIgnoreCase(nv.getMaNhanVien())) {
                            JOptionPane.showMessageDialog(null, "Trùng mã nhân viên ở phòng " + phongBanselected.getTenPhong());
                            return;
                        }
                    }
                    phongBanselected.themNhanVien(nhanVien);
                    listNV.setListData(phongBanselected.getListNhanVien().toArray(new NhanVien[0]));
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        });
        
        btnLuu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (phongBanselected == null) {
                        JOptionPane.showMessageDialog(null, "Phải chọn phòng ban");
                    } else if (nhanVienselected == null) {
                        JOptionPane.showMessageDialog(null, "Phải chọn nhân viên cần chỉnh sửa");
                    } else {
                        nhanVienselected.setMaNhanVien(txtMaNV.getText());
                        nhanVienselected.setTenNhanVien(txtTenNV.getText());
                        nhanVienselected.setNgayVaoLamViec(sdf.parse(txtNgayVaoLam.getText()));
                        nhanVienselected.setNamSinh(sdf.parse(txtNamSinh.getText()));
                        listNV.setListData(phongBanselected.getListNhanVien().toArray(new NhanVien[0]));
                    }
                } catch (ParseException e1) {
                    JOptionPane.showMessageDialog(null, e1.toString());
                }
            }
        });
        
        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nhanVienselected != null) {
                    phongBanselected.getListNhanVien().remove(nhanVienselected);
                    listNV.setListData(phongBanselected.getListNhanVien().toArray(new NhanVien[0]));
                    txtMaNV.setText("");
                    txtNamSinh.setText("");
                    txtNgayVaoLam.setText("");
                    txtTenNV.setText("");
                }
            }
        });
    }
}
