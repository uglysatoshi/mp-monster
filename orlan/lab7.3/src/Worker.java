import java.util.Scanner;

public class Worker {
    // Поля структуры
    String lastname;
    int age;
    String edDegree;
    String title;
    // Конструктор
    public Worker() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите фамилию: ");
        this.lastname = scan.next();
        System.out.print("Введите возраст: ");
        this.age = scan.nextInt();
        System.out.print("Введите образование: ");
        this.edDegree = scan.next();
        System.out.print("Введите должность: ");
        this.title = scan.next();
        System.out.print("\n");
    }
    // Конструктор
    void show() {
        System.out.printf("Фамилия: %s\nВозраст: %d\nОбразование: %s\nДолжность: %s\n\n", lastname, age, edDegree, title);
    }
}
