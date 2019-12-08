////////////////////////////////////////////////////////////////////
// [FEDERICO] [PERIN] [1170747]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;

public class TakeAwayBillImp implements TakeAwayBill 
{

    public double getOrderPrice(List<MenuItem> itemsOrdered) 
            throws TakeAwayBillException 
    {
        double PrezzoTotale=0.0;
        double PrezzoMinPanino=Double.MAX_VALUE;
        int NumeroPanini=0;

        for(MenuItem itemOrdered : itemsOrdered) 
        {
            PrezzoTotale+=itemOrdered.getPrice();
            
            if(itemOrdered.getItemType()==ItemType.Panini) 
            {
                if(itemOrdered.getPrice()<PrezzoMinPanino) 
                {
                    PrezzoMinPanino=itemOrdered.getPrice();
                }
                NumeroPanini++;
            }
        }

        if(NumeroPanini>5) 
        {
            PrezzoTotale-=PrezzoMinPanino/2.0;
        }
    
        return PrezzoTotale;
    }

}
