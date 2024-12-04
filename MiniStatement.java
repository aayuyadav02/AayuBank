package bank.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class MiniStatement extends JFrame{
    
    MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        add(mini);
        
        JLabel bank = new JLabel("Bank Of India");
        bank.setFont(new Font("Arial", Font.BOLD, 16));
        bank.setBounds(150, 20, 110, 30);
        add(bank);
        
        JLabel atm = new JLabel("Relationships Beyond Banking");
        atm.setFont(new Font("Arial", Font.BOLD, 16));
        atm.setBounds(100, 40, 240, 30);
        add(atm);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card number: " + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn c = new Conn();
        int bal = 0;
        StringBuilder miniText = new StringBuilder("<html>");
        ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
        while (rs.next()) {
        // Add each transaction to the mini statement
            miniText.append(rs.getString("date")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                    .append(rs.getString("type")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                    .append(rs.getString("amount")).append("<br><br>");
        
        // Update the balance based on the transaction type
            if (rs.getString("type").equals("Deposit")) {
                bal += Integer.parseInt(rs.getString("amount"));
            } else {
                bal -= Integer.parseInt(rs.getString("amount"));
            }
        }
        miniText.append("</html>"); // Close the HTML string
        mini.setText(miniText.toString()); // Set the formatted text to the JLabel
    
    // Update balance
        balance.setText("Your Current Account Balance is Rs. " + bal);
        add(balance);
    } catch (Exception e) {
        System.out.println(e);
        }
        
        mini.setBounds(20, 140, 400, 200);
        
        setSize(400, 600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MiniStatement("");
    }
}