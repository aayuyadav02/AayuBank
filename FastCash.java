package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton hundred, fundred, thousand, tthousand, fthousand, tenthousand, back;
    String pinnumber;
    
    FastCash(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(265, 335, 700, 35);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        hundred = new JButton("Rs. 100");
        hundred.setBounds(220, 440, 120, 25);
        hundred.addActionListener(this);
        image.add(hundred);
        
        fundred = new JButton("Rs. 500");
        fundred.setBounds(390, 440, 145, 25);
        fundred.addActionListener(this);
        image.add(fundred);
        
        thousand = new JButton("Rs. 1000");
        thousand.setBounds(220, 470, 120, 25);
        thousand.addActionListener(this);
        image.add(thousand);
        
        tthousand = new JButton("Rs. 2000");
        tthousand.setBounds(390, 470, 145, 25);
        tthousand.addActionListener(this);
        image.add(tthousand);
        
        fthousand = new JButton("Rs. 5000");
        fthousand.setBounds(220, 500, 120, 25);
        fthousand.addActionListener(this);
        image.add(fthousand);
        
        tenthousand = new JButton("Rs. 10000");
        tenthousand.setBounds(390, 500, 145, 25);
        tenthousand.addActionListener(this);
        image.add(tenthousand);
        
        back = new JButton("BACK");
        back.setBounds(390, 530, 145, 25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(4);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                  JOptionPane.showMessageDialog(null, "Inssuficent Balance");
                  return;
                }
                
                Date date = new Date();
                String query ="insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. "+" Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}