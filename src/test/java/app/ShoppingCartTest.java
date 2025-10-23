package app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    @Test
    public void testIndividualItemCost() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item(2, 10));
        assertEquals(20, cart.getTotalPrice());
    }

    @Test
    public void testTotalCartCost() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item(2, 10)); // 2 * 10 = 20
        cart.addItem(new Item(3, 5));  // 3 * 5 = 15
        assertEquals(35, cart.getTotalPrice());
    }

    @Test
    public void testEmptyCart() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0, cart.getTotalPrice());
    }
}
