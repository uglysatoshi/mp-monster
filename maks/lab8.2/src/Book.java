public class Book {
    // Поля структуры
    String author;
    String nameOfBook;
    String circulation;
    String price;
    String yearOfPublish;
    // Функция вывода
    void show() {
        System.out.printf("Автор: %s\nНазвание книги: %s\nТираж: %s\nЦена: %s\nГод издания: %s\n\n", author, nameOfBook, circulation, price, yearOfPublish);
    }
}
