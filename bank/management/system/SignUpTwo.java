package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener {

    JLabel additionaldetails, religion1, catagory1, income1, education1, qualification, occupation1, pan, aadhar, senior, existing;
    JTextField panTextField, aadharTextField;
    JRadioButton syes, sno, eyes, eno;
    JButton next;
    JComboBox religion, catagory, income, occupation, education;
    String formno;

    SignUpTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION - PAGE 2");

        additionaldetails = new JLabel("Page 2: Additional Details: ");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionaldetails.setBounds(290, 80, 400, 30);
        add(additionaldetails);

        religion1 = new JLabel("Religion: ");
        religion1.setFont(new Font("Raleway", Font.BOLD, 20));
        religion1.setBounds(100, 140, 100, 30);
        add(religion1);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);

        catagory1 = new JLabel("Catagory: ");
        catagory1.setFont(new Font("Raleway", Font.BOLD, 20));
        catagory1.setBounds(100, 190, 200, 30);
        add(catagory1);

        String valcatagory[] = {"General", "OBC", "SC", "ST", "Other"};
        catagory = new JComboBox(valcatagory);
        catagory.setBackground(Color.white);
        catagory.setBounds(300, 190, 400, 30);
        add(catagory);

        income1 = new JLabel("Income: ");
        income1.setFont(new Font("Raleway", Font.BOLD, 20));
        income1.setBounds(100, 240, 200, 30);
        add(income1);

        String incomecatagory[] = {"NULL", "<1,50,000", "<2,50,000", "<5,00,00", "upto 10,00,000"};
        income = new JComboBox(incomecatagory);
        income.setBackground(Color.white);
        income.setBounds(300, 240, 400, 30);
        add(income);

        education1 = new JLabel("Educational ");
        education1.setFont(new Font("Raleway", Font.BOLD, 20));
        education1.setBounds(100, 290, 200, 30);
        add(education1);

        qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 330, 200, 30);
        add(qualification);

        String educationvalues[] = {"Non-Graduate", "Graduation", "Post-Graduation", "Doctrate", "Other"};
        education = new JComboBox(educationvalues);
        education.setBackground(Color.white);
        education.setBounds(300, 315, 400, 30);
        add(education);

        occupation1 = new JLabel("Occupation: ");
        occupation1.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation1.setBounds(100, 390, 200, 30);
        add(occupation1);

        String occupationalvalues[] = {"Salaried", "self Employeed", "Businessman", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationalvalues);
        occupation.setBackground(Color.white);
        occupation.setBounds(300, 390, 400, 30);
        add(occupation);

        pan = new JLabel("PAN No: ");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);

        aadhar = new JLabel("AADHAR NO: ");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 490, 200, 30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);

        senior = new JLabel("Senior citizen: ");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 540, 200, 30);
        add(senior);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.white);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup smartialgroup = new ButtonGroup();
        smartialgroup.add(syes);
        smartialgroup.add(sno);

        existing = new JLabel("Existing account: ");
        existing.setFont(new Font("Raleway", Font.BOLD, 20));
        existing.setBounds(100, 590, 200, 30);
        add(existing);

        eyes = new JRadioButton("Yes");
        eyes.setBackground(Color.white);
        eyes.setBounds(300, 590, 100, 30);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBackground(Color.white);
        eno.setBounds(450, 590, 100, 30);
        add(eno);

        ButtonGroup emartialgroup = new ButtonGroup();
        emartialgroup.add(eyes);
        emartialgroup.add(eno);

        next = new JButton("Next");
        next.setForeground(Color.white);
        next.setBackground(Color.black);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(500, 120);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String religion1 = (String) religion.getSelectedItem();
        String catagory1 = (String) catagory.getSelectedItem();
        String income1 = (String) income.getSelectedItem();
        String education1 = (String) education.getSelectedItem();
        String occupation1 = (String) occupation.getSelectedItem();

        String senior = null;
        if (syes.isSelected()) {
            senior = "Yes";
        } else if (sno.isSelected()) {
            senior = "No";
        }

        String existing = null;
        if (eyes.isSelected()) {
            existing = "Yes";
        } else if (eno.isSelected()) {
            existing = "No";
        }

        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();

        try {
            Conn c1 = new Conn();
            String q1 = "insert into signuptwo values('" + formno + "','" + religion1 + "','" + catagory1 + "','" + income1 + "','" + education1 + "','" + occupation1 + "','" + pan + "','" + aadhar + "','" + senior + "','" + existing + "')";
            c1.s.executeUpdate(q1);

            setVisible(false);
            new SignUpThree(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String args[]) {
        new SignUpTwo("");
    }
}
