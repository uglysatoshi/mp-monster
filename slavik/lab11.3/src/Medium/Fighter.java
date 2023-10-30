package Medium;

// Создаем класс Fighter, также наследуемый от класса Plane
public class Fighter extends Plane {
    // Конструктор класса Fighter вызывает конструктор базового класса Plane
    public Fighter(String brand, String model, int maxSpeed, int maxHeight) {
        super(brand, model, maxSpeed, maxHeight);
    }
    // Переопределенный метод cost() возвращает утроенную стоимость истребителя
    @Override
    public double cost() {
        return super.cost() * 3;
    }
}