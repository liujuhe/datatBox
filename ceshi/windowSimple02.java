package software.ceshi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class windowSimple02 extends JFrame {
    private JPanel jp;
    private JPanel jp2;
    private JLabel number;
    private JLabel name;
    private JLabel password;
    private JLabel sex;
    private JLabel picture1;
    private JTextField jtf;
    private JTextField jtfName;
    private JComboBox<String> cbxSex;
    private JPasswordField jpf;
    private JButton sign;
    private JButton revert;

    public windowSimple02(){
        liu();
    }

    private void liu() {
        jp=new JPanel();
        jp.setLayout(null);

        name=new JLabel("姓    名:");
        name.setBounds(100,55,90,60);
        name.setFont(new Font("宋体",Font.PLAIN,15));
        name.setLayout(null);

        jtfName=new JTextField(15);
        jtfName.setBounds(200,75,150,20);
        jtfName.setLayout(null);

        sex=new JLabel("性    别:");
        sex.setLayout(null);
        sex.setFont(new Font("宋体",Font.PLAIN,15));
        sex.setBounds(100,135,90,30);

        cbxSex=new JComboBox<String>();
        cbxSex.setBackground(Color.white);
        cbxSex.setModel(new DefaultComboBoxModel<>(new String[]{"","男","女"}));
        cbxSex.setBounds(200,140,60,21);

        number=new JLabel("账    号:");
        number.setBounds(100,215,90,30);
        number.setFont(new Font("宋体",Font.PLAIN,15));
        number.setLayout(null);

        jtf=new JTextField(15);
        jtf.setBounds(200,220,150,20);
        jtf.setLayout(null);

        password=new JLabel("密    码:");
        password.setBounds(100,295,90,30);
        password.setFont(new Font("宋体",Font.PLAIN,15));
        password.setLayout(null);

        jpf=new JPasswordField(15);
        jpf.setBounds(200,300,150,20);
        jpf.setLayout(null);

        sign=new JButton("确定");
        sign.setFont(new Font("宋体",Font.BOLD,12));
        sign.setBounds(230,390,60,30);
        sign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (jtf.getText().equals("")||jpf.getText().equals("")||jtfName.getText().equals("")||cbxSex.getSelectedItem().toString().equals("")){
                    JOptionPane.showMessageDialog(null,"请填写完整的信息！");
                }else {
                    JDBCtb_uesr t=new JDBCtb_uesr();
                    int i=(int) (Math.random()*1000);
                    if(!(jtf.getText().equals(""))){
                        t.delete(jtf.getText());
                    }
                    t.insert(i, jtf.getText(),jpf.getText());
                    dispose();
                    JOptionPane.showMessageDialog(null,"恭喜你！注册更改成功，欢迎来到图书管理系统登录界面！O(∩_∩)O");
                    new windowSimple();
                }
            }
        });
        revert=new JButton("返回");
        revert.setFont(new Font("宋体",Font.BOLD,12));
        revert.setBounds(140,390,60,30);
        revert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null,"欢迎进入登录界面(╯▽╰ )好香~~");
                new windowSimple();
            }
        });
        jp.add(revert);

        picture1=new JLabel(new ImageIcon("C:\\Users\\asus\\Pictures\\Saved Pictures\\3.jpg"));
        picture1.setBounds(-110,-150,1400,900);
        picture1.setLayout(null);

        jp.add(number);
        jp.add(jtf);
        jp.add(sex);
        jp.add(cbxSex);
        jp.add(password);
        jp.add(jpf);
        jp.add(name);
        jp.add(jtfName);
        jp.add(sign);
        jp.add(picture1);
        add(jp);
        setTitle("图书管理系统信息管理界面");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600,200,800,600);
        setResizable(false);
    }

    public static void main(String[] args){
        windowSimple02 w=new windowSimple02();
    }
}
