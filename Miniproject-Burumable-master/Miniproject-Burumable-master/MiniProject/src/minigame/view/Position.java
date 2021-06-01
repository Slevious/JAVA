package minigame.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import minigame.controller.PosiEvent;
import minigame.controller.SoccerGame;

public class Position extends JLabel
{
	public static JLabel[] posi = new JLabel[5];

	private ImageIcon nc = new ImageIcon("img/nonclick.png");
	private PosiEvent pe = new PosiEvent();

	public Position()
	{	
		for(int i=0;i<5;i++)
		{
			posi[i] = new JLabel(nc);
			posi[i].addMouseListener(pe);
		}
		posi[0].setBounds(110, 185, 260, 160);
		posi[1].setBounds(110, 25, 260, 160);
		posi[2].setBounds(370, 25, 260, 160);
		posi[3].setBounds(630, 25, 260, 160);
		posi[4].setBounds(630, 185, 260, 160);
		for(int i=0;i<5;i++)
		{
			SoccerGame.jlp.add(posi[i], new Integer(1));
		}
	}
}