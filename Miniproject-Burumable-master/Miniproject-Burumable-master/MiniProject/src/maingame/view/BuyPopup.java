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
		// �˾� Ʋ ����
		setTitle("���� �����ϱ�"); // �˾� ���� 5��
		setSize(500, 280);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

		JLabel background = new JLabel(pbg); // �̹���
		background.setBounds(0, 0, 500, 280); // ��ġ �� ������

		String str = String.format("%,d", MarbleGame.st[MarbleManager.posi].getPrice());

		JLabel[] text = new JLabel[3];
		for (int i=0;i<3;i++)
		{
			text[i] = new JLabel(); // ����
			text[i].setFont(new Font("08���ﳲ��ü M", Font.PLAIN, 18)); // �۲�, �Ϲ�, ũ��
			text[i].setHorizontalAlignment(JLabel.CENTER); // �� ������ �������
		}

		text[0].setText("���� ��ġ�� \"" + MarbleGame.st[MarbleManager.posi].getName() + "\" �Դϴ�.");
		text[0].setBounds(0, 40, 500, 30);
		text[1].setText("������ ������ " + str + "�� �Դϴ�.");
		text[1].setBounds(0, 75, 500, 30);
		text[2].setText("�����Ͻðڽ��ϱ�?");
		text[2].setBounds(0, 110, 500, 30);

		JButton yes = new JButton(yb); // �̹���
		yes.setBorderPainted(false); // ��ư ���� 3��
		yes.setContentAreaFilled(false);
		yes.setFocusPainted(false);
		yes.setBounds(130, 175, 100, 50); // ��ġ �� ������

		// �� ��ư �׼�(�����)
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // ������� �ϱ�

				if(MarbleGame.st[MarbleManager.posi].getPrice() > MarbleGame.p[MarbleManager.pnum].getMoney())
				{
					JOptionPane.showMessageDialog(MarbleGame.jlp, "������ �����մϴ�. ������ �� �����ϴ�.", "���� ���", JOptionPane.ERROR_MESSAGE);
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
								JOptionPane.showMessageDialog(MarbleGame.jlp, "������ �� �̻� ������ �� �����ϴ�.", "���� ���", JOptionPane.ERROR_MESSAGE);
								return;
							}

				MarbleGame.st[MarbleManager.posi].setOwner(MarbleManager.pnum); // ������ ����
				MarbleGame.st[MarbleManager.posi].setOwnerCheck(1); // ���� ���� ����
				MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()-MarbleGame.st[MarbleManager.posi].getPrice()); // ���� ��� ����
				MarbleGame.p[MarbleManager.pnum].setSalary(MarbleGame.p[MarbleManager.pnum].getSalary()+MarbleGame.st[MarbleManager.posi].getAdmission()); // ���� �߰�
				JOptionPane.showMessageDialog(MarbleGame.jlp, "���� �����Ͽ����ϴ�. �����մϴ�.", "���� ���", JOptionPane.INFORMATION_MESSAGE);
				
				mm.border(); // �׵θ� ����
				mm.moneysetting(); // �� ����
				mm.groundsetting(); // ���� ī�� ����
			}
		});

		JButton no = new JButton(nb); // �̹���
		no.setBorderPainted(false); // ��ư ���� 3��
		no.setContentAreaFilled(false);
		no.setFocusPainted(false);
		no.setBounds(270, 175, 100, 50); // ��ġ �� ������

		// �ƴϿ� ��ư �׼�(�����)
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // ������� �ϱ�
			}
		});

		// �˾��� ������Ʈ�� �ø���
		for (int i=0;i<3;i++) {
			background.add(text[i]);
		}
		background.add(yes);
		background.add(no);
		add(background);

		setVisible(true); // �˾��� �����ֱ�
	}
}