public class ComplexImpedance extends ComplexNumber {
    // Конструктор класса ComplexImpedance
    public ComplexImpedance(double resistance, double inductance) {
        // Вызываем конструктор класса предка (ComplexNumber)
        super(resistance, inductance);
    }
    public double magnitude() {
        // Вычисляем модуль комплексной проводимости (комплексного импеданса)
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
    }
    public double admittanceArgumentDegrees() {
        // Вычисляем аргумент комплексной проводимости (комплексного импеданса) в градусах
        if (real == 0) {
            if (imaginary > 0) {
                return 90.0;
            } else if (imaginary < 0) {
                return -90.0;
            } else {
                return 0.0;
            }
        } else {
            double angleRad = Math.atan(imaginary / real);
            return Math.toDegrees(angleRad);
        }
    }
    // Переопределение метода toString для получения текстового представления объекта
    @Override
    public String toString() {
        return String.format("Комплексное число: %.2f + %.2fi\nАргумент комплексной проводимости: %.2f°\nМодуль комплексной проводимости: %.2f\n\n",
                real, imaginary, admittanceArgumentDegrees(), magnitude());
    }
}