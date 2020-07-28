package com.scx.javabase.Lambda;

@FunctionalInterface
public interface MyFucntionLambda<T,R> {

	public R test(T t, T tt);
}
