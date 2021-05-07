package tdd.practice.shoppingcart;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {
    @Test
    public void newItemTest() {
        Item item = new Item("Toy Car", 4);

        String expected = "Toy Car";
        String actual = item.getName();

        assertEquals("Item getName should return name", expected, actual);
    }

    @Test
    public void itemGetPriceTest() {
        Item item = new Item("Toy Car", 4);

        int expected = 4;
        int actual = item.getPrice();

        assertEquals("Item getPrice method should return 4", expected, actual);
    }

    @Test
    public void itemNotONsaleTest() {
        Item item = new Item("Toy Car", 4);

        boolean actual = item.isOnsale();

        assertEquals("Item isOnSale method should return default not on sale", false, actual);
    }

    @Test
    public void itemOnSaleTest() {
        Item item = new Item("Toy Car", 4, true);

        boolean actual = item.isOnsale();

        assertEquals("Item isOnSale method should return is on sale", true, actual);
    }
}
