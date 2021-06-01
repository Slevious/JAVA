package maingame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import maingame.controller.MarbleGame;
import maingame.controller.StartEvent;

public class StartButton extends JButton
{
	private ImageIcon sb = new ImageIcon("img/startbutton.png");
	private StartEvent se = new StartEvent();

	public StartButton()
	{
		setIcon(sb); // �̹���
		addActionListener(se); // �׼� �߰�
		setBorderPainted(false); // �׵θ� ����(������ ��ư ���� 3��)
		setContentAreaFilled(false); // �� ���� �����ϰ�
		setFocusPainted(false); // ��Ŀ�� �� ��, �׵θ� ����
		setBounds(625, 750, 250, 130); // ��ġ �� ������
		MarbleGame.jlp.add(this, new Integer(1)); // 1���� �߰�
	}
}