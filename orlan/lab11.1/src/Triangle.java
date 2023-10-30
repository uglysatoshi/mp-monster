import java.util.Scanner;

public class Triangle {
    double a;
    double b;
    // Конструктор класса Triangle
    public Triangle() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите катет a: ");
        this.a = scan.nextDouble();
        System.out.print("Введите катет b: ");
        this.b = scan.nextDouble();
    }
    // Переопределение метода toString для получения текстового представления объекта
    @Override
    public String toString() {
        return String.format("Первый катет: %.2f\nВторой катет: %.2f\nТангенс альфа: %.2f\n\n", a, b, a/b);
    }
}
