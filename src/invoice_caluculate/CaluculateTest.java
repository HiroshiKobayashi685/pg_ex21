package invoice_caluculate;

import static org.junit.Assert.*;

import org.junit.Test;

public class CaluculateTest {

	@Test
	public void checkDay() {
		assertEquals(false,Caluculate.checkDayTime("07:59"));
		assertEquals(true,Caluculate.checkDayTime("08:00"));
		assertEquals(true,Caluculate.checkDayTime("12:00"));
		assertEquals(true,Caluculate.checkDayTime("17:59"));
		assertEquals(false,Caluculate.checkDayTime("18:00"));
	}

	@Test
	public void telPrice() {

		CallInfo.setInfo("5 2004/06/27 13:50 010 090-1234-9999");
		assertEquals(200,Caluculate.telPrice());
		Clear.clear();

		UserDiscountInfo.setInfo("2 C1 090-1234-0002");
		CallInfo.setInfo("5 2004/06/27 13:50 010 090-1234-9999");
		assertEquals(200,Caluculate.telPrice());
		Clear.clear();

		UserDiscountInfo.setInfo("2 E1");
		CallInfo.setInfo("5 2004/06/27 13:50 010 090-1234-9999");
		assertEquals(150,Caluculate.telPrice());
		Clear.clear();

		UserDiscountInfo.setInfo("2 C1 090-1234-0002");
		CallInfo.setInfo("5 2004/06/27 13:50 010 090-1234-0002");
		assertEquals(100,Caluculate.telPrice());
		Clear.clear();

		UserDiscountInfo.setInfo("2 C1 090-1234-0002");
		UserDiscountInfo.setInfo("2 E1");
		CallInfo.setInfo("5 2004/06/27 13:50 010 090-1234-0002");
		assertEquals(70,Caluculate.telPrice());
		Clear.clear();

		UserDiscountInfo.setInfo("2 E1");
		CallInfo.setInfo("5 2004/06/27 20:50 010 090-1234-9999");
		assertEquals(200,Caluculate.telPrice());
		Clear.clear();

	}


	@Test
	public void basePrice() {

		assertEquals(1000,Caluculate.basePrice());
		UserDiscountInfo.clear();

		UserDiscountInfo.setInfo("2 C1 090-1234-0002");
		assertEquals(1100,Caluculate.basePrice());
		UserDiscountInfo.clear();

		UserDiscountInfo.setInfo("2 E1");
		assertEquals(1200,Caluculate.basePrice());
		UserDiscountInfo.clear();

		UserDiscountInfo.setInfo("2 E1");
		UserDiscountInfo.setInfo("2 C1 090-1234-0002");
		assertEquals(1300,Caluculate.basePrice());
		UserDiscountInfo.clear();

	}
}
