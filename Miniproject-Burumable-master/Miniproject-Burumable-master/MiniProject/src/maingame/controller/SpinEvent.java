package maingame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpinEvent implements ActionListener
{
	private MarbleManager mm = new MarbleManager();

	public void actionPerformed(ActionEvent e)
	{
		mm.spindice(); // 주사위 돌리기 메소드
		mm.pdiceimage(); // 값에 따른 주사위 이미지
		mm.game(); // 게임 시작
	}
}