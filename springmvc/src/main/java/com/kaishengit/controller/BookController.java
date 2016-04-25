package com.kaishengit.controller;

import com.google.common.collect.Lists;
import com.kaishengit.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {

        Book book1 = new Book(1,"Head First Java",56.5F);
        Book book2 = new Book(3,"JavaScript从入门到精通",45F);
        Book book3 = new Book(5,"Spring源码解析",88F);

        List<Book> bookList = Lists.newArrayList(book1,book2,book3);

        model.addAttribute("bookList",bookList);
        return "book/list";
    }


    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public ModelAndView newBook() {

        ModelAndView mav = new ModelAndView("book/new");
        //mav.setViewName();
        mav.addObject("pubName","人民邮电出版社");
        return mav;
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String saveBook(Book book,String pubName) {
        System.out.println("BookName:" + book.getBookName() + "  BookPrice:" + book.getBookPrice() + " PubName:" + pubName);
        return "redirect:/book";
    }

    @RequestMapping(value = "/{bookId:\\d+}",method = RequestMethod.GET)
    public String viewBook(@PathVariable Integer bookId) {
        System.out.println("ID:" + bookId);
        return "redirect:/book";
    }

}
