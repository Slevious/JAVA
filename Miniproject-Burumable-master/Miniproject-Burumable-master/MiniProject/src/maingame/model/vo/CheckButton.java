package maingame.model.vo;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import maingame.controller.CheckEvent;
import maingame.controller.MarbleGame;

public class CheckButton extends JButton
{
	public static JButton cb;
	
	private ImageIcon c = new ImageIcon("img/checkbutton.png");
	private CheckEvent ce = new CheckEvent();

	public CheckButton()
	{
		cb = new JButton(c); // 이미지
		cb.addActionListener(ce); // 액션 추가
		cb.setBorderPainted(false); // 버튼 설정 3종
		cb.setContentAreaFilled(false);
		cb.setFocusPainted(false);
		cb.setBounds(600, 750, 300, 130); // 위치 및 사이즈
		MarbleGame.jlp.add(cb, new Integer(3)); // 3층에 추가
	}
}