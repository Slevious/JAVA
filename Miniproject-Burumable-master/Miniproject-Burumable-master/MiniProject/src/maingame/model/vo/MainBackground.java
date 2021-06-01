package maingame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class MainBackground extends JLabel
{
	private ImageIcon mbg = new ImageIcon("img/mainbackground.png");

	public MainBackground()
	{
		setIcon(mbg); // 이미지
		setBounds(0, 0, 1500, 1000); // 위치 및 사이즈
		MarbleGame.jlp.add(this, new Integer(4)); // 4층에 추가
	}
}