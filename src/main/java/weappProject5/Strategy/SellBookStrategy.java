package weappProject5.Strategy;

import weappProject5.Model.Book;
import weappProject5.Repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sell")
public class SellBookStrategy implements BookOperationStrategy {

    @Autowired
    private BookRepository libRepo;

    @Override
    public String performOperation(Long id) {
        Book book = libRepo.RetrieveById(id);
        if (book != null && !book.isCheckIfAvailable()) {
            double newPrice = book.getCurrentPrice() - calculateDepreciation(book);
            book.setCurrentPrice((float) newPrice);
            book.incrementTimesSold();
            book.setCheckIfAvailable(true);
            libRepo.save(book);
            return "success, Price of the Book : $" + book.getCurrentPrice()*10;
        }
        return "failure";
    }

    private double calculateDepreciation(Book book) {
        return book.getCurrentPrice() * 0.10;
    }
}
