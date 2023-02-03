package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Pinchange extends JFrame implements ActionListener {

    String pinnumber;
    JLabel text, pintext, repintext;
    JPasswordField pin, repin;
    JButton change, back;

    Pinchange(String pinnumber) {
        setLayout(null);
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(0, 0, 900, 900);
        add(l11);

        text = new JLabel("Change your pin");
        text.setBounds(250, 280, 500, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.white);
        l11.add(text);

        pintext = new JLabel("New pin: ");
        pintext.setBounds(165, 320, 180, 25);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setForeground(Color.white);
        l11.add(pintext);

        pin = new JPasswordField();
        pin.setBounds(330, 320, 180, 25);
        pin.setFont(new Font("Raleway", Font.BOLD, 14));
        l11.add(pin);

        repintext = new JLabel("Re-Enter New pin: ");
        repintext.setBounds(165, 360, 180, 25);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setForeground(Color.white);
        l11.add(repintext);

        repin = new JPasswordField();
        repin.setBounds(330, 360, 180, 25);
        repin.setFont(new Font("Raleway", Font.BOLD, 14));
        l11.add(repin);

        change = new JButton("Change");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        l11.add(change);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        l11.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {

            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered pin does not match");
                    return;
                }

                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter new pin");
                    return;
                }

                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter new pin");
                    return;
                }

                Conn c1 = new Conn();
                String q1 = "update bank set pin = '" + rpin + "' where pin = '" + pinnumber + "' ";
                String q2 = "update login set pinnumber = '" + rpin + "' where pinnumber = '" + pinnumber + "' ";
                String q3 = "update signupthree set pinnumber = '" + rpin + "' where pinnumber = '" + pinnumber + "' ";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "Pin changed successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Pinchange("").setVisible(true);
    }
}
