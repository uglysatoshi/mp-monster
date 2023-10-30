import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем список
        LinkedList<Double> list = new LinkedList<>();
        // Заполняем список
        System.out.print("Введите 10 элементов: ");
        for(int i = 0; i < 10; i++) {
            list.add(scan.nextDouble());
        }
        // Удаляем элементы стоящие после положительного
        for(int i = 0; i< list.size()-1; i++) {
            if(list.get(i) > 0) list.remove(list.get(i+1));
        }
        // Выводим результат
        System.out.printf("Список после редактирования: %s\n\n", list);
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Объявляем список
        LinkedList<Double> list = new LinkedList<>();
        // Заполняем список
        System.out.print("Введите 10 элементов: ");
        for(int i = 0; i < 10; i++) {
            list.add(scan.nextDouble());
        }
        // Удаляем элементы стоящие после 4 и добавляем 1 перед 0
        for(int i = 0; i < list.size()-1; i++) {
            if(list.get(i) == 4) list.remove(list.get(i+1));
            if(list.get(i) == 0) {
                list.add(i-1, 1.0);
                i++;
            }
        }
        // Выводим результат
        System.out.printf("Список после редактирования: %s\n\n", list);
    }
    public static void Hard() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите значение K: ");
        int K = scan.nextInt(); // Заданное число K
        List<Integer> list = new LinkedList<>(); // Создаем свой список
        // Заполняем список данными
        System.out.print("Введите 10 элементов: ");
        for (int i = 1; i <= 10; i++) {
            list.add(scan.nextInt());
        }
        System.out.print("Введите значение элемента для перемещения: ");
        int P0 = scan.nextInt(); // Указатель на элемент, который нужно переместить
        // Находим указатель на первый элемент и перемещаем элемент P0 на K позиций вперед
        ListIterator<Integer> iterator = list.listIterator();
        int firstPointer = -1;
        int lastPointer = -1;
        while (iterator.hasNext()) {
            int current = iterator.next();
            if (current == P0) {
                firstPointer = current;
                iterator.remove();
                for (int i = 0; i < K && iterator.hasNext(); i++) {
                    iterator.next();
                }
                iterator.add(P0);
                lastPointer = P0;
                break;
            }
        }
        // Если P0 был последним элементом, обновляем lastPointer
        if (lastPointer == -1) {
            lastPointer = P0;
        }
        // Выводим указатели на первый и последний элементы преобразованного списка
        System.out.println("Указатель на первый элемент: " + firstPointer);
        System.out.println("Указатель на последний элемент: " + lastPointer);
        System.out.println("Список: " + list);
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}