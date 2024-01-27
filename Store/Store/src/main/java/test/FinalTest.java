/*package test;

import business.Store;
import entity.*;
import enums.Genre;
import interfaces.Item;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinalTest {

    @Test
    public void test() {

        Author author1 = new Author("Jane", "Doe", "987654321", 40);
        Author author2 = new Author("Michael", "Smith", "456789012", 35);
        Author author3 = new Author("Alice", "Johnson", "345678901", 28);
        Author author4 = new Author("David", "Williams", "210987654", 45);
        CD cd1 = new CD("Best Hits", 29.99, 15);
        CD cd2 = new CD("Rock Classics", 24.99, 12);
        CD cd3 = new CD("Pop Mix", 19.99, 20);
        CD cd4 = new CD("Jazz Fusion", 34.99, 18);
        DigitalBook digitalBook1 = new DigitalBook(author1, "Digital Novel", 501, 19.99, Genre.DRAMA, "https://novel.com", 3.5);
        DigitalBook digitalBook2 = new DigitalBook(author2, "Sci-Fi Adventure", 502, 24.99, Genre.FICTION, "https://scifi.com", 4.8);
        DigitalBook digitalBook3 = new DigitalBook(author3, "Romantic Story", 503, 14.99, Genre.DRAMA, "https://romance.com", 2.2);
        DigitalBook digitalBook4 = new DigitalBook(author4, "Mystery Thriller", 504, 29.99, Genre.COMEDY, "https://mystery.com", 5.5);
        DigitalManga digitalManga1 = new DigitalManga(author1, "Action Manga", 601, 9.99, Genre.ACTION, "https://actionmanga.com", 1.0, 50);
        DigitalManga digitalManga2 = new DigitalManga(author2, "Fantasy Adventure", 602, 12.99, Genre.HORROR, "https://fantasymanga.com", 1.5, 75);
        DigitalManga digitalManga3 = new DigitalManga(author3, "Slice of Life", 603, 7.99, Genre.OTHER, "https://sliceoflife.com", 0.8, 40);
        DigitalManga digitalManga4 = new DigitalManga(author4, "Horror Manga", 604, 14.99, Genre.HORROR, "https://horrormanga.com", 2.0, 60);
        PhysicalBook physicalBook1 = new PhysicalBook(author1, "Historical Fiction", 701, 39.99, Genre.DRAMA, 300);
        PhysicalBook physicalBook2 = new PhysicalBook(author2, "Self-Help Guide", 702, 19.99, Genre.HORROR, 150);
        PhysicalBook physicalBook3 = new PhysicalBook(author3, "Science Textbook", 703, 49.99, Genre.ACTION, 400);
        PhysicalBook physicalBook4 = new PhysicalBook(author4, "Cookbook", 704, 29.99, Genre.OTHER, 200);

        // Create a list and add all the objects
        List<Item> itemList = new ArrayList<>();
        itemList.add(cd1);
        itemList.add(cd2);
        itemList.add(cd3);
        itemList.add(cd4);
        itemList.add(digitalBook1);
        itemList.add(digitalBook2);
        itemList.add(digitalBook3);
        itemList.add(digitalBook4);
        itemList.add(digitalManga1);
        itemList.add(digitalManga2);
        itemList.add(digitalManga3);
        itemList.add(digitalManga4);
        itemList.add(physicalBook1);
        itemList.add(physicalBook2);
        itemList.add(physicalBook3);
        itemList.add(physicalBook4);

        // Print information about all items in the list
        for (Item item : itemList) {
            System.out.println(item);
        }

        Store store = new Store<Item>();

        for (Item item : itemList) {
            store.addItem(item);
        }

        System.out.println(Genre.DRAMA.name());

        List<Item> filtroPorDrama = store.filtrarPorGenero(Genre.DRAMA.name());
        List<Item> filtroPorPreco = store.filtrarPorPreco(15.99);

        System.out.println(filtroPorDrama);
        System.out.println(filtroPorPreco);


        assertEquals(3, filtroPorDrama.size());
        assertEquals(5, filtroPorPreco.size());


    }



}

 */
