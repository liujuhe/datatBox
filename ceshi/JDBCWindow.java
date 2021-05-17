package software.ceshi;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCWindow {
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/hicc?useUnicode=true&characterEncoding=gbk";
    Connection conn=null;
    public Connection getConn(){
        try {
            //加载驱动
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String uesrName="root";
        String passWord="root";
        try {
            conn= (Connection) DriverManager.getConnection(DB_URL,uesrName,passWord);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public int insert(Integer id,String name,String ISBN,Double price,String author,String house,String borrowName,String borrowPhone){
        conn=getConn();
        Statement sta=null;
        int num=0;
        try{
            sta=conn.createStatement();
            String sql="INSERT INTO tb_books values ";
            if (!(id==null)){
                sql=sql+"("+id+",";
            }
            if (!(name==null)){
                sql=sql+"'"+name+"',";
            }
            if (!(ISBN==null)){
                sql=sql+"'"+ISBN+"',";
            }
            if (!(price==null)){
                sql=sql+"'"+price+"',";
            }
            if (!(author==null)){
                sql=sql+"'"+author+"',";
            }
            if (!(house==null)){
                sql=sql+"'"+house+"',";
            }
            if (!(borrowName==null)){
                sql=sql+"'"+borrowName+"',";
            }
            if (!(borrowPhone==null)){
                sql=sql+"'"+borrowPhone+"');";
            }
            num=sta.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                getConn().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return num;
    }

    public int updata(Integer id,String name,String ISBN,Double price,String author,String house,String borrowName,String borrowPhone){
        conn=getConn();
        Statement sta=null;
        int num=0;
        try {
            sta=conn.createStatement();
            String sql="UPDATE tb_books SET";
            if (!(name==null)){
                sql=sql+" Boook_name='"+name+"'";
            }
            if (!(ISBN==null)){
                sql=sql+" ,ISBN="+ISBN;
            }
            if (!(price==null)){
                sql=sql+" ,Book_price="+price;
            }
            if (!(author==null)){
                sql=sql+" ,Book_author='"+author+"'";
            }
            if (!(house==null)){
                sql=sql+" ,Published_house='"+house+"'";
            }
            if (!(borrowName==null)){
                sql=sql+" ,Borrower_name='"+borrowName+"'";
            }
            if (!(borrowPhone==null)){
                sql=sql+" ,Borrower_phone='"+borrowPhone+"'";
            }
            if (!(id==null)){
                sql=sql+" WHERE ID="+id+";";
            }
            num=sta.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return num;
    }
    public int delete(Integer id){
        conn=getConn();
        Statement sta=null;
        int num=0;
        try {
            sta= conn.createStatement();
            String sql="DELETE FROM tb_books WHERE ID= ";
            if (!(id==0)){
                sql=sql+id;
            }
           num=sta.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return num;
    }
    public List<userBooks> check(){
        conn=getConn();
        Statement sta=null;
        ResultSet rs=null;
        List<userBooks> list=new ArrayList<>();
        try {
            sta=conn.createStatement();
            String sql="SELECT * FROM tb_books";
            rs=sta.executeQuery(sql);
            while (rs.next()){
                userBooks u=new userBooks();
                u.setId(rs.getInt(1));
                u.setBoook_name(rs.getString(2));
                u.setISBN(rs.getInt(3));
                u.setBook_price(rs.getDouble(4));
                u.setBook_author(rs.getString(5));
                u.setPublished_house(rs.getString(6));
                u.setBorrower_name(rs.getString(7));
                u.setBorrower_phone(rs.getString(8));
                list.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }
}
