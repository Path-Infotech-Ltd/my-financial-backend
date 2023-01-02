package com.exam.config;

// input=Sunil
// output=linuS

public class ReverseString {

	public static void main(String[] args){
	String s1 = "Sunil";
	String result = reverseString(s1);
		System.out.println(result);
	}
	
	static String reverseString(String str){
	int i = 0;
	String reverse="";
	char[] charac = str.toCharArray();
	
		for(i=str.length()-1; i>=0;i--){
		reverse+=charac[i];
		}
	return reverse;
	}

}