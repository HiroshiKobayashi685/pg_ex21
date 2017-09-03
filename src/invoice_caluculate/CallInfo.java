package invoice_caluculate;

import java.util.ArrayList;

public class CallInfo {
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
