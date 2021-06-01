package maingame.model.vo;

import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class PGround extends JLabel
{
	public static JLabel[][] pground = new JLabel[3][3];

	public PGround()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				pground[i][j] = new JLabel(); // 생성
			}
		}
		
		pground[0][0].setBounds(72, 511, 110, 150); // 위치 및 사이즈
		pground[0][1].setBounds(192, 511, 110, 150);
		pground[0][2].setBounds(312, 511, 110, 150);
		
		pground[1][0].setBounds(743, 73, 110, 150);
		pground[1][1].setBounds(863, 73, 110, 150);
		pground[1][2].setBounds(983, 73, 110, 150);
		
		pground[2][0].setBounds(1077, 511, 110, 150);
		pground[2][1].setBounds(1197, 511, 110, 150);
		pground[2][2].setBounds(1317, 511, 110, 150);
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				MarbleGame.jlp.add(pground[i][j], new Integer(5)); // 5층에 추가
			}
		}
	}
}