package demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
    //定义连接conn
    private Connection conn = null;

    //构造设置连接conn
    public BaseDao(Connection conn) {
        this.conn = conn;
    }

    /**
     * 关闭所有链接
     * @param conn
     * @param pstm
     * @param res
     */
    public static void closeAll(Connection conn, PreparedStatement pstm , ResultSet res){
        if(res != null){
            try {
                res.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(pstm != null){
            try {
                pstm.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 通用修改方法
     * @param sql
     * @param params
     * @return
     */
    public int executeUpdate(String sql,Object... params){
        PreparedStatement pstm = null;
        int res = 0;
        try {
            pstm = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstm.setObject(i+1,params[i]);
            }
            res = pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }

    /**
     * 通用查询方法
     * @param sql
     * @param params
     * @return
     */
    public ResultSet executeQuery(String sql,Object... params){
        PreparedStatement pstm = null;
        ResultSet res = null;
        try {
            pstm = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstm.setObject(i+1,params[i]);
            }
            res = pstm.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return res;
    }
}
