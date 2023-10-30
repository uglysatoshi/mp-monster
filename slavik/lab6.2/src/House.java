import java.util.Scanner;

// Реализация структуры по задания
public class House {
    String street;
    int houseNumber;
    int roomNumber;

    // Конструктор
    public House() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите улицу: ");
        this.street = scan.nextLine();
        System.out.print("Введите номер дома: ");
        this.houseNumber = scan.nextInt();
        System.out.print("Введите номер квартиры: ");
        this.roomNumber = scan.nextInt();
        System.out.print("\n");
    }
    // Вывод всех полей
    public void show() {
        System.out.printf("ул. %s, д. %d, кв. %d\n", street, houseNumber, roomNumber);
    }
}


