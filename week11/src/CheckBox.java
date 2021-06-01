import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class CheckBox extends JFrame {
        private JCheckBox red, green, blue;

        public CheckBox(){
            setSize(300, 300);
            setTitle("CheckBox1");
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            red = new JCheckBox("Red");
            green = new JCheckBox("Green");
            blue = new JCheckBox("Blue");

            JButton button = new JButton("확인");
            button.addActionListener(new ButtonListener());

            Container cPane = getContentPane();
            cPane.setLayout(new FlowLayout());
            cPane.add(red);
            cPane.add(green);
            cPane.add(blue);
            cPane.add(button);
        }

            public void paint(Graphics g){
            super.paint(g);
            int rCheck = red.isSelected() ? 1:0;
            int gCheck = green.isSelected()? 1:0;
            int bCheck = blue.isSelected()? 1:0;
            g.setColor(new Color(rCheck*255, gCheck*255, bCheck*255));
            g.fillOval(50,80,200,200);
            }

            public class ButtonListener implements ActionListener{
            public void actionPerformed(ActionEvent e){repaint();}
            }


    }

