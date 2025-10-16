package org.example.library.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "book_borrowings")
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String borrowerName;     // Kitabı ödünç alan kişinin adı
    private LocalDate borrowingDate; // Ödünç alma tarihi
    private LocalDate returnDate;    // Teslim tarihi (ilk başta null)

    // Many-to-One: Bir ödünç alma işlemi yalnızca bir kitaba ait olabilir
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    // Boş constructor
    public BookBorrowing() {}

    // Tüm alanları alan constructor
    public BookBorrowing(Long id, String borrowerName, LocalDate borrowingDate, LocalDate returnDate) {
        this.id = id;
        this.borrowerName = borrowerName;
        this.borrowingDate = borrowingDate;
        this.returnDate = returnDate;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getBorrowerName() {
        return borrowerName;
    }
    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }
    public void setBorrowingDate(LocalDate borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
}
