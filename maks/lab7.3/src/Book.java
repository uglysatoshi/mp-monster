import java.util.Scanner;

public class Book {
    // Поля структуры
    String author;
    int countPages;
    String circulation;
    String yearOfPublishing;
    // Конструктор
    public Book() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите автора книги: ");
        this.author = scan.nextLine();
        System.out.print("Введите количество страниц: ");
        this.countPages = scan.nextInt();
        System.out.print("Введите тираж: ");
        this.circulation = scan.next();
        System.out.print("Введите год публикации: ");
        this.yearOfPublishing = scan.next();
        System.out.print("\n\n");
    }
    // Функция вывода
    void show() {
        System.out.printf("Автор: %s\nКоличество страниц: %d\nТираж: %s\nГод издания: %s\n\n", author, countPages, circulation, yearOfPublishing);
    }
}
