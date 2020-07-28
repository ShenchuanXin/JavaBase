package com.scx.javabase;

/**
 *	自动拆装箱和享元设计模式 --jdk1.5
 * @author 86176
 *
 */
public class AutoBox {

	public static void main(String[] args) {

		Integer i = 1;  //装箱
		System.out.println(i+2); //拆箱

		//当数值在-128~127之间时，为同一个对象。
		Integer i1 = 2;
		Integer i2 = 2;
		System.out.println(i1 == i2);

		//把基础的数据，封装成同一个对象，把他们的不同点作为属性，这样的模式：享元设计模式

	}
}
