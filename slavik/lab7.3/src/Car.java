import java.util.Scanner;

public class Car {
    // Поля структуры
    String type;
    String label;
    int weightUp;
    int age;
    String date;
    // Конструктор
    public Car() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите марку автомобиля: ");
        this.type = scan.nextLine();
        System.out.print("Введите производителя автомобиля: ");
        this.label = scan.nextLine();
        System.out.print("Введите грузоподъемность автомобиля: ");
        this.weightUp = scan.nextInt();
        System.out.print("Введите год выпуска автомобиля: ");
        this.age = scan.nextInt();
        System.out.print("Введите дату регистрации автомобиля: ");
        this.date = scan.next();
    }
    // Функция вывода
    public void show() {
        System.out.printf("Марка: %s\nПроизводитель: %s\nГрузоподъемность: %d т.\nГод выпуска: %d\nДата выпуска: %s\n\n", type, label, weightUp, age, date);
    }
}
