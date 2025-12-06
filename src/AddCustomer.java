
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener {
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JComboBox<String> c1;
    JRadioButton r1, r2;
    JButton b1, b2;
    ImageIcon male;
    ImageIcon female;

    AddCustomer(String username) {

        setTitle("Add Customer Details . . .");
        setLayout(null);// by default border Layout
        getContentPane().setBackground(Color.black);
        setBounds(570, 220, 720, 560);

        JLabel l1 = new JLabel("Username :");
        l1.setBounds(30, 50, 160, 25);
        l1.setForeground(Color.PINK);
        l1.setFont(new Font("Tamoha", Font.BOLD, 15));
        add(l1);

        t1 = new JTextField();
        t1.setBounds(170, 50, 200, 25);
        t1.setFont(new Font("Tamoha", Font.BOLD, 15));
        add(t1);

        JLabel l2 = new JLabel("ID :");
        l2.setFont(new Font("Tamoha", Font.BOLD, 15));
        l2.setForeground(Color.PINK);
        l2.setBounds(30, 95, 100, 25);
        add(l2);

        // String[] s = {"Passport","Aadhar Card","Rasan Card","Pan Card"};
        c1 = new JComboBox<String>(new String[] { "Passport", "Aadhar Card", "Rasan Card", "Pan Card" });
        c1.setBounds(170, 95, 200, 25);
        add(c1);

        JLabel l3 = new JLabel("Number :");
        l3.setBounds(30, 140, 100, 25);
        l3.setFont(new Font("Tamoha", Font.BOLD, 15));
        l3.setForeground(Color.PINK);
        add(l3);

        t2 = new JTextField();
        t2.setBounds(170, 140, 200, 25);
        t2.setFont(new Font("Tamoha", Font.BOLD, 15));
        add(t2);

        JLabel l4 = new JLabel("Name :");
        l4.setBounds(30, 185, 100, 25);
        l4.setFont(new Font("Tamoha", Font.BOLD, 15));
        l4.setForeground(Color.PINK);
        add(l4);

        t3 = new JTextField();
        t3.setBounds(170, 185, 200, 25);
        t3.setFont(new Font("Tamoha", Font.BOLD, 15));
        add(t3);

        JLabel l5 = new JLabel("Gender :");
        l5.setBounds(30, 225, 100, 25);
        l5.setFont(new Font("Tamoha", Font.BOLD, 15));
        l5.setForeground(Color.PINK);
        add(l5);

        r1 = new JRadioButton("Male");
        r1.setBounds(170, 225, 100, 30);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(270, 225, 100, 30);
        r2.setBackground(Color.WHITE);
        add(r2);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        ImageIcon m3 = ImageLoader.loadAndScaleImage("male.png", 30, 30);
        r1.setIcon(m3);
        ImageIcon m5 = ImageLoader.loadAndScaleImage("female.png", 30, 30);
        r2.setIcon(m5);

        JLabel l6 = new JLabel("Country :");
        l6.setBounds(30, 270, 100, 25);
        l6.setFont(new Font("Tamoha", Font.BOLD, 15));
        l6.setForeground(Color.PINK);
        add(l6);

        t4 = new JTextField();
        t4.setBounds(170, 270, 200, 25);
        t4.setFont(new Font("Tamoha", Font.BOLD, 15));
        add(t4);

        JLabel l7 = new JLabel("Address :");
        l7.setBounds(30, 315, 100, 25);
        l7.setFont(new Font("Tamoha", Font.BOLD, 15));
        l7.setForeground(Color.PINK);
        add(l7);

        t5 = new JTextField();
        t5.setBounds(170, 315, 200, 25);
        t5.setFont(new Font("Tamoha", Font.BOLD, 15));
        add(t5);

        JLabel l8 = new JLabel("Phone :");
        l8.setBounds(30, 365, 100, 25);
        l8.setFont(new Font("Tamoha", Font.BOLD, 15));
        l8.setForeground(Color.PINK);
        add(l8);

        t6 = new JTextField();
        t6.setBounds(170, 365, 200, 25);
        t6.setFont(new Font("Tamoha", Font.BOLD, 15));
        add(t6);

        JLabel l9 = new JLabel("Email :");
        l9.setBounds(30, 410, 100, 25);
        l9.setFont(new Font("Tamoha", Font.BOLD, 15));
        l9.setForeground(Color.PINK);
        add(l9);

        t7 = new JTextField();
        t7.setBounds(170, 410, 200, 25);
        t7.setFont(new Font("Tamoha", Font.BOLD, 15));
        add(t7);

        b1 = new JButton("Add");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setBounds(70, 475, 100, 25);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setBounds(200, 475, 100, 25);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i3 = ImageLoader.loadAndScaleImage("newcustomer.jpg", 350, 500);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(370, 30, 350, 500);
        add(l10);

        try {
            Conns c = new Conns();
            ResultSet rs = c.stmt.executeQuery("select * from account where username = '" + username + "' ");
            while (rs.next()) {
                t1.setText(rs.getString("username"));
                t3.setText(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            Conns c = new Conns();
            String username = t1.getText().trim();
            String name = t3.getText().trim();
            String radio = null;
            if (r1.isSelected()) {
                radio = "Male";
            } else if (r2.isSelected()) {
                radio = "Female";
            }
            String email = t7.getText().trim();
            String phone = t6.getText().trim();
            String address = t5.getText().trim();

            if (username.isEmpty() || name.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill at least Username, Name and Email fields.");
                return;
            }

            String q = "INSERT INTO customer (username, name, email, phone, address, gender) VALUES ('"
                    + username + "','" + name + "','" + email + "','" + phone + "','" + address + "','" + radio
                    + "')";
            try {
                c.stmt.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                this.setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to add customer: " + e.getMessage());
            }

        } else if (ae.getSource() == b2) {
            this.setVisible(false);

        }

    }

}
