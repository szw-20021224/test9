package demo.dao;

import demo.entity.Keyword;

import java.util.List;

public interface KeywordDao {
    List<Keyword> getList();

    Keyword getById(int id);

    int update(Keyword keyword);
}
