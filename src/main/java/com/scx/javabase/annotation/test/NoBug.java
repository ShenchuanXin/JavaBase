package com.scx.javabase.annotation.test;

public class NoBug {
	@CustomizeAnnotation
	public void suanShu() {
		System.out.println("1234567890");
	}

	@CustomizeAnnotation
	public void jiafa() {
		System.out.println("1+1=" + 1 + 1);
	}

	@CustomizeAnnotation
	public void jiefa() {
		System.out.println("1-1=" + (1 - 1));
	}

	@CustomizeAnnotation
	public void chengfa() {
		System.out.println("3 x 5=" + 3 * 5);
	}

	@CustomizeAnnotation
	public void chufa() {
		System.out.println("6 / 0=" + 6 / 0);
	}

	public void ziwojieshao() {
		System.out.println("我写的程序没有 bug!");
	}

}
