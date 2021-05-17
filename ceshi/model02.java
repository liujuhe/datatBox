package software.ceshi;

public class model02 extends javax.swing.table.DefaultTableModel{
    Class[] types=new Class[]{java.lang.String.class,java.lang.String.class,java.lang.String.class,
                            java.lang.String.class,java.lang.String.class,java.lang.String.class};
    boolean[] canEdit={false,false,false,false,false,false};

    public model02(){
        super(new Object[][]{},new String[]{"图书编号","图书名称","ISBN","图书价格","图书作者","出版社"});
    }

    public Class getColumnClass(int columnIndex) {// 获得表头的类类型,
        return types[columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {// 表头是否可编辑
        return canEdit[columnIndex];
    }
}
