package maingame.view;

import java.awt.Font;

import javax.swing.JTextField;

import maingame.controller.MarbleGame;

public class NameField extends JTextField
{
	static JTextField[] nf = new JTextField[3];

	public NameField()
	{
		for(int i=0;i<3;i++)
		{
			nf[i] = new JTextField(12); // ���� 12
			nf[i].setFont(new Font("08���ﳲ��ü M", Font.BOLD, 20)); // �۲�, ����, ũ��
			nf[i].setBorder(null); // �׵θ� ����
			nf[i].setToolTipText("�ִ� 5����"); // ��Ŀ�� �� ��, ���� ����
		}
		nf[0].setBounds(320, 620, 160, 35); // ��ġ �� ������
		nf[1].setBounds(670, 620, 160, 35);
		nf[2].setBounds(1020, 620, 160, 35);
		for(int i=0;i<3;i++)
		{
			MarbleGame.jlp.add(nf[i], new Integer(1)); // 1���� �߰�
		}
	}
}