// Класс наследник
public class Prism extends Triangle {
    // Дополнительное поле
    double height;
    // Конструктор наследника
    public Prism(double a, double b, double c) {
        // Вызов конструктора предка
        super(a, b);
        // Заполнение доп. поля
        this.height = c;
    }
    // Унаследованная функция перегрузки с дополнительными параметрами
    // в виде высоты призмы и нахождения суммы всех ребер
    @Override
    public String toString() {
        return String.format("Первый катет: %.2f \nВторой катет: %.2f \nГипотенуза: %.2f\nВысота: %.2f\nCумма всех ребер призмы: %.2f\n\n", firstKat, secondKat, getHepo(), height, (firstKat+secondKat+getHepo() * 2) + (height * 3));
    }
}
