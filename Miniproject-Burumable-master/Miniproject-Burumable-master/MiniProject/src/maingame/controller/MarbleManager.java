package maingame.controller;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import maingame.model.vo.FinalBackground;
import maingame.model.vo.MainBackground;
import maingame.model.vo.PBankruptcy;
import maingame.model.vo.PBorder;
import maingame.model.vo.PDice;
import maingame.model.vo.PFlag;
import maingame.model.vo.PFlagmove;
import maingame.model.vo.PGround;
import maingame.model.vo.PMoney;
import maingame.model.vo.PName;
import maingame.model.vo.PRank;
import maingame.model.vo.PTurn;
import maingame.model.vo.SpinButton;
import maingame.model.vo.StartBackground;
import maingame.model.vo.StartButton;
import maingame.view.BholePopup;
import maingame.view.BuyPopup;
import maingame.view.Dice;
import maingame.view.NameField;
import maingame.view.SalaryPopup;
import maingame.view.TollPopup;
import minigame.controller.SoccerGame;

public class MarbleManager
{
	public static int[] ranking = new int[3]; // ���� �ε��� ���� ����� �迭
	public static int pnum = 0; // ���� ���� �÷��̾� ��ȣ
	public static int posi = 0; // ���� ��ġ
	public static int personcount = 0; // �Ļ��� ��� ��
	public static int[] finalrank = new int[3]; // ���� ��ŷ�� ���� ���� �迭

	static int[] pdicenum = new int[2];  // ���� �ֻ��� ���� ���� ����� �迭
	static int startIndex;
	static int endIndex;
	static int moveIndex;

	private ImageIcon y = new ImageIcon("img/yellow.png");
	private ImageIcon b = new ImageIcon("img/blue.png");
	private ImageIcon g = new ImageIcon("img/green.png");
	private int[] dicenum = new int[3]; // ���� ���ϴ� �ֻ��� ���� ���� ����� �迭
	private int[] dicenum_copy = new int[3]; // �ֻ��� ���� ���� ���� �޾�, ������������ ������ �迭
	private int turnnum = 1; // ���� ��

	public void startpage()
	{
		StartBackground sbg = new StartBackground();
		NameField nf = new NameField();
		StartButton sb = new StartButton();
	}

	public void turndice() // 1~6���� �ߺ����� 3�� �� �����Ͽ� �迭�� �ֱ�
	{
		int num = 0;
		boolean result = true;

		for(int i=0;i<3;i++)
		{
			num = (int)(Math.random()*6+1);

			for(int j=0;j<=i;j++)
			{
				if(dicenum[j] == num)
				{
					i = i-1;
					result = false;
					break;
				}
			}

			if(result)
				dicenum[i] = num;
			else
				result = true;
		}
	}

	public void diceimage()
	{
		ImageIcon d_2 = new ImageIcon("img/dice_2.png");
		ImageIcon d_1 = new ImageIcon("img/dice_1.png");
		ImageIcon d = new ImageIcon("img/dice.png");
		ImageIcon d1 = new ImageIcon("img/dice1.png");
		ImageIcon d2 = new ImageIcon("img/dice2.png");
		ImageIcon d3 = new ImageIcon("img/dice3.png");

		for(int i=0;i<3;i++) 
		{
			switch(dicenum[i])
			{
			case 1:
				Dice.d[i].setIcon(d_2); // �ֻ��� -2
				break;
			case 2:
				Dice.d[i].setIcon(d_1); // �ֻ��� -1
				break;
			case 3:
				Dice.d[i].setIcon(d); // �ֻ��� 0
				break;
			case 4:
				Dice.d[i].setIcon(d1); // �ֻ��� 1
				break;
			case 5:
				Dice.d[i].setIcon(d2); // �ֻ��� 2
				break;
			case 6:
				Dice.d[i].setIcon(d3); // �ֻ��� 3
				break;
			}
		}
	}

	public void sortdice()
	{
		int tmp = 0;

		System.arraycopy(dicenum, 0, dicenum_copy, 0, 3);

		for(int i=0;i<3;i++)
		{
			for(int j=i+1;j<3;j++)
			{
				if(dicenum_copy[i] < dicenum_copy[j])
				{
					tmp = dicenum_copy[i];
					dicenum_copy[i] = dicenum_copy[j];
					dicenum_copy[j] = tmp;
				}
			}
		}
	}

	public void rank() // �� �迭�� ���Ͽ�, ���� ���� ���� ���� �ε����� ����
	{
		int index = 0;

		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(dicenum_copy[i] == dicenum[j])
				{
					ranking[index] = j;
					index++;
					break;
				}
			}
		}
	}

	public void mainpage()
	{		
		MainBackground mb = new MainBackground();
		PTurn tl = new PTurn();
		PName pn = new PName();
		PMoney pm = new PMoney();
		PGround pg = new PGround();
		PFlag pf = new PFlag();
		PDice pd = new PDice();
		SpinButton sb = new SpinButton();
		PFlagmove pfm = new PFlagmove();
		PBorder pb = new PBorder();
		PBankruptcy pbr = new PBankruptcy();

		turnsetting(); // �Ͽ� �°� �ʷϺ�
		moneysetting(); // �� ����
		groundsetting(); // ���� ī�� ����
	}

	public void turnsetting()
	{
		ImageIcon c = new ImageIcon("img/clear.png");
		ImageIcon tl = new ImageIcon("img/turnlight.png");

		for(int i=0;i<3;i++)
		{
			PTurn.pturn[i].setIcon(c); // ���� ��� �ʱ�ȭ
		}

		if(turnnum > 3)
			turnnum -= 3;

		if(MarbleGame.p[turnnum-1].getStatus() == 0) // �Ļ��� �÷��̾ �ִٸ� �� �Ѿ��
			turnnum++;

		if(turnnum > 3)
			turnnum -= 3;

		PTurn.pturn[turnnum-1].setIcon(tl); // �Ͽ� ���� �� �ѱ�
	}

	public void moneysetting()
	{
		for(int i=0;i<3;i++)
		{
			String str = String.format("%,d", MarbleGame.p[i].getMoney());
			PMoney.pmoney[i].setText(str);
		}
	}

	public void groundsetting()
	{
		ImageIcon cd = new ImageIcon("img/card.png");
		ImageIcon cd1 = new ImageIcon("img/card1.png");
		ImageIcon cd2 = new ImageIcon("img/card2.png");
		ImageIcon cd4 = new ImageIcon("img/card4.png");
		ImageIcon cd5 = new ImageIcon("img/card5.png");
		ImageIcon cd7 = new ImageIcon("img/card7.png");
		ImageIcon cd8 = new ImageIcon("img/card8.png");
		ImageIcon cd10 = new ImageIcon("img/card10.png");
		ImageIcon cd11 = new ImageIcon("img/card11.png");

		int tmp = 0;

		for(int i=0;i<3;i++) // ������������ ����
		{
			for(int j=0;j<2;j++)
			{
				if(MarbleGame.pst[i][j] < MarbleGame.pst[i][j+1])
				{
					tmp = MarbleGame.pst[i][j];
					MarbleGame.pst[i][j] = MarbleGame.pst[i][j+1];
					MarbleGame.pst[i][j+1] = tmp;
				}
			}

			if(MarbleGame.pst[i][0] < MarbleGame.pst[i][1])
			{
				tmp = MarbleGame.pst[i][0];
				MarbleGame.pst[i][0] = MarbleGame.pst[i][1];
				MarbleGame.pst[i][1] = tmp;
			}
		}

		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{

				switch(MarbleGame.pst[i][j])
				{
				case 0:
					PGround.pground[i][j].setIcon(cd);
					break;
				case 1:
					PGround.pground[i][j].setIcon(cd1);
					break;
				case 2:
					PGround.pground[i][j].setIcon(cd2);
					break;
				case 4:
					PGround.pground[i][j].setIcon(cd4);
					break;
				case 5:
					PGround.pground[i][j].setIcon(cd5);
					break;
				case 7:
					PGround.pground[i][j].setIcon(cd7);
					break;
				case 8:
					PGround.pground[i][j].setIcon(cd8);
					break;
				case 10:
					PGround.pground[i][j].setIcon(cd10);
					break;
				case 11:
					PGround.pground[i][j].setIcon(cd11);
					break;
				}
			}
		}
	}

	public void spindice() // 1~6���� �ߺ����� 2�� �� �����Ͽ� �迭�� �ֱ�
	{
		int num = 0;
		boolean result = true;

		for(int i=0;i<2;i++)
		{
			num = (int)(Math.random()*6+1);

			for(int j=0;j<=i;j++)
			{
				if(pdicenum[j] == num)
				{
					i = i-1;
					result = false;
					break;
				}
			}

			if(result)
				pdicenum[i] = num;
			else
				result = true;
		}
	}

	public void pdiceimage()
	{
		ImageIcon d_2 = new ImageIcon("img/dice_2.png");
		ImageIcon d_1 = new ImageIcon("img/dice_1.png");
		ImageIcon d = new ImageIcon("img/dice.png");
		ImageIcon d1 = new ImageIcon("img/dice1.png");
		ImageIcon d2 = new ImageIcon("img/dice2.png");
		ImageIcon d3 = new ImageIcon("img/dice3.png");

		for(int i=0;i<2;i++) 
		{
			switch(pdicenum[i])
			{
			case 1:
				PDice.pdice[i].setIcon(d_2); // �ֻ��� -2
				break;
			case 2:
				PDice.pdice[i].setIcon(d_1); // �ֻ��� -1
				break;
			case 3:
				PDice.pdice[i].setIcon(d); // �ֻ��� 0
				break;
			case 4:
				PDice.pdice[i].setIcon(d1); // �ֻ��� 1
				break;
			case 5:
				PDice.pdice[i].setIcon(d2); // �ֻ��� 2
				break;
			case 6:
				PDice.pdice[i].setIcon(d3); // �ֻ��� 3
				break;
			}
		}
	}

	public void game()
	{
		pnum = turncheck(); // ���� ���� �÷��̾� �˷��ֱ�
		int dnum = MarbleGame.p[pnum].getPosition() + pdicenum[0] + pdicenum[1] - 6; // ���� ��ġ���� �ֻ��� ���� ��ģ ���

		startIndex = MarbleGame.p[pnum].getPosition();
		endIndex = dnum;

		if(MarbleGame.p[pnum].getBlack()==1 && MarbleGame.p[pnum].getStatus()==1) // ��Ȧ�� �����ų� �Ļ��� ��찡 �ƴ� �������� �÷���
		{
			posicheck(dnum); // �̵��� ��ġ üũ

			horsemove(); // �� �̵�

			stadiumcheck(); // ������ ��ġ�� ����, ���� ��Ȳ �߻�

			sumproperty(); // �÷��̾� �� ��� ���
		}
		else
			if(MarbleGame.p[pnum].getBlack() == 0) // ��Ȧ���� 1�� ����
			{
				MarbleGame.p[pnum].setBlack(1);

				JOptionPane.showMessageDialog(MarbleGame.jlp, "���� �Ϻ��� ���� �����մϴ�.", "����â", JOptionPane.ERROR_MESSAGE);
			}

		turnsetting(); // �Ͽ� �°� �ʷϺ�
		
		
	}

	public int turncheck()
	{
		int num = 0;

		for(int i=0;i<3;i++)
		{
			if(turnnum == MarbleGame.p[i].getTurn())
			{
				num = i;
				break;
			}
		}

		turnnum++;

		return num;
	}

	public void posicheck(int dnum)
	{	
		ImageIcon c = new ImageIcon("img/clear.png");

		PFlag.pflag[pnum][MarbleGame.p[pnum].getPosition()].setIcon(c); // ���� ��ġ �� ������

		if(MarbleGame.p[pnum].getRound() == 0) // ���� 1������ �� ������ ��
		{
			if(dnum <= 0) // 0 ���� ���ڰ� ������ �������� �ʴ´�.
				MarbleGame.p[pnum].setPosition(0);
			else
				if(dnum > 11)
				{
					dnum -= 12; // �� ������ �Ѿ ���
					MarbleGame.p[pnum].setRound(MarbleGame.p[pnum].getRound()+1); // ���� �߰�
					MarbleGame.p[pnum].setPosition(dnum);
					
					if(MarbleGame.p[pnum].getRound() == 2) // ������ 2������ ���� �����ϸ�, ���� ����
					{
						gameover();
						return;
					}
					
					SalaryPopup sp = new SalaryPopup(); // �� ������ �߰��Ǹ�, ������ ���� �˾�
				}
				else
					MarbleGame.p[pnum].setPosition(dnum);
		}
		else
			if(dnum > 11)
			{
				dnum -= 12; // �� ������ �Ѿ ���
				MarbleGame.p[pnum].setRound(MarbleGame.p[pnum].getRound()+1); // ���� �߰�
				MarbleGame.p[pnum].setPosition(dnum);
				
				if(MarbleGame.p[pnum].getRound() == 2) // ������ 2������ ���� �����ϸ�, ���� ����
				{
					gameover();
					return;
				}
				
				SalaryPopup sp = new SalaryPopup(); // �� ������ �߰��Ǹ�, ������ ���� �˾�
			}
			else
				if(dnum == 0) // ������� ���
				{
					MarbleGame.p[pnum].setRound(MarbleGame.p[pnum].getRound()+1); // ���� �߰�
					MarbleGame.p[pnum].setPosition(dnum);
					
					if(MarbleGame.p[pnum].getRound() == 2) // ������ 2������ ���� �����ϸ�, ���� ����
					{
						gameover();
						return;
					}
					
					SalaryPopup sp = new SalaryPopup(); // �� ������ �߰��Ǹ�, ������ ���� �˾�
				}
				else
					if(dnum < 0)
					{
						dnum += 12; // �ڷ� �� ���
						MarbleGame.p[pnum].setPosition(dnum);
					}
					else
						MarbleGame.p[pnum].setPosition(dnum);
	}

	public void horsemove()
	{
		posi = MarbleGame.p[pnum].getPosition();

		if(pnum == 0)
		{
			PFlag.pflag[0][posi].setIcon(y);
			PFlagmove.pflagmove.setIcon(y);
		}
		else
			if(pnum == 1)
			{
				PFlag.pflag[1][posi].setIcon(b);
				PFlagmove.pflagmove.setIcon(b);
			}
			else 
				if(pnum == 2)
				{
					PFlag.pflag[2][posi].setIcon(g);
					PFlagmove.pflagmove.setIcon(g);
				}

		(new FlagThread()).start();
	}

	public static void gameover()
	{
		FinalBackground fb = new FinalBackground();
		PRank pr = new PRank();

		finalrank[2] = pnum; // 2������ ������ �Ǵ� �Ļ����� ���� ���� �÷��̾ 1��

		if(personcount == 0) // �Ļ��� ��� ����, ������ 2������ ���� ������ ���
		{
			int[] sort = new int[2];
			int index = 0;

			finalrank[2] = pnum; // 2������ ������ ���� �÷��̾ 1��

			// 1�� �÷��̾� ������ �ٸ� �÷��̾� �ε��� ����
			for(int i=0;i<3;i++)
			{
				if(i != pnum)
				{
					sort[index] = i;
					index++;
				}
			}

			// ������� ���� ����� ����
			// -> ���� ������� ���ٸ�, �÷��̾� �� ������ �������� �� ���� ������ ����
			if(MarbleGame.p[sort[0]].getProperty() >= MarbleGame.p[sort[1]].getProperty())
			{
				int tmp = sort[0];
				sort[0] = sort[1];
				sort[1] = tmp;
			}

			// ���� ��ŷ �迭�� �ֱ�
			for(int i=1;i>=0;i--)
			{
				finalrank[i] = sort[i];
			}
		}
		else
			if(personcount == 1) // �Ļ��� ��� 1��, ������ 2�� �߿��� 2������ ������ ������ ���
			{
				finalrank[2] = pnum; // 2������ ������ ���� �÷��̾ 1��

				// �Ļ� 1��, 1�� �÷��̾� ������ �ٸ� �÷��̾� �ε��� ����
				for(int i=0;i<3;i++)
				{
					if(i!=pnum && i!=finalrank[0])
					{
						finalrank[1] = i;
						break;
					}
				}
			}
			else
				if(personcount == 2) // �Ļ��� ��� 2��
				{
					// �Ļ� 2���� ������ 1�� �÷��̾� �ε��� ����
					for(int i=0;i<3;i++)
					{
						if(i!=finalrank[0] && i!=finalrank[1])
						{
							finalrank[2] = i;
							break;
						}
					}
				}

		// �������� ���� ���
		for(int i=2;i>=0;i--)
		{
			pr.prank[i].setText(MarbleGame.p[finalrank[i]].getName());
		}
	}

	public void stadiumcheck()
	{
		if(MarbleGame.st[posi].getOwnerCheck()==0 && posi!=0)
		{
			BuyPopup bp = new BuyPopup(); // ���� �����ϱ� �˾�
		}
		else
			if(posi==3 || posi==9)
			{
				SoccerGame sc = new SoccerGame(); // �౸ ���� ����
			}
			else
				if(posi == 6)
				{
					MarbleGame.p[pnum].setBlack(0); // ������ ���� 0���� �����

					BholePopup bp = new BholePopup(); // ��Ȧ ���� �˾�
				}
				else
					if(MarbleGame.st[posi].getOwner()!=pnum && posi!=0)
					{
						TollPopup tp = new TollPopup(); // ���� ����� �� �μ��ϱ� �˾�
					}
	}

	public void border()
	{
		ImageIcon yb = new ImageIcon("img/yellow_border.png");
		ImageIcon yb2 = new ImageIcon("img/yellow_border2.png");
		ImageIcon bb = new ImageIcon("img/blue_border.png");
		ImageIcon bb2 = new ImageIcon("img/blue_border2.png");
		ImageIcon gb = new ImageIcon("img/green_border.png");
		ImageIcon gb2 = new ImageIcon("img/green_border2.png");

		if(pnum == 0)
		{
			switch(MarbleGame.p[pnum].getPosition()) 
			{
			case 1 : case 2 : case 7 : case 8 :
				PBorder.pborder[MarbleGame.p[pnum].getPosition()].setIcon(yb);
				break;
			case 4 : case 5 : case 10 : case 11 :
				PBorder.pborder[MarbleGame.p[pnum].getPosition()].setIcon(yb2);
				break;
			}
		}
		else
			if(pnum == 1)
			{
				switch(MarbleGame.p[pnum].getPosition()) 
				{
				case 1 : case 2 : case 7 : case 8 :
					PBorder.pborder[MarbleGame.p[pnum].getPosition()].setIcon(bb);
					break;
				case 4 : case 5 : case 10 : case 11 :
					PBorder.pborder[MarbleGame.p[pnum].getPosition()].setIcon(bb2);
					break;
				}
			}
			else
				if(pnum == 2)
				{
					switch(MarbleGame.p[pnum].getPosition()) 
					{
					case 1 : case 2 : case 7 : case 8 :
						PBorder.pborder[MarbleGame.p[pnum].getPosition()].setIcon(gb);
						break;
					case 4 : case 5 : case 10 : case 11 :
						PBorder.pborder[MarbleGame.p[pnum].getPosition()].setIcon(gb2);
						break;
					}
				}
	}

	public void nonborder(int num)
	{
		ImageIcon c = new ImageIcon("img/clear.png");

		PBorder.pborder[num].setIcon(c);
	}

	public void sumproperty()
	{
		int property = 0;

		// �� ��� ���ϱ�
		for(int i=0;i<3;i++)
		{
			property += MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getTakePrice();
		}
		property += MarbleGame.p[MarbleManager.pnum].getMoney();

		MarbleGame.p[pnum].setProperty(property);
	}
}