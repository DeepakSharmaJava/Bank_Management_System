package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

    JLabel imageLabel,heading;
    ImageIcon icon,icon1;
    JButton Deposit,withdrawal,Fastcash,ministatement,pinchange,BalanceEnquiry,Exit;
    String pinnumber;

    public Transaction(String pinnumber) {
        this.pinnumber =pinnumber;
        setLayout(null);

        icon = new ImageIcon("E:/Bank Management System/Bank Management System/src/BankManagementSystem/ATM1.jpg");
        Image image =icon.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        icon1 =new ImageIcon(image);

        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);

        imageLabel = new JLabel(icon1);
        imageLabel.setBounds(0, 0, 800, 800);
        add(imageLabel);

        heading = new JLabel("PLEASE SELECT YOUR TRANSACTION");
        heading.setBounds(220,390,250,20);
        heading.setForeground(Color.white);
        heading.setFont(new Font("System",Font.BOLD,13));
        imageLabel.add(heading);

        Deposit = new JButton("DEPOSIT");
        Deposit.setBounds(205,442,130,18);
        Deposit.setForeground(Color.white);
        Deposit.setBackground(Color.BLACK);
        Deposit.setFont(new Font("System",Font.BOLD,13));
        Deposit.addActionListener(this);
        imageLabel.add(Deposit);

        withdrawal = new JButton("WITHDRAWAL");
        withdrawal.setBounds(350,442,130,18);
        withdrawal.setForeground(Color.white);
        withdrawal.setBackground(Color.BLACK);
        withdrawal.setFont(new Font("System",Font.BOLD,13));
        withdrawal.addActionListener(this);
        imageLabel.add(withdrawal);

        Fastcash = new JButton("FAST CASH");
        Fastcash.setBounds(205,464,130,18);
        Fastcash.setForeground(Color.white);
        Fastcash.setBackground(Color.BLACK);
        Fastcash.setFont(new Font("System",Font.BOLD,13));
        Fastcash.addActionListener(this);
        imageLabel.add(Fastcash);

        ministatement = new JButton("MINI STATEMENT");
        ministatement.setBounds(350,464,130,18);
        ministatement.setForeground(Color.white);
        ministatement.setBackground(Color.BLACK);
        ministatement.setFont(new Font("System",Font.BOLD,11));
        ministatement.addActionListener(this);
        imageLabel.add(ministatement);

        pinchange = new JButton("PIN CHANGE");
        pinchange.setBounds(205,486,130,18);
        pinchange.setForeground(Color.white);
        pinchange.setBackground(Color.BLACK);
        pinchange.setFont(new Font("System",Font.BOLD,13));
        pinchange.addActionListener(this);
        imageLabel.add(pinchange);

        BalanceEnquiry = new JButton("BALANCE ENQUIRY");
        BalanceEnquiry.setBounds(350,486,130,18);
        BalanceEnquiry.setForeground(Color.white);
        BalanceEnquiry.setBackground(Color.BLACK);
        BalanceEnquiry.setFont(new Font("System",Font.BOLD,9));
        BalanceEnquiry.addActionListener(this);
        imageLabel.add(BalanceEnquiry);

        Exit = new JButton("EXIT");
        Exit.setBounds(350,506,130,18);
        Exit.setForeground(Color.white);
        Exit.setBackground(Color.BLACK);
        Exit.setFont(new Font("System",Font.BOLD,15));
        Exit.addActionListener(this);
        imageLabel.add(Exit);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Exit){
            System.exit(0);
        } else if (e.getSource()==Deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (e.getSource()==withdrawal) {
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        } else if (e.getSource()==Fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (e.getSource()==pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (e.getSource()==BalanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (e.getSource()==ministatement) {
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
}
