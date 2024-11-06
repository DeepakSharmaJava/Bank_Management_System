package BankManagementSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class SignUpOne extends JFrame implements ActionListener {

    JLabel form = new JLabel();
    JLabel top = new JLabel();
    JLabel name = new JLabel();
    JLabel Fname = new JLabel();
    JLabel dob = new JLabel();
    JLabel gender = new JLabel();
    JLabel email = new JLabel();
    JLabel Martial = new JLabel();
    JLabel Address = new JLabel();
    JLabel city = new JLabel();
    JLabel state = new JLabel();
    JLabel pin = new JLabel();

    Random ran;
    long random;
    JDateChooser dateChooser;
    JTextField nameTextField ,FnameTextField,Email,address,State,City,Pinn;
    JRadioButton male , female , others , maried , single;

    JButton next = new JButton("Next");

    SignUpOne(){

        ran = new Random();
        random=Math.abs(ran.nextLong()%9000L)+1000;

        form.setText("APPLICATION FORM NO.: "+random);
        form.setBounds(80,30,580,40);
        form.setFont(new Font("Ariel",Font.BOLD,36));

        top.setText("Page 1: PERSONAL DETAILS");
        top.setBounds(180,90,300,30);
        top.setFont(new Font("Ariel",Font.BOLD,21));

        name.setText("NAME :");
        name.setBounds(50,160,100,25);
        name.setFont(new Font("Ariel",Font.BOLD,20));

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Ariel",Font.BOLD,16));
        nameTextField.setBounds(300,160,300,25);

        Fname.setText("FATHER'S NAME :");
        Fname.setBounds(50,210,200,25);
        Fname.setFont(new Font("Ariel",Font.BOLD,20));

        FnameTextField = new JTextField();
        FnameTextField.setFont(new Font("Ariel",Font.BOLD,16));
        FnameTextField.setBounds(300,210,300,25);

        dob.setText("DATE-OF-BIRTH :");
        dob.setBounds(50,260,200,25);
        dob.setFont(new Font("Ariel",Font.BOLD,20));

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,260,200,25);
        add(dateChooser);

        gender.setText("GENDER :");
        gender.setBounds(50,310,200,25);
        gender.setFont(new Font("Ariel",Font.BOLD,20));

        male = new JRadioButton("MALE");
        male.setBounds(300,310,100,25);
        add(male);

        female = new JRadioButton("FEMALE");
        female.setBounds(400,310,100,25);
        add(female);

        others = new JRadioButton("OTHERS");
        others.setBounds(500,310,100,25);
        add(others);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(others);

        email.setText("E-MAIL ADDERSS :");
        email.setBounds(50,360,200,25);
        email.setFont(new Font("Ariel",Font.BOLD,20));

        Email = new JTextField();
        Email.setFont(new Font("Ariel",Font.BOLD,16));
        Email.setBounds(300,360,300,25);

        Martial.setText("MARTIAL STATUS :");
        Martial.setBounds(50,410,200,25);
        Martial.setFont(new Font("Ariel",Font.BOLD,20));

        maried = new JRadioButton("MARRIED");
        maried.setBounds(300,410,100,25);
        add(maried);

        single = new JRadioButton("SINGLE");
        single.setBounds(400,410,100,25);
        add(single);

        ButtonGroup MartialGroup = new ButtonGroup();
        MartialGroup.add(maried);
        MartialGroup.add(single);

        Address.setText("ADDRESS :");
        Address.setBounds(50,460,200,25);
        Address.setFont(new Font("Ariel",Font.BOLD,20));

        address = new JTextField();
        address.setFont(new Font("Ariel",Font.BOLD,16));
        address.setBounds(300,460,300,25);

        city.setText("CITY :");
        city.setBounds(50,510,200,25);
        city.setFont(new Font("Ariel",Font.BOLD,20));

        City = new JTextField();
        City.setFont(new Font("Ariel",Font.BOLD,16));
        City.setBounds(300,510,300,25);

        state.setText("STATE :");
        state.setBounds(50,560,200,25);
        state.setFont(new Font("Ariel",Font.BOLD,20));

        State = new JTextField();
        State.setFont(new Font("Ariel",Font.BOLD,16));
        State.setBounds(300,560,300,25);

        pin.setText("PIN CODE:");
        pin.setBounds(50,610,200,25);
        pin.setFont(new Font("Ariel",Font.BOLD,20));

        Pinn = new JTextField();
        Pinn.setFont(new Font("Ariel",Font.BOLD,16));
        Pinn.setBounds(300,610,300,25);

        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        next.setBounds(580,680,100,50);

        setTitle("FORM NO. 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750,800);
        setLocationRelativeTo(null);
        setLayout(null);

        add(form);
        add(top);
        add(name);
        add(Fname);
        add(dob);
        add(gender);
        add(email);
        add(Martial);
        add(Address);
        add(city);
        add(state);
        add(nameTextField);
        add(FnameTextField);
        add(Email);
        add(address);
        add(State);
        add(City);
        add(pin);
        add(Pinn);
        add(next);


        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = FnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()) {
            gender = "MALE";
        }else if(female.isSelected()){
            gender="FEMALE";
        }else if(others.isSelected()){
            gender="others";
        }
        String email = Email.getText();
        String Martial = null;
        if(maried.isSelected()){
            Martial="MARIED";
        }else if(single.isSelected()){
            Martial="SINGLE";
        }
        String adderss = address.getText();
        String city = City.getText();
        String STATE =State.getText();
        String Pin = Pinn.getText();

        try{
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(null,"name is Required");
            }else{
                Connect c = new Connect();
                // Assuming `c` is your Connection object
                String query = "INSERT INTO signup VALUES('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + adderss + "','" + Martial + "','" + STATE + "','" + city + "','" + Pin + "')";

                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }

        }catch (Exception ee){
            System.out.println(ee);
        }
    }
}
