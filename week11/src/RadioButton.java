import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RadioButton extends JFrame{

    private JRadioButton red, green, blue;
    private Color color;

    public RadioButton(){
        setSize(300, 300);
        setTitle("RadioButton");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        red = new JRadioButton("Red");
        green = new JRadioButton("Green");
        blue = new JRadioButton("Blue");
        ButtonGroup group = new ButtonGroup();
        group.add(red);
        group.add(green);
        group.add(blue);
        RadioListener listener = new RadioListener();
        red.addItemListener(listener);
        green.addItemListener(listener);
        blue.addItemListener(listener);

        Container cPane = getContentPane();
        cPane.setLayout(new FlowLayout());
        cPane.add(red);
        cPane.add(green);
        cPane.add(blue);

    }
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(color);
        g.fillOval(50,80,200,200);
    }

    private class RadioListener implements ItemListener {
        public void itemStateChanged(ItemEvent e){
            if (e.getItem() == red)
                color = Color.red;
            else if (e.getItem() == green)
                color = Color.green;
            else if (e.getItem() == blue)
                color = Color.blue;

            repaint();
        }
    }
}
