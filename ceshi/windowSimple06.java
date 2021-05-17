package software.ceshi;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class windowSimple06 extends JFrame {
    private JTable table;
    private JPanel jp;
    private model01 model=new model01();
    private JButton jb;
    public windowSimple06(){
        liu();
    }

    private void liu() {
        jp=new JPanel();
        jp.setLayout(null);
        jp.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),"借书人表格",TitledBorder.LEADING,TitledBorder.TOP,null, Color.BLUE));
        jp.setBounds(10,10,350,450);
        setContentPane(getContentPane());//设置内容窗格

        JScrollPane jScrollPane=new JScrollPane();
        jScrollPane.setBounds(5,20,330,350);
        jp.add(jScrollPane);

        table=new JTable(model);
        jScrollPane.setViewportView(table);
        abouts(jScrollPane);

        jb=new JButton("返回");
        jb.setBounds(130,380,70,30);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null,"欢迎再次来到图书借阅管理系统o(*^▽^*)┛");
                new windowSimple04();
            }
        });
        jp.add(jb);

        add(jp);
        setTitle("图书借阅信息显示");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setBounds(600,200,350,450);
    }

    public void abouts(JScrollPane jScrollPane){
        JDBCWindow j=new JDBCWindow();
        List<userBooks> list=j.check();
        for (userBooks l:list) {
            model.addRow(new Object[]{l.getBorrower_name(), l.getBorrower_phone()});
        }
    }
}
