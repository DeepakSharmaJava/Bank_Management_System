package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JLabel imageLabel,heading,pinText,RepinText;
    JTextField pinField,repinField;
    JButton change , back;
    String pinnumber;

    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);


        ImageIcon icon = new ImageIcon("D:/ATM1.jpg");
        Image i =icon.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(i);
        imageLabel = new JLabel(icon2);
        imageLabel.setBounds(0,0,800,800);
        add(imageLabel);

        heading = new JLabel("CHANGE YOUR PIN");
        heading.setBounds(280,371,250,20);
        heading.setForeground(Color.white);
        heading.setFont(new Font("System",Font.BOLD,13));
        imageLabel.add(heading);

        pinText = new JLabel("NEW PIN");
        pinText.setBounds(230,400,150,20);
        pinText.setForeground(Color.white);
        pinText.setFont(new Font("System",Font.BOLD,13));
        imageLabel.add(pinText);

        RepinText = new JLabel("Re-ENTER NEW PIN");
        RepinText.setBounds(230,450,150,20);
        RepinText.setForeground(Color.white);
        RepinText.setFont(new Font("System",Font.BOLD,13));
        imageLabel.add(RepinText);

        pinField = new JTextField();
        pinField.setBounds(230,420,150,20);
        //pinField.setForeground(Color.white);
        pinField.setFont(new Font("System",Font.BOLD,13));
        imageLabel.add(pinField);

        repinField= new JTextField();
        repinField.setBounds(230,470,150,20);
        //repinField.setForeground(Color.BLACK);
        repinField.setFont(new Font("System",Font.BOLD,13));
        imageLabel.add(repinField);

        change = new JButton("CHANGE");
        change.setBounds(235,505,100,17);
        change.setForeground(Color.black);
        change.addActionListener(this);
        change.setBackground(Color.white);
        change.setFont(new Font("System",Font.BOLD,13));
        imageLabel.add(change);

        back = new JButton("BACK");
        back.setBounds(365,505,80,17);
        back.setForeground(Color.black);
        back.addActionListener(this);
        back.setBackground(Color.white);
        back.setFont(new Font("System",Font.BOLD,13));
        imageLabel.add(back);


        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==change) {
            try {

                String npin = pinField.getText();
                String rpin = repinField.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }
                Connect conn =new Connect();
                String query1 = "update bank set pin ='"+rpin+"' where pin='"+pinnumber+"'";
                String query2 = "update login set pin_number ='"+rpin+"' where pin_number='"+pinnumber+"'";
                String query3 = "update signupthere set pin_number ='"+rpin+"' where pin_number='"+pinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");

                setVisible(false);
                new Transaction(rpin).setVisible(true);

            } catch (Exception e3) {
                System.out.println(e3);
            }

        }else {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
}

