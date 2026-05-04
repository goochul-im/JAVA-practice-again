package annotationEx;

import java.lang.annotation.Annotation;

public class DeprecateEx {

    private static class ClassEx {

        @Deprecated(forRemoval = true)
        void run() {
            System.out.println("run");
        }

    }

    public static void main(String[] args) {

        Class<AnnotationEx> annotationExClass = AnnotationEx.class;
        Annotation[] annotations = annotationExClass.getAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println(annotation.getClass());
            System.out.println(annotation.hashCode());
            System.out.println(annotation.toString());
            System.out.println(annotation.equals(annotation));
        }

    }

}
