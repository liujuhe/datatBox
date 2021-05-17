package software.ceshi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class windowSimple {
    private JPanel jp;
    private JLabel number;
    private JLabel password;
    private JLabel picture;
    private JTextField jtf;
    private JPasswordField jpf;
    private JButton sign;
    private JButton register;
    public windowSimple(){
        liu();
    }

    private void liu() {
        JFrame jf=new JFrame();
        jp=new JPanel();

        number=new JLabel("账    号:");
        number.setBounds(20,10,95,15);
        number.setFont(new Font("宋体",Font.PLAIN,13));

        jtf=new JTextField(15);
        jtf.setBounds(110,10,95,15);

        password=new JLabel("密    码:");
        password.setBounds(200,10,75,15);
        password.setFont(new Font("宋体",Font.PLAIN,13));

        jpf=new JPasswordField(15);
        jpf.setBounds(280,10,75,15);

        sign=new JButton("登录");
        sign.setFont(new Font("楷体",Font.BOLD,13));
        sign.setBounds(370,10,95,15);
        sign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean sign=true;
                JDBCtb_uesr j=new JDBCtb_uesr();
                List<administrators> list=j.select();
                for (administrators l:list){
                    if ((l.getUsername().equals(jtf.getText())&&l.getPassword().equals(jpf.getText()))){
                        jf.dispose();
                        sign=false;
                        JOptionPane.showMessageDialog(null,"登录成功，欢迎使用图书管理系统！O(∩_∩)O");
                        new windowSimple03();
                    }
                }
                if (sign){
                    JOptionPane.showMessageDialog(null,"输入的账号或密码错误！请重新输入");
                }
            }
        });

        register=new JButton("注册");
        register.setFont(new Font("楷体",Font.BOLD,13));
        register.setBounds(460,10,95,15);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                new windowSimple02();
            }
        });

        picture=new JLabel(new ImageIcon("C:\\Users\\asus\\Pictures\\Saved Pictures\\1.png"));
        picture.setBounds(0,30,800,570);

        jp.add(number);
        jp.add(jtf);
        jp.add(password);
        jp.add(jpf);
        jp.add(sign);
        jp.add(register);
        jp.add(picture);
        jf.add(jp);
        jf.setTitle("图书管理系统登录界面");
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setBounds(600,200,800,600);
        jf.setResizable(false);

    }

    public static void main(String[] args) {
        windowSimple w=new windowSimple();
    }
}
