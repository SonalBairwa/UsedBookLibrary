package weappProject5.Controller;

import weappProject5.Model.Book;
import weappProject5.Repository.BookRepository;
import weappProject5.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    private final BookRepository libRepo;

    @Autowired
    public BookController(BookRepository libRepo) {
        this.libRepo = libRepo;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping("/add-book")
    public @ResponseBody String addNewBook(@RequestBody Book book) {
        return bookService.addNewBook(book);
    }


    @PostMapping("/resale-book")
    public @ResponseBody String resaleBook(@RequestParam Long id) {
        return bookService.resaleBook(id);
    }

    @PostMapping("/repurchase-book")
    public @ResponseBody String repurchaseBook(@RequestParam Long id) {
        return bookService.repurchaseBook(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/delete")
    public void deleteById(@RequestParam Long id) {
        bookService.deleteById(id);
    }
}
