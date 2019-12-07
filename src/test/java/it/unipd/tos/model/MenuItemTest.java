package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;

public class MenuItemTest {

    private static MenuItem menuItem;

    @BeforeClass
    public static void beforeClass() {
        menuItem = new MenuItem(ItemType.Panini, "Fantasia",4);
    }

    @Test
    public void testGetItemType() {
        assertEquals(ItemType.Panini, menuItem.getItemType());
    }

    @Test
    public void testGetName() {
        assertEquals("Fantasia", menuItem.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(4, menuItem.getPrice(), 0);
    }

}