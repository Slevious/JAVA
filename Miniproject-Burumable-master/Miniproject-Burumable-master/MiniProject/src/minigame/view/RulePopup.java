package minigame.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RulePopup extends JDialog
{
	private ImageIcon r = new ImageIcon("img/rule.PNG");
	private ImageIcon s = new ImageIcon("img/start.png");
	private ImageIcon s1 = new ImageIcon("img/start_1.png");

	public RulePopup(JFrame frame, String title, boolean b)
	{
		super(frame, title, b);

		JLabel rule = new JLabel(r);
		JButton start = new JButton(s);

		start.setBorderPainted(false);
		start.setContentAreaFilled(false);
		start.setFocusPainted(false);
		start.setRolloverIcon(s1);

		setSize(400, 370);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());

		add(rule);
		add(start);

		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		setVisible(true);
	}
}