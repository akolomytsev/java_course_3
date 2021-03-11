package dbexample;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // у анатоции есть своя анатауия
@Target(ElementType.METHOD) // то на чем будет анатация
public @interface Ann {

}
