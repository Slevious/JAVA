package minigame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import minigame.controller.SoccerGame;

public class GoalKeeper extends JLabel
{
	public static JLabel gk;

	private ImageIcon gk0 = new ImageIcon("img/goalkeeper.png");

	public GoalKeeper()
	{
		gk = new JLabel(gk0);
		gk.setBounds(0, 0, 1000, 470);
		SoccerGame.jlp.add(gk, new Integer(2));
	}
}