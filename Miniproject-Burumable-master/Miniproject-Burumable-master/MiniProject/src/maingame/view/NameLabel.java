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
			nl[i] = new JLabel(NameField.nf[i].getText()); // 텍스트필드에 입력된 값을 가져와서 넣기
			nl[i].setFont(new Font("08서울남산체 M", Font.PLAIN, 30)); // 글꼴, 일반, 크기
			nl[i].setHorizontalAlignment(JLabel.CENTER); // 라벨 내에서 가운데정렬
		}
		nl[0].setBounds(320, 305, 160, 70); // 위치 및 사이즈
		nl[1].setBounds(670, 305, 160, 70);
		nl[2].setBounds(1020, 305, 160, 70);
		for(int i=0;i<3;i++)
		{
			MarbleGame.jlp.add(nl[i], new Integer(3)); // 3층에 추가
		}
	}
}