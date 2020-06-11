package composition;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflector {
	
	public static Object reflect(Object obj, Object args) {
		
		Method method = null;
		
		Object result = null;
			
		try {
			method = obj.getClass().getMethod("interfaceMethod", Object.class);
		} catch (SecurityException | NoSuchMethodException e) {
			e.printStackTrace();
		}

		try {
			result = method.invoke(obj, args);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

}
