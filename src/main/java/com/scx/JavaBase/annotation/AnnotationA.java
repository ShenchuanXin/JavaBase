package com.scx.javabase.annotation;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 86176
 *
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE}) //标记该注解应用的范围
@Retention(RetentionPolicy.SOURCE) //标记该注解的的存活时间
@Documented //它的作用是能够将注解中的元素包含到 Javadoc 中去
public @interface AnnotationA {

	String value();

	int hello() default  -1; //定义hello属性，默认值 -1
}


