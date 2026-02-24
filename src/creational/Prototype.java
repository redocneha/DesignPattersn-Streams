package creational;

import java.util.HashMap;
import java.util.Map;

// objects are created using clone instead with new keyword, helpful when obj creation is costly like db calls
// default objs are loaded in cache
public class Prototype {
    public static void main(String[] args) {
        CacheStore cacheStore = new CacheStore();
        Item book1 = cacheStore.createItem("book");
        Item bottle1 = cacheStore.createItem("bottle");
        book1.setName("Anisha");
        bottle1.show();
        book1.show();
    }
}

class CacheStore {
    Map<String, Item> itemList = new HashMap<String, Item>();

    public CacheStore() {
        loadItems();
    }

    private void loadItems() {
        Item book = new Book();
        book.name = "Neha";
        book.price = 100;
        Item bottle = new Book();
        bottle.name = "Vishal";
        bottle.price = 200;
        this.itemList.put("bottle", bottle);
        this.itemList.put("book", book);
    }

    public Item createItem(String itemType) {
        return this.itemList.get(itemType).clone();
    }
}

abstract class Item implements Cloneable {
    String name;
    int price;
    public Item clone(){
        Item clonedItem = null;
        try{
            clonedItem = (Item) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return clonedItem;
    }
    public String getName(){ return this.name; }
    public int getPrice(){ return this.price; }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public abstract void show();

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

class Book extends Item{

    @Override
    public void show() {
        System.out.println("Book " + this.toString());
    }
}

class Bottle extends Item{

    @Override
    public void show() {
        System.out.println("Bottle " + this.toString());
    }
}