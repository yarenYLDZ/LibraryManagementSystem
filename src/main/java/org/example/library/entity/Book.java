package org.example.library.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int publicationYear;
    private int stock;

    // Many-to-One: Bir kitabın bir yazarı olabilir
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    // Many-to-One: Bir kitabın bir yayınevi olabilir
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    // Many-to-Many: Bir kitabın birden fazla kategorisi olabilir
    @ManyToMany
    @JoinTable(
            name = "book_categories",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories = new ArrayList<>();

    // One-to-Many: Bir kitabın birden fazla ödünç alma işlemi olabilir
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BookBorrowing> borrowings = new ArrayList<>();

    // Boş constructor
    public Book() {}

    // Tüm alanları alan constructor
    public Book(Long id, String name, int publicationYear, int stock) {
        this.id = id;
        this.name = name;
        this.publicationYear = publicationYear;
        this.stock = stock;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Category> getCategories() {
        return categories;
    }
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<BookBorrowing> getBorrowings() {
        return borrowings;
    }
    public void setBorrowings(List<BookBorrowing> borrowings) {
        this.borrowings = borrowings;
    }
}
