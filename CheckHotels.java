// import javax.swing.*;
// import java.awt.*;
// import java.sql.*;
// import java.awt.event.*;




// public class CheckHotels extends JFrame implements Runnable
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
//                 caption.setText(text[i]);
//                 Thread.sleep(2500);
//                 label[i].setVisible(false);
//             }

//         }
//           catch(Exception e)
//             {
//                 e.printStackTrace();

//             }


//     }

//     CheckHotels()
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
//                  image[i]= new ImageIcon(ClassLoader.getSystemResource("icons/hotel" + (i+1) + ".jpg"));
//                 jimage[i]  = image[i].getImage().getScaledInstance(800,600, Image.SCALE_DEFAULT);
//                 kimage[i]= new ImageIcon(jimage[i]);
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
//         new CheckHotels();
//     }
    
// }
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckHotels extends JFrame implements ActionListener, Runnable {

    JLabel imageLabel, caption;
    JButton btnNext, btnPrev;

    ImageIcon[] hotelImages = new ImageIcon[10];
    String[] hotelNames = {
        "JW Mariott","Mandarin Oriental Hotel","Four Seasons Hotel","Raddison Blue Hotel",
        "Classio Hotel","The Bay Club Hotel","The Breeze Blow Hotel","The Taj Hotel",
        "Happy Morning Motel","Moss View Hotel"
    };

    int index = 0;
    long lastActionTime = System.currentTimeMillis();   // ⭐ track last button press
    Thread slideshowThread;

    CheckHotels() {

        setBounds(450, 150, 800, 600);
        setLayout(null);

        loadImages();

        // IMAGE LABEL
        imageLabel = new JLabel(hotelImages[0]);
        imageLabel.setBounds(0, 0, 800, 600);
        add(imageLabel);

        // CAPTION
        caption = new JLabel(hotelNames[0]);
        caption.setBounds(30, 480, 700, 50);
        caption.setFont(new Font("Tahoma", Font.BOLD, 32));
        caption.setForeground(Color.WHITE);
        caption.setOpaque(false);
        add(caption);

        // PREV BUTTON
        btnPrev = new JButton("<");
        btnPrev.setBounds(20, 250, 60, 40);
        btnPrev.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnPrev.setBackground(new Color(0, 0, 0, 10));
        btnPrev.setForeground(Color.WHITE);
        btnPrev.setOpaque(true);
        btnPrev.addActionListener(this);
        add(btnPrev);

        // NEXT BUTTON
        btnNext = new JButton(">");
        btnNext.setBounds(720, 250, 60, 40);
        btnNext.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNext.setBackground(new Color(0, 0, 0, 10));
        btnNext.setForeground(Color.WHITE);
        btnNext.setOpaque(true);
        btnNext.addActionListener(this);
        add(btnNext);

        // bring buttons & caption to top layer
        bringToFront();

        // start slideshow
        slideshowThread = new Thread(this);
        slideshowThread.start();

        setVisible(true);
    }

    void bringToFront() {
        setComponentZOrder(btnPrev, 0);
        setComponentZOrder(btnNext, 0);
        setComponentZOrder(caption, 0);
        setComponentZOrder(imageLabel, 1);
    }

    void loadImages() {
        for (int i = 0; i < 10; i++) {
            ImageIcon raw = new ImageIcon(ClassLoader.getSystemResource("icons/hotel" + (i+1) + ".jpg"));
            Image scaled = raw.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
            hotelImages[i] = new ImageIcon(scaled);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnNext) {
            index = (index + 1) % 10;
        } else if (e.getSource() == btnPrev) {
            index = (index - 1 + 10) % 10;
        }

        updateImage();

        // ⭐ Reset slideshow timer
        lastActionTime = System.currentTimeMillis();
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(500); // check twice a second

                long now = System.currentTimeMillis();
                if (now - lastActionTime >= 7000) {  // ⭐ 7 sec passed without user input
                    index = (index + 1) % 10;
                    updateImage();
                    lastActionTime = System.currentTimeMillis();   // reset timer
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void updateImage() {
        imageLabel.setIcon(hotelImages[index]);
        caption.setText(hotelNames[index]);
        bringToFront();   // ⭐ keep buttons always visible
    }

    public static void main(String[] args) {
        new CheckHotels();
    }
}
