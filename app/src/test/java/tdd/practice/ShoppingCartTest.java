package tdd.practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {
    @Test
    public void newCartTest() {
        ShoppingCart cart = new ShoppingCart();

        int expected = 0;
        int actual = cart.itemQuantities();

        assertEquals("New cart should be empty", expected, actual);
    }

    @Test
    public void cartAddItemTest() {
        ShoppingCart cart = new ShoppingCart();
        Item item = new Item("Toy Car", 4, true);

        cart.addItem(item);

        int expected = 1;
        int actual = cart.itemQuantities();

        assertEquals("Cart addItem method should add item " +
                "and itemQuantities should return quantity", expected, actual);
    }

    @Test
    public void cartTotalPrice() {
        ShoppingCart cart = new ShoppingCart();
        Item itemOne = new Item("Toy Car",4);
        Item itemTwo = new Item("Toy Car",6);

        cart.addItem(itemOne);
        cart.addItem(itemTwo);

        int expected = 10;
        int actual = cart.totalPrice();

        assertEquals("Cart totalPrice method should return total price", expected, actual);
    }

    @Test
    public void cartItemizedList() {
        ShoppingCart cart = new ShoppingCart();
        Item itemOne = new Item("Toy Car", 4);
        Item itemTwo = new Item("Toy Truck", 6);

        cart.addItem(itemOne);
        cart.addItem(itemTwo);

        String expected = "{\n" +
                          "  Toy Car: 1\n" +
                          "  Toy Truck: 1\n" +
                          "}";
        String actual = cart.itemizedList();

        assertEquals("Cart itemizedList method should JSON of items and quantities", expected, actual);
    }
}
