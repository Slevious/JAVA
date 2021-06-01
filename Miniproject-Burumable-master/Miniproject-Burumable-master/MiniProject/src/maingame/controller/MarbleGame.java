package maingame.controller;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import maingame.model.vo.Player;
import maingame.model.vo.Stadium;

public class MarbleGame extends JFrame
{
	public static JLayeredPane jlp; // 여러 층을 쌓을 수 있는 컨테이너
	public static Player[] p = new Player[3];
	public static Stadium[] st = new Stadium[12];
	public static int[][] pst = new int[3][3]; // 플레이어 소유 구장 기록

	private MarbleManager mm = new MarbleManager();

	public MarbleGame()
	{
		jlp = new JLayeredPane();

		// 전체 틀 프레임 설정
		setTitle("니땅내땅"); // 제목
		setSize(1500, 1000); // 사이즈
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x표시 누르면 시스템 종료
		setResizable(false); // 사이즈 조정 불가
		setLocationRelativeTo(null); // 모니터 중앙에 위치

		// 플레이어, 구장 객체 생성
		for(int i=0;i<3;i++)
		{
			p[i] = new Player(null, 5000000, i+1, 0, 0, 0, 1, 1, 0);
		}

		st[0] = new Stadium("출발", 3, 0, 0, 0, 0, 0, 1);
		st[1] = new Stadium("맨체스터 United", 3, 1500000, 1500000, 0, 600000, 300000, 0);
		st[2] = new Stadium("첼시", 3, 1500000, 1500000, 0, 600000, 300000, 0);
		st[3] = new Stadium("축구게임", 3, 0, 0, 0, 0, 0, 1);
		st[4] = new Stadium("바이에른뮌헨", 3, 2000000, 2000000, 0, 800000, 400000, 0);
		st[5] = new Stadium("도르트문트", 3, 1500000, 1500000, 0, 600000, 300000, 0);
		st[6] = new Stadium("블랙홀", 3, 0, 0, 0, 0, 0, 1);
		st[7] = new Stadium("FC서울", 3, 2500000, 2500000, 0, 1000000, 500000, 0);
		st[8] = new Stadium("전북현대", 3, 2000000, 2000000, 0, 800000, 400000, 0);
		st[9] = new Stadium("축구게임", 3, 0, 0, 0, 0, 0, 1);
		st[10] = new Stadium("FC바르셀로나", 3, 2000000, 2000000, 0, 800000, 400000, 0);
		st[11] = new Stadium("레알마드리드", 3, 2000000, 2000000, 0, 800000, 400000, 0);

		mm.startpage(); // 시작 화면 실행

		add(jlp); // 컨테이너를 프레임에 올리기

		setVisible(true); // 프레임을 보여주기
	}
}