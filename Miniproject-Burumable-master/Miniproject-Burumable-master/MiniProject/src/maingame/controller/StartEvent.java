package maingame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import maingame.model.vo.CheckButton;
import maingame.model.vo.TurnBackground;
import maingame.model.vo.TurnButton;
import maingame.view.Dice;
import maingame.view.NameLabel;

public class StartEvent implements ActionListener
{	
	public void actionPerformed(ActionEvent e)
	{
		TurnBackground tb = new TurnBackground();
		NameLabel nl = new NameLabel();
		Dice d = new Dice();
		TurnButton t = new TurnButton();
		CheckButton cb = new CheckButton();
	}
}