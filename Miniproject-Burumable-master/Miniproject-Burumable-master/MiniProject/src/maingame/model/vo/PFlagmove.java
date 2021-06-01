package maingame.model.vo;

import javax.swing.JLabel;

import maingame.controller.MarbleGame;

public class PFlagmove extends JLabel
{
	public static JLabel pflagmove; // 말 이동 시작 위치 좌표
	
	public PFlagmove()
	{
		pflagmove = new JLabel(); // 생성
		MarbleGame.jlp.add(pflagmove, new Integer(6)); // 6층에 추가
	}
}