package weappProject5.Service;

import weappProject5.Model.Author;
import weappProject5.Model.Genre;
import weappProject5.Repository.AuthorRepository;
import weappProject5.Strategy.BookOperationStrategy;
import weappProject5.Strategy.BuyBookStrategy;
import weappProject5.Strategy.SellBookStrategy;
import weappProject5.Model.Book;
import weappProject5.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BuyBookStrategy buyBookStrategy;
    @Autowired
    private SellBookStrategy sellBookStrategy;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    private Map<String, BookOperationStrategy> bookOperationStrategyMap = new HashMap<>();

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public String resaleBook(Long id) {
        return bookOperationStrategyMap.get("buy").performOperation(id);
    }

    public String repurchaseBook(Long id) {
        return bookOperationStrategyMap.get("sell").performOperation(id);
    }

    public String addNewBook(Book book) {
        Author author = book.getAuthor();
        author = authorRepository.save(author);
        book.setNumberOfTimesSold(1L);
        book.setCheckIfAvailable(true);
        book.setGenre(Genre.GENERAL);
        bookRepository.save(book);
        return "success, Price of the Book : " + book.getCurrentPrice();
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
