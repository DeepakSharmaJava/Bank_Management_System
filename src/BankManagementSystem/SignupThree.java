package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    JLabel heading = new JLabel("PAGE 3:ACCOUNT DETAILS");
    JLabel type = new JLabel("ACCOUNT TYPE : ");
    JLabel card = new JLabel("CARD NUMBER");
    JLabel cardNo =new JLabel("XXXX-XXXX-XXXX-5846");
    JLabel pin = new JLabel("PIN NUMBER");
    JLabel pinNO =new JLabel("XXXX");
    JLabel detail1 = new JLabel("your 16-digit card number");
    JLabel detail2 =new JLabel("your 4-digit pin number");
    JLabel service =new JLabel("SERVICES REQUIRED");

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formno;
    JButton cancel,submit;

    SignupThree(String formno){
        this.formno=formno;
        heading.setFont(new Font("Raleway",Font.BOLD,22));
        heading.setBounds(170,40,400,40);
        add(heading);

        type.setFont(new Font("Ariel",Font.BOLD,20));
        type.setBounds(80,140,200,30);
        add(type);

        card.setFont(new Font("Ariel",Font.BOLD,20));
        card.setBounds(80,280,200,30);
        add(card);

        pin.setFont(new Font("Ariel",Font.BOLD,20));
        pin.setBounds(80,330,250,30);
        add(pin);

        pinNO.setFont(new Font("Ariel",Font.BOLD,20));
        pinNO.setBounds(330,330,200,30);
        add(pinNO);

        cardNo.setFont(new Font("Ariel",Font.BOLD,20));
        cardNo.setBounds(330,280,250,30);
        add(cardNo);

        detail1.setFont(new Font("Ariel",Font.BOLD,11));
        detail1.setBounds(80,307,250,15);
        add(detail1);

        detail2.setFont(new Font("Ariel",Font.BOLD,11));
        detail2.setBounds(80,357,250,15);
        add(detail2);

        service.setFont(new Font("Ariel",Font.BOLD,15));
        service.setBounds(80,405,250,18);
        add(service);


        r1 = new JRadioButton("SAVING ACCOUNT");
        r1.setFont(new Font("Ariel", Font.BOLD, 11));
        r1.setBackground(Color.white);
        r1.setBounds(80, 180, 150, 25);
        add(r1);

        r3 = new JRadioButton("FIXED DEPOSIT ACCOUNT");
        r3.setFont(new Font("Ariel",Font.BOLD,11));
        r3.setBackground(Color.white);
        r3.setBounds(330,180,200,25);
        add(r3);

        r2 = new JRadioButton("CURRENT ACCOUNT");
        r2.setFont(new Font("Ariel",Font.BOLD,11));
        r2.setBackground(Color.white);
        r2.setBounds(80,215,150,25);
        add(r2);

        r4 = new JRadioButton("RECURRING DEPOSIT ACCOUNT");
        r4.setFont(new Font("Ariel",Font.BOLD,11));
        r4.setBackground(Color.white);
        r4.setBounds(330,215,210,25);
        add(r4);

        ButtonGroup account = new ButtonGroup();
        account.add(r1);
        account.add(r2);
        account.add(r3);
        account.add(r4);

        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Ariel",Font.BOLD,16));
        c1.setBounds(80,430,150,25);
        add(c1);

        c2=new JCheckBox("INTERNET BANKING");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Ariel",Font.BOLD,16));
        c2.setBounds(330,430,200,25);
        add(c2);

        c3=new JCheckBox("MOBILE BANKING");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Ariel",Font.BOLD,16));
        c3.setBounds(80,465,150,25);
        add(c3);

        c4=new JCheckBox("EMAIL & SMS ALERTS");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Ariel",Font.BOLD,16));
        c4.setBounds(330,465,150,25);
        add(c4);

        c5=new JCheckBox("CHEQUE BOOK");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Ariel",Font.BOLD,16));
        c5.setBounds(80,500,150,25);
        add(c5);

        c6=new JCheckBox("E- STATEMENT");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Ariel",Font.BOLD,16));
        c6.setBounds(330,500,150,25);
        add(c6);

        c7=new JCheckBox("I HEARBY DECLARE THAT THE ABOVE ENTERED DETAILS ARE CORRECT TO THE BEST OF MY KNOWLEDGE");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Ariel",Font.BOLD,8));
        c7.setBounds(80,560,550,18);
        add(c7);

        submit=new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Ariel",Font.BOLD,20));
        submit.setBounds(380,650,120,30);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Ariel",Font.BOLD,20));
        cancel.setBounds(110,650,120,30);
        cancel.addActionListener(this);
        add(cancel);



        setSize(650,820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String accountType=null;
            if(r1.isSelected()){
                accountType="SAVING ACCOUNT";
            } else if (r2.isSelected()) {
                accountType="CURRENT ACCOUNT";
            } else if (r3.isSelected()) {
                accountType="FIXED DEPOSIT ACCOUNT";
            } else if (r4.isSelected()) {
                accountType="RECURRING DEPOSIT ACCOUNT";
            }

            Random rand = new Random();
            String cardnumber =""+Math.abs((rand.nextLong() % 90000000L) +504093600000000L);

            String pinnumber =""+Math.abs((rand.nextLong()%9000L)+1000L);

            String facility ="";
            if(c1.isSelected()){
                facility=facility+"ATM CARD";
            } else if (c2.isSelected()) {
                facility=facility+"INTERNET BANKING";
            }else if (c3.isSelected()) {
                facility=facility+"MOBILE BANKING";
            }else if (c4.isSelected()) {
                facility=facility+"EMAIL & SMS ALERTS";
            }else if (c5.isSelected()) {
                facility=facility+"CHEQUE BOOK";
            }else if (c6.isSelected()) {
                facility=facility+"E -STATEMENT";
            }

            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"ACCOUNT TYPE IS REQURIED");
                }else{
                    Connect conn =new Connect();
                    String query ="insert into Signupthere values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query1 ="insert into Login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";

                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query1);

                    JOptionPane.showMessageDialog(null,"Card Number:"+cardnumber+"\n Pin Number:"+pinnumber);

                }
                {
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }


            }catch (Exception eee){
                System.out.println(eee);
            }

        } else if (e.getSource()==cancel) {
            setVisible(false);
            new Login().setVisible(true);

        }
    }
}
