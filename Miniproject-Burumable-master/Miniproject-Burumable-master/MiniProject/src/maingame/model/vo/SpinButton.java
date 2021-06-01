package maingame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import maingame.controller.MarbleGame;
import maingame.controller.SpinEvent;

public class SpinButton extends JButton
{
	private ImageIcon s = new ImageIcon("img/spin.png");
	private SpinEvent se = new SpinEvent();

	public SpinButton()
	{
		setIcon(s); // �̹���
		addActionListener(se); // �׼� �߰�
		setBorderPainted(false); // ��ư ���� 3��
		setContentAreaFilled(false);
		setFocusPainted(false);
		setBounds(700,530,100,50); // ��ġ �� ������
		MarbleGame.jlp.add(this, new Integer(5)); // 5���� �߰�
	}
}