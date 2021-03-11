package dbexample;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AnnWithParams {
    String description() default  "";
    int executionTimes() default 0; // это наше значение, сколько надо столько будет

}
