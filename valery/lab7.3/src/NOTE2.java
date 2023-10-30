import java.time.LocalDate;
import java.util.Scanner;

public class NOTE2 {
    // поля класса
    String name;
    String phone;
    LocalDate date;

    // конструктор класса
    public NOTE2() {
       Scanner in = new Scanner(System.in);
       System.out.print("Введите фамилию и имя: "); this.name = in.nextLine();
       System.out.print("Введите номер телефона: "); this.phone = in.next();
       in.nextLine();
       System.out.print("Введите дату(гггг.мм.дд): "); this.date = LocalDate.parse(in.nextLine());
       System.out.println();
    }

    // функция вывода полей
    void show() {
        System.out.println("ФИ: " + name);
        System.out.println("Номер телефона: " + phone);
        System.out.println("Дата: " + date.toString());
        System.out.println();
    }

    // функция вывода первых 3х цифр номера
    int phoneNumber() {
       String str = phone.substring(0,3);
       return Integer.parseInt(str);
    }


}
