package az.lsim.librarymanagementsystem.controller;

import az.lsim.librarymanagementsystem.model.Book;
import az.lsim.librarymanagementsystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }


    @GetMapping("/new")
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "create_book";
    }

    @PostMapping
    public String saveStudent(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "redirect:/api/books";
    }

    @GetMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/api/books";
    }

    @GetMapping("edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "edit_book";
    }

    @PostMapping("/{id}")
    public String updateBook(@PathVariable Long id,@ModelAttribute("book") Book book){
        Book book1=bookService.getBookById(id);
        book1.setAuthor(book.getAuthor());
        book1.setGenre(book.getGenre());
        book1.setName(book.getName());
        bookService.addBook(book1);
        return "redirect:/api/books";
    }

}
