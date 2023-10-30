import java.util.Scanner;

public class Display {
    // Поля структуры
    String model;
    int price;
    double x_size;
    double y_size;
    int optic;
    // Конструктор
    public Display() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите название модели: ");
        this.model = scan.nextLine();
        System.out.print("Введите цену: ");
        this.price = scan.nextInt();
        System.out.print("Введите размер по горизонтали: ");
        this.x_size = scan.nextDouble();
        System.out.print("Введите размер по вертикали: ");
        this.y_size = scan.nextDouble();
        System.out.print("Введите оптическое разрешение: ");
        this.optic = scan.nextInt();
        System.out.print("\n\n");
    }
    // Функция вывода
    void show() {
        System.out.printf("Модель: %s\nЦена: %d$\nРазмер по горизонтали: %.1f\nРазмер по вертикали: %.1f\nОптическое разрешение: %d\n\n", model, price, x_size, y_size, optic);
    }
}
