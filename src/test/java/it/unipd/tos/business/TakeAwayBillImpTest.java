////////////////////////////////////////////////////////////////////
// [FEDERICO] [PERIN] [1170747]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;

public class TakeAwayBillImpTest {

    private TakeAwayBillImp TABI;

    @Before
    public void before() 
    {
        TABI=new TakeAwayBillImp();
    }

    @Test
    public void testPriceCalculation() 
    {
        List<MenuItem> itemsOrdered=new ArrayList<MenuItem>();
        for(int i=0; i<3; i++) 
        {
            itemsOrdered.add(new MenuItem(ItemType.Fritti, "Patatine fritte", 3.0));
        }

        try 
        {
            assertEquals(9.0, TABI.getOrderPrice(itemsOrdered), 0);
        } 
        catch (TakeAwayBillException e) 
        {
            fail("TakeAwayBillException thrown");
        }
    }
    
    @Test
    public void testDiscountIfMoreThanFiveSandwiches() 
    {
        List<MenuItem> itemsOrdered=new ArrayList<MenuItem>();
        for(int i=0; i<5; i++) 
        {
            itemsOrdered.add(new MenuItem(ItemType.Panini, "Fantasia", 5.0));
        }
        itemsOrdered.add(new MenuItem(ItemType.Panini, "Vegetariano", 2.0));

        try 
        {
            assertEquals(26.0, TABI.getOrderPrice(itemsOrdered), 0);
        } 
        catch (TakeAwayBillException e)
        {
            fail("TakeAwayBillException thrown");
        }
    }
    
    @Test
    public void testDiscountIfSandwichesAndFriedPriceIfMoreThan50() 
    {
        List<MenuItem> itemsOrdered=new ArrayList<MenuItem>();
        for(int i=0; i<5; i++) 
        {
            itemsOrdered.add(new MenuItem(ItemType.Panini, "Enos", 5.0));
            itemsOrdered.add(new MenuItem(ItemType.Fritti, "Arancini", 6.0));
        }

        try 
        {
            assertEquals(49.5, TABI.getOrderPrice(itemsOrdered), 0);
        } 
        catch (TakeAwayBillException e) 
        {
            fail("TakeAwayBillException thrown");
        }
    }

    @Test
    public void test2DiscountForMoreThanFiveSandwichAndPriceMoreThan50() 
    {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        for(int i = 0; i < 6; ++i)
        {
            itemsOrdered.add(new MenuItem(ItemType.Panini, "Enos", 5.0));
            itemsOrdered.add(new MenuItem(ItemType.Fritti, "Arancini", 6.0));
        }

        try
        {
            assertEquals(56.9, TABI.getOrderPrice(itemsOrdered), 0);
        } 
        catch (TakeAwayBillException e) 
        {
            fail("TakeAwayBillException thrown");
        }
    }
}
