package maingame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class StartBackground extends JLabel
{
	private ImageIcon sbg = new ImageIcon("img/startbackground.png");

	public StartBackground()
	{
		setIcon(sbg); // �̹���
		setBounds(0, 0, 1500, 1000); // ��ġ �� ������
		MarbleGame.jlp.add(this, new Integer(0)); // 0���� �߰�
	}
}