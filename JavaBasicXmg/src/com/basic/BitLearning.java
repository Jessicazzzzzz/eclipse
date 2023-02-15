package com.basic;

import java.util.Iterator;

public class BitLearning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print(Integer.toBinaryString(7));
		
		// & | ^
		//boolean 也可以用位运算
		System.out.println(true & false);
		
		byte b1 = 10;
		byte b2 = 20;
		b1++;//一元运算符
		
		int[] array = {1,2,3};
		char index = 1;
		System.out.println(array[index]);//这里index 就提升为int 类型
        System.out.println(Character.isJavaIdentifierStart('h'));
        sum();
	}
	public static int sum(int... n1) {
		int res= 0;
		for(int num:n1) {
			res += num;
		}
		System.out.println(n1);
		return res;
	}

}
