package MainFrame;

import Constants.Constants;
import javax.swing.*;

public class MainFrame extends JFrame {
    private MainPanel mainPanel;

    public MainFrame() {
        this.mainPanel = new MainPanel();
        this.add(this.mainPanel);
    }

    public void init(){
        this.setSize(Constants.MAINFRAME_WIDTH, Constants.MAINFRAME_HEIGHT);
        this.setTitle(Constants.MAINFRAME_TITLE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
