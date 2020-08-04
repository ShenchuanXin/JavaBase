package com.scx.javabase.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.junit.Test;

import com.scx.javabase.tree.TreeParent;


/**
 *
* Title: TestLambda
* Description:
	java8 内置四大核心函数式接口
	-1) Consumer<T> 消费型接口 ： void accept(T t);
	-2) Supplier<T> 供给型接口 ： T get();
	-3)Function<T,R> 函数型接口 ：R apply(T t);
	-4)Predicate<T> 断言型接口 ： Boolean test(T t);
* @author shencx
* @date 2019年2月25日
 */
public class TestLambda {

	@Test
	public void test() {
		Long aa = jisuan(2l, 3l, (x,y) -> x * y);
		System.out.println(aa);
	}

	@Test
	public void test3() throws Exception {
		List<Integer> list = getNumList(10, ()->(int)(Math.random()*100));
		System.out.println(list);
	}

	public Long jisuan(long a, long b, MyFucntionLambda<Long, Long> myFucntionLambda) {
		return myFucntionLambda.test(a, b);
	}


	//消费型接口
	public void consumer(Consumer<String> cons, String ss) {
		cons.accept(ss);
	}

	//供给型接口
	public List<Integer> getNumList(int num, Supplier<Integer> sup){
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			int e = sup.get();
			list.add(e);
		}
		return list;
	}

	@Test
	public void test2() {
		TreeParent<String> treeParent = new TreeParent<String>("根节点");

		Consumer<String> cos = treeParent::methodTry;

		cos.accept("aaaaaaaaaaa");


		Comparator<Integer> com = Integer::compare;
		System.out.println(com.compare(1, 1111));

		BiPredicate<String, String> b = (x,y) -> x.equals(y);

		System.out.println(b.test("1", "2"));
		b = String::equals;
		System.out.println(b.test("1", "2"));
	}
}
