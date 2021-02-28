import java.util.ArrayList;
import java.util.List;
public class Box<T extends Fruit> {
    private final List<T> fruits = new ArrayList<>();
    /*Не забываем про метод добавления фрукта в коробку.*/
    public void addFruit(T fruit){
        fruits.add(fruit);
    }
/* Сделать метод getWeight() который высчитывает вес коробки,
зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);*/
    public float getWeight(){
        if (fruits.size() > 0){
            return fruits.size() * fruits.get(0).getWeight();
        }
        return 0;
    }
/* Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку
с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в
противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);*/
    public boolean compare (Box <?> box){
        return this.getWeight() == box.getWeight();
    }
/* Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно
в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;*/
    public void emptyTheBox(Box<T> other){
        if (this == other
            || other == null
            || other.fruits.isEmpty()){
            return;
        }
        other.fruits.addAll(fruits);
        fruits.clear();
    }
}


