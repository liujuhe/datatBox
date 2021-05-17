package software.ceshi;

public class model01 extends javax.swing.table.DefaultTableModel{
    Class[] types=new Class[]{java.lang.String.class,java.lang.String.class};
    boolean[] canEdit={false,false};
    public model01(){
        super(new Object[][]{},new String[]{"借书人姓名","借书人电话"});
    }
    public Class getColumnClass(int columnIndex) {// 获得表头的类类型,
        return types[columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {// 表头是否可编辑
        return canEdit[columnIndex];
    }
}
