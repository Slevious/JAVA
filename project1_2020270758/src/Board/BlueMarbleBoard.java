package Board;

import Agent.Agent;
import City.City;
import Dice.Dice;
import MainFrame.MainFrame;

import javax.swing.*;
import java.awt.*;

public class BlueMarbleBoard {
    private int width = 7; //Constants 값 활용
    private int height = 7; //Constants 값 활용
    private Tile[][] tileMap;
    private Agent computer;
    private Agent player;
    private Dice dice;
    private City[] cityList;

    public BlueMarbleBoard(){}
    public void drawBoard(Graphics g) {
        Image City = new ImageIcon("src/resource/tile/CITY.png").getImage(); //draw 이미지 Graphics 클래스 메소드 이용
        Image TILE_COM = new ImageIcon("src/resource/tile/COM.png").getImage(); //draw 이미지 Graphics 클래스 메소드 이용
        Image ISLAND = new ImageIcon("src/resource/tile/ISLAND.png").getImage(); //draw 이미지 Graphics 클래스 메소드 이용
        Image TILE_PLAYER = new ImageIcon("src/resource/tile/PLAYER.png").getImage(); //draw 이미지 Graphics 클래스 메소드 이용
        Image START = new ImageIcon("src/resource/tile/START.png").getImage(); //draw 이미지 Graphics 클래스 메소드 이용
        Image TILE = new ImageIcon("src/resource/tile/TILE.png").getImage(); //draw 이미지 Graphics 클래스 메소드 이용

        g.drawImage(START, 0, 60,80,80,null); //draw 이미지 City. ISLAND, START, TILE의 좌표값을 각각 계산해 그려준다.
        g.drawImage(City, 80, 60,80,80,null);
        g.drawImage(City, 160, 60,80,80,null);
        g.drawImage(City, 240, 60,80,80,null);
        g.drawImage(City, 320, 60,80,80,null);
        g.drawImage(City, 400, 60,80,80,null);
        g.drawImage(City, 80, 540,80,80,null);
        g.drawImage(City, 160, 540,80,80,null);
        g.drawImage(City, 240, 540,80,80,null);
        g.drawImage(City, 320, 540,80,80,null);
        g.drawImage(City, 400, 540,80,80,null);
        g.drawImage(City, 0, 140,80,80,null);
        g.drawImage(City, 0, 220,80,80,null);
        g.drawImage(City, 0, 300,80,80,null);
        g.drawImage(City, 0, 380,80,80,null);
        g.drawImage(City, 0, 460,80,80,null);
        g.drawImage(City, 480, 140,80,80,null);
        g.drawImage(City, 480, 220,80,80,null);
        g.drawImage(City, 480, 300,80,80,null);
        g.drawImage(City, 480, 380,80,80,null);
        g.drawImage(City, 480, 460,80,80,null);
        g.drawImage(ISLAND, 0, 540,80,80,null);
        g.drawImage(ISLAND, 480, 60,80,80,null);
        g.drawImage(ISLAND, 480, 540,80,80,null);
        g.drawImage(TILE, 80, 140,80,80,null);
        g.drawImage(TILE, 160, 140,80,80,null);
        g.drawImage(TILE, 240, 140,80,80,null);
        g.drawImage(TILE, 320, 140,80,80,null);
        g.drawImage(TILE, 400, 140,80,80,null);
        g.drawImage(TILE, 80, 220,80,80,null);
        g.drawImage(TILE, 160, 220,80,80,null);
        g.drawImage(TILE, 240, 220,80,80,null);
        g.drawImage(TILE, 320, 220,80,80,null);
        g.drawImage(TILE, 400, 220,80,80,null);
        g.drawImage(TILE, 80, 300,80,80,null);
        g.drawImage(TILE, 160, 300,80,80,null);
        g.drawImage(TILE, 240, 300,80,80,null);
        g.drawImage(TILE, 320, 300,80,80,null);
        g.drawImage(TILE, 400, 300,80,80,null);
        g.drawImage(TILE, 80, 380,80,80,null);
        g.drawImage(TILE, 160, 380,80,80,null);
        g.drawImage(TILE, 240, 380,80,80,null);
        g.drawImage(TILE, 320, 380,80,80,null);
        g.drawImage(TILE, 400, 380,80,80,null);
        g.drawImage(TILE, 80, 460,80,80,null);
        g.drawImage(TILE, 160, 460,80,80,null);
        g.drawImage(TILE, 240, 460,80,80,null);
        g.drawImage(TILE, 320, 460,80,80,null);
        g.drawImage(TILE, 400, 460,80,80,null);

        g.drawString("시 작",30, 80); //drawString을 이용해 각 타일에 좌표값을 계산해 텍스트를 이미지 위에 그림.
        g.drawString("수 원",110, 80);
        g.drawString("용 인",190, 80);
        g.drawString("익 산",270, 80);
        g.drawString("전 주",350, 80);
        g.drawString("군 산",430, 80);
        g.drawString("무인도",510, 80);
        g.drawString("경 주",510, 160);
        g.drawString("포 항",510, 240);
        g.drawString("대 구",510, 320);
        g.drawString("창 원",510, 400);
        g.drawString("부 산",510, 480);
        g.drawString("무인도",510, 560);
        g.drawString("제 주",430, 560);
        g.drawString("여 수",350, 560);
        g.drawString("광 주",270, 560);
        g.drawString("춘 천",190, 560);
        g.drawString("강 릉",110, 560);
        g.drawString("무인도",30, 560);
        g.drawString("청 주",30, 480);
        g.drawString("천 안",30, 400);
        g.drawString("대 전",30, 320);
        g.drawString("인 천",30, 240);
        g.drawString("서 울",30, 160);
    }
    public void drawAgent(Graphics g){
        Image Computer = new ImageIcon("src/resource/agent/COMPUTER.png").getImage(); //draw 이미지 Graphics 클래스 메소드 이용
        Image Player = new ImageIcon("src/resource/agent/PLAYER.png").getImage(); //draw 이미지 Graphics 클래스 메소드 이용

        g.drawImage(Computer, 38, 96,40,40,null); //draw 이미지 Computer, Player 좌표값을 각각 계산해 그려준다.
        g.drawImage(Player,4,86,40,40,null);
    }
    public void drawDice(Graphics g){

        Dice.currentNum = 1; //currentNum의 초기값을 1로 설정한다.

        if(MainFrame.stack != 0){
            Dice.currentNum = (int)(Math.random() * 6) +1;
            MainFrame.stack--;
            //MainFrame의 스택이 0이 아닐 경우, Dice.currentNum의 값을 1~6중 랜덤 설정
            //이후 stack의 값을 -1한다.
            //Dice.currentNum 값이 바뀌므로 아래 이미지 또한 바뀌게 된다.
        }

        Image Dice1 = new ImageIcon("src/resource/dice/DICE1.png").getImage(); //draw 이미지 Graphics 클래스 메소드 이용
        Image Dice2 = new ImageIcon("src/resource/dice/DICE2.png").getImage(); //draw 이미지 Graphics 클래스 메소드 이용
        Image Dice3 = new ImageIcon("src/resource/dice/DICE3.png").getImage(); //draw 이미지 Graphics 클래스 메소드 이용
        Image Dice4 = new ImageIcon("src/resource/dice/DICE4.png").getImage(); //draw 이미지 Graphics 클래스 메소드 이용
        Image Dice5 = new ImageIcon("src/resource/dice/DICE5.png").getImage(); //draw 이미지 Graphics 클래스 메소드 이용
        Image Dice6 = new ImageIcon("src/resource/dice/DICE6.png").getImage(); //draw 이미지 Graphics 클래스 메소드 이용

        if(Dice.currentNum == 1){ //draw currentNum의 값에 따라 다른 이미지를 출력하도록 한다.
            g.drawImage(Dice1,Dice.x,Dice.y,90,90,null); //draw 이미지 currentNum 좌표값을 각각 계산해 그려준다. 이때 Dice클래스에서 값을 받아온다.
        }
        else if(Dice.currentNum == 2){
            g.drawImage(Dice2,Dice.x,Dice.y,90,90, null);
        }
        else if(Dice.currentNum == 3){
            g.drawImage(Dice3,Dice.x,Dice.y,90,90, null);
        }else if(Dice.currentNum == 4){
            g.drawImage(Dice4,Dice.x,Dice.y,90,90, null);
        }
        else if(Dice.currentNum == 5){
            g.drawImage(Dice5,Dice.x,Dice.y,90,90, null);
        }
        else if(Dice.currentNum == 6){
            g.drawImage(Dice6,Dice.x,Dice.y, 90, 90, null);
        }





    }
}
