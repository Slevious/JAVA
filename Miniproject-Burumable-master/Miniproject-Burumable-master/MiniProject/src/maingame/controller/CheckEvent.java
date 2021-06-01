package maingame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import maingame.model.vo.CheckButton;
import maingame.view.CheckPopup;

public class CheckEvent implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		CheckButton.cb.setVisible(false); // 체크 버튼 1번 누른 뒤, 사라지기
		
		CheckPopup cp = new CheckPopup(); // 순서 결과 팝업
	}
}