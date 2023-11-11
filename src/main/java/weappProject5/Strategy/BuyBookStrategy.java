package weappProject5.Strategy;

import weappProject5.Model.Book;
import weappProject5.Repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("buy")
public class BuyBookStrategy implements BookOperationStrategy {

    @Autowired
    private BookRepository libRepo;

    @Override
    public String performOperation(Long id) {
        Book book = libRepo.RetrieveById(id);
        if (book != null) {
            if (book.isCheckIfAvailable()) {
                book.setCheckIfAvailable(false);
                libRepo.save(book);
                return "success";
            }
        }
        return "failure";
    }
}
