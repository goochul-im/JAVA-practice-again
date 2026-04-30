package reflectionEx;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface PP {

}

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface CC {

}

@PP
class PPClass {

}

@CC
class CCClass extends PPClass {

}

public class AnnotationEx {

    static void main() {

        Annotation[] declaredAnnotations = CCClass.class.getAnnotations();

        for (Annotation annotation : declaredAnnotations) {
            Class<? extends Annotation> aClass = annotation.annotationType();
            System.out.println(aClass.getSimpleName());
        }


    }

}
