import java.time.LocalDateTime;
import java.util.Scanner;

public class Email {
    // Поля класса
    String addressOfSender;
    String addressOfRecipient;
    LocalDateTime date;
    int size;
    // Конструктор
    public Email() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите отправителя: ");
        this.addressOfSender = scan.nextLine();
        System.out.print("Введите получателя: ");
        this.addressOfRecipient = scan.nextLine();
        System.out.print("Введите дату и время отправки(ГГГГ ММ ДД ЧЧ ММ): ");
        this.date = LocalDateTime.of(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
        System.out.print("Введите размер сообщения: ");
        this.size = scan.nextInt();
    }
    // Функция вывода полей
    void show() {
        System.out.printf("E-mail отправителя: %s\nE-mail получателя: %s\nДата и время отправки: %s\nРазмер сообщения: %dКб\n\n", addressOfSender, addressOfRecipient, date, size);
    }
}
