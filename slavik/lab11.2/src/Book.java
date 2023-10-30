public class Book {
    // Поля класса
    String title;
    int pageCount;
    double price;
    // Конструктор
    public Book(String title, int pageCount, double price) {
        this.title = title;
        this.pageCount = pageCount;
        this.price = price;
    }
    // Цена за страницу
    public double calculateAveragePagePrice() {
        if (pageCount > 0) {
            return price / pageCount;
        } else {
            return 0.0; // Защита от деления на ноль, если количество страниц равно 0.
        }
    }
    // Удвоение стоимости книг по программированию
    public void doublePriceIfProgrammingBook() {
        if (title != null && title.startsWith("Программирование")) {
            price *= 2;
        }
    }
    // Перегруженная функция конвертации объекта в строку
    @Override
    public String toString() {
        doublePriceIfProgrammingBook();
        return String.format("Название: %s\nКоличество страниц: %d\nЦена: %.2f\nЦена за страницу: %.2f\n\n", title, pageCount, price, calculateAveragePagePrice());
    }
}
