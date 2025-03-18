package librarySystem;

import Expections.BookNotFoundException;
import Expections.EmptyLibraryException;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (book == null)
            throw new IndexOutOfBoundsException("Book should not be null");
        books.add(book);
    }

    private Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title))
                return book;
        }
        return null;
    }

    public void borrowBook(String title) throws EmptyLibraryException, BookNotFoundException {
        if (books.isEmpty())
            throw new EmptyLibraryException("Library is empty, no books to borrow");
        Book book = findBook(title);
        if (book == null)
            throw new BookNotFoundException("book with title " + title + " not found");

        books.remove(book);
        System.out.println("book " + title + " (" + findBook(title).getPageCount() + " pages)" + " has been successfully borrowed");
    }

    public void listBooks () throws EmptyLibraryException {
        if (books.isEmpty())
            throw new EmptyLibraryException("Library is empty");
        System.out.println("Books in the library: ");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book getBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title))
                return book;
        }
        return null;
    }
}
