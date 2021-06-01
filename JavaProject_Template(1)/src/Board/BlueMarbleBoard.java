package Board;

import Agent.Agent;
import City.City;
import Dice.Dice;
import java.awt.*;

public class BlueMarbleBoard {
    private int width;
    private int height;
    private Tile[][] tileMap;
    private Agent computer;
    private Agent player;
    private Dice dice;
    private City[] cityList;

    public BlueMarbleBoard(){
        //멤버 변수 세팅 우선
    }

    public void drawBoard(Graphics g){
        //보드 (타일) 그리기 메소드
    }

    public void drawAgent(Graphics g) {
        // 플레이어, 컴퓨터 말 그리기 메소드
    }

    public void drawDice(Graphics g){
        // 주사위 그리기 메소드
    }
}
