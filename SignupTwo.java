package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    
    JTextField panTextField, aadharTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, income, education, occupation;
    String formno;
    
    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
       
        
        JLabel additonaldetails = new JLabel("Page 2: Additonal Details");
        additonaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additonaldetails.setBounds(290, 80, 400, 30);
        add(additonaldetails);
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christianity","Jainism","Buddhism","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        String valCategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        String valIncome[] = {"Null","< 50,000","< 65,000","< 80,000","Upto 100,000"};
        income = new JComboBox(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 315, 200, 30);
        add(email);
        
        String valEducation[] = {"Non-graduate","Graduate","Postgraduate","Doctorate","Others"};
        education = new JComboBox(valEducation);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel occupy = new JLabel("Occupation:");
        occupy.setFont(new Font("Raleway", Font.BOLD, 20));
        occupy.setBounds(100, 390, 200, 30);
        add(occupy);
        
        String valOccupation[] = {"Salaried","Self Employed","Business","Retired","Others"};
        occupation = new JComboBox(valOccupation);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
        JLabel address = new JLabel("PAN number:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);
     
        JLabel city = new JLabel("Aadhar number:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);
        
        JLabel state = new JLabel("Senior citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 70, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(400, 540, 90, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        
        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);
        
        JLabel pincode = new JLabel("Existing account:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
         
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 70, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(400, 590, 90, 30);
        sno.setBackground(Color.WHITE);
        add(eno);
        
        
        ButtonGroup existaccountgroup = new ButtonGroup();
        existaccountgroup.add(eyes);
        existaccountgroup.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.DARK_GRAY);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(600, 660, 90, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }else if(sno.isSelected()){
            seniorcitizen = "No";
        }
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        }else{
            existingaccount = "No";
        }
        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();
        
        try{
            if (span.equals("") || saadhar.equals("")){
                JOptionPane.showMessageDialog(null, "Form is Incomplete!");
            } else{
                Conn c = new Conn();
                String query = "insert into signup2 values('"+formno+"','"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"','"+soccupation+"', '"+span+"','"+saadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";  
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Form submitted succesfully!!");
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        
       
        
        
   }
    
    
    
    public static void main(String[] args) {
        new SignupTwo("");
    }
}