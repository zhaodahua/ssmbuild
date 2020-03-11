package com.dahua.controller;

import com.dahua.pojo.Books;
import com.dahua.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


//@RequestMapping注解来将请求URL映射到整个类上,
// 或某个特定的方法上，即@RequestMapping 既可以定义在类上，
//有一个大的映射
@Controller
@RequestMapping("/book")
public class BookController {
    //controller调用service层
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;
    //查询全部书籍，并且返回一个书籍展示页面
    @RequestMapping("/allbook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
        //返回到allbook页面
    }
    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
public String toAddPaper(Books books){
               return "allBook";

}
//添加书籍的请求
@RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addbook="+books);
        bookService.addBook(books);
//重定向
        return "allBook";

    }
    //跳转修改页面
    @RequestMapping("/toUpdate/{book}")
    public String toUpdatePaper(@PathVariable("book") int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("QBook",books);
    return "updateBook";

    }
    //修改书籍
    @RequestMapping("updateBook")
    public String updateBook( Books books){
        System.out.println("->"+books);
        bookService.updateBook(books);
        return "allBook";

    }
    //删除书籍
    //restful风格
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
         bookService.deleteBookId(id);
        return "redirect:/book/allBook";

    }
    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        Books books = bookService.queryBookByName(queryBookName);
        List<Books> list=new ArrayList<Books>();
        list.add(books);


        System.err.println("query=>"+books);
        if (books==null){
             list = bookService.queryAllBook();
             model.addAttribute("error","没找着");

        }

        model.addAttribute("list",list);
        return "allBook";



    }



}
