package demo.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    //定义一个context 对象
    private static Context ctx = null;
    private static DataSource ds= null;
    static {
        try {
            //加载context对象
            ctx = new InitialContext();
            //获取连接池 数据集
            ds= (DataSource)ctx.lookup("java:comp/env/news");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取连接池中的 连接
     * @return
     */
    public static Connection getConn(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
