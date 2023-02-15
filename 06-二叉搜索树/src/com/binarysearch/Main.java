package com.binarysearch;
//import static com.binarysearch.BinarySearchTree.age;
//import static java.lang.Math.PI;



import com.binarysearch.BinarySearchTree.Visitor;

import File.Files;
import printer.BinaryTrees;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Integer[] dataIntegers= new Integer[]{7,9,11,0,3,4,1,6};

   BinarySearchTree<Integer> bst = new BinarySearchTree<>();
   
	for (Integer data : dataIntegers) {
		bst.add(data);
	}
	BinaryTrees.println(bst);
    
	
//	  静态类的调用
	bst.preOrder(new  Visitor<Integer>() {
		
		@Override
		boolean visit(Integer element) {
			// TODO Auto-generated method stub
			System.out.print(element+"_");
//			这个执行的是如果element == 3 ,就返回true 
			return element==3?true:false;
		}
	});
	
//	String string = BinaryTrees.printString(bst);
//	Files.writeToFile("/Users/jessicazhu/Desktop/test.txt",string , false);
    
	}
	
	
}
