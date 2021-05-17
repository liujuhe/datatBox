package software.ceshi;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class windowSimple05 extends JFrame {
    private JPanel jp;
    private JPanel jp1;
    private JPanel jp2;
    private JLabel jlId;
    private JLabel jlName;
    private JLabel jlISBN;
    private JLabel jlPrice;
    private JLabel jlAuthor;
    private JLabel jlHouse;
    private JLabel jlbName;
    private JLabel jlbNhone;
    private JLabel jlId2;
    private JLabel jlName2;
    private JLabel jlISBN2;
    private JLabel jlPrice2;
    private JLabel jlAuthor2;
    private JLabel jlHouse2;
    private JLabel jlbName2;
    private JLabel jlbNhone2;
    private JLabel jlId3;
    private JLabel jlPictrue;
    private JTextField jtID3;
    private JTextField jtID;
    private JTextField jtName;
    private JTextField jtISBN;
    private JTextField jtPrice;
    private JTextField jtAuthor;
    private JTextField jtHouse;
    private JTextField jtbName;
    private JTextField jtbPhone;
    private JTextField jtID2;
    private JTextField jtName2;
    private JTextField jtISBN2;
    private JTextField jtPrice2;
    private JTextField jtAuthor2;
    private JTextField jtHouse2;
    private JTextField jtbName2;
    private JTextField jtbPhone2;
    private JButton jb;
    private JButton jb1;
    private JButton jb0;
    private JButton jb3;
    private JButton jb4;

    public windowSimple05() {
        liu();
    }

    private void liu() {
        jp=new JPanel();
        jp.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),"设置增加图书信息",TitledBorder.LEFT,TitledBorder.TOP,null, Color.blue));
        jp.setBounds(10,10,300,600);
        jp.setLayout(null);

        jp1=new JPanel();
        jp1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),"设置修改图书信息",TitledBorder.LEADING,TitledBorder.TOP,null, Color.PINK));
        jp1.setBounds(310,10,300,600);
        jp1.setLayout(null);

        jp2=new JPanel();
        jp2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),"设置删除图书信息",TitledBorder.LEADING,TitledBorder.TOP,null, Color.red));
        jp2.setBounds(610,10,300,600);
        jp2.setLayout(null);

        jlId=new JLabel("图书编号:");
        jlId.setFont(new Font("宋体",Font.PLAIN,20));
        jlId.setBounds(20,50,90,20);
        jp.add(jlId);

        jtID=new JTextField(15);
        jtID.setBounds(140,50,150,25);
        jp.add(jtID);

        jlName=new JLabel("图书书名:");
        jlName.setFont(new Font("宋体",Font.PLAIN,20));
        jlName.setBounds(20,100,90,20);
        jp.add(jlName);

        jtName=new JTextField(15);
        jtName.setBounds(140,100,150,25);
        jp.add(jtName);

        jlISBN=new JLabel("I S B N :");
        jlISBN.setFont(new Font("宋体",Font.PLAIN,20));
        jlISBN.setBounds(20,150,90,20);
        jp.add(jlISBN);

        jtISBN=new JTextField(15);
        jtISBN.setBounds(140,150,150,25);
        jp.add(jtISBN);

        jlPrice=new JLabel("图书价格:");
        jlPrice.setFont(new Font("宋体",Font.PLAIN,20));
        jlPrice.setBounds(20,210,90,20);
        jp.add(jlPrice);

        jtPrice=new JTextField(15);
        jtPrice.setBounds(140,210,150,25);
        jp.add(jtPrice);

        jlAuthor=new JLabel("图书作者:");
        jlAuthor.setFont(new Font("宋体",Font.PLAIN,20));
        jlAuthor.setBounds(20,270,90,20);
        jp.add(jlAuthor);

        jtAuthor=new JTextField(15);
        jtAuthor.setBounds(140,270,150,25);
        jp.add(jtAuthor);

        jlHouse=new JLabel("出版社  :");
        jlHouse.setFont(new Font("宋体",Font.PLAIN,20));
        jlHouse.setBounds(20,330,90,20);
        jp.add(jlHouse);

        jtHouse=new JTextField(15);
        jtHouse.setBounds(140,330,150,25);
        jp.add(jtHouse);

        jlbName=new JLabel("借书人  :");
        jlbName.setFont(new Font("宋体",Font.PLAIN,20));
        jlbName.setBounds(20,390,90,20);
        jp.add(jlbName);

        jtbName=new JTextField(15);
        jtbName.setBounds(140,390,150,25);
        jp.add(jtbName);

        jlbNhone=new JLabel("电   话 :");
        jlbNhone.setFont(new Font("宋体",Font.PLAIN,20));
        jlbNhone.setBounds(20,450,90,20);
        jp.add(jlbNhone);

        jtbPhone=new JTextField(15);
        jtbPhone.setBounds(140,450,150,25);
        jp.add(jtbPhone);

        jb=new JButton("确定");
        jb.setBounds(210,510,60,30);
        jp.add(jb);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDBCWindow j=new JDBCWindow();
                if (!("".equals(jtID.getText())
                        &&"".equals(jtName.getText())
                        &&"".equals(jtISBN.getText())
                        &&"".equals(jtPrice.getText())
                        &&"".equals(jtAuthor.getText())
                        &&"".equals(jtHouse.getText())
                        &&"".equals(jtbName.getText())
                        &&"".equals(jtbPhone.getText()))){
                    j.insert(Integer.valueOf(jtID.getText()),jtName.getText(),jtISBN.getText(),Double.valueOf(jtPrice.getText()),jtAuthor.getText(),jtHouse.getText(),jtbName.getText(),jtbPhone.getText());
                    dispose();
                    JOptionPane.showMessageDialog(null,"添加成功！(●ˇ∀ˇ●)");
                    new windowSimple05();
                }else{
                    JOptionPane.showMessageDialog(null,"请将还书信息填写完整！ԅ(¯﹃¯ԅ)");
                }
            }
        });

        jb1=new JButton("返回");
        jb1.setBounds(125,510,60,30);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null,"欢迎来到信息管理界面！(❤ ω ❤)");
                new windowSimple03();
            }
        });
        jp.add(jb1);

        jb4=new JButton("查询");
        jb4.setBounds(40,510,60,30);
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new windowSimple07();
            }
        });
        jp.add(jb4);

        jlId2=new JLabel("图书编号:");
        jlId2.setFont(new Font("宋体",Font.PLAIN,20));
        jlId2.setBounds(20,50,90,20);
        jp1.add(jlId2);

        jtID2=new JTextField(15);
        jtID2.setBounds(140,50,150,25);
        jp1.add(jtID2);

        jlName2=new JLabel("图书书名:");
        jlName2.setFont(new Font("宋体",Font.PLAIN,20));
        jlName2.setBounds(20,100,90,20);
        jp1.add(jlName2);

        jtName2=new JTextField(15);
        jtName2.setBounds(140,100,150,25);
        jp1.add(jtName2);

        jlISBN2=new JLabel("I S B N :");
        jlISBN2.setFont(new Font("宋体",Font.PLAIN,20));
        jlISBN2.setBounds(20,150,90,20);
        jp1.add(jlISBN2);

        jtISBN2=new JTextField(15);
        jtISBN2.setBounds(140,150,150,25);
        jp1.add(jtISBN2);

        jlPrice2=new JLabel("图书价格:");
        jlPrice2.setFont(new Font("宋体",Font.PLAIN,20));
        jlPrice2.setBounds(20,210,90,20);
        jp1.add(jlPrice2);

        jtPrice2=new JTextField(15);
        jtPrice2.setBounds(140,210,150,25);
        jp1.add(jtPrice2);

        jlAuthor2=new JLabel("图书作者:");
        jlAuthor2.setFont(new Font("宋体",Font.PLAIN,20));
        jlAuthor2.setBounds(20,270,90,20);
        jp1.add(jlAuthor2);

        jtAuthor2=new JTextField(15);
        jtAuthor2.setBounds(140,270,150,25);
        jp1.add(jtAuthor2);

        jlHouse2=new JLabel("出版社  :");
        jlHouse2.setFont(new Font("宋体",Font.PLAIN,20));
        jlHouse2.setBounds(20,330,90,20);
        jp1.add(jlHouse2);

        jtHouse2=new JTextField(15);
        jtHouse2.setBounds(140,330,150,25);
        jp1.add(jtHouse2);

        jlbName2=new JLabel("借书人  :");
        jlbName2.setFont(new Font("宋体",Font.PLAIN,20));
        jlbName2.setBounds(20,390,90,20);
        jp1.add(jlbName2);

        jtbName2=new JTextField(15);
        jtbName2.setBounds(140,390,150,25);
        jp1.add(jtbName2);

        jlbNhone2=new JLabel("电   话 :");
        jlbNhone2.setFont(new Font("宋体",Font.PLAIN,20));
        jlbNhone2.setBounds(20,450,90,20);
        jp1.add(jlbNhone2);

        jtbPhone2=new JTextField(15);
        jtbPhone2.setBounds(140,450,150,25);
        jp1.add(jtbPhone2);

        jb0=new JButton("确定");
        jb0.setBounds(160,510,60,30);
        jp1.add(jb0);
        jb0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDBCWindow j=new JDBCWindow();
                if (!("".equals(jtID2.getText())
                        &&"".equals(jtName2.getText())
                        &&"".equals(jtISBN2.getText())
                        &&"".equals(jtPrice2.getText())
                        &&"".equals(jtAuthor2.getText())
                        &&"".equals(jtHouse2.getText())
                        &&"".equals(jtbName2.getText())
                        &&"".equals(jtbPhone2.getText()))){
                    j.updata(Integer.valueOf(jtID2.getText()),jtName2.getText(),jtISBN2.getText(),Double.valueOf(jtPrice2.getText()),jtAuthor2.getText(),jtHouse2.getText(),jtbName2.getText(),jtbPhone2.getText());
                    dispose();
                    JOptionPane.showMessageDialog(null,"修改成功！(●ˇ∀ˇ●)");
                    new windowSimple05();
                }else{
                    JOptionPane.showMessageDialog(null,"请将修改信息填写完整!d=====(￣▽￣*)b");
                }
            }
        });

        jlId3=new JLabel("输入要删除图书的编号:");
        jlId3.setBounds(20,50,220,20);
        jlId3.setFont(new Font("宋体",Font.PLAIN,20));
        jp2.add(jlId3);

        jtID3=new JTextField(15);
        jtID3.setBounds(20,100,220,25);
        jp2.add(jtID3);

        jb3=new JButton("确定");
        jb3.setBounds(170,150,90,25);
        jp2.add(jb3);
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDBCWindow j=new JDBCWindow();
                if(!(jtID3.getText().equals(""))){
                    String s=jtID3.getText();
                    j.delete(Integer.valueOf(s));
                    dispose();
                    JOptionPane.showMessageDialog(null,"删除成功！(●ˇ∀ˇ●)");
                    new windowSimple05();
                }else{
                    JOptionPane.showMessageDialog(null,"请输入要删除的图书编号！╰（‵□′）╯");
                }
            }
        });

        jlPictrue=new JLabel(new ImageIcon("C:\\Users\\asus\\Pictures\\Saved Pictures\\7.jpg"));
        jlPictrue.setBounds(10,150,270,500);
        jp2.add(jlPictrue);

        add(jp2);
        add(jp1);
        add(jp);
        setLayout(null);
        setTitle("图书信息管理界面");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600,200,900,600);
    }
}
