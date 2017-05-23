package beanUtils;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 测试类各种检测
 * Created by Vincent on 2017/5/23.
 */
public class Tester extends TestCase {


    /**
     *  全局只会执行一次，而且是第一个运行
     */
    @BeforeClass
    public static void setUpBeforeClass(){
        System.out.println("Set up before class");
    }

    /**
     * 期望此方法抛出NullPointerException异常
     */
    @Test(expected = NullPointerException.class)
    public void testException(){
        System.out.println("Test exception");
        Object obj = null;
        obj.toString();
    }

}
