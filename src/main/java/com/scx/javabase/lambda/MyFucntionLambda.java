package com.scx.javabase.lambda;

@FunctionalInterface
public interface MyFucntionLambda<T,R> {

	public R test(T t, T tt);
}
