package business;

import java.util.List;
import java.util.ArrayList;

public class LittleStore<Item> {

    // Attributes to store the name of the inventory, the items in stock, and the limit of items.
    private String name;
    private List<Item> stock;
    private int limit;

    /**
     * Constructor to initialize the inventory with a name and item limit.
     * @param name The name of the inventory.
     * @param limit The limit of items that the inventory can hold.
     */
    public LittleStore(String name, int limit){
        // Initialize the stock as an ArrayList.
        stock = new ArrayList<Item>();
        this.name = name;
        this.limit = limit;
    }

    /**
     * Adds an item to the inventory if there's space
     * @param item The item to be added.
     */
    public boolean add(Item item){
        if(limit > stock.size()){
            return stock.add(item);
        }
        return false;
    }

    /**
     * Removes a specified item from the inventory.
     * @param item The item to be removed.
     */
    public void remove(Item item){
        stock.remove(item);
    }

    /**
     * Retrieves the first item in the inventory without removing it.
     * @return The first item in the inventory.
     */
    public Item firstItem(){
        return stock.get(0);
    }

    /**
     * Removes and returns the first item in the inventory.
     * @return The first item in the inventory.
     */
    public Item removeFirstItem(){
        stock.remove(0);
        return stock.get(0);
    }


}
