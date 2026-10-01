import java.time.LocalDate;

public class Book {

    final String author;
    final String title;
    final String isbn;
    final int id;

    Member borrowedBy;
    LocalDate borrowedDate;

    public Book(String author, String title, String isbn, int id) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.id = id;

        this.borrowedBy = null;
        this.borrowedDate = null;
    }

    public boolean isAvailable() {
        return borrowedBy == null;
    }

    public boolean loanBook(Member member) {

        if (isAvailable()) {
            borrowedBy = member;
            borrowedDate = LocalDate.now();
            return true;
        }

        return false;
    }

    public void returnBook() {
        borrowedBy = null;
        borrowedDate = null;
    }

    public LocalDate getDueDate() {

        if (borrowedDate == null) {
            return null;
        }

        return borrowedDate.plusDays(14);
    }

    @Override
    public String toString() {

        if (isAvailable()) {
            return author + ": " + title + "; ISBN " + isbn + "; (" + id + ") - På hylden";
        } else {
            return author + ": " + title + "; ISBN " + isbn + "; (" + id + ") - "
                    + borrowedBy + " - afleveringsfrist " + getDueDate();
        }
    }
}