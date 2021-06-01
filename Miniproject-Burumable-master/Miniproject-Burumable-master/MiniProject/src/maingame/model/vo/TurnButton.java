package maingame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import maingame.controller.MarbleGame;
import maingame.controller.TurnEvent;

public class TurnButton extends JButton
{
	public static JButton tb;

	private ImageIcon t = new ImageIcon("img/turnbutton.png");
	private TurnEvent te = new TurnEvent();

	public TurnButton()
	{
		tb = new JButton(t); // 이미지
		tb.addActionListener(te); // 액션 추가
		tb.setBorderPainted(false); // 버튼 설정 3종
		tb.setContentAreaFilled(false);
		tb.setFocusPainted(false);
		tb.setBounds(700, 575, 100, 50); // 위치 및 사이즈
		MarbleGame.jlp.add(tb, new Integer(3)); // 3층에 추가
	}
}