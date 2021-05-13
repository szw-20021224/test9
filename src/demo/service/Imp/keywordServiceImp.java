package demo.service.Imp;

import demo.dao.BaseDao;
import demo.dao.Imp.keywordDaoImp;
import demo.entity.Keyword;
import demo.service.keywordService;
import demo.util.DBUtil;

import java.sql.Connection;
import java.util.List;

public class keywordServiceImp implements keywordService {
    @Override
    public List<Keyword> getList() {
        Connection conn = null;
        List<Keyword> list = null;
        try {
            //获取连接
            conn = DBUtil.getConn();
            //调用查询方法
            list = new keywordDaoImp(conn).getList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放连接
            BaseDao.closeAll(conn,null,null);
        }
        return list;
    }

    @Override
    public Keyword getById(int id) {
        Connection conn = null;
        try {
            //获取连接
            conn = DBUtil.getConn();
            //调用查询方法
            return new keywordDaoImp(conn).getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放连接
            BaseDao.closeAll(conn,null,null);
        }
        return null;
    }

    @Override
    public int update(Keyword keyword) {
        Connection conn=null;
        int res=0;
        try {
            conn=DBUtil.getConn();
            res=new keywordDaoImp(conn).update(keyword);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,null,null);
        }
        return res;
    }
}
