package com.scx.javabase;

import java.net.URL;

/**
 * 类加载器是负责动态加载类的对象。
 * 通过用户自定义的类装载器，你的程序可以加载在编译时并不知道或者尚未存在的类或者接口，并动态连接它们并进行有选择的解析。
 * @author 86176
 *
 */
public class FrameDemoTest {

	public static void main(String[] args) throws Exception{
		/**
		 * 创建静态内部类对象
		 * */
		//1.正常情况
		Test ins = new Test();
		ins = new FrameDemoTest.Test();

		//2.反射
		Test instance = (Test)Class.forName("com.scx.javabase.FrameDemoTest$Test").newInstance();

		//3.类加载器（反射）
		ClassLoader classLoader = FrameDemoTest.class.getClassLoader();
		instance = (Test)classLoader.loadClass("com.scx.javabase.FrameDemoTest$Test").newInstance();


		URL url = classLoader.getResource("com/scx/JavaBase/FrameDemoTest.class");
		System.out.println(url);

		/**
		 * //创建成员内部类对象
		 * */
		//1.正常
		FrameDemoTest demoTest = new FrameDemoTest();
		TestAnonymous tAnonymous = demoTest.new TestAnonymous();

		//2.反射
		TestAnonymous TestAnonymous = (com.scx.javabase.FrameDemoTest.TestAnonymous) TestAnonymous.class.getDeclaredConstructors()[0].newInstance(FrameDemoTest.class.newInstance());

	}

	private TestAnonymous inner = null;

	public TestAnonymous getInnerInstance() {
        if(inner == null)
            inner = new TestAnonymous();
        return inner;
    }

	static class Test implements TestInter{

		Test(){
			System.out.println("实例对象："+this.toString());
		}
	}

	class TestAnonymous{

		TestAnonymous(){
			System.out.println("实例对象："+this.toString());
		}

	}

	interface TestInter{

	}

	@org.junit.Test
	public void test() {
		System.out.println(ClassLoader.getSystemClassLoader());  //系统类加载器
        System.out.println(ClassLoader.getSystemClassLoader().getParent());  //扩展类加载器
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());  //启动类加载器
        //由于启动类加载器无法被Java程序直接引用，因此JVM默认直接使用 null 代表启动类加载器
	}

}
