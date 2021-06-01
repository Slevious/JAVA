package minigame.controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import maingame.controller.MarbleGame;
import maingame.controller.MarbleManager;
import minigame.model.vo.BackGround;
import minigame.model.vo.Ball;
import minigame.model.vo.GoalKeeper;
import minigame.view.Position;

public class SoccerManager
{		
	static int gknum = 0;

	private ImageIcon gk1 = new ImageIcon("img/goalkeeper1.png");
	private ImageIcon gk2 = new ImageIcon("img/goalkeeper2.png");
	private ImageIcon gk3 = new ImageIcon("img/goalkeeper3.png");
	private ImageIcon gk4 = new ImageIcon("img/goalkeeper4.png");
	private ImageIcon gk5 = new ImageIcon("img/goalkeeper5.png");
	private ImageIcon r1 = new ImageIcon("img/victory.png");
	private ImageIcon r2 = new ImageIcon("img/defeat.png");
	private JLabel result;
	private MarbleManager mm = new MarbleManager();

	public void initial()
	{
		BackGround bg = new BackGround();
		Position p = new Position();
		GoalKeeper gk = new GoalKeeper();
		Ball b = new Ball();
	}

	public void defense()
	{
		int num = (int)(Math.random()*5+1);

		switch(num)
		{
		case 1:
			GoalKeeper.gk.setIcon(gk1);
			gknum = 1;
			break;
		case 2:
			GoalKeeper.gk.setIcon(gk2);
			gknum = 2;
			break;
		case 3:
			GoalKeeper.gk.setIcon(gk3);
			gknum = 3;
			break;
		case 4:
			GoalKeeper.gk.setIcon(gk4);
			gknum = 4;
			break;
		case 5:
			GoalKeeper.gk.setIcon(gk5);
			gknum = 5;
			break;
		}
	}

	public void compare(int gknum, int posinum)
	{
		if(gknum != posinum)
		{
			MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()+500000);
			mm.moneysetting();

			result = new JLabel(r1);
			result.setBounds(0, 0, 1000, 700);
			SoccerGame.jlp.add(result, new Integer(4));
			result.setVisible(true);
			JOptionPane.showMessageDialog(SoccerGame.jlp, "'50만원' 획득 성공!!! 축하합니다♥", "게임 결과", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			result = new JLabel(r2);
			result.setBounds(0, 0, 1000, 700);
			SoccerGame.jlp.add(result, new Integer(4));
			result.setVisible(true);
			JOptionPane.showMessageDialog(SoccerGame.jlp, "'50만원' 획득 실패!!! 다음 기회에...ㅠㅠ", "게임 결과", JOptionPane.ERROR_MESSAGE);
		}
	}
}