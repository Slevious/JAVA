import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;


public class BookListFrame extends JFrame {
    private JList listBox;
    private JTextArea bookInfo;

    public BookListFrame(){
        setTitle("Book List");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Book[] list = new Book[5];
        list[0] = new Book("자바 프로그래밍", "저자1", 14000);
        list[1] = new Book("C 프로그래밍", "저자2", 20000);
        list[2] = new Book("소피의 세계", "저자3", 1300);
        list[3] = new Book("숲", "저자4", 20300);
        list[4] = new Book("스토너", "저자5", 23900);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        listBox = new JList(list);
        listBox.addListSelectionListener(new BookListListener());
        panel.add(listBox);

        bookInfo = new JTextArea(6, 20);
        bookInfo.setEditable(false);
        bookInfo.setLineWrap(true);
        bookInfo.setBackground(Color.LIGHT_GRAY);
        bookInfo.setText("도서를 선택");
        panel.add(bookInfo);

        setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        add(panel);
        pack();
    }

    private class BookListListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e){
            if(e.getValueIsAdjusting() == false){
                Book book = (Book)listBox.getSelectedValue();
                bookInfo.setText(book.getFullInfo());
            }
        }
    }
}
