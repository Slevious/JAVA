import javax.swing.*;
import java.awt.*;

public class LoginSuccessFrame extends JFrame {

    public LoginSuccessFrame(String msg){
        setSize(400,200);
        setTitle("Login Success");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel label = new JLabel("Login 성공!", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 26));
        label.setForeground(Color.ORANGE);
        JLabel msgLabel = new JLabel(msg);

        Container cPane = getContentPane();
        cPane.setLayout(new FlowLayout());
        cPane.add(label);
        cPane.add(msgLabel);

    }
}
