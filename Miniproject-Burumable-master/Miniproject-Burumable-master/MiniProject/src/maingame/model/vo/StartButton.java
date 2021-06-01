package maingame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import maingame.controller.MarbleGame;
import maingame.controller.StartEvent;

public class StartButton extends JButton
{
	private ImageIcon sb = new ImageIcon("img/startbutton.png");
	private StartEvent se = new StartEvent();

	public StartButton()
	{
		setIcon(sb); // 이미지
		addActionListener(se); // 액션 추가
		setBorderPainted(false); // 테두리 제거(앞으로 버튼 설정 3종)
		setContentAreaFilled(false); // 빈 공간 투명하게
		setFocusPainted(false); // 포커스 될 때, 테두리 제거
		setBounds(625, 750, 250, 130); // 위치 및 사이즈
		MarbleGame.jlp.add(this, new Integer(1)); // 1층에 추가
	}
}