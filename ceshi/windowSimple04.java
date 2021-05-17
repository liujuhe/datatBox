package software.ceshi;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class windowSimple04 extends JFrame {
    private JPanel jp;
    private JLabel jlId;
    private JLabel jlName;
    private JLabel jlISBN;
    private JLabel jlPrice;
    private JLabel jlAuthor;
    private JLabel jlHouse;
    private JLabel jlbName;
    private JLabel jlbNhone;
    private JTextField jtID;
    private JTextField jtName;
    private JTextField jtISBN;
    private JTextField jtPrice;
    private JTextField jtAuthor;
    private JTextField jtHouse;
    private JTextField jtbName;
    private JTextField jtbPhone;
    private JButton jb;
    private JButton jb1;
    private JButton query;
    public windowSimple04(){
        liu();
    }

    private void liu() {
        jp=new JPanel();
        jp.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),"写入还书信息",TitledBorder.LEADING,TitledBorder.TOP,null, Color.magenta));
        jp.setBounds(10,10,300,400);
        jp.setLayout(null);

        jlId=new JLabel("图书编号:");
        jlId.setFont(new Font("宋体",Font.PLAIN,20));
        jlId.setBounds(60,30,90,20);
        jp.add(jlId);

        jtID=new JTextField(15);
        jtID.setBounds(180,30,180,25);
        jp.add(jtID);

        jlName=new JLabel("图书书名:");
        jlName.setFont(new Font("宋体",Font.PLAIN,20));
        jlName.setBounds(60,80,90,20);
        jp.add(jlName);

        jtName=new JTextField(15);
        jtName.setBounds(180,80,180,25);
        jp.add(jtName);

        jlISBN=new JLabel("I S B N :");
        jlISBN.setFont(new Font("宋体",Font.PLAIN,20));
        jlISBN.setBounds(60,130,90,20);
        jp.add(jlISBN);

        jtISBN=new JTextField(15);
        jtISBN.setBounds(180,130,180,25);
        jp.add(jtISBN);

        jlPrice=new JLabel("图书价格:");
        jlPrice.setFont(new Font("宋体",Font.PLAIN,20));
        jlPrice.setBounds(60,180,90,20);
        jp.add(jlPrice);

        jtPrice=new JTextField(15);
        jtPrice.setBounds(180,180,180,25);
        jp.add(jtPrice);

        jlAuthor=new JLabel("图书作者:");
        jlAuthor.setFont(new Font("宋体",Font.PLAIN,20));
        jlAuthor.setBounds(60,230,90,20);
        jp.add(jlAuthor);

        jtAuthor=new JTextField(15);
        jtAuthor.setBounds(180,230,180,25);
        jp.add(jtAuthor);

        jlHouse=new JLabel("出版社  :");
        jlHouse.setFont(new Font("宋体",Font.PLAIN,20));
        jlHouse.setBounds(60,280,90,20);
        jp.add(jlHouse);

        jtHouse=new JTextField(15);
        jtHouse.setBounds(180,280,180,25);
        jp.add(jtHouse);

        jlbName=new JLabel("借书人  :");
        jlbName.setFont(new Font("宋体",Font.PLAIN,20));
        jlbName.setBounds(60,330,90,20);
        jp.add(jlbName);

        jtbName=new JTextField(15);
        jtbName.setBounds(180,330,180,25);
        jp.add(jtbName);

        jlbNhone=new JLabel("电   话 :");
        jlbNhone.setFont(new Font("宋体",Font.PLAIN,20));
        jlbNhone.setBounds(60,380,90,20);
        jp.add(jlbNhone);

        jtbPhone=new JTextField(15);
        jtbPhone.setBounds(180,380,180,25);
        jp.add(jtbPhone);

        jb=new JButton("确定");
        jb.setBounds(290,420,60,30);
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
                    j.updata(Integer.valueOf(jtID.getText()),jtName.getText(),jtISBN.getText(),Double.valueOf(jtPrice.getText()),jtAuthor.getText(),jtHouse.getText(),jtbName.getText(),jtbPhone.getText());
                    dispose();
                    JOptionPane.showMessageDialog(null,"归还成功！(●ˇ∀ˇ●)");
                    new windowSimple04();
                }else{
                    JOptionPane.showMessageDialog(null,"请将还书信息填写完整！ԅ(¯﹃¯ԅ)");
                }
            }
        });

        jb1=new JButton("返回");
        jb1.setBounds(180,420,60,30);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null,"欢迎再次来到图书信息管理系统！( ఠൠఠ )ﾉ");
                new windowSimple03();
            }
        });
        jp.add(jb1);

        query=new JButton("查询");
        query.setBounds(60,420,60,30);
        query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new windowSimple06();
            }
        });
        jp.add(query);

        add(jp);
        setTitle("归还图书系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600,200,400,500);
        setVisible(true);
        setResizable(false);
    }
}
