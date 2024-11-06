package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MiniStatement extends JFrame {
    JLabel mini;
    String pinnumber;
    MiniStatement(String pinnumber) {
        this.pinnumber=pinnumber;
        setTitle("MINI STATEMENT");
        setSize(400,600);
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150,150,400,600);
        setVisible(true);

        mini= new JLabel();
        add(mini);

        JLabel bank = new JLabel("CRYO BANK");
        bank.setBounds(160,30,100,30);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,60,200,30);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        Connect conn = new Connect();
        int bal =0;
        try {
            String query = "select * from login where pin_number='"+pinnumber+"'";
            ResultSet re =conn.s.executeQuery(query);

            while (re.next()){
                card.setText("Card Number :"+re.getString("card_number").substring(0,4)+"XXXXXXXX"+re.getString("card_number").substring(11));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            Connect connn = new Connect();
            ResultSet rs = connn.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
            while (rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("YOUR CURRENT ACCOUNT BALLANCE IS: "+bal);
        }catch (Exception e){
            System.out.println(e);
        }
        mini.setBounds(20,100,400,200);
    }

}
