package dbexample;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //первый способ создания доткласса
        Class<Cat> catClass = Cat.class; // объект доткласс Cat.class и ссылка на него Class<Cat> ,
        // объект доткласса хранит информацию обо всем том что хранитя в самом классе
        // второй способ
        // Cat cat = new Cat("Furry");// создаем объект класса
        // Class<Cat> catClass1 = (Class<Cat>) cat.getClass();//  получаем через объект, но это не очень
        //Class catClass1 = (Class<Cat>) cat.getClass(); совсем не очень
        // третий способ
        //Class<Cat> catClass2 =(Class<Cat>) Class.forName("Cat");


        Cat cat = new Cat("Furry", "black", 2);

//        Constructor<Cat> constructor = catClass.getConstructor(String.class, String.class, int.class);
//        Cat cat1 = constructor.newInstance("Barry", "red", 1);
//        cat1.info();
//
//        Method[] methods = catClass.getMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//
//        }

//        Method[] declaredMethods = catClass.getDeclaredMethods();
//        for (Method declaredMethod : declaredMethods) {
//            System.out.println(declaredMethod);
//        }

//        Method info = catClass.getMethod("info");
//        info.invoke(cat);

//        Method jump = catClass.getDeclaredMethod("jump");
//        jump.invoke(cat);

        Method meow = catClass.getDeclaredMethod("meow");
//        meow.setAccessible(true);
//        meow.invoke(cat);


//        int modifiers = meow.getModifiers(); // метод для проверки (грубо) уровня доступа к методу
//        System.out.println("isPublic " + Modifier.isPublic(modifiers));
//        System.out.println("isFinal " + Modifier.isFinal(modifiers));
//        System.out.println("isPrivate " + Modifier.isPrivate(modifiers));


//        Field[] declaredFields = catClass.getDeclaredFields();
//        for (Field declaredField : declaredFields) {
//            System.out.println(declaredField);
//        }

//        System.setSecurityManager(new SecurityManager()); //обрубает возможность
//        и читать и писать в метод, запрещает рефлекшн

//        Field name = catClass.getDeclaredField("name");
//        name.setAccessible(true);
//        System.out.println(name.get(cat));
//
//        name.set(cat, "Murzik");
//
//        cat.info();


//        Class<Tester> testerClass = Tester.class;
//        Method[] declaredMethods = testerClass.getDeclaredMethods();
//        for (Method declaredMethod : declaredMethods) {
//            if (declaredMethod.isAnnotationPresent(Ann.class)){
//                declaredMethod.invoke(null);
//            }
//
//        }

        Class<Tester> testerClass = Tester.class;
        Method[] declaredMethods = testerClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(AnnWithParams.class)){
                System.out.println(declaredMethod.getAnnotation(AnnWithParams.class).description());
                int i = declaredMethod.getAnnotation(AnnWithParams.class).executionTimes();
                for (int j = 0; j < i; j++) {
                    declaredMethod.invoke(null);

                }
            }

        }
    }
}