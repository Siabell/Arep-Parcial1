package edu.escuelaing.arep.calculator;
import java.util.*;
import edu.escuelaing.arep.calculator.entities.MergeSort;
public class Calculator {
	
	
	public static String calculateMerge (String dataList) {
		List<String> numberList = Arrays.asList(dataList.split(","));
		String lista = "";
		Integer[] intArray = new Integer[numberList.size()];
		for (int i = 0; i < numberList.size(); i++) {
			//codigo
			intArray[i]= Integer.parseInt(numberList.get(i));
		}
		List<Integer> intList = new ArrayList<Integer>();
		MergeSort<Integer> merge = new MergeSort<Integer>();
		
		MergeSort.mergeSort(intArray, intArray.length);
		for(Integer i: intArray) {
			String number = Integer.toString(i); 
			lista+=number+",";
        }
		String listResult=lista.substring(0,lista.length()-1);
		String result ="{\"lista\":\""+listResult+"\"}";
		return result;
	}
}

///ordenador de cmparadores
//comparable interface