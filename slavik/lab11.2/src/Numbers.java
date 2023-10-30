public class Numbers {
    // Поля класса
    double number1;
    double number2;

    // Конструктор
    public Numbers(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }
    // Нахождение полуразности
    public double calculateHalfDifference() {
        return Math.abs(number1 - number2) / 2.0;
    }
    // Перегруженная функция конвертации объекта в строку
    @Override
    public String toString() {
        return String.format("Первое число: %.2f Второе число: %.2f Полуразность: %.2f\n\n", number1, number2, calculateHalfDifference());
    }
}