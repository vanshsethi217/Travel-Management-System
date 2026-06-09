import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;





public class BookHotel extends JFrame implements ActionListener
{
    Choice chotel,cac,cfood;
    JTextField tfpersons,tfdays;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton checkprice,bookhotel,back;

    BookHotel(String username)
    {
        this.username=username;

        setBounds(350,200,1100,600);     
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Book Hotel ");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lbusername = new JLabel("Username ");
        lbusername.setBounds(40,70,100,20);
        lbusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbusername);

         labelusername = new JLabel();
        labelusername.setBounds(250,70,200,20);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelusername);

        //hsjhjhsjfh
        JLabel ppackage = new JLabel("Select hotel ");
        ppackage.setBounds(40,110,100,20);
        ppackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(ppackage);

        chotel =new Choice();   
        chotel.setBounds(250,110,200,20);
        add(chotel);

        //jgddddddddddddd
          try
        {
            Conn conn =new Conn();
            String query="select * from hotel";
            ResultSet rs=conn.s.executeQuery(query);
        
            while(rs.next())
            {
            
                chotel.add(rs.getString("name"));
                
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        
        }

        //kkkkkkkkkkkkk


        JLabel lbpersons = new JLabel("Total Persons");
        lbpersons.setBounds(40, 150, 150, 25);
        lbpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbpersons);

         tfpersons =new JTextField("1");
        tfpersons.setBounds(250,150,200,25);  
        add(tfpersons);

         JLabel lbdays = new JLabel("No. of days");
        lbdays.setBounds(40, 190, 150, 25);
        lbdays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbdays);

         tfdays =new JTextField("1");
        tfdays.setBounds(250,190,200,25);  
        add(tfdays);

        //iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii

        JLabel lbac = new JLabel("AC / Non-AC");
        lbac.setBounds(40, 230, 150, 20);
        lbac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbac);

         cac =new Choice();   
        cac.setBounds(250,230,200,20);
        cac.add("AC");
        cac.add("Non-AC");
        add(cac);


        JLabel lbfood = new JLabel("Food Included");
        lbfood.setBounds(40, 270, 150, 20);
        lbfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbfood);

         cfood =new Choice();   
        cfood.setBounds(250,270,200,20);
        cfood.add("Yes");
        cfood.add("No");
        add(cfood);
        //ghuhuh


        JLabel lbid = new JLabel("ID");
        lbid.setBounds(40, 310, 150, 25);
        lbid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbid);

         labelid = new JLabel();
        labelid.setBounds(250,310,200,25);
        add(labelid);

        JLabel lbnumber = new JLabel("Number");
        lbnumber.setBounds(40, 350, 150, 25);
        lbnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250,350,200,25);     
        add(labelnumber);

        JLabel lbphone = new JLabel("Phone");
        lbphone.setBounds(40, 390, 150, 20);
        lbphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbphone);

         labelphone = new JLabel();
        labelphone.setBounds(250,390,200,25);     
        add(labelphone);

        JLabel lbtotal = new JLabel("Total Price");
        lbtotal.setBounds(40, 430, 150, 25);
        lbtotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbtotal);

         labelprice = new JLabel();
        labelprice.setBounds(250,430,200,25);     
        add(labelprice);

          try
        {
            Conn conn =new Conn();
            String query="select * from customer where username = '"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
        
            while(rs.next())
            {
            
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
            
                labelphone.setText(rs.getString("phone"));
                
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        
        }
        //lllllllllllllll

        checkprice= new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60,490,120,25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookhotel= new JButton("Book Hotel");
        bookhotel.setBackground(Color.BLACK);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setBounds(200,490,120,25);
        bookhotel.addActionListener(this);
        add(bookhotel);

        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,490,120,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,50,600,300);
        add(image);

        setVisible(true);
       
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == checkprice) 
            {
            try 
            {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("Select * from hotel where name ='" + chotel.getSelectedItem() + "'");
                while (rs.next()) 
                {
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));

                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());
                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();

                    if (persons * days > 0) 
                    {
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;

                        labelprice.setText("Rs " + total);

                    } else 
                    {

                        JOptionPane.showMessageDialog(null, "Please Enter a valid number.");
                    }

                }

            } catch (Exception e) 
            {
                e.printStackTrace();

            }

        }
        else if (ae.getSource() == bookhotel)
            {
            try {
                Conn c = new Conn();
                // c.s.executeUpdate("insert into bookhotel('" + labelusername.getText() + "','"
                //         + chotel.getSelectedItem() + "','" + tfpersons.getText() + "','" + tfdays.getText() + "','"
                //         + cac.getSelectedItem() + "','" + cfood.getSelectedItem() + "','" + labelid.getText() + "','"
                //         + labelnumber.getText() + "','" + labelphone.getText() + "','" + labelprice.getText() + "')");

                String query = "INSERT INTO bookhotel (username, name, persons, days, ac, food, id, number, phone, price) VALUES ('"
                        + labelusername.getText() + "', '"
                        + chotel.getSelectedItem() + "', '"
                        + tfpersons.getText() + "', '"
                        + tfdays.getText() + "', '"
                        + cac.getSelectedItem() + "', '"
                        + cfood.getSelectedItem() + "', '"
                        + labelid.getText() + "', '"
                        + labelnumber.getText() + "', '"
                        + labelphone.getText() + "', '"
                        + labelprice.getText() + "')";

                c.s.executeUpdate(query);


                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully.");
                setVisible(false);
            }

            catch (Exception e) {
                e.printStackTrace();
            }

        } 
        else 
        {
            setVisible(false);

        }

    }
    public static void main(String args[])
    {
        new BookHotel("dgd");
    }
    
}
