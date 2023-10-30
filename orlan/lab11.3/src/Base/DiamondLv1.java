package Base;
// Создаем базовый класс DiamondLv1
public class DiamondLv1 {
    // Прописываем поля класса
    public String name;
    public double weight;
    public double quality;
    public double Q;

    // Конструктор
    public DiamondLv1(String a, double b, double c) {
        this.name = a;
        this.weight = b;
        this.quality = c;
        this.Q = (0.4 * weight) + (0.6 * quality);
    }
    // Переопределяем функцию для изменения объекта в строковый вид
    @Override
    public String toString() {
        return String.format("Название: %s\nВес(карат): %.1f\nКачество огранки(баллов): %.0f\nQ: %.2f", name, weight, quality, Q);
    }
}
