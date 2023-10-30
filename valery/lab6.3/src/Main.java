import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    public static void Base() {
        LinkedList<Double> list = new LinkedList<>();
        System.out.println("Введите 10 значений:");
        for(int i = 0; i < 10; i++) {
            list.add(in.nextDouble());
        }
        // идем по списку
        for(int i = 0; i < list.size(); i++) {
            // данный элемент равен 55?
            if(list.get(i) == 55) {
                // удаляем прошлый элемент
                list.remove(i - 1);
            }
        }
        System.out.println("Список после обработки: ");
        // выводим список
        for (Double aDouble : list) {
            System.out.print(aDouble + " ");
        }
        System.out.println();
    }
    public static void Medium() {
        LinkedList<Double> list = new LinkedList<>();
        System.out.println("Введите 10 значений:");
        for(int i = 0; i < 10; i++) {
            list.add(in.nextDouble());
        }
        // идем по списку
        for (int  i = 0; i < list.size(); i++) {
            // данный элемен больше нуля?
            if(list.get(i) > 0) {
                // вносим в список данный элемент
                list.add(list.get(i));
                // разрываем цикл
                break;
            }
        }
        System.out.println("Список после обработки: ");
        // выводим список
        for (Double aDouble : list) {
            System.out.print(aDouble + " ");
        }
        System.out.println();
    }
    public static void Hard() {
        LinkedList<Double> list = new LinkedList<>();
        System.out.println("Введите 10 значений:");
        for(int i = 0; i < 10; i++) {
            list.add(in.nextDouble());
        }
        // идем по списку
        for(int i = 0; i < list.size(); i++) {
            if(i > 0) {
                // если данные элементы уже продублированы
                if(list.get(i).equals(list.get(i - 1))) {
                    // идем к следующему элементу
                    continue;
                }
            }
            // данный элемент списку четный?
            if(list.get(i) % 2 == 0) {
                // добавляем данный элемент по этому же индексу
                list.add(i, list.get(i));
            }
        }
        System.out.println("Список после обработки: ");
        // вывести список
        for (Double aDouble : list) {
            System.out.print(aDouble + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}