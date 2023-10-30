import java.util.LinkedList;

public class Main {
    public static void Base() {
        LinkedList<Triangle> list = new LinkedList<>();
        for(int i = 0; i < 10; i++) {
            list.add(new Triangle((Math.random() * 100), (Math.random() * 100)));
        }
        for(Triangle t : list) {
            System.out.print(t);
        }
    }
    public static void Medium() {
        LinkedList<Fraction> list = new LinkedList<>();
        for(int i = 0; i < 10; i++) {
            list.add(new Fraction((int) (Math.random() * 100) + 1, (int) (Math.random() * 100) + 1));
        }
        for(Fraction f : list) {
            System.out.print(f);
        }
    }
    public static void main(String[] args) {
        Base();
        Medium();
    }
}