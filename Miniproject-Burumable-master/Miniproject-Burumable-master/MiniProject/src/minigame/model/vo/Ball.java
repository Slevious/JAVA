package minigame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import minigame.controller.SoccerGame;

public class Ball extends JLabel
{
	public static JLabel b;

	private ImageIcon ob = new ImageIcon("img/originball.png");

	public Ball()
	{
		b = new JLabel(ob);
		b.setBounds(445, 550, 110, 110);
		SoccerGame.jlp.add(b, new Integer(3));
	}
}