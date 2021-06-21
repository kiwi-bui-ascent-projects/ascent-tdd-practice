package tdd.practice.shoppingcart;

import java.util.*;

public class ShoppingCart {
    private final ArrayList<Item> items = new ArrayList<>();

    public int itemQuantities() {
        return items.size();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public int totalPrice() {
        int total = 0;

        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public LinkedHashMap<String, Integer>  itemizedList() {
        LinkedHashMap<String, Integer> mappedItems = new LinkedHashMap<>();

        for (Item item : items) {
            if (!mappedItems.containsKey(item.getName())) {
                mappedItems.put(item.getName(), 1);
            } else {
                mappedItems.put(item.getName(), mappedItems.get(item.getName()) + 1);
            }
        }

        return mappedItems;
    }
}
