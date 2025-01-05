package Bai15;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.*;
import javax.swing.tree.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class QLSV extends JFrame {
    
    private JPanel contentPane;
    private JTable tblLop;
    private JTextField txtMaSV;
    private JTextField txtNgaySinh;
    private JTextField txtTenSV;
    private static final String NAME = "qlsv.txt"; 
    private int posselected;
    private Button btnThem;
    private JTree tree;
    private ArrayList<Khoa> listKhoa;
    private Lop lopSelected;
    private DefaultTableModel modelLop;
    private SinhVien svSelected;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DefaultMutableTreeNode root = new DefaultMutableTreeNode("Đại học Thủ Dầu Một");
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QLSV frame = new QLSV("Quản lý sinh viên");
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public QLSV(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 604, 366);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Dùng EmptyBorder ở đây
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 11, 151, 305);
        contentPane.add(scrollPane);
        
        tree = new JTree();
        tree.setModel(new DefaultTreeModel(root));
        scrollPane.setViewportView(tree);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(171, 11, 407, 184);
        contentPane.add(scrollPane_1);
        
        tblLop = new JTable();
        tblLop.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Mã", "Họ Tên", "Ngày sinh", "Giới tính" }
        ));
        scrollPane_1.setViewportView(tblLop);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Thông tin sinh viên", TitledBorder.LEADING, TitledBorder.TOP, null, null)); // Dùng TitledBorder ở đây
        panel.setBounds(171, 206, 407, 70);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblMSinhVin = new JLabel("Mã sinh viên");
        lblMSinhVin.setBounds(10, 19, 70, 14);
        panel.add(lblMSinhVin);
        
        txtMaSV = new JTextField();
        txtMaSV.setBounds(90, 16, 86, 20);
        panel.add(txtMaSV);
        txtMaSV.setColumns(10);
        
        JLabel lblNgaySinh = new JLabel("Ngày sinh");
        lblNgaySinh.setBounds(10, 42, 70, 14);
        panel.add(lblNgaySinh);
        
        txtNgaySinh = new JTextField();
        txtNgaySinh.setColumns(10);
        txtNgaySinh.setBounds(90, 39, 86, 20);
        panel.add(txtNgaySinh);
        
        JLabel lblTnSinhVin = new JLabel("Tên sinh viên");
        lblTnSinhVin.setBounds(211, 16, 80, 14);
        panel.add(lblTnSinhVin);
        
        JLabel lblGiiTnh = new JLabel("Giới tính");
        lblGiiTnh.setBounds(211, 42, 56, 14);
        panel.add(lblGiiTnh);
        ButtonGroup groupGioiTinh = new ButtonGroup();
        
        txtTenSV = new JTextField();
        txtTenSV.setBounds(294, 16, 86, 20);
        panel.add(txtTenSV);
        txtTenSV.setColumns(10);
        
        JCheckBox chkNam = new JCheckBox("Nam");
        chkNam.setBounds(283, 38, 97, 23);
        panel.add(chkNam);
        
        JButton btnThem = new JButton("Thêm");
        btnThem.setBounds(209, 287, 68, 23);
        contentPane.add(btnThem);
        
        JButton btnXoa = new JButton("Xoá");
        btnXoa.setBounds(287, 287, 59, 23);
        contentPane.add(btnXoa);
        
        JButton btnSua = new JButton("Sửa");
        btnSua.setBounds(356, 287, 59, 23);
        contentPane.add(btnSua);
        
        JButton btnLuu = new JButton("Lưu");
        btnLuu.setBounds(425, 287, 59, 23);
        contentPane.add(btnLuu);
        
        JButton btnThoat = new JButton("Thoát");
        btnThoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        btnThoat.setBounds(494, 287, 84, 23);
        contentPane.add(btnThoat);
        
        loadData();
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                try {
                    lopSelected = (Lop) node.getUserObject();
                    showLop();
                } catch (Exception ex) {
                }
            }
        });
        
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (lopSelected != null) {
                    try {
                        SinhVien sinhVien = new SinhVien(txtMaSV.getText(), txtTenSV.getText(),
                                sdf.parse(txtNgaySinh.getText()), chkNam.isSelected());
                        lopSelected.themSinhVien(sinhVien);
                        showLop();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Thêm thất bại");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Chưa chọn lớp cần thêm");
                }
            }
        });
        
        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int posselected = tblLop.getSelectedRow();
                if (lopSelected != null && posselected >= 0) {
                    lopSelected.getListSinhVien().remove(posselected);
                    showLop();
                } else {
                    JOptionPane.showMessageDialog(null, "Chưa chọn sinh viên để xoá");
                }
            }
        });
        
        btnSua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                posselected = tblLop.getSelectedRow();
                if (posselected >= 0) {
                    SinhVien svSelected = lopSelected.getListSinhVien().get(posselected);
                    svSelected.setMaSinhVien(txtMaSV.getText());
                    svSelected.setTenSinhVien(txtTenSV.getText());
                    try {
                        svSelected.setNgaySinh(sdf.parse(txtNgaySinh.getText()));
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                    svSelected.setGioiTinh(chkNam.isSelected());
                    showLop();
                }
            }
        });
        
        tblLop.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                posselected = tblLop.getSelectedRow();
                SinhVien svSelected = lopSelected.getListSinhVien().get(posselected);
                txtMaSV.setText(svSelected.getMaSinhVien());
                txtTenSV.setText(svSelected.getTenSinhVien());
                txtNgaySinh.setText(sdf.format(svSelected.getNgaySinh()));
                chkNam.setSelected(svSelected.isGioiTinh());
            }
        });
        
        btnLuu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean kq = DocGhiFile.ghiFile(listKhoa, NAME);
                if (kq) {
                    JOptionPane.showMessageDialog(null, "Lưu thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "Lưu thất bại");
                }
            }
        });
    }
    
    private void loadData() {
        listKhoa = DocGhiFile.docFile(NAME);
        if (listKhoa.size() == 0) {
            listKhoa = new ArrayList<>();
            Khoa khoaCNTT = new Khoa("CNTT", "Khoa Công nghệ thông tin");
            khoaCNTT.themLop(new Lop("D4HT01", "Lớp hệ thống"));
            khoaCNTT.themLop(new Lop("D4PM01", "Lớp phần mềm"));
            Khoa khoaKT = new Khoa("KT", "Khoa Kinh tế");
            khoaKT.themLop(new Lop("D14QT01", "Lớp quản trị"));
            khoaKT.themLop(new Lop("D14KT01", "Lớp kế toán"));
            listKhoa.add(khoaCNTT);
            listKhoa.add(khoaKT);
        }
        
        for (Khoa khoa : listKhoa) {
            DefaultMutableTreeNode nodeKhoa = new DefaultMutableTreeNode(khoa);
            root.add(nodeKhoa);
            for (Lop lop : khoa.getListLop()) {
                DefaultMutableTreeNode nodeLop = new DefaultMutableTreeNode(lop);
                nodeKhoa.add(nodeLop);
            }
        }
    }
    
    private void showLop() {
        modelLop = (DefaultTableModel) tblLop.getModel();
        modelLop.setRowCount(0);
        for (SinhVien sinhVien : lopSelected.getListSinhVien()) {
            modelLop.addRow(new Object[] {
                sinhVien.getMaSinhVien(),
                sinhVien.getTenSinhVien(),
                sdf.format(sinhVien.getNgaySinh()),
                sinhVien.isGioiTinh() ? "Nam" : "Nữ"
            });
        }
    }
}
