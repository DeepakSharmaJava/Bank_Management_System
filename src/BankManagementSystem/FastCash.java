package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel imageLabel,heading;
    ImageIcon icon,icon1;
    JButton Deposit,withdrawal,Fastcash,ministatement,pinchange,BalanceEnquiry,Exit;
    String pinnumber;

    public FastCash(String pinnumber) {
        this.pinnumber =pinnumber;
        setLayout(null);

        icon = new ImageIcon("D:/ATM1.jpg");
        Image image =icon.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        icon1 =new ImageIcon(image);

        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);

        imageLabel = new JLabel(icon1);
        imageLabel.setBounds(0, 0, 800, 800);
        add(imageLabel);

        heading = new JLabel("PLEASE SELECT YOUR AMOUNT");
        heading.setBounds(220,390,250,20);
        heading.setForeground(Color.white);
        heading.setFont(new Font("System",Font.BOLD,13));
        imageLabel.add(heading);

        Deposit = new JButton("RS 100");
        Deposit.setBounds(205,442,130,18);
        Deposit.setForeground(Color.white);
        Deposit.setBackground(Color.BLACK);
        Deposit.setFont(new Font("System",Font.BOLD,13));
        Deposit.addActionListener(this);
        imageLabel.add(Deposit);

        withdrawal = new JButton("RS 200");
        withdrawal.setBounds(350,442,130,18);
        withdrawal.setForeground(Color.white);
        withdrawal.setBackground(Color.BLACK);
        withdrawal.setFont(new Font("System",Font.BOLD,13));
        withdrawal.addActionListener(this);
        imageLabel.add(withdrawal);

        Fastcash = new JButton("RS 500");
        Fastcash.setBounds(205,464,130,18);
        Fastcash.setForeground(Color.white);
        Fastcash.setBackground(Color.BLACK);
        Fastcash.setFont(new Font("System",Font.BOLD,13));
        Fastcash.addActionListener(this);
        imageLabel.add(Fastcash);

        ministatement = new JButton("RS 1000");
        ministatement.setBounds(350,464,130,18);
        ministatement.setForeground(Color.white);
        ministatement.setBackground(Color.BLACK);
        ministatement.setFont(new Font("System",Font.BOLD,13));
        ministatement.addActionListener(this);
        imageLabel.add(ministatement);

        pinchange = new JButton("RS 5000");
        pinchange.setBounds(205,486,130,18);
        pinchange.setForeground(Color.white);
        pinchange.setBackground(Color.BLACK);
        pinchange.setFont(new Font("System",Font.BOLD,13));
        pinchange.addActionListener(this);
        imageLabel.add(pinchange);

        BalanceEnquiry = new JButton("RS 10000");
        BalanceEnquiry.setBounds(350,486,130,18);
        BalanceEnquiry.setForeground(Color.white);
        BalanceEnquiry.setBackground(Color.BLACK);
        BalanceEnquiry.setFont(new Font("System",Font.BOLD,13));
        BalanceEnquiry.addActionListener(this);
        imageLabel.add(BalanceEnquiry);

        Exit = new JButton("BACK");
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
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else {
           String amount = ((JButton)e.getSource()).getText().substring(3);
           Connect conn = new Connect();
           try {
               ResultSet rs = conn.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
               int balance =0;
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance += Integer.parseInt(rs.getString("amount"));
                   }else {
                       balance -= Integer.parseInt(rs.getString("amount"));
                   }
               }
               if(e.getSource() != Exit && balance < Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"insufficient Balance");
                   return;
               }
               Date date = new Date();
               String query = "insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+amount+"')";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"RS "+amount+" Debited successfully");
               setVisible(false);
               new Transaction(pinnumber).setVisible(true);

           }catch (Exception e2){
               System.out.println(e);
           }

        }
    }
}
