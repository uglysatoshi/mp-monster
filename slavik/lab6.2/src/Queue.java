import java.util.LinkedList;

public class Queue {
    // доабвление элемента в очередь
    public static void enqueueS(LinkedList<String> queue, String str) {
        queue.add(0, str);
    }
    // удаление элемента из очереди
    public static void dequeueS(LinkedList<String> queue) {
        queue.remove(queue.size() - 1);
    }
    // вывод очереди в консоль
    public static void showS(LinkedList<String> queue) {
        for (String s : queue) {
            System.out.printf("%s\n", s);
        }
        System.out.println();
    }
    public static void countS(LinkedList<String> queue) {
        int count = 0;
        for (String s : queue) {
            if (s.startsWith("s") || s.startsWith("t")) count++;
        }
        System.out.printf("Количество строк в очереди начинающиеся на s или t: %d\n\n", count);
    }
    // вывод первого и последнего элемента очереди
    public static void getFirstLast(LinkedList<Double> queue) {
        System.out.println("Первый элемент: " + queue.get(0));
        System.out.println("Последний элемент: " + queue.get(queue.size()-1));
    }
    // доабвление элемента в очередь
    public static void enqueue(LinkedList<Double> queue, double value) {
        queue.add(0, value);
    }
    // вывод очереди в консоль
    public static void show(LinkedList<Double> queue) {
        for (Double aDouble : queue) {
            System.out.print(aDouble + " ");
        }
        System.out.println();
    }
}
