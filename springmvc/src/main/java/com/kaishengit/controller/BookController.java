package com.kaishengit.controller;

import com.google.common.collect.Lists;
import com.kaishengit.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model,
                       @RequestParam(required = false,defaultValue = "1") Integer p) {

        System.out.println("PageNo:" + p);

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
    public String saveBook(Book book, String pubName, RedirectAttributes redirectAttributes) {
        System.out.println("BookName:" + book.getBookName() + "  BookPrice:" + book.getBookPrice() + " PubName:" + pubName);

        redirectAttributes.addFlashAttribute("message","添加新书籍成功");
        return "redirect:/book";
    }

    @RequestMapping(value = "/{bookId:\\d+}",method = RequestMethod.GET)
    public String viewBook(@PathVariable Integer bookId) {
        System.out.println("ID:" + bookId);
        return "redirect:/book";
    }

    @RequestMapping(value = "/list.json",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Book> list2(@RequestHeader("User-Agent") String userAgent,
                            @CookieValue(value = "names",defaultValue = "other") String name) {

        System.out.println("User-Agent:" + userAgent);
        System.out.println("Name:" + name);

        Book book1 = new Book(1,"Head First Java",56.5F);
        Book book2 = new Book(3,"JavaScript从入门到精通",45F);
        Book book3 = new Book(5,"Spring源码解析",88F);

        return Lists.newArrayList(book1,book2,book3);
    }

    @RequestMapping(value = "/{id:\\d+}.json",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Book viewBook(HttpServletRequest request, HttpServletResponse response,
                         HttpSession session, ServletContext servletContext) {
        return new Book(1,"Head First Java",56.5F);
    }


    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String upload() {
        return "book/upload";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(MultipartFile doc) throws IOException {
        System.out.println("getOriginalFileName:" + doc.getOriginalFilename());
        System.out.println("getName:" + doc.getName());
        System.out.println("getContentType:" + doc.getContentType());
        System.out.println("getSize:" + doc.getSize());

        InputStream inputStream = doc.getInputStream();
        //...

        return "redirect:/book/upload";
    }


}
