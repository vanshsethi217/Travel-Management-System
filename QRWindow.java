import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class QRWindow extends JFrame implements ActionListener 
{

    JButton done;
    String username;

    QRWindow(String username) 
    {
        this.username = username;

        setBounds(500, 200, 400, 500);
        setLayout(null);

        // Load QR image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/gpayqr.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        JLabel qr = new JLabel(new ImageIcon(i2));
        qr.setBounds(25, 20, 350, 350);
        add(qr);

        done = new JButton("DONE");
        done.setBounds(150, 400, 100, 40);
        done.addActionListener(this);
        add(done);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == done) 
        {

            try 
            {
                Conn c = new Conn();

                // Fetch customer email
                String query = "SELECT email FROM customer WHERE username = '" + username + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) 
                {
                    String email = rs.getString("email");

                    // ---------------- SEND EMAIL SAFELY ----------------
                    try 
                    {
                        EmailSender.sendEmail(email, username);
                        JOptionPane.showMessageDialog(null,
                                "Payment Verified!\nBooking Confirmed ✔\nEmail sent to: " + email);
                    } 
                    catch (Exception ex) 
                    {
                        JOptionPane.showMessageDialog(null,
                                "Booking Saved.\nBut email could NOT be sent. ❌");
                        ex.printStackTrace();
                    }

                }
                else 
                {
                    JOptionPane.showMessageDialog(null,
                            "Error: Customer email not found for username → " + username);
                }

            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }

            // Move to Payment screen after done
            setVisible(false);
            new Payment(username);
        }
    }

    public static void main(String[] args)
    {
        new QRWindow("dog");  // TEST USERNAME
    }
}
