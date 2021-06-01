package maingame.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import maingame.controller.MarbleGame;
import maingame.controller.MarbleManager;

public class SalaryPopup extends JDialog
{	
	private ImageIcon pbg = new ImageIcon("img/popupbackground.png");
	private ImageIcon yb = new ImageIcon("img/yesbutton.png");
	private JLabel background;
	private JLabel[] text = new JLabel[3];
	private JButton yes;
	private MarbleManager mm = new MarbleManager();

	public SalaryPopup()
	{
		// 팝업 틀 설정
		setTitle("관람료 지급"); // 팝업 설정 5종
		setSize(500, 280);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

		background = new JLabel(pbg); // 이미지
		background.setBounds(0, 0, 500, 280); // 위치 및 사이즈

		String str1 = null;
		String str2 = String.format("%,d", MarbleGame.p[MarbleManager.pnum].getSalary());

		for (int i=0;i<3;i++)
		{
			text[i] = new JLabel(); // 생성
			text[i].setFont(new Font("08서울남산체 M", Font.PLAIN, 18)); // 글꼴, 일반, 크기
			text[i].setHorizontalAlignment(JLabel.CENTER); // 라벨 내에서 가운데정렬
		}

		// 소유한 구장 나열
		for(int i=0;i<3;i++)
		{
			if(i == 0)
			{
				if(MarbleGame.pst[MarbleManager.pnum][0] != 0)
					str1 = MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][0]].getName();
			}
			else
				if(MarbleGame.pst[MarbleManager.pnum][i] != 0)
					str1 += " / " + MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getName();
		}

		text[0].setText("< 소유한 구장 목록 >");
		text[0].setBounds(0, 40, 500, 30);
		text[1].setText(str1);
		text[1].setBounds(0, 75, 500, 30);
		text[2].setText("총 " + str2 + "원의 관람료가 지급됩니다.");
		text[2].setBounds(0, 110, 500, 30);

		yes = new JButton(yb); // 이미지
		yes.setBorderPainted(false); // 버튼 설정 3종
		yes.setContentAreaFilled(false);
		yes.setFocusPainted(false);
		yes.setBounds(200, 175, 100, 50); // 위치 및 사이즈

		// 예 버튼 액션(무기명)
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // 사라지게 하기

				MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()+MarbleGame.p[MarbleManager.pnum].getSalary()); // 월급 지급
				mm.moneysetting(); // 돈 세팅
			}
		});

		// 팝업에 컴포넌트들 올리기
		for (int i=0;i<3;i++) {
			background.add(text[i]);
		}
		background.add(yes);
		add(background);

		setVisible(true); // 팝업을 보여주기
	}
}