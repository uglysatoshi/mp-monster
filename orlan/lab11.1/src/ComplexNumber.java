public class ComplexNumber {
    private final double real;
    private final double imaginary;
    // Конструктор класса ComplexNumber
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    // Метод для умножения комплексного числа на другое комплексное число
    public ComplexNumber multiply(ComplexNumber other) {
        // Вычисляем произведение двух комплексных чисел
        double realPart = this.real * other.real - this.imaginary * other.imaginary;
        double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(realPart, imaginaryPart);
    }
    // Метод для вычисления аргумента комплексного числа в градусах
    public double argumentDegrees() {
        // Вычисляем аргумент комплексного числа в градусах
        if (this.real == 0) {
            if (this.imaginary > 0) {
                return 90.0;
            } else if (this.imaginary < 0) {
                return 270.0;
            } else {
                return 0.0;
            }
        } else {
            double angleRad = Math.atan(this.imaginary / this.real);
            double angleDeg = Math.toDegrees(angleRad);
            if (this.real > 0) {
                if (this.imaginary >= 0) {
                    return angleDeg;
                } else {
                    return angleDeg + 360.0;
                }
            } else {
                return angleDeg + 180.0;
            }
        }
    }
    // Переопределение метода toString для получения текстового представления объекта
    @Override
    public String toString() {
        ComplexNumber com = multiply(new ComplexNumber(5, 0));
        return String.format("Действительная часть: %.2f\nМнимая часть: %.2f\nКомплексное число: %.2f + %.2fi\nКомплексное число после умножения на 5: %.2f + %.2fi\nАргумент в градусах: %.2f°",
                real, imaginary, real, imaginary, com.real, com.imaginary, argumentDegrees());
    }
}