package maingame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class PBorder extends JLabel
{
	public static JLabel[] pborder = new JLabel[12];

	private ImageIcon yb = new ImageIcon("img/yellow_border.png");
	private ImageIcon yb2 = new ImageIcon("img/yellow_border2.png");
	private ImageIcon bb = new ImageIcon("img/blue_border.png");
	private ImageIcon bb2 = new ImageIcon("img/blue_border2.png");
	private ImageIcon gb = new ImageIcon("img/green_border.png");
	private ImageIcon gb2 = new ImageIcon("img/green_border2.png");

	public PBorder()
	{
		for (int i=0;i<12;i++)
		{
			pborder[i] = new JLabel(); // 생성
		}
		pborder[1].setBounds(605, 595, 145, 145); // 위치 및 사이즈
		pborder[2].setBounds(750, 595, 145, 145);
		pborder[4].setBounds(895, 480, 145, 145);
		pborder[5].setBounds(895, 370, 145, 145);
		pborder[7].setBounds(750, 260, 145, 145);
		pborder[8].setBounds(605, 260, 145, 145);
		pborder[10].setBounds(460, 370, 145, 145);
		pborder[11].setBounds(460, 480, 145, 145);
		for (int i=0;i<12;i++)
		{
			MarbleGame.jlp.add(pborder[i], new Integer(5)); // 5층에 추가
		}
	}	
}