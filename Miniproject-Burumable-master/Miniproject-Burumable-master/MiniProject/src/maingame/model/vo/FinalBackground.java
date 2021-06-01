package maingame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class FinalBackground extends JLabel
{
	private ImageIcon gbg = new ImageIcon("img/gameover_background.png");

	public FinalBackground()
	{
		setIcon(gbg); // �̹���
		setBounds(0, 0, 1500, 1000); // ��ġ �� ������
		MarbleGame.jlp.add(this, new Integer(7)); // 7���� �߰�
	}
}