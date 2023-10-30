public class Fraction {
    double numerator;
    double denominator;
    public Fraction(int a, int b) {
        this.numerator = a;
        this.denominator = b;
    }
    public double getPercentage() {
        return (numerator / denominator) * 100;
    }
    public int getNumeratorSum() {
        int sum = 0;
        int num = (int) numerator;
        while(num > 0) {
            sum += num %10;
            num /= 10;
        }
        return sum;
    }
    @Override
    public String toString() {
        return String.format("Дробь: %.0f/%.0f\nПроцентное соотношение: %.2f\nСумма всех цифр числителя: %d\n\n", numerator, denominator, getPercentage(), getNumeratorSum());
    }
}
