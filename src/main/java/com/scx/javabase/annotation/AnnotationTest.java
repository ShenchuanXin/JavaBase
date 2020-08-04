package com.scx.javabase.annotation;

import java.util.HashMap;
import java.util.Map;

public class AnnotationTest {


	public static void main(String[] args) {

		Test.say();

	}

	/**
	 * @Inherited
	 * Inherited 是继承的意思，
	 * 但是它并不是说注解本身可以继承，
	 * 而是说如果一个超类被 @Inherited 注解过的注解进行注解的话，
	 * 那么如果它的子类没有被任何注解应用的话，
	 * 那么这个子类就继承了超类的注解。
	 */

}


class Test{
	@Deprecated
	public static void say() {
		System.out.println("我是被废弃的");
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public static void speak() {
		Map map = new HashMap<>();
	}
	@Override
	public String toString() {
		return super.toString();
	}
}
