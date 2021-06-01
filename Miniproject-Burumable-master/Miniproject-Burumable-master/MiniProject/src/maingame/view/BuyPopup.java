package maingame.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import maingame.controller.MarbleGame;
import maingame.controller.MarbleManager;

public class BuyPopup extends JDialog
{
	private ImageIcon pbg = new ImageIcon("img/popupbackground.png");
	private ImageIcon yb = new ImageIcon("img/yesbutton.png");
	private ImageIcon nb = new ImageIcon("img/nobutton.png");
	private MarbleManager mm = new MarbleManager();

	public BuyPopup()
	{
		// 팝업 틀 설정
		setTitle("구장 구매하기"); // 팝업 설정 5종
		setSize(500, 280);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

		JLabel background = new JLabel(pbg); // 이미지
		background.setBounds(0, 0, 500, 280); // 위치 및 사이즈

		String str = String.format("%,d", MarbleGame.st[MarbleManager.posi].getPrice());

		JLabel[] text = new JLabel[3];
		for (int i=0;i<3;i++)
		{
			text[i] = new JLabel(); // 생성
			text[i].setFont(new Font("08서울남산체 M", Font.PLAIN, 18)); // 글꼴, 일반, 크기
			text[i].setHorizontalAlignment(JLabel.CENTER); // 라벨 내에서 가운데정렬
		}

		text[0].setText("현재 위치는 \"" + MarbleGame.st[MarbleManager.posi].getName() + "\" 입니다.");
		text[0].setBounds(0, 40, 500, 30);
		text[1].setText("구장의 가격은 " + str + "원 입니다.");
		text[1].setBounds(0, 75, 500, 30);
		text[2].setText("구매하시겠습니까?");
		text[2].setBounds(0, 110, 500, 30);

		JButton yes = new JButton(yb); // 이미지
		yes.setBorderPainted(false); // 버튼 설정 3종
		yes.setContentAreaFilled(false);
		yes.setFocusPainted(false);
		yes.setBounds(130, 175, 100, 50); // 위치 및 사이즈

		// 예 버튼 액션(무기명)
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // 사라지게 하기

				if(MarbleGame.st[MarbleManager.posi].getPrice() > MarbleGame.p[MarbleManager.pnum].getMoney())
				{
					JOptionPane.showMessageDialog(MarbleGame.jlp, "현금이 부족합니다. 구매할 수 없습니다.", "구매 결과", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else
					if(MarbleGame.pst[MarbleManager.pnum][0] == 0)
						MarbleGame.pst[MarbleManager.pnum][0] = MarbleManager.posi;
					else
						if(MarbleGame.pst[MarbleManager.pnum][1] == 0)
							MarbleGame.pst[MarbleManager.pnum][1] = MarbleManager.posi;
						else
							if(MarbleGame.pst[MarbleManager.pnum][2] == 0)
								MarbleGame.pst[MarbleManager.pnum][2] = MarbleManager.posi;
							else
							{
								JOptionPane.showMessageDialog(MarbleGame.jlp, "구장을 더 이상 소유할 수 없습니다.", "구매 결과", JOptionPane.ERROR_MESSAGE);
								return;
							}

				MarbleGame.st[MarbleManager.posi].setOwner(MarbleManager.pnum); // 소유자 갱신
				MarbleGame.st[MarbleManager.posi].setOwnerCheck(1); // 소유 여부 갱신
				MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()-MarbleGame.st[MarbleManager.posi].getPrice()); // 구매 비용 차감
				MarbleGame.p[MarbleManager.pnum].setSalary(MarbleGame.p[MarbleManager.pnum].getSalary()+MarbleGame.st[MarbleManager.posi].getAdmission()); // 월급 추가
				JOptionPane.showMessageDialog(MarbleGame.jlp, "구매 성공하였습니다. 축하합니다.", "구매 결과", JOptionPane.INFORMATION_MESSAGE);
				
				mm.border(); // 테두리 갱신
				mm.moneysetting(); // 돈 세팅
				mm.groundsetting(); // 구장 카드 세팅
			}
		});

		JButton no = new JButton(nb); // 이미지
		no.setBorderPainted(false); // 버튼 설정 3종
		no.setContentAreaFilled(false);
		no.setFocusPainted(false);
		no.setBounds(270, 175, 100, 50); // 위치 및 사이즈

		// 아니오 버튼 액션(무기명)
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // 사라지게 하기
			}
		});

		// 팝업에 컴포넌트들 올리기
		for (int i=0;i<3;i++) {
			background.add(text[i]);
		}
		background.add(yes);
		background.add(no);
		add(background);

		setVisible(true); // 팝업을 보여주기
	}
}