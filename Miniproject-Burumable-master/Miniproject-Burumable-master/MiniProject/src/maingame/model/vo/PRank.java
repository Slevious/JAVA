package maingame.model.vo;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class PRank extends JLabel
{
	public JLabel[] prank = new JLabel[3];

	public PRank()
	{
		for(int i=0;i<3;i++)
		{
			prank[i] = new JLabel(); // ����
			prank[i].setFont(new Font("08���ﳲ��ü M", Font.PLAIN, 20)); // �۲�, �Ϲ�, ũ��
			prank[i].setHorizontalAlignment(JLabel.CENTER); // �� ������ �������
		}
		prank[0].setBounds(700, 590, 160, 70); // ��ġ �� ������
		prank[1].setBounds(700, 520, 160, 70);
		prank[2].setBounds(700, 450, 160, 70);
		for(int i=0;i<3;i++)
		{
			MarbleGame.jlp.add(prank[i], new Integer(8)); // 8���� �߰�
		}
	}
}