import java.util.Scanner;

// класс базового уровня
public class Base {
    // поля класса
    int minutes;
    int seconds;
    // конструктор класса
    Base() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество минут: ");
        this.minutes = in.nextInt();
        System.out.print("Введите количество секунд: ");
        this.seconds = in.nextInt();
    }
}
