public class Book {
    String authorName;
    String bookName;
    double price;
    int amount;
    void show() {
        System.out.printf("ФИО автора: %s\nНазвание книги: %s\nСтоимость: %.2f руб.\nКоличество экземпляров: %d\n\n",authorName,bookName, price, amount);
    }
}
