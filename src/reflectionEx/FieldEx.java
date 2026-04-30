package reflectionEx;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;


public class FieldEx {

    static void main() throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        try {
            Class<?> clazz = Class.forName("reflectionEx.Q$X");
            Object x = clazz.getDeclaredConstructors()[0].newInstance();
            Field field = clazz.getField("i");
            System.out.println(field.getInt(x));
            field.setInt(x, 20);
            System.out.println(field.getInt(x));
            Field pi = clazz.getField("PI");
            System.out.println(pi.getDouble(null));
            pi.setDouble(clazz, 4.14);
        } catch (Exception e) {
            throw e;
        }

    }

}
