package demo.service;


import demo.entity.Keyword;

import java.util.List;

public interface keywordService {
    List<Keyword> getList();

    Keyword getById(int id);

    int update(Keyword keyword);
}
