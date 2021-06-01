package maingame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class MainBackground extends JLabel
{
	private ImageIcon mbg = new ImageIcon("img/mainbackground.png");

	public MainBackground()
	{
		setIcon(mbg); // �̹���
		setBounds(0, 0, 1500, 1000); // ��ġ �� ������
		MarbleGame.jlp.add(this, new Integer(4)); // 4���� �߰�
	}
}