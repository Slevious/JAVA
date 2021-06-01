package maingame.controller;

import maingame.model.vo.PFlag;
import maingame.model.vo.PFlagmove;

public class FlagThread extends Thread
{
	public void run()
	{
		PFlagmove.pflagmove.setLocation(PFlag.pflag[MarbleManager.pnum][MarbleManager.startIndex].getX(), PFlag.pflag[MarbleManager.pnum][MarbleManager.startIndex].getY()); // 말 이동 시작 위치 좌표
		int n1 = MarbleGame.p[MarbleManager.pnum].getPosition(); // 도착 인덱스
		int dicenum = MarbleManager.pdicenum[0] + MarbleManager.pdicenum[1] - 6; // 주사위 수 합
		int dochack = 0;

		if((n1-dicenum) < 0)
			dochack = (n1-dicenum) + 12;
		else
			dochack = n1 - dicenum;

		if(dicenum > 0) // 앞으로 가기
		{
			for(int i=MarbleManager.startIndex;i<MarbleManager.endIndex;i++)
			{
				if(i==12 && MarbleManager.endIndex!=0)
				{
					i -= 12;
					MarbleManager.endIndex -= 12;
				}

				int x1 = PFlag.pflag[MarbleManager.pnum][i].getX();
				int y1 = PFlag.pflag[MarbleManager.pnum][i].getY();

				if(i==0 || i==1 || i==2)
				{
					for(int j=0;j<145;j++) 
					{
						try 
						{
							Thread.sleep(3);
						}
						catch (InterruptedException e) 
						{
							e.printStackTrace();
						}

						x1 += 1;
						PFlagmove.pflagmove.setBounds(x1, 665, 20, 30);
					}
				}
				else
					if(i==3 || i==4 || i==5)
					{
						for(int j=0;j<110;j++) 
						{
							try 
							{
								Thread.sleep(3);
							}
							catch (InterruptedException e) 
							{
								e.printStackTrace();
							}
							y1 -= 1;
							PFlagmove.pflagmove.setBounds(x1, y1, 20, 30);
						}
					}
					else
						if(i==6 || i==7 || i==8)
						{
							for(int j=0;j<145;j++) 
							{
								try 
								{
									Thread.sleep(3);
								}
								catch (InterruptedException e) 
								{
									e.printStackTrace();
								}

								x1 -= 1;
								PFlagmove.pflagmove.setBounds(x1, y1, 20, 30);
							}
						}
						else
							if(i==9 || i==10 || i==11)
							{
								for (int j=0;j<110;j++) 
								{
									try 
									{
										Thread.sleep(3);
									}
									catch (InterruptedException e) 
									{
										e.printStackTrace();
									}

									y1 += 1;
									PFlagmove.pflagmove.setBounds(x1, y1, 20, 30);
								}
							}

				if(i==11 && MarbleManager.endIndex<=12)
				{
					i = 0;
					MarbleManager.endIndex = -12;
				}
			}
		}
		else
			if(dicenum < 0) // 뒤로 가기
			{
				for(int i=MarbleManager.startIndex;i>MarbleManager.endIndex; i--)
				{
					if(i==0 && MarbleGame.p[MarbleManager.pnum].getRound()==0)
						break;
					else
						if(i<=-1 && MarbleManager.endIndex<0)
						{
							i = 11;
							MarbleManager.endIndex += 12;
						}

					int x1 = PFlag.pflag[MarbleManager.pnum][i].getX();
					int y1 = PFlag.pflag[MarbleManager.pnum][i].getY();

					if(i==1 || i==2 || i==3)
					{
						for(int j=0;j<145;j++) 
						{
							try 
							{
								Thread.sleep(3);
							}
							catch (InterruptedException e) 
							{
								e.printStackTrace();
							}

							x1 -= 1;
							PFlagmove.pflagmove.setBounds(x1, 665, 20, 30);
						}
					}
					else
						if(i==4 || i==5 || i==6)
						{
							for(int j=0;j<110;j++) 
							{
								try 
								{
									Thread.sleep(3);
								}
								catch (InterruptedException e) 
								{
									e.printStackTrace();
								}

								y1 += 1;
								PFlagmove.pflagmove.setBounds(x1, y1, 20, 30);
							}
						}
						else
							if(i==7 || i==8 || i==9)
							{
								for(int j=0;j<145;j++) 
								{
									try 
									{
										Thread.sleep(3);
									}
									catch (InterruptedException e) 
									{
										e.printStackTrace();
									}

									x1 += 1;
									PFlagmove.pflagmove.setBounds(x1, y1, 20, 30);
								}
							}
							else
								if(i==10 || i==11 || i==0)
								{
									for(int j=0;j<110;j++) 
									{
										try 
										{
											Thread.sleep(3);
										}
										catch (InterruptedException e) 
										{
											e.printStackTrace();
										}

										y1 -= 1;
										PFlagmove.pflagmove.setBounds(x1, y1, 20, 30);
									}
								}
				}
			}
	}
}