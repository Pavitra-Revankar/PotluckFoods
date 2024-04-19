package com.feast.PotLuckFoods.model;

public class EncryptDecrypt {
	public static String decrypt(String s) {
		char[] str = s.toCharArray();
		for(int i=0;i<str.length ; i++) {
			str[i] /=2;
			str[i] +=2;	
		}
		
		reverse(str,str.length);
		rotateR(str,str.length);
		String res="";
		for(int i =0;i<str.length;i++){
			res+=str[i];
	}
		return res;	}


	public static String encrypt(String s) {
		char[] str = s.toCharArray();

//		rotate by 2
		rotateL(str,str.length);
		reverse(str,str.length);
		for(int i=0;i<str.length ; i++) {
			str[i] -=2;
			str[i] *=2;
		}
		
		String res="";
		for(int i =0;i<str.length;i++){
			res+=str[i];
	}
		return res;

		
	}
	
	public static void rotateL(char[] a, int n) {

		for (int k = 1; k <= 2; k++) {
			int i = 0, j = n - 1;

			while (i != j) {
				char temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}
//		for (int k : a)
//			System.out.print(k + " ");
	}
	
	public static void rotateR(char[] a, int n) {
		for (int k = 1; k <= 2; k++) {
			int i = 0, j = n - 1;

			while (i != j) {
				char temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				j--;
			}
		}
		
	}
		
	public static void reverse(char[] a, int n) {
			int i = 0, j = n-1;
			while (i <= j) {
				char temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
		}

	}
}
