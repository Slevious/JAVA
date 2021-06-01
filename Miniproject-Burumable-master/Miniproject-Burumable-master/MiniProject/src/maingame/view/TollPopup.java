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
		// 팝업 틀 설정
		setTitle("구장 통행료 및 인수하기"); // 팝업 설정 5종
		setSize(500,280);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

		JLabel background = new JLabel(pbg); // 이미지
		background.setBounds(0, 0, 500, 280); // 위치 및 사이즈

		int num1 = MarbleGame.st[MarbleManager.posi].getToll(); // 통행료
		String str1 = String.format("%,d", num1);
		double num2 = MarbleGame.st[MarbleManager.posi].getPrice() * (MarbleGame.st[MarbleManager.posi].getTakeCount()+1) * 0.1; // 인수비 10%씩 증가
		int num3 = MarbleGame.st[MarbleManager.posi].getPrice() + (int)(num2); // 인수비
		String str2 = String.format("%,d", num3);

		JLabel[] text = new JLabel[3];
		for (int i=0;i<3;i++)
		{
			text[i] = new JLabel(); // 생성
			text[i].setFont(new Font("08서울남산체 M", Font.PLAIN, 18)); // 글꼴, 일반, 크기
			text[i].setHorizontalAlignment(JLabel.CENTER); // 라벨 내에서 가운데정렬
		}

		text[0].setText("현재 \"" + MarbleGame.st[MarbleManager.posi].getName() + "\" 의 통행료는 " + str1 + "원 입니다.");
		text[0].setBounds(0, 40, 500, 30);
		text[1].setText("인수 비용은 " + str2 + "원 입니다.");
		text[1].setBounds(0, 75, 500, 30);
		text[2].setText("모두 지불하시겠습니까?");
		text[2].setBounds(0, 110, 500, 30);

		JButton yes = new JButton(yb); // 이미지
		yes.setBorderPainted(false); // 버튼 설정 3종
		yes.setContentAreaFilled(false);
		yes.setFocusPainted(false);
		yes.setBounds(130, 175, 100, 50); // 위치 및 사이즈

		// 예 버튼 액션(무기명)
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // 사라지게 하기

				int count = 0;

				// 가지고 있는 구장 갯수 체크
				for(int i=0;i<3;i++)
				{
					if(MarbleGame.pst[MarbleManager.pnum][i] != 0)
						count++;
				}

				// 구장이 3개면, no 버튼과 동일한 액션(통행료만 납부)
				if(count == 3)
				{
					if(MarbleGame.p[MarbleManager.pnum].getMoney() < num1) // 현금이 통행료보다 적을 경우
					{
						if(MarbleGame.p[MarbleManager.pnum].getProperty() < num1) // 전재산이 통행료보다 적을 경우
						{
							// 파산
							MarbleGame.p[MarbleManager.pnum].setStatus(0); // 파산 상태로 변경
							MarbleManager.finalrank[MarbleManager.personcount] = MarbleManager.pnum; // 랭크에 기록
							MarbleManager.personcount++; // 파산 인원 추가
							MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setMoney(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getMoney()+num1); // 통행료 지급
							MarbleGame.p[MarbleManager.pnum].setMoney(0); // 현금 소멸

							for(int i=0;i<3;i++)
							{
								mm.nonborder(MarbleGame.pst[MarbleManager.pnum][i]); // 테두리 제거
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwner(3); // 소유자 초기화
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakePrice(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()); // 인수된 가격 초기화
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakeCount(0); // 인수된 횟수 초기화
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setToll((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.4)); // 통행료 초기화
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setAdmission((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.2)); // 관람료 초기화
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwnerCheck(0); // 소유 여부 초기화
								MarbleGame.pst[MarbleManager.pnum][i] = 0; // 카드 제거
							}

							JOptionPane.showMessageDialog(MarbleGame.jlp, "파산하였습니다. 게임에 참여할 수 없습니다.", "상태창", JOptionPane.ERROR_MESSAGE);
							PBankruptcy.pbankruptcy[MarbleManager.pnum].setIcon(bkr); // 파산 이미지 띄우기

							if(MarbleManager.personcount == 2) // 파산 인원이 2명이면, 게임 종료
							{
								MarbleManager.gameover();
							}
						}
						else
						{
							// 통행료 낼 수 있을 만큼, 소유 구장 팔기
							for(int i=2;i>=0;i--)
							{
								if(MarbleGame.p[MarbleManager.pnum].getMoney() < num1)
								{
									MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()+MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getTakePrice()); // 판매금 추가
									MarbleGame.p[MarbleManager.pnum].setSalary(MarbleGame.p[MarbleManager.pnum].getSalary()-MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getAdmission()); // 월급 차감
									mm.nonborder(MarbleGame.pst[MarbleManager.pnum][i]); // 테두리 제거
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwner(3); // 소유자 초기화
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakePrice(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()); // 인수된 가격 초기화
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakeCount(0); // 인수된 횟수 초기화
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setToll((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.4)); // 통행료 초기화
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setAdmission((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.2)); // 관람료 초기화
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwnerCheck(0); // 소유 여부 초기화
									MarbleGame.pst[MarbleManager.pnum][i] = 0; // 카드 제거
								}
							}

							// 통행료만 납부
							MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setMoney(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getMoney()+num1); // 통행료 지급
							MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()-num1); // 통행료 차감

							JOptionPane.showMessageDialog(MarbleGame.jlp, "소유한 구장을 팔아, 통행료를 납부합니다.", "상태창", JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						// 통행료만 납부
						MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setMoney(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getMoney()+num1); // 통행료 지급
						MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()-num1); // 통행료 차감

						JOptionPane.showMessageDialog(MarbleGame.jlp, "이미 소유한 구장이 3개입니다. 통행료만 부과합니다.", "상태창", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					if(MarbleGame.p[MarbleManager.pnum].getMoney() < num1+num3) // 현금이 통행료+인수비보다 적을 경우
					{
						if(MarbleGame.p[MarbleManager.pnum].getMoney() < num1) // 현금이 통행료보다 적을 경우
						{
							if(MarbleGame.p[MarbleManager.pnum].getProperty() < num1)  // 전재산이 통행료보다 적을 경우
							{
								// 파산
								MarbleGame.p[MarbleManager.pnum].setStatus(0); // 파산 상태로 변경
								MarbleManager.finalrank[MarbleManager.personcount] = MarbleManager.pnum; // 랭크에 기록
								MarbleManager.personcount++; // 파산 인원 추가
								MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setMoney(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getMoney()+num1); // 통행료 지급
								MarbleGame.p[MarbleManager.pnum].setMoney(0); // 재산 소멸

								for(int i=0;i<3;i++)
								{
									mm.nonborder(MarbleGame.pst[MarbleManager.pnum][i]); // 테두리 제거
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwner(3); // 소유자 초기화
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakePrice(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()); // 인수된 가격 초기화
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakeCount(0); // 인수된 횟수 초기화
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setToll((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.4)); // 통행료 초기화
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setAdmission((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.2)); // 관람료 초기화
									MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwnerCheck(0); // 소유 여부 초기화
									MarbleGame.pst[MarbleManager.pnum][i] = 0; // 카드 제거
								}

								JOptionPane.showMessageDialog(MarbleGame.jlp, "파산하였습니다. 게임에 참여할 수 없습니다.", "상태창", JOptionPane.ERROR_MESSAGE);
								PBankruptcy.pbankruptcy[MarbleManager.pnum].setIcon(bkr); // 파산 이미지 띄우기

								if(MarbleManager.personcount == 2) // 파산 인원이 2명이면, 게임 종료
								{
									MarbleManager.gameover();
								}
							}
							else
							{
								// 통행료 낼 수 있을 만큼, 소유 구장 팔기
								for(int i=2;i>=0;i--)
								{
									if(MarbleGame.p[MarbleManager.pnum].getMoney() < num1)
									{
										MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()+MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getTakePrice()); // 판매금 추가
										MarbleGame.p[MarbleManager.pnum].setSalary(MarbleGame.p[MarbleManager.pnum].getSalary()-MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getAdmission()); // 월급 차감
										mm.nonborder(MarbleGame.pst[MarbleManager.pnum][i]); // 테두리 제거
										MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwner(3); // 소유자 초기화
										MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakePrice(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()); // 인수된 가격 초기화
										MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakeCount(0); // 인수된 횟수 초기화
										MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setToll((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.4)); // 통행료 초기화
										MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setAdmission((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.2)); // 관람료 초기화
										MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwnerCheck(0); // 소유 여부 초기화
										MarbleGame.pst[MarbleManager.pnum][i] = 0; // 카드 제거
									}
								}

								// 통행료만 납부
								MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setMoney(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getMoney()+num1); // 통행료 지급
								MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()-num1); // 통행료 차감

								JOptionPane.showMessageDialog(MarbleGame.jlp, "소유한 구장을 팔아, 통행료를 납부합니다.", "상태창", JOptionPane.ERROR_MESSAGE);
							}
						}
						else
						{
							// 통행료만 납부
							MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setMoney(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getMoney()+num1); // 통행료 지급
							MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()-num1); // 통행료 차감

							JOptionPane.showMessageDialog(MarbleGame.jlp, "현금이 부족하여 인수할 수 없습니다. 통행료만 정상 납부되었습니다.", "상태창", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else
					{
						// 통행료 납부 및 인수 성공
						MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setMoney(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getMoney()+num1+num3); // 통행료+인수비 지급
						MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setSalary(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getSalary()-MarbleGame.st[MarbleManager.posi].getAdmission()); // 월급 차감
						// 카드 제거
						for(int i=0;i<3;i++)
						{
							if(MarbleGame.pst[MarbleGame.st[MarbleManager.posi].getOwner()][i] == MarbleManager.posi)
							{
								MarbleGame.pst[MarbleGame.st[MarbleManager.posi].getOwner()][i] = 0;
								break;
							}
						}

						MarbleGame.st[MarbleManager.posi].setOwner(MarbleManager.pnum); // 소유자 갱신
						MarbleGame.st[MarbleManager.posi].setTakePrice(num3); // 인수된 가격 갱신
						MarbleGame.st[MarbleManager.posi].setTakeCount(MarbleGame.st[MarbleManager.posi].getTakeCount()+1); // 인수된 횟수 갱신
						MarbleGame.st[MarbleManager.posi].setToll((int)(MarbleGame.st[MarbleManager.posi].getTakePrice()*0.4)); // 통행료 갱신
						MarbleGame.st[MarbleManager.posi].setAdmission((int)(MarbleGame.st[MarbleManager.posi].getTakePrice()*0.2)); // 관람료 갱신
						MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()-num1-num3); // 통행료+인수비 차감
						MarbleGame.p[MarbleManager.pnum].setSalary(MarbleGame.p[MarbleManager.pnum].getSalary()+MarbleGame.st[MarbleManager.posi].getAdmission()); // 월급 추가
						mm.border(); // 테두리 갱신
						MarbleGame.pst[MarbleManager.pnum][count] = MarbleManager.posi; // 카드 추가

						JOptionPane.showMessageDialog(MarbleGame.jlp, "정상 인수되었습니다.", "상태창", JOptionPane.INFORMATION_MESSAGE);
					}
				}

				mm.moneysetting(); // 돈 세팅
				mm.groundsetting(); // 구장 카드 세팅
			}
		});

		JButton no = new JButton(nb); // 이미지
		no.setBorderPainted(false); // 버튼 설정 3종
		no.setContentAreaFilled(false);
		no.setFocusPainted(false);
		no.setBounds(270, 175, 100, 50); // 위치 및 사이즈

		// 아니오 버튼 액션(무기명)
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // 사라지게 하기

				if(MarbleGame.p[MarbleManager.pnum].getMoney() < num1) // 현금이 통행료보다 적을 경우
				{
					if(MarbleGame.p[MarbleManager.pnum].getProperty() < num1) // 전재산이 통행료보다 적을 경우
					{
						// 파산
						MarbleGame.p[MarbleManager.pnum].setStatus(0); // 파산 상태로 변경
						MarbleManager.finalrank[MarbleManager.personcount] = MarbleManager.pnum; // 랭크에 기록
						MarbleManager.personcount++; // 파산 인원 추가
						MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setMoney(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getMoney()+num1); // 통행료 지급
						MarbleGame.p[MarbleManager.pnum].setMoney(0); // 재산 소멸

						for(int i=0;i<3;i++)
						{
							mm.nonborder(MarbleGame.pst[MarbleManager.pnum][i]); // 테두리 제거
							MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwner(3); // 소유자 초기화
							MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakePrice(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()); // 인수된 가격 초기화
							MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakeCount(0); // 인수된 횟수 초기화
							MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setToll((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.4)); // 통행료 초기화
							MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setAdmission((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.2)); // 관람료 초기화
							MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwnerCheck(0); // 소유 여부 초기화
							MarbleGame.pst[MarbleManager.pnum][i] = 0; // 카드 제거
						}

						JOptionPane.showMessageDialog(MarbleGame.jlp, "파산하였습니다. 게임에 참여할 수 없습니다.", "상태창", JOptionPane.ERROR_MESSAGE);
						PBankruptcy.pbankruptcy[MarbleManager.pnum].setIcon(bkr); // 파산 이미지 띄우기

						if(MarbleManager.personcount == 2) // 파산 인원이 2명이면, 게임 종료
						{
							MarbleManager.gameover();
						}
					}
					else
					{
						// 통행료 낼 수 있을 만큼, 소유 구장 팔기
						for(int i=2;i>=0;i--)
						{
							if(MarbleGame.p[MarbleManager.pnum].getMoney() < num1)
							{
								MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()+MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getTakePrice()); // 판매금 추가
								MarbleGame.p[MarbleManager.pnum].setSalary(MarbleGame.p[MarbleManager.pnum].getSalary()-MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getAdmission()); // 월급 차감
								mm.nonborder(MarbleGame.pst[MarbleManager.pnum][i]); // 테두리 제거
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwner(3); // 소유자 초기화
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakePrice(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()); // 인수된 가격 초기화
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setTakeCount(0); // 인수된 횟수 초기화
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setToll((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.4)); // 통행료 초기화
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setAdmission((int)(MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].getPrice()*0.2)); // 관람료 초기화
								MarbleGame.st[MarbleGame.pst[MarbleManager.pnum][i]].setOwnerCheck(0); // 소유 여부 초기화
								MarbleGame.pst[MarbleManager.pnum][i] = 0; // 카드 제거
							}
						}

						// 통행료만 납부
						MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setMoney(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getMoney()+num1); // 통행료 지급
						MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()-num1); // 통행료 차감

						JOptionPane.showMessageDialog(MarbleGame.jlp, "소유한 구장을 팔아, 통행료를 납부합니다.", "상태창", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					// 통행료만 납부
					MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].setMoney(MarbleGame.p[MarbleGame.st[MarbleManager.posi].getOwner()].getMoney()+num1); // 통행료 지급
					MarbleGame.p[MarbleManager.pnum].setMoney(MarbleGame.p[MarbleManager.pnum].getMoney()-num1); // 통행료 차감

					JOptionPane.showMessageDialog(MarbleGame.jlp, "통행료가 정상 납부되었습니다.", "상태창", JOptionPane.INFORMATION_MESSAGE);
				}

				mm.moneysetting(); // 돈 세팅
				mm.groundsetting(); // 구장 카드 세팅
			}
		});

		// 팝업에 컴포넌트들 올리기
		for (int i=0;i<3;i++)
		{
			background.add(text[i]);
		}
		background.add(yes);
		background.add(no);
		add(background);

		setVisible(true); // 팝업을 보여주기
	}
}