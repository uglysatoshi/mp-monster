public class extendedNumbers extends Numbers{
    double c;
    public extendedNumbers(double number1, double number2, double C) {
        super(number1, number2);
        this.c = C;
    }
    public double halfMultiply() {
        return super.calculateHalfDifference() * c;
    }
    @Override
    public String toString() {
        return String.format("Первое число: %.2f\nВторое число: %.2f\nТретье число: %.2f\nПолуразность: %.2f\nПроизведение полуразности: %.2f\n\n", number1, number2, c, calculateHalfDifference(), halfMultiply());
    }
}
