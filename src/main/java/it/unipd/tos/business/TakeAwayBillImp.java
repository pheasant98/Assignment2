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
        double PrezzoTotalePaninieFritti=0.0;
        double ScontoTotale=0.0;
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
                PrezzoTotalePaninieFritti+=itemOrdered.getPrice();
                NumeroPanini++;
            }
            if(itemOrdered.getItemType()==ItemType.Fritti) {
                PrezzoTotalePaninieFritti+=itemOrdered.getPrice();
            }
        }

        if(NumeroPanini>5) 
        {
            ScontoTotale+=PrezzoMinPanino/2.0;
        }
        
        if(PrezzoTotalePaninieFritti>50.0) 
        {
            ScontoTotale+=PrezzoTotale*0.10;
        }
    
        return PrezzoTotale-ScontoTotale;
    }

}
