package minigame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import minigame.controller.SoccerGame;

public class BackGround extends JLabel
{
	private ImageIcon bg = new ImageIcon("img/background.png");

	public BackGround()
	{
		setIcon(bg);
		setBounds(0, 0, 1000, 700);
		SoccerGame.jlp.add(this, new Integer(0));
	}
}