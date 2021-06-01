package maingame.controller;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import maingame.model.vo.Player;
import maingame.model.vo.Stadium;

public class MarbleGame extends JFrame
{
	public static JLayeredPane jlp; // ���� ���� ���� �� �ִ� �����̳�
	public static Player[] p = new Player[3];
	public static Stadium[] st = new Stadium[12];
	public static int[][] pst = new int[3][3]; // �÷��̾� ���� ���� ���

	private MarbleManager mm = new MarbleManager();

	public MarbleGame()
	{
		jlp = new JLayeredPane();

		// ��ü Ʋ ������ ����
		setTitle("�϶�����"); // ����
		setSize(1500, 1000); // ������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // xǥ�� ������ �ý��� ����
		setResizable(false); // ������ ���� �Ұ�
		setLocationRelativeTo(null); // ����� �߾ӿ� ��ġ

		// �÷��̾�, ���� ��ü ����
		for(int i=0;i<3;i++)
		{
			p[i] = new Player(null, 5000000, i+1, 0, 0, 0, 1, 1, 0);
		}

		st[0] = new Stadium("���", 3, 0, 0, 0, 0, 0, 1);
		st[1] = new Stadium("��ü���� United", 3, 1500000, 1500000, 0, 600000, 300000, 0);
		st[2] = new Stadium("ÿ��", 3, 1500000, 1500000, 0, 600000, 300000, 0);
		st[3] = new Stadium("�౸����", 3, 0, 0, 0, 0, 0, 1);
		st[4] = new Stadium("���̿�������", 3, 2000000, 2000000, 0, 800000, 400000, 0);
		st[5] = new Stadium("����Ʈ��Ʈ", 3, 1500000, 1500000, 0, 600000, 300000, 0);
		st[6] = new Stadium("��Ȧ", 3, 0, 0, 0, 0, 0, 1);
		st[7] = new Stadium("FC����", 3, 2500000, 2500000, 0, 1000000, 500000, 0);
		st[8] = new Stadium("��������", 3, 2000000, 2000000, 0, 800000, 400000, 0);
		st[9] = new Stadium("�౸����", 3, 0, 0, 0, 0, 0, 1);
		st[10] = new Stadium("FC�ٸ����γ�", 3, 2000000, 2000000, 0, 800000, 400000, 0);
		st[11] = new Stadium("���˸��帮��", 3, 2000000, 2000000, 0, 800000, 400000, 0);

		mm.startpage(); // ���� ȭ�� ����

		add(jlp); // �����̳ʸ� �����ӿ� �ø���

		setVisible(true); // �������� �����ֱ�
	}
}