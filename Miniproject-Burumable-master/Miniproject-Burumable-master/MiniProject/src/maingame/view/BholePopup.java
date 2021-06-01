package maingame.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class BholePopup extends JDialog
{
	private ImageIcon bb = new ImageIcon("img/blackbutton.png");
	private ImageIcon bbg = new ImageIcon("img/blackbackground.png");

	public BholePopup()
	{
		// �˾� Ʋ ����
		setTitle("��Ȧ ����"); // �˾� ���� 5��
		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

		JLabel warn = new JLabel(bbg); // �̹���
		warn.setBounds(0, 0, 500, 500); // ��ġ �� ������

		JButton ok = new JButton(bb); // �̹���
		ok.setBorderPainted(false); // ��ư ���� 3��
		ok.setContentAreaFilled(false);
		ok.setFocusPainted(false);
		ok.setBounds(0, 300, 200, 100); // ��ġ �� ������

		// Ȯ�� ��ư �׼�(�����)
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // ������� �ϱ�
			}
		});

		// �˾��� ������Ʈ�� �ø���
		warn.add(ok);
		add(warn);

		setVisible(true); // �˾��� �����ֱ�
	}
}