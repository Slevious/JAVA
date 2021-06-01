package maingame.model.vo;

import java.awt.Font;

import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class PName extends JLabel
{
	public PName()
	{
		JLabel[] pname = new JLabel[3];
		
		for(int i=0;i<3;i++)
		{
			pname[i] = new JLabel(MarbleGame.p[i].getName()); // �÷��̾� �̸�
			pname[i].setHorizontalAlignment(JLabel.CENTER); // �� ������ �������
			pname[i].setFont(new Font("08���ﳲ��ü M", Font.PLAIN, 20)); // �۲�, �Ϲ�, ũ��
		}
		pname[0].setBounds(195, 370, 100, 50); // ��ġ �� ������
		pname[1].setBounds(500, 110, 100, 50);
		pname[2].setBounds(1200, 370, 100, 50);
		for(int i=0;i<3;i++)
		{
			MarbleGame.jlp.add(pname[i], new Integer(5)); // 5���� �߰�
		}
	}
}