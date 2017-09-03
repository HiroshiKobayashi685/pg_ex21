package invoice_caluculate;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CallInfoTest {

	@Test
	public void callInfo() {
		ArrayList<ArrayList<String>> utilListTest = new ArrayList<ArrayList <String>>();
		ArrayList<String> subUtilListTest = new ArrayList <String>();

		CallInfo.setInfo("5 2004/06/27 13:50 010 090-1234-9999");
		subUtilListTest.add("2004/06/27");
		subUtilListTest.add("13:50");
		subUtilListTest.add("010");
		subUtilListTest.add("090-1234-9999");
		utilListTest.add(subUtilListTest);
		assertEquals(utilListTest,CallInfo.getInfo());

		CallInfo.clear();
		utilListTest.clear();
		assertEquals(utilListTest,CallInfo.getInfo());

	}

}
