import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import queue.*;

public class Main {
    // Структура книги
    private static class Book {
        // Поля
        String name; // Название книги
        int cntPages; // Количество страниц

        // Конструктор
        Book() {
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите название книги: ");
            this.name = scan.nextLine();
            System.out.print("Введите количество страниц: ");
            this.cntPages = scan.nextInt();
            System.out.print("\n");
        }
        // Вывод полей структуры
        void show() {
            System.out.printf("Название книги: %s\nКоличество страниц: %d\n\n", name, cntPages);
        }
    }
    public static void Base() {
        // Объявляем список
        Stack<Book> stack = new Stack<>();
        // Добавляем в список 5 элементов Book
        for(int i = 0; i < 5; i++) {
            stack.push(new Book());
        }
        // Выводим размер стека (Кол-во книг)
        System.out.printf("Количество книг в стеке: %d\n", stack.size());
        // Выводим все элементы стека(книги)
        for(Book b : stack) {
            b.show();
        }
    }
    public static void Medium() {
        Stack <Integer> stack =  new Stack<>();
        stack.push(-5);
        stack.push(3);
        stack.push(-4);
        stack.push(5);
        System.out.print("Выводим стек: \n");
        for (Integer integer : stack) {
            System.out.printf("%d ", integer);
        }
        System.out.print("\n");
        stack.pop();
        stack.push(10);
        System.out.print("Выводим стек: \n");
        int sum = 0;
        for (Integer integer : stack) {
            System.out.printf("%d ", integer);
            if(integer > 0) sum += integer;
        }
        System.out.printf("\nСумма всех положительных элементов стека: %d\n\n", sum);
    }
    public static void Hard() {
        // Объявляем очереди и исполняем все функции описанные в пакете queue
        LinkedList <Integer> q1 = new LinkedList<>();
        LinkedList <Integer> q2 = new LinkedList<>();
        queue.in(q1);
        queue.in(q2);
        queue.replace(q1,q2);
        queue.show(q1, 1);
        queue.show(q2, 2);
    }
    public static void main(String[] args) {
//        Base();
//        Medium();
        Hard();
    }
}