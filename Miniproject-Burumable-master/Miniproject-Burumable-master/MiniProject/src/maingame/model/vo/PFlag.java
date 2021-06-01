package maingame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class PFlag extends JLabel
{
	public static JLabel[][] pflag = new JLabel[3][12];
	
	private ImageIcon y = new ImageIcon("img/yellow.png");
	private ImageIcon b = new ImageIcon("img/blue.png");
	private ImageIcon g = new ImageIcon("img/green.png");

	public PFlag()
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<12;j++)
			{
				pflag[i][j] = new JLabel(); // 생성
			}
		}
		pflag[0][0].setIcon(y); // 이미지
		pflag[1][0].setIcon(b);
		pflag[2][0].setIcon(g);
		
		pflag[0][0].setBounds(485, 665, 20, 30); // 위치 및 사이즈
		pflag[0][1].setBounds(630, 665, 20, 30);
		pflag[0][2].setBounds(775, 665, 20, 30);
		pflag[0][3].setBounds(920, 665, 20, 30);
		pflag[0][4].setBounds(920, 555, 20, 30);
		pflag[0][5].setBounds(920, 445, 20, 30);
		pflag[0][6].setBounds(920, 335, 20, 30);
		pflag[0][7].setBounds(775, 335, 20, 30);
		pflag[0][8].setBounds(630, 335, 20, 30);
		pflag[0][9].setBounds(485, 335, 20, 30);
		pflag[0][10].setBounds(485, 445, 20, 30);
		pflag[0][11].setBounds(485, 555, 20, 30);

		pflag[1][0].setBounds(525, 665, 20, 30);
		pflag[1][1].setBounds(670, 665, 20, 30);
		pflag[1][2].setBounds(815, 665, 20, 30);
		pflag[1][3].setBounds(960, 665, 20, 30);
		pflag[1][4].setBounds(960, 555, 20, 30);
		pflag[1][5].setBounds(960, 445, 20, 30);
		pflag[1][6].setBounds(960, 335, 20, 30);
		pflag[1][7].setBounds(815, 335, 20, 30);
		pflag[1][8].setBounds(670, 335, 20, 30);
		pflag[1][9].setBounds(525, 335, 20, 30);
		pflag[1][10].setBounds(525, 445, 20, 30);
		pflag[1][11].setBounds(525, 555, 20, 30);

		pflag[2][0].setBounds(565, 665, 20, 30);
		pflag[2][1].setBounds(710, 665, 20, 30);
		pflag[2][2].setBounds(855, 665, 20, 30);
		pflag[2][3].setBounds(1000, 665, 20, 30);
		pflag[2][4].setBounds(1000, 555, 20, 30);
		pflag[2][5].setBounds(1000, 445, 20, 30);
		pflag[2][6].setBounds(1000, 335, 20, 30);
		pflag[2][7].setBounds(855, 335, 20, 30);
		pflag[2][8].setBounds(710, 335, 20, 30);
		pflag[2][9].setBounds(565, 335, 20, 30);
		pflag[2][10].setBounds(565, 445, 20, 30);
		pflag[2][11].setBounds(565, 555, 20, 30);

		for(int i=0;i<3;i++)
		{
			for(int j=0;j<12;j++)
			{
				MarbleGame.jlp.add(pflag[i][j], new Integer(5)); // 5층에 추가
			}
		}
	}
}