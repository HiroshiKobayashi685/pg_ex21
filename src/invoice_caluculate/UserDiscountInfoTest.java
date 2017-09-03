package invoice_caluculate;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UserDiscountInfoTest {

	@Test
	public void userDiscountInfo() {
		List<String> categoryList = new ArrayList<String>();
		List<String> attributeList = new ArrayList<String>();
		categoryList.add("C1");
		categoryList.add("C1");
		attributeList.add("090-1234-0002");
		attributeList.add("090-1234-0003");
		UserDiscountInfo.setInfo("2 C1 090-1234-0002");
		UserDiscountInfo.setInfo("2 C1 090-1234-0003");
		assertEquals(categoryList,UserDiscountInfo.getServiceInfo());
		assertEquals(attributeList,UserDiscountInfo.getServiceAttributeInfo());

		UserDiscountInfo.clear();
		categoryList.clear();
		attributeList.clear();
		assertEquals(categoryList,UserDiscountInfo.getServiceInfo());
		assertEquals(attributeList,UserDiscountInfo.getServiceAttributeInfo());

		categoryList.add("C1");
		categoryList.add("E1");
		attributeList.add("090-1234-0002");
		UserDiscountInfo.setInfo("2 C1 090-1234-0002");
		UserDiscountInfo.setInfo("2 E1");
		assertEquals(categoryList,UserDiscountInfo.getServiceInfo());
		assertEquals(attributeList,UserDiscountInfo.getServiceAttributeInfo());
	}

}
