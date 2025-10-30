package app;

import java.util.ArrayList;

public class ShoppingCart {
    ArrayList<Item> allItems = new ArrayList<>();

    public void addItem(Item item) {
        allItems.add(item);
    }
    public int getTotalPrice() {
        int totalPrice = 0;
        for (Item item : allItems) {
            totalPrice += item.price * item.quantity;
        }
        return totalPrice;
    }
}
