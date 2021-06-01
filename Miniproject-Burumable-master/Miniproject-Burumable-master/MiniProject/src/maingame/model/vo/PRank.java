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
			prank[i] = new JLabel(); // 생성
			prank[i].setFont(new Font("08서울남산체 M", Font.PLAIN, 20)); // 글꼴, 일반, 크기
			prank[i].setHorizontalAlignment(JLabel.CENTER); // 라벨 내에서 가운데정렬
		}
		prank[0].setBounds(700, 590, 160, 70); // 위치 및 사이즈
		prank[1].setBounds(700, 520, 160, 70);
		prank[2].setBounds(700, 450, 160, 70);
		for(int i=0;i<3;i++)
		{
			MarbleGame.jlp.add(prank[i], new Integer(8)); // 8층에 추가
		}
	}
}