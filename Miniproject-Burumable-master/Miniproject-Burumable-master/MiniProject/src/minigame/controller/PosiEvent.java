package minigame.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import minigame.model.vo.Ball;
import minigame.view.Position;

public class PosiEvent implements MouseListener
{
	private ImageIcon sb = new ImageIcon("img/shootball.png");
	private ImageIcon nc = new ImageIcon("img/nonclick.png");
	private ImageIcon c = new ImageIcon("img/click.png");
	private SoccerManager sm = new SoccerManager();

	@Override
	public void mouseClicked(MouseEvent e)
	{	
		Ball.b.setIcon(sb);
		sm.defense();

		if(e.getSource() == Position.posi[0])
		{
			Position.posi[0].setIcon(nc);
			Ball.b.setBounds(200, 220, 70, 70);
			sm.compare(SoccerManager.gknum, 1);
		}
		if(e.getSource() ==  Position.posi[1])
		{
			Position.posi[1].setIcon(nc);
			Ball.b.setBounds(200, 60, 70, 70);
			sm.compare(SoccerManager.gknum, 2);
		}
		if(e.getSource() ==  Position.posi[2])
		{
			Position.posi[2].setIcon(nc);
			Ball.b.setBounds(465, 40, 70, 70);
			sm.compare(SoccerManager.gknum, 3);
		}
		if(e.getSource() == Position.posi[3])
		{
			Position.posi[3].setIcon(nc);
			Ball.b.setBounds(725, 65, 70, 70);
			sm.compare(SoccerManager.gknum, 4);
		}
		if(e.getSource() == Position.posi[4])
		{
			Position.posi[4].setIcon(nc);
			Ball.b.setBounds(725, 220, 70, 70);
			sm.compare(SoccerManager.gknum, 5);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		if(e.getSource() == Position.posi[0])
		{
			Position.posi[0].setIcon(c);
			Position.posi[1].setIcon(nc);
			Position.posi[2].setIcon(nc);
			Position.posi[3].setIcon(nc);
			Position.posi[4].setIcon(nc);
		}
		if(e.getSource() == Position.posi[1])
		{
			Position.posi[0].setIcon(nc);
			Position.posi[1].setIcon(c);
			Position.posi[2].setIcon(nc);
			Position.posi[3].setIcon(nc);
			Position.posi[4].setIcon(nc);
		}
		if(e.getSource() == Position.posi[2])
		{
			Position.posi[0].setIcon(nc);
			Position.posi[1].setIcon(nc);
			Position.posi[2].setIcon(c);
			Position.posi[3].setIcon(nc);
			Position.posi[4].setIcon(nc);
		}
		if(e.getSource() == Position.posi[3])
		{
			Position.posi[0].setIcon(nc);
			Position.posi[1].setIcon(nc);
			Position.posi[2].setIcon(nc);
			Position.posi[3].setIcon(c);
			Position.posi[4].setIcon(nc);
		}
		if(e.getSource() == Position.posi[4])
		{
			Position.posi[0].setIcon(nc);
			Position.posi[1].setIcon(nc);
			Position.posi[2].setIcon(nc);
			Position.posi[3].setIcon(nc);
			Position.posi[4].setIcon(c);
		}
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		for(int i=0;i<5;i++)
		{
			Position.posi[i].setIcon(nc);
		}
	}
}