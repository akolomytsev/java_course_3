package check;

import java.util.Arrays;


public class MyMethod {

//    public int[] arrayAfterFour(int [] arr){
//        for (int i = arr.length - 1; i >= 0; i--) {
//            if (arr[i] == 4){
//                return Arrays.copyOfRange(arr, i + 1, arr.length);
//            }
//        }
//        throw new RuntimeException();
//    }


    public int[] checkArray(int[] arr) {
        int x = 0;
        int [] result = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                x = arr[i];
                result = new int[arr.length - i - 1];
                for (int j = i + 1, k = 0; j < arr.length; j++, k++) {
                    if (arr[j] == 4) continue;
                    result[k] = arr[j];
                }
            }
        }
        try{
            x = 1 / x;
        } catch(ArithmeticException e){
            throw new RuntimeException();
        }
        return result;
    }


    public boolean checkArray2(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 1 && arr[i] != 4) return false;
        }
        return true;
    }
}
