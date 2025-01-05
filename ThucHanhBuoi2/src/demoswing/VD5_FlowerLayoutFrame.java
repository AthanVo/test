package demoswing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VD5_FlowerLayoutFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VD5_FlowerLayoutFrame frame = new VD5_FlowerLayoutFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public VD5_FlowerLayoutFrame() {
        // Cấu hình cửa sổ JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300); // Vị trí và kích thước cửa sổ
        
        // Tạo JPanel và thiết lập border
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        // Thiết lập layout FlowLayout cho contentPane
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT); // Căn chỉnh các nút sang bên trái
        contentPane.setLayout(layout);

        // Thêm 20 nút vào contentPane
        for (int i = 0; i < 20; i++) {
            JButton btn = new JButton();
            btn.setPreferredSize(new Dimension(70, 30)); // Kích thước nút
            btn.setText("Text" + i); // Text của nút
            contentPane.add(btn); // Thêm nút vào contentPane
        }
    }
}
