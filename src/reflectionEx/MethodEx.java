package reflectionEx;

import java.lang.reflect.Method;

class MethodX{

    public void objectMethod(String arg) {
        System.out.println("Instance Method : "+arg);
    }

    public static void classMethod() {
        System.out.println("class method");
    }

}

public class MethodEx {

    static void main() {
        try {
            Class<?> clazz = Class.forName("reflectionEx.MethodX");
            Object instance = clazz.getDeclaredConstructor().newInstance();
            Class[] argType = {String.class};
            Method objectMethod = clazz.getMethod("objectMethod", argType);
            Object[] data = {"Hello"};
            objectMethod.invoke(instance, data);
            objectMethod.setAccessible(true);

            objectMethod = clazz.getMethod("classMethod");
            objectMethod.invoke(null, (Object[]) null);

        } catch (Exception e) {
            System.err.println(e);
        }
    }



}
