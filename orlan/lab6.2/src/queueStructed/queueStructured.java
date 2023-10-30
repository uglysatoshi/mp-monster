package queueStructed;

import java.util.LinkedList;
import java.util.Scanner;

public class queueStructured {
    public static class Triangle {
        double a; // первый катет
        double b; // второй катет
        double perimeter; // периметр треугольника
        // Конструктор
        public Triangle() {
            Scanner scan = new Scanner(System.in);
            // Вводим катеты и находим периметр
            System.out.print("Введите значения двух катетов: ");
            this.a = scan.nextDouble();
            this.b = scan.nextDouble();
            this.perimeter = a + b + Math.sqrt(a * a + b * b);
            System.out.print("\n");
        }
        // Вывод конструкции в консоль
        void show() {
            System.out.printf("Первый катет: %.2f\nВторой катет: %.2f\nПериметр треугольника: %.2f\n\n", a, b, perimeter);
        }
    }
    // добавление элемента в очередь
    public static void enqueue(LinkedList<Triangle> queue, Triangle value) {
        queue.add(0, value);
    }
    // удаление элемента из очереди
    public static void dequeue(LinkedList<Triangle> queue) {
        queue.remove(queue.size() - 1);
    }
    // вывод очереди в консоль
    public static void show(LinkedList<Triangle> queue) {
        for (Triangle a : queue) {
            a.show();
        }
    }
    // заполнение очереди
    public static void in(LinkedList<Triangle> q) {
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < 5; i++) {
            enqueue(q, new Triangle());
        }
        System.out.print("\n");
    }
}
