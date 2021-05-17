package software.ceshi;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class windowSimple07 extends JFrame {
    private JTable table;
    private model02 model=new model02();
    private JPanel jp;
    private JButton jb;
    public windowSimple07(){
        liu();
    }

    private void liu() {
        jp=new JPanel();
        jp.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),"图书信息列表",TitledBorder.LEFT,TitledBorder.TOP,null, Color.blue));
        jp.setBounds(10,10,680,580);
        jp.setLayout(null);

        JScrollPane jScrollPane=new JScrollPane();
        jScrollPane.setBounds(10,20,680,500);
        jp.add(jScrollPane);

        table=new JTable(model);
        jScrollPane.setViewportView(table);
        inti(jScrollPane);

        jb=new JButton("返回");
        jb.setBounds(600,530,80,25);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null,"欢迎再次来到图书信息管理界面(｡･∀･)ﾉﾞ嗨");
                new windowSimple05();
            }
        });
        jp.add(jb);

        add(jp);
        setTitle("图书列表窗口");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(600,200,700,600);
    }

    public void inti(JScrollPane jScrollPane){
        JDBCWindow j=new JDBCWindow();
        List<userBooks> list=j.check();
        for (userBooks l:list){
            model.addRow(new Object[]{l.getId(),l.getBoook_name(),l.getISBN(),l.getBook_price(),l.getBook_author(),l.getPublished_house()});
        }
    }
}
