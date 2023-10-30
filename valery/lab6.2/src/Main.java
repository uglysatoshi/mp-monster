import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import queue.myQueue;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    public static void Base() {
        Stack<Double> stack = new Stack<>();
        // Вводим 10 элементов с клавиатуры
        System.out.println("Введите 10 элементов стэка:");
        for (int i = 0; i < 10; i++) {
            stack.push(in.nextDouble());
        }


        double max = Double.MIN_VALUE;
        while(!stack.empty()) { // пока стэк не пуст
            if(stack.lastElement() > max) // если данный элемент больше максимального
                max = stack.lastElement();
            System.out.print(stack.lastElement() + " "); // выводим элемент
            stack.pop(); // удаляем
        }
        System.out.println("\nМаксимальный элемент: " + max); // выводим максимальный элемент
    }
    public static void Medium() {
        LinkedList<Double> queue = new LinkedList<>();
        myQueue.enqueue(queue, 2.1);
        myQueue.enqueue(queue, 2.1);
        myQueue.enqueue(queue, 5.3);
        myQueue.show(queue);
        myQueue.dequeue(queue);
        myQueue.show(queue);
        myQueue.enqueue(queue, 4.9);
        myQueue.show(queue);
        myQueue.sum(queue);
    }
    public static void Hard() {
        // задаем массив из 10 чисел
        double[] arr = new double[]{7, 12, 53, 74, 5, 16, 73, 82, 97, 10};
        // задаем две очереди
        LinkedList<Double> queueFirst = new LinkedList<>();
        LinkedList<Double> queueSecond = new LinkedList<>();

        // вносим в очереди значения по четным и нечетным индексам
        for (int i = 0; i < 10; i++) {
            if(i % 2 == 0) {
                myQueue.enqueue(queueSecond, arr[i]);
            }
            else {
                myQueue.enqueue(queueFirst, arr[i]);
            }
        }

        myQueue.show(queueFirst);
        myQueue.show(queueSecond);

        myQueue.getFirstLast(queueFirst);
        myQueue.getFirstLast(queueSecond);
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}