import java.util.LinkedList;

public class Main {
    public static void Base() {
        // Объявляем список
        LinkedList<Prism> list = new LinkedList<>();
        // Вносим 10 элементов Prism в список
        for (int i = 0; i < 10; i++) {
            list.add(new Prism((Math.random() * 100), (Math.random() * 100), (Math.random() * 100)));
        }
        // Выводим все элементы списка
        for (Prism p : list) {
            System.out.print(p);
        }
    }

    public static void Medium() {
        // Объявляем список
        LinkedList<SemiFraction> list = new LinkedList<>();
        // Вносим 10 элементов SemiFraction в список
        for (int i = 0; i < 10; i++) {
            list.add(new SemiFraction((int) (Math.random() * 100) + 1, (int) (Math.random() * 100) + 1));
        }
        // Выводим все элементы списка
        for (SemiFraction sf : list) {
            System.out.print(sf);
        }
    }

    public static void main(String[] args) {
        Base();
        Medium();
    }
}