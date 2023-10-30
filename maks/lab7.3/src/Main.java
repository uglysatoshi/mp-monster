import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {
    public static void Base() {
        // Объявляем список
        LinkedList<Book> list = new LinkedList<>();
        // Объявляем список
        for(int i = 0; i < 5; i++) {
            list.add(new Book());
        }
        // Выводим все книги с количеством страниц больше 150
        System.out.print("Книги с количеством страниц более 150: \n");
        for(Book b : list) {
            if(b.countPages > 150) b.show();
        }
        System.out.print("\n\n");
    }
    public static void Medium() {
        // Объявляем список
        LinkedList<Film> list = new LinkedList<>();
        // Объявляем список
        for(int i = 0; i < 5; i++) {
            list.add(new Film());
        }
        // Выводим фильмы начинающиеся после 18.00 и продолжительностью более 100 минут.
        System.out.print("Фильмы начинающиеся после 18.00 и длящиеся более 100 минут: \n");
        for(Film f : list) {
            if(f.duration > 100 && f.time.isAfter(LocalTime.of(18, 0, 0))) f.show();
        }
        System.out.print("\n\n");
    }
    public static void Hard() {
        LinkedList<Display> list = new LinkedList<>();
        input(list);
        sort(list);
        System.out.print("Отсортированный список: \n");
        print(list);
        toFile(list);
    }
    // Ввод значений в список
    private static void input(LinkedList<Display> list) {
        for(int i = 0; i < 8; i++) {
            list.add(new Display());
        }
    }
    // Сортировка по разрешению дисплея
    private static void sort(LinkedList<Display> list) {
        list.sort(Comparator.comparingInt(display -> display.optic));
    }
    // Вывод списка
    private static void print(LinkedList<Display> list) {
        for(Display d : list) {
            d.show();
        }
    }
    // Внос значений в файл
    private static void toFile(LinkedList<Display> list) {
        try (FileWriter writer = new FileWriter("displays.txt")) {
            for(Display d : list) {
                writer.write(d.model + "\n");
                writer.write(d.price + "\n");
                writer.write(d.x_size + "\n");
                writer.write(d.y_size + "\n");
                writer.write(d.optic + "\n");
                writer.write("\n");
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
//        Base();
//        Medium();
        Hard();
    }
}