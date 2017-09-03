package invoice_caluculate;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void userTest() {
		User.setInfo("1 090-1234-0001");
		assertEquals("090-1234-0001",User.returnUser());
		User.clear();
		assertEquals("",User.returnUser());
	}

}
