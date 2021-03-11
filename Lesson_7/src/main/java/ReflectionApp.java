import java.lang.reflect.Method;

public class ReflectionApp {
    @MarkingAnnotation
    public void markedMethod() {
        System.out.println("Java");
    }

    public static void main(String[] args) {
        Method[] methods = MyClass.class.getDeclaredMethods();
        for (Method o : methods) {
            if(o.getAnnotation(MarkingAnnotation.class) != null) {
                System.out.println(o);
            }
        }
    }
}
