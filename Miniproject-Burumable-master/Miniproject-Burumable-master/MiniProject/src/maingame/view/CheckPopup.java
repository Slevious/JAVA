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
import maingame.model.vo.Player;

public class CheckPopup extends JDialog
{
	private ImageIcon s = new ImageIcon("img/start.png");
	private ImageIcon s1 = new ImageIcon("img/start_1.png");
	private MarbleManager mm = new MarbleManager();

	public CheckPopup()
	{
		// 팝업 틀 설정
		setTitle("순서 결과"); // 제목(앞으로 팝업 설정 5종)
		setSize(300, 300); // 팝업 사이즈
		setResizable(false); // 사이즈 조정 불가
		setLocationRelativeTo(null); // 모니터 중앙에 위치
		setLayout(null); // 절대값 지정 레이아웃

		JLabel[] num = new JLabel[3];
		JLabel[] rank = new JLabel[3];
		for(int i=0;i<3;i++)
		{
			num[i] = new JLabel(); // 생성
			num[i].setHorizontalAlignment(JLabel.CENTER); // 라벨 내에서 가운데정렬
			num[i].setFont(new Font("08서울남산체 M", Font.BOLD, 30)); // 글꼴, 굵게, 크기

			rank[i] = new JLabel(NameLabel.nl[MarbleManager.ranking[i]].getText()); // 순서에 맞는 이름 넣기
			rank[i].setHorizontalAlignment(JLabel.CENTER); // 라벨 내에서 가운데정렬
			rank[i].setFont(new Font("08서울남산체 M", Font.PLAIN, 20)); // 글꼴, 일반, 크기
			
			MarbleGame.p[i].setName(NameLabel.nl[MarbleManager.ranking[i]].getText()); // 플레이어 객체에 이름 넣기
		}
		num[0].setText("1등 : ");
		num[1].setText("2등 : ");
		num[2].setText("3등 : ");

		JButton start = new JButton(s); // 이미지
		start.setBorderPainted(false); // 버튼 설정 3종
		start.setContentAreaFilled(false);
		start.setFocusPainted(false);
		start.setRolloverIcon(s1); // 버튼 위로 마우스가 올라오면, 테두리가 생긴 다른 이미지로 변경

		num[0].setBounds(30, 30, 100, 30); // 위치 및 사이즈
		num[1].setBounds(30, 100, 100, 30);
		num[2].setBounds(30, 170, 100, 30);
		rank[0].setBounds(150, 30, 100, 30);
		rank[1].setBounds(150, 100, 100, 30);
		rank[2].setBounds(150, 170, 100, 30);
		start.setBounds(60, 210, 180, 50);

		// 팝업에 컴포넌트들 올리기
		for(int i=0;i<rank.length;i++)
		{
			add(num[i]);
			add(rank[i]);
		}
		add(start);

		// 시작 버튼 액션(무기명)
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // 사라지게 하기

				mm.mainpage(); // 메인 화면 실행
			}
		});

		setVisible(true); // 팝업을 보여주기
	}
}