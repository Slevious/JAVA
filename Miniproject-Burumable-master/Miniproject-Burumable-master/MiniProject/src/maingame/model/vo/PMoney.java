package maingame.model.vo;

import java.awt.Font;

import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class PMoney extends JLabel
{
	public static JLabel[] pmoney = new JLabel[3];

	public PMoney()
	{
		for(int i=0;i<3;i++)
		{
			pmoney[i] = new JLabel(); // ����
			pmoney[i].setHorizontalAlignment(JLabel.CENTER); // �� ������ �������
			pmoney[i].setFont(new Font("08���ﳲ��ü M", Font.PLAIN, 20)); // �۲�, �Ϲ�, ũ��
		}
		pmoney[0].setBounds(195, 435, 100, 50); // ��ġ �� ������
		pmoney[1].setBounds(500, 175, 100, 50);
		pmoney[2].setBounds(1200, 435, 100, 50);
		for(int i=0;i<3;i++)
		{
			MarbleGame.jlp.add(pmoney[i], new Integer(5)); // 5���� �߰�
		}
	}
}