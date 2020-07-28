package com.scx.javabase;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

/**
 * hashset-arraylist.png 是对hashset与arraylist的描述。
 *
 * @author 86176
 *
 */
public class ListTest {

	public static void main(String[] args) {

	}

	@Test
	public void testArrayList() {
		ArrayList<Point> alist = new ArrayList<Point>();

		Point point1 = new Point(1, 1);
		Point point2 = new Point(1, 2);
		Point point3 = new Point(1, 1);

		alist.add(point1);
		alist.add(point2);
		alist.add(point3);
		System.out.println("当前集合中有" + alist.size() + "个元素");
		alist.add(point1);
		System.out.println("当前集合中有" + alist.size() + "个元素");

		System.out.println(point1 == point3); // == 比较的是内存中的存放地址（确切的说，是堆内存地址）
		System.out.println(point1.hashCode()); // 不同的对象 ，hashcode有可能相同
		System.out.println(point3.hashCode());
		System.out.println(point1);
		System.out.println(point3);

	}

	@Test
	public void testHashSet() {
		HashSet<Point> alist = new HashSet<Point>();

		Point point1 = new Point(1, 1);
		Point point2 = new Point(1, 2);
		Point point3 = new Point(1, 1);

		alist.add(point1);
		alist.add(point2);
		alist.add(point3);  //HashSet根据equal()和hashCode()进行判断，如果相同，则不会添加到集合中。
		System.out.println("当前集合中有" + alist.size() + "个元素");
		alist.add(point1);
		System.out.println("当前集合中有" + alist.size() + "个元素");

		point1.setX(222); //修改point1的x坐标，使其hashcode发生变化。

		alist.add(point1);  //  hashcode变化就可以添加进集合中
		System.out.println("当前集合中有" + alist.size() + "个元素");
	}

	@Test
	public void testHashSet2() throws Exception {
		HashSet<Point> alist = new HashSet<Point>();

		Point point1 = new Point(1, 1);
		Point point2 = new Point(1, 2);
		Point point3 = new Point(1, 1);

		alist.add(point1);
		alist.add(point2);
		alist.add(point3);  //HashSet根据equal()和hashCode()进行判断，如果相同，则不会添加到集合中。
		System.out.println("当前集合中有" + alist.size() + "个元素");

		System.out.println("point1的内存地址：" + RamAdress.addressOf(point1));
		point1.setX(222); //修改point1的x坐标，使其hashcode发生变化。
		System.out.println("修改hashcode后point1的内存地址：" + RamAdress.addressOf(point1));

		alist.remove(point1);  //  删除的时候，是根据hashcode去寻找的，hashcode发生变化时，就找不到该元素了。
		/**
		 * 在进行remove的时候，可能将会出现两种情况：

		　　1、由于找不到此hashcode对应的index，remove不做任何操作。

		　　2、从hashset中删除了一个与之修改后生成对象的hashcode相等的对象

			出问题的点就在：重写hashcode方法后，
			修改成员字段数值会影响hashcode值，
			进而影响到对象在哈希表中的位置，
			致使remove方法无法找到原来的对象。
			但是，对象有在哈希表中有引用，hash对象又没有被释放。
			垃圾回收器发现其还有引用，又不会回收该对象，称作内存泄露。大量的内存泄露以后，于是，内存溢出了（OutOfMemoryError）。
			因此，从根本上解决Java内存溢出的唯一方法就是修改程序，及时地释放没用的对象，释放内存空间。
		 */
		/**
		 * 总结：
		 * 	重写hashcode时，一定要保证同一对象的hashcode的唯一性。
		 * 	重写hashcode后，如果要修改，先从哈希表中删除该对象，修改后再放入哈希表。
		 *
		 */
		System.out.println("当前集合中有" + alist.size() + "个元素");
	}

	class Point {

		private int x;
		private int y;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		private ListTest getOuterType() {
			return ListTest.this;
		}

	}

}
