import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.sql.ResultSet;
import java.util.Properties;

public class EmailSender {

    public static void sendEmail(String toEmail, String username) 
    {

        final String from = "case8055b@gmail.com";
        final String password = "kqlubkojfotllmce";   // Gmail App Password

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() 
        {
            
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(from, password);
            }
        });

        try 
        {

            // ---------------- FETCH DATA FROM DATABASE ------------------
            Conn c = new Conn();

            String custQuery = "SELECT * FROM customer WHERE username='" + username + "'";
            String packQuery = "SELECT * FROM bookpackage WHERE username='" + username + "'";
            String hotelQuery = "SELECT * FROM bookhotel WHERE username='" + username + "'";
            String destQuery = "SELECT destination FROM booked_destinations WHERE username='" + username + "' ORDER BY id DESC LIMIT 1";

            String custName = "", packageName = "", destination = "", hotelName = "";
            String persons = "", packPrice = "0", hotelPrice = "0";

            try 
            {
                ResultSet rs1 = c.s.executeQuery(custQuery);
                if (rs1.next()) 
                {
                    custName = rs1.getString("name");
                }

                ResultSet rs2 = c.s.executeQuery(packQuery);
                if (rs2.next()) 
                {
                    packageName = rs2.getString("package");
                    persons = rs2.getString("persons");
                    packPrice = rs2.getString("price");    // "Rs 35000"
                }

                ResultSet rs3 = c.s.executeQuery(hotelQuery);
                if (rs3.next()) 
                {
                    hotelName = rs3.getString("name");
                    hotelPrice = rs3.getString("price");   // "Rs 15000"
                }

                ResultSet rs4 = c.s.executeQuery(destQuery);
                if (rs4.next()) 
                {
                    destination = rs4.getString("destination");
                }

            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }

            // ---------------- CLEAN PRICE VALUES ------------------
            // Remove Rs, spaces, commas, anything non-numeric
            String cleanPackPrice = packPrice.replaceAll("[^0-9]", "");
            String cleanHotelPrice = hotelPrice.replaceAll("[^0-9]", "");

            // Convert to integers
            int packCost = cleanPackPrice.isEmpty() ? 0 : Integer.parseInt(cleanPackPrice);
            int hotelCost = cleanHotelPrice.isEmpty() ? 0 : Integer.parseInt(cleanHotelPrice);

            int totalCost = packCost + hotelCost;

            // ---------------- CREATE EMAIL MESSAGE ------------------
            String finalMessage =
                    "Hello " + custName + ",\n\n" +
                    "Payment was successful. Your booking is confirmed.\n\n" +
                    "Package Details:\n" +
                    "• Package: " + packageName + "\n" +
                    "• Persons: " + persons + "\n" +
                    "• Package Cost: " + packPrice + "\n\n" +
                    "Destination:\n" +
                    "• " + destination + "\n\n" +
                    "Hotel Details:\n" +
                    "• Hotel: " + hotelName + "\n" +
                    "• Hotel Price: " + hotelPrice + "\n\n" +
                    "TOTAL AMOUNT PAID: Rs " + totalCost + "\n\n" +
                    "Thank you for booking with Travel Management System!";

            // ---------------- SEND EMAIL ------------------
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Booking Confirmed");
            message.setText(finalMessage);

            Transport.send(message);

            System.out.println("Email sent successfully.");

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) 
    {
        EmailSender.sendEmail("atharva.karanjkar@gmail.com", "atharva123");
    }
}
