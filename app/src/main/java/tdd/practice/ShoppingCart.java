package tdd.practice;

import java.util.*;

public class ShoppingCart {
    private ArrayList<Item> items = new ArrayList<>();

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

    public String itemizedList() {
        String result = "{\n";
        LinkedHashMap<String, Integer> mappedItems = new LinkedHashMap<>();

        for (Item item : items) {
            if (!mappedItems.containsKey(item.getName())) {
                mappedItems.put(item.getName(), 1);
            } else {
                mappedItems.put(item.getName(), mappedItems.get(item.getName()) + 1);
            }
        }

        Iterator iterator = mappedItems.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry element = (Map.Entry)iterator.next();
            result += "  " + element.getKey() + ": " + element.getValue() + "\n";
        }

        result += "}";

        return result;
    }
}
