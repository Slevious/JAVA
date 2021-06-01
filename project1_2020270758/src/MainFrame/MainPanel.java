package MainFrame;

import Board.BlueMarbleBoard;
import Dice.Dice;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public BlueMarbleBoard board;

    public MainPanel(){this.board = new BlueMarbleBoard();}

    protected void paintComponent(Graphics g){

        super.paintComponent(g);


        if(this.board != null){
            this.board.drawBoard(g);
            this.board.drawAgent(g);
            this.board.drawDice(g);


        }
    }

}
