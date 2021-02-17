import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {


        /* 1.Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа); */
        String [] word = {"plus","minus"};
        System.out.println(Arrays.deepToString(word));
        swap(word, 0, 1);
        System.out.println(Arrays.deepToString(word));
    }

    private static <String> void swap(String[] word, int i, int i1) {
        // проверки тупо позаимствовал из видео, для механической памяти, может что то и запомню
        if (word != null
        && i < word.length
        && i1 < word.length
        && i >= 0
        && i1 >= 0
        && i != i1) {
            String w = word[i];
            word[i] = word[i1];
            word[i1] = w;
        }
    }
        /* 2. Написать метод, который преобразует массив в ArrayList;
        * Я его немного укоротил, опять же по видео */
        public static <T> ArrayList<T> toArrayList(T[] arr) {
            return new ArrayList<T>(Arrays.asList(arr));
        }
}
