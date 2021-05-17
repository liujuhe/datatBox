package software.ceshi;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCtb_uesr {
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/hicc?&useUnicode=true&characterEncoding=gbk";
    Connection conn=null;
    public Connection getConn(){
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String userName="root";
        String passWord="root";
        try {
            conn= (Connection) DriverManager.getConnection(DB_URL,userName,passWord);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public int insert(Integer id,String username,String password){
        conn=getConn();
        Statement sta=null;
        int num=0;
        try {
            sta=conn.createStatement();
            String sql="INSERT INTO tb_user VALUES ";
            if (!(id==null)){
                sql=sql+"("+id+",";
            }
            if (!(username==null)){
                sql=sql+"'"+username+"',";
            }
            if (!(password==null)){
                sql=sql+"'"+password+"');";
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
    public int delete(String userName){
        conn=getConn();
        Statement sta=null;
        int num=0;
        try {
            sta= conn.createStatement();
            String sql="DELETE FROM tb_user WHERE User= ";
            if (!("".equals(userName))){
                sql=sql+"'"+userName+"'";
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

    public List<administrators> select(){
        conn=getConn();
        Statement sta=null;
        ResultSet rs=null;
        List<administrators> list=new ArrayList<>();
        try {
            sta=conn.createStatement();
            String str="SELECT * FROM tb_user";
            rs=sta.executeQuery(str);
            while(rs.next()){
                administrators a=new administrators();
                a.setId(rs.getInt(1));
                a.setUsername(rs.getString(2));
                a.setPassword(rs.getString(3));
                list.add(a);
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
