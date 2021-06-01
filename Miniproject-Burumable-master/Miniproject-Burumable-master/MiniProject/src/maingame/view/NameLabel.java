package maingame.view;

import java.awt.Font;

import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class NameLabel extends JLabel
{
	static JLabel[] nl = new JLabel[3];

	public NameLabel()
	{
		for(int i=0;i<3;i++)
		{
			nl[i] = new JLabel(NameField.nf[i].getText()); // �ؽ�Ʈ�ʵ忡 �Էµ� ���� �����ͼ� �ֱ�
			nl[i].setFont(new Font("08���ﳲ��ü M", Font.PLAIN, 30)); // �۲�, �Ϲ�, ũ��
			nl[i].setHorizontalAlignment(JLabel.CENTER); // �� ������ �������
		}
		nl[0].setBounds(320, 305, 160, 70); // ��ġ �� ������
		nl[1].setBounds(670, 305, 160, 70);
		nl[2].setBounds(1020, 305, 160, 70);
		for(int i=0;i<3;i++)
		{
			MarbleGame.jlp.add(nl[i], new Integer(3)); // 3���� �߰�
		}
	}
}