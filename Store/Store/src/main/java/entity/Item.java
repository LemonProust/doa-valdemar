package entity;
public class Item {

    private String name;
    private Double price;

    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double price() {
        return price;
    }
}