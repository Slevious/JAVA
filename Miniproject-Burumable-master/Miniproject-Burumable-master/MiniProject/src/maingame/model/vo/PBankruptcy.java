package maingame.model.vo;

import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class PBankruptcy extends JLabel
{
	public static JLabel[] pbankruptcy = new JLabel[3];

	public PBankruptcy()
	{
		for(int i=0;i<3;i++)
		{
			pbankruptcy[i] = new JLabel(); // ����
		}
		pbankruptcy[0].setBounds(110, 360, 270, 295); // ��ġ �� ������
		pbankruptcy[1].setBounds(630, 0, 270, 295);
		pbankruptcy[2].setBounds(1125, 360, 270, 295);

		for(int i=0;i<3;i++)
		{
			MarbleGame.jlp.add(pbankruptcy[i], new Integer(6)); // 6���� �߰�
		}
	}
}