package maingame.model.vo;

import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class PDice extends JLabel
{
	public static JLabel[] pdice = new JLabel[2];

	public PDice()
	{
		for(int i=0;i<2;i++)
		{
			pdice[i] = new JLabel(); // ����
		}
		pdice[0].setBounds(650,450,50,50); // ��ġ �� ������
		pdice[1].setBounds(800,450,50,50);
		for(int i=0;i<2;i++)
		{
			MarbleGame.jlp.add(pdice[i], new Integer(5)); // 5���� �߰�
		}
	}
}