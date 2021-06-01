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
			nf[i] = new JTextField(12); // 길이 12
			nf[i].setFont(new Font("08서울남산체 M", Font.BOLD, 20)); // 글꼴, 굵게, 크기
			nf[i].setBorder(null); // 테두리 제거
			nf[i].setToolTipText("최대 5글자"); // 포커스 될 때, 툴팁 설정
		}
		nf[0].setBounds(320, 620, 160, 35); // 위치 및 사이즈
		nf[1].setBounds(670, 620, 160, 35);
		nf[2].setBounds(1020, 620, 160, 35);
		for(int i=0;i<3;i++)
		{
			MarbleGame.jlp.add(nf[i], new Integer(1)); // 1층에 추가
		}
	}
}