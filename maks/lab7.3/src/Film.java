import java.time.LocalTime;
import java.util.Scanner;

public class Film {
    // Поля структуры
    String nameOfMovie;
    LocalTime time;
    int duration;
    String genre;
    String budget;
    // Конструктор
    public Film() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите название фильма: ");
        this.nameOfMovie = scan.nextLine();
        System.out.print("Введите время начала в формате (HH mm ss): ");
        this.time = LocalTime.of(scan.nextInt(), scan.nextInt(), scan.nextInt());
        System.out.print("Введите продолжительность сеанса в минутах: ");
        this.duration = scan.nextInt();
        System.out.print("Введите жанр: ");
        this.genre = scan.next();
        System.out.print("Введите бюджет фильма: ");
        this.budget = scan.next();
        System.out.print("\n\n");
    }
    void show() {
        System.out.printf("Название фильма: %s\nВремя начала: %s\nДлительность: %d\nЖанр: %s\nБюджет: %s\n\n", nameOfMovie, time, duration, genre, budget);
    }
}
