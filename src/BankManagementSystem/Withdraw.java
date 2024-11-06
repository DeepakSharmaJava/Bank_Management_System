package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {

    ImageIcon icon,icon1;
    JLabel image,heading;
    JTextField withdrawField;
    JButton withdraw,Back;
    String pinnumber;

    Withdraw(String pinnumber){

        this.pinnumber=pinnumber;

        icon = new ImageIcon("D:/ATM1.jpg");
        Image i = icon.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        icon1 = new ImageIcon(i);

        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);

        image = new JLabel(icon1);
        image.setBounds(0,0,800,800);
        add(image);

        heading = new JLabel("ENTER THE AMOUNT YOU WANT TO WITHDRAW ");
        heading.setBounds(220,405,250,20);
        heading.setForeground(Color.white);
        heading.setFont(new Font("System",Font.BOLD,11));
        image.add(heading);

        withdrawField = new JTextField();
        withdrawField.setBounds(222,440,240,25);
        withdrawField.setFont(new Font("System",Font.BOLD,13));
        image.add(withdrawField);

        withdraw = new JButton("WITHDRAW");
        withdraw.setBounds(360,492,100,24);
        withdraw.setBackground(Color.BLACK);
        withdraw.addActionListener(this);
        withdraw.setForeground(Color.WHITE);
        withdraw.setFont(new Font("System",Font.BOLD,11));
        image.add(withdraw);

        Back = new JButton("BACK");
        Back.setBounds(227,492,100,24);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        Back.setFont(new Font("System",Font.BOLD,13));
        image.add(Back);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==withdraw){
            String withdraww =withdrawField.getText();
            Date date = new Date();
            if(withdraww.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount to deposit");
            }else{
                Connect conn = new Connect();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+withdraww+"')";
                try {
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+withdraww+" Withdrawed Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

        } else if (e.getSource()==Back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
}
