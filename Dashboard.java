import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Dashboard extends JFrame implements ActionListener
{
    JButton addPersonalDetails, viewPersonalDetails,updatePersonalDetails,checkPackage, bookPackage,viewPackage,destination,viewHotels,bookHotels,viewBookedHotels,payments,notepad,calculator,about,deletePersonalDetails;
 
    String username;
    Dashboard(String username)
    {
        this.username=username;
        //setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(58, 189, 252));
        p1.setBounds(0,0,1600,65);
       add(p1);


         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon =new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.ORANGE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(232, 210, 178));
        p2.setBounds(0,65,300,900);
       add(p2);



       addPersonalDetails =new JButton("Add Personal Details");
       addPersonalDetails.setBounds(0,0,300,50);
       addPersonalDetails.setBackground(new Color(255, 186, 0));
       addPersonalDetails.setForeground(Color.BLACK);
       addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
       addPersonalDetails.setMargin(new Insets(0,0,0,60));
       addPersonalDetails.addActionListener(this);
       p2.add(addPersonalDetails);

       
        updatePersonalDetails =new JButton("Update Personal Details");
       updatePersonalDetails.setBounds(0,50,300,50);
       updatePersonalDetails.setBackground(new Color(255, 186, 0));
       updatePersonalDetails.setForeground(Color.BLACK);
       updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
       updatePersonalDetails.setMargin(new Insets(0,0,0,30));
       updatePersonalDetails.addActionListener(this);
       p2.add(updatePersonalDetails);

        viewPersonalDetails =new JButton("View Details");
       viewPersonalDetails.setBounds(0,100,300,50);
       viewPersonalDetails.setBackground(new Color(255, 186, 0));
       viewPersonalDetails.setForeground(Color.BLACK);
       viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
       viewPersonalDetails.setMargin(new Insets(0,0,0,130));
       viewPersonalDetails.addActionListener(this);
       p2.add(viewPersonalDetails);

        deletePersonalDetails =new JButton("Delete Personal Details");
       deletePersonalDetails.setBounds(0,150,300,50);
       deletePersonalDetails.setBackground(new Color(255, 186, 0));
       deletePersonalDetails.setForeground(Color.BLACK);
       deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
       deletePersonalDetails.setMargin(new Insets(0,0,0,40));
       deletePersonalDetails.addActionListener(this);
       p2.add(deletePersonalDetails);

         checkPackage =new JButton("Check Package");
       checkPackage.setBounds(0,200,300,50);
       checkPackage.setBackground(new Color(255, 186, 0));
       checkPackage.setForeground(Color.BLACK);
       checkPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
       checkPackage.setMargin(new Insets(0,0,0,110));
       checkPackage.addActionListener(this);
       p2.add(checkPackage);

         bookPackage =new JButton("Book Package");
       bookPackage.setBounds(0,250,300,50);
       bookPackage.setBackground(new Color(255, 186, 0));
       bookPackage.setForeground(Color.BLACK);
       bookPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
       bookPackage.setMargin(new Insets(0,0,0,120));
       bookPackage.addActionListener(this);
       p2.add(bookPackage);

         viewPackage =new JButton("View Package");
       viewPackage.setBounds(0,300,300,50);
       viewPackage.setBackground(new Color(255, 186, 0));
       viewPackage.setForeground(Color.BLACK);
       viewPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
       viewPackage.setMargin(new Insets(0,0,0,120));
       viewPackage.addActionListener(this);
       p2.add(viewPackage);

         viewHotels =new JButton("Check Hotels");
       viewHotels.setBounds(0,350,300,50);
       viewHotels.setBackground(new Color(255, 186, 0));
       viewHotels.setForeground(Color.BLACK);
       viewHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
       viewHotels.setMargin(new Insets(0,0,0,130));
       viewHotels.addActionListener(this);
       p2.add(viewHotels);

        bookHotels =new JButton("Book Hotels");
       bookHotels.setBounds(0,400,300,50);
       bookHotels.setBackground(new Color(255, 186, 0));
       bookHotels.setForeground(Color.BLACK);
       bookHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
       bookHotels.setMargin(new Insets(0,0,0,140));
       bookHotels.addActionListener(this);
       p2.add(bookHotels);

        viewBookedHotels =new JButton("View Booked Hotels");
       viewBookedHotels.setBounds(0,450,300,50);
       viewBookedHotels.setBackground(new Color(255, 186, 0));
       viewBookedHotels.setForeground(Color.BLACK);
       viewBookedHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
       viewBookedHotels.setMargin(new Insets(0,0,0,70));
       viewBookedHotels.addActionListener(this);
       p2.add(viewBookedHotels);

        destination =new JButton("Destination");
      destination .setBounds(0,500,300,50);
       destination.setBackground(new Color(255, 186, 0));
       destination.setForeground(Color.BLACK);
       destination.setFont(new Font("Tahoma",Font.PLAIN,20));
       destination.setMargin(new Insets(0,0,0,125));
       destination.addActionListener(this);
       p2.add(destination);



         payments=new JButton("Payments");
       payments.setBounds(0,550,300,50);
       payments.setBackground(new Color(255, 186, 0));
      payments .setForeground(Color.BLACK);
      payments .setFont(new Font("Tahoma",Font.PLAIN,20));
       payments.setMargin(new Insets(0,0,0,155));
       payments.addActionListener(this);
       p2.add(payments);

         calculator=new JButton("Calculator");
       calculator.setBounds(0,600,300,50);
       calculator.setBackground(new Color(255, 186, 0));
       calculator.setForeground(Color.BLACK);
       calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
       calculator.addActionListener(this);
       calculator.setMargin(new Insets(0,0,0,145));
       p2.add(calculator);

         notepad=new JButton("Notepad");
       notepad.setBounds(0,650,300,50);
       notepad.setBackground(new Color(255, 186, 0));
       notepad.setForeground(Color.BLACK);
       notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
       notepad.addActionListener(this);
       notepad.setMargin(new Insets(0,0,0,155));
       p2.add(notepad);

       
         about=new JButton("About");
      about .setBounds(0,700,300,50);
       about.setBackground(new Color(255, 186, 0));
       about.setForeground(Color.BLACK);
       about.setFont(new Font("Tahoma",Font.PLAIN,20));
      about .setMargin(new Insets(0,0,0,17570));
      about.addActionListener(this);
       p2.add(about);


        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5=i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image =new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);


        /*
         * JLabel text= new JLabel ("Travel and Tourism Management System") ;
         * text.setBounds (400, 70, 1200, 70) ;
         * text.setForeground (new Color(255, 250, 88)) ;
         * text. setFont (new Font ("Raleway", Font. PLAIN, 55) ) ;
         * image.add (text) ;
         */
        // Shadow label (behind)
        JLabel shadow = new JLabel(
                "<html><div style='color: rgba(255, 255, 255, 1);'>Travel and Tourism Management System</div></html>");
        shadow.setFont(new Font("Raleway", Font.BOLD, 55));
        shadow.setBounds(342, 72, 1400, 70); // Slight offset for shadow
        image.add(shadow);

        // Main label (front)
        JLabel text = new JLabel("<html><div style='color:black;'>Travel and Tourism Management System</div></html>");
        text.setFont(new Font("Raleway", Font.BOLD, 55));
        text.setBounds(340, 70, 1400, 70);
        image.add(text);











        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
     {

        if (ae.getSource() == addPersonalDetails) 
        {

           new AddCustomer(username);
        } 
        else if ( ae.getSource() == viewPersonalDetails)
        {
            new ViewCustomer(username);
        
        }
        else if ( ae.getSource() == updatePersonalDetails)
        {
            new UpdateCustomer(username);
        
        }
         else if ( ae.getSource() == checkPackage)
        {
            new CheckPackage();
        
        }
         else if ( ae.getSource() == bookPackage)
        {
            new BookPackage(username);
        
        }
        else if ( ae.getSource() == viewPackage)
        {
            new ViewPackage(username);
        
        }
        else if ( ae.getSource() == viewHotels)
        {
            new CheckHotels();
        
        }
          else if ( ae.getSource() == destination)
        {
            new Destinations(username);
        
        }
          else if ( ae.getSource() == bookHotels)
        {
            new BookHotel(username);
        
        }
        else if ( ae.getSource() == viewBookedHotels)
        {
            new ViewBookedHotel(username);
        
        }
        else if ( ae.getSource() == payments)
        {
            new Payment(username);
        
        }
        else if ( ae.getSource() == calculator)
        {
            try {
                Runtime.getRuntime().exec("calc.exe");
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        }
        else if ( ae.getSource() == notepad)
        {
            try {
                Runtime.getRuntime().exec("notepad.exe");
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        }
         else if ( ae.getSource() == about)
        {
            new About();
        }
        else if ( ae.getSource() == deletePersonalDetails)
        {
            new DeleteDetails(username);
        }
    }
    public static void main(String args[])
    {
        new Dashboard("");
    }
}





