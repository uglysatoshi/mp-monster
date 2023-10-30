import java.util.Scanner;

public class Hockey {
    // Поля структуры
    String lastname;
    int age;
    int gamesCount;
    int goalsMissed;
    // Конструктор
    public Hockey() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите фамилию игрока: ");
        this.lastname = scan.next();
        System.out.print("Введите возраст игрока: ");
        this.age = scan.nextInt();
        System.out.print("Введите количество игр: ");
        this.gamesCount = scan.nextInt();
        System.out.print("Введите количество пропущенных шайб: ");
        this.goalsMissed = scan.nextInt();
        System.out.print("\n");
    }
    // Функция вывода
    public void show() {
        System.out.printf("Информация о игроке\nФамилия: %s\nВозраст: %d\nКоличество игр: %d\nКоличество пропущенных шайб: %d\n\n", lastname, age, gamesCount, goalsMissed );
    }
}
