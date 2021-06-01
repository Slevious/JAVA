package MainFrame;

import Board.BlueMarbleBoard;
import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public BlueMarbleBoard board;

    public MainPanel(){
        this.board = new BlueMarbleBoard();
    }

    protected void paintComponent(Graphics g){
        //시스템에서 직접호출 하는 그리기 메소드
        //해당 패널이 들어간 프레임이 보여지면 해당 메소드가 호출됨

        super.paintComponent(g);

        if (this.board != null){
            this.board.drawBoard(g);
            this.board.drawAgent(g);
            this.board.drawDice(g);
        }
    }
}
