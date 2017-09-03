package invoice_caluculate;

import java.util.ArrayList;

public class UserDiscountInfo {

	static ArrayList<ArrayList<String>> discountList = new ArrayList<ArrayList <String>>();

	public static void setInfo(String data){
		ArrayList<String> sub = new ArrayList<String>();
		String[] readtext = data.split(" ",0);
		for (int i = 1 ; i < readtext.length ; i++){
			sub.add(readtext[i]);
		}
		discountList.add(sub);
	}

	public static  ArrayList<String> getServiceInfo(){
		ArrayList<String> serviceList = new ArrayList<String>();
		for(int count = 0 ; count < discountList.size() ; count++){
			serviceList.add(discountList.get(count).get(0));
		}
		return serviceList;
	}

	public static  ArrayList<String> getServiceAttributeInfo(){
		ArrayList<String> serviceListAttribute = new ArrayList<String>();
		for(int count = 0 ; count < discountList.size() ; count++){
			try{
				serviceListAttribute.add(discountList.get(count).get(1));
			}catch (Exception e) {

			}
		}
		return serviceListAttribute;
	}

	public static void clear(){
		discountList.clear();
	}


}
