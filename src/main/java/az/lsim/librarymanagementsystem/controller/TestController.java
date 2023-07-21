package az.lsim.librarymanagementsystem.controller;

import az.lsim.librarymanagementsystem.model.Book;
import az.lsim.librarymanagementsystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/books/all")
@RequiredArgsConstructor
public class TestController {

    private final BookService bookService;

    //master
    //masasasasa

    @GetMapping
    public List<Book> getAllBoks() {
        return bookService.getAllBooks();
    }

}
