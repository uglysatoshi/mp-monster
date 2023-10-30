package Medium;

// Создаем класс Bomber, наследуемый от класса Plane
public class Bomber extends Plane {
    // Конструктор класса Bomber вызывает конструктор базового класса Plane
    public Bomber(String brand, String model, int maxSpeed, int maxHeight) {
        super(brand, model, maxSpeed, maxHeight);
    }

    // Переопределенный метод cost() возвращает удвоенную стоимость бомбардировщика
    @Override
    public double cost() {
        return super.cost() * 2;
    }
}
