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
		// �˾� Ʋ ����
		setTitle("���� ���"); // ����(������ �˾� ���� 5��)
		setSize(300, 300); // �˾� ������
		setResizable(false); // ������ ���� �Ұ�
		setLocationRelativeTo(null); // ����� �߾ӿ� ��ġ
		setLayout(null); // ���밪 ���� ���̾ƿ�

		JLabel[] num = new JLabel[3];
		JLabel[] rank = new JLabel[3];
		for(int i=0;i<3;i++)
		{
			num[i] = new JLabel(); // ����
			num[i].setHorizontalAlignment(JLabel.CENTER); // �� ������ �������
			num[i].setFont(new Font("08���ﳲ��ü M", Font.BOLD, 30)); // �۲�, ����, ũ��

			rank[i] = new JLabel(NameLabel.nl[MarbleManager.ranking[i]].getText()); // ������ �´� �̸� �ֱ�
			rank[i].setHorizontalAlignment(JLabel.CENTER); // �� ������ �������
			rank[i].setFont(new Font("08���ﳲ��ü M", Font.PLAIN, 20)); // �۲�, �Ϲ�, ũ��
			
			MarbleGame.p[i].setName(NameLabel.nl[MarbleManager.ranking[i]].getText()); // �÷��̾� ��ü�� �̸� �ֱ�
		}
		num[0].setText("1�� : ");
		num[1].setText("2�� : ");
		num[2].setText("3�� : ");

		JButton start = new JButton(s); // �̹���
		start.setBorderPainted(false); // ��ư ���� 3��
		start.setContentAreaFilled(false);
		start.setFocusPainted(false);
		start.setRolloverIcon(s1); // ��ư ���� ���콺�� �ö����, �׵θ��� ���� �ٸ� �̹����� ����

		num[0].setBounds(30, 30, 100, 30); // ��ġ �� ������
		num[1].setBounds(30, 100, 100, 30);
		num[2].setBounds(30, 170, 100, 30);
		rank[0].setBounds(150, 30, 100, 30);
		rank[1].setBounds(150, 100, 100, 30);
		rank[2].setBounds(150, 170, 100, 30);
		start.setBounds(60, 210, 180, 50);

		// �˾��� ������Ʈ�� �ø���
		for(int i=0;i<rank.length;i++)
		{
			add(num[i]);
			add(rank[i]);
		}
		add(start);

		// ���� ��ư �׼�(�����)
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // ������� �ϱ�

				mm.mainpage(); // ���� ȭ�� ����
			}
		});

		setVisible(true); // �˾��� �����ֱ�
	}
}