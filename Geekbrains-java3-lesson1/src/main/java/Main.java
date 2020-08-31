import javax.swing.text.Position;

import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws PositionException {
        Task_Description();
        task1();
        task2();
        task3();
    }

    private static void Task_Description() {
        System.out.println("1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);\n" +
                "2. Написать метод, который преобразует массив в ArrayList;\n" +
                "3. Большая задача:\n" +
                "a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)\n" +
                "b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;\n" +
                "c. Для хранения фруктов внутри коробки можете использовать ArrayList;\n" +
                "d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);\n" +
                "e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);\n" +
                "f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;\n" +
                "g. Не забываем про метод добавления фрукта в коробку.");
    }

    private static void task1() throws PositionException {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        String[] stringArray = {"Один", "Два", "Kot", "Четыре", "Пять"};
        Double[] doubleArray = {1.0, 2.5, 3.0, 4.5, 5.5, 6.76, 7.34, 8.0, 9.54, 150.32};
        try {
            System.out.println("Исходный массив intArray " + Arrays.toString(intArray));
            ChangePosition(intArray, 0, 10);
            System.out.println("Результат замены в массиве intArray " + Arrays.toString(intArray));
            System.out.println("Исходный массив stringArray " + Arrays.toString(stringArray));
            ChangePosition(stringArray, 1, 3);
            System.out.println("Результат замены в массиве stringArray " + Arrays.toString(stringArray));
            System.out.println("Исходный массив doubleArray " + Arrays.toString(doubleArray));
            ChangePosition(doubleArray, 8, 9);
            System.out.println("Результат замены в массиве doubleArray " + Arrays.toString(doubleArray));
        } catch (PositionException e) {
            e.printStackTrace();
        }
    }

    private static void ChangePosition(Object[] array, int a, int b) throws PositionException {
        if (a < 0 || a > array.length || b < 0 || b > array.length)
            throw new PositionException("Позиции для замены указаны некорректно.");

        Object temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static void task2(){
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        String[] stringArray = {"Один", "Два", "Kot", "Четыре", "Пять"};
        Double[] doubleArray = {1.0, 2.5, 3.0, 4.5, 5.5, 6.76, 7.34, 8.0, 9.54, 150.32};
        ChangeArrayToArrayList(intArray);
        ChangeArrayToArrayList(stringArray);
        ChangeArrayToArrayList(doubleArray);
        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(stringArray));
        System.out.println(Arrays.toString(doubleArray));
    }

    private static <T> ArrayList ChangeArrayToArrayList(T[] array) {
        return  new ArrayList<T>(Arrays.asList(array));
    }

    private static void task3(){
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();
        Box<Orange> OrangeBox = new Box<Orange>(orange1, orange2,orange3,orange4);
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();
        Apple apple6 = new Apple();
        Box<Apple> AppleBox = new Box<Apple>(apple1, apple2, apple3, apple4, apple5, apple6);
        System.out.println(OrangeBox.getWeight());
        System.out.println(AppleBox.getWeight());
        System.out.println(OrangeBox.compare(AppleBox));
        Box<Orange> OrangeBox2 = new Box<Orange>(orange1, orange2,orange3);
        OrangeBox2.Transfer_To(OrangeBox);
        System.out.println(OrangeBox.getWeight());
        System.out.println(OrangeBox2.getWeight());
        OrangeBox2.add(orange1);
        System.out.println(OrangeBox2.getWeight());
    }
}
