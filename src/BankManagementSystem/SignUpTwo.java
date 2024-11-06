package BankManagementSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

    public class SignUpTwo extends JFrame implements ActionListener {

        JLabel Additionaldetail = new JLabel();
        JLabel Religion = new JLabel();
        JLabel Category = new JLabel();
        JLabel Income = new JLabel();
        JLabel Education = new JLabel();
        JLabel Qualification = new JLabel();
        JLabel Occopation = new JLabel();
        JLabel PanNo = new JLabel();
        JLabel Aadhar = new JLabel();
        JLabel SeniorCitizen = new JLabel();
        JLabel ExistingAccount = new JLabel();


        Random ran;
        long random;
        JDateChooser dateChooser;
        JTextField panTextField , AadharTextField;
        JRadioButton yes,no, YES, NO;
        JComboBox religionBox,CategoryBox,IncomeBox,EducationBox,OccopationBox;
        String formno;

        JButton next = new JButton("Next");

        SignUpTwo(String formno) {

            this.formno=formno;
            Additionaldetail.setText("Page 2: ADDITIONAL DETAILS");
            Additionaldetail.setBounds(180, 90, 350, 30);
            Additionaldetail.setFont(new Font("Ariel", Font.BOLD, 21));

            Religion.setText("RELIGION :");
            Religion.setBounds(50, 160, 150, 25);
            Religion.setFont(new Font("Ariel", Font.BOLD, 20));

            String val[]= {"HINDU","MUSLIM","SIKH","CHRISTIAN","OTHERS"};
            religionBox = new JComboBox(val);
            religionBox.setFont(new Font("Ariel", Font.BOLD, 16));
            religionBox.setBounds(300,160,300,25);

            Category.setText("CAGTEGORY :");
            Category.setBounds(50, 210, 200, 25);
            Category.setFont(new Font("Ariel", Font.BOLD, 20));

            String val1[]= {"GENERAL","OBC","ST","SC","OTHERS"};
            CategoryBox = new JComboBox(val1);
            CategoryBox.setFont(new Font("Ariel", Font.BOLD, 16));
            CategoryBox.setBounds(300,210,300,25);

            Income.setText("INCOME :");
            Income.setBounds(50, 260, 200, 25);
            Income.setFont(new Font("Ariel", Font.BOLD, 20));

            String val2[]= {"NULL","< 100000","< 250000","<500000 ","UPTO 100000"};
            IncomeBox = new JComboBox(val2);
            IncomeBox.setFont(new Font("Ariel", Font.BOLD, 16));
            IncomeBox.setBounds(300, 260, 300, 25);

            Education.setText("EDUCATIONAL");
            Education.setBounds(50, 320, 200, 25);
            Education.setFont(new Font("Ariel", Font.BOLD, 20));

            String val3[]= {"NON GRADUATED","GRADUATED","POST GRADUATED","DOCT","OTHERS"};
            EducationBox = new JComboBox(val3);
            EducationBox.setFont(new Font("Ariel", Font.BOLD, 16));
            EducationBox.setBounds(300,328,300,25);

            Qualification.setText("QUALIFICATION :");
            Qualification.setBounds(50, 345, 200, 25);
            Qualification.setFont(new Font("Ariel", Font.BOLD, 20));

            Occopation.setText("OCCOPATION :");
            Occopation.setBounds(50, 410, 200, 25);
            Occopation.setFont(new Font("Ariel", Font.BOLD, 20));

            String val4[]= {"STUDENT","BUSINESS","SELF EMPLOYED","SALARRIED","OTHERS"};
            OccopationBox = new JComboBox(val4);
            OccopationBox.setFont(new Font("Ariel", Font.BOLD, 16));
            OccopationBox.setBounds(300,410,300,25);


            PanNo.setText("PAN NUMBER:");
            PanNo.setBounds(50, 460, 200, 25);
            PanNo.setFont(new Font("Ariel", Font.BOLD, 20));

            panTextField = new JTextField();
            panTextField.setFont(new Font("Ariel", Font.BOLD, 16));
            panTextField.setBounds(300, 460, 300, 25);

            Aadhar.setText("AADAHAR NO :");
            Aadhar.setBounds(50, 510, 200, 25);
            Aadhar.setFont(new Font("Ariel", Font.BOLD, 20));

            AadharTextField = new JTextField();
            AadharTextField.setFont(new Font("Ariel", Font.BOLD, 16));
            AadharTextField.setBounds(300, 510, 300, 25);

            SeniorCitizen.setText("SENIORCITIZEN :");
            SeniorCitizen.setBounds(50,560,200,25);
            SeniorCitizen.setFont(new Font("Ariel",Font.BOLD,20));

            YES = new JRadioButton("YES");
            YES.setBounds(300, 560, 100, 25);
            add(YES);

            NO = new JRadioButton("NO");
            NO.setBounds(400, 560, 100, 25);
            add(NO);

            ButtonGroup SeniorGroup = new ButtonGroup();
            SeniorGroup.add(YES);
            SeniorGroup.add(NO);

            ExistingAccount.setText("EXISTING ACCOUNT:");
            ExistingAccount.setBounds(50,610,250,25);
            ExistingAccount.setFont(new Font("Ariel",Font.BOLD,20));

            yes = new JRadioButton("YES");
            yes.setBounds(300, 610, 100, 25);
            add(yes);

            no = new JRadioButton("NO");
            no.setBounds(400, 610, 100, 25);
            add(no);

            ButtonGroup ExistingGroup = new ButtonGroup();
            ExistingGroup.add(yes);
            ExistingGroup.add(no);


            next.setBackground(Color.BLACK);
            next.setForeground(Color.WHITE);
            next.addActionListener(this);
            next.setBounds(580, 680, 100, 50);

            setTitle("ACCOUNT OPENING:FORM NO. 2");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(750, 800);
            setLocationRelativeTo(null);
            setLayout(null);

            add(Additionaldetail);
            add(Religion);
            add(Education);
            add(Qualification);
            add(Category);
            add(Occopation);
            add(Income);
            add(PanNo);
            add(Aadhar);
            add(SeniorCitizen);
            add(ExistingAccount);
            add(AadharTextField);
            add(panTextField);
            add(religionBox);
            add(CategoryBox);
            add(IncomeBox);
            add(EducationBox);
            add(OccopationBox);
            add(next);



            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String formno = "" +random;
            String sreligion =(String)religionBox.getSelectedItem();
            String scategory =(String)CategoryBox.getSelectedItem();
            String sincome = (String)IncomeBox.getSelectedItem();
            String seducation =(String)EducationBox.getSelectedItem();
            String occopation=(String)OccopationBox.getSelectedItem();
            String seniorC =null;
            if(YES.isSelected()){
                seniorC ="YES";
            } else if (NO.isSelected()) {
                seniorC="NO";
            }
            String sExistion =null;
            if(yes.isSelected()){
                sExistion ="YES";
            } else if (no.isSelected()) {
                sExistion = "NO";
            }
            String AAdhar =AadharTextField.getText();
            String panNO =panTextField.getText();
            try {
                Connect c = new Connect();
                String query = "INSERT INTO signupTwo VALUES('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + seniorC + "','" + sExistion + "','" + AAdhar + "','" + panNO +"','"+occopation+"')";

                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }catch (Exception eee){
                System.out.println(eee);
            }
        }
    }

