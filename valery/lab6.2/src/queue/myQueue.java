package queue;

import java.util.LinkedList;

public class myQueue {
    // доабвление элемента в очередь
    public static void enqueue(LinkedList<Double> queue, double value) {
        queue.add(0, value);
    }
    // удаление элемента из очереди
    public static void dequeue(LinkedList<Double> queue) {
        queue.remove(queue.size() - 1);
    }
    // вывод очереди в консоль
    public static void show(LinkedList<Double> queue) {
        for (Double aDouble : queue) {
            System.out.print(aDouble + " ");
        }
        System.out.println();
    }
    // сумма всех элементов очереди
    public static void sum(LinkedList<Double> queue) {
        double sum = 0;
        for (Double aDouble : queue) {
            sum += aDouble;
        }
        System.out.println("Сумма элементов: " + String.format("%3.1f", sum));
    }
    // вывод первого и последнего элемента очереди
    public static void getFirstLast(LinkedList<Double> queue) {
        System.out.println("Первый элемент: " + queue.get(0));
        System.out.println("Последний элемент: " + queue.get(queue.size()-1));
    }
}
