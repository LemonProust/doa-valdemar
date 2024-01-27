package business;

import interfaces.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Store<T> {
    private List<T> stock = new ArrayList<>();

    public void addItem(T item) {
        stock.add(item);
    }

    public void mostrarItens() {
        stock.forEach(System.out::println);
    }

    public List<T> getStock(){
        return List.copyOf(stock);
    }

    public List<T> filterByAuthor(String autor) {
        return stock.stream()
                .filter(item -> item instanceof Book)
                .filter(item -> ((Book) item).getAuthor().getFullName().equals(autor))
                .collect(Collectors.toList());
    }

    // Operação Read - Filtrar por gênero
    public List<T> filtrarPorGenero(String genero) {
        return stock.stream()
                .filter(item -> item instanceof Book)
                .filter(item -> ((Book) item).getGenre().name().equals(genero))
                .collect(Collectors.toList());
    }

    /*public List<T> filtrarPorPreco(double price) {
        return stock.stream()
                .filter(item -> ((Item) item).getPrice() <= price)
                .collect(Collectors.toList());
    }*/

    public void removerItem(T item) {
        stock.remove(item);
    }
}