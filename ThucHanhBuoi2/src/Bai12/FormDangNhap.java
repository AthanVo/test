package Bai12;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FormDangNhap extends JFrame {

    private JPanel contentPane;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JTable tblAccount;
    DefaultTableModel modelAccount;
    ArrayList<TaiKhoan> listTK = new ArrayList<TaiKhoan>();
    private int i = 1;
    private JTextField txtTenDN;
    private JPasswordField txtMatKhau;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormDangNhap frame = new FormDangNhap("Đăng nhập");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FormDangNhap(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 0, 434, 261);
        contentPane.add(tabbedPane);

        JPanel panel = new JPanel();
        tabbedPane.addTab("Đăng kí", null, panel, null);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Username");
        lblNewLabel.setBounds(10, 11, 65, 14);
        panel.add(lblNewLabel);

        txtUsername = new JTextField();
        txtUsername.setBounds(81, 8, 86, 20);
        panel.add(txtUsername);
        txtUsername.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Password");
        lblNewLabel_1.setBounds(222, 11, 65, 14);
        panel.add(lblNewLabel_1);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(297, 8, 122, 20);
        panel.add(txtPassword);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 66, 409, 156);
        panel.add(scrollPane);

        tblAccount = new JTable();
        modelAccount = new DefaultTableModel(
            new Object[][]{},
            new String[]{
                "STT", "Username"
            }
        );
        tblAccount.setModel(modelAccount);
        scrollPane.setViewportView(tblAccount);

        JButton btnAddAccount = new JButton("Add account");
        btnAddAccount.setBounds(153, 36, 115, 23);
        panel.add(btnAddAccount);

        JPanel panel_1 = new JPanel();
        tabbedPane.addTab("Đăng nhập", null, panel_1, null);
        panel_1.setLayout(null);

        txtTenDN = new JTextField();
        txtTenDN.setBounds(195, 99, 100, 20);
        panel_1.add(txtTenDN);
        txtTenDN.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Username");
        lblNewLabel_2.setBounds(107, 102, 100, 14);
        panel_1.add(lblNewLabel_2);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(107, 140, 100, 14);
        panel_1.add(lblPassword);

        JButton btnDangNhap = new JButton("Đăng nhập");
        btnDangNhap.setBounds(195, 176, 100, 23);
        panel_1.add(btnDangNhap);

        txtMatKhau = new JPasswordField();
        txtMatKhau.setBounds(195, 137, 100, 23);
        panel_1.add(txtMatKhau);

        JLabel lblMnHnhng = new JLabel("MÀN HÌNH ĐĂNG NHẬP");
        lblMnHnhng.setForeground(Color.RED);
        lblMnHnhng.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblMnHnhng.setBounds(123, 11, 158, 62);
        panel_1.add(lblMnHnhng);

        btnAddAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                modelAccount = (DefaultTableModel) tblAccount.getModel();
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                // Kiểm tra trùng username
                for (TaiKhoan data : listTK) {
                    if (username.equals(data.getUsername())) {
                        JOptionPane.showMessageDialog(null, "Trùng username!");
                        return;
                    }
                }

                TaiKhoan taiKhoan = new TaiKhoan(username, password);
                modelAccount.addRow(new Object[]{
                        i, username
                });
                i++;
                listTK.add(taiKhoan);
            }
        });

        btnDangNhap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String tenDN = txtTenDN.getText();
                String matKhau = new String(txtMatKhau.getPassword());
                TaiKhoan tk = new TaiKhoan(tenDN, matKhau);

                // Kiểm tra nếu danh sách tài khoản trống
                if (listTK.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Danh sách tài khoản chưa tồn tại!");
                    return;
                }

                // Kiểm tra tài khoản đăng nhập
                for (int i = 0; i < listTK.size(); i++) {
                    if (tk.getUsername().equals(listTK.get(i).getUsername()) &&
                            tk.getPassword().equals(listTK.get(i).getPassword())) {
                        JOptionPane.showMessageDialog(null,
                                "Chào mừng " + tenDN + " đăng nhập thành công!", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Đăng nhập thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
