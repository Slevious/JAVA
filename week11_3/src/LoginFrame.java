import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JButton btnLogin;
    private JButton btnCancel;
    private JTextField inputId;
    private JPasswordField inputPasswd;

    public LoginFrame(){
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER,50,10));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,2,10,3));
        LoginListener listener = new LoginListener();

        JLabel labelId = new JLabel("아이디", JLabel.RIGHT);
        JLabel labelPasswd = new JLabel("비밀번호", JLabel.RIGHT);
        inputId = new JTextField(8);
        inputPasswd = new JPasswordField(8);

        btnLogin = new JButton("로그인");
        btnCancel = new JButton("취소");
        btnLogin.addActionListener(listener);
        btnCancel.addActionListener(listener);

        panel.add(labelId);
        panel.add(inputId);
        panel.add(labelPasswd);
        panel.add(inputPasswd);
        panel.add(btnLogin);
        panel.add(btnCancel);
        add(panel);
        pack();
    }

    private class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == btnLogin){
                String id = inputId.getText();
                String passwd = new String(inputPasswd.getPassword());
                if(id.equals("java") && passwd.equals("1234")){
                    String msg = "id = " + id + ", passwd= " + passwd;
                    new LoginSuccessFrame(msg).setVisible(true);
                    dispose();
                }

                else{
                    JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호 틀림");
                    inputPasswd.setText("");
                    inputId.selectAll();
                    inputId.requestFocus();
                }
            }

            else if (e.getSource() == btnCancel){
                inputId.setText("");
                inputPasswd.setText("");
                inputId.requestFocus(true);
            }
        }
    }
}
