import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static class MergeLinkedLists {
        public static ListNode mergeLists(ListNode pa, ListNode pb, ListNode pc) {
            // Находим последний элемент второго списка (Pc указывает на один из элементов второго списка)
            ListNode pcEnd = pc;
            while (pcEnd.next != null) {
                pcEnd = pcEnd.next;
            }
            // Объединяем списки
            pcEnd.next = pa;
            pa.prev = pcEnd;
            pb.next = null; // Устанавливаем null в следующем элементе второго списка, чтобы разделить списки

            return pc;
        }
        public static void printList(ListNode head) {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
    public static void Base() {
        Scanner scan = new Scanner(System.in);
        // Объявляем список
        LinkedList<Integer> list = new LinkedList<>();
        // Заполняем список
        System.out.print("Введите 10 целочисленных значений: ");
        for(int i = 0; i < 10; i++) {
            list.add(scan.nextInt());
        }
        // Удаляем первый элемент равный 10
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == 10) {
                list.remove(list.get(i));
                break;
            }
        }
        // Выводим список
        System.out.printf("Список после редактирования: %s\n\n", list);
    }
    public static void Medium() {
        Scanner scan = new Scanner(System.in);
        // Объявляем список
        LinkedList<Integer> list = new LinkedList<>();
        // Заполняем список
        System.out.print("Введите 10 целочисленных значений: ");
        for(int i = 0; i < 10; i++) {
            list.add(scan.nextInt());
        }
        // Проводим суммирование
        int sum = 0;
        for(int a : list) {
            if(a >= 15) sum += a;
        }
        // Удаляем все элементы <5
        list.removeIf(x -> x < 5);
        // Выводим результаты
        System.out.printf("Список после редактирования: %s\nСумма элементов больших, либо равных 15: %d\n\n", list, sum);
    }
    public static void Hard() {
        // Создаем исходные списки
        ListNode pa1 = new ListNode(1);
        ListNode pa2 = new ListNode(2);
        ListNode pa3 = new ListNode(3);
        ListNode pb1 = new ListNode(4);
        ListNode pb2 = new ListNode(5);
        ListNode pc1 = new ListNode(6);
        ListNode pc2 = new ListNode(7);
        // Связываем элементы в списки
        pa1.next = pa2;
        pa2.prev = pa1;
        pa2.next = pa3;
        pa3.prev = pa2;
        pb1.next = pb2;
        pb2.prev = pb1;
        pb2.next = pc1;
        pc1.prev = pb2;
        pc1.next = pc2;
        pc2.prev = pc1;
        // Выводим два списка до изменения
        System.out.print("Первый список: ");
        MergeLinkedLists.printList(pa1);
        System.out.print("Второй список: ");
        MergeLinkedLists.printList(pb1);
        // Вызываем функцию для объединения списков
        ListNode mergedList = MergeLinkedLists.mergeLists(pa1, pb1, pc1);
        // Выводим объединенный список
        System.out.println("Объединенный список:");
        MergeLinkedLists.printList(mergedList);
    }
    public static void main(String[] args) {
        Base();
        Medium();
        Hard();
    }
}