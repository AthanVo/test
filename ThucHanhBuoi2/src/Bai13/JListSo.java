package Bai13;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultListModel;

public class JListSo extends JFrame {

    private JPanel contentPane;
    private JTextField txtSo;
    DefaultListModel<Integer> modelSo = new DefaultListModel<>();
    ArrayList<Integer> list = new ArrayList<>();
    
    /** 
     * Launch the application. 
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JListSo("Thao tác số trên JList");
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null); // Center the frame
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /** 
     * Create the frame.
     */
    public JListSo(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 552, 344);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Panel for actions (e.g., find even/odd numbers)
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Chọn tác vụ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(10, 11, 185, 195);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton btnSoChan = new JButton("Tìm số chẵn");
        btnSoChan.setBounds(10, 22, 165, 23);
        panel.add(btnSoChan);

        JButton btnSoLe = new JButton("Tìm số lẻ");
        btnSoLe.setBounds(10, 56, 165, 23);
        panel.add(btnSoLe);

        JButton btnBanDau = new JButton("List ban đầu");
        btnBanDau.setBounds(10, 125, 165, 23);
        panel.add(btnBanDau);

        JButton btnChinhPhuong = new JButton("Tìm số chính phương");
        btnChinhPhuong.setBounds(10, 91, 165, 23);
        panel.add(btnChinhPhuong);

        JButton btnTong = new JButton("Tổng giá trị");
        btnTong.setBounds(10, 159, 165, 23);
        panel.add(btnTong);

        // Panel for input and list display
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "Nhập thông tin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(206, 11, 320, 239);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        txtSo = new JTextField();
        txtSo.setBounds(10, 21, 86, 20);
        panel_1.add(txtSo);
        txtSo.setColumns(10);

        JButton btnNhap = new JButton("Nhập");
        btnNhap.setBounds(101, 20, 89, 20);
        panel_1.add(btnNhap);

        JCheckBox chkSoAm = new JCheckBox("Cho nhập số âm");
        chkSoAm.setBounds(196, 20, 118, 23);
        panel_1.add(chkSoAm);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 52, 300, 176);
        panel_1.add(scrollPane);

        JList<Integer> listSo = new JList<>();
        scrollPane.setViewportView(listSo);

        // Button action to input a number
        btnNhap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int so = Integer.parseInt(txtSo.getText());
                    if (!chkSoAm.isSelected() && so < 0) {
                        JOptionPane.showMessageDialog(null, "Không nhập số âm", "Cảnh báo", JOptionPane.OK_OPTION);
                        return;
                    }
                    modelSo.addElement(so);
                    list.add(so);
                    listSo.setModel(modelSo);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Chỉ nhập số nguyên", "Cảnh báo", JOptionPane.OK_OPTION);
                }
            }
        });

        // Exit button
        JButton btnExit = new JButton("Thoát chương trình");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                } else {
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            }
        });
        btnExit.setBounds(189, 261, 147, 23);
        contentPane.add(btnExit);

        // Calculate total sum
        btnTong.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int tong = 0;
                for (int data : list) {
                    tong += data;
                }
                JOptionPane.showMessageDialog(null, "Tổng giá trị: " + tong, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Action to filter even numbers
        btnSoChan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modelSo.clear();
                for (int data : list) {
                    if (data % 2 == 0) {
                        modelSo.addElement(data);
                    }
                }
                listSo.setForeground(Color.BLUE);
                listSo.setModel(modelSo);
            }
        });

        // Action to filter odd numbers
        btnSoLe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modelSo.clear();
                for (int data : list) {
                    if (data % 2 != 0) {
                        modelSo.addElement(data);
                    }
                }
                listSo.setForeground(Color.BLUE);
                listSo.setModel(modelSo);
            }
        });

        // Show the original list
        btnBanDau.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modelSo.clear();
                for (int data : list) {
                    modelSo.addElement(data);
                }
                listSo.setModel(modelSo);
            }
        });

        // Action to find perfect squares
        btnChinhPhuong.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modelSo.clear();
                for (int data : list) {
                    int x = (int) Math.sqrt(data);
                    if (x * x == data) {
                        modelSo.addElement(data);
                    }
                }
                listSo.setModel(modelSo);
            }
        });
    }
}
