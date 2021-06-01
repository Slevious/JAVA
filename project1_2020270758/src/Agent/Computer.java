package Agent;

import Constants.Constants;

import javax.swing.*;
import java.awt.*;

public class Computer extends Agent{
    public static int x = 38;
    public static int y = 96;
    public static int balance = Constants.MAX_BALANCE;


    //x, y, balance는 이후 import되는 경우를 고려해 public static으로 했다.
    //balance의 경우 처음 지명된 것 처럼 Constants.MAX_BALANCE 활용
}
