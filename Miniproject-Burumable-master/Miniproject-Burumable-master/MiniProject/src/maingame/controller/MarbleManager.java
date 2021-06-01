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
	public static int[] ranking = new int[3]; // 순서 인덱스 값이 저장된 배열
	public static int pnum = 0; // 게임 중인 플레이어 번호
	public static int posi = 0; // 현재 위치
	public static int personcount = 0; // 파산인 사람 수
	public static int[] finalrank = new int[3]; // 최종 랭킹에 쓰일 역순 배열

	static int[] pdicenum = new int[2];  // 게임 주사위 돌린 값이 저장된 배열
	static int startIndex;
	static int endIndex;
	static int moveIndex;

	private ImageIcon y = new ImageIcon("img/yellow.png");
	private ImageIcon b = new ImageIcon("img/blue.png");
	private ImageIcon g = new ImageIcon("img/green.png");
	private int[] dicenum = new int[3]; // 순서 정하는 주사위 돌린 값이 저장된 배열
	private int[] dicenum_copy = new int[3]; // 주사위 돌린 값을 복사 받아, 오름차순으로 정렬한 배열
	private int turnnum = 1; // 게임 턴

	public void startpage()
	{
		StartBackground sbg = new StartBackground();
		NameField nf = new NameField();
		StartButton sb = new StartButton();
	}

	public void turndice() // 1~6까지 중복없이 3개 값 추출하여 배열에 넣기
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
				Dice.d[i].setIcon(d_2); // 주사위 -2
				break;
			case 2:
				Dice.d[i].setIcon(d_1); // 주사위 -1
				break;
			case 3:
				Dice.d[i].setIcon(d); // 주사위 0
				break;
			case 4:
				Dice.d[i].setIcon(d1); // 주사위 1
				break;
			case 5:
				Dice.d[i].setIcon(d2); // 주사위 2
				break;
			case 6:
				Dice.d[i].setIcon(d3); // 주사위 3
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

	public void rank() // 두 배열을 비교하여, 같은 값을 가질 때의 인덱스를 추출
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

		turnsetting(); // 턴에 맞게 초록불
		moneysetting(); // 돈 세팅
		groundsetting(); // 구장 카드 세팅
	}

	public void turnsetting()
	{
		ImageIcon c = new ImageIcon("img/clear.png");
		ImageIcon tl = new ImageIcon("img/turnlight.png");

		for(int i=0;i<3;i++)
		{
			PTurn.pturn[i].setIcon(c); // 불을 모두 초기화
		}

		if(turnnum > 3)
			turnnum -= 3;

		if(MarbleGame.p[turnnum-1].getStatus() == 0) // 파산인 플레이어가 있다면 턴 넘어가기
			turnnum++;

		if(turnnum > 3)
			turnnum -= 3;

		PTurn.pturn[turnnum-1].setIcon(tl); // 턴에 맞춰 불 켜기
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

		for(int i=0;i<3;i++) // 내림차순으로 정렬
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

	public void spindice() // 1~6까지 중복없이 2개 값 추출하여 배열에 넣기
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
				PDice.pdice[i].setIcon(d_2); // 주사위 -2
				break;
			case 2:
				PDice.pdice[i].setIcon(d_1); // 주사위 -1
				break;
			case 3:
				PDice.pdice[i].setIcon(d); // 주사위 0
				break;
			case 4:
				PDice.pdice[i].setIcon(d1); // 주사위 1
				break;
			case 5:
				PDice.pdice[i].setIcon(d2); // 주사위 2
				break;
			case 6:
				PDice.pdice[i].setIcon(d3); // 주사위 3
				break;
			}
		}
	}

	public void game()
	{
		pnum = turncheck(); // 게임 중인 플레이어 알려주기
		int dnum = MarbleGame.p[pnum].getPosition() + pdicenum[0] + pdicenum[1] - 6; // 현재 위치에서 주사위 값을 합친 결과

		startIndex = MarbleGame.p[pnum].getPosition();
		endIndex = dnum;

		if(MarbleGame.p[pnum].getBlack()==1 && MarbleGame.p[pnum].getStatus()==1) // 블랙홀에 빠지거나 파산인 경우가 아닌 정상적인 플레이
		{
			posicheck(dnum); // 이동할 위치 체크

			horsemove(); // 말 이동

			stadiumcheck(); // 도착한 위치에 따라, 여러 상황 발생

			sumproperty(); // 플레이어 총 재산 계산
		}
		else
			if(MarbleGame.p[pnum].getBlack() == 0) // 블랙홀에서 1턴 쉬기
			{
				MarbleGame.p[pnum].setBlack(1);

				JOptionPane.showMessageDialog(MarbleGame.jlp, "다음 턴부터 참여 가능합니다.", "상태창", JOptionPane.ERROR_MESSAGE);
			}

		turnsetting(); // 턴에 맞게 초록불
		
		
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

		PFlag.pflag[pnum][MarbleGame.p[pnum].getPosition()].setIcon(c); // 현재 위치 말 가리기

		if(MarbleGame.p[pnum].getRound() == 0) // 아직 1바퀴도 안 돌았을 때
		{
			if(dnum <= 0) // 0 이하 숫자가 나오면 움직이지 않는다.
				MarbleGame.p[pnum].setPosition(0);
			else
				if(dnum > 11)
				{
					dnum -= 12; // 한 바퀴를 넘어갈 경우
					MarbleGame.p[pnum].setRound(MarbleGame.p[pnum].getRound()+1); // 라운드 추가
					MarbleGame.p[pnum].setPosition(dnum);
					
					if(MarbleGame.p[pnum].getRound() == 2) // 누군가 2바퀴에 먼저 도달하면, 게임 종료
					{
						gameover();
						return;
					}
					
					SalaryPopup sp = new SalaryPopup(); // 한 바퀴가 추가되면, 관람료 지급 팝업
				}
				else
					MarbleGame.p[pnum].setPosition(dnum);
		}
		else
			if(dnum > 11)
			{
				dnum -= 12; // 한 바퀴를 넘어갈 경우
				MarbleGame.p[pnum].setRound(MarbleGame.p[pnum].getRound()+1); // 라운드 추가
				MarbleGame.p[pnum].setPosition(dnum);
				
				if(MarbleGame.p[pnum].getRound() == 2) // 누군가 2바퀴에 먼저 도달하면, 게임 종료
				{
					gameover();
					return;
				}
				
				SalaryPopup sp = new SalaryPopup(); // 한 바퀴가 추가되면, 관람료 지급 팝업
			}
			else
				if(dnum == 0) // 출발점인 경우
				{
					MarbleGame.p[pnum].setRound(MarbleGame.p[pnum].getRound()+1); // 라운드 추가
					MarbleGame.p[pnum].setPosition(dnum);
					
					if(MarbleGame.p[pnum].getRound() == 2) // 누군가 2바퀴에 먼저 도달하면, 게임 종료
					{
						gameover();
						return;
					}
					
					SalaryPopup sp = new SalaryPopup(); // 한 바퀴가 추가되면, 관람료 지급 팝업
				}
				else
					if(dnum < 0)
					{
						dnum += 12; // 뒤로 갈 경우
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

		finalrank[2] = pnum; // 2바퀴에 도달한 또는 파산하지 않은 현재 플레이어가 1등

		if(personcount == 0) // 파산한 사람 없이, 누군가 2바퀴에 먼저 도달한 경우
		{
			int[] sort = new int[2];
			int index = 0;

			finalrank[2] = pnum; // 2바퀴에 도달한 현재 플레이어가 1등

			// 1등 플레이어 제외한 다른 플레이어 인덱스 추출
			for(int i=0;i<3;i++)
			{
				if(i != pnum)
				{
					sort[index] = i;
					index++;
				}
			}

			// 전재산이 많은 순대로 정렬
			// -> 만약 전재산이 같다면, 플레이어 턴 순서가 빠를수록 더 높은 우위를 가짐
			if(MarbleGame.p[sort[0]].getProperty() >= MarbleGame.p[sort[1]].getProperty())
			{
				int tmp = sort[0];
				sort[0] = sort[1];
				sort[1] = tmp;
			}

			// 최종 랭킹 배열에 넣기
			for(int i=1;i>=0;i--)
			{
				finalrank[i] = sort[i];
			}
		}
		else
			if(personcount == 1) // 파산한 사람 1명, 나머지 2명 중에서 2바퀴에 누군가 도달한 경우
			{
				finalrank[2] = pnum; // 2바퀴에 도달한 현재 플레이어가 1등

				// 파산 1명, 1등 플레이어 제외한 다른 플레이어 인덱스 추출
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
				if(personcount == 2) // 파산한 사람 2명
				{
					// 파산 2명을 제외한 1등 플레이어 인덱스 추출
					for(int i=0;i<3;i++)
					{
						if(i!=finalrank[0] && i!=finalrank[1])
						{
							finalrank[2] = i;
							break;
						}
					}
				}

		// 역순으로 순위 출력
		for(int i=2;i>=0;i--)
		{
			pr.prank[i].setText(MarbleGame.p[finalrank[i]].getName());
		}
	}

	public void stadiumcheck()
	{
		if(MarbleGame.st[posi].getOwnerCheck()==0 && posi!=0)
		{
			BuyPopup bp = new BuyPopup(); // 구장 구매하기 팝업
		}
		else
			if(posi==3 || posi==9)
			{
				SoccerGame sc = new SoccerGame(); // 축구 게임 실행
			}
			else
				if(posi == 6)
				{
					MarbleGame.p[pnum].setBlack(0); // 밟으면 상태 0으로 만들기

					BholePopup bp = new BholePopup(); // 블랙홀 입장 팝업
				}
				else
					if(MarbleGame.st[posi].getOwner()!=pnum && posi!=0)
					{
						TollPopup tp = new TollPopup(); // 구장 통행료 및 인수하기 팝업
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

		// 전 재산 구하기
		for(int i=0;i<3;i++)
		{
			property += MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getTakePrice();
		}
		property += MarbleGame.p[MarbleManager.pnum].getMoney();

		MarbleGame.p[pnum].setProperty(property);
	}
}