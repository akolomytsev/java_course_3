package dbexample;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class Cat {
    private final String name;
    private String color;
    private int age;

    public void info(){
        System.out.printf("%s %d %s\n", name, age, color);

    }
    void jump(){
        System.out.printf("%s: jump\n", name);
    }

    private void meow(){
        System.out.printf("%s: meow\n", name);
    }
}
