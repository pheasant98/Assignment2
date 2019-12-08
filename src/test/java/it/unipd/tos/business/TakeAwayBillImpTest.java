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
    public void before() {
        TABI = new TakeAwayBillImp();
    }

    @Test
    public void testPriceCalculation() {
        List<MenuItem> itemsOrdered=new ArrayList<MenuItem>();
        for(int i=0; i<3; i++) {
            itemsOrdered.add(new MenuItem(ItemType.Fritti, "Patatine fritte", 3.0));
        }

        try {
            assertEquals(9.0, TABI.getOrderPrice(itemsOrdered), 0);
        } catch (TakeAwayBillException e) {
            fail("TakeAwayBillException thrown");
        }
    }

}
