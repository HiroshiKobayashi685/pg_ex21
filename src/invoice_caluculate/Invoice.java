package invoice_caluculate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Invoice {

	public static void main(String args[]){
		try{
			File readFile = new File("/Applications/Eclipse_4.6.3.app/Contents/workspace/invoice_caluculate/InterFace/record.log");
			File writeFile = new File("/Applications/Eclipse_4.6.3.app/Contents/workspace/invoice_caluculate/InterFace/invoice.dat");

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
						pw.println("9 =====================");
						Clear.clear();
					}
					if(flag==1){User.setInfo(data);}
					if(flag==2){UserDiscountInfo.setInfo(data);}
					if(flag==5){CallInfo.setInfo(data);}
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

