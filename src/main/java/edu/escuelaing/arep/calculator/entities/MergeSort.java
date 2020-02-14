package edu.escuelaing.arep.calculator.entities;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> {

	
	
	public static <T extends Comparable<T>> void mergeSort(T[] a, int n) {
	    if (n < 2) {
	        return;
	    }
	    int mid = n / 2;
	    T[] l = Arrays.copyOf(a,mid);
	    T[] r = Arrays.copyOf(a,n-mid);
	 
	    for (int i = 0; i < mid; i++) {
	        l[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) {
	        r[i - mid] = a[i];
	    }
	    mergeSort(l, mid);
	    mergeSort(r, n - mid);
	 
	    merge(a, l, r, mid, n - mid);
	}
	
	public static <T extends Comparable<T>> void merge( T[] a, T[] l, T[] r, int left, int right) {
	  
	    int i = 0, j = 0, k = 0;
	    while (i < left && j < right) {
	        if (l[i].compareTo(r[j]) <0)  {
	            a[k++] = l[i++];
	        }
	        else {
	            a[k++] = r[j++];
	        }
	    }
	    while (i < left) {
	        a[k++] = l[i++];
	    }
	    while (j < right) {
	        a[k++] = r[j++];
	    }
	}


}
