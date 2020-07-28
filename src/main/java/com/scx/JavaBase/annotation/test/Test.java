package com.scx.javabase.annotation.test;

import java.lang.reflect.Method;

/**
 * 自定义注解完成某个目的 我要写一个测试框架，测试程序员的代码有无明显的异常。
 *  —— 程序员 A : 我写了一个类，它的名字叫做NoBug，因为它所有的方法都没有错误。
 *  —— 我：自信是好事，不过为了防止意外，让我测试一下如何？
 *  —— 程序员 A: 怎么测试？
 *  —— 我：把你写的代码的方法都加上 @CustomizeAnnotation 这个注解就好了。
 *  —— 程序员 A: 好的。
 *
 * @author 86176
 *
 */
public class Test {

	public static void main(String[] args) {

		NoBug noBug = new NoBug();
		Class<?> class1 = noBug.getClass();
		Method[] methods = class1.getDeclaredMethods();

		//用来记录测试产生的 log 信息
		StringBuilder log = new StringBuilder();
		// 记录异常的次数
		int errornum = 0;

		for (Method method : methods) {
			if (method.isAnnotationPresent(CustomizeAnnotation.class)) {
				try {
					method.setAccessible(true);
					method.invoke(noBug, null);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					errornum++;
					log.append(method.getName());
					log.append(" ");
					log.append("has error:");
					log.append("\n\r  caused by ");
					// 记录测试过程中，发生的异常的名称
					log.append(e.getCause().getClass().getSimpleName());
					log.append("\n\r");
					// 记录测试过程中，发生的异常的具体信息
					log.append(e.getCause().getMessage());
					log.append("\n\r");
				}
			}
		}

		log.append(class1.getSimpleName());
		log.append(" has  ");
		log.append(errornum);
		log.append(" error.");

		// 生成测试报告
		System.out.println(log.toString());

	}
}
