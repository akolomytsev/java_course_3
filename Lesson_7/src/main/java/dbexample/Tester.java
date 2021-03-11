package dbexample;

public class Tester {

    @Ann
    public static void testOne(){
        System.out.println("testOne");
    }
    @AnnWithParams(description = "Second test", executionTimes = 5)
    public static void testTwo(){
        System.out.println("testTwo");
    }
    public static void testThree(){
        System.out.println("testThree");
    }


}
