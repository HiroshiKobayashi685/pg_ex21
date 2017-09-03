package invoice_caluculate;

public class Caluculate {
	int fee;

	public static int telPrice(){
		int price = 0;
		for(int i = 0; i < CallInfo.getInfo().size(); i++){
			int callPrice = 20;
			String startTime = CallInfo.getInfo().get(i).get(1);
			int callTime = Integer.parseInt(CallInfo.getInfo().get(i).get(2));
			String callNumber = CallInfo.getInfo().get(i).get(3);
			if(UserDiscountInfo.getServiceInfo().contains("E1") && Caluculate.checkDayTime(startTime)){
				callPrice = callPrice - 5;
			}
			if(UserDiscountInfo.getServiceAttributeInfo().contains(callNumber)){
				callPrice = callPrice /2  ;
			}
			price = price + callPrice * callTime;
		}
		return price;
	}

	public static int basePrice(){
		int price =0;
		price = 1000;
		if(UserDiscountInfo.getServiceInfo().contains("C1")){
			price = price + 100;
		}
		if(UserDiscountInfo.getServiceInfo().contains("E1")){
			price = price + 200;
		}
		return price;
	}

	public static boolean checkDayTime(String stringDate){
		String startDate = "08:00";
		String endDate = "18:00";
		if (stringDate.compareTo(startDate) >= 0 && stringDate.compareTo(endDate) < 0  ){
			return true;
		}
		return false;
	}

}
