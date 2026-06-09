

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener
{

    JButton Create,Back;
    JTextField tfusername,tfname,tfpassword,tfAnswer;
    Choice security;



    Signup()
    {
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        
        JPanel p1=new JPanel();
        p1.setBackground(new Color(255, 165, 89));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);

        JLabel lbusername =new JLabel("Username");
        lbusername.setBounds(50,20,125,25);
        lbusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lbusername);

         tfusername =new JTextField();
        tfusername.setBounds(190,20,170,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        JLabel lbname =new JLabel("Name");
        lbname.setBounds(50,60,125,25);
        lbname.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lbname);

         tfname =new JTextField();
        tfname.setBounds(190,60,180,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lbpassword =new JLabel("Password");
        lbpassword.setBounds(50,100,125,25);
        lbpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lbpassword);

         tfpassword =new JTextField();
        tfpassword.setBounds(190,100,180,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);


         JLabel lbsecurity =new JLabel("Security Question");
        lbsecurity.setBounds(50,140,125,25);
        lbsecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lbsecurity);

         security =new Choice();
        security.add("First Car");
        security.add("Best Marvel superhero");
        security.add("Your lucky Number");
        security.add("Worst Sport");
        security.setBounds(190,140,180,25);
        p1.add(security);


        JLabel lbAnswer =new JLabel("Answer");
        lbAnswer.setBounds(50,180,125,25);
        lbAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lbAnswer);

         tfAnswer =new JTextField();
        tfAnswer.setBounds(190,180,180,25);
        tfAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfAnswer);


         Create =new JButton("Create");
        Create.setBounds(80,250,100,30);
        Create.setBackground(Color.WHITE);
        Create.setForeground(new Color(255, 165, 89));
         Create.setBorder(new LineBorder(new Color(133,193,233)));
         Create.setFont(new Font("Tahoma", Font.BOLD, 14));
         Create.addActionListener(this);
         p1.add(Create);


          Back = new JButton("Back");
         Back.setBounds(250, 250, 100, 30);
         Back.setBackground(Color.WHITE);
         Back.setForeground(new Color(255, 165, 89));
         Back.setBorder(new LineBorder(new Color(133, 193, 233)));
         Back.setFont(new Font("Tahoma", Font.BOLD, 14));
         Back.addActionListener(this);
         p1.add(Back);


         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(580,50,250,250);
        add(image);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {

        if (ae.getSource() == Create) 
        {

            String username=tfusername.getText();
            String name=tfname.getText();
            String password=tfpassword.getText();
            String question=security.getSelectedItem();
            String answer=tfAnswer.getText();



            String query="insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            try
            {
            
                Conn c= new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new Login();
            }
            catch(Exception e)
            {
                e.printStackTrace();

            }
        } 
        else if (ae.getSource() == Back) 
        {
            setVisible(false);
            new Login();

        }
    }
    
    public static void main(String args[])
    {
        new Signup();

    }
    
}
