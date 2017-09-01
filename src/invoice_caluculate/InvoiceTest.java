package invoice_caluculate;

import static org.junit.Assert.*;

import org.junit.Test;

public class InvoiceTest {

	@Test
	public void UserNum() {
		assertEquals(null,invoice_caluculate.User.returnUser());
		invoice_caluculate.User.setInfo("1 090-1234-0001");
		invoice_caluculate.UserDiscountInfo.setInfo("2 C1 090-1234-0002");
		invoice_caluculate.UserDiscountInfo.setInfo("2 C1 090-1234-0003");
		assertEquals("090-1234-0001",invoice_caluculate.User.returnUser());

		invoice_caluculate.Clear.clear();


		invoice_caluculate.UserDiscountInfo.setInfo("2 E1");
		invoice_caluculate.UserDiscountInfo.setInfo("2 C1 090-1234-5678");
		invoice_caluculate.UserDiscountInfo.getServiceInfo().forEach(s -> System.out.println(s));

		invoice_caluculate.Util.setInfo("1 2014/06/05 17:50 010 090-8324-0220");
		invoice_caluculate.Util.setInfo("1 2014/06/05 17:52 010 090-8324-0220");

		assertEquals(1300,invoice_caluculate.Caluculate.basePrice());

		assertEquals(300,invoice_caluculate.Caluculate.telPrice());

		invoice_caluculate.Clear.clear();

		invoice_caluculate.User.setInfo("1 090-1234-5678");
		assertEquals("090-1234-5678",invoice_caluculate.User.returnUser());

		assertEquals(1000,invoice_caluculate.Caluculate.basePrice());

	}
	public void checkDay() {
		assertEquals(false,Caluculate.checkDayTime("07:59"));
		assertEquals(true,Caluculate.checkDayTime("08:00"));
		assertEquals(true,Caluculate.checkDayTime("12:00"));
		assertEquals(true,Caluculate.checkDayTime("17:59"));
		assertEquals(false,Caluculate.checkDayTime("18:00"));
	}

}
