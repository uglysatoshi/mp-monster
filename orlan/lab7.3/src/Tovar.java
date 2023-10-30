import java.time.LocalDate;
import java.util.Scanner;

public class Tovar {
    // Поля структуры
    String name;
    int count;
    int price;
    LocalDate date;
    // Конструктор
    public Tovar() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите название товара: ");
        this.name = scan.nextLine();
        System.out.print("Введите количество товара: ");
        this.count = scan.nextInt();
        System.out.print("Введите стоимость товара: ");
        this.price = scan.nextInt();
        System.out.print("Введите дату поступления(ГГГГ мм ДД): ");
        this.date = LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt());
        System.out.print("\n");
    }
    // Конструктор
    void show() {
        System.out.printf("Наименование: %s\nКоличество: %d\nЦена: %d$\nДата поступления: %s\nСредняя стоимость: %.2f\n\n", name, count, price, date, (double) price / count);
    }
}
