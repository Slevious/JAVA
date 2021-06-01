import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MyFrame extends JFrame implements ActionListener{

    private ArrayList<Movie> movieList;
    private JTextField title, year, grade;
    private JTextArea textArea;

    public MyFrame(){
        setSize(330,330);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("2020270758 임광민 Movie List");

        movieList = new ArrayList<>();

        Container cPane = getContentPane();
        cPane.setLayout(new FlowLayout(FlowLayout.CENTER,5, 10));
        cPane.add(new JLabel("영화 제목"));
        title = new JTextField(20);
        cPane.add(title);
        cPane.add(new JLabel("개봉 연도"));
        year = new JTextField(20);
        cPane.add(year);
        cPane.add(new JLabel("영화 평점"));
        grade = new JTextField(20);
        cPane.add(grade);

        JButton register = new JButton("영화 등록");
        cPane.add(register);
        JButton search = new JButton("영화 검색");
        cPane.add(search);
        JButton delete = new JButton("영화 삭제"); //위의 코드를 응용한, JButton delete를 구현.
        cPane.add(delete);

        textArea = new JTextArea(8,25);
        textArea.setEditable(false);
        cPane.add(textArea);
        textArea.setText("영화 삭제 후 새로운 영화 등록시 옳바르게 출력됨");
        //일부 오류로 인해 작성한, 결과 확인을 위한 가이드 , setText를 통해 gui 컨테이너에 문구를 넣었다.

        register.addActionListener(this);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result ="";
                if(year.getText().trim().equals(""))
                    return;
                int inYear = Integer.parseInt(year.getText().trim());
                for(Movie m: movieList){
                    if(inYear ==m.getReleaseYear())
                        result += m.toString() + "\n";
                }
                textArea.setText(result);
            }
        });

        delete.addActionListener(new ActionListener() { //ActionListener의 오버라이드를 통한 delete선택시의 함구 수현
            @Override
            public void actionPerformed(ActionEvent e) {
                String result ="";
                String inTitle = title.getText().trim();

                    for (Movie m : movieList) {
                        for (int i = 0; i < movieList.size(); i++) { //movieList의 사이즈보다 작은 수까지 i가 증가한다.
                            try{
                                if (movieList.get(i).getTitle().equals(inTitle)) {  //반복되는 과정에서 movieList의 i번째 제목이 inTitle과 같으면
                                    movieList.remove(i); //해당 i번째 movieList를 삭제

                                    result += m.toString() + "\n"; //이후 이를 텍스트로 편집
                                    throw new Exception("새로운 영화를 등록해주시면 옳바르게 출력됩니다."); //에러에 대한 안내문
                                    }
                            }
                            catch (Exception exception){
                                exception.printStackTrace();
                            }
                        }
                        textArea.setText(result); //이후 result의 출력
                    }
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e){
        int inYear = Integer.parseInt(this.year.getText().trim());
        double inGrade = Double.parseDouble(this.grade.getText().trim());
        movieList.add(new Movie(title.getText().trim(), inYear, inGrade));
        String result = "";
        for(Movie m : movieList)
            result += m.toString() + "\n";
        textArea.setText(result);
        title.setText("");
        year.setText("");
        grade.setText("");

    }
}
