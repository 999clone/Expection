package librarySystem;

public class Book {
    private String title;
    private int pageCount;

    public Book(String title, int pageCount) {
        if (title == null)
            throw new NullPointerException("title cannot be empty");
        if (pageCount <= 0)
            throw new IllegalArgumentException("pageCount must be positive");
        this.title = title;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }
    public int getPageCount() {
        return pageCount;
    }
    @Override
    public String toString() {
        return title + " (" + pageCount + " pages)";
    }

}
