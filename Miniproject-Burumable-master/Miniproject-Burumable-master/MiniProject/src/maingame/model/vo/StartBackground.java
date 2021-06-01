package maingame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class StartBackground extends JLabel
{
	private ImageIcon sbg = new ImageIcon("img/startbackground.png");

	public StartBackground()
	{
		setIcon(sbg); // 이미지
		setBounds(0, 0, 1500, 1000); // 위치 및 사이즈
		MarbleGame.jlp.add(this, new Integer(0)); // 0층에 추가
	}
}