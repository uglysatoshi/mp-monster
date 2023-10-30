public class Statement { // класс состояния
    private final String name; // имя состояния
    public Statement(String str) {
        this.name = str;
    }
    void show() {
        System.out.println("Состояние автомата: " + name);
    }
}