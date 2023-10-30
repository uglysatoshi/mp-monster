package Medium;
// Создаем базовый класс Plane
public class Plane {
    private final String brand; // Поле для хранения марки самолета
    private final String model; // Поле для хранения модели самолета
    private final int maxSpeed; // Поле для хранения максимальной скорости (в км/ч)
    private final int maxHeight; // Поле для хранения максимальной высоты полета (в метрах)
    // Конструктор класса Plane, принимающий марку, модель, максимальную скорость и максимальную высоту
    public Plane(String brand, String model, int maxSpeed, int maxHeight) {
        this.brand = brand;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxHeight = maxHeight;
    }
    // Метод cost() вычисляет стоимость самолета на основе заданной формулы
    public double cost() {
        return maxSpeed * 1000 + maxHeight * 100;
    }
    // Переопределенный метод toString() для вывода информации о самолете в удобочитаемом виде
    @Override
    public String toString() {
        return String.format("Марка: %s\nМодели: %s\nМаксимальная скорость: %d\nМаксимальная высота: %d\nСтоимость: %.0f\n", brand, model, maxSpeed, maxHeight, cost());
    }
}

