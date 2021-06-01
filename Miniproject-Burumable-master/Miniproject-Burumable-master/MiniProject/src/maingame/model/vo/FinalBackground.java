package maingame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class FinalBackground extends JLabel
{
	private ImageIcon gbg = new ImageIcon("img/gameover_background.png");

	public FinalBackground()
	{
		setIcon(gbg); // 이미지
		setBounds(0, 0, 1500, 1000); // 위치 및 사이즈
		MarbleGame.jlp.add(this, new Integer(7)); // 7층에 추가
	}
}