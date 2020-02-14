package edu.escuelaing.arep.calculator;
import java.util.*;

public class Calculator {
	
	
	public static String calculateMerge (String dataList) {
		List<String> numberList = Arrays.asList(dataList.split(","));
		String lista = "";
		for (int i = 0; i < numberList.size(); i++) {
			//codigo
			String number = numberList.get(i);
			lista+=number+",";
		}
		
		String result ="{\"lista\":\""+lista+"\"}";
		return result;
	}
}

///ordenador de cmparadores
//comparable interface