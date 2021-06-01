package maingame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class TurnBackground extends JLabel
{
	private ImageIcon tbg = new ImageIcon("img/turnbackground.png");

	public TurnBackground()
	{
		setIcon(tbg); // �̹���
		setBounds(0, 0, 1500, 1000); // ��ġ �� ������
		MarbleGame.jlp.add(this, new Integer(2)); // 2���� �߰�
	}
}