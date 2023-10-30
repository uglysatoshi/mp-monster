import java.time.LocalDate;
import java.util.Scanner;

public class Player {
    // Поля структуры
    String lastname;
    LocalDate date;
    String birthPlace;
    String role;
    int countGames;
    int yellowCards;
    // Конструктор
    public Player() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите фамилию: ");
        this.lastname = scan.next();
        System.out.print("Введите дату рождения(ГГГГ мм ДД): ");
        this.date = LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt());
        System.out.print("Введите место рождения: ");
        this.birthPlace = scan.next();
        System.out.print("Введите роль: ");
        this.role = scan.next();
        System.out.print("Введите количество игр: ");
        this.countGames = scan.nextInt();
        System.out.print("Введите количество желтых карточек: ");
        this.yellowCards = scan.nextInt();
        System.out.print("\n");
    }
    // Конструктор
    void show() {
        System.out.printf("Фамилия: %s\nДата рождения: %s\nМесто рождения: %s\nРоль: %s\nКоличество матчей: %d\nКоличество желтых карточек: %d\n\n", lastname, date, birthPlace, role, countGames, yellowCards);
    }

}
