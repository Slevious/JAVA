package maingame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpinEvent implements ActionListener
{
	private MarbleManager mm = new MarbleManager();

	public void actionPerformed(ActionEvent e)
	{
		mm.spindice(); // �ֻ��� ������ �޼ҵ�
		mm.pdiceimage(); // ���� ���� �ֻ��� �̹���
		mm.game(); // ���� ����
	}
}