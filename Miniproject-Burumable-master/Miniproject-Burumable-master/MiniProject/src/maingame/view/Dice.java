package maingame.view;

import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class Dice extends JLabel
{
	public static JLabel[] d = new JLabel[3];

	public Dice()
	{
		for(int i=0;i<3;i++)
		{
			d[i] = new JLabel(); // 생성
		}
		d[0].setBounds(375, 450, 50, 50); // 위치 및 사이즈
		d[1].setBounds(725, 450, 50, 50);
		d[2].setBounds(1075, 450, 50, 50);
		for(int i=0;i<3;i++)
		{
			MarbleGame.jlp.add(d[i], new Integer(3)); // 3층에 추가
		}
	}
}