package maingame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import maingame.controller.MarbleGame;
import maingame.controller.TurnEvent;

public class TurnButton extends JButton
{
	public static JButton tb;

	private ImageIcon t = new ImageIcon("img/turnbutton.png");
	private TurnEvent te = new TurnEvent();

	public TurnButton()
	{
		tb = new JButton(t); // �̹���
		tb.addActionListener(te); // �׼� �߰�
		tb.setBorderPainted(false); // ��ư ���� 3��
		tb.setContentAreaFilled(false);
		tb.setFocusPainted(false);
		tb.setBounds(700, 575, 100, 50); // ��ġ �� ������
		MarbleGame.jlp.add(tb, new Integer(3)); // 3���� �߰�
	}
}