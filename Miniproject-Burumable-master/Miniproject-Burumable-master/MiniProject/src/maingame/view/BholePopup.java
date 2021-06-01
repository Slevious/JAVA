package maingame.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class BholePopup extends JDialog
{
	private ImageIcon bb = new ImageIcon("img/blackbutton.png");
	private ImageIcon bbg = new ImageIcon("img/blackbackground.png");

	public BholePopup()
	{
		// 팝업 틀 설정
		setTitle("블랙홀 입장"); // 팝업 설정 5종
		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

		JLabel warn = new JLabel(bbg); // 이미지
		warn.setBounds(0, 0, 500, 500); // 위치 및 사이즈

		JButton ok = new JButton(bb); // 이미지
		ok.setBorderPainted(false); // 버튼 설정 3종
		ok.setContentAreaFilled(false);
		ok.setFocusPainted(false);
		ok.setBounds(0, 300, 200, 100); // 위치 및 사이즈

		// 확인 버튼 액션(무기명)
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // 사라지게 하기
			}
		});

		// 팝업에 컴포넌트들 올리기
		warn.add(ok);
		add(warn);

		setVisible(true); // 팝업을 보여주기
	}
}