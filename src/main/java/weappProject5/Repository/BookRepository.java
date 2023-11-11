package weappProject5.Repository;

import weappProject5.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
    @Query(value = "select * from book where id = ?1", nativeQuery = true)
    Book RetrieveById(Long id);

}