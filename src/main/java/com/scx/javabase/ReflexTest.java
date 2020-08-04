package com.scx.javabase;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;

import org.junit.Test;

/**
 * 反射：反射就是把java类中的各种成分解释成java类。 Constructor Method Field Package
 *
 * @author 86176
 *
 */
public class ReflexTest {

	public static void main(String[] args) throws Exception {

		// 构造方法
		Constructor<String> constructor = String.class.getConstructor(StringBuffer.class);
		System.out.println(constructor.newInstance(new StringBuffer("11")));

	}

	/**
	 * 同一类型，同一纬度的数组的字节码对象相同
	 * Array操作数组反射的类
	 */
	@Test
	public void testArrayFlex() {
		// 数组也可以反射
		int[] i = new int[4];
		int[] ii = new int[3];

		System.out.println(i.getClass() == ii.getClass());// 同一类型，同一纬度的数组的字节码对象相同


		System.out.println(i.getClass().getSuperclass().getName());

		Class a = i.getClass();

		if(a.isArray()) {
			System.out.println(Array.getLength(i));
		}


	}

}
