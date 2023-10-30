package Automatons.Statement;
public class Statement { // класс состояния
    private final String state; // Имя состояния
    public Statement(String str) {
        this.state = str;
    }
    public void show() {
        System.out.println("Auto state: " + state);
    }
}