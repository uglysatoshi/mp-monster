import queueStructed.*;
import queueDecimal.*;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void Base() {
        LinkedList<queueStructured.Triangle> q = new LinkedList<>();
        // Вводим 5 элементов в очередь
        queueStructured.in(q);
        // Выводим очередь
        queueStructured.show(q);
        // Добавляем еще один элемент
        queueStructured.enqueue(q, new queueStructured.Triangle());
        // Снова выводим очередь
        queueStructured.show(q);
    }
    public static void Medium() {
        Stack<String> s = new Stack<>();
        s.push("Students");
        s.push("of");
        s.push("the");
        s.push("group");
        s.push("TE");
        System.out.printf("Выводим стек: %s\n", s);
        s.pop();
        System.out.printf("Выводим стек: %s\n", s);
        System.out.print("Слова в стеке начинающиеся с 't': ");
        for(String str : s) {
            if(str.startsWith("t")) System.out.printf("%s ", str);
        }
        System.out.print("\n\n");
    }
    public static void Hard() {
        // Объявляем две очереди
        LinkedList <Integer> q1 = new LinkedList<>();
        LinkedList <Integer> q2 = new LinkedList<>();
        // Заполняем очереди
        queueDecimal.in(q1);
        queueDecimal.in(q2);
        // Перемещаем элементы
        queueDecimal.replace(q1,q2);
        // Выводим обе очереди
        queueDecimal.show(q1, 1);
        queueDecimal.show(q2, 2);
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}