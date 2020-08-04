package com.scx.javabase;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * 获取对象的的内存地址
 * @author 86176
 *
 */
public class RamAdress {

	private static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long addressOf(Object o) throws Exception {

        Object[] array = new Object[] { o };

        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();
        long objectAddress;
        switch (addressSize) {
        case 4:
            objectAddress = unsafe.getInt(array, baseOffset);
            break;
        case 8:
            objectAddress = unsafe.getLong(array, baseOffset);
            break;
        default:
            throw new Error("unsupported address size: " + addressSize);
        }
        return (objectAddress);
    }

}
