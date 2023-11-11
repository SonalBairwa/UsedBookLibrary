package weappProject5.Model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Book {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment", parameters = {
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "100"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
    })
    private Long id;
    private Long isbn;
    @ManyToOne
    private Author author;

    private String title;
    private String edition;

    private Float currentPrice;

    private Float originalPrice;
    private Long yearOfPublish;

    private Long numberOfTimesSold;

    private boolean checkIfAvailable;


    private Genre genre;

    public Book() {

    }

    public Book(Long isbn, Author author, String title, String edition, Float currentPrice, Float originalPrice, Long yearOfPublish, Long numberOfTimesSold, boolean avail, Genre genre){
        this.isbn=isbn;
        this.author=author;
        this.title=title;
        this.edition=edition;
        this.currentPrice =currentPrice;
        this.originalPrice=originalPrice;
        this.checkIfAvailable=avail;
        this.yearOfPublish=yearOfPublish;
        this.numberOfTimesSold=numberOfTimesSold;
        this.genre = (genre == null) ? Genre.GENERAL : genre;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Float getOriginalPrice() { return originalPrice; }

    public void setOriginalPrice(Float originalPrice) { this.originalPrice = originalPrice; }

    public Long getYearOfPublish() { return yearOfPublish; }

    public void setYearOfPublish(Long yearOfPublish) { this.yearOfPublish = yearOfPublish; }

    public Long getNumberOfTimesSold() { return numberOfTimesSold; }

    public void setNumberOfTimesSold(Long numberOfTimesSold) { this.numberOfTimesSold = numberOfTimesSold; }

    public boolean isCheckIfAvailable() {
        return checkIfAvailable;
    }


    public void incrementTimesSold() {
        this.numberOfTimesSold++;
    }

    public void setCheckIfAvailable(boolean checkIfAvailable) {
        this.checkIfAvailable = checkIfAvailable;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}


