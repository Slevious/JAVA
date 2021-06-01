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
			pname[i] = new JLabel(MarbleGame.p[i].getName()); // 플레이어 이름
			pname[i].setHorizontalAlignment(JLabel.CENTER); // 라벨 내에서 가운데정렬
			pname[i].setFont(new Font("08서울남산체 M", Font.PLAIN, 20)); // 글꼴, 일반, 크기
		}
		pname[0].setBounds(195, 370, 100, 50); // 위치 및 사이즈
		pname[1].setBounds(500, 110, 100, 50);
		pname[2].setBounds(1200, 370, 100, 50);
		for(int i=0;i<3;i++)
		{
			MarbleGame.jlp.add(pname[i], new Integer(5)); // 5층에 추가
		}
	}
}