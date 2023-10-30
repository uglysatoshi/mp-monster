import java.util.Scanner;

public class Storage {
    // поля класса
    String itemType;
    int itemAmount;
    int itemPrice;
    String itemPurveyor;
    String date;

    // конструктор
    public Storage() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите наименование: "); this.itemType = in.next();
        System.out.print("Введите количество: "); this.itemAmount = in.nextInt();
        System.out.print("Введите цену: "); this.itemPrice = in.nextInt();
        System.out.print("Введите изготовителя: "); this.itemPurveyor = in.next();
        System.out.print("Введите дату: "); this.date = in.next();
        System.out.println();
    }

    // функция вывода полей класса
    void show() {
        System.out.println("Наименование: " + itemType);
        System.out.println("Количество: " + itemAmount);
        System.out.println("Цена: " + itemPrice);
        System.out.println("Изготовитель: " + itemPurveyor);
        System.out.println("Дата поставки: " + date);
        System.out.println();
    }

    // функция нахождения общей суммы
    int multiply() {
        return itemPrice * itemAmount;
    }
}
