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
import maingame.model.vo.PBankruptcy;
import minigame.controller.SoccerGame;

public class TollPopup extends JDialog
{
	private ImageIcon pbg = new ImageIcon("img/popupbackground.png");
	private ImageIcon yb = new ImageIcon("img/yesbutton.png");
	private ImageIcon nb = new ImageIcon("img/nobutton.png");
	private ImageIcon bkr = new ImageIcon("img/boom.png");
	private MarbleManager mm = new MarbleManager();

	public TollPopup()
	{
		// �˾� Ʋ ����
		setTitle("���� ����� �� �μ��ϱ�"); // �˾� ���� 5��
		setSize(500,280);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

		JLabel background = new JLabel(pbg); // �̹���
		background.setBounds(0, 0, 500, 280); // ��ġ �� ������

		int num1 = MarbleGame.st[MarbleManager.posi].getToll(); // �����
		String str1 = String.format("%,d", num1);
		double num2 = MarbleGame.st[MarbleManager.posi].getPrice() * (MarbleGame.st[MarbleManager.posi].getTakeCount()+1) * 0.1; // �μ��� 10%�� ����
		int num3 = MarbleGame.st[MarbleManager.posi].getPrice() + (int)(num2); // �μ���
		String str2 = String.format("%,d", num3);

		JLabel[] text = new JLabel[3];
		for (int i=0;i<3;i++)
		{
			text[i] = new JLabel(); // ����
			text[i].setFont(new Font("08���ﳲ��ü M", Font.PLAIN, 18)); // �۲�, �Ϲ�, ũ��
			text[i].setHorizontalAlignment(JLabel.CENTER); // �� ������ �������
		}

		text[0].setText("���� \"" + MarbleGame.st[MarbleManager.posi].getName() + "\" �� ������ " + str1 + "�� �Դϴ�.");
		text[0].setBounds(0, 40, 500, 30);
		text[1].setText("�μ� ����� " + str2 + "�� �Դϴ�.");
		text[1].setBounds(0, 75, 500, 30);
		text[2].setText("��� �����Ͻðڽ��ϱ�?");
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

				int count = 0;

				// ������ �ִ� ���� ���� üũ
				for(int i=0;i<3;i++)
				{
					if(MarbleGame.pst[MarbleManager.pnum][i] != 0)
						count++;
				}

				// ������ 3����, no ��ư�� ������ �׼�(����Ḹ ����)
				if(count == 3)
				{
					if(MarbleGame.p[MarbleManager.pnum].getMoney() < num1) // ������ ����Ẹ�� ���� ���
					{
						if(MarbleGame.p[MarbleManager.pnum].getProperty() < num1) // ������� ����Ẹ�� ���� ���
						{
							// �Ļ�
							MarbleGame.p[MarbleManager.pnum].setStatus(0); // �Ļ� ���·� ����
							MarbleManager.finalrank[MarbleManager.personcount] = MarbleManager.pnum; // ��ũ�� ���
							MarbleManager.personcount++; // �Ļ� �ο� �߰�
							MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setMoney(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getMoney()+num1); // ����� ����
							MarbleGame.p[MarbleManager.pnum].setMoney(0); // ���� �Ҹ�

							for(int i=0;i<3;i++)
							{
								mm.nonborder(MarbleGame.pst[MarbleManager.pnum][i]); // �׵θ� ����
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwner(3); // ������ �ʱ�ȭ
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakePrice(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()); // �μ��� ���� �ʱ�ȭ
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakeCount(0); // �μ��� Ƚ�� �ʱ�ȭ
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setToll((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.4)); // ����� �ʱ�ȭ
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setAdmission((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.2)); // ������ �ʱ�ȭ
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwnerCheck(0); // ���� ���� �ʱ�ȭ
								MarbleGame.pst[MarbleManager.pnum][i] = 0; // ī�� ����
							}

							JOptionPane.showMessageDialog(MarbleGame.jlp, "�Ļ��Ͽ����ϴ�. ���ӿ� ������ �� �����ϴ�.", "����â", JOptionPane.ERROR_MESSAGE);
							PBankruptcy.pbankruptcy[MarbleManager.pnum].setIcon(bkr); // �Ļ� �̹��� ����

							if(MarbleManager.personcount == 2) // �Ļ� �ο��� 2���̸�, ���� ����
							{
								MarbleManager.gameover();
							}
						}
						else
						{
							// ����� �� �� ���� ��ŭ, ���� ���� �ȱ�
							for(int i=2;i>=0;i--)
							{
								if(MarbleGame.p[MarbleManager.pnum].getMoney() < num1)
								{
									MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()+MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getTakePrice()); // �Ǹű� �߰�
									MarbleGame.p[MarbleManager.pnum].setSalary(MarbleGame.p[MarbleManager.pnum].getSalary()-MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getAdmission()); // ���� ����
									mm.nonborder(MarbleGame.pst[MarbleManager.pnum][i]); // �׵θ� ����
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwner(3); // ������ �ʱ�ȭ
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakePrice(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()); // �μ��� ���� �ʱ�ȭ
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakeCount(0); // �μ��� Ƚ�� �ʱ�ȭ
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setToll((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.4)); // ����� �ʱ�ȭ
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setAdmission((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.2)); // ������ �ʱ�ȭ
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwnerCheck(0); // ���� ���� �ʱ�ȭ
									MarbleGame.pst[MarbleManager.pnum][i] = 0; // ī�� ����
								}
							}

							// ����Ḹ ����
							MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setMoney(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getMoney()+num1); // ����� ����
							MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()-num1); // ����� ����

							JOptionPane.showMessageDialog(MarbleGame.jlp, "������ ������ �Ⱦ�, ����Ḧ �����մϴ�.", "����â", JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						// ����Ḹ ����
						MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setMoney(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getMoney()+num1); // ����� ����
						MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()-num1); // ����� ����

						JOptionPane.showMessageDialog(MarbleGame.jlp, "�̹� ������ ������ 3���Դϴ�. ����Ḹ �ΰ��մϴ�.", "����â", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					if(MarbleGame.p[MarbleManager.pnum].getMoney() < num1+num3) // ������ �����+�μ��񺸴� ���� ���
					{
						if(MarbleGame.p[MarbleManager.pnum].getMoney() < num1) // ������ ����Ẹ�� ���� ���
						{
							if(MarbleGame.p[MarbleManager.pnum].getProperty() < num1)  // ������� ����Ẹ�� ���� ���
							{
								// �Ļ�
								MarbleGame.p[MarbleManager.pnum].setStatus(0); // �Ļ� ���·� ����
								MarbleManager.finalrank[MarbleManager.personcount] = MarbleManager.pnum; // ��ũ�� ���
								MarbleManager.personcount++; // �Ļ� �ο� �߰�
								MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setMoney(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getMoney()+num1); // ����� ����
								MarbleGame.p[MarbleManager.pnum].setMoney(0); // ��� �Ҹ�

								for(int i=0;i<3;i++)
								{
									mm.nonborder(MarbleGame.pst[MarbleManager.pnum][i]); // �׵θ� ����
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwner(3); // ������ �ʱ�ȭ
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakePrice(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()); // �μ��� ���� �ʱ�ȭ
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakeCount(0); // �μ��� Ƚ�� �ʱ�ȭ
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setToll((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.4)); // ����� �ʱ�ȭ
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setAdmission((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.2)); // ������ �ʱ�ȭ
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwnerCheck(0); // ���� ���� �ʱ�ȭ
									MarbleGame.pst[MarbleManager.pnum][i] = 0; // ī�� ����
								}

								JOptionPane.showMessageDialog(MarbleGame.jlp, "�Ļ��Ͽ����ϴ�. ���ӿ� ������ �� �����ϴ�.", "����â", JOptionPane.ERROR_MESSAGE);
								PBankruptcy.pbankruptcy[MarbleManager.pnum].setIcon(bkr); // �Ļ� �̹��� ����

								if(MarbleManager.personcount == 2) // �Ļ� �ο��� 2���̸�, ���� ����
								{
									MarbleManager.gameover();
								}
							}
							else
							{
								// ����� �� �� ���� ��ŭ, ���� ���� �ȱ�
								for(int i=2;i>=0;i--)
								{
									if(MarbleGame.p[MarbleManager.pnum].getMoney() < num1)
									{
										MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()+MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getTakePrice()); // �Ǹű� �߰�
										MarbleGame.p[MarbleManager.pnum].setSalary(MarbleGame.p[MarbleManager.pnum].getSalary()-MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getAdmission()); // ���� ����
										mm.nonborder(MarbleGame.pst[MarbleManager.pnum][i]); // �׵θ� ����
										MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwner(3); // ������ �ʱ�ȭ
										MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakePrice(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()); // �μ��� ���� �ʱ�ȭ
										MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakeCount(0); // �μ��� Ƚ�� �ʱ�ȭ
										MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setToll((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.4)); // ����� �ʱ�ȭ
										MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setAdmission((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.2)); // ������ �ʱ�ȭ
										MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwnerCheck(0); // ���� ���� �ʱ�ȭ
										MarbleGame.pst[MarbleManager.pnum][i] = 0; // ī�� ����
									}
								}

								// ����Ḹ ����
								MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setMoney(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getMoney()+num1); // ����� ����
								MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()-num1); // ����� ����

								JOptionPane.showMessageDialog(MarbleGame.jlp, "������ ������ �Ⱦ�, ����Ḧ �����մϴ�.", "����â", JOptionPane.ERROR_MESSAGE);
							}
						}
						else
						{
							// ����Ḹ ����
							MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setMoney(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getMoney()+num1); // ����� ����
							MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()-num1); // ����� ����

							JOptionPane.showMessageDialog(MarbleGame.jlp, "������ �����Ͽ� �μ��� �� �����ϴ�. ����Ḹ ���� ���εǾ����ϴ�.", "����â", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else
					{
						// ����� ���� �� �μ� ����
						MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setMoney(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getMoney()+num1+num3); // �����+�μ��� ����
						MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setSalary(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getSalary()-MarbleGame.st[MarbleManager.posi].getAdmission()); // ���� ����
						// ī�� ����
						for(int i=0;i<3;i++)
						{
							if(MarbleGame.pst[MarbleGame.st[MarbleManager.posi].getOwner()][i] == MarbleManager.posi)
							{
								MarbleGame.pst[MarbleGame.st[MarbleManager.posi].getOwner()][i] = 0;
								break;
							}
						}

						MarbleGame.st[MarbleManager.posi].setOwner(MarbleManager.pnum); // ������ ����
						MarbleGame.st[MarbleManager.posi].setTakePrice(num3); // �μ��� ���� ����
						MarbleGame.st[MarbleManager.posi].setTakeCount(MarbleGame.st[MarbleManager.posi].getTakeCount()+1); // �μ��� Ƚ�� ����
						MarbleGame.st[MarbleManager.posi].setToll((int)(MarbleGame.st[MarbleManager.posi].getTakePrice()*0.4)); // ����� ����
						MarbleGame.st[MarbleManager.posi].setAdmission((int)(MarbleGame.st[MarbleManager.posi].getTakePrice()*0.2)); // ������ ����
						MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()-num1-num3); // �����+�μ��� ����
						MarbleGame.p[MarbleManager.pnum].setSalary(MarbleGame.p[MarbleManager.pnum].getSalary()+MarbleGame.st[MarbleManager.posi].getAdmission()); // ���� �߰�
						mm.border(); // �׵θ� ����
						MarbleGame.pst[MarbleManager.pnum][count] = MarbleManager.posi; // ī�� �߰�

						JOptionPane.showMessageDialog(MarbleGame.jlp, "���� �μ��Ǿ����ϴ�.", "����â", JOptionPane.INFORMATION_MESSAGE);
					}
				}

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

				if(MarbleGame.p[MarbleManager.pnum].getMoney() < num1) // ������ ����Ẹ�� ���� ���
				{
					if(MarbleGame.p[MarbleManager.pnum].getProperty() < num1) // ������� ����Ẹ�� ���� ���
					{
						// �Ļ�
						MarbleGame.p[MarbleManager.pnum].setStatus(0); // �Ļ� ���·� ����
						MarbleManager.finalrank[MarbleManager.personcount] = MarbleManager.pnum; // ��ũ�� ���
						MarbleManager.personcount++; // �Ļ� �ο� �߰�
						MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setMoney(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getMoney()+num1); // ����� ����
						MarbleGame.p[MarbleManager.pnum].setMoney(0); // ��� �Ҹ�

						for(int i=0;i<3;i++)
						{
							mm.nonborder(MarbleGame.pst[MarbleManager.pnum][i]); // �׵θ� ����
							MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwner(3); // ������ �ʱ�ȭ
							MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakePrice(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()); // �μ��� ���� �ʱ�ȭ
							MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakeCount(0); // �μ��� Ƚ�� �ʱ�ȭ
							MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setToll((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.4)); // ����� �ʱ�ȭ
							MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setAdmission((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.2)); // ������ �ʱ�ȭ
							MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwnerCheck(0); // ���� ���� �ʱ�ȭ
							MarbleGame.pst[MarbleManager.pnum][i] = 0; // ī�� ����
						}

						JOptionPane.showMessageDialog(MarbleGame.jlp, "�Ļ��Ͽ����ϴ�. ���ӿ� ������ �� �����ϴ�.", "����â", JOptionPane.ERROR_MESSAGE);
						PBankruptcy.pbankruptcy[MarbleManager.pnum].setIcon(bkr); // �Ļ� �̹��� ����

						if(MarbleManager.personcount == 2) // �Ļ� �ο��� 2���̸�, ���� ����
						{
							MarbleManager.gameover();
						}
					}
					else
					{
						// ����� �� �� ���� ��ŭ, ���� ���� �ȱ�
						for(int i=2;i>=0;i--)
						{
							if(MarbleGame.p[MarbleManager.pnum].getMoney() < num1)
							{
								MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()+MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getTakePrice()); // �Ǹű� �߰�
								MarbleGame.p[MarbleManager.pnum].setSalary(MarbleGame.p[MarbleManager.pnum].getSalary()-MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getAdmission()); // ���� ����
								mm.nonborder(MarbleGame.pst[MarbleManager.pnum][i]); // �׵θ� ����
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwner(3); // ������ �ʱ�ȭ
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakePrice(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()); // �μ��� ���� �ʱ�ȭ
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakeCount(0); // �μ��� Ƚ�� �ʱ�ȭ
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setToll((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.4)); // ����� �ʱ�ȭ
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setAdmission((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.2)); // ������ �ʱ�ȭ
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwnerCheck(0); // ���� ���� �ʱ�ȭ
								MarbleGame.pst[MarbleManager.pnum][i] = 0; // ī�� ����
							}
						}

						// ����Ḹ ����
						MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setMoney(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getMoney()+num1); // ����� ����
						MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()-num1); // ����� ����

						JOptionPane.showMessageDialog(MarbleGame.jlp, "������ ������ �Ⱦ�, ����Ḧ �����մϴ�.", "����â", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					// ����Ḹ ����
					MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setMoney(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getMoney()+num1); // ����� ����
					MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()-num1); // ����� ����

					JOptionPane.showMessageDialog(MarbleGame.jlp, "����ᰡ ���� ���εǾ����ϴ�.", "����â", JOptionPane.INFORMATION_MESSAGE);
				}

				mm.moneysetting(); // �� ����
				mm.groundsetting(); // ���� ī�� ����
			}
		});

		// �˾��� ������Ʈ�� �ø���
		for (int i=0;i<3;i++)
		{
			background.add(text[i]);
		}
		background.add(yes);
		background.add(no);
		add(background);

		setVisible(true); // �˾��� �����ֱ�
	}
}