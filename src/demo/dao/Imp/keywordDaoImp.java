package demo.dao.Imp;

import demo.dao.BaseDao;
import demo.dao.KeywordDao;
import demo.entity.Keyword;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class keywordDaoImp extends BaseDao implements KeywordDao {

    public keywordDaoImp(Connection conn) {
        super(conn);
    }

    @Override
    public List<Keyword> getList() {
        ResultSet res = null;
        List<Keyword> list = new ArrayList<>();
        try {
            String sql ="SELECT * FROM keyword";
            res = executeQuery(sql);
            while(res.next()){
                Keyword keyword=new Keyword();
                keyword.setId(res.getInt("id"));
                keyword.setName(res.getString("name"));
                keyword.setType(res.getString("type"));
                keyword.setCreateDate(res.getDate("createDate"));
                list.add(keyword);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            closeAll(null,null,res);
        }
        return list;
    }

    @Override
    public Keyword getById(int id) {
        ResultSet res = null;
        List<Keyword> list = new ArrayList<>();
        try {
            String sql ="SELECT * FROM keyword WHERE id=?";
            res = executeQuery(sql,id);
            if (res.next()){
                Keyword keyword=new Keyword();
                keyword.setId(res.getInt("id"));
                keyword.setName(res.getString("name"));
                keyword.setType(res.getString("type"));
                keyword.setCreateDate(res.getDate("createDate"));
                list.add(keyword);
                return keyword;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            closeAll(null,null,res);
        }
        return null;
    }

    @Override
    public int update(Keyword keyword) {
        String sql="UPDATE keyword SET NAME=?,TYPE=?,createDate=? WHERE id=?";
        return  executeUpdate(sql,keyword.getName(),keyword.getType(),keyword.getCreateDate(),keyword.getId());
    }
}
