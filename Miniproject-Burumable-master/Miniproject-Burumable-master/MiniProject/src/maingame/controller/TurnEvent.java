package maingame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import maingame.model.vo.TurnButton;

public class TurnEvent implements ActionListener
{
	private MarbleManager mm = new MarbleManager();

	public void actionPerformed(ActionEvent e)
	{
		mm.turndice(); // �ֻ��� ������
		mm.diceimage(); // ���� ���� �ֻ��� �̹���
		mm.sortdice(); // �ֻ��� �� �������� ����
		mm.rank(); // �÷��̾� �ε��� ���� ��, ���� ���ϱ�

		TurnButton.tb.setVisible(false); // ������ ��ư 1�� ���� ��, �������
	}
}