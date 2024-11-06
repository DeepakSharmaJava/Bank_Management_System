package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel welcomeLabel = new JLabel("WELCOME TO", SwingConstants.CENTER);
    JLabel cryoBankLabel = new JLabel("CRYO BANK ATM", SwingConstants.CENTER);  // Separate label for CRYO BANK text
    JLabel imageLabel = new JLabel(); // Label for the image only
    JLabel cardNo = new JLabel("CARD NO: ",SwingConstants.CENTER);
    JLabel PIN = new JLabel("PIN: ");

    JTextField cardTextField = new JTextField();
    JTextField PinTextField = new JPasswordField();

    JButton Signup = new JButton("SIGN UP");
    JButton login = new JButton("LOGIN");
    JButton clear = new JButton("CLEAR");

    Login() {
        // Load the image
        ImageIcon originalImageIcon = new ImageIcon("E:/Bank Management System/Bank Management System/src/BankManagementSystem/bank image.png");
        Image scaledImage = originalImageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Adjust width and height as needed
        ImageIcon resizedImageIcon = new ImageIcon(scaledImage);

        // Set up the image label
        imageLabel.setIcon(resizedImageIcon);

        // Configure the "WELCOME" label
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Font for WELCOME text

        // Configure the "CRYO BANK" label
        cryoBankLabel.setFont(new Font("Arial", Font.BOLD, 30));

        cardNo.setFont(new Font("Arial",Font.BOLD,27));
        PIN.setFont(new Font("Arial",Font.BOLD,27));
        cardTextField.setFont(new Font("Arial",Font.BOLD,23));
        PinTextField.setFont(new Font("Arial",Font.BOLD,23));


        // Panel to hold only the image
        JPanel imagePanel = new JPanel();
        imagePanel.add(imageLabel);  // Add the imageLabel to imagePanel
        imagePanel.setSize(200, 200);  // Set preferred size for the image panel


        // Set up frame layout
        this.setTitle("Bank Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 480);
        this.setLocationRelativeTo(null);
        setLayout(null);  // Set layout to null for absolute positioning
        setResizable(false);

        // Set bounds for components
        welcomeLabel.setBounds(400, 20, 200, 40);   // Position of WELCOME label
        cryoBankLabel.setBounds(370, 70, 300, 40);  // Position of CRYO BANK label
        imagePanel.setBounds(70, 90, 200, 200);   // Position of the image panel
        cardNo.setBounds(300,180,150,45);
        PIN.setBounds(310,240,80,45);
        cardTextField.setBounds(480,190,250,30);
        PinTextField.setBounds(480,250,250,30);
        Signup.setBounds(480,370,220,30);
        Signup.setBackground(new Color(50,55,90));
        Signup.setForeground(Color.WHITE);
        login.setBounds(480,320,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        clear.setBounds(600,320,100,30);
        clear.setForeground(Color.WHITE);
        clear.setBackground(Color.BLACK);

        login.addActionListener(this);
        clear.addActionListener(this);
        Signup.addActionListener(this);

        // Add components to the frame
        add(welcomeLabel);       // Add WELCOME label at specified position
        add(cryoBankLabel);      // Add CRYO BANK label below WELCOME
        add(imagePanel);         // Add image panel at specified location
        add(cardNo);
        add(PIN);
        add(cardTextField);
        add(PinTextField);
        add(Signup);
        add(login);
        add(clear);

        // Set visibility after all components are added
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==login){
            Connect conn = new Connect();
            String cardnumber = cardTextField.getText();
            String pinnumber = PinTextField.getText();
            String query ="select * from Login where card_number ='"+cardnumber+"' and pin_number ='"+pinnumber+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"incorrect card no or pin");
                }

            }catch (Exception e1){
                System.out.println(e1);
            }
         }else if(e.getSource()==clear){
            cardTextField.setText("");
            PinTextField.setText("");

         } else if (e.getSource()==Signup) {
             //System.out.println("signup bro");
             setVisible(false);
             new SignUpOne().setVisible(true);
         }
    }

}
