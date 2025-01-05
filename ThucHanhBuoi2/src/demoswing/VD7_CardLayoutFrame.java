package demoswing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;

public class VD7_CardLayoutFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel jpnChoice; // Panel chứa các nút điều khiển
    private JPanel jpnCards; // Panel chứa các thẻ
    private JButton jbtCard1, jbtCard2; // Các nút điều khiển cho Card1 và Card2
    private JPanel jpnCard1, jpnCard2; // Các thẻ Card1 và Card2
    private JButton jbt11, jbt12, jbt21, jbt22; // Các nút trong các thẻ

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VD7_CardLayoutFrame frame = new VD7_CardLayoutFrame();
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
    public VD7_CardLayoutFrame() {
        initComponents();

        // Thiết lập giao diện
        this.setSize(400, 200);
        this.setTitle("CardLayout with Buttons");

        // Tạo các nút điều khiển
        jbtCard1 = new JButton("Card 1");
        jbtCard2 = new JButton("Card 2");

        // Thêm các nút vào panel điều khiển
        jpnChoice.add(jbtCard1);
        jpnChoice.add(jbtCard2);

        // Tạo các thẻ Card1 và Card2
        jpnCard1 = new JPanel();
        jpnCard1.setName("Card1");
        jpnCard1.setLayout(new FlowLayout());

        jpnCard2 = new JPanel();
        jpnCard2.setName("Card2");
        jpnCard2.setLayout(new FlowLayout());

        // Thêm các nút vào Card1
        jbt11 = new JButton("Button 1-1");
        jpnCard1.add(jbt11);
        jbt12 = new JButton("Button 1-2");
        jpnCard1.add(jbt12);

        // Thêm các nút vào Card2
        jbt21 = new JButton("Button 2-1");
        jpnCard2.add(jbt21);
        jbt22 = new JButton("Button 2-2");
        jpnCard2.add(jbt22);

        // Thêm các thẻ vào jpnCards
        jpnCards.add(jpnCard1, jpnCard1.getName());
        jpnCards.add(jpnCard2, jpnCard2.getName());

        // Thêm ActionListener cho các nút sau khi khởi tạo chúng
        jbtCard1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jbtCard1ActionPerformed(e);
            }
        });

        jbtCard2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jbtCard2ActionPerformed(e);
            }
        });
    }

    private void initComponents() {
        // Cấu hình JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300); // Cấu hình vị trí và kích thước cửa sổ

        // Tạo panel chứa các nút điều khiển
        jpnChoice = new JPanel();
        jpnChoice.setLayout(new FlowLayout()); // Căn lề các nút
        getContentPane().add(jpnChoice, BorderLayout.NORTH);

        // Tạo panel chứa các thẻ
        jpnCards = new JPanel();
        jpnCards.setLayout(new CardLayout()); // Sử dụng CardLayout cho panel này
        getContentPane().add(jpnCards, BorderLayout.CENTER);

        pack(); // Đảm bảo mọi thứ được khởi tạo đúng
    }

    // Hàm xử lý sự kiện khi nhấn nút Card1
    private void jbtCard1ActionPerformed(ActionEvent e) {
        CardLayout layout = (CardLayout) jpnCards.getLayout();
        layout.show(jpnCards, jpnCard1.getName()); // Hiển thị Card1
    }

    // Hàm xử lý sự kiện khi nhấn nút Card2
    private void jbtCard2ActionPerformed(ActionEvent e) {
        CardLayout layout = (CardLayout) jpnCards.getLayout();
        layout.show(jpnCards, jpnCard2.getName()); // Hiển thị Card2
    }
}
