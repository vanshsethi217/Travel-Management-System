import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;



public class UpdateCustomer extends JFrame implements ActionListener
{
    JLabel labelusername,labelname;
    JComboBox comboid;
    JTextField tfnumber,tfaddress,tfcountry,tfemail,tfphone,tfid,tfgender;
    JRadioButton rmale,rfemale;
    JButton add,back;

    UpdateCustomer(String username)
    {
        setBounds(550, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

         JLabel text = new JLabel("UPDATE CUSTOMER DETAILS -");
        text.setBounds(50, 0, 300, 25);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);



        JLabel lbusername = new JLabel("Username");
        lbusername.setBounds(30, 50, 150, 25);
        add(lbusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lbid = new JLabel("ID ");
        lbid.setBounds(30, 90, 150, 25);
        add(lbid);

        tfid = new JTextField();//88888888888888888
        tfid.setBounds(220, 90, 150, 25);
        add(tfid);


        JLabel lbnumber = new JLabel("Number ");
        lbnumber.setBounds(30, 130, 150, 25);
        add(lbnumber);

         tfnumber = new JTextField();//88888888888888888
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);

        JLabel lbname = new JLabel("Name ");
        lbname.setBounds(30, 170, 150, 25);
        add(lbname);

        labelname = new JLabel();
        labelname.setBounds(220, 170, 150, 25);
        add(labelname);

        JLabel lbgender = new JLabel("Gender ");
        lbgender.setBounds(30, 210, 150, 25);
        add(lbgender);

        tfgender = new JTextField();//88888888888888888
        tfgender.setBounds(220, 210, 150, 25);
        add(tfgender);

        JLabel country = new JLabel("Country ");
        country.setBounds(30, 250, 150, 25);
        add(country);

         tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);

        JLabel address = new JLabel("Address ");
        address.setBounds(30, 290, 150, 25);
        add(address);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 150, 25);
        add(tfaddress);

        JLabel lbphone = new JLabel("Phone ");
        lbphone.setBounds(30, 330, 150, 25);
        add(lbphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);

        JLabel lbemail = new JLabel("Email ID ");
        lbemail.setBounds(30, 370, 150, 25);
        add(lbemail);

        tfemail = new JTextField();
        tfemail.setBounds(220, 370, 150, 25);
        add(tfemail);

        //----------------------------------

        add= new JButton("Update");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);

        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2=i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(400,100,450,300);
        add(image);

        try 
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer where username ='"+username+"'");

            //ResultSet rs = c.s.executeQuery("select * from account where username ='"+username+"'");


            while(rs.next())
            {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));

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
        if(ae.getSource() ==add)
        {
            String username =labelusername.getText();
            String id =tfid.getText();
            String number =tfnumber.getText();
            String name =labelname.getText();
            String gender =tfgender.getText();
            

            String country =tfcountry.getText();
            String address =tfaddress.getText();
            String phone =tfphone.getText();
            String email =tfemail.getText();
            try
            {

                Conn c=new Conn();
                //String query="insert into customer values{'"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"'}";
                String query = "update  customer  set username='"+username+"',id='"+id+"',number='"+number+"',name ='"+name+"',gender ='"+gender+"',country ='"+country+"',address ='"+address+"',phone ='"+phone+"',email ='"+email+"'";

                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Customer Detail Updated Succefully");
                setVisible(false);
                
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }



        }
        else
        setVisible(false);

    }
    public static void main(String args[])
    {
        new UpdateCustomer("dgd");

    }
    
    
}
