import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем список
        LinkedList<Double> list = new LinkedList<>();
        // Вносим в список 10 элементов
        System.out.print("Введите 10 вещественных чисел: ");
        for(int i = 0; i < 10; i++) {
            list.add(scan.nextDouble());
        }
        // После каждого элемента равного 55 добавляем 0.99
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == 55) list.add(i +1, 0.99);
        }
        // Выводим список
        for(double d : list) {
            System.out.printf("%.2f ", d);
        }
        System.out.print("\n\n");
    }
    public static void Medium() {
        // Объявляем список
        LinkedList<Character> list = new LinkedList<>();
        // Добавляем в список элементы
        list.add('c'); list.add('9'); list.add('g');
        list.add('1'); list.add('0'); list.add('w');
        list.add('q'); list.add(']'); list.add(';');
        // Выводим список
        for(char c : list) {
            System.out.printf("%c ", c);
        }
        System.out.print("\n\n");
        // Удаляем все элементы списка с кодом символа ниже 50
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) < 50) {
                list.remove(i);
                break;
            }
        }
        // Выводим список
        for(char c : list) {
            System.out.printf("%c ", c);
        }
        System.out.print("\n\n");
        // Заменяем все цифры на %
        for(int i = 0; i < list.size(); i++) {
            if(Character.isDigit(list.get(i))) {
                list.add(i+1, '%');
            }
        }

        for(char c : list) {
            System.out.printf("%c ", c);
        }
        System.out.print("\n\n");
    }
    public static void Hard() {
        // Создание и заполнение исходного списка
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        // Вывод исходного списка
        System.out.println("Исходный список:");
        printList(head);
        // Перемещение элементов между Px и Py в новый список
        Node newHead = moveElements(node2, node4);
        // Вывод преобразованного списка
        System.out.println("Преобразованный список:");
        printList(head);
    }
    public static Node moveElements(Node px, Node py) {
        // Создание нового списка
        Node newHead = px.next;
        // Обновление связей в исходном списке
        px.next = py;
        py.prev = px;
        // Обновление связей в новом списке
        if (newHead != null) {
            newHead.prev = null;
        }
        // Возвращаем указатель на новый список
        return newHead;
    }
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}