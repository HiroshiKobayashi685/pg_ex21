package invoice_caluculate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Invoice {

	public static void main(String args[]){
		try{
			File readFile = new File("/Applications/Eclipse_4.6.3.app/Contents/workspace/invoice_caluculate/InterFace/record.log");
			File writeFile = new File("/Applications/Eclipse_4.6.3.app/Contents/workspace/invoice_caluculate/InterFace/output.log");

			FileReader filereader = new FileReader(readFile);
			BufferedReader bufferedReader = new BufferedReader(filereader);
			String data;

			if (checkBeforeWritefile(writeFile)){
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(writeFile)));
				while ((data = bufferedReader.readLine()) != null) {
					char flag_char = data.charAt(0);
					int flag = Character.getNumericValue(flag_char);
					if(flag==0 && User.returnUser() != null){
						pw.println("1 "+User.returnUser());
						pw.println("5 "+Caluculate.basePrice());
						pw.println("7 "+Caluculate.telPrice());
						pw.println("9 ================================");
						Clear.clear();
					}
					if(flag==1){User.setInfo(data);}
					if(flag==2){UserDiscountInfo.setInfo(data);}
					if(flag==5){Util.setInfo(data);}
				}
				pw.close();
			}else{
				System.out.println("ファイルに書き込めません");
			}
			filereader.close();
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
	}

	private static boolean checkBeforeWritefile(File file){
		if (file.exists()){
			if (file.isFile() && file.canWrite()){
				return true;
			}
		}
		return false;
	}

}
class User {

	static String cell_number;

	public static void setInfo(String data){
		String[] readtext = data.split(" ",0);
		cell_number = readtext[1];
	}

	public static String returnUser(){
		return cell_number;
	}

	public static void clear(){
		cell_number = "";
	}
}

class UserDiscountInfo{

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

class Util{

	static ArrayList<ArrayList<String>> utilList = new ArrayList<ArrayList <String>>();

	public static void setInfo(String data){
		ArrayList<String> sub = new ArrayList<String>();
		String[] readtext = data.split(" ",0);
		for (int i = 1 ; i < readtext.length ; i++){
			sub.add(readtext[i]);
		}
		utilList.add(sub);
	}

	public static ArrayList<ArrayList<String>> getInfo(){
		return utilList;
	}

	public static void clear(){
		utilList.clear();
	}
}

class Caluculate{

	int fee;

	public static int telPrice(){
		int price = 0;
		for(int i = 0; i < Util.getInfo().size(); i++){
			int callPrice = 20;
			String startTime = Util.getInfo().get(i).get(1);
			int callTime = Integer.parseInt(Util.getInfo().get(i).get(2));
			String callNumber = Util.getInfo().get(i).get(3);
			if(UserDiscountInfo.getServiceInfo().contains("E1") && Caluculate.checkDayTime(startTime)){
				callPrice = callPrice - 5;
			}
			if(UserDiscountInfo.getServiceAttributeInfo().contains(callNumber)){
				callPrice = callPrice /2  ;
			}
			price = price + callPrice * callTime;
		}
		System.out.println("通話料金は"+price);
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
		System.out.println("基本料金は"+price);
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

class Clear{
	public static void clear(){
		Util.clear();
		UserDiscountInfo.clear();
		User.clear();
	}
}