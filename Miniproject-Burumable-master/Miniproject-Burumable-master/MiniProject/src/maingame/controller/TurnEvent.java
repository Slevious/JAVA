package maingame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import maingame.model.vo.TurnButton;

public class TurnEvent implements ActionListener
{
	private MarbleManager mm = new MarbleManager();

	public void actionPerformed(ActionEvent e)
	{
		mm.turndice(); // 주사위 돌리기
		mm.diceimage(); // 값에 따른 주사위 이미지
		mm.sortdice(); // 주사위 값 내림차순 정렬
		mm.rank(); // 플레이어 인덱스 추출 후, 순서 정하기

		TurnButton.tb.setVisible(false); // 돌리기 버튼 1번 누른 뒤, 사라지기
	}
}