////////////////////////////////////////////////////////////////////
// [FEDERICO] [PERIN] [1170747]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

public class TakeAwayBillImp implements TakeAwayBill 
{

    public double getOrderPrice(List<MenuItem> itemsOrdered) 
            throws TakeAwayBillException 
    {
        double PrezzoTotale=0.0;

        for(MenuItem itemOrdered : itemsOrdered) 
        {
            PrezzoTotale+=itemOrdered.getPrice();
        }

        return PrezzoTotale;
    }

}
