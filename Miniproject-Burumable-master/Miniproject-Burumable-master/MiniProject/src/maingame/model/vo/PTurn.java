package maingame.model.vo;

import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class PTurn extends JLabel
{
	public static JLabel[] pturn = new JLabel[3];
	
	public PTurn()
	{
		for(int i=0;i<3;i++)
		{
			pturn[i] = new JLabel(); // ����
		}
		pturn[0].setBounds(130, 385, 20, 20); // ��ġ �� ������
		pturn[1].setBounds(435, 125, 20, 20);
		pturn[2].setBounds(1135, 385, 20, 20);
		for(int i=0;i<3;i++)
		{
			MarbleGame.jlp.add(pturn[i], new Integer(5)); // 5���� �߰�
		}
	}
}