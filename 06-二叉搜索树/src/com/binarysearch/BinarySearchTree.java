package com.binarysearch;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import printer.BinaryTreeInfo;

public class BinarySearchTree<E> implements BinaryTreeInfo {
//	数据的个数
	 private int size;
	 private Node<E> root;
	 private Comparator<E> comparator;
	 
	 public  int size() {
		 return size;
	 }
	 public BinarySearchTree() {
		 this(null);

	}
	 public BinarySearchTree(Comparator<E> comparator) {
		 this.comparator  = comparator;
	 }
	 public static int age ;
/**
 * 数据的添加
 */
	 public void add(E element) {
//		 加的数据不能为空,需要做个check
		 checkNull(element);
//		 加入第一个节点,必然是根节点,加完就可以直接返回了
		 if(root==null) {
			 root = new Node<E>(element,null);
			 size++;
			 return;
		 }
		 
		 int cmp = 0;
		 Node<E> node = root;
		 Node<E> parent = root;
		 while(node!=null) {
			 cmp = compare(element, node.element);
			 parent = node;
			 if(cmp>0) {
				 node = node.right;
			 }else if(cmp<0) {
				 node = node.left;
			 }else {
				 return ;
			 }
		 }
		 //TODO:这个地方写了node ,写错了应该写parent
		 Node<E> newNode = new Node<>(element, parent);
		 if(cmp>0) {
			 parent.right = newNode;
		 }else {
			 parent.left = newNode;
		 }
		 size++;
		 
		 
		 
		 
		 
		 
		 
	 }
	 private int compare(E e1,E e2) {
//		 如果比较器不为空,那么就使用比较器
		 if(comparator!=null) {
			return comparator.compare(e1, e2);
		 }
//		 如果没有传比较器,那就这个类就需要实现比较器的接口
		 return ((Comparable<E>)e1).compareTo(e2);
	 }
	 
	 private  void checkNull(E element) {
		if(element==null) {
			throw new IllegalArgumentException("element can not be null!");
		}
	}
	 
	 private class Node<E> {
		 Node<E> parent;
		 Node<E> left;
		 Node<E> right;
		 E element;
		 public Node(E element,Node<E> parent) {
			// TODO Auto-generated constructor stub
			 this.element = element;
			 this.parent = parent;
		}
		 
		 
		 
		 	 
		 
		 
	 }
	 
//	 前序遍历
	 
	 public void preOrder(Visitor<E> visitor) {
		 if(visitor == null) return;
		 preOrderTraverse(root, visitor);
		
	}
	 private void preOrderTraverse(Node<E> node, Visitor<E> visitor) {
		 if(node == null  || visitor.stop) return;
		visitor.stop = visitor.visit(node.element);
		preOrderTraverse(node.left, visitor);
		preOrderTraverse(node.right, visitor);
		 
	 }
//	 中序遍历
	 public void inorder(Visitor<E> visitor) {
		 if(visitor==null) return;
		 inorderTraverse(root, visitor);
		 
	 }
	 private void inorderTraverse(Node<E> node,Visitor<E> visitor) {
//		 node 为空 ,或者记录点为true 就停止递归的调用
		 if(node == null || visitor.stop) return;
		 inorderTraverse(node.left, visitor);
		 if(visitor.stop)return;
		 visitor.stop = visitor.visit(node.element);
		 inorderTraverse(node.right, visitor);
	 }
//	 后序遍历
	 public void pastOrder(Visitor<E> visitor) {
		 if(visitor==null) return;
		 
	 }
	 public void pastOrderTraverse(Node<E> node,Visitor<E> visitor) {
		 if(node==null|| visitor.stop) return;
		 pastOrderTraverse(node.left, visitor);
		 pastOrderTraverse(node.right, visitor);
		 visitor.stop = visitor.visit(node.element);
	 }
//	 层级遍历
	 public void levelOrder(Visitor<E> visitor) {
		 levelOrderTraverse(root, visitor);
	 }
	 private void levelOrderTraverse(Node<E> node,Visitor<E> visitor) {
		 if(node==null || visitor==null) return;
		 Queue<Node<E>> stack = new LinkedList<>();
		 stack.offer(node);
		 while(!stack.isEmpty()) {
			Node<E> popupNode= stack.poll();
			 if(visitor.stop)return;
			 visitor.stop = visitor.visit(popupNode.element);
			 if(popupNode.left !=null) {
				 stack.offer(popupNode.left);
			 }
			 if(popupNode.right !=null) {
				 stack.offer(popupNode.right);
			 }
			 
			 
		 }
		 
	 }
	 
//	 提供接口,可以随时叫停遍历,同时可以进行具体的操作
	 public abstract static class Visitor<E>{
		 boolean stop;
		 abstract boolean visit(E element);
	 }
	 

	@Override
	public Object root() {
		// TODO Auto-generated method stub
		return root;
	}
	@Override
	public Object left(Object node) {
		// TODO Auto-generated method stub
		return ((Node<E>)node).left;
	}
	@Override
	public Object right(Object node) {
		return ((Node<E>)node).right;
	}
	@Override
	public Object string(Object node) {
		Node<E> myNode = (Node<E>) node;
		String parentString = "null";
		
		
//		如果是root 那就是没有父节点的
		if(myNode.parent!=null) {
		  parentString = myNode.parent.element.toString();
		}
		//简写的方式
		String myParentString = myNode.parent==null?"null":myNode.parent.element.toString();
		
      
		return myNode.element+"_parent:"+myParentString;
	}


}
