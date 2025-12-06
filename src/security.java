
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class security extends JFrame implements ActionListener {
	// public static void main(String[] args) {
	// new security("").setVisible(true);
	// }
	JButton b1;
	JCheckBox checkBox;

	String username;

	security(String user) {
		username = user;

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setBounds(500, 280, 570, 230);
		this.getContentPane().setBackground(Color.WHITE);

		ImageIcon xIcon = ImageLoader.loadAndScaleImage("xpng.png", 40, 40);
		ImageIcon i3 = xIcon;

		ImageIcon checkIcon = ImageLoader.loadAndScaleImage("checkmark.png", 40, 40);
		ImageIcon i5 = checkIcon;

		b1 = new JButton("Verify");
		b1.setBounds(225, 130, 110, 25);
		b1.setFont(new Font("Tahoma", Font.BOLD, 15));
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		add(b1);

		checkBox = new JCheckBox();
		checkBox.setBounds(100, 50, 350, 40);
		checkBox.setText("I'm not a robot");
		checkBox.setFocusable(false);
		checkBox.setFont(new Font("Consolas", Font.BOLD, 35));
		checkBox.setIcon(i3);
		checkBox.setSelectedIcon(i5);

		add(checkBox);

		JLabel l1 = new JLabel("Hi , " + username + "...");
		l1.setBounds(30, 150, 300, 25);
		l1.setFont(new Font("Tahoma", Font.BOLD, 15));
		l1.setForeground(Color.BLACK);
		add(l1);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			// System.out.println(c);
			if (checkBox.isSelected()) {

				new Loading(username);
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null,
						"To confirm your request , Please check box to let us know you're human(Sorry, no robots allowed). ");
			}
		}
	}

}
