
/*
import javax.swing.*;
import java.awt.*;
public class Splash extends JFrame
 {
    Splash() 
    {

        setSize(1200,600);
        setLocation(200,100);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));

        JLabel image = new JLabel(i1);
        add(image);



        setVisible(true);


    }

    public static void main(String args[]) 
    {

        new Splash();

    }
}
 */

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable 
{

    Thread t;

    Splash() 
    {

        // ImageIcon i1=new
        // ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));

        // JLabel image = new JLabel(i1);
        // add(image);

        // setSize(1200,600);
        // setLocation(200,100);
        // setVisible(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1200, 600); // Makes the image fill the frame
        add(image);

        setSize(1200, 600);
        setLocation(200, 100);
        setLayout(null);
        setVisible(true);

        t = new Thread(this);
        t.start();
    }

    public void run() 
    {
        try 
        {
            Thread.sleep(2000); // wait 2 seconds
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        setVisible(false);
        new Login(); // open login after delay
    }

    public static void main(String[] args) 
    {
        new Splash(); // ONLY splash here
    }
}
