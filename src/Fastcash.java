package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Fastcash extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, exit;
    String pinnumber;

    Fastcash(String pinnumber) {
        setLayout(null);
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(0, 0, 900, 900);
        add(l11);

        JLabel text = new JLabel("Select withdrawl amount");
        text.setBounds(210, 300, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.white);
        l11.add(text);

        b1 = new JButton("Rs 100");
        b1.setBounds(170, 415, 150, 30);
        b1.addActionListener(this);
        l11.add(b1);

        b2 = new JButton("Rs 500");
        b2.setBounds(355, 415, 150, 30);
        b2.addActionListener(this);
        l11.add(b2);

        b3 = new JButton("Rs 1000");
        b3.setBounds(170, 450, 150, 30);
        b3.addActionListener(this);
        l11.add(b3);

        b4 = new JButton("Rs 2000");
        b4.setBounds(355, 450, 150, 30);
        b4.addActionListener(this);
        l11.add(b4);

        b5 = new JButton("Rs 5000");
        b5.setBounds(170, 485, 150, 30);
        b5.addActionListener(this);
        l11.add(b5);

        b6 = new JButton("Rs 10000");
        b6.setBounds(355, 485, 150, 30);
        b6.addActionListener(this);
        l11.add(b6);

        exit = new JButton("Back");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        l11.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin= '" + pinnumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, " Insufficient balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'Withdraw', '" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Deposited Sucessfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String args[]) {
        new Fastcash("");
    }
}
