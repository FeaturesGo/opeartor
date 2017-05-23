package beanUtils;

import com.www.opeartor.entity.Operator;
import junit.framework.TestCase;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 关于BeanUtils工具类的使用
 * Created by Vincent on 2017/5/23.
 */
public class OperatorTest extends TestCase {

    /**
     * 通过BeanUtils对javabean的基本操作
     * The basic operation of javabean through BeanUtils
     */
    @Test
    public void testBeanUtils(){
        Operator operator = new Operator();
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("userName","Alex");
            map.put("userPwd","abc");
            BeanUtils.populate(operator,map);
            System.out.println(operator.getUserName());
            System.out.println(operator.getUserPwd());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
