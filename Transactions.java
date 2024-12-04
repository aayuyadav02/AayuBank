package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit, cashwithdraw, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pinnumber;
    
    Transactions(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(265, 335, 700, 35);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(220, 440, 120, 25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        cashwithdraw = new JButton("CASH WITHDRAWL");
        cashwithdraw.setBounds(390, 440, 145, 25);
        cashwithdraw.addActionListener(this);
        image.add(cashwithdraw);
        
        fastcash = new JButton("FAST CASH");
        fastcash.setBounds(220, 470, 120, 25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("MINI STATEMENT");
        ministatement.setBounds(390, 470, 145, 25);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("PIN CHANGE");
        pinchange.setBounds(220, 500, 120, 25);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("BALANCE ENQUIRY");
        balanceenquiry.setBounds(390, 500, 145, 25);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit = new JButton("EXIT");
        exit.setBounds(390, 530, 145, 25);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource() == cashwithdraw){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource() == balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource() == ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transactions("");
    }
}