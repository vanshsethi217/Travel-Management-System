import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
 
public class ViewBookedHotel extends JFrame implements ActionListener
{
    JButton back;
    ViewBookedHotel(String username)
    {
        setBounds(400,200,1000,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("View Booked Hotel Details ");
        text.setBounds(60,0,400,30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lbusername =new JLabel("Username");
        lbusername.setBounds(30,50,150,25);
        add(lbusername);

        JLabel labelusername=new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        JLabel lbid =new JLabel("Hotel Name");
        lbid.setBounds(30,90,150,25);
        add(lbid);

        JLabel labelpackage=new JLabel();
        labelpackage.setBounds(220,90,150,25);
        add(labelpackage);

        JLabel lbnumber =new JLabel("Total Persons");
        lbnumber.setBounds(30,130,150,25);
        add(lbnumber);

        JLabel labelpersons=new JLabel();
        labelpersons.setBounds(220,130,150,25);
        add(labelpersons);
        //lllllll

         JLabel lbdays =new JLabel("Total Days");
        lbdays.setBounds(30,170,150,25);
        add(lbdays);

        JLabel labeldays=new JLabel();
        labeldays.setBounds(220,170,150,25);
        add(labeldays);


         JLabel lbac =new JLabel("AC / Non-AC");
        lbac.setBounds(30,210,150,25);
        add(lbac);

        JLabel labelac=new JLabel();
        labelac.setBounds(220,210,150,25);
        add(labelac);


         JLabel lbfood =new JLabel("Food Included");
        lbfood.setBounds(30,250,150,25);
        add(lbfood);

        JLabel labelfood=new JLabel();
        labelfood.setBounds(220,250,150,25);
        add(labelfood);


        //llllllllllllll

        JLabel lbname =new JLabel("ID");
        lbname.setBounds(30,290,150,25);
        add(lbname);

        JLabel labelid=new JLabel();
        labelid.setBounds(220,290,150,25);
        add(labelid);


        JLabel lbgender =new JLabel("Number");
        lbgender.setBounds(30,330,150,25);
        add(lbgender);

        JLabel labelnumber=new JLabel();
        labelnumber.setBounds(220,330,150,25);
        add(labelnumber);
//---------------------------------------------1----------------------------------
        JLabel lbcountry =new JLabel("Phone");
        lbcountry.setBounds(30,370,150,25);
        add(lbcountry);

        JLabel labelphone=new JLabel();
        labelphone.setBounds(220,370,150,25);
        add(labelphone);

       JLabel lbaddress =new JLabel("Total Cost");
        lbaddress.setBounds(30,410,150,25);
        add(lbaddress);

        JLabel labelprice=new JLabel();
        labelprice.setBounds(220,410,150,25);
        add(labelprice);

        //==================================================
        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130,460,100,25);
        back.addActionListener(this);
        add(back);

         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,20,500,400);
        add(image);

        //=========================
        try
        {
            Conn conn =new Conn();
            String query="select * from bookhotel where username = '"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
        
            while(rs.next())
            {
            
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelpackage.setText(rs.getString("name"));
                labelprice.setText(rs.getString("price"));
                labelphone.setText(rs.getString("phone"));
                labelpersons.setText(rs.getString("persons"));
                labelnumber.setText(rs.getString("number"));
                labelfood.setText(rs.getString("food"));
                labelac.setText(rs.getString("ac"));
                labeldays.setText(rs.getString("days"));
              
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        
        }

        setVisible(true);
       
    }

    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
    }
    public static void main(String args[])
    {
        new ViewBookedHotel("dgd");
    }
    


    
}
