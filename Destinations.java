// import javax.swing.*;
// import java.awt.*;
// import java.sql.*;
// import java.awt.event.*;




// public class Destinations extends JFrame implements Runnable
// {

//     JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
//         JLabel [] label=new JLabel[]{l1,l2,l3,l4,l5,l6,l7,l8,l9,l10};
//         JLabel caption;
//     Thread t1;
//     public  void run()
//     {
//         String [] text={"JW Mariott","Mandarin Oriental Hotel","Four Seasons Hotel","Raddison Blue Hotel","Classio Hotel","The Bay Club Hotel","The Breeze Blow Hotel","The Taj Hotel","Happy Morning Motel","Moss View Hotel"};
//         try 
//         {
//             for(int i=0;i<=9;i++)
//             {
//                 label[i].setVisible(true);
//                // caption.setText(text[i]);
//                 Thread.sleep(2500);
//                 label[i].setVisible(false);
//             }

//         }
//           catch(Exception e)
//             {
//                 e.printStackTrace();

//             }


//     }

//     Destinations()
//     {


//         caption = new JLabel();
//         caption.setBounds(50,500,1000,70);
//         caption.setFont(new Font("Tahoma", Font.PLAIN, 40));
//         caption.setForeground(Color.WHITE);
//         add(caption);

//         setBounds(500,200,800,600); 

//         ImageIcon i1=null,i2=null,i3=null,i4=null,i5=null,i6=null,i7=null,i8=null,i9=null,i10=null;
//         ImageIcon [] image=new ImageIcon[]{i1,i2,i3,i4,i5,i6,i7,i8,i9,i10};

//         Image j1=null,j2=null,j3=null,j4=null,j5=null,j6=null,j7=null,j8=null,j9=null,j10=null;
//         Image [] jimage=new Image[]{j1,j2,j3,j4,j5,j6,j7,j8,j9,j10};

//         ImageIcon k1=null,k2=null,k3=null,k4=null,k5=null,k6=null,k7=null,k8=null,k9=null,k10=null;
//         ImageIcon [] kimage=new ImageIcon[]{k1,k2,k3,k4,k5,k6,k7,k8,k9,k10};

//          for(int i=0;i<=9;i++)
//             {
//                  image[i]= new ImageIcon(ClassLoader.getSystemResource("icons/dest" + (i+1) + ".jpg"));
//                 jimage[i]  = image[i].getImage().getScaledInstance(800,600, Image.SCALE_DEFAULT);
//                 kimage[i]=  new ImageIcon(jimage[i]);
//                 label[i] = new JLabel(kimage[i]);
//                 label[i].setBounds(0,0,800,600);
//                 add(label[i]);
//             }

//             t1=new Thread(this);

//             t1.start();
        
//                 setVisible(true);

//     }

//     public static void main(String args[])
//     {
//         new Destinations();
//     }
    
// }
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Destinations extends JFrame implements Runnable 
{

    JLabel[] label = new JLabel[10];
    JLabel caption;
    Thread t1;
    JButton bookBtn, leftBtn, rightBtn;
    String username;
    int currentIndex = 0;

    boolean manualClick = false;

    // ⭐ REAL destination names
    String[] names = {
            "Paris", "Tokyo", "Dubai", "New York", "London",
            "Maldives", "Istanbul", "Singapore", "Sydney", "Rome"
    };

    // ⭐ NORMAL SLIDESHOW (NO TIMER RESET)
    public void run() 
    {
        try 
        {
            while (true) 
            {
                if (!manualClick) 
                {
                    Thread.sleep(7000);  
                    currentIndex = (currentIndex + 1) % 10;
                    showImage(currentIndex);
                } 
                else 
                {
                    manualClick = false; 
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    Destinations(String username) 
    {

        this.username = username;

        setBounds(500, 200, 800, 600);
        setLayout(null);

        JLayeredPane lp = getLayeredPane();

        // Caption
        caption = new JLabel(names[0], SwingConstants.CENTER);
        caption.setBounds(200, 500, 400, 40);
        caption.setFont(new Font("Tahoma", Font.BOLD, 30));
        caption.setForeground(Color.WHITE);
        lp.add(caption, JLayeredPane.PALETTE_LAYER);

        // Load images
        for (int i = 0; i < 10; i++) 
        {
            ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/dest" + (i + 1) + ".jpg"));
            Image scaled = img.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
            ImageIcon finalImg = new ImageIcon(scaled);

            label[i] = new JLabel(finalImg);
            label[i].setBounds(0, 0, 800, 600);
            label[i].setVisible(false);

            lp.add(label[i], JLayeredPane.DEFAULT_LAYER);
        }

        label[0].setVisible(true);

        // BOOK NOW button
        bookBtn = new JButton("BOOK NOW");
        bookBtn.setBounds(600, 500, 150, 40);
        bookBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
        bookBtn.setForeground(Color.WHITE);
        bookBtn.setBackground(new Color(255, 69, 0));
        bookBtn.setFocusPainted(false);

        bookBtn.addMouseListener(new MouseAdapter() 
        {
            public void mouseEntered(MouseEvent e) 
            { bookBtn.setBackground(new Color(255, 120, 0)); 

            }
            public void mouseExited(MouseEvent e) 
            { bookBtn.setBackground(new Color(255, 69, 0)); 

            }
        });

        lp.add(bookBtn, JLayeredPane.DRAG_LAYER);

        // LEFT button
        leftBtn = new JButton("<");
        leftBtn.setBounds(20, 260, 50, 50);
        leftBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        leftBtn.setBackground(new Color(0, 0, 0, 120));
        leftBtn.setForeground(Color.WHITE);
        lp.add(leftBtn, JLayeredPane.DRAG_LAYER);

        // RIGHT button
        rightBtn = new JButton(">");
        rightBtn.setBounds(720, 260, 50, 50);
        rightBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        rightBtn.setBackground(new Color(0, 0, 0, 120));
        rightBtn.setForeground(Color.WHITE);
        lp.add(rightBtn, JLayeredPane.DRAG_LAYER);

        // Manual navigation
        leftBtn.addActionListener(e -> 
        {
            manualClick = true;
            currentIndex = (currentIndex - 1 + 10) % 10;
            showImage(currentIndex);
        });

        rightBtn.addActionListener(e -> 
        {
            manualClick = true;
            currentIndex = (currentIndex + 1) % 10;
            showImage(currentIndex);
        });

        // BOOK NOW SQL
        bookBtn.addActionListener(ae -> 
        {

            String destinationName = names[currentIndex];

            try 
            {
                Conn c = new Conn();

                String query = "INSERT INTO booked_destinations(username, destination) VALUES('" +
                        username + "', '" + destinationName + "')";

                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,
                        "Destination booked successfully!");

                dispose();

            } 
            catch (Exception e) 
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error while booking!");
            }
        });

        t1 = new Thread(this);
        t1.start();

        setVisible(true);
    }

    void showImage(int idx) 
    {
        for (int i = 0; i < 10; i++) label[i].setVisible(false);

        label[idx].setVisible(true);
        caption.setText(names[idx]); 
    }

    public static void main(String args[]) 
    {
        new Destinations("vs");
    }
}
