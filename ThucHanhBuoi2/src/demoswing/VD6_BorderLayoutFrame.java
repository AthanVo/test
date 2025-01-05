package demoswing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;

public class VD6_BorderLayoutFrame extends javax.swing.JFrame {

    // Khai báo các nút cho từng khu vực
    JButton btnCenter, btnWest, btnEast, btnNorth, btnSouth;

    public VD6_BorderLayoutFrame() {
        // Khởi tạo các nút
        btnCenter = new JButton("CENTER");
        btnWest = new JButton("WEST");
        btnEast = new JButton("EAST");
        btnNorth = new JButton("NORTH");
        btnSouth = new JButton("SOUTH");

        // Cấu hình cửa sổ
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400, 300); // Thiết lập kích thước cửa sổ
        
        // Sử dụng BorderLayout với khoảng cách tùy chỉnh giữa các khu vực
        BorderLayout layout = new BorderLayout(10, 20);
        this.getContentPane().setLayout(layout);
        
        // Thêm các nút vào từng khu vực của BorderLayout
        this.getContentPane().add(btnCenter, BorderLayout.CENTER);
        this.getContentPane().add(btnNorth, BorderLayout.NORTH);
        this.getContentPane().add(btnSouth, BorderLayout.SOUTH);
        this.getContentPane().add(btnWest, BorderLayout.WEST);
        this.getContentPane().add(btnEast, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        // Đảm bảo việc chạy trên Event Dispatch Thread (EDT)
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Khởi tạo và hiển thị cửa sổ
                    VD6_BorderLayoutFrame frame = new VD6_BorderLayoutFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(); // Xử lý lỗi nếu có
                }
            }
        });
    }
}

