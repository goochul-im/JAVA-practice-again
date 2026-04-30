package reflectionEx;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectionEx {

    static void main() throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, InstantiationException, IllegalAccessException {

        Class<ReflectMember> reflectMemberClass = ReflectMember.class;

        Class<?> reflectMember = Class.forName("reflectionEx.ReflectMember");

        System.out.println(reflectMember == reflectMemberClass); // true

        System.out.println(Arrays.toString(reflectMember.getAnnotations()));

        Class<?>[] classes = reflectMember.getClasses(); // 내부에 생성된 퍼블릭 클래스
        System.out.println(Arrays.toString(classes));

        Class<?>[] declaredClasses = reflectMember.getDeclaredClasses(); // 내부에 생성된 프라이빗 클래스도 같이
        System.out.println(Arrays.toString(declaredClasses));

        Constructor<?>[] constructor = reflectMember.getConstructors();
        System.out.println(Arrays.toString(constructor));

        Constructor<?>[] declaredConstructors = reflectMember.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));

        Field[] declaredFields = reflectMember.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));

        Field[] fields = reflectMember.getFields();
        System.out.println(Arrays.toString(fields));

//        reflectMember.getField("name");

        Method[] declaredMethods = reflectMember.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods));

        Method[] methods = reflectMember.getMethods();
        System.out.println(Arrays.toString(methods));

        int modifiers = reflectMember.getModifiers();
        System.out.println(Modifier.toString(modifiers));

        String name = reflectMember.getName();
        System.out.println(name);

        Class<?> superclass = reflectMember.getSuperclass();
        System.out.println(superclass);

        Object o = reflectMember.newInstance();

        Annotation[] declaredAnnotations = reflectMember.getDeclaredAnnotations();
        System.out.println(Arrays.toString(declaredAnnotations));

    }

}
