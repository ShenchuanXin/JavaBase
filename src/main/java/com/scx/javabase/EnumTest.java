package com.scx.javabase;

/**
 * 枚举的作用：使某个类型的变量的取值只能为预制好的固定值，这样就能在编译前检查错误。如一周7天，每天用1~7表示。写代码的时候用8表示就不对。
 *
 * 即：只能使用枚举中的值。
 *
 * @author 86176
 *
 */
public class EnumTest {

	public static void main(String[] args) {

		// 普通类
		WeekDay day = WeekDay.Monday;
		System.out.println(day.nextDay());

		// 抽象类
		WeekDayAb dayAb = WeekDayAb.Monday;
		System.out.println(dayAb.nextDay());

		// 枚举类
		WeekDayEnum dayEnum = WeekDayEnum.Monday;
		System.out.println("---enum----");
		System.out.println(dayEnum); // 枚举类中重写了toString()方法，返回枚举对象的name
		System.out.println(dayEnum.name());
		System.out.println(dayEnum.ordinal()); // 在枚举值中的排序，从0开始

		System.out.println("---enum----static method");
		System.out.println(WeekDayEnum.valueOf("Monday")); // 传入枚举对象的name，返回枚举对象
		System.out.println(WeekDayEnum.values()); // 返回所有的枚举值

	}

	/**
	 * 用普通类来模拟枚举的实现原理
	 *
	 * @author 86176
	 *
	 */
	public static class WeekDay {

		public final static WeekDay Monday = new WeekDay();// 周一
		public final static WeekDay Tuesday = new WeekDay();// 周二

		public WeekDay nextDay() {
			// 如果枚举值很多，就需要写大量的if-else
			return this == Monday ? Tuesday : Monday;
		}

		private WeekDay() {
			// 构造方法私有，外界就只能使用类中预定义的枚举值。
		}

		@Override
		public String toString() {
			return this == Monday ? "Monday" : "Tuesday";
		}

	}

	/**
	 * 用抽象类来模拟枚举的实现原理，避免大量的if判断
	 *
	 * @author 86176
	 *
	 */
	public abstract static class WeekDayAb {

		public final static WeekDayAb Monday = new WeekDayAb() {

			@Override
			public WeekDayAb nextDay() {

				return Tuesday;
			}

			@Override
			public String toString() {
				return "Monday";
			}

		};// 周一 匿名子类
		public final static WeekDayAb Tuesday = new WeekDayAb() {

			@Override
			public WeekDayAb nextDay() {

				return Monday;
			}

			@Override
			public String toString() {
				return "Tuesday";
			}

		};// 周二 匿名子类

		public abstract WeekDayAb nextDay();

		private WeekDayAb() {
			// 构造方法私有，外界就只能使用类中预定义的枚举值。
		}

	}

	/**
	 * 枚举类 jdk5 出现
	 *
	 * WeekDayEnum是一个类，枚举的值是他的实例对象，约定只能为若干个固定的值
	 */
	public enum WeekDayEnum {
		Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
	}

	/**
	 * 实现带有构造方法和抽象方法的枚举
	 */
	public enum WeekDayEnumCus {

		// 枚举值后加(参数)，指定使用的构造方法
		Monday(1) {
			@Override
			public void nextDay() {

			}
		},
		Tuesday {
			@Override
			public void nextDay() {

			}
		},
		Wednesday {
			@Override
			public void nextDay() {

			}
		},
		Thursday {
			@Override
			public void nextDay() {

			}
		},
		Friday {
			@Override
			public void nextDay() {

			}
		},
		Saturday {
			@Override
			public void nextDay() {

			}
		},
		Sunday {
			@Override
			public void nextDay() {

			}
		};

		private WeekDayEnumCus() {

		}

		private WeekDayEnumCus(int a) {

		}

		public abstract void nextDay();
	}
}
