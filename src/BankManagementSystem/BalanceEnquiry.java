package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceEnquiry extends JFrame implements ActionListener {

    ImageIcon icon, icon1;
    JLabel image,text;
    JButton Back;
    String pinnumber;

    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;

        icon = new ImageIcon("E:/Bank Management System/Bank Management System/src/BankManagementSystem/ATM1.jpg");
        Image i = icon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        icon1 = new ImageIcon(i);
        image = new JLabel(icon1);
        image.setBounds(0, 0, 800, 800);
        add(image);

        Back = new JButton("BACK");
        Back.setBounds(350, 506, 100, 21);
        Back.setForeground(Color.white);
        Back.setBackground(Color.BLACK);
        Back.setFont(new Font("System", Font.BOLD, 15));
        Back.addActionListener(this);
        image.add(Back);

        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        Connect conn = new Connect();
        int balance = 0;
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where pin ='" + pinnumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        text = new JLabel("YOUR CURRENT BALANCE IS  RS "+balance);
        text.setBounds(210,405,250,40);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,13));
        image.add(text);

    }
    @Override
    public void actionPerformed (ActionEvent e){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
}
