package app;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main
{
    public static void main( String[] args )
    {
        ShoppingCart cart = new ShoppingCart();
        Scanner sc = new Scanner(System.in);

        System.out.println("Select the language: ");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Swedish");
        System.out.println("4. Japanese");
        int language = sc.nextInt();
        Locale locale;
        switch (language) {
            case 1:
                locale = new Locale("en", "US");
                break;
            case 2:
                locale = new Locale("fi", "FI");
                break;
            case 3:
                locale = new Locale("sv", "SE");
                break;
            case 4:
                locale = new Locale("ja", "JP");
                break;
            default:
                locale = new Locale("en", "US");
                break;
        }

        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);

        System.out.print(messages.getString("itemNumber"));
        int total = sc.nextInt();

        for (int i = 0; i < total; i++) {
            System.out.print(messages.getString("itemPrice") + (i + 1) + ": ");
            int itemPrice = sc.nextInt();
            System.out.print(messages.getString("itemQuantity"));
            int itemQuantity = sc.nextInt();
            cart.addItem(new Item(itemQuantity, itemPrice));
        }

        System.out.println(messages.getString("totalCost") + cart.getTotalPrice());
    }
}
