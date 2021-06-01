package MainFrame;

import javax.swing.*;
import Agent.Computer;
import Agent.Player;
import Board.BlueMarbleBoard;
import Constants.Constants;
import Dice.Dice;

import MainFrame.MainPanel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame {

        private MainPanel mainPanel;
        public static int stack = 0;


        public MainFrame(){

            this.mainPanel = new MainPanel(); //mainPanel 생성
            this.add(this.mainPanel);

            mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT,50,15)); //mainPanel을 FlowLayout으로 하여 JLabel, Button이 순차적으로 입력되도록 함.

            JLabel LabelComputer = new JLabel("컴퓨터 잔액: " + Computer.balance,SwingConstants.LEFT);
            //JLabel로 텍스트 입력, Computer.balance로 잔액 가져옴., 왼쪽 정렬



            JLabel LabelPlayer = new JLabel("플레이어 잔액: " + Player.balance, SwingConstants.RIGHT);
            //JLabel로 텍스트 입력, Player.balance로 잔액 가져옴., 오른쪽 정렬

            JButton Roll = new JButton("주사위 굴리기");
            Roll.addActionListener(new ButtonListener());
            //ActionListener를 활용하여 버튼과 currentNum을 연결



            mainPanel.add(LabelComputer);
            mainPanel.add(Roll);
            mainPanel.add(LabelPlayer);
        //mainPnael에 Computer, Roll, Player의 텍스트와 버튼을 순차적으로 더함.

            add(mainPanel, BorderLayout.CENTER);



            pack();
        }

        private class ButtonListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {

                stack++;
                repaint();
                // stack을 활용해 버튼을 누르면 stack이 +1되게 설정, 이후 repaint.
            }
        }



        public void init(){
            this.setSize(Constants.MAINFRAME_WIDTH, Constants.MAINFRAME_HEIGHT);
            this.setTitle(Constants.MAINFRAME_TITLE);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        }
}
