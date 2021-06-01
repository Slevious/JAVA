package maingame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import maingame.controller.CheckEvent;
import maingame.controller.MarbleGame;

public class CheckButton extends JButton
{
	public static JButton cb;
	
	private ImageIcon c = new ImageIcon("img/checkbutton.png");
	private CheckEvent ce = new CheckEvent();

	public CheckButton()
	{
		cb = new JButton(c); // �̹���
		cb.addActionListener(ce); // �׼� �߰�
		cb.setBorderPainted(false); // ��ư ���� 3��
		cb.setContentAreaFilled(false);
		cb.setFocusPainted(false);
		cb.setBounds(600, 750, 300, 130); // ��ġ �� ������
		MarbleGame.jlp.add(cb, new Integer(3)); // 3���� �߰�
	}
}