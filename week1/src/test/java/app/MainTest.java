package app;

import org.junit.jupiter.api.Test;
import java.util.Locale;
import java.util.ResourceBundle;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testEnglishBundle() {
        Locale locale = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", locale);
        assertEquals("Enter the number of items to purchase:", rb.getString("itemNumber"));
    }

    @Test
    public void testFinnishBundle() {
        Locale locale = new Locale("fi", "FI");
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", locale);
        assertEquals("Syötä ostettavien tuotteiden määrä:", rb.getString("itemNumber"));
    }

}
