package gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("fixme", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    public void deberiaDevolverQuality6ConElixirOfTheMongoose() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        int expectedQuality = 6;
        int actualQuality = app.items[0].quality;
        assertEquals(expectedQuality, actualQuality);
    }
    
    @Test
    public void deberiaDevolver0() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        int expectedQuality = 6;
        int actualQuality = app.items[0].quality;
        assertEquals(expectedQuality, actualQuality);
    }

}