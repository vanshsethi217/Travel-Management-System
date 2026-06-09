import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;





public class BookPackage extends JFrame implements ActionListener
{
    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton checkprice,bookpackage,back;

    BookPackage(String username)
    {
        this.username=username;

        setBounds(350,200,1100,500);     
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Book Package ");
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
        JLabel ppackage = new JLabel("Select Package ");
        ppackage.setBounds(40,110,100,20);
        ppackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(ppackage);

        cpackage =new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");

        cpackage.setBounds(250,110,200,20);
        add(cpackage);


        JLabel lbpersons = new JLabel("Total Persons");
        lbpersons.setBounds(40, 150, 150, 25);
        lbpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbpersons);

         tfpersons =new JTextField("1");
        tfpersons.setBounds(250,150,200,25);  
        add(tfpersons);

        JLabel lbid = new JLabel("ID");
        lbid.setBounds(40, 190, 150, 20);
        lbid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbid);

         labelid = new JLabel();
        labelid.setBounds(250,190,200,25);
        add(labelid);

        JLabel lbnumber = new JLabel("Number");
        lbnumber.setBounds(40, 230, 150, 25);
        lbnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250,230,200,25);     
        add(labelnumber);

        JLabel lbphone = new JLabel("Phone");
        lbphone.setBounds(40, 270, 150, 20);
        lbphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbphone);

         labelphone = new JLabel();
        labelphone.setBounds(250,270,200,25);     
        add(labelphone);

        JLabel lbtotal = new JLabel("Total Price");
        lbtotal.setBounds(40, 310, 150, 25);
        lbtotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbtotal);

         labelprice = new JLabel();
        labelprice.setBounds(250,310,200,25);     
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

        checkprice= new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage= new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200,380,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,50,500,300);
        add(image);

        setVisible(true);
       
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() ==checkprice)
        {
            String pack=cpackage.getSelectedItem();
            int cost=0;
            if(pack.equals("Gold Package"))
                cost+=35000;
            else if(pack.equals("Silver Package"))
                cost+=24000;
            else
                cost+=12000;

            int persons=Integer.parseInt(tfpersons.getText());
            cost*=persons;
            labelprice.setText("Rs "+cost);


            
        }
        else if (ae.getSource() == bookpackage) 
            {
            try {
                Conn c = new Conn();
               /* c.s.executeUpdate("insert into bookpackage values ('" + labelusername.getText() + "','"
                        + cpackage.getSelectedItem() + "','" + tfpersons.getText() + "','" + labelid.getText() + "','"
                        + labelnumber.getText() + "','" + labelphone.getText() + "','" + labelprice.getText() + "')");*/

               String query = "INSERT INTO bookpackage (username, package, persons, id, number, phone, price) VALUES ('"
                       + labelusername.getText() + "', '"
                       + cpackage.getSelectedItem() + "', '"
                       + tfpersons.getText() + "', '"
                       + labelid.getText() + "', '"
                       + labelnumber.getText() + "', '"
                       + labelphone.getText() + "', '"
                       + labelprice.getText() + "')";

c.s.executeUpdate(query);


                JOptionPane.showMessageDialog(null, "Package Booked Successfully.");
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
        new BookPackage("dgd");
    }
    
}
