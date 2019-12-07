////////////////////////////////////////////////////////////////////
// [FEDERICO] [PERIN] [1170747]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.exception;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class TakeAwayBillExceptionTest {

    private static TakeAwayBillException takeAwayBillException;

    @BeforeClass
    public static void BeforeClass() {
        takeAwayBillException = new TakeAwayBillException("Messaggio: ");
    }

    @Test
    public void TestGetMessage() {
        assertEquals("Messaggio: ", takeAwayBillException.getMessage());
    }

}