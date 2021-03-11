package check;

import org.junit.Assert;
import org.junit.Test;

public class MyMethodTest {
    MyMethod main = new MyMethod();

//    @Test(expected = RuntimeException.class)
//    public void testArrayAfterFouException(){
//        int[] arr = {1, 2, 3, 2};
//        int[] expectedArr = {};
//        int[] result = main.arrayAfterFour(arr);
//        Assert.assertArrayEquals(expectedArr, result);
//    }

    @Test(expected = RuntimeException.class)
    public void testArrayAfterFouException(){
        int[] arr = {1, 2, 3, 2};
        int[] expectedArr = {};
        int[] result = main.checkArray(arr);
        Assert.assertArrayEquals(expectedArr, result);
    }

    @Test
    public void testArrayAfterFouException1(){
        int[] arr = {1, 2, 3, 2, 4};
        int[] expectedArr = {};
        int[] result = main.checkArray(arr);
        Assert.assertArrayEquals(expectedArr, result);
    }

    @Test
    public void testArrayAfterFouException2(){
        int[] arr = {4, 2, 3, 2};
        int[] expectedArr = {2, 3, 2};
        int[] result = main.checkArray(arr);
        Assert.assertArrayEquals(expectedArr, result);
    }

    @Test
    public void testArrayAfterFouException3(){
        int[] arr = {4, 2, 4, 2};
        int[] expectedArr = {2};
        int[] result = main.checkArray(arr);
        Assert.assertArrayEquals(expectedArr, result);
    }


    @Test
    public void testcheckArray2(){
        int[] arr = {4, 2, 4, 2};
        Assert.assertFalse(main.checkArray2(arr));
    }

    @Test
    public void testcheckArray21(){
        int[] arr = {4, 1, 1, 1};
        Assert.assertTrue(main.checkArray2(arr));
    }
    @Test
    public void testcheckArray22(){
        int[] arr = {1, 1, 1, 1};
        Assert.assertTrue(main.checkArray2(arr));
    }
    @Test
    public void testcheckArray23(){
        int[] arr = {4, 4, 4, 4};
        Assert.assertTrue(main.checkArray2(arr));
    }
}
