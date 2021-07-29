import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.*;

public class Sol10 extends JFrame{
    JButton btnLogin , btn;
    JTextField text;
    JPasswordField pw;

    Sol10() {
        setTitle("로그인 화면");
        JPanel panel = new JPanel();
        btnLogin = new JButton("로그인");
        btn = new JButton("취소");
        text = new JTextField("로그인 성공");
        pw = new JPasswordField("PW");
        panel.add(pw);
        panel.add(text);
        panel.add(btnLogin);
        panel.add(btn);
        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
//        Map<Integer , Integer> map = new HashMap<Integer,Integer>();
//        map.put(1,map.getOrDefault(1, 2) + 1);
        new Sol10();
    }
}
