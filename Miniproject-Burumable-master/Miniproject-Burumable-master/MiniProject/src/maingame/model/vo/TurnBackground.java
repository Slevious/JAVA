package maingame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class TurnBackground extends JLabel
{
	private ImageIcon tbg = new ImageIcon("img/turnbackground.png");

	public TurnBackground()
	{
		setIcon(tbg); // 이미지
		setBounds(0, 0, 1500, 1000); // 위치 및 사이즈
		MarbleGame.jlp.add(this, new Integer(2)); // 2층에 추가
	}
}