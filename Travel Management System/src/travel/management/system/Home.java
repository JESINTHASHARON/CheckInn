package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements Runnable, ActionListener {
    
    public Login l;
    public AdminLogin a;

    ImageIcon[] image = new ImageIcon[6];
    Image[] jimage = new Image[6];
    ImageIcon[] iimage = new ImageIcon[6];
    JLabel[] jlabel = new JLabel[6];
    
    JLabel l4, l5;
    JButton b1, b2, b3, btn;
    JPanel contentPane, button, panel1;
    Thread t1;

    public static void main(String[] args) {
        new Home().setVisible(true);
    }
    
    Home() {
        super("Travel and Tourism Management System");

        // Get screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Button panel
        button = new JPanel();
        button.setBackground(new Color(0, 139, 139, 220));
        button.setBounds(0, 0, screenWidth, 60);
        button.setLayout(null);
        contentPane.add(button);

        // Main panel
        panel1 = new JPanel();
        panel1.setBackground(Color.WHITE);
        panel1.setBounds(0, 60, screenWidth, screenHeight - 60);
        panel1.setLayout(null);
        contentPane.add(panel1);

        // Header image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/icons/dd.jpeg"));
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        l4 = new JLabel(i6);
        l4.setBounds(5, 5, 50, 50);
        button.add(l4);

        // Header label
        l5 = new JLabel("DREAM DESTINATION");
        l5.setForeground(Color.RED);
        l5.setFont(new Font("Times New Roman", Font.BOLD, 43));
        l5.setBounds(57, 2, 800, 57);
        button.add(l5);

        // Buttons
        b1 = createButton("Home", 1017, 7);
        b2 = createButton("Login", 1124, 7);
        b3 = createButton("Admin", 1234, 7);

        button.add(b1);
        button.add(b2);
        button.add(b3);
        btn = b1;
        activeButton(b1);

        // Load images for slideshow
        for (int i = 0; i < 6; i++) {
            image[i] = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/icons/homepage" + (i + 1) + ".jpg"));
            jimage[i] = image[i].getImage().getScaledInstance(screenWidth, screenHeight - 60, Image.SCALE_DEFAULT);
            iimage[i] = new ImageIcon(jimage[i]);
            jlabel[i] = new JLabel(iimage[i]);
            jlabel[i].setBounds(0, 0, screenWidth, screenHeight - 60);
            panel1.add(jlabel[i]);

            JLabel l6 = new JLabel("WELCOME TO OUR WORLD");
            l6.setForeground(Color.YELLOW);
            l6.setFont(new Font("Bradley Hand ITC", Font.BOLD, 70));
            l6.setHorizontalAlignment(SwingConstants.CENTER);
            l6.setBounds(0, (screenHeight - 60) / 2 - 55, screenWidth, 110);
            jlabel[i].add(l6);
        }

        t1 = new Thread(this);
        t1.start();
    }

    // Helper method to create buttons
    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0, 139, 139, 220));
        button.setBounds(x, y, 100, 46);
        button.addActionListener(this);
        button.setFocusable(false);
        return button;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (int i = 0; i < 6; i++) {
                    jlabel[i].setVisible(true);
                    Thread.sleep(2000);
                    jlabel[i].setVisible(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            activeButton(b1);
            panel1.setVisible(true);
        } else if (ae.getSource() == b2) {
            activeButton(b2);
            if (l == null) l = new Login(this);
            l.setLocation(0, 60);
            l.setVisible(true);
            contentPane.add(l);
        } else if (ae.getSource() == b3) {
            activeButton(b3);
            if (a == null) a = new AdminLogin(this);
            a.setLocation(0, 60);
            a.setVisible(true);
            contentPane.add(a);
        }
    }

    public void activeButton(JButton b) {
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(0, 139, 139, 220));
        btn = b;
        btn.setForeground(Color.CYAN);
        btn.setBackground(Color.BLACK);
        disable();
    }

    public void disable() {
        if (panel1 != null && panel1.isVisible()) {
            panel1.setVisible(false);
        }
        if (l != null && l.isVisible()) {
            l.setVisible(false);
        }
        if (a != null && a.isVisible()) {
            a.setVisible(false);
        }
    }
}
