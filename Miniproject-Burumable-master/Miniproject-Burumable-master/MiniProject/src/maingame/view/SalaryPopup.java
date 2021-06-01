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
		// �˾� Ʋ ����
		setTitle("������ ����"); // �˾� ���� 5��
		setSize(500, 280);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

		background = new JLabel(pbg); // �̹���
		background.setBounds(0, 0, 500, 280); // ��ġ �� ������

		String str1 = null;
		String str2 = String.format("%,d", MarbleGame.p[MarbleManager.pnum].getSalary());

		for (int i=0;i<3;i++)
		{
			text[i] = new JLabel(); // ����
			text[i].setFont(new Font("08���ﳲ��ü M", Font.PLAIN, 18)); // �۲�, �Ϲ�, ũ��
			text[i].setHorizontalAlignment(JLabel.CENTER); // �� ������ �������
		}

		// ������ ���� ����
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

		text[0].setText("< ������ ���� ��� >");
		text[0].setBounds(0, 40, 500, 30);
		text[1].setText(str1);
		text[1].setBounds(0, 75, 500, 30);
		text[2].setText("�� " + str2 + "���� �����ᰡ ���޵˴ϴ�.");
		text[2].setBounds(0, 110, 500, 30);

		yes = new JButton(yb); // �̹���
		yes.setBorderPainted(false); // ��ư ���� 3��
		yes.setContentAreaFilled(false);
		yes.setFocusPainted(false);
		yes.setBounds(200, 175, 100, 50); // ��ġ �� ������

		// �� ��ư �׼�(�����)
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // ������� �ϱ�

				MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()+MarbleGame.p[MarbleManager.pnum].getSalary()); // ���� ����
				mm.moneysetting(); // �� ����
			}
		});

		// �˾��� ������Ʈ�� �ø���
		for (int i=0;i<3;i++) {
			background.add(text[i]);
		}
		background.add(yes);
		add(background);

		setVisible(true); // �˾��� �����ֱ�
	}
}