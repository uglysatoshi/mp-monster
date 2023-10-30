import java.util.Scanner;

public class Marshrut {
    // Поля структуры
    int number;
    String start;
    String end;
    int length;
    // Конструктор
    public Marshrut() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите номер маршрута: ");
        this.number = scan.nextInt();
        System.out.print("Введите начальный пункт: ");
        this.start = scan.next();
        System.out.print("Введите конечный пункт: ");
        this.end = scan.next();
        System.out.print("Введите длина маршрута (км): ");
        this.length = scan.nextInt();
    }
    // Функция вывода
    public void show() {
        System.out.printf("Номер маршрута: %d\nНачальный пункт: %s\nКонечный пункт: %s\nДлина: %d км\n\n", number,start,end,length);
    }
}
