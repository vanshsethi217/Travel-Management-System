import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {

    About() {
        setBounds(600, 200, 500, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // --- Heading Label ---
        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(200, 10, 200, 40);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l1);

        String s = "About Projects\n\n" +
                "The objective of the Travel and Tourism Management System project is to develop a system that automates travel operations.\n"
                +
                "This application will help in accessing information related to travel for the particular user.\n\n" +
                "Advantages of Project:\n" +
                "• Gives accurate information\n" +
                "• Simplifies the manual work\n" +
                "• It minimizes the documentation related work\n" +
                "• Provides up to date information\n" +
                "• Friendly environment by providing warning messages\n" +
                "• Travelers details can be provided\n" +
                "• Booking confirmation notification";

        // --- Text Area ---
        TextArea area = new TextArea(
                s,
                10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 100, 450, 300);
        add(area);

        JButton back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 420, 100, 25);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);

    }

    public static void main(String[] args) {
        new About();
    }
}
