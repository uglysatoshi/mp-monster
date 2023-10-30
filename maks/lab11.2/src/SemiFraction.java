// Класс наследник
public class SemiFraction extends Fraction{
    // Функция нахождения целой части дроби
    public int getIntegerPart() {
        return (int) (numerator / denominator);
    }
    // Функция нахождения остатка от деления
    public int getNewNumerator() {
        return (int) (numerator % denominator);
    }
    // Конструктор наследника
    public SemiFraction(int a, int b) {
        // Вызов конструктора предка
        super(a, b);
    }
    // Унаследованная функция перегрузки с дополнительными параметрами
    // в виде вывода смешанной дроби и дроби в вещественном виде
    @Override
    public String toString() {
        return String.format("Правильная дробь: %.0f/%.0f\nСмешанная дробь: %d(%d/%.0f)\nДробь в виде вещественного числа: %.2f\nПроцентное соотношение: %.2f\nСумма всех цифр числителя: %d\n\n", numerator, denominator,getIntegerPart(), getNewNumerator(), denominator, numerator / denominator,  getPercentage(), getNumeratorSum());
    }
}
