// Класс из лабораторной 11.1 (Средний уровень)
public class Fraction {
    // Поля класса
    double numerator;
    double denominator;
    // Конструктор с параметрами
    public Fraction(int a, int b) {
        this.numerator = a;
        this.denominator = b;
    }
    // Функция нахождения процентного соотношения
    public double getPercentage() {
        return (numerator / denominator) * 100;
    }
    // Функция нахождения суммы всех цифр числителя
    public int getNumeratorSum() {
        int sum = 0;
        int num = (int) numerator;
        while(num > 0) {
            sum += num %10;
            num /= 10;
        }
        return sum;
    }
    // Перегруженная функция форматирования структуры в строку
    @Override
    public String toString() {
        return String.format("Дробь: %.0f/%.0f\nПроцентное соотношение: %.2f\nСумма всех цифр числителя: %d\n\n", numerator, denominator, getPercentage(), getNumeratorSum());
    }
}
