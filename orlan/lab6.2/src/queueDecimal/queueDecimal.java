package queueDecimal;

import java.util.LinkedList;
import java.util.Scanner;

public class queueDecimal {
    // добавление элемента в очередь
    public static void enqueue(LinkedList<Integer> queue, Integer value) {
        queue.add(0, value);
    }
    // удаление элемента из очереди
    public static void dequeue(LinkedList<Integer> queue) {
        queue.remove(queue.size() - 1);
    }
    // вывод очереди в консоль
    public static void show(LinkedList<Integer> queue, int num) {
        System.out.printf("Очередь %d: \n[ ", num);
        for (Integer a : queue) {
            System.out.print(a + " ");
        }
        System.out.print("]\n");
    }
    // заполнение очереди
    public static void in(LinkedList<Integer> q) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите 10 элементов: ");
        for(int i = 0; i < 10; i++) {
            enqueue(q, scan.nextInt());
        }
        System.out.print("\n");
    }
    // Перенесение элементов из очереди 1 в очередь 2
    public static void replace(LinkedList<Integer> q1, LinkedList<Integer> q2) {
        for(int i = q1.size() - 1; i >= 0; i--) {
            if (q1.get(i) % 2 == 0) break;
            enqueue(q2, q1.get(i));
        }
    }
}
