package com.www.opeartor.core.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 * 
 * @author hwg
 *@Retention 注解会在class字节码文件中存在，在运行时可以通过反射获取到
 *@Target  字段、枚举的常量
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomTranslate {

}
