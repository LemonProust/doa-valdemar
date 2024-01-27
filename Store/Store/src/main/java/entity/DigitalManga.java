package entity;

import enums.Genre;

import java.util.ArrayList;
import java.util.List;

public class DigitalManga extends DigitalBook {
    private List<Byte> pages;
    private boolean isReadingRightToLeft;
    private int currentPageIndex;

    public DigitalManga(Author author, String title, int id,
                        double price, Genre genre, String url,
                        double sizeMB, int nPages) {
        super(author, title, id, price, genre, url, sizeMB);
        this.pages = new ArrayList<>(nPages);
        this.isReadingRightToLeft = false;
        this.currentPageIndex = 0;
        for (int i = 0; i < nPages; i++) {
            this.pages.add((byte) 0);
        }
    }

    public boolean isReadingRightToLeft(){
        return isReadingRightToLeft;
    }

    public void changeDirection() {
        isReadingRightToLeft = !isReadingRightToLeft;
    }

    public List<Byte> getPages() {
        return new ArrayList<>(pages);
    }

    public Byte getPage(int index) {
        return pages.get(index);
    }

    public Byte getBookCover() { return pages.get(0); }

    public byte nextPage() {
        byte nextPage = pages.get(currentPageIndex);
        currentPageIndex = (isReadingRightToLeft) ? currentPageIndex - 1 : currentPageIndex + 1;
        if (currentPageIndex < 0) {
            currentPageIndex = (isReadingRightToLeft) ? pages.size() - 1 : 0;
        } else if (currentPageIndex >= pages.size()) {
            currentPageIndex = (isReadingRightToLeft) ? 0 : pages.size() - 1;
        }
        return nextPage;
    }

    @Override
    public String toString() {
        return super.toString() + " [manga]";
    }
}