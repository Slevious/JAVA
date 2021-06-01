package minigame.controller;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import minigame.view.RulePopup;

public class SoccerGame extends JFrame
{
	public static JLayeredPane jlp;

	private SoccerManager sm = new SoccerManager();

	public SoccerGame()
	{
		new RulePopup(this, "게임 설명", true);

		jlp = new JLayeredPane();

		setTitle("축구 게임");
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		sm.initial();

		add(jlp);

		setVisible(true);
	}
}