package software.ceshi;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class windowSimple03 extends JFrame{
    private JPanel  jp;
    private JLabel  picture;
    private JLabel  picture02;
    private JButton jb1;
    private JButton jb2;
    private JButton jb3;
    private JButton jb4;
    public windowSimple03(){
        liu();
    }

    private void liu() {
        jp=new JPanel();
        jp.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),"选择查询条件",TitledBorder.LEADING,TitledBorder.TOP,null, Color.BLUE));
        jp.setBounds(10,10,409,500);
        jp.setLayout(null);

        picture=new JLabel(new ImageIcon("C:\\Users\\asus\\Pictures\\Saved Pictures\\4.jpg"));
        picture.setBounds(210,-280,300,900);
        picture.setLayout(null);

        picture02=new JLabel(new ImageIcon("C:\\Users\\asus\\Pictures\\Saved Pictures\\6.jpg"));
        picture02.setBounds(235,350,320,200);
        picture02.setLayout(null);

        jb1=new JButton("借阅图书管理");
        jb1.setBounds(20,80,200,50);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new windowSimple04();
            }
        });

        jb2=new JButton("图书信息管理");
        jb2.setBounds(20,180,200,50);
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new windowSimple05();
            }
        });

        jb3=new JButton("更改密码");
        jb3.setBounds(20,280,200,50);
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null,"欢迎来到图书馆信息管理界面！ヾ(≧▽≦*)o");
                new windowSimple02();
            }
        });

        jb4=new JButton("退出图书管理系统");
        jb4.setBounds(20,380,200,50);
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null,"退出成功！欢迎下次使用图书管理系统，/(ㄒoㄒ)/~~");
                new windowSimple();
            }
        });

        jp.add(picture02);
        jp.add(picture);
        jp.add(jb2);
        jp.add(jb1);
        jp.add(jb3);
        jp.add(jb4);
        add(jp);
        setTitle("图书管理系统界面");
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600,200,500,600);
    }
    public static void main(String[] args){
        windowSimple03 w=new windowSimple03();
    }
}
