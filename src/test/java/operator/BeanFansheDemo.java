package operator;

import com.www.opeartor.entity.Artic;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public class BeanFansheDemo {

	
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		
		
		Artic artic = new Artic();
		artic.setTitle("11111");
		PropertyDescriptor[] propers = PropertyUtils.getPropertyDescriptors(artic.getClass());
		for(PropertyDescriptor pd:propers) {
			System.out.println(pd.getName());
			//System.out.println(PropertyUtils.getProperty(artic, pd.getName()));
		}
	}
}
