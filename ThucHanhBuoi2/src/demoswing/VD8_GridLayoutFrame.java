package demoswing;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class VD8_GridLayoutFrame extends javax.swing.JFrame {
    private JButton[] jbts; // Mảng các nút

    public VD8_GridLayoutFrame() {
        initComponents();
    }

    private void initComponents() {
        // Cấu hình JFrame
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        // Thiết lập GridLayout (7 hàng, 3 cột)
        GridLayout layout = new GridLayout(7, 3);  
        this.setLayout(layout);  // Áp dụng layout cho content pane

        // Khởi tạo mảng nút JButton
        this.jbts = new JButton[21];
        for (int i = 0; i < 21; i++) {
            this.jbts[i] = new JButton();           // Khởi tạo JButton
            this.jbts[i].setText(String.valueOf(i + 1));  // Đặt văn bản nút từ 1 đến 21
            this.getContentPane().add(this.jbts[i]);  // Thêm nút vào content pane
        }

        // Đảm bảo cửa sổ vừa vặn với các thành phần đã thêm
        pack();  
        
        // Sau khi gọi pack(), bạn có thể thiết lập kích thước cửa sổ nếu cần thiết
        this.setSize(700, 400);  // Kích thước cửa sổ (Có thể bỏ nếu pack() đủ)
    }

    public static void main(String[] args) {
        // Hiển thị giao diện
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VD8_GridLayoutFrame frame = new VD8_GridLayoutFrame();
                    frame.setVisible(true); // Hiển thị cửa sổ
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
