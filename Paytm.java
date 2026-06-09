// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;

// public class Paytm extends JFrame implements ActionListener
// {
    

//     Paytm()
//     {
//         setBounds(500,200,800,600);
//         //setLayout(null);

//         JEditorPane pane=new JEditorPane();
//         pane.setEditable(false);


//         try {
//             //pane.setPage("https://paytm.com/rent-payment");
//             pane.setPage("https://example.com");
          


//         } catch (Exception e) {
//             pane.setContentType("text/html");
//             pane.setText("<html>Could not Load ....ERROR 404 !!!</html>");
//         }

//         JScrollPane sp = new JScrollPane(pane);
//         getContentPane().add(sp);

//           JButton     back= new JButton("Back");
       
//         back.setBounds(610,20,80,40);
//         back.addActionListener(this);
//         pane.add(back);

//         setVisible(true);

//     }
//      public void actionPerformed(ActionEvent ae)
//     {
//          setVisible(false);
//          new Payment();

//     }
//     public static void main(String args[]) 
//     {
//         new Paytm();
//     }
// }
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class Paytm extends JFrame implements ActionListener 
{

    JButton back, open;

    Paytm() 
    {
        setBounds(500,200,800,600);
        setLayout(null);

        JLabel msg = new JLabel("Click below to open Paytm securely in your browser");
        msg.setBounds(180, 200, 500, 30);
        add(msg);

        open = new JButton("Open Paytm");
        open.setBounds(310, 260, 150, 40);
        open.addActionListener(this);
        add(open);

        back = new JButton("Back");
        back.setBounds(10,10,80,30);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == open) 
            {
            try 
            {
                Desktop.getDesktop().browse(new URI("https://paytm.com/rent-payment"));
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        } 
        setVisible(false);
        new Payment("");
    }
}
