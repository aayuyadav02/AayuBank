package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JLabel pintext, newtext, retext;
    JPasswordField npin, rpin;
    JButton change, back;
    String pinnumber;
    
    PinChange(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        pintext = new JLabel("CHANGE YOUR PIN");
        pintext.setBounds(295, 335, 700, 35);
        pintext.setForeground(Color.BLACK);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(pintext);
        
        newtext = new JLabel("New PIN:");
        newtext.setBounds(220, 435, 700, 35);
        newtext.setForeground(Color.BLACK);
        newtext.setFont(new Font("System", Font.BOLD, 14));
        image.add(newtext);
        
        npin = new JPasswordField();
        npin.setFont(new Font("System", Font.BOLD, 25));
        npin.setBounds(360, 440, 150, 25);
        image.add(npin);
        
        retext = new JLabel("Re-Enter New PIN:");
        retext.setBounds(220, 465, 700, 35);
        retext.setForeground(Color.BLACK);
        retext.setFont(new Font("System", Font.BOLD, 14));
        image.add(retext);
        
        rpin = new JPasswordField();
        rpin.setFont(new Font("System", Font.BOLD, 25));
        rpin.setBounds(360, 470, 150, 25);
        image.add(rpin);
        
        change = new JButton("Change");
        change.setBounds(430, 500, 80, 25);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(430, 530, 80, 25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try{
                String nepin = npin.getText();
                String repin = rpin.getText();
            
                if(!nepin.equals(repin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                
                if(nepin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                
                if(repin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+repin+"' where pin = '"+pinnumber+"'";
                String query2 = "update login set pin = '"+repin+"' where pin = '"+pinnumber+"'";
                String query3 = "update signup3 set pin = '"+repin+"' where pin = '"+pinnumber+"'";
               
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");

                setVisible(false);
                new Transactions(repin).setVisible(true);

            }catch(Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    
    public static void main(String[] args) {
    
        new PinChange("").setVisible(true);
        
    }
}