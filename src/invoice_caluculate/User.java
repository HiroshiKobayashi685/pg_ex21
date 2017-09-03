package invoice_caluculate;

public class User {

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
