package maingame.model.vo;

import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class PFlagmove extends JLabel
{
	public static JLabel pflagmove; // �� �̵� ���� ��ġ ��ǥ
	
	public PFlagmove()
	{
		pflagmove = new JLabel(); // ����
		MarbleGame.jlp.add(pflagmove, new Integer(6)); // 6���� �߰�
	}
}