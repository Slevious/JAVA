package maingame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import maingame.model.vo.CheckButton;
import maingame.view.CheckPopup;

public class CheckEvent implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		CheckButton.cb.setVisible(false); // üũ ��ư 1�� ���� ��, �������
		
		CheckPopup cp = new CheckPopup(); // ���� ��� �˾�
	}
}