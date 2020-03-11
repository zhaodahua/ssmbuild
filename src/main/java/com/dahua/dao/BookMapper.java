package com.dahua.dao;

import com.dahua.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookId(@Param("bookId") int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(@Param("bookID") int id);

    //查询全部书
    List<Books> queryAllBook();

    //根据名字查书
    Books queryBookByName(@Param("bookName") String bookName);
}
