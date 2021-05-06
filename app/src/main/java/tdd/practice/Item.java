package tdd.practice;

public class Item {

    private String name;
    private int price;
    private boolean onSale;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
        this.onSale = false;
    }

    public Item(String name, int price, boolean onSale) {
        this.price = price;
        this.onSale = onSale;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isOnsale() {
        return this.onSale;
    }

    public String getName() {
        return this.name;
    }
}
