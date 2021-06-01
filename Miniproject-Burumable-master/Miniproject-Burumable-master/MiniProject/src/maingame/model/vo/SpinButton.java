package maingame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import maingame.controller.MarbleGame;
import maingame.controller.SpinEvent;

public class SpinButton extends JButton
{
	private ImageIcon s = new ImageIcon("img/spin.png");
	private SpinEvent se = new SpinEvent();

	public SpinButton()
	{
		setIcon(s); // 이미지
		addActionListener(se); // 액션 추가
		setBorderPainted(false); // 버튼 설정 3종
		setContentAreaFilled(false);
		setFocusPainted(false);
		setBounds(700,530,100,50); // 위치 및 사이즈
		MarbleGame.jlp.add(this, new Integer(5)); // 5층에 추가
	}
}