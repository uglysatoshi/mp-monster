public class extendedBook extends Book{
    double discount;
    public extendedBook(String title, int pageCount, double price, double disc) {
        super(title, pageCount, price);
        this.discount = Math.abs(1 - disc / 100);
    }
    public void updPrice() {
        super.doublePriceIfProgrammingBook();
        price *= discount;
    }
    // Перегруженная функция конвертации объекта в строку
    @Override
    public String toString() {
        updPrice();
        return String.format("Название: %s\nКоличество страниц: %d\nЦена: %.2f\nЦена за страницу: %.2f\n\n", title, pageCount, price, calculateAveragePagePrice());
    }
}
