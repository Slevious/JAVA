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
			pmoney[i] = new JLabel(); // 생성
			pmoney[i].setHorizontalAlignment(JLabel.CENTER); // 라벨 내에서 가운데정렬
			pmoney[i].setFont(new Font("08서울남산체 M", Font.PLAIN, 20)); // 글꼴, 일반, 크기
		}
		pmoney[0].setBounds(195, 435, 100, 50); // 위치 및 사이즈
		pmoney[1].setBounds(500, 175, 100, 50);
		pmoney[2].setBounds(1200, 435, 100, 50);
		for(int i=0;i<3;i++)
		{
			MarbleGame.jlp.add(pmoney[i], new Integer(5)); // 5층에 추가
		}
	}
}